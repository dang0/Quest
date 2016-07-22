package view

import scala.swing.Panel
import java.awt.Graphics2D
import model.PlayerState

object Player extends Panel {
  opaque = false
  override def paintComponent(g: Graphics2D) {
    super.paintComponent(g)
//    g.drawRect(PlayerState.locX+200, PlayerState.locY+200, 20, 40)
    g.drawRect(200, 200, 20, 40)
  }
  
  def update() {
    repaint
  }
}