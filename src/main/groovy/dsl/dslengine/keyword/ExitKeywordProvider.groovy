package dsl.dslengine.keyword

class ExitKeywordProvider implements KeywordProvider {
    def keywords = []
    String description = "Exit Keywords - for Exit DSL File"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def exitKeyword = new Keyword()
        exitKeyword.name = "Exit"
        exitKeyword.help = "Exit DSL File"
        exitKeyword.aliases = ["exit", "EXIT"]
        exitKeyword.closure = { value ->
            println("dsl is exit! code:" +value)
            System.exit(value)
        }
        keywords << exitKeyword

        keywords
    }
}
