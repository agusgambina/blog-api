package common

import com.softwaremill.macwire.wire
import controllers.{Assets, AssetsComponents, PostController}
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import repositories.implementations.PostRepositoryImp
import router.Routes
import services.implementations.PostServiceImp

class BlogApiComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
  with AssetsComponents
  with HttpFiltersComponents {

  // Router
  override lazy val assets = wire[Assets]
  lazy val prefix: String = "/"
  lazy val blogApiRouter: Router = wire[Routes]
  lazy val router: Router = blogApiRouter

  // Controllers
  //lazy val homeController = wire[HomeController]
  lazy val postController = wire[PostController]

  // Services
  lazy val postService = wire[PostServiceImp]

  // Repositories
  lazy val postRepository = wire[PostRepositoryImp]

}
