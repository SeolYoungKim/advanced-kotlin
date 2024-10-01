package reflection

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.cast
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType
import kotlin.reflect.full.hasAnnotation


@Target(AnnotationTarget.CLASS)
annotation class Executable

@Executable
class Reflection {
  fun a() {  // 멤버함수는 자기 자신(this)을 파라미터로 하나 가지고 있다
    println("A입니다")
  }

  fun b(n: Int) {
    println("B입니다")
  }

  fun c() {
    println("C입니다")
  }
}


fun executeAll(obj: Any) {
  val kClass = obj::class
  if (!kClass.hasAnnotation<Executable>()) {
    return
  }

  val callableFunctions = kClass.members.filterIsInstance<KFunction<*>>()
    .filter { it.returnType == Unit::class.createType() }
    .filter { it.parameters.size == 1 && it.parameters[0].type == kClass.createType() }  // 멤버함수는 자기 자신(this)을 파라미터로 하나 가지고 있다

  callableFunctions.forEach { function ->
    function.call(obj)
  }
}

fun add(a: Int, b: Int) = a + b

// JVM
fun main() {
  val addFunction = ::add

  executeAll(Reflection())

  val kClass: KClass<Reflection> = Reflection::class

  val ref = Reflection()
  val kClass2: KClass<out Reflection> = ref::class

  val kClass3: KClass<out Any> = Class.forName("reflection.Reflection").kotlin
  kClass.java // Class<Reflection>
  kClass.java.kotlin // KClass<Reflection>

}

