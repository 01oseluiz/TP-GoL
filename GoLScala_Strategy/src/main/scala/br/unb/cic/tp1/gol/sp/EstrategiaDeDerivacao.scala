package br.unb.cic.tp1.gol.sp

/**
  * trait com as definições abstratas das regras de derivação
  */

abstract class EstrategiaDeDerivacao {

  def shouldKeepAlive(i: Int, j: Int): Boolean

  def shouldRevive(i: Int, j: Int): Boolean

}
