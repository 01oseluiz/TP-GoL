package Source.GameEngine

/**
  * trait com as definições abstratas das regras de derivação
  */

trait EstrategiaDeDerivacao {

  protected var GameEngine: GameEngine = _
  def UpdateGameEngine(x:GameEngine):Unit = GameEngine = x

  def shouldKeepAlive(i: Int, j: Int): Boolean
  def shouldRevive(i: Int, j: Int): Boolean

}
