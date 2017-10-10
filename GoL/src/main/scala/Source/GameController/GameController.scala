package Source.GameController

import Source.GameEngine._
import Source.GameView._

import scala.collection.immutable.Stream.Empty

/**
 * Relaciona o componente View com o componente Model. 
 * 
 * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br
 */

object GameController {

  private val Rules_List:Array[Any] = DependencyInjection.getClasses
  private val Package_N : String = DependencyInjection.getPackageName
  private val GameEngine:GameEngine = new GameEngine

  GameView.UpdateGameEngine(GameEngine)
  
  def start {
    GameEngine.GameMode = Class.forName(Package_N +"."+ Rules_List(0).toString).newInstance.asInstanceOf[EstrategiaDeDerivacao]
    GameEngine.GameMode.UpdateGameEngine(GameEngine)
    GameView.update
  }

  def changeRules: Unit ={
    val Rule:String = GameView.chooseRules(DependencyInjection.getClasses).toString

    GameEngine.GameMode = Class.forName(Package_N +"."+ Rule).newInstance.asInstanceOf[EstrategiaDeDerivacao]
    GameEngine.GameMode.UpdateGameEngine(GameEngine)

    println("\nRule: " + Rule + " is Activated!")
    Thread.sleep(1000)
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