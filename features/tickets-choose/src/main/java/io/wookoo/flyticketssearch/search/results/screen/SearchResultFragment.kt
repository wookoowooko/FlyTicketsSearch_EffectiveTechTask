package io.wookoo.flyticketssearch.search.results.screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.wookoo.flyticketssearch.data.navigation.INavigationCallback
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import io.wookoo.flyticketssearch.search.results.databinding.FragmentSearchResultBinding
import io.wookoo.flyticketssearch.search.results.viewnodel.SearchResultViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchResultFragment : Fragment() {

    private lateinit var navigationCallback: INavigationCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigationCallback) {
            navigationCallback = context
        }
    }

    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val ticketsViewModel: SearchResultViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchQueryFrom = arguments?.getString("searchQueryFrom")
        val searchQueryWhere = arguments?.getString("searchQueryWhere")

        ticketsViewModel.updateTextFrom(searchQueryFrom.orEmpty())
        ticketsViewModel.updateTextWhere(searchQueryWhere.orEmpty())

        lifecycleScope.launch {
            ticketsViewModel.textFrom.collect { textFrom ->
                binding.editTextFromSearch.setText(textFrom)
            }
        }

        lifecycleScope.launch {
            ticketsViewModel.textWhere.collect { textWhere ->
                binding.editTextWhereSearch.setText(textWhere)
            }
        }

        binding.apply {
            changeTextViews.setOnClickListener {
                ticketsViewModel.changeValues()
            }

            backClick.setOnClickListener {
                navigationCallback.goBack()
            }

            clearWhere.setOnClickListener {
                ticketsViewModel.clearTextWhere()
            }
        }

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
