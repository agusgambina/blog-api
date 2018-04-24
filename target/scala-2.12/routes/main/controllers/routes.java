// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/agusgambina/code/github/blog-api/conf/routes
// @DATE:Tue Apr 24 10:33:32 ART 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
