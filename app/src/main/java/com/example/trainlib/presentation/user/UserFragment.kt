package com.example.trainlib.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.arguments
import com.example.trainlib.data.GitHubUserRepositoryFactory
import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.databinding.ViewUserDetailsBinding
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.user.adapter.GitHubRepositoryAdapter
import com.example.trainlib.setTextColorCompat
import com.example.trainlib.setUserAvatar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.trainlib.R.layout.view_user_details

class UserFragment: MvpAppCompatFragment(view_user_details), UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    private val viewBinding: ViewUserDetailsBinding by viewBinding()
    private val gitHubRepositoryAdapter = GitHubRepositoryAdapter()

    override fun showUser(user: GitHubUserViewModel) {
        with(viewBinding) {
            this.user.setUserAvatar(user.avatar)
            this.user.setTextColorCompat(user.nameColor)
            this.user.text = user.name
        }
    }

    override fun showRepositories(repositories: List<GitHubRepository>) {
        with(viewBinding) {
            userRepositories.adapter = gitHubRepositoryAdapter
        }

        gitHubRepositoryAdapter
            .submitList(repositories)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}