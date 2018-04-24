package functional.common

import common.BlogApiApplicationLoader
import org.scalatestplus.play.FakeApplicationFactory
import play.api.inject.DefaultApplicationLifecycle
import play.api.{Application, ApplicationLoader, Configuration, Environment}
import play.core.DefaultWebCommands

trait BlogApiApplicationFactory extends FakeApplicationFactory {

  private class BlogApiApplicationBuilder {
    def build(): Application = {
      val env = Environment.simple()
      val context = ApplicationLoader.Context(
        environment = env,
        sourceMapper = None,
        webCommands = new DefaultWebCommands(),
        initialConfiguration = Configuration.load(env),
        lifecycle = new DefaultApplicationLifecycle()
      )
      val loader = new BlogApiApplicationLoader()
      loader.load(context)
    }
  }

  def fakeApplication(): Application = new BlogApiApplicationBuilder().build()

}
