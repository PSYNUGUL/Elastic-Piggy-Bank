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
public class ElasticTester {

  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1)
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25)
      return false;
    return true;
  }

  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("GOLD", 50));
    two.addCoin(new Coin("NICKEL", 5));
    if (one.getBalance() != 51)
      return false;
    if (two.getBalance() != 5)
      return false;
    return true;
  }

  /**
   * tests getCoins() method with different cases
   * 
   * case 1 - two coins added 
   * case 2 - three coins added 
   * case 3 - one coin added
   * 
   * @return true when method works as expected
   */
  public static boolean testGetCoins() {
    ElasticBank one = new ElasticBank();

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));

    String coins = "(PENNY, 1) (DIME, 10)";
    if (!one.getCoins().equals(coins)) {
      return false;
    }

    ElasticBank two = new ElasticBank();

    two.addCoin(new Coin("QUARTER", 25));
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("WON", 10000));

    String coins1 = "(QUARTER, 25) (PENNY, 1) (WON, 10000)";
    if (!two.getCoins().contentEquals(coins1)) {
      return false;
    }

    ElasticBank three = new ElasticBank();

    three.addCoin(new Coin("GOLD", 50));

    String coins2 = "(GOLD, 50)";
    if (!three.getCoins().equals(coins2)) {
      return false;
    }

    return true;
  }

  /**
   * tests empty() method with different cases
   * 
   * case 1 - one coin added and empty it 
   * case 2 - five same coins added and empty it case 3 - four
   * different coins added and empty it
   * 
   * @return true when method works as expected
   */
  public static boolean testEmpty() {
    ElasticBank one = new ElasticBank(2);
    ElasticBank two = new ElasticBank(7);

    one.addCoin(new Coin("PENNY", 1));
    one.empty();
    if (one.getCoins() != "") {
      return false;
    }

    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.empty();
    if (one.getCoins() != "") {
      return false;
    }

    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("DIME", 10));
    two.addCoin(new Coin("iPad", 100));
    two.addCoin(new Coin("PENNY", 1));
    two.empty();
    if (two.getCoins() != "") {
      return false;
    }
    return true;

  }

  /**
   * tests removeCoin() method with different cases
   * 
   * case 1 - two coins added and removed one 
   * case 2 - four coins added and removed and removed two
   * case 3- two coins added and removed one
   * 
   * @return true when method works as expected
   */
  public static boolean testRemoveCoin() {

    ElasticBank two = new ElasticBank(3);
    two.addCoin(new Coin("DIME", 10));
    two.addCoin(new Coin("GOLD", 50));
    two.removeCoin();

    if (two.getSize() != 1) {
      return false;
    }
    ElasticBank one = new ElasticBank();
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("GOLD", 50));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("GOLD", 50));
    one.removeCoin();
    one.removeCoin();

    if (one.getSize() != 2) {
      return false;
    }
    ElasticBank three = new ElasticBank();
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("GOLD", 50));
    three.removeCoin();

    if (three.getSize() != 1) {
      return false;
    }
    return true;
  }

  /**
   * tests getSize() method with different cases
   * 
   * @return true when method works as expected
   */
  public static boolean testGetSize() {
    ElasticBank one = new ElasticBank();
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));;
    if (one.getSize() != 2) {
      return false;
    }

    ElasticBank two = new ElasticBank(2);
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    if (two.getSize() != 3) {
      return false;
    }

    ElasticBank three = new ElasticBank(5);
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("DIME", 10));
    if (three.getSize() != 5) {
      return false;
    }

    return true;
  }



  public static void main(String[] args) {

    System.out.println("Testing coinInstantiableClass() method: " + testCoinInstantiableClass());

    System.out.println("Testing balanceAccessors() method: " + testBalanceAccessors());

    System.out.println("Testing getCoins() method: " + testGetCoins());

    System.out.println("Testing empty() method: " + testEmpty());

    System.out.println("Testing getSize() method: " + testGetSize());

    System.out.println("Testing removeCoin() method: " + testRemoveCoin());

  }

}
