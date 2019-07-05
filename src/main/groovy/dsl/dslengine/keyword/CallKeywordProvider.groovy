package dsl.dslengine.keyword

class CallKeywordProvider implements KeywordProvider {
    def keywords = []
    String description = "Call Keywords - Call phone No."

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def callKeyword = new Keyword()
        callKeyword.name = "Call"
        callKeyword.help = "Call phone No."
        callKeyword.aliases = ["call", "CALL"]
        callKeyword.closure = { value ->
            if (value instanceof List) {
                value.each {
                    println "CALL1: ${it}"
                }
            } else if (value instanceof Map) {
                value.each { k,v ->
                    if (v instanceof  Script) {
                        println "CALL2" + v.toString()
                    } else {
                        println "CALL3: ${k}:${v}"
                    }
                }
            } else {
                println "CALL4: ${value}"
            }
            return true
        }
        keywords << callKeyword

        keywords
    }
}
