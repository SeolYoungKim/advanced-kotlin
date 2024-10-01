package generic

inline fun <reified T> T.toSuperString() {
  println("${T::class.java.name}: $this")
}

inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
  // any: 하나 이상의 element가 주어진 predicate와 일치하는지 여부를 확인
  return this.any { it is T }
}

class TypeErase<T, R, B> {
}

class CageShadow<T : Animal> {
  fun <T : Animal> addAnimal(animal: T) {

  }
}


fun main() {
  val cage = CageShadow<GoldFish>()
  cage.addAnimal(GoldFish("금붕어"))
  cage.addAnimal(Carp("잉어"))

  val numbers = listOf(1, 2, 3)
  println(numbers.hasAnyInstanceOf<Int>())
  println(numbers.hasAnyInstanceOf<String>())

  numbers.filterIsInstance<Int>()
}

open class CageV1<T : Animal> {
  open fun addAnimal(animal: T) {
    println(animal.name)
  }
}

// CageV2 에 T를 선언하고 이를 CageV1에 넘겨주어야 한다
// 이 때, T는 같은 제약 조건을 가지고 있어야만 한다
class CageV2<T : Animal> : CageV1<T>() {
  override fun addAnimal(animal: T) {
    TODO("구현 필요")
  }
}

class GoldFishCageV2 : CageV1<GoldFish>() {
  override fun addAnimal(animal: GoldFish) {
    TODO("구현 필요")
  }
}
