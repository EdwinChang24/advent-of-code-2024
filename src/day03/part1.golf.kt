fun main()=println(java.io.File("i").readText().split("mul(").drop(1).map{it.split(")")[0].split(",")}.filter{it.size==2}.sumOf{(it[0].toIntOrNull()?:0)*(it[1].toIntOrNull()?:0)})