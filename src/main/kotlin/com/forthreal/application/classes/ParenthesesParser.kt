package com.forthreal.application.classes

import com.forthreal.application.exception.ParenthesesParseException
import javax.xml.ws.Holder

/*
 ( ) *

 */

object ParenthesesParser
{
    fun checkBalanced(input: String) : Boolean
    {
        val hBalancedMin = Holder<Int>()
        hBalancedMin.value = 0

        val hBalancedMax = Holder<Int>()
        hBalancedMax.value = 0

        val hAsterisk = Holder<Int>()
        hAsterisk.value = 0

        val hUnbalanced = Holder<Boolean>()
        hUnbalanced.value = false

        input
            .toCharArray()
            .forEach {
                when(it)
                {
                    '(' -> {
                        hBalancedMax.value ++
                        hBalancedMin.value ++
                    }
                    ')' -> {
                        hBalancedMin.value --

                        /* There are fewer asterisks than closing parentheses, it will not ever restore */
                        if( ( hBalancedMin.value + hAsterisk.value ) < 0 )
                        {
                            hUnbalanced.value = true
                        }
                    }
                    '*' -> {
                        hAsterisk.value ++
                    }
                    ' ' -> {

                    }
                    else -> {
                        throw ParenthesesParseException("Unexpected symbol found: ${it}")
                    }
                }
            }

        System.out.println("min ${hBalancedMin.value} max ${hBalancedMax.value} asterisk ${hAsterisk.value}")

        return if(
                    ( hUnbalanced.value == false ) &&
                    (
                      ( hBalancedMax.value <= ( hBalancedMin.value + hAsterisk.value ) ) ||
                      ( hBalancedMin.value == 0 )
                    )
                 )
                    true
               else
                    false
    }

}