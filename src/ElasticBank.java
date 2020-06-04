import java.util.Arrays;
import java.util.Random;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ElasticBank
// Files: ElasticBank.java , ElasticTester.java, Coin.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
public class ElasticBank {
  private Coin[] coins;
  private int size;
  private int expansionsLeft;
  private static Random rand = new Random(99);

  /**
   * Creates ElasticBank by setting default size and initializing coins array with its size
   */
  public ElasticBank() {
    this.size = 10;
    this.coins = new Coin[this.size];
    this.expansionsLeft = 2;

  }

  /**
   * Creates ElasticBank by setting size as given initialCapacity and initializing coins array with
   * its size
   */
  public ElasticBank(int initialCapacity) {
    this.size = initialCapacity;
    this.coins = new Coin[this.size];
    this.expansionsLeft = 2;
  }

  /**
   * @return integer value of coin array capacity
   */
  public int capacity() {
    return size;

  }

  /**
   * @return the amount of expansionsLeft for coin array before and after the spill
   */
  public int getExpansions() {

    return expansionsLeft;
  }

  /**
   * Calculates the size by inspecting each array position's element
   * 
   * @return integer value of total amount of non-null elements in coin array
   */
  public int getSize() {
    int sum = 0;
    for (int i = 0; i < this.size; i++) {
      if (this.coins[i] != null)
        sum++;
    }
    return sum;
  }

  /**
   * Calculates the amount of balance by inspecting each array position's value
   * 
   * @return integer value of total amount of values in coin array
   */
  public int getBalance() {
    int balance = 0;

    for (int i = 0; i < this.size; i++) {
      if (this.coins[i] != null) {
        balance += this.coins[i].getValue();
      }
    }
    return balance;

  }

  /**
   * Formats the given coins into String
   * 
   * @return string value of coins given without spaces at front and back
   */
  public String getCoins() {
    String coin = "";
    String format = "";
    for (int i = 0; i < this.size; i++) {
      if (this.coins[i] != null) {
        format = "(" + this.coins[i].getName() + ", " + this.coins[i].getValue() + ") ";
        coin += format;
      }
    }
    return coin.trim();
  }

  /**
   * Removes a Coin from coins at random and returns it, replacing it with null reference in coins
   * array
   * 
   * @return Coin value of the removed Coin
   */
  public Coin removeCoin() {
    Coin coinRemoved = null;
    int select = rand.nextInt(this.size);

    if (this.coins[select] != null) {
      coinRemoved = this.coins[select];
      this.coins[select] = null;
      size--;
    } else if (this.coins[select] == null) {
      while (this.coins[select] == null) {
        select = rand.nextInt(this.size);
      }

      if (this.coins[select] != null) {
        coinRemoved = this.coins[select];
        this.coins[select] = null;
        size--;
      }
    }



    return coinRemoved;
  }

  /**
   * Replaces all elements in coin array with null reference
   */
  public void empty() {
    if (this.size == 0 || coins.length == 0) {
      System.out.println("The Elastic Piggy bank is already empty.");

    } else {
      for (int i = 0; i < this.size; i++) {
        coins[i] = null;
      }

    }
  }

  /**
   * Adds coin into Coin array If the inspected coin position has null reference, add Coin value to
   * array If the inspected coin array is full, use expansionsLeft to get 10 additional space Then,
   * add coins into the new copied array
   */
  public void addCoin(Coin c) {

    Coin[] newCoins = null;
    boolean space = false;
    int spaceIndex = 0;

    for (int i = 0; i < this.size; i++) {
      if (this.coins[i] == null) {
        spaceIndex = i;
        space = true;
        // break to not replace every element with Coin c
        break;
      }
    }

    // empty space --> same as P01
    if (space) {
      this.coins[spaceIndex] = c;
    }

    // full --> create new array w/ 10 additional spaces
    // copy contents of previous array and add new Coin
    // decrement expansionsLeft
    else {
      if (this.expansionsLeft != 0) {
        this.size += 10;
        this.expansionsLeft--;
        newCoins = Arrays.copyOf(coins, this.size);
        this.coins = newCoins;
        for (int i = 0; i < this.size; i++) {
          if (this.coins[i] == null) {
            this.coins[i] = c;
            // break to not replace every element with Coin c
            break;
          }
        }
      }

      // no expansionLeft --> expansionLeft = 0
      // use empty() and add Coin to now-empty ElasticBank
      else {
        empty();
        spaceIndex++;
        this.coins[spaceIndex] = c;
      }
    }

  }
}


