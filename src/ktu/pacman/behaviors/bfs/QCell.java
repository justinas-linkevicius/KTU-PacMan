/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ktu.pacman.behaviors.bfs;

/*
 * QCell class
 */

class QCell
{

  /*
   * The data members
   */

  protected Object    data;          // Storage for the data
  protected QCell     next;          // A reference to the next QCell
                                     //   in the Queue
  
  /*
   * Constructor requiring the Object to be stored
   *   and the QCell that the next field refers to.
   */
  
  QCell(Object o, QCell next)
  {
    this.data = o;
    this.next = next;  
  }
  
}