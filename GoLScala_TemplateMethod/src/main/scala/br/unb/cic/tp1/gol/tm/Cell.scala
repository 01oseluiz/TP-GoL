package br.unb.cic.tp1.gol.tm

/**
 * Rerepsentacao de uma celula do GoL 
 * 
 * baseado na implementacao de Breno Xavier, utilizando padrão de design template method
 */
class Cell {
  
  private var alive = false
  
  def isAlive = alive
  
  def kill = alive = false
  def revive = alive = true
}