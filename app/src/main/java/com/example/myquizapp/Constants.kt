package com.example.myquizapp

object Constants {
  fun getQuestions(): ArrayList<Question> {
    val questionsList = ArrayList<Question>()

    // 1
    val que1 = Question(
      1,
      R.drawable.ic_flag_of_argentina,
      "Argentina", "Australia",
      "Armenia", "Austria", 0
    )

    questionsList.add(que1)

    // 2
    val que2 = Question(
      2,
      R.drawable.ic_flag_of_australia,
      "Angola", "Austria",
      "Australia", "Armenia", 2
    )

    questionsList.add(que2)

    // 3
    val que3 = Question(
      3,
      R.drawable.ic_flag_of_brazil,
      "Belarus", "Belize",
      "Brunei", "Brazil", 3
    )

    questionsList.add(que3)

    // 4
    val que4 = Question(
      4,
      R.drawable.ic_flag_of_belgium,
      "Bahamas", "Belgium",
      "Barbados", "Belize", 1
    )

    questionsList.add(que4)

    // 5
    val que5 = Question(
      5,
      R.drawable.ic_flag_of_fiji,
      "Gabon", "France",
      "Fiji", "Finland", 2
    )

    questionsList.add(que5)

    // 6
    val que6 = Question(
      6,
      R.drawable.ic_flag_of_germany,
      "Germany", "Georgia",
      "Greece", "none of these", 0
    )

    questionsList.add(que6)

    // 7
    val que7 = Question(
      7,
      R.drawable.ic_flag_of_denmark,
      "Dominica", "Egypt",
      "Denmark", "Ethiopia", 2
    )

    questionsList.add(que7)

    // 8
    val que8 = Question(
      8,
      R.drawable.ic_flag_of_india,
      "Ireland", "Iran",
      "Hungary", "India", 3
    )

    questionsList.add(que8)

    // 9
    val que9 = Question(
      9,
      R.drawable.ic_flag_of_new_zealand,
      "Australia", "New Zealand",
      "Tuvalu", "United States of America", 1
    )

    questionsList.add(que9)

    // 10
    val que10 = Question(
      10,
      R.drawable.ic_flag_of_kuwait,
      "Kuwait", "Jordan",
      "Sudan", "Palestine", 0
    )

    questionsList.add(que10)
    return questionsList
  }
}