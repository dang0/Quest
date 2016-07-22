package view

import scala.swing.Panel
import scala.swing.Swing
import java.awt.image.BufferedImage
import javax.swing.ImageIcon
import scala.swing.Label
import java.awt.Graphics2D
import scala.swing.BorderPanel
import scala.swing.GridPanel
import java.awt.Dimension
import scala.swing.FlowPanel
import scala.swing.Component
import model.PlayerState
import java.awt.Color
import scala.swing.BoxPanel
import scala.swing.Orientation

class StatusOverlay extends BorderPanel {
  opaque = false
  border = Swing.EmptyBorder(10)
  def getHealth: String = {
    ": " + PlayerState.curhp + " / " + PlayerState.maxhp
  }
  var cname = new Label {
    icon = new ImageIcon("src/resource/logo.png")
    text = PlayerState.title }
  var hp = new Label { 
    icon = new ImageIcon("src/resource/btn_close_over.png")
    text = getHealth }
  
  var DEBUG = new BoxPanel(Orientation.Vertical) {
    opaque = false
    val g = new Label {text = "grounded:" + PlayerState.grounded}
    val d = new Label {text = "dx:"+PlayerState.dX + " dy:" + PlayerState.dY}
    contents += (
      g,d
    )
  }
  
  
  val innerPanel = new BoxPanel(Orientation.Vertical) {
    opaque = false
//    contents += (cname,hp)
    contents += DEBUG
  }
  layout(innerPanel) = BorderPanel.Position.West
  
  
  
  override def paintComponent(g: Graphics2D){
    super.paintComponent(g)
  }
  
  def update() {
    DEBUG.g.text = "grounded:" + PlayerState.grounded
    DEBUG.d.text = "dx:"+PlayerState.dX + " dy:" + PlayerState.dY
  }
}
