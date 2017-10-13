package main.scala.GameRules

import main.scala.Source.GameEngine.EstrategiaDeDerivacao
import org.springframework.context.annotation._

/**
  * Regras do Jogo da Vida no modo High Life
  *
  * baseado na implementacao de Breno Xavier, utilizando padrão de design template method
  */

@Configuration
@Bean
class HighLife extends EstrategiaDeDerivacao{

  /* verifica se uma celula deve ser mantida viva */
  override def shouldKeepAlive(i: Int, j: Int): Boolean = {
          GameEngine.cells(i)(j).isAlive &&
          (GameEngine.numberOfNeighborhoodAliveCells(i, j) == 2 ||
          GameEngine.numberOfNeighborhoodAliveCells(i, j) == 3)
  }

  /* verifica se uma celula deve (re)nascer */
  override def shouldRevive(i: Int, j: Int): Boolean = {
        (!GameEngine.cells(i)(j).isAlive) &&
        (GameEngine.numberOfNeighborhoodAliveCells(i, j) == 3 ||
        GameEngine.numberOfNeighborhoodAliveCells(i, j) == 6)
  }
}
