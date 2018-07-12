package functional.common

import common.BlogApiComponents
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.components.OneAppPerSuiteWithComponents
import play.api.{BuiltInComponents, Configuration}

class BlogApiOneAppPerSuiteWithComponents extends PlaySpec
  with OneAppPerSuiteWithComponents
  with BlogApiDBTest {

  override def components: BlogApiComponents = new BlogApiComponents(context) {
    override lazy val configuration: Configuration = context.initialConfiguration
    override lazy val database = testDatabase
  }
}

