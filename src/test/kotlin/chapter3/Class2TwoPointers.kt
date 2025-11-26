package chapter3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Class2TwoPointers {
    class Solution {
        fun reverseWords(s: String): String {
            var pointerR = 0
            var pointerL = 0
            var result :String = ""
            while(pointerR < s.length){
                if(s[pointerR] == ' '){
                    var word = s.substring(pointerL, pointerR+1)
                    // println("regular  word <$word>")
                    // println("reversed word <${word.reversed()}>")
                    result = result + word.reversed()
                    // println("result:<$result>")
                    pointerL = pointerR+1
                    pointerR++
                }else{
                    pointerR++
                }

            }
            result = result + " " + s.substring(pointerL, pointerR).reversed()
            return result.substring(1,result.length)
        }
    }

    @Test
    fun testCase1(){
        val reverseWords = Solution().reverseWords(
            s = "Let's take LeetCode contest"
        )

        assertEquals(
            expected = "s'teL ekat edoCteeL tsetnoc",
            actual = reverseWords
        )
    }

    @Test
    fun testCase2(){
        val reverseWords = Solution().reverseWords(
            s = "Mr Ding"
        )

        assertEquals(
            expected = "rM gniD",
            actual = reverseWords
        )
    }
}