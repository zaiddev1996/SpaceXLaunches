package zaiddev1996.android.moneseassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.databinding.ListLaunchItemBinding
import zaiddev1996.android.moneseassignment.utils.DateUtil

class LaunchesAdapter(
    private val onBlogClick: (Launch) -> Unit
) : ListAdapter<Launch, LaunchesAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchesAdapter.ViewHolder {
        val layoutBinding = ListLaunchItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(layoutBinding)
    }

    override fun onBindViewHolder(holder: LaunchesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), onBlogClick)
    }

    inner class ViewHolder(private val layoutBinding: ListLaunchItemBinding) :
        RecyclerView.ViewHolder(layoutBinding.root) {
        fun bind(list: Launch, onBlogClick: (Launch) -> Unit) {

            layoutBinding.tvName.text = list.name
            layoutBinding.tvDate.text = DateUtil().unixStampToDate(list.dateUnix!!)

//            Glide.with(context)
//                .load(Constants.IMAGE_URL + list.url)
//                .into(layoutBinding.ivImage)

            layoutBinding.root.setOnClickListener {
                onBlogClick.invoke(list)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Launch>() {
            override fun areItemsTheSame(
                oldItem: Launch,
                newItem: Launch
            ): Boolean {
                return oldItem != newItem
            }

            override fun areContentsTheSame(
                oldItem: Launch,
                newItem: Launch
            ): Boolean {
                return oldItem != newItem
            }
        }
    }
}