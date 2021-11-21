package com.example.trainlib.presentation.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.trainlib.data.GitHubUser

object UserDiff : DiffUtil.ItemCallback<GitHubUser>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem.login == newItem.login
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubUser, newItem: GitHubUser) = payload

}