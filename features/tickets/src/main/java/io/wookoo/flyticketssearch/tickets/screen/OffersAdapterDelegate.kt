package io.wookoo.flyticketssearch.tickets.screen

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.tickets.databinding.ListItemBinding
import io.wookoo.flyticketssearch.tickets.ui.UiOffer


private val diffCallback = object : DiffUtil.ItemCallback<UiOffer>() {
    override fun areItemsTheSame(oldItem: UiOffer, newItem: UiOffer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiOffer, newItem: UiOffer): Boolean {
        return oldItem == newItem
    }
}

class OffersAdapter(
    itemClickedListener: (UiOffer) -> Unit
) : AsyncListDifferDelegationAdapter<UiOffer>(diffCallback) {

    init {
        delegatesManager.addDelegate(offersAdapterDelegate(itemClickedListener))
    }

    @SuppressLint("SetTextI18n")
    private fun offersAdapterDelegate(itemClickedListener: (UiOffer) -> Unit) =
        adapterDelegateViewBinding<UiOffer, UiOffer, ListItemBinding>(
            { layoutInflater, root -> ListItemBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                itemClickedListener(item)
            }

            bind {
                binding.apply {
                    title.text = item.title
                    town.text = item.town
                    price.text = item.price.toString()
                }
            }
        }
}
