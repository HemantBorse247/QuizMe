package com.hemant.quizapp

object Constants {

    const val USER_NAME : String = "User_name"
    const val TOTAL_QUESTIONS: String = "Total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val quest1 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Austria",
            "Greece",
            1
        )
        questionList.add(quest1)

        val quest2 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Austria",
            "Greece",
            2
        )
        questionList.add(quest2)

        val quest3 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bermuda",
            "Belgium",
            "Bangladesh",
            "Greece",
            2
        )
        questionList.add(quest3)

        val quest4 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Australia",
            "Austria",
            "Brazil",
            4
        )
        questionList.add(quest4)

        val quest5 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Australia",
            "Austria",
            "Greece",
            1
        )
        questionList.add(quest5)

        val quest6 = Question(
            1,
            "What country this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "fiji",
            "Austria",
            "Greece",
            2
        )
        questionList.add(quest6)

        return questionList
    }

}