package dsl.dslengine.keyword

class DebuggingKeywordProvider implements KeywordProvider {
    def keywords = []
    String description = "Debugging Keywords - for testing Diesel Engine!!"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def debugKeyword = new Keyword()
        debugKeyword.name = "debug"
        debugKeyword.help = "simple echo keyword"
        debugKeyword.aliases = ["echo"]
        debugKeyword.closure = { value ->
            if (value instanceof List) {
                value.each {
                    println "DEBUG: ${it}"
                }
            } else if (value instanceof Map) {
                value.each { k,v ->
                    println "DEBUG: ${k}:${v}"
                }
            } else {
                println "DEBUG: ${value}"
            }
        }
        keywords << debugKeyword

        keywords
    }
}
