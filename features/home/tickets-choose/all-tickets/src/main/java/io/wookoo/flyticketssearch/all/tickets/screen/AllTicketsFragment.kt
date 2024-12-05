package io.wookoo.flyticketssearch.all.tickets.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import io.wookoo.flyticketssearch.all.tickets.databinding.FragmentAllTicketsBinding
import io.wookoo.flyticketssearch.all.tickets.viewmodel.AllTicketsViewModel
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val ARG_FROM = "from"
private const val ARG_WHERE = "where"
private const val ARG_DATE_OUTBOUND = "dateOutbound"

class AllTicketsFragment : Fragment() {

    private var paramFrom: String? = null
    private var paramWhere: String? = null
    private var paramDateOutbound: String? = null

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val allTicketsViewModel: AllTicketsViewModel by viewModel()
    private val ticketsAdapter = TicketsAdapter(itemClickedListener = {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramFrom = it.getString(ARG_FROM)
            paramWhere = it.getString(ARG_WHERE)
            paramDateOutbound = it.getString(ARG_DATE_OUTBOUND) ?: SimpleDateFormat(
                "d MMMM",
                Locale.getDefault()
            ).format(Date())

            logger.info("alltickets", "$paramFrom $paramWhere $paramDateOutbound")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllTicketsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        lifecycleScope.launch {
            allTicketsViewModel.uiTickets.collect { uiTicketsOffers ->
                ticketsAdapter.items = uiTicketsOffers
            }
        }

        binding.apply {
            ticketsRecycler.adapter = ticketsAdapter
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
            fromText.text = paramFrom
            whereText.text = paramWhere
            dateDeparture.text = paramDateOutbound
        }

        return root
    }
}
