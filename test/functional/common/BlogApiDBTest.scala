package functional.common

import play.api.db.Databases
import play.api.db.evolutions.Evolutions

trait BlogApiDBTest {

  implicit val testDatabase = Databases.inMemory(
    name = "default",
    urlOptions = Map(
      "MODE" -> "MYSQL"
    ),
    config = Map(
      "logStatements" -> true
    )
  )

  /*
    Gracias a esta linea de codigo H2 no reemplaza el null y podemos testear
    la restriction de NOT NULL de MySql
  */
  org.h2.engine.Mode.getInstance("MYSQL").convertInsertNullToZero = false
  Evolutions.applyEvolutions(testDatabase)
}
