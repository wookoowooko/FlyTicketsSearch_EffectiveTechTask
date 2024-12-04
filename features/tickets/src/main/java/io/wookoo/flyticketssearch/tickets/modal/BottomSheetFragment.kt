package io.wookoo.flyticketssearch.tickets.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.wookoo.flyticketssearch.tickets.R
import io.wookoo.flyticketssearch.tickets.databinding.FragmentBottomSheetBinding
import io.wookoo.flyticketssearch.tickets.ui.UiDepartures
import io.wookoo.flyticketssearch.tickets.ui.inputFilter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding: FragmentBottomSheetBinding
        get() = checkNotNull(_binding)

    private val bottomSheetViewModel by viewModel<ModalBottomSheetViewModel>()

    override fun onStart() {
        super.onStart()
//        configModal()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        binding.apply {
            val args = arguments?.getString("flag")
            when (args) {
                "from" -> editTextFromModal.requestFocus()
                "where" -> editTextWhereModal.requestFocus()
            }

            lifecycleScope.launch {
                bottomSheetViewModel.whereEditText.collect { lastEditedValue ->
                    // check difference between last edited value and current value
                    if (editTextFromModal.text.toString() != lastEditedValue) {
                        editTextFromModal.setText(lastEditedValue)
                        editTextFromModal.setSelection(lastEditedValue.length)
                    }


                }
            }

            val listOfDepartures = listOf(
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.istanbul, R.string.stambul
                ),
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.sochi, R.string.sochi_text
                ),
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.phuket, R.string.phuket
                )
            )

            val departuresAdapter = ListDelegationAdapter(
                departuresAdapter {
                    editTextWhereModal.setText(it.town)
                    editTextWhereModal.setSelection(editTextWhereModal.text.length)
                }
            ).apply {
                items = listOfDepartures
            }
            depRec.apply {
                adapter = departuresAdapter
            }

            everywhere.setOnClickListener{
                editTextWhereModal.setText(R.string.everywhere)
                editTextWhereModal.setSelection(editTextWhereModal.text.length)
            }

            editTextFromModal.filters = arrayOf(inputFilter)
            editTextWhereModal.filters = arrayOf(inputFilter)

            editTextFromModal.addTextChangedListener { editable ->
                bottomSheetViewModel.setEditText(editable.toString())
            }

            closeWhere.setOnClickListener {
                editTextWhereModal.text.clear()
            }
        }

        return binding.root
    }

//    private fun configModal() {
//        val bottomSheetDialog = dialog as? BottomSheetDialog
//        bottomSheetDialog?.behavior?.apply {
//            val rectangle = Rect()
//            val window: Window = requireActivity().window
//            window.decorView.getWindowVisibleDisplayFrame(rectangle)
//            val statusBarHeight = rectangle.top * 2
//            peekHeight = resources.displayMetrics.heightPixels - statusBarHeight
//            state = BottomSheetBehavior.STATE_COLLAPSED
////                state = BottomSheetBehavior.STATE_EXPANDED
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
