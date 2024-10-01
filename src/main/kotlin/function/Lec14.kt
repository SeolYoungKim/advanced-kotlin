package function


class Lec14 {
}

fun main() {
  var num = 5
  num += 1

  // 람다식에서 밖에 있는 변경 가능한 변수를 가져왔다
  // 람다식에서 밖에 있는 변수들에 접근하기 위해, 밖의 정보들을 일시적으로 포획해두는 것 = Closure
  val plusOne: () -> Unit = { num += 1 }
}

fun compute(num1: Int, num2: Int, operator: (Int, Int) -> Int): Int {
  return operator(num1, num2)
}
