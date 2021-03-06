package `in`.webdevlabs.campuscommerce.adapters

/**
 * Created by yolo on 7/4/18.
 */
import `in`.webdevlabs.campuscommerce.R
import `in`.webdevlabs.campuscommerce.model.Post
import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name) as TextView
    var price: TextView = itemView.findViewById(R.id.price) as TextView
    var type: TextView = itemView.findViewById(R.id.type) as TextView
    var chat: ImageView = itemView.findViewById(R.id.chat) as ImageView
    var time: TextView = itemView.findViewById(R.id.time) as TextView

    fun bindPost(post: Post) {
        this.name.text = post.name
        this.price.text = post.price.toString()
        this.type.text = post.type.toString()

        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        post.time?.run {
            time.text = DateUtils.getRelativeTimeSpanString(sdf.parse(post.time).time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS)
        }
    }
}