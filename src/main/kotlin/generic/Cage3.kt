package generic

fun main() {
  val fishCage = Cage3<Fish>()
  val animalCage: Cage3<Animal> = fishCage

  val cage:Cage3<Number> = Cage3<Int>()

}

class Cage3<out T> {
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return this.animals.first()
  }

  fun getAll(): List<T> {
    return this.animals
  }
}

class Cage4<in T> {
  private val animals: MutableList<T> = mutableListOf()

  fun put(animal: T) {
    this.animals.add(animal)
  }

  fun putAll(animals: List<T>) {
    this.animals.addAll(animals)
  }
}
