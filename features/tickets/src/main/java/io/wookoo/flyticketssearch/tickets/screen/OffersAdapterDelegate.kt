package io.wookoo.flyticketssearch.tickets.screen

import android.annotation.SuppressLint
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.tickets.databinding.ListItemBinding

data class UiOffer(
    val id: Long,
    val title: String,
    val town: String,
    val price: Int
)

@SuppressLint("SetTextI18n")
internal fun offersAdapterDelegate(itemClickedListener: (UiOffer) -> Unit) =
    adapterDelegateViewBinding<UiOffer, Any, ListItemBinding>(
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
