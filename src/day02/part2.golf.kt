fun main()=println(java.io.File("i").readLines().map{it.split(' ').map{it.toInt()}}.count{it.indices.any{r->it.filterIndexed{i,_->i!=r}.run{"$this" in "${sorted()}${sortedDescending()}"&&sorted().windowed(2).all{it[1]-it[0]in 1..3}}}})