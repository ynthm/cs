package com.ynthm.command;

public class CommandCalculator {
  public int calculate(Command command) {
    return command.execute();
  }

  public static void main(String[] args) {
    CommandCalculator calculator = new CommandCalculator();
    int result = calculator.calculate(new AddCommand(3, 7));
  }
}
