package io.wookoo.flyticketssearch.search.results

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wookoo.flyticketssearch.data.navigation.INavigationCallback
import io.wookoo.flyticketssearch.search.results.databinding.FragmentSearchResultBinding


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
//
//        private val ticketsViewModel: TicketsViewModel by viewModel()
//        private val ticketsAdapter = OffersAdapter(itemClickedListener = {})

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

//            lifecycleScope.launch {
//                launch {
//                    ticketsViewModel.uiOffer.collect { offers ->
//                        ticketsAdapter.items = offers
//                    }
//                }
//                launch {
//                    ticketsViewModel.textFrom.collect { textFrom ->
//                        binding.editTextFrom.setText(textFrom.lastUserInput)
//                    }
//                }
//            }

        binding.apply {
//                ticketRecycler.apply {
//                    adapter = ticketsAdapter
//                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//                }
//
//                editTextWhere.setOnClickListener { showBottomSheet("where") }
//                editTextFrom.setOnClickListener { showBottomSheet("from") }
        }
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
