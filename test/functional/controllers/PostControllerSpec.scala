package functional.controllers

import functional.common.BlogApiOneServerPerTestWithComponents
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import play.api.mvc.{Result, Results}
import play.api.test.{FakeRequest, Helpers, WsTestClient}

import scala.concurrent.Future

import play.api.test.Helpers.{GET, route}

class PostControllerSpec extends BlogApiOneServerPerTestWithComponents
  with Results
  with ScalaFutures
  with IntegrationPatience {

  "Server query should" should {
    "provide an Application" in {
      val Some(result) = route(app, FakeRequest(GET, "/posts"))
      Helpers.contentAsString(result) must be("success!")
    }
  }

}