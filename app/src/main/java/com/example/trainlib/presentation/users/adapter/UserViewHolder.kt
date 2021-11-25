package com.example.trainlib.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.trainlib.click
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.databinding.ViewUserBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.presentation.GitHubUserViewModel

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(user: GitHubUserViewModel, delegate: UsersAdapter.Delegate?) {
        with(viewBinding) {
            userLogin.text = user.login

            root.click { delegate?.onUserPicked(user) }
        }
    }

}