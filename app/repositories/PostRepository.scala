package repositories

import models.Post
import requests.PostRequest

trait PostRepository {

  def create(postRequest: PostRequest): Option[Long]
  def findById(postId: Long): Option[Post]
  def findAll: List[Post]

}
