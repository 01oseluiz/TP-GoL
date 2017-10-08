package Source.GameEngine

/**
  * trait com as definições abstratas das regras de derivação
  */

trait EstrategiaDeDerivacao {

  var GameEngine: GameEngine = new GameEngine

  def UpdateGameEngine(x:GameEngine):Unit = GameEngine = x

  def shouldKeepAlive(i: Int, j: Int): Boolean
  def shouldRevive(i: Int, j: Int): Boolean

}
