val map  = Map(4->"d", 1->"a", 2->"b", 3->"c")
println(map(2))
//println(map(4))
println(map.init)
println(map.lift(4))
println(map.filterKeys(_<3))
println(map - 2)

println(map.keys)
println(map.values)

println(map.size)
val map2   = Map(1->"a", 2->"b", 3->"c")
println(map.sameElements(map2))

val map3 = Map(1->"aa", 4->"dd")
println(map2 ++ map3)