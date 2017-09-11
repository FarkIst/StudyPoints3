/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Farkas
 */
public class CalculationResult {
   public String operation;  
   public int result;

  public CalculationResult(String operation, int result) {
    this.operation = operation;
    this.result = result;
  }
   
}