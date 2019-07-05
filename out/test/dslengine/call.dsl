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

def succ = Call 13811400863  // Call(13811400863)
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