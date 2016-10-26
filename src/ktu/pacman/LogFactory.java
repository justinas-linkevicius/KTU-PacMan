/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author Justinas
 */
public class LogFactory {
   public ILogger getLogger(String loggerType){
      if(loggerType == null){
         return null;
      }		
      if(loggerType.equalsIgnoreCase("consoleLogger")){
         return ConsoleLogger.getInstance();
         
      } else if(loggerType.equalsIgnoreCase("fileLogger")){
         return FileLogger.getInstance();
      } 
      
      return null;
   }   
}
