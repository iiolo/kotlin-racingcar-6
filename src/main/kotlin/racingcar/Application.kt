package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
}

data class Car(
    val name: String,
    val score: Int
)

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    if (input.isBlank()) throw IllegalArgumentException("공백만 입력 불가")
    return input
}

fun getValidCarNamesArray(carNames: String): Collection<Car> {
    val carNamesArray = carNames.split(",").map { Car(it, 0) }
    if (carNamesArray.any { it.name.length > 5 }) throw IllegalArgumentException("자동차 이름은 5자 이하 이어야 함")
    return carNamesArray
}

fun getNumberOfRacing(): Int {
    println("시도할 횟수는 몇 회인가요?")
    if (!Console.readLine().matches(Regex("\\d"))) throw IllegalArgumentException("숫자로 입력해야 함")
    return Console.readLine().toInt()
}

fun getRandomNumArray(carNamesArray: Collection<Car>): Array<Int> {
    return Array(carNamesArray.size) {
        Randoms.pickNumberInRange(0, 9)
    }
}







