// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/agusgambina/code/github/blog-api/conf/routes
// @DATE:Tue Apr 24 10:33:32 ART 2018


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
