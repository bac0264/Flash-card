
// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepo/flashcard/conf/routes
// @DATE:Mon Aug 14 00:33:44 ICT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def query(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "query")
    }
  
    // @LINE:9
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateData")
    }
  
    // @LINE:8
    def saveData(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "save")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
