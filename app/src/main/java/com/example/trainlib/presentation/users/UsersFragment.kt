package com.example.trainlib.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import com.example.trainlib.R.layout.view_users
import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.databinding.ViewUsersBinding
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.users.adapter.UsersAdapter
import com.example.trainlib.arguments

class UsersFragment: AbsFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = gitHubUserRepository,
            router = router,
            schedulers = schedulers
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUserViewModel>) {
        usersAdapter.submitList(users)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onUserPicked(user: GitHubUserViewModel) =
        presenter.displayUser(user)

}