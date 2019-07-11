abc = async([{
        println "task 1"
        return 2 * 2
    }, {
        println "task 2"
        return 4 * 4
    }, {
        println "task 3"
        return 8000 * 8000
    }])

println join(abc)

a = async { 2 * 2 }
b = async { 4 * 4 }
c = async { 8 * 8 }
result = join([a,b,c])
println result