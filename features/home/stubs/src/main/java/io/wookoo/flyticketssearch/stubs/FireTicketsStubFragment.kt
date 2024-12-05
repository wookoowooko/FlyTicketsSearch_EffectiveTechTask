package io.wookoo.flyticketssearch.stubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FireTicketsStubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fire_tickets_stub, container, false)

        val backButton: AppCompatImageButton = view.findViewById(R.id.back_button)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}
