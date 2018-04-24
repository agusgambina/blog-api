package functional.common

import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatestplus.play._
import play.api.mvc.Results
import play.api.test.Helpers._
import play.api.test.WsTestClient

class BlogApiServerSpec extends PlaySpec
  with BaseOneServerPerTest
  with Results
  with ScalaFutures
  with IntegrationPatience
  with BlogApiApplicationFactory {

  "Server query should" should {
    "work" in {
      WsTestClient.withClient { implicit client =>
        whenReady(wsUrl("/").get) { response =>
          response.status mustBe NOT_FOUND
        }
      }
    }
  }

}
