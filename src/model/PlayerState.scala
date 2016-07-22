package model

import scala.swing.Component
import java.awt.Graphics2D
import view.GameArea

object PlayerState {
  
  var maxhp = 10
  var curhp = 7
  var title = "Playername"
  var locX, locY = 200
  var speed = 4
  var playerSize = (20,40)
  def loc = (locX,locY)
  var up, down, left, right, jumping, grounded, attack = false
  var jCounter = 0
  var dX, dY = 0
  def update() {
    
    if(dY > 20) dY = 20
    else if(dY < -20) dY = -20
    if(dX > 10) dX = 10
    else if(dX < -10) dX = -10
    if(left) {
      dX -= speed
    }
    else if(dX > 0) dX -= 1
    else if(dX < 0) dX += 1
    if(right) {
      dX += speed
    }
    else if(dX > 0) dX -= 1
    else if(dX < 0) dX += 1
    if(jCounter > 0) {
      dY -= speed * 3
      jCounter -= 1
    }
//    if(up) {
//      dY -= speed
//    }
//    if(down) {
//      dY += speed
//    }
    else if(!grounded){
      dY += speed / 2
    } else dY = speed
    if(jumping) {
      jump
    }
    
    
    if(dX != 0 || dY != 0){
      if(!GameArea.validLocY(locY+playerSize._2+1)) grounded = true
      else grounded = false
      move(dX, dY)
    }
    
  }
  
  def jump() {
    if(grounded) {
      jCounter = 3
    }
    
  }
  def move(dX: Int, dY: Int) {
    var nx = dX
    var ny = dY
//    val check = GameArea.validLoc((locX+dX), (locY+dY), playerSize)
//    if(check._1) locX += dX
    while(!GameArea.validLocX(locX+nx) || !GameArea.validLocX(locX+nx+playerSize._1)) {
      if(nx > 0) nx -= 1
      else nx += 1
    }
    locX += nx
//    if(check._2) {
//      locY += dY
//      grounded = false
//    }
    while(!GameArea.validLocY(locY+ny) || !GameArea.validLocY(locY+ny+playerSize._2)) {
      if(ny > 0) ny -= 1
      else ny += 1
    }
    locY += ny
  }
  def moveX(dX: Int) {
  }
  
}