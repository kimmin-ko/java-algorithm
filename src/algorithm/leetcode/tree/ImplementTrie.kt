package algorithm.leetcode.tree

class Trie {

    private val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var curNode = this.root
        for (ch in word) {
            if (!curNode.containsKey(ch)) {
                curNode.put(ch)
            }
            curNode = curNode.get(ch)
        }
        curNode.setEnd()
    }

    fun search(word: String): Boolean {
        var curNode = this.root
        for (ch in word) {
            if (!curNode.containsKey(ch)) {
                return false;
            }
            curNode = curNode.get(ch)
        }
        return curNode.isEnd()
    }

    fun startsWith(prefix: String): Boolean {
        var curNode = this.root
        for (ch in prefix) {
            if (!curNode.containsKey(ch)) {
                return false
            }
            curNode = curNode.get(ch)
        }
        return true
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */
}

class TrieNode {
    private val links: Array<TrieNode?> = arrayOfNulls(26)
    private var isEnd: Boolean = false

    fun containsKey(ch: Char): Boolean {
        return this.links[ch - 'a'] != null
    }

    fun get(ch: Char): TrieNode {
        return this.links[ch - 'a']!!
    }

    fun put(ch: Char) {
        this.links[ch - 'a'] = TrieNode()
    }

    fun setEnd() {
        this.isEnd = true
    }

    fun isEnd(): Boolean {
        return this.isEnd
    }
}