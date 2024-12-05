package io.wookoo.flyticketssearch.search.results.screen

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.search.results.databinding.TicketOfferItemBinding
import io.wookoo.flyticketssearch.search.results.ui.UiTicketOffer

private val diffCallback = object : DiffUtil.ItemCallback<UiTicketOffer>() {
    override fun areItemsTheSame(oldItem: UiTicketOffer, newItem: UiTicketOffer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiTicketOffer, newItem: UiTicketOffer): Boolean {
        return oldItem == newItem
    }
}

class TicketsOffersAdapter(
    itemClickedListener: (UiTicketOffer) -> Unit
) : AsyncListDifferDelegationAdapter<UiTicketOffer>(
    diffCallback
) {

    init {
        delegatesManager.addDelegate(offersAdapterDelegate(itemClickedListener))
    }

    private fun offersAdapterDelegate(itemClickedListener: (UiTicketOffer) -> Unit) =
        adapterDelegateViewBinding<UiTicketOffer, UiTicketOffer, TicketOfferItemBinding>(
            { layoutInflater, root ->
                TicketOfferItemBinding.inflate(
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
                    companyName.text = item.title
                    departureTimes.text = item.timeRange
                    price.text = item.price
                    ticketOfferImage.setImageResource(
                        getIconResourceByPosition(bindingAdapterPosition)
                    )
                }
            }
        }

    private fun getIconResourceByPosition(position: Int): Int {
        return when (position) {
            0 -> io.wookoo.tickets.shared.R.drawable.special_orange_placeholder
            1 -> io.wookoo.tickets.shared.R.drawable.special_blue_placeholder
            2 -> io.wookoo.tickets.shared.R.drawable.special_white_placeholder
            else -> io.wookoo.tickets.shared.R.drawable.special_white_placeholder
        }
    }
}
