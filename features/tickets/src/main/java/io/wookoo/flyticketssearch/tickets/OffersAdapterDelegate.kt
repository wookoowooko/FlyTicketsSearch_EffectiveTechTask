package io.wookoo.flyticketssearch.tickets

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.tickets.databinding.ListItemBinding

private interface DisplayableItem

internal data class Offers(
    val id: Long,
    val title: String,
    val town: String,
    val price: String
) : DisplayableItem

internal fun offersAdapterDelegate(itemClickedListener: (Offers) -> Unit) =
    adapterDelegateViewBinding<Offers, Offers, ListItemBinding>(
        { layoutInflater, root -> ListItemBinding.inflate(layoutInflater, root, false) }
    ) {

        binding.root.setOnClickListener {
            itemClickedListener(item)
        }

        bind {
            binding.apply {
                title.text = item.title
                town.text = item.town
                price.text = item.price
            }
        }
    }