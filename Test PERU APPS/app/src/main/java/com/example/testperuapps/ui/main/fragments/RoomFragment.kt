package com.example.testperuapps.ui.main.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entity.Post
import com.example.testperuapps.R
import com.example.testperuapps.data.PostRepository
import com.example.testperuapps.data.entity.PostEntity
import com.example.testperuapps.databinding.FragmentRoomBinding
import com.example.testperuapps.ui.main.DBRoomQuery
import com.example.testperuapps.ui.main.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_room.*

import kotlinx.android.synthetic.main.layout_dialog_detail.*

class RoomFragment : Fragment() {
    private var postListtRoom :List<Post> = ArrayList()
    private var postAdapter = PostAdapter()
    private var postSelect = Post()

    lateinit var binding: FragmentRoomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    fun initUI(){
        val linearVertical =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rviPost.setHasFixedSize(true)
        rviPost.layoutManager = linearVertical
        rviPost.adapter = postAdapter
        getAllPost()
    }

    fun getAllPost(){
        PostRepository(Application()).getAllNotes(object : PostRepository.PopulateCallback {
            override fun onSuccess(postEntityList: List<PostEntity>) {
                postListtRoom = PostEntity.toPost(postEntityList) as MutableList<Post>
                postAdapter.listData = postListtRoom as MutableList<Post>
                postAdapter.onDetail = {
                    postSelect = it
                    showDetailDialog(it)
                }
            }
            override fun onFailure(e: Exception) {

            }
        })
    }

    fun showDetailDialog(post: Post){
        rlaDialog.visibility = View.VISIBLE
        eteComentario.visibility = View.VISIBLE
        binding.item = post
        rlaDialog.setOnClickListener {
            if (rlaDialog.isVisible)
                rlaDialog.visibility = View.GONE
        }
        btnSaveLocal.setOnClickListener {
            DBRoomQuery(vLoading, rlaDialog).updateRoom(postSelect, eteComentario)
            getAllPost()
        }
    }

}
