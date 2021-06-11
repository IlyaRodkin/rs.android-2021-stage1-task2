package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> doSting(blockA)
            Int::class -> doInt(blockA)
            LocalDate::class -> doDate(blockA)
            else -> return ""
        }
    }

    private fun doSting(blockA: Array<*>): Any {
        var string = StringBuilder()
        for (i in blockA.indices) {
            if (blockA[i] is String) string.append(blockA[i])
        }
        return string.toString()
    }

    private fun doInt(blockA: Array<*>): Any {
        var value = 0
        var valuePlus = 0
        for (i in blockA.indices) {
            if (blockA[i] is Int) {
                valuePlus = blockA[i] as Int
                value += valuePlus
            }
        }
        return value
    }

    private fun doDate(blockA: Array<*>): Any {
        val dateNow = LocalDate.now()
        var date = StringBuilder()
        var masDate = arrayListOf<LocalDate>()
        for (i in blockA.indices) {
            if (blockA[i] is LocalDate) {
                masDate.add(blockA[i] as LocalDate)
            }
        }

        try {
            for (i in 0..masDate.size - 2) {    //sort for Year
                for (j in i + 1 until masDate.size) {
                    if (kotlin.math.abs(dateNow.year - masDate[i].year)
                        > kotlin.math.abs(dateNow.year - masDate[j].year)
                    ) {
                        var tmpDate = masDate[i]
                        masDate[i] = masDate[j]
                        masDate[j] = tmpDate
                    }
                }
            }
            for (i in 0..masDate.size - 2) {
                if (masDate[i].year != masDate[i + 1].year) {
                    masDate.dropLast(masDate.size - i - 1).also { masDate = it as ArrayList<LocalDate> }

                }
            }
        }catch (e:Exception){
            return date.append(masDate[0].dayOfMonth).append(".").append(masDate[0].monthValue)
                .append(".").append(masDate[0].year).toString()
        }

        try {
            for (i in 0..masDate.size - 2) {              //sort for month
                for (j in i + 1 until masDate.size) {
                    if (kotlin.math.abs(dateNow.monthValue - masDate[i].monthValue)
                        > kotlin.math.abs(dateNow.monthValue - masDate[j].monthValue) &&
                        dateNow.year == masDate[i].year) {
                        var tmpDate = masDate[i]
                        masDate[i] = masDate[j]
                        masDate[j] = tmpDate
                    }
                    else if(masDate[i].monthValue < masDate[j].monthValue){
                        var tmpDate = masDate[i]
                        masDate[i] = masDate[j]
                        masDate[j] = tmpDate
                    }
                }
            }
            for (i in 0..masDate.size - 2) {
                if (masDate[i].monthValue != masDate[i + 1].monthValue) {
                    masDate.dropLast(masDate.size - i - 1).also { masDate = it as ArrayList<LocalDate> }

                }
            }
        }
        catch (e:Exception){
            return date.append(masDate[0].dayOfMonth).append(".").append(masDate[0].monthValue)
                .append(".").append(masDate[0].year).toString()
        }

        try {
            for (i in 0..masDate.size - 2) {              //sort for month
                for (j in i + 1 until masDate.size) {
                    if (kotlin.math.abs(dateNow.dayOfMonth - masDate[i].dayOfMonth)
                        > kotlin.math.abs(dateNow.dayOfMonth - masDate[j].dayOfMonth)  &&
                        dateNow.year == masDate[i].year) {
                        var tmpDate = masDate[i]
                        masDate[i] = masDate[j]
                        masDate[j] = tmpDate
                    }
                    else if(masDate[i].dayOfMonth < masDate[j].dayOfMonth){
                        var tmpDate = masDate[i]
                        masDate[i] = masDate[j]
                        masDate[j] = tmpDate
                    }
                }
            }
            for (i in 0..masDate.size - 2) {
                if (masDate[i].dayOfMonth != masDate[i + 1].dayOfMonth) {
                    masDate.dropLast(masDate.size - i - 1).also { masDate = it as ArrayList<LocalDate> }

                }
            }
        }
        catch (e:Exception){
            return date.append(masDate[0].dayOfMonth).append(".").append(masDate[0].monthValue)
                .append(".").append(masDate[0].year).toString()
        }


        return date.append(masDate[0].dayOfMonth).append(".").append(masDate[0].monthValue)
            .append(".").append(masDate[0].year).toString()
    }
}
