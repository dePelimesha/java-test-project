package net.itspartner.test.n3

/**
 * Description: Application calculates sum of ages of all users and finds the eldest user
 * Task: Refactor, use Kotlin style constructions. Calculate average age of users.
 */
@SuppressWarnings("all")
fun main(args: Array<String>) {

    val usersList = mutableListOf<User>()
    usersList.add(User("Pavel", 50))
    usersList.add(User("Suresh", 50))
    usersList.add(User("Robin", 50))

    val maxAge = usersList.maxBy { it -> it.age }
    println("The eldest user is ${maxAge!!.name}")

    val sumAge = usersList.sumBy { it -> it.age }.toDouble()
    println("Sum of all ages is $sumAge")

    val avgAge = findAverageAge(sumAge, usersList.count())
    println("Average age is $avgAge")
}

fun findAverageAge(sumAge: Double, numberOfUsers: Int) = sumAge/numberOfUsers