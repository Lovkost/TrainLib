package com.example.trainlib.presentation.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.databinding.ViewUserRepositoryBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class GitHubRepositoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val viewBinding: ViewUserRepositoryBinding by viewBinding()

    fun bind(model: GitHubRepository) {
        with(viewBinding) {
            userRepository.text = model.name
        }
    }

}