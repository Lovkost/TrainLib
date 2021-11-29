package com.example.trainlib.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.click
import com.example.trainlib.databinding.ViewUserBinding
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.users.adapter.UsersAdapter.Delegate
import com.example.trainlib.setTextColorCompat
import com.example.trainlib.setUserAvatar

class UserViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(userModel: GitHubUserViewModel, delegate: Delegate?) {
        with(viewBinding) {
            user.setUserAvatar(userModel.avatar)
            user.setTextColorCompat(userModel.nameColor)
            user.text = userModel.name

            root.click { delegate?.onUserPicked(userModel) }
        }
    }

}