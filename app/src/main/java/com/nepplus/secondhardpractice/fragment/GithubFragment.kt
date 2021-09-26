package com.nepplus.secondhardpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nepplus.secondhardpractice.databinding.FragmentCouroutineItemBinding
import com.nepplus.secondhardpractice.databinding.FragmentGithubBinding
import com.nepplus.secondhardpractice.model.User
import com.nepplus.secondhardpractice.model.UserResponse
import com.nepplus.secondhardpractice.viewmodel.GithubViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubFragment : Fragment() {

    lateinit var binding: FragmentGithubBinding

    val viewModel : GithubViewModel by viewModel()

    val githubAdapter = GithubAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentGithubBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = this@GithubFragment
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }


  //addtextchangelistener -> edittext글자 주입, viewmodel에서 세팅을 가져옴

    private fun initView() {
        binding.apply {
            editText.addTextChangedListener {
                viewModel.setUser(it.toString())
            }

            recyclerview.apply {
                adapter = githubAdapter
            }
        }
    }

    //lifecycle, 데이터의 업데이트 정보를 위해서 반드시 obeerve를 해야 한다.
    //데이터의 변경을 observe만 알려주어서 구현을 하면된다.
    private fun observe(){
        viewModel.user.observe(viewLifecycleOwner){
            githubAdapter.submitList(it.item)
        }
    }

}

class GithubViewHoler(val binding: FragmentCouroutineItemBinding) : RecyclerView.ViewHolder(binding.root)

class GithubAdapter : ListAdapter<User, GithubViewHoler>(User.DiffUtil) {

    var clickListener: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHoler {
        val view = FragmentCouroutineItemBinding.inflate(LayoutInflater.from(parent.context), parent,false
        )

        return GithubViewHoler(view)
    }

    //해당코드에서 바로 모델 클래스에 있는 데이터를 가지고 올 수 있는 이유???????
    //ListAdapter에 User를 통해서 데이터를 가져 올 수 있는지 확인 가능

    override fun onBindViewHolder(holder: GithubViewHoler, position: Int) {

        holder.binding.apply {
            Glide.with(this.root).load(getItem(position).avatar_url).into(image)
            title.text = getItem(position).blog
            subTitle.text = getItem(position).repos_url

        }.also {
            it.root.setOnClickListener {
                clickListener?.invoke(getItem(position))
            }
        }

    }
}