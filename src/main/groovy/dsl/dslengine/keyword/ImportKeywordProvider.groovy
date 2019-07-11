package dsl.dslengine.keyword

class ImportKeywordProvider implements KeywordProvider {
    def keywords = []
    def hasImport = []
    String description = "Import Keywords - import other dsl file"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def exitKeyword = new Keyword()
        exitKeyword.name = "Import"
        exitKeyword.help = "import other dsl file"
        exitKeyword.aliases = ["import", "IMPORT"]
        exitKeyword.closure = { value->
            println("import other dsl file" +value)
            if (value in hasImport) {
                println(value, "has imported!!!")
            } else {
                hasImport << value
            }
        }
        keywords << exitKeyword

        keywords
    }
}
