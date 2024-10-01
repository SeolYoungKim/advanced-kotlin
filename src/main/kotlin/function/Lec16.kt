package function

// 이름이 있는 함수
fun add(a: Int, b: Int) = a + b

fun main() {
  // 람다
  val add1 = { a: Int, b: Int -> a + b }
  // 익명 함수
  val add2 = fun (a: Int, b: Int) = a + b
  // 이름이 있는 함수를 변수에 바로 할당하는 방법 (Method Reference)
  val add3 = ::add

  val filter = StringFilter { str -> str?.startsWith("A") ?: false }
  consumeFilter({ str -> str?.startsWith("A") ?: false })

  KStringFilter { it.startsWith("A") }
}

fun consumeFilter(filter: StringFilter) { }

fun <T> consumeFilter(filter: Filter<T>) {}

fun interface KStringFilter {
  fun predicate(str: String): Boolean
}
