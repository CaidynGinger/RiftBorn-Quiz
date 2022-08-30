package com.example.riftbornquiz.modles

import com.example.riftbornquiz.R

object Constants {
    fun getAllQuestions()  : ArrayList<Question>{
        var allQuestions = ArrayList<Question>()

        val que1 = Question(
                1,
        "The diagram shows the height of a stack of identical coins. \n What is the thickness of one coin? ",
            R.drawable.question_one,
            "0.20 mm",
            "2.0 mm",
            "0.24 cm",
        "2.0 cm",
        2)

        allQuestions.add(que1)

        val que2 = Question(
            2,
            "In a laboratory, a ball is dropped in a vacuum and falls 200cm.\n  Which statement describes the acceleration of the ball?",
            R.drawable.question_two,
            "It is greater at 10cm than at 200 cm.",
            "It is greatest at 200cm.",
            "It is smaller at 50cm than at 100cm.",
            "It is the same value at 50cm as at 150cm. ",
            4)

        allQuestions.add(que2)

        val que3 = Question(
            3,
            "A man stands by a railway track. \n  A train travelling at 40m/ s takes 2.0s to pass the man.\n" +
                    "What is the length of the train? ",
            R.drawable.question_two,
            "20m",
            "38m",
            "40m",
            "80m",
            4)

        allQuestions.add(que3)

        val que4 = Question(
            4,
            "A stone has a volume of 0.50cm3 and a mass of 2.0g.\n" +
                    "What is the density of the stone? ",
            R.drawable.question_two,
            "0.25g/cm3",
            "1.5g/ cm3",
            "2.5g/ cm3",
            "4.0g/ cm3",
            4)

        allQuestions.add(que4)

        val que5 = Question(
            5,
            "In which position would a boy exert the most pressure on the ground? ",
            R.drawable.question_two,
            "lying on his back",
            "sitting down",
            "standing on one foot ",
            "standing on two feet ",
            3)

        allQuestions.add(que5)

        return allQuestions
    }
}