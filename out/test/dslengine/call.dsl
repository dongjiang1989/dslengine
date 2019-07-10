package call

import static java.lang.Math.pow
println pow(2,3)

// 注释
println 1 /* one */ + 2 /* two */
println 1222 // println

def mys = { e -> println "balabala ${e}" }
aaa = mys
aaa()
mys()

def func1(abc) {
    println "func1 bababa..."
}
bbb = this.&func1
bbb()
func1()

def abc = 0
println abc

def addList(abc) {
    list = []
    abc.delegate = list
    abc()
    list
}
list = addList() {
    add(1)
    add(2)
    size()
}
println list

// 注释
Call(list)
Call([1, 2, 3, 4])

def succ = Call    13811400863   // Call(13811400863)
println succ
if (succ == true) {
    sendmessage "I love you"
} else {
    play "`let it go!` move "
}

def task = {println "3.hello"}
println "1.begin"
new Thread( {
         task();
    }).start()
println "2.end"

Timer timer = new Timer()
timer.schedule(new TimerTask() {
    void run() {
        println new Date()
    }
}, 0)

echo 133:abc
9.key "Eighty Nine"
