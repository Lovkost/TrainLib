package com.example.trainlib.presentation.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.presentation.GitHubUserViewModel

object UserDiff : DiffUtil.ItemCallback<GitHubUserViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel) = payload

}