
// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepo/flashcard/conf/routes
// @DATE:Mon Aug 14 00:33:44 ICT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
