package controllers

import play.api.libs.json.Json
import play.api.libs.json.Json._
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.PostService

class PostController (val controllerComponents: ControllerComponents,
                      postService: PostService) extends BaseController {

  def index: Action[AnyContent] = Action {
    postService.getPosts.fold(
      error => BadRequest(Json.obj("error" -> true, "message" -> error)),
      postList => Ok(Json.obj("error" -> false, "posts" -> postList))
    )
  }

}
