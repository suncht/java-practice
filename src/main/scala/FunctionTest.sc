def myprint(s: Any) = println(s)

def compute(arr: Array[Int])(f: (Int, Int)=>Int): Int = {
  var sum = 0
  for(i <- 0 until arr.length) {
    sum += f(sum, i)
  }
  sum
}

val arr = Array(2,3)
println(compute(arr)(_+_))