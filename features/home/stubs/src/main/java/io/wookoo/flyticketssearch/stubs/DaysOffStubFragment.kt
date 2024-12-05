package io.wookoo.flyticketssearch.stubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.wookoo.flyticketssearch.stubs.databinding.FragmentDayOffStubBinding

class DaysOffStubFragment : Fragment() {

    private var _binding: FragmentDayOffStubBinding? = null
    private val binding: FragmentDayOffStubBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayOffStubBinding.inflate(inflater, container, false)
        binding
            .backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        return binding.root
    }
}
