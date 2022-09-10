package zaiddev1996.android.moneseassignment.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    fun unixStampToDate(unixStamp: Long): String? {
        return try {
            val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm:ss", Locale.getDefault())
            val netDate = Date(unixStamp * 1000)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }
}