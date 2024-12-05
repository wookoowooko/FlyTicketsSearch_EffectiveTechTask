package io.wookoo.flyticketssearch.stubs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import io.wookoo.flyticketssearch.data.navigation.INavigationCallback

class HardWayStubFragment : Fragment() {

    private lateinit var navigationCallback: INavigationCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigationCallback) {
            navigationCallback = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hard_way_stub, container, false)

        val backButton: AppCompatImageButton = view.findViewById(R.id.back_button)

        backButton.setOnClickListener {
            navigationCallback.goBack()
        }

        return view
    }
}
