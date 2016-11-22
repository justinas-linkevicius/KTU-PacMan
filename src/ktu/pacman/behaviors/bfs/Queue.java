/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ktu.pacman.behaviors.bfs;

/*
 * The Queue class consists of two references:
 *   front, a reference to the first QCell in the queue,
 *          which is the first to go on a call to dequeue.
 *   back,  a reference to the last QCell in the queue,
 *          which is where new QCells are enqueued.
 */

class Queue
{
  
  /*
   * The data members
   */

  protected QCell front;
  protected QCell back;
  
  /*
   * Constructor for an empty Queue, in which
   *  both the front and the back are null references.
   */
  
  Queue()
  {
    front = null;
     back = null;
  }
  
  /*
   * The static and nonstatic is_empty methods.
   * A Queue is empty if either of its front
   *   or back QCell references is null.
   */
  
  public boolean is_empty() 
  {
    return (front == null);
  }

  public static boolean is_empty(Queue Q) 
  {
    return Q.is_empty();
  }
  
  /*
   * The static and nonstatic enqueue methods.
   * A new QCell is created and placed at the back of
   *   the queue. The previous back (if any)
   *   is adjusted to point to the new back.
   * The front is set to the same QCell if the Queue
   *   was originally empty.
   */
  
  public void enqueue(Object o)
  {
    QCell newCell = new QCell(o,null);
    
    if (back == null) {
      back = front = newCell;
    } else {
      back.next = newCell;
      back = newCell;    
    }

  }
  
  public static void enqueue(Object o, Queue Q)
  {
    Q.enqueue(o);  
  }
  
  /*
   * The static and nonstatic dequeue methods.
   * If there is only one QCell remaining, its data
   *   is returned and both the Queue's front and back are
   *   set to null, since the resulting Queue is empty.
   * If there are more than one QCell in the Queue,
   *   the data of the one in the front is returned and
   *   the front refernce is adjusted to refer to
   *   the next QCell in line.
   */
  
  public Object dequeue()
  {
    Object retVal = front.data;
    front = front.next;
    if (front == null) back = null;
    return retVal;
  }
  
  public static Object dequeue(Queue Q)
  {
    return Q.dequeue();  
  }
  
  /*
   * toString() is a nonstatic method that returns a string representation of
   *            the Queue that invokes this method. It may be invoked implicitly
   *            when a Queue is an argument to the + operator and another String.
   */

  public String toString()
  {
    StringBuffer theFullAnswer = new StringBuffer();  // now it's ""
    theFullAnswer.append("The Queue (or derived class) is\n"); 

    QCell current = this.front;
    while (current != null) {
      theFullAnswer.append("  " + current.data + "\n");
      current = current.next;
    }
    theFullAnswer.append("\n");
    return theFullAnswer.toString();
  }
}

