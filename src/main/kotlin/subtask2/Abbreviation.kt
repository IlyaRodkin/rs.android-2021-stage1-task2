package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var countB = 0
        var countA = 0
        for (i in b.indices) {
            for (j in a.indices) {
                if (j < countA) continue
                else if(b[i] == a[j]) {
                    countB++
                    countA = j
                    break
                }
               else if ((b[i].toInt() > 98 && a[j].toInt() + 32 == b[i].toInt()) ||
                    (b[i].toInt() < 98 && a[j].toInt() - 32 == b[i].toInt())){
                    countB++
                    countA = j
                    break
                }
            }
        }
        return if(countB == b.length) "YES"
        else "NO"
        throw NotImplementedError("Not implemented")
    }
}
