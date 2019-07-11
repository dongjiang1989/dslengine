a = {
    println "I'm wait for notify."
}

println "this is other code ......."
sleep(6000)  // sleep 6 秒

notify(a)