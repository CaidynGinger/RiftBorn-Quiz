package com.example.riftbornquiz.modles

import com.example.riftbornquiz.R

object Constants {
    fun getAllQuestions()  : ArrayList<Question>{
        var allQuestions = ArrayList<Question>()

        val que1 = Question(
                1,
        "Why does the energy needed by a human increase during the first ten years of life",
            "Coordination and responses improve",
            "Energy is needed for gamete formation",
            "The Body is Growing",
            "The diet is more balanced")

        allQuestions.add(que1)

        return allQuestions
    }
}