package com.example.mytestingapplication.presentation.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestingapplication.R
import com.example.mytestingapplication.databinding.ListItemUserRepositoriesBinding
import com.example.mytestingapplication.model.DiffUtilRepositoriesModelItem
import com.example.mytestingapplication.model.RepositoriesModel
import com.example.mytestingapplication.util.hideIfEmptyText
import com.example.mytestingapplication.util.loadImageFromUrl

class RepositoriesAdapter: ListAdapter<RepositoriesModel.RepositoriesModelItem, RepositoriesAdapter.RepositoriesViewHolder>(
    DiffUtilRepositoriesModelItem()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val itemView = ListItemUserRepositoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepositoriesViewHolder(binding = itemView)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


class RepositoriesViewHolder(private var binding: ListItemUserRepositoriesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RepositoriesModel.RepositoriesModelItem?) {
        val owner = item?.owner
        binding.imageViewOwner?.loadImageFromUrl(owner?.avatarUrl)
        binding.textViewOwnerName.text = item?.fullName?.substringBefore(delimiter = "/")
        binding.textViewRepositoryName.hideIfEmptyText(item?.name)
        binding.textViewRepositoryDescription.hideIfEmptyText(item?.description)
    }
}
}