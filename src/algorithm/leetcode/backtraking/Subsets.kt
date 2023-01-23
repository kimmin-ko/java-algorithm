package algorithm.leetcode.backtraking

class Subsets {

    private val result: MutableList<List<Int>> = mutableListOf()

    fun subsets(nums: IntArray): List<List<Int>> {
        subsets(nums, 0, mutableListOf())
        return result;
    }

    fun subsets(nums: IntArray, index: Int, subsets: MutableList<Int>) {
        if (nums.size == index) {
            result.add(ArrayList(subsets))
            return
        }

        val num = nums[index]
        subsets.add(num)
        subsets(nums, index + 1, subsets)

        if (subsets.isNotEmpty()) {
            subsets.removeAt(subsets.size - 1)
        }
        subsets(nums, index + 1, subsets)
    }
}