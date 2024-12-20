package io.wookoo.flyticketssearch.tickets.modal

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.wookoo.flyticketssearch.tickets.R
import io.wookoo.flyticketssearch.tickets.databinding.FragmentBottomSheetBinding
import io.wookoo.flyticketssearch.tickets.ui.UiDepartures
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding: FragmentBottomSheetBinding
        get() = checkNotNull(_binding)

    private val bottomSheetViewModel by viewModel<ModalBottomSheetViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val modalBottomSheet = this
        val modalBottomSheetBehavior = (modalBottomSheet.dialog as BottomSheetDialog).behavior
        modalBottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL
        modalBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        binding.apply {
            val args = arguments?.getString(FLAG_KEY)
            when (args) {
                FROM_KEY -> editTextFromModal.requestFocus()
                WHERE_KEY -> editTextWhereModal.requestFocus()
            }

            lifecycleScope.launch {
                bottomSheetViewModel.fromEditText.collect { lastEditedValue ->
                    // check difference between last edited value and current value
                    if (editTextFromModal.text.toString() != lastEditedValue) {
                        editTextFromModal.setText(lastEditedValue)
                        editTextFromModal.setSelection(lastEditedValue.length)
                    }
                }
            }

            val listOfDepartures = listOf(
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.istanbul,
                    R.string.stambul
                ),
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.sochi,
                    R.string.sochi_text
                ),
                UiDepartures(
                    io.wookoo.tickets.shared.R.drawable.phuket,
                    R.string.phuket
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
            depRec.adapter = departuresAdapter

            everywhere.setOnClickListener {
                editTextWhereModal.setText(R.string.everywhere)
                editTextWhereModal.setSelection(editTextWhereModal.text.length)
            }

            setCardClickListener(hardWay) {
                findNavController().navigate(R.id.actionNavigateToHardWayStubFragment)
            }

            setCardClickListener(daysOffCard) {
                findNavController().navigate(R.id.actionNavigateToDaysOffStubFragment)
            }

            setCardClickListener(fireTicketsCard) {
                findNavController().navigate(R.id.actionNavigateToFireTicketsStubFragment)
            }

            editTextFromModal.filters = arrayOf(inputFilter())
            editTextWhereModal.filters = arrayOf(inputFilter())

            editTextFromModal.addTextChangedListener { editable ->
                bottomSheetViewModel.setFromEditText(editable.toString())
            }

            editTextWhereModal.addTextChangedListener { editable ->
                val inputText = editable.toString()
                if (inputText.isNotEmpty()) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        delay(1000)
                        if (editable.toString() == inputText) {
                            onDismiss(checkNotNull(dialog))

                            val bundle = Bundle().apply {
                                putString(SEARCH_QUERY_WHERE, inputText)
                                putString(SEARCH_QUERY_FROM, editTextFromModal.text.toString())
                            }
                            findNavController().navigate(
                                R.id.actionToTicketsSearchResultNavigation,
                                bundle
                            )
                        }
                    }
                }
            }

            closeWhere.setOnClickListener {
                editTextWhereModal.text.clear()
            }
        }

        return binding.root
    }

    private fun setCardClickListener(card: View, navigateAction: () -> Unit) {
        card.setOnClickListener {
            onDismiss(checkNotNull(dialog))
            navigateAction()
        }
    }

    private fun inputFilter(): InputFilter {
        val inputFilter = InputFilter { source, _, _, _, _, _ ->
            val filtered = source.filter { it in 'А'..'я' || it == ' ' }
            return@InputFilter filtered.ifEmpty { "" }
        }
        return inputFilter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val FLAG_KEY = "flag"
        private const val FROM_KEY = "from"
        private const val WHERE_KEY = "where"
        private const val SEARCH_QUERY_FROM = "searchQueryFrom"
        private const val SEARCH_QUERY_WHERE = "searchQueryWhere"
    }
}
