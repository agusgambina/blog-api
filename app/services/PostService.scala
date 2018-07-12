package services

import models.Post

trait PostService {

  def getPosts: List[Post]

}
