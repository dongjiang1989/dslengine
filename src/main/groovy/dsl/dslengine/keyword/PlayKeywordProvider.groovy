package dsl.dslengine.keyword

class PlayKeywordProvider implements KeywordProvider {
    def keywords = []
    String description = "Play Keywords - Play moving!"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def playKeyword = new Keyword()
        playKeyword.name = "Play"
        playKeyword.help = "Play moving."
        playKeyword.aliases = ["play", "PLAY"]
        playKeyword.closure = { value ->
            if (value == null)
                return this

            if (value instanceof List) {
                value.each {
                    println "play1: ${it}"
                }
            } else if (value instanceof Map) {
                value.each { k,v ->
                    if (v instanceof  Script) {
                        println "play4" + v.toString()
                    } else {
                        println "play2: ${k}:${v}"
                    }
                }
            } else {
                println "play3: ${value}"
            }
        }
        keywords << playKeyword

        keywords
    }
}