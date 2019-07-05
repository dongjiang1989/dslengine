package dsl.dslengine.keyword

interface KeywordProvider {
    String description
    void addKeyword(keyword)
    void addKeyword(name, help, closure, aliases)
    List<Keyword> getKeywords()
}