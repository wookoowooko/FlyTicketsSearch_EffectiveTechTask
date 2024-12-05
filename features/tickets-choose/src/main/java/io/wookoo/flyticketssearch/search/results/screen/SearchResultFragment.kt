package io.wookoo.flyticketssearch.search.results.screen

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.wookoo.flyticketssearch.data.navigation.INavigationCallback
import io.wookoo.flyticketssearch.search.results.R
import io.wookoo.flyticketssearch.search.results.databinding.FragmentSearchResultBinding
import io.wookoo.flyticketssearch.search.results.viewnodel.SearchResultViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar

class SearchResultFragment : Fragment() {

    private lateinit var navigationCallback: INavigationCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigationCallback) {
            navigationCallback = context
        }
    }

    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val searchResultViewModel: SearchResultViewModel by viewModel()
    private val ticketsOffersAdapter = TicketsOffersAdapter(itemClickedListener = {})

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchQueryFrom = arguments?.getString("searchQueryFrom")
        val searchQueryWhere = arguments?.getString("searchQueryWhere")

        searchResultViewModel.updateTextFrom(searchQueryFrom.orEmpty())
        searchResultViewModel.updateTextWhere(searchQueryWhere.orEmpty())

        lifecycleScope.launch {
            searchResultViewModel.textFrom.collect { textFrom ->
                binding.editTextFromSearch.setText(textFrom)
            }
        }

        lifecycleScope.launch {
            searchResultViewModel.textWhere.collect { textWhere ->
                binding.editTextWhereSearch.setText(textWhere)
            }
        }

        lifecycleScope.launch {
            searchResultViewModel.dateDepartureOutbound.collect { dateDepartureOutbound ->
                binding.dateDeparture.text = dateDepartureOutbound
            }
        }
        lifecycleScope.launch {
            searchResultViewModel.dateReturn.collect { dateReturn ->
                if (dateReturn.isNotEmpty()) {
                    binding.dateReturn.text = dateReturn
                    binding.dateReturn.setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null,
                        null,
                        null
                    )
                } else {
                    binding.dateReturn.text = getString(R.string.back)
                    val drawable = ContextCompat.getDrawable(
                        requireContext(),
                        io.wookoo.tickets.shared.R.drawable.ic_add
                    )
                    binding.dateReturn.setCompoundDrawablesWithIntrinsicBounds(
                        drawable,
                        null,
                        null,
                        null
                    )
                }
            }
        }
        lifecycleScope.launch {
            searchResultViewModel.uiTicketsOffers.collect { uiTicketsOffers ->
                ticketsOffersAdapter.items = uiTicketsOffers
            }
        }

        binding.apply {
            changeTextViews.setOnClickListener {
                searchResultViewModel.changeValues()
            }

            backClick.setOnClickListener {
                navigationCallback.goBack()
            }

            clearWhere.setOnClickListener {
                searchResultViewModel.clearTextWhere()
            }
            cardWhereDate.setOnClickListener {
                showDatePickerDialog(Position.OUTBOUND)
            }
            cardBackDate.setOnClickListener {
                showDatePickerDialog(Position.RETURN)
            }
            ticketOfferRecycler.adapter = ticketsOffersAdapter
        }

        return root
    }

    private fun showDatePickerDialog(position: Position) {
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                when (position) {
                    Position.OUTBOUND -> {
                        searchResultViewModel.formatDateOutbound(calendar.time)
                    }

                    Position.RETURN -> {
                        searchResultViewModel.formatDateReturn(calendar.time)
                    }
                }
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private enum class Position {
        OUTBOUND,
        RETURN
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
