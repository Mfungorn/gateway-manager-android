package org.fungorn.gatewayapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import org.fungorn.gatewayapp.common.StatefulFragment
import org.fungorn.gatewayapp.databinding.FragmentMainBinding
import org.fungorn.gatewayapp.util.ext.observeNonNull
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : StatefulFragment<MainViewState>() {
    private val mainViewModel: MainViewModel by viewModel()

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.mainState.observeNonNull(viewLifecycleOwner) {
            render(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun render(state: MainViewState) {
        binding.progress.isVisible = state.isLoading
        binding.message.text = state.text

        if (state.error != null) {
            Toast.makeText(context, state.error.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
