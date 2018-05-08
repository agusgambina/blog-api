package functional.common

import common.BlogApiComponents
import org.scalatestplus.play.components.WithApplicationComponents
import play.api.{BuiltInComponents, Configuration}

trait BlogApiComponentsTest extends WithApplicationComponents with BlogApiDBTest {

  override def components: BuiltInComponents = new BlogApiComponents(context) {
    override lazy val configuration: Configuration = context.initialConfiguration
    override lazy val blogDatabase = testDatabase
  }


}
