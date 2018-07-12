package common

import com.softwaremill.macwire.wire
import controllers.{Assets, AssetsComponents, PostController}
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.{DBComponents, HikariCPComponents}
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import repositories.implementations.PostRepositoryImp
import router.Routes
import services.implementations.PostServiceImp

import scala.concurrent.Future

class BlogApiComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
  with DBComponents
  with EvolutionsComponents
  with HikariCPComponents
  with AssetsComponents
  with HttpFiltersComponents {

  lazy val database = dbApi.database("default")

  // Router
  override lazy val assets = wire[Assets]
  lazy val prefix: String = "/"
  lazy val blogApiRouter: Router = wire[Routes]
  lazy val router: Router = blogApiRouter

  // Controllers
  lazy val postController = wire[PostController]

  // Services
  lazy val postService = wire[PostServiceImp]

  // Repositories
  lazy val postRepository = wire[PostRepositoryImp]

  //Hookups
  applicationLifecycle.addStopHook(() => Future.successful {
    database.shutdown()
  })

}
