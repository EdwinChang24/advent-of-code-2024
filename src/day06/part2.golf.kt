fun main()= java.io.File("i").readLines().map{it.toMutableList()}.run{println(indices.sumOf{o->get(o).indices.count{var b=false;if(get(o)[it]!in "#^"){get(o)[it]='#';val v=mutableSetOf<Pair<Pair<Int,Int>,Pair<Int,Int>>>();val(x,y)=indexOfFirst{'^' in it}to first{'^' in it}.indexOf('^');var(r,c)=x to y;get(r)[c]='.';var d=-1 to 0;while(r in indices&&c in get(0).indices){if(r to c to d in v){b=true;break};v+=r to c to d;while(getOrNull(r+d.first)?.getOrNull(c+d.second)=='#')d=when(d){-1 to 0->0 to 1;0 to 1->1 to 0;1 to 0->0 to-1;else->-1 to 0};r+=d.first;c+=d.second};get(x)[y]='^';get(o)[it]='.'};b}})}