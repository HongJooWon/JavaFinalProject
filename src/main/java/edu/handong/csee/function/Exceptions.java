package edu.handong.csee.function;

public class Exceptions extends Exception {
   public Exceptions() {
      super("No CLI argument Exception! Please put a file path.");
   }
   public Exceptions(String message) {
      super(message);
   }
}