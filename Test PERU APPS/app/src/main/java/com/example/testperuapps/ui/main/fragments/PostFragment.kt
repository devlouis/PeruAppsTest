package com.example.testperuapps.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entity.Post

import com.example.testperuapps.R
import com.example.testperuapps.databinding.FragmentRoomBinding
import com.example.testperuapps.ui.main.PostViewModel
import com.example.testperuapps.ui.main.adapter.PostAdapter
import com.example.testperuapps.ui.main.DBRoomQuery
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.android.synthetic.main.layout_dialog_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFragment : Fragment() {
    private val postViewModel: PostViewModel by viewModel(clazz = PostViewModel::class)
    private var postSelect = Post()
    private var postAdapter = PostAdapter()
    private var postList :List<Post> = ArrayList()

    lateinit var binding: FragmentRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerVM()
        postViewModel.getPostData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room, container, false)
        return binding.root    }

    fun initUI(){
        val linearVertical =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rviPost.setHasFixedSize(true)
        rviPost.layoutManager = linearVertical
        rviPost.adapter = postAdapter
        postAdapter.onDetail = {
            postViewModel.detailPost(it.id.toString())
        }

    }

    fun observerVM(){
        postViewModel.postLiveData.observe(this, Observer {
            initUI()
            vLoading.visibility = View.GONE
            postList =  it
            postAdapter.listData = postList as MutableList<Post>
        })

        postViewModel.detailPostLiveData.observe(this, Observer {
            postSelect = it
            showDetailDialog(it)
        })
    }


    fun showDetailDialog(post: Post){
        rlaDialog.visibility = View.VISIBLE
        binding.item = post
        rlaDialog.setOnClickListener {
            if (rlaDialog.isVisible)
                rlaDialog.visibility = View.GONE
        }
        btnSaveLocal.setOnClickListener {
            //saveRoom(postSelect)
            DBRoomQuery(vLoading, rlaDialog).saveRoom(postSelect)
        }
    }


}
