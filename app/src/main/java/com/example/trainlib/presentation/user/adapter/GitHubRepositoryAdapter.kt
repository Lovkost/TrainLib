package com.example.trainlib.presentation.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.R.layout.view_user_repository

class GitHubRepositoryAdapter: ListAdapter<GitHubRepository, GitHubRepositoryViewHolder>(GitHubRepositoryDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepositoryViewHolder =
        GitHubRepositoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_user_repository, parent, false)
        )

    override fun onBindViewHolder(holder: GitHubRepositoryViewHolder, position: Int) =
        holder.bind(getItem(position))

}