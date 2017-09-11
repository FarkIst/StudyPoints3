/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

/**
 *
 * @author Farkas
 */
public class ErrorMessage {

  public ErrorMessage(String  msg, int code) {
    this.code = code;
    this.message = msg;        
  }

  private int code;
  private String message;
}