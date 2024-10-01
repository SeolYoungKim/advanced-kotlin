package delegate

class Person {
  lateinit var name: String
//  lateinit var number: Int  // 사용 불가
//  lateinit var nullableNumber: Int?  // 사용 불가

  val isKim: Boolean
    get() = this.name.startsWith("김")

  val maskingName: String
    get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

fun main() {
  val p = Person()
  p.isKim
}

class Person2 {
  val name: String by lazy {
    Thread.sleep(2_000L)
    "김수한무"
  }
}
