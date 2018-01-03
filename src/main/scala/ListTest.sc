val list = 1 to 10
val list2 = List(1112,31241,241,5,3,12324,5,123)
println(list takeWhile(_<5))
println(list dropWhile(_<5))
println(list span(_<5))
println(List(1,2,2,1,8) span(_<2))
println(list take(3))
println(list2 take(2))
println(list2 takeRight(2))
println(list2 takeWhile(_>100))

println(list2 head)
println(list2 init)

println(list2.last)
println(list2 tail)
println(list2.slice(2, 3))

//区别groupby和span
println(list2.groupBy(_>100))

println(list2.filter(_>100))





