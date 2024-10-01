package delegate

fun main() {
  val fruits = listOf(
    MyFruit("사과", 1000L),
    MyFruit("바나나", 3000L),
  )

  // Iterable을 이용하는 방법
  val avgWithIterable = fruits
    .filter { it.name == "사과" }
    .map { it.price }
    .take(10_000)
    .average()

  // 2,000,000 -> 모두 필터링!
  // [과일, 과일 과일, .. ]
  // Sequence를 이용하는 방법
  val avgWithSequence = fruits.asSequence()
    .filter { it.name == "사과" }
    .map { it.price }
    .take(10_000)
    .average()
}

data class MyFruit(
  val name: String,
  val price: Long, // 1,000원부터 20,000원 사이
)
