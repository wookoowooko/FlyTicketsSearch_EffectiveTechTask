package io.wookoo.flyticketssearch.tickets.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.wookoo.flyticketssearch.tickets.databinding.FragmentTicketsBinding
import io.wookoo.flyticketssearch.tickets.viewmodel.TicketsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding

    private val ticketsAdapter = ListDelegationAdapter(
        offersAdapterDelegate {}
    )

    private val ticketsViewModel: TicketsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val root: View = binding?.root ?: error("Binding is null")


        ticketsViewModel.uiOffer.observe(viewLifecycleOwner) { offers ->
            ticketsAdapter.items = offers
        }

        binding?.apply {
            ticketRecycler.apply {
                adapter = ticketsAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            }
        }

        ticketsViewModel.loadOffers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

