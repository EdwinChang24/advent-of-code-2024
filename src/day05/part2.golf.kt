fun main(){val(r,u)=java.io.File("i").readText().split("\n\n").map{it.split("\n")};val s=u.filter{it!=""}.map{it.split(",").sortedWith{a,b->if("$a|$b" in r)-1 else 1}};println(u.mapIndexed{i,v->if(v!=""&&v.split(",")!=s[i])s[i].run{this[size/2].toInt()}else 0}.sum())}