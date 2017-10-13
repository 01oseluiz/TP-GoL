package main.scala.Source.GameEngine

import main.scala.Source.GameView.GameScreen

/**
  * trait com as definicoes abstratas das regras de derivacao
  */

trait EstrategiaDeDerivacao {
  protected var GameEngine: GameEngine =_
  def UpdateGameEngine(x:GameEngine): Unit = GameEngine = x

  def shouldKeepAlive(i: Int, j: Int): Boolean
  def shouldRevive(i: Int, j: Int): Boolean
}