package com.ynthm.demo.algorithm.currying;

import java.time.LocalDate;
import java.util.function.Function;

/**
 * Currying in Java
 *
 * @author Ethan Wang
 */
public class Letter {
  private String returnAddress;
  private String insideAddress;
  private LocalDate dateOfLetter;
  private String salutation;
  private String body;
  private String closing;

  public Letter(
      String returnAddress,
      String insideAddress,
      LocalDate dateOfLetter,
      String salutation,
      String body,
      String closing) {
    this.returnAddress = returnAddress;
    this.insideAddress = insideAddress;
    this.dateOfLetter = dateOfLetter;
    this.salutation = salutation;
    this.body = body;
    this.closing = closing;
  }

  public static Function<
          String,
          Function<
              String,
              Function<LocalDate, Function<String, Function<String, Function<String, Letter>>>>>>
      LETTER_CREATER =
          returnAddress ->
              insideAddress ->
                  dateOfLetter ->
                      salutation ->
                          body ->
                              closing ->
                                  new Letter(
                                      returnAddress,
                                      insideAddress,
                                      dateOfLetter,
                                      salutation,
                                      body,
                                      closing);

  static AddReturnAddress builder() {
    return returnAddress ->
        closing ->
            dateOfLetter ->
                insideAddress ->
                    salutation ->
                        body ->
                            new Letter(
                                returnAddress,
                                insideAddress,
                                dateOfLetter,
                                salutation,
                                body,
                                closing);
  }

  interface AddReturnAddress {
    Letter.AddClosing withReturnAddress(String returnAddress);
  }

  interface AddClosing {
    Letter.AddDateOfLetter withClosing(String closing);
  }

  interface AddDateOfLetter {
    Letter.AddInsideAddress withDateOfLetter(LocalDate dateOfLetter);
  }

  interface AddInsideAddress {
    Letter.AddSalutation withInsideAddress(String insideAddress);
  }

  interface AddSalutation {
    Letter.AddBody withSalutation(String salutation);
  }

  interface AddBody {
    Letter withBody(String body);
  }

  @Override
  public String toString() {
    return "Letter{"
        + "returnAddress='"
        + returnAddress
        + '\''
        + ", insideAddress='"
        + insideAddress
        + '\''
        + ", dateOfLetter="
        + dateOfLetter
        + ", salutation='"
        + salutation
        + '\''
        + ", body='"
        + body
        + '\''
        + ", closing='"
        + closing
        + '\''
        + '}';
  }

  public String getReturnAddress() {
    return returnAddress;
  }

  public void setReturnAddress(String returnAddress) {
    this.returnAddress = returnAddress;
  }

  public String getInsideAddress() {
    return insideAddress;
  }

  public void setInsideAddress(String insideAddress) {
    this.insideAddress = insideAddress;
  }

  public LocalDate getDateOfLetter() {
    return dateOfLetter;
  }

  public void setDateOfLetter(LocalDate dateOfLetter) {
    this.dateOfLetter = dateOfLetter;
  }

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getClosing() {
    return closing;
  }

  public void setClosing(String closing) {
    this.closing = closing;
  }

  public static void main(String[] args) {

    Letter apply =
        LETTER_CREATER
            .apply("return address")
            .apply("inside address")
            .apply(LocalDate.now())
            .apply("salutation")
            .apply("body")
            .apply("closing");
    System.out.println(apply);

    Letter letter =
        Letter.builder()
            .withReturnAddress("return address")
            .withClosing("closing")
            .withDateOfLetter(LocalDate.now())
            .withInsideAddress("inside address")
            .withSalutation("salutation")
            .withBody("body");
    System.out.println(letter);
  }
}
