package view

import scala.swing.Panel
import scala.swing.BorderPanel
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import scala.swing.Swing
import java.awt.Graphics2D
import javax.swing.JLayeredPane
import javax.swing.OverlayLayout
import scala.swing.Orientation
import scala.swing.BoxPanel
import scala.swing.Component
import java.awt.Container
import model.PlayerState
import controller.KeyboardController

object GameArea extends Panel with KeyboardController {
  def MAPSIZE_H = 9
  def MAPSIZE_W = MAPSIZE_H
  preferredSize = new Dimension(400,400)
  val overlay = new StatusOverlay
  val tilemap = new TileMap
  
  peer.setLayout(new OverlayLayout(peer))
  val myContents = new Content +=
    (overlay,
     Player,
     tilemap
    ) 
  override def contents = myContents

  def update() {
    requestFocus
    requestFocusInWindow
//    overlay.update
//    tilemap.update
//    Player.update
    repaint
    overlay.update
  }
  
   def validLoc(dx: Int, dy: Int, pSize: (Int,Int)): (Boolean,Boolean) = {
     var vx,vy = true
     val pxy1 = (dx/50, dy/50)
     val pxy2 = ((dx + pSize._1)/50, dy/50)
     val pxy3 = (dx/50, (dy + pSize._2)/50)
     val pxy4 = ((dx + pSize._1)/50, (dy + pSize._2)/50)
     
     if(dx < 0 || pxy4._1 > 127) vx = false
     else if(tilemap.tiles(PlayerState.locY/50)(pxy1._1) == 1) vx = false
     else if(tilemap.tiles(PlayerState.locY/50)(pxy2._1) == 1) vx = false
     else if(tilemap.tiles((PlayerState.locY + pSize._2)/50)(pxy3._1) == 1) vx = false
     else if(tilemap.tiles((PlayerState.locY + pSize._2)/50)(pxy4._1) == 1) vx = false
     if(dy < 0 || pxy4._2 > 9) vy = false
     else if(tilemap.tiles(pxy1._2)(PlayerState.locX/50) == 1) vy = false
     else if(tilemap.tiles(pxy2._2)((PlayerState.locX + pSize._1)/50 ) == 1) vy = false
     else if(tilemap.tiles(pxy3._2)(PlayerState.locX /50) == 1) vy = false
     else if(tilemap.tiles(pxy4._2)((PlayerState.locX + pSize._1)/50) == 1) vy = false
     (vx,vy)
  }
   def validLocX(dx: Int): Boolean = {
     if(dx < 0 || (dx + PlayerState.playerSize._1)/50 > 127) false
     else if(tilemap.tiles(PlayerState.locY/50)(dx/50) == 1) false
     else if(tilemap.tiles((PlayerState.locY + PlayerState.playerSize._2)/50)(dx/50) == 1) false
     else true
  }
    def validLocY(dy: Int): Boolean = {
     if(dy < 0 || (dy + PlayerState.playerSize._2)/50 > 9) false
     else if(tilemap.tiles(dy/50)(PlayerState.locX/50) == 1) false
     else if(tilemap.tiles(dy/50)((PlayerState.locX + PlayerState.playerSize._1)/50) == 1) false
     else true
  }
}
