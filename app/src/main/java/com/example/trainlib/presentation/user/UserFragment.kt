package com.example.trainlib.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.data.GitHubUserRepositoryFactory
import com.example.trainlib.databinding.ViewUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.trainlib.arguments
import com.example.trainlib.R.layout.view_user
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trainlib.presentation.GitHubUserViewModel

class UserFragment: MvpAppCompatFragment(view_user), UserView {

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

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun showUser(user: GitHubUserViewModel) {
        viewBinding.userLogin.text = user.login
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}