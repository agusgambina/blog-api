package common

import play.api.ApplicationLoader.Context
import play.api._

class BlogApiApplicationLoader extends ApplicationLoader {

  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach { _.configure(context.environment) }
    new BlogApiComponents(context).application
  }

}
