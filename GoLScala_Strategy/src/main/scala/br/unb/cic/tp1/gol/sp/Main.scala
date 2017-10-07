package br.unb.cic.tp1.gol.sp

/**
 * Programa principal do GoL.
 *baseado na implementacao de Breno Xavier, utilizando padrão de design template method
 */
object Main {
  
  val height = 10
  val width = 10
  
  def main(args: Array[String]){
    GameController.start
  }
}