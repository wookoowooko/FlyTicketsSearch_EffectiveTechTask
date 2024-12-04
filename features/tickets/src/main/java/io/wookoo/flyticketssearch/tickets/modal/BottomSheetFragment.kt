package io.wookoo.flyticketssearch.tickets.modal

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import io.wookoo.flyticketssearch.tickets.databinding.FragmentBottomSheetBinding

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null


    private val binding: FragmentBottomSheetBinding
        get() = checkNotNull(_binding)

    override fun onStart() {
        super.onStart()
        val bottomSheetDialog = dialog as? BottomSheetDialog
        bottomSheetDialog?.behavior?.apply {
//
            val rectangle = Rect()
            val window: Window = requireActivity().window
            window.decorView.getWindowVisibleDisplayFrame(rectangle)
            val statusBarHeight = rectangle.top * 2

            peekHeight = resources.displayMetrics.heightPixels - statusBarHeight

            state = BottomSheetBehavior.STATE_COLLAPSED

//            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        val args = arguments?.getString("flag")
        logger.info("bundle", "$args")

        when(args){
            "from" -> binding.editTextFromModal.requestFocus()
            "where" -> binding.editTextWhereModal.requestFocus()
        }

//        binding.closeButton.setOnClickListener {
//            dismiss()
//        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
