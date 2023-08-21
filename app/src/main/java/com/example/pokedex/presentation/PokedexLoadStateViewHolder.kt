package com.example.pokedex.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.PokedexLoadStateFooterBinding
import com.example.pokedex.util.hideView
import com.example.pokedex.util.showView

class PokedexLoadStateViewHolder(
    private val binding: PokedexLoadStateFooterBinding,
    tryAgain: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.loadStateTryAgainButton.setOnClickListener { tryAgain.invoke() }
    }

    fun bind(loadState: LoadState) {
        when(loadState) {
            is LoadState.Loading -> {
                binding.loadStateProgressBar.showView()
//                binding.loadStateErrorMessage.hideView()
                binding.loadStateTryAgainButton.hideView()
            }
            is LoadState.Error -> {
//                binding.loadStateErrorMessage.showView()
                binding.loadStateTryAgainButton.showView()
                binding.loadStateProgressBar.hideView()
            }
            is LoadState.NotLoading -> {
                // Do nothing
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, tryAgain: () -> Unit) : PokedexLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.pokedex_load_state_footer, parent, false)
            val binding = PokedexLoadStateFooterBinding.bind(view)
            return PokedexLoadStateViewHolder((binding), tryAgain)
        }
    }
}