package subtask1

import java.time.LocalDate

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {

        try {


            var stringDate = StringBuilder().append(day).append(' ')
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            when (month) {
                "1" -> stringDate.append("января, ")
                "2" -> stringDate.append("февраля, ")
                "3" -> stringDate.append("марта, ")
                "4" -> stringDate.append("апреля, ")
                "5" -> stringDate.append("мая, ")
                "6" -> stringDate.append("июня, ")
                "7" -> stringDate.append("июля, ")
                "8" -> stringDate.append("августа, ")
                "9" -> stringDate.append("сентября, ")
                "10" -> stringDate.append("октября, ")
                "11" -> stringDate.append("ноября, ")
                "12" -> stringDate.append("декабря, ")
            }
            when(date.dayOfWeek.toString()){
                "MONDAY" -> stringDate.append("понедельник")
                "TUESDAY" -> stringDate.append("вторник")
                "WEDNESDAY" -> stringDate.append("среда")
                "THURSDAY" -> stringDate.append("четверг")
                "FRIDAY" -> stringDate.append("пятница")
                "SATURDAY" -> stringDate.append("суббота")
                "SUNDAY" -> stringDate.append("воскресенье")
            }
            return stringDate.toString()
        } catch (e:Exception){
            return "Такого дня не существует"
        }

    }
}
