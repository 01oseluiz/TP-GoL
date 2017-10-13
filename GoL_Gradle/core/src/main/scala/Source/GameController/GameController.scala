package main.scala.Source.GameController

import com.badlogic.gdx.Game
import main.scala.Source.GameView._
import main.scala.Source.GameEngine.{GameEngine, EstrategiaDeDerivacao}

object GameController extends Game{

  /**
    *O app eh lancado sem a atribuicao new GameEngine para GameEngine apenas
    */

//  private val Rules_List:Array[Any] = DependencyInjection.getClasses
//  private val Package_N: String = DependencyInjection.getPackageName
//  private val GameEngine: GameEngine = new GameEngine
//
//  GameView.UpdateGameEngine(GameEngine)
//
//  def start {
//    GameEngine.GameMode = Class.forName(Package_N +"."+ Rules_List(0).toString).newInstance.asInstanceOf[EstrategiaDeDerivacao]
//    GameEngine.GameMode.UpdateGameEngine(GameEngine)
//    GameView.update
//  }
//
//  def changeRules: Unit ={
//    val Rule:String = GameView.chooseRules(DependencyInjection.getClasses).toString
//
//    GameEngine.GameMode = Class.forName(Package_N +"."+ Rule).newInstance.asInstanceOf[EstrategiaDeDerivacao]
//    GameEngine.GameMode.UpdateGameEngine(GameEngine)
//
//    println("\nRule: " + Rule + " is Activated!")
//    Thread.sleep(1000)
//    GameView.update
//  }
//
//  def halt() {
//    //oops, nao muito legal fazer sysout na classe Controller
//    println("\n \n")
//    Statistics.display
//    System.exit(0)
//  }
//
//  def makeCellAlive(i: Int, j: Int) {
//    try {
//      GameEngine.makeCellAlive(i, j)
//      GameView.update
//    }
//    catch {
//      case ex: IllegalArgumentException => {
//        println(ex.getMessage)
//      }
//    }
//  }
//
//  def nextGeneration {
//    GameEngine.nextGeneration
//    GameView.update
//  }

  /** SEM EFEITO, MUDAR ESSA GameView.update A FIM DE DAR UM JEITOOOOOOOOOOOOO
    * Executado assim que o app eh iniciado
    */
  def create(): Unit = {
    while(GameView == null/* || GameView.screen == null*/){}
    setScreen(new GameScreen{}) //Mudando para a tela do jogo
  }

  /**
    * Redefine as dimensoes da janela sempre que o jogo eh colocado em foco
    */
  override def resize(width: Int, height: Int): Unit = {
    super.resize(width, height)
  }

  /**
    * Renderiza constantemente. A mesma coisa que a update
    */
  override def render(): Unit = {
    super.render()
  }

  /**
    * Executado quando jogo fica fora de foco
    */
  override def pause(): Unit = {
    super.pause()
  }

  /**
    * Executado quando jogo volta a ser o foco
    */
  override def resume(): Unit = {
    super.resume()
  }

  /**
    * Usado para liberar espaco na memoria quando nao se utiliza mais um recurso
    */
  override def dispose(): Unit = {
    super.dispose()
  }



}
