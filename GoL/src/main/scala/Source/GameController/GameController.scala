package Source.GameController

import GameRules.HighLife
import Source.GameEngine._
import Source.GameView._

import scala.collection.immutable.Stream.Empty

/**
 * Relaciona o componente View com o componente Model. 
 * 
 * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br
 */

object GameController {

  var GameEngine:GameEngine = _
  
  def start {
    GameEngine = DependencyInjection.setRule("Classic").asInstanceOf[GameEngine]
    GameEngine.GameMode.UpdateGameEngine(GameEngine)
    GameView.update
  }

  def halt() {
    //oops, nao muito legal fazer sysout na classe Controller
    println("\n \n")
    Statistics.display
    System.exit(0)
  }

  def makeCellAlive(i: Int, j: Int) {
    try {
			GameEngine.makeCellAlive(i, j)
			GameView.update
		}
		catch {
		  case ex: IllegalArgumentException => {
		    println(ex.getMessage)
		  }
		}
  }
  
  def nextGeneration {
    GameEngine.nextGeneration
    GameView.update
  }
  
}