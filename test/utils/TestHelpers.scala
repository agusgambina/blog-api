package utils

import scala.util.Random

object TestHelpers {

  val maxWordLength = 30
  val maxTitleLength = 3
  val maxBodyLength = 3

  def randomId = Random.nextInt(Integer.MAX_VALUE)

  def randomPostTitle = LoremIpsum.getWords(Random.nextInt(maxTitleLength)+1)

  def randomPostBody = LoremIpsum.getParagraphs(Random.nextInt(maxBodyLength)+1)


}
