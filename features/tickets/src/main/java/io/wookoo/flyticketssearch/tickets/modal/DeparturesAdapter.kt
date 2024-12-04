package io.wookoo.flyticketssearch.tickets.modal

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.wookoo.flyticketssearch.tickets.databinding.DeparturesItemBinding
import io.wookoo.flyticketssearch.tickets.ui.UiDepartures


fun departuresAdapter(itemClickedListener: (UiDepartures) -> Unit) =
    adapterDelegateViewBinding<UiDepartures, UiDepartures, DeparturesItemBinding>(
        { layoutInflater, root -> DeparturesItemBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener {
            itemClickedListener(item)
        }

        bind {
            binding.apply {
                town.setText(item.town)
                depImage.setImageResource(item.image)
            }
        }
    }