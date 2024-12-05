package io.wookoo.flyticketssearch.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wookoo.flyticketssearch.databinding.FragmentMoreBinding
import io.wookoo.flyticketssearch.databinding.FragmentNotificationsBinding

class MoreStub : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        val root: View = binding?.root ?: error("Binding is null")
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
