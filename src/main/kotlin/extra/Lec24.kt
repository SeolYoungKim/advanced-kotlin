package extra

import kotlin.system.measureTimeMillis

class Lec24 {
}

fun main() {
  repeat(3) {
    println("Hello world!")
  }

  val measureTimeMillis = measureTimeMillis {
    val a = 1
    val b = 2
    Thread.sleep(50)
    val add = a + b
  }
  println("측정 시간 = $measureTimeMillis")

//  acceptOnlyTwo(3)  // 2가 아니라서 예외

  // runCatching을 이용해 예외 처리를 간단하게 할 수 있다
  // 예외를 던지지 않고, 성공/실패 모두 Result<R>라는 객체를 반환함
  // Result<R> 객체는 여러 함수를 제공하여 예외 처리의 편의성을 제공함 (체이닝 가능)
  val result: Result<Int> = runCatching { 1 / 0 }
  println("runCatching 실행 결과 = $result")

//  val person = Person()
//  person.status = Person.PersonStatus.SLEEPING
//  person.sleep()  // check 조건을 통과하지 못해 예외

  TODO("main함수 구현이 덜됐음")
}

fun acceptOnlyTwo(num: Int) {
  // 검증 로직을 깔끔하게 만들 수 있다
  // 파라미터 검증에 주로 사용된다
  require(num == 2) { "2만 허용!" }  // 주의 : 통과 조건을 적어야 함
}

class Person {
  var status: PersonStatus = PersonStatus.PLAYING

  fun sleep() {
    // 상태 혹은 멤버 변수 검증에 유용하게 사용된다
    check(this.status == PersonStatus.PLAYING) { "PLAYING일 때만 호출 가능!" }
  }

  enum class PersonStatus {
    PLAYING, SLEEPING
  }
}
