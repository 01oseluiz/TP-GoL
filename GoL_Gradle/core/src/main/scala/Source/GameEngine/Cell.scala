package main.scala.Source.GameEngine

/**
  * Representacao de uma celula do Gol
  *
  */
class Cell {
  private var alive = true

  def isAlive = alive

  def kill = alive = false
  def revive = alive = true

}
