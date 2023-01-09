package algorithm.leetcode.backtraking

class LetterCombinationsOfAPhoneNumber {

    private val digitAndAlphabet: HashMap<Int, List<String>> = HashMap()
    private val result: ArrayList<String> = ArrayList()

    init {
        digitAndAlphabet[2] = arrayListOf("a", "b", "c")
        digitAndAlphabet[3] = arrayListOf("d", "e", "f")
        digitAndAlphabet[4] = arrayListOf("g", "h", "i")
        digitAndAlphabet[5] = arrayListOf("j", "k", "l")
        digitAndAlphabet[6] = arrayListOf("m", "n", "o")
        digitAndAlphabet[7] = arrayListOf("p", "q", "r", "s")
        digitAndAlphabet[8] = arrayListOf("t", "u", "v")
        digitAndAlphabet[9] = arrayListOf("w", "x", "y", "z")
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }
        letterCombinations(digits, 0, "")
        return result;
    }

    private fun letterCombinations(digits: String, index: Int, letter: String) {
        if (digits.length <= index) {
            result.add(letter)
            return
        }

        val num: Int = Character.getNumericValue(digits[index])
        val alphabets: List<String> = digitAndAlphabet.getOrDefault(num, emptyList())
        for (alphabet in alphabets) {
            letterCombinations(digits, index + 1, letter + alphabet)
        }
    }
}
