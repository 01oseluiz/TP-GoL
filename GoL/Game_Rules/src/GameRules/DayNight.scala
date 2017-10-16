package GameRules

import Source.GameEngine.EstrategiaDeDerivacao
import org.springframework.context.annotation._

@Configuration
@Bean
class DayNight extends EstrategiaDeDerivacao{

  /* verifica se uma celula deve ser mantida viva */
  override def shouldKeepAlive(i: Int, j: Int): Boolean = {
        GameEngine.cells(i)(j).isAlive &&
        (GameEngine.numberOfNeighborhoodAliveCells(i, j) == 3 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 6 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 7 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 8)
  }

  /* verifica se uma celula deve (re)nascer */
  override def shouldRevive(i: Int, j: Int): Boolean = {
        (!GameEngine.cells(i)(j).isAlive) &&
        (GameEngine.numberOfNeighborhoodAliveCells(i, j) == 3 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 4 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 5 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 7 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 8)
  }
}
