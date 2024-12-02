package io.wookoo.flyticketssearch.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.wookoo.flyticketssearch.tickets.databinding.FragmentTicketsBinding




class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding

    private val ticketsAdapter = ListDelegationAdapter(
        offersAdapterDelegate { offer ->
            println("Clicked on: ${offer.title}")
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ticketsViewModel =
            ViewModelProvider(this)[TicketsViewModel::class.java]

        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val root: View = binding?.root ?: error("Binding is null")

        binding?.apply {

////        val textView: TextView? = binding?.textHome
//        ticketsViewModel.text.observe(viewLifecycleOwner) {
//            textView?.text = it
//        }

            ticketRecycler.apply {
                adapter = ticketsAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                itemAnimator = DefaultItemAnimator()
            }

            val offers = listOf(
                Offers(1, "Flight to Paris", "Paris", "22 264 ₽"),
                Offers(2, "Flight to London", "London", "18 000 ₽"),
                Offers(3, "Flight to New York", "New York", "35 000 ₽")
            )
            ticketsAdapter.items = offers
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
