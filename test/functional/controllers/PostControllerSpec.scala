//package functional.controllers
//
//import functional.common.BlogApiOneAppPerSuiteWithComponents
//import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
//import play.api.mvc.Results
//import play.api.test.{FakeRequest, Helpers}
//import play.api.test.Helpers._
//
//class PostControllerSpec extends BlogApiOneAppPerSuiteWithComponents
//  with Results
//  with ScalaFutures
//  with IntegrationPatience {
//
//  "Server query should" should {
//    "provide an Application" in {
//      val Some(result) = route(app, FakeRequest(GET, "/posts"))
//      Helpers.contentAsString(result) must be("success!")
//    }
//  }
//
//}