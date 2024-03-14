package ru.netology

fun main() {
    agoToText(87000)
}

fun agoToText(
    seconds: Int,
    minutes: Int = seconds / 60,
    hours: Int = seconds / 60 / 60,
    days: Int = seconds / 60 / 60 / 24
) {
    val minutesRem = minutes % 10

    when {
        days >= 1 && days < 2 -> println("был(а) вчера")
        days >= 2 && days < 3 -> println("был(а) позавчера")
        days > 3  -> println("был(а) давно")

        hours >= 1 && hours <= 24 ->
            when (hours) {
                1, 21 -> println("был(а) $hours час назад")
                2, 3, 4, 22, 23, 24 -> println("был(а) $hours часа назад")
                in 5..20 -> println("был(а) $hours часов назад")
            }

        minutes >= 1 && minutes <= 60 -> when {
            minutes in 11..14 -> println("был(а) $minutes минут назад")
            minutesRem === 1 -> println("был(а) $minutes минуту назад")
            minutesRem in 2..4 -> println("был(а) $minutes минуты назад")
            minutesRem in 5..9 || minutesRem === 0 -> println("был(а) $minutes минут назад")
        }
        seconds >= 0 && seconds <= 60 -> println("был(а) только что")
    }
}

