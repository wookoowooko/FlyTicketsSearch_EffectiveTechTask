package io.wookoo.flyticketssearch.tickets.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.wookoo.flyticketssearch.tickets.databinding.FragmentHomeBinding
import io.wookoo.flyticketssearch.tickets.modal.BottomSheetFragment
import io.wookoo.flyticketssearch.tickets.viewmodel.TicketsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val ticketsViewModel: TicketsViewModel by viewModel()
    private val ticketsAdapter = OffersAdapter(itemClickedListener = {})

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        lifecycleScope.launch {
            launch {
                ticketsViewModel.uiOffer.collect { offers ->
                    ticketsAdapter.items = offers
                }
            }
            launch {
                ticketsViewModel.textFrom.collect { textFrom ->
                    binding.editTextFrom.setText(textFrom.lastUserInput)
                }
            }
        }

        binding.apply {
            ticketRecycler.apply {
                adapter = ticketsAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            }

            editTextWhere.setOnClickListener { showBottomSheet(FLAG_WHERE) }
            editTextFrom.setOnClickListener { showBottomSheet(FLAG_FROM) }
        }
        return root
    }

    private fun showBottomSheet(flag: String) {
        BottomSheetFragment().apply {
            arguments = Bundle().apply { putString(ARG, flag) }
        }.also {
            it.show(parentFragmentManager, it.tag)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val FLAG_WHERE = "where"
        private const val FLAG_FROM = "from"
        private const val ARG = "flag"
    }
}
