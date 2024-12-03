package io.wookoo.flyticketssearch.tickets.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import io.wookoo.flyticketssearch.tickets.databinding.FragmentTicketsBinding
import io.wookoo.flyticketssearch.tickets.viewmodel.TicketsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding

    private val ticketsAdapter = OffersAdapter(
        itemClickedListener = {}
    )

    private val ticketsViewModel: TicketsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        lifecycleScope.launch {
            ticketsViewModel.uiOffer.collect { offers ->
                logger.info("API", "observedOffers=> $offers")
                ticketsAdapter.items = offers
            }
        }

        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val root: View = binding?.root ?: error("Binding is null")

        binding?.apply {
            ticketRecycler.apply {
                adapter = ticketsAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

