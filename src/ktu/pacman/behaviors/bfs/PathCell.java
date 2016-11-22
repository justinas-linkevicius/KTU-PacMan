/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.behaviors.bfs;


/*
 * The PathCell class implements a single cell of 
 *   a maze. It includes private data fields that
 *   tell 
 *     whether a cell is marked (already visited by the BFS)
 *     what a cell's contents are
 *     what a cell's parent is (for the BFS)
 *     what the cell's position is in the maze
 */
class PathCell {

    private boolean marked;
    private char contents;
    private PathCell parent;
    private int x, y;

    /*
     * The constructor for MazeCells. The cells are by default
     *   unmarked and without a parent cell. To construct a new cell,
     *   its position in the maze (x,y) and its contents '|', '-', 'X', or 'S'
     *   must be specified.
     */
    public PathCell(int x, int y, char c) {
        marked = false;
        contents = c;
        parent = null;

        this.x = x;
        this.y = y;
    }

    /*
     * A public nonstatic accessor method that returns the contents
     *   of the PathCell that invokes it.
     */
    public char getContents() {
        return this.contents;
    }

    /*
     * A public nonstatic method that changes marked value 
     *   of the PathCell to ture that invokes it.
     */
    public void Mark() {
        marked = true;
    }

    /*
     * A public nonstatic accessor method that returns the marked value
     *   of the PathCell that invokes it.
     */
    public boolean isMarked() {
        return this.marked;
    }

    /*
     * A public nonstatic accessor method that returns the parent
     *   of the PathCell that invokes it.
     */
    public PathCell getParent() {
        return this.parent;
    }

    /*
     * A public nonstatic method that changes parent value 
     *   of the PathCell to parent that invokes it.
     */
    public void changeParent(PathCell child) {
        child.parent = this;
    }

    /*
     * A public nonstatic accessor method that returns the x
     *   of the PathCell that invokes it.
     */
    public int xValue() {
        return this.x;
    }

    /*
     * A public nonstatic accessor method that returns the y
     *   of the PathCell that invokes it.
     */
    public int yValue() {
        return this.y;
    }

    /*
     * A public nonstatic method that changes contents value 
     *   of the PathCell to '*' that invokes it.
     */
    public void star() {
        contents = '#';
    }
}
