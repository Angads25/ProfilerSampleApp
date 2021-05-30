package com.github.angads25.profilersampleapp.imagegallery.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.angads25.domain.models.Photos
import com.github.angads25.profilersampleapp.databinding.ListItemImageBinding

class ImageListAdapter: RecyclerView.Adapter<ImageListAdapter.ImageItemViewHolder>() {
    private val imageList: ArrayList<Photos> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        val binding: ListItemImageBinding = ListItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    fun addImages(photos: List<Photos>) {
        val sizeBefore = imageList.size
        imageList.addAll(photos)
        notifyItemRangeChanged(sizeBefore, photos.size)
    }

    class ImageItemViewHolder(binding: ListItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imageView

        fun bind(photo: Photos) {
            Glide.with(imageView).load(photo.src.large).into(imageView)
        }
    }
}