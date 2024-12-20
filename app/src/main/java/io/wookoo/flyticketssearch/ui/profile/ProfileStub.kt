package io.wookoo.flyticketssearch.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wookoo.flyticketssearch.databinding.FragmentProfileBinding

class ProfileStub : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding?.root ?: error("Binding is null")
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
