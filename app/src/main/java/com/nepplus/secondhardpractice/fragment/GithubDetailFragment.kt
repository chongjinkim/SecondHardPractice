package com.nepplus.secondhardpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.nepplus.secondhardpractice.databinding.FragmentGithubDetailBinding
import com.nepplus.secondhardpractice.model.User

class GithubDetailFragment : Fragment() {

    lateinit var binding: FragmentGithubDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentGithubDetailBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = this@GithubDetailFragment
        binding.root
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>(GITHUB_USER)

            //지정된 값이 null이 아닐 때 반드시 사용을 해야 한다.
        binding.apply {
            user?.let {
                Glide.with(this.root).load(user.avatar_url).into(detailImage)
                detailName.text = user.name
            }
        }
    }

    companion object{

        const val GITHUB_USER = "GITHUB_USER"
//        getter//setter 자동으로 생성
        @JvmStatic
        fun newInstance(user : User) = GithubDetailFragment().apply {
            arguments = Bundle().apply { putParcelable(GITHUB_USER, user) }
        }
    }

}