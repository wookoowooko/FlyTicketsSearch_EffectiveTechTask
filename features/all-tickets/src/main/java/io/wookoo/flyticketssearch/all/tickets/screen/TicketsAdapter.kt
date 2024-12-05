package io.wookoo.flyticketssearch.all.tickets.screen

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.all.tickets.databinding.TicketInfoItemBinding
import io.wookoo.flyticketssearch.all.tickets.ui.UiTicket

private val diffCallback = object : DiffUtil.ItemCallback<UiTicket>() {
    override fun areItemsTheSame(oldItem: UiTicket, newItem: UiTicket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiTicket, newItem: UiTicket): Boolean {
        return oldItem == newItem
    }
}

class TicketsAdapter(
    itemClickedListener: (UiTicket) -> Unit
) : AsyncListDifferDelegationAdapter<UiTicket>(
    diffCallback
) {

    init {
        delegatesManager.addDelegate(offersAdapterDelegate(itemClickedListener))
    }

    private fun offersAdapterDelegate(itemClickedListener: (UiTicket) -> Unit) =
        adapterDelegateViewBinding<UiTicket, UiTicket, TicketInfoItemBinding>(
            { layoutInflater, root ->
                TicketInfoItemBinding.inflate(
                    layoutInflater,
                    root,
                    false
                )
            }
        ) {
            binding.root.setOnClickListener {
                itemClickedListener(item)
            }

            bind {
                binding.apply {
                    if (item.badge.isNullOrEmpty()) {
                        badge.visibility = View.GONE
                    } else {
                        badge.visibility = View.VISIBLE
                        badgeText.text = item.badge
                    }
                    if (item.hasTransfer) {
                        hasTransfer.visibility = View.VISIBLE
                    } else {
                        hasTransfer.visibility = View.GONE
                    }
                    price.text = item.price
                    airportArrival.text = item.arrivalAirport
                    airportDeparture.text = item.departureAirport
                    dateArrival.text = item.arrivalTime
                    dateDeparture.text = item.departureTime
                    timeToFly.text = item.timeToFly
                }
            }
        }
}
