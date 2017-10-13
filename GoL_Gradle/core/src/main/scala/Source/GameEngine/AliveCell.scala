package main.scala.Source.GameEngine

import com.badlogic.gdx.math.Vector2

/**
  * Classe para armazenar a celula e sua posicao
  * @param pos Posicao da celula na tela
  * @param cell Celula a ser desenhada
  */
class AliveCell(pos: Vector2, cell: Cell) {
  def x: Float = pos.x              //
  def y: Float = pos.y
  def alive: Boolean = cell.isAlive
  def kill = cell.kill
  def revive = cell.revive
}
