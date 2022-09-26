package org.sjhstudio.sunflowerclone.data.local

import androidx.room.TypeConverter
import java.util.*

/**
 * @description     : Room 에서 복잡한 데이터를 참조하기 위해 사용되는 컨버터
 */
class Converters {

    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar) = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar = Calendar.getInstance().apply { timeInMillis = value }
}