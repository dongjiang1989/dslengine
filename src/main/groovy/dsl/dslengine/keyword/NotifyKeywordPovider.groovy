package dsl.dslengine.keyword

class NotifyKeywordPovider implements KeywordProvider {
    def keywords = []
    String description = "Notify Keywords"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def playKeyword = new Keyword()
        playKeyword.name = "notify"
        playKeyword.help = "Notify Keywords"
        playKeyword.aliases = ["Notify"]
        playKeyword.closure = { Closure value ->
            return value()

        }
        keywords << playKeyword

        keywords
    }
}
