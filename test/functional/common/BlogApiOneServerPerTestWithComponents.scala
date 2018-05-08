package functional.common

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.components.{OneServerPerTestWithComponents}

trait BlogApiOneServerPerTestWithComponents extends PlaySpec with OneServerPerTestWithComponents with BlogApiComponentsTest {

}

