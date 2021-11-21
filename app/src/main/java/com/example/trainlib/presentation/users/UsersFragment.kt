package com.example.trainlib.presentation.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.trainlib.PopularLibraries.Navigation.router
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.data.GitHubUserRepositoryFactory
import com.example.trainlib.databinding.ViewUsersBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.trainlib.R.layout.view_users
import com.example.trainlib.arguments
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.presentation.users.adapter.UsersAdapter

class UsersFragment: MvpAppCompatFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) =
        presenter.displayUser(user)

}