package services

import models.Post

trait PostService {

  def get: List[Post]

}
