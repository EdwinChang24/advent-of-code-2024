fun main(){val(r,u)=java.io.File("i").readText().split("\n\n").map{it.split("\n")};println(u.filter{it!=""&&it.split(",").run{r.all{it.split("|").let{indexOf(it[0])<(indexOf(it[1]).takeIf{it!=-1}?:99)}}}}.sumOf{it.split(",").run{get(size/2).toInt()}})}