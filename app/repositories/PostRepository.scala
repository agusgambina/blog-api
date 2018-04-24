package repositories

import models.Post

trait PostRepository {

  def find: Either[String, List[Post]]

}
