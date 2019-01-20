

import java.util.Date;
import java.util.Random;

/**

 *
 * If we pick an integer in [1,1M] randomly, how likely is it to get one whose digit sum is divisible by 7?
 *
 * Compute the probability by sampling 10% of those integers and store the sample in a collection.
 *
 * Here we use an array to represent the collection.
 */
public class SumDiv7_Array
{
    private int population;  // population size
    private int sample;  // sample size
    private Random rng;
    private int count;  // count of samples meeting criterion
    private int[] bag;  // random sample set

    public SumDiv7_Array(int population, double samplingPercentage)
    {
        this.population = population;
        this.sample = (int) (population * samplingPercentage);
        this.rng = new Random();
        this.count = 0;
        this.bag = new int[this.sample + 1]; // create array
    }

    public void simulate()
    {
        for (int i = 0; i < this.sample; i++)
        {
            // pick a distinct int from population
            // if it fits the criterion, count it
            int n = pickDistinct();
            this.bag[i] = n;  // store sample in array
            int sum = digitSum(n);
            if (sum % 7 == 0) this.count++;  // if it meets criterion, count it
        }
    }

    private int pickDistinct()
    {
        int n;
        do
        {
            n = 1 + rng.nextInt(this.population);
        } while (contains(this.bag, this.count, n));
        return n;
    }

    // return true or false depending on whether x is in ar
    private boolean contains(int[] ar, int size, int x)
    {
        boolean found = false;
        for (int i = 0; (i < size) && !found; i++)
        {
            found = (ar[i] == x);
        }
        return found;
    }

    // return the sum of the digits of x
    private int digitSum(int x)
    {
        int sum = 0;
        for (int r = x; r != 0; r = r / 10)
        {
            int digit = r % 10;
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        long start = (new Date()).getTime();

        SumDiv7_Array var = new SumDiv7_Array(1000000, .1);
        var.simulate();
        System.out.println("Probalility of meeting criterion is " + var.count / (double) var.sample);
        System.out.println("Sample is ");
        for (int i = 0; i < var.count; i++)
        {
            System.out.print(var.bag[i] + " ");
        }

        long finish = (new Date()).getTime();

        System.out.println("\nRunning time was " + (finish-start) + " ms.");


    }
}




import java.util.Date;
import java.util.Random;

/**
 
 *
 * If we pick an integer in [1,1M] randomly, how likely is it to get one whose digit sum is divisible by 7?
 *
 * Compute the probability by sampling 10% of those integers and store the sample in a collection.
 *
 * Here we use an array to represent the collection.
 */
public class SumDiv7_Array
{
    private int population;  // population size
    private int sample;  // sample size
    private Random rng;
    private int count;  // count of samples meeting criterion
    private int[] bag;  // random sample set

    public SumDiv7_Array(int population, double samplingPercentage)
    {
        this.population = population;
        this.sample = (int) (population * samplingPercentage);
        this.rng = new Random();
        this.count = 0;
        this.bag = new int[this.sample + 1]; // create array
    }

    public void simulate()
    {
        for (int i = 0; i < this.sample; i++)
        {
            // pick a distinct int from population
            // if it fits the criterion, count it
            int n = pickDistinct();
            this.bag[i] = n;  // store sample in array
            int sum = digitSum(n);
            if (sum % 7 == 0) this.count++;  // if it meets criterion, count it
        }
    }

    private int pickDistinct()
    {
        int n;
        do
        {
            n = 1 + rng.nextInt(this.population);
        } while (contains(this.bag, this.count, n));
        return n;
    }

    // return true or false depending on whether x is in ar
    private boolean contains(int[] ar, int size, int x)
    {
        boolean found = false;
        for (int i = 0; (i < size) && !found; i++)
        {
            found = (ar[i] == x);
        }
        return found;
    }

    // return the sum of the digits of x
    private int digitSum(int x)
    {
        int sum = 0;
        for (int r = x; r != 0; r = r / 10)
        {
            int digit = r % 10;
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        long start = (new Date()).getTime();

        SumDiv7_Array var = new SumDiv7_Array(1000000, .1);
        var.simulate();
        System.out.println("Probalility of meeting criterion is " + var.count / (double) var.sample);
        System.out.println("Sample is ");
        for (int i = 0; i < var.count; i++)
        {
            System.out.print(var.bag[i] + " ");
        }

        long finish = (new Date()).getTime();

        System.out.println("\nRunning time was " + (finish-start) + " ms.");


    }
}


import java.util.List;


public class Lab1 {

	/**
	 * The course name for EECS2030.
	 */
	public static final String COURSE_NAME = "Advanced Object Oriented Programming";
	
	/**
	 * The smallest address allowed by yourAgeChecked.
	 */
	public static final int MIN_ADDRESS = 1;
	
	/**
	 * The greatest address allowed by yourAgeChecked.
	 */
	public static final int MAX_ADDRESS = 20000000;
	
	/**
	 * The smallest birth year allowed by yourAgeChecked.
	 */
	public static final int MIN_BIRTH_YEAR = 1917;
	
	/**
	 * The greatest birth year allowed by yourAgeChecked.
	 */
	public static final int MAX_BIRTH_YEAR = 2016;
	
	private Lab1() {
		// empty by design
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minDouble() {
		return Double.MIN_VALUE;
	}

	/**
	 * Removes the last two digits of a positive integer base 10 number that is
	 * greater than <code>99</code>.
	 * 
	 * @param n
	 *            a positive integer number greater than 99
	 * @return the integer produced by removing the last two digits of n
	 */
	public static int removeLastTwoDigits(int n) {
		return n / 100;
	}

	/**
	 * Returns the last two digits of a positive integer base 10 number that is
	 * greater than <code>99</code>. If the last two digits start with a
	 * <code>0</code> then only the last digit is returned.
	 * 
	 * @param n
	 *            a positive integer number greater than 99
	 * @return the last two digits of n
	 */
	public static int lastTwoDigits(int n) {
		return n % 100;
	}

	/**
	 * Computes the age (in years) of a person using the following convoluted
	 * algorithm:
	 * 
	 * <p>
	 * <ul>
	 * <li>start with the person's street <code>address</code>
	 * <li>double it
	 * <li>add 42 to the result from the previous step
	 * <li>multiply the previous step by 50
	 * <li>subtract the person's <code>birthYear</code> from the previous step
	 * <li>subtract 50 from the previous step
	 * <li>add the number of <code>birthdays</code> the person has had this year
	 * to the previous step
	 * <li>subtract 34 from the previous step
	 * <li>the last two digits of the previous step is the age of the person
	 * </ul>
	 * 
	 * @param address
	 *            the person's street address number
	 * @param birthYear
	 *            the person's birth year
	 * @param birthdays
	 *            the number of birthdays the person has had this year (either 0
	 *            or 1)
	 * @return the age of the person
	 * @pre. address is between MIN_ADDRESS and MAX_ADDRESS,
	 *       birthYear is between MIN_BIRTH_YEAR and MAX_BIRTH_YEAR, and
	 *       birthdays is 0 or 1
	 */
	public static int yourAge(int address, int birthYear, int birthdays) {
		address *= 2;
		address += 42;
		address *= 50;
		address -= birthYear + 50;
		address += birthdays;
		address -= 34;
		return lastTwoDigits(address);
	}

	/**
	 * Compute the average of two values.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 * @return the average of the two values
	 */
	public static double avg(int a, int b) {
		return (0.0 + a + b) / 2.0;
	}

	/**
	 * Returns the wind chill for air temperatures equal to or below 0 degrees
	 * Celcius and wind velocities equal to or greater than 5 km/h.
	 * 
	 * <p>
	 * Wind chill is an index that indicates how cold the weather feels to the
	 * average person when there is some wind. For example, if the air
	 * temperature is -5 degrees Celcius and the wind chill is -15 then it means
	 * that it feels similar to a windless day where the temperature is -15
	 * degrees Celcius.
	 * 
	 * @param airTemp
	 *            the temperature in degrees Celcius
	 * @param windSpeed
	 *            the wind speed in km/h
	 * @return the wind chill index
	 * @pre. airTemp is less than or equal to 0 degrees Celcius and
	 *       windSpeed is greater than or equal to 5 km/h
	 * @see <a href="http://climate.weather.gc.ca/glossary_e.html#w">
	 *      Environment and Climate Change Canada wind chill definition</a>
	 */
	public static double windChill(double airTemp, double windSpeed) {

		return (13.12 + 0.6215 * airTemp - 11.37 * Math.pow(windSpeed, 0.16)
				+ 0.3965 * airTemp * Math.pow(windSpeed, 0.16));
	}

	/**
	 * Determine if an integer <code>x</code> is odd.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is odd and false otherwise
	 */
	public static boolean isOdd(int x) {
		return x % 2 != 0;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is exactly on the perimeter of
	 * a circle with center <code>(0, 0)</code> and having radius equal to
	 * <code>1</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is exactly on the perimeter of the unit circle,
	 *         and false otherwise
	 */
	public static boolean isOnUnitCircle(double x, double y) {
		return x * x + y * y == 1;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is inside the unit square. The
	 * unit square is the square whose sides have length 1, whose bottom left
	 * corner has coordinates (0, 0), and whose top right corner has coordinates
	 * (1, 1). A point on the perimeter of the unit square is considered to be
	 * inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is inside the unit square, and false otherwise
	 */
	public static boolean isInsideUnitSquare(double x, double y) {
		return (x <= 1.0 && x >= 0.0 && y <= 1.0 && y >= 0.0);
	}

	/**
	 * Determine if the point <code>(x, y)</code> is outside the unit square.
	 * The unit square is the square whose sides have length 1, whose bottom
	 * left corner has coordinates (0, 0), and whose top right corner has
	 * coordinates (1, 1). A point on the perimeter of the unit square is
	 * considered to be inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is outside the unit square, and false otherwise
	 */
	public static boolean isOutsideUnitSquare(double x, double y) {
		return !Lab1.isInsideUnitSquare(x, y);
	}

	/**
	 * A version of yourAge where the arguments are checked to ensure that
	 * they have acceptable values.
	 * 
	 * <p>
	 * <code>address</code> must be greater than or equal
	 * <code>MIN_ADDRESS</code> and less than
	 * or equal to <code>MAX_ADDRESS</code>.
	 * 
	 * <p>
	 * <code>birthYear</code> must be greater than or equal
	 * <code>MIN_BIRTH_YEAR</code> and less than
	 * or equal to <code>MAX_BIRTH_YEAR</code>.
	 * 
	 * <p>
	 * <code>birthdays</code> must be equal to 0 or 1.
	 * 
	 * @param address
	 *            the person's street address number
	 * @param birthYear
	 *            the person's birth year 
	 * @param birthdays
	 *            the number of birthdays the person has had this year
	 * @return the age of the person
	 * @throws IllegalAddressException
	 *             if address is less than MIN_ADDRESS or greater than 
	 *             MAX_ADDRESS
	 * @throws IllegalArgumentException
	 *             if birthYear is less than MIN_BIRTH_YEAR or greater
	 *             than MAX_BIRTH_YEAR
	 * @throws IllegalArgumentException
	 *             if birthdays is not 0 or 1
	 */
	public static int yourAgeChecked(int address, int birthYear, int birthdays) {
		if (address < MIN_ADDRESS || address > MAX_ADDRESS) {
			throw new IllegalAddressException();
		}
		if (birthYear > MAX_BIRTH_YEAR || birthYear < MIN_BIRTH_YEAR) {
			throw new IllegalBirthYearException();
		}
		if (birthdays != 0 && birthdays != 1) {
			throw new IllegalBirthdaysException();
		}
		return Lab1.yourAge(address, birthYear, birthdays);
	}

	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the
	 * range is considered outside of the range.
	 * 
	 * @param x
	 *            a value
	 * @param range
	 *            a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0
	 *         otherwise
	 */
	public static int contains(double x, Range range) {
		int result = 1;

		if (x <= range.getMinimum() || x >= range.getMaximum()) {
			result = 0;
		}
		return result;
	}

	/**
	 * Compares two <code>Range</code> instances by their widths.
	 * The width of a range is equal to the maximum value of the
	 * range minus the minimum value of the range.
	 * 
	 * @param r1
	 *            a Range
	 * @param r2
	 *            a second Range
	 * @return the value 0 if both Range instances are equal; -1 if r1 is
	 *         narrower than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		int result = 0;

		double wid1 = r1.getMaximum() - r1.getMinimum();
		double wid2 = r2.getMaximum() - r2.getMinimum();
		if (wid1 < wid2) {
			result = -1;
		} else if (wid1 > wid2) {
			result = 1;
		}
		return result;
	}

	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to Lab1.COURSE_NAME
	 */
	public static String getCourseName() {
		return Lab1.COURSE_NAME;
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"range from x to y"</code> where 
	 * x is the minimum value of the range and y is the maximum value of the
	 * range.
	 * 
	 * @param r
	 *            a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {
		return "range from " + r.getMinimum() + " to " + r.getMaximum();
	}

	/**
	 * Returns the character located in the middle of the string. If
	 * <code>s</code> has an even number of characters then the middle character
	 * is taken to be the first character in the second half of the string
	 * (i.e., the middle character of the string <code>"abcd"</code> is
	 * <code>'c'</code>.
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 * @return the middle character of s
	 * @throws IllegalArgumentException
	 *             if s is empty
	 */
	public static char middleChar(String s) {
		if (s.isEmpty()) {
			throw new IllegalArgumentException("string has length 0");
		}
		int mid = s.length() / 2;
		return s.charAt(mid);
	}

	/**
	 * Sorts a list of two integers so that the elements are in descending order
	 * (largest to smallest). The size of the list remains unchanged.
	 * 
	 * @param t
	 *            a list
	 * @throws IllegalArgumentException
	 *             if the size of list is not equal to 2
	 */
	public static void sort2(List<Integer> t) {
		if (t.size() != 2) { 
			throw new IllegalArgumentException();
		}
		int a =t.get(0);
		int b = t.get(1);
		if (a < b) {
			t.set(0, b);
			t.set(1, a);
		}
	}

	/**
	 * Returns the sum of the absolute value of the elements in a list. The sum
	 * of an empty list is <code>0</code>. The method does not modify the list.
	 * 
	 * @param t
	 *            a list
	 * @return the sum of the absolute value of the elements in a list
	 */
	public static double sumAbsolute(List<Double> t) {
		double sum = 0;
		for (Double val : t) {
			sum += Math.abs(val);
		}
		return sum;
	}

	/**
	 * Replaces each string in a list with the uppercase version of the string.
	 * The size of the list remains unchanged. For example, the method would
	 * modify the list <code>["some", "random", "WoRdS"]"</code> to become
	 * <code>["SOME", "RANDOM", "WORDS"]"</code>.
	 * 
	 * @param t
	 *            a list of strings
	 */
	public static void toUpperCase(List<String> t) {
		for (int i = 0; i < t.size(); i++) {
			String s = t.get(i);
			t.set(i, s.toUpperCase());
		}
	}
	

}




import java.util.List;

/**
 * 
 * 
 * A random assortment of methods reviewing topics that should
 * have been covered in your previous programming courses.
 *
 */

public class Lab0 {
	
	
	private Lab0() {
		// empty to prevent object creation
	}
	
	
	
	/**
	 * Returns the value 1.
	 * 
	 * @return the value 1
	 */
	public static int one() {
		return 1;
	}
	
	
	
	
	/**
	 * <p><strong> Divisibility </strong> :  When dividing an integer by a second nonzero integer, 
	 * the quotient may or  may not be an integer. </p>
	 * <p> For example, 12/3 = 4 while 9/4 = 2:25.</p>
	 * <p><strong>Definition </strong>: <em> If {@code a}  and {@code b} are integers with {@code a} 
	 * is not equal to  zero , we say that {@code a}  divides {@code b} 
	 * if there exists an integer {@code c}  such that  {@code b = ac}. 
	 *  When {@code a}  divides {@code b} we say that {@code a}  is a factor of {@code b} 
	 *  and that {@code b}  is a multiple of {@code a} </em>. </p>
	 *  <p> This method take two integers {@code a} and {@code b}, then it return true if  
	 *  {@code a} divides {@code b }  </p>
	 *  
	 *  <pre>
	 *  Example:
	 *  
	 *  isDivisible ( 3, 5) returns false 
	 *  isDivisible ( 5, 21) returns false
	 *  isDivisible ( 75, 512) returns false
	 *  isDivisible ( 5, 10) returns true 
	 *  isDivisible ( 22, 198) returns true 
	 *  isDivisible ( 64, 512) returns true 
	 *  </pre>
	 * 
	 * @param a integer not equal to zero
	 * @param b integer not equal to zero
	 * @return true true if  {@code a} divides {@code b } or {@code b} divides {@code a} 
	 * @pre.
	 * 		{@code a != 0} , and  {@code b != 0}
	 */
	
	public static boolean  isDivisible ( int a , int b ) {
		boolean result = false;
		if(b % a == 0) {
			result = true;
		}
		
		return result;
		
	}
	
	
	/**
	 * <p><strong> Modular Arithmetic</strong> </p> 
	 * <p><strong> Definition: </strong><em>
	 *  If {@code a} and {@code b}  are integers and {@code m} is a positive integer, 
	 *  then {@code a} is <b>congruent</b> to {@code b}  modulo {@code m} if <b> {@code m} divides {@code a-b} </b>. </em>
	 *  </p><p> In the other words, two integers are congruent mod {@code m} if and only if 
	 *  they have the <b> same remainder when divided by {@code m} </b> .</p>
	 * <p> This method take three integers {@code a} and {@code b} and {@code m}, then it return true if  
	 *  {@code a} is <b>congruent</b> to {@code b}  modulo {@code m} </p>
	 *  
	 *  <pre>
	 *  Example:
	 *  
	 *  isCongruent ( 81,199,5) returns false 
	 *  isCongruent ( -8,8, 5) returns false
	 *  isCongruent ( 24, 14, 6) returns false
	 *  isCongruent ( 10, 26, 8) returns true 
	 *  isCongruent ( 17, 5, 6) returns true 
	 *  isCongruent ( -1,1, 2) returns true 
	 *  isCongruent ( -8,2, 5) returns true 
	 *  isCongruent ( 38,23, 15) returns true 
	 *  </pre>
	 * 
	 * 
	 * @param a integer not equal to zero
	 * @param b integer not equal to zero 
	 * @param m integer not equal to zero
	 * @return true if {@code a} is <b>congruent</b> to {@code b}  modulo {@code m} 
	 * @pre.
	 * 		{@code m > 0} , {@code a != 0}  , {@code b != 0} 
	 */
	
	
	public static boolean isCongruent (int a , int b , int m ) {
		boolean result = false;
		int aa = a - b;
		if (aa % m == 0) {
			result = true;
		}
		
		return result;
		
	}
	
	
	/**
	 * Returns the mathematical average of 3 values.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @return the average of a, b, and c
	 */
	public static double avg(int a, int b, int c) {
		double ave;
		double sum;
		sum = (double)a + (double)b + (double)c;
		ave = sum / 3;
	
		return ave;
	}
	
	
	
	
	/**
	 * <p><strong> Primes</strong> </p>
	 * <p> A <em> positive integer </em> {@code n > 1} is called <strong> prime</strong> 
	 * if the only positive factors of {@code n}  are {@code  1}  and {@code  n} . 
	 * A positive integer that is greater than one and is not prime is called <strong> composite</strong>.</p>
	 * <p> An integer {@code  n} is <strong> composite </strong> 
	 * if and only if there exists an integer {@code a} such that
	 * <strong> <em>  {@code a}  divides {@code n}  </em></strong> and {@code 1 < a < n}.</p>
	 * 
	 * <p> <strong> Hint:  1 is neither prime nor composite. It forms its own special category as a "unit".</strong></p>
	 * 
	 * <p> This method checks the positive integer if it is prime or not.</p>
	 *  <pre>
	 *  Example:
	 *  
	 *  isPrime ( -5) returns false 
	 *  isPrime ( 6) returns false
	 *  isPrime ( 25) returns false
	 *  isPrime ( 2) returns true 
	 *  isPrime ( 3) returns true 
	 *  isPrime ( 13) returns true 
	 *  isPrime ( 17) returns true 
	 *  isPrime ( 29) returns true 
	 *  </pre>
	 * 
	 * @param n positive integer 
	 * @return true  if number {@code n} is prime, else false
	 * @pre.
	 * 		{@code n > 0}  
	 */
	public static boolean isPrime(int n) {
		if(n < 2){
	        return false;
	    }
	    if(n == 2){
	        return true;
	    }
	    if(n % 2==0){
	        return false;
	    }
	    for(int i = 3;i < n;i++){
	        if(n % i == 0){
	            return false;
	        }
	    }
	    return true;
	
	}
	
	/**
	 * This method checks the element of the list of integers and 
	 * return the number (count) of  of prime integers.
	 * 
	 * 
	 * <pre>
	 * Example: if the input list is 
	 *  
	 *  [1,2,4,5,6,7] returns 3 ( hint: we have three prime integers : 2, 5, and 7)  
	 *  [-1, -5, 6, 8, 16 , 18]  returns 0 ( hint: none of these integers are prime )
	 *  [ 9, 13, 17, 19, 37] returns 4 ( hint: we have four prime numbers: 13, 17, 19 and 37) 
	 * 
	 *  </pre>
	 * 
	 * <p> Note: This method does not modify the input list of integer {@code listofintegers}.</p>
	 * 
	 * @param listofintegers  a list of Integers
	 * @return the number of prime integers  in the given list of integers
	 */
	
	
	public static int countPrimeElements(List<Integer> listofintegers) {
		int count = 0;
		for(int i = 0; i < listofintegers.size();i++) {
			int a = listofintegers.get(i);
			boolean isPrime = true;
			if(a < 2){
		         isPrime = false;
		    }
			else if(a == 2){
		        isPrime = true;
		    }
			else if(a % 2 == 0){
		        isPrime = false;
		    }
			else {
				
				for(int j = 3;j < a;j++){
			
		             if(a % j == 0){
		                 isPrime = false;
		            }
				}
		    }
		
		    if(isPrime) {
		    	count++;
		    }
		}
			
		return count;	
	}
	
	



	/**
	 * This method check the input array of integers and return number of elements 
	 * that are  <b>congruent</b> to {@code b}  modulo {@code m}.
	 * 
	 * <pre>
	 * Example:   
	 *  arrayofint= [1,6,8,5],b=14  m=3  returns 2   
	 *  arrayofint= [2,3,17,19,29], b=7, m=7  returns 0
	 *  arrayofint= [81,45,65,99] b= 18 , m=3 returns 4 
	 * 
	 *  </pre>
	 *  
	 * <p> Note: This method does not modify the input list of integer {@code arrayofint}.</p>
	 * @param arrayofint input array of int , elements are not equal to zero
	 * @param b integer not equal to zero 
	 * @param m positive integer 
	 * @return the number of elements that are  <b>congruent</b> to {@code b}  modulo {@code m}.
	 * 
	 * @pre.
	 * 		{@code m > 0} , {@code b != 0}  , {@code arrayofint[i] != 0} 
	 * 
	 */
	public static int countCongruentElement(int [] arrayofint, int b, int m ) {
		int count = 0;
		for(int i = 0; i < arrayofint.length; i ++) {
			int bb = arrayofint[i] - b;
			if(bb % m == 0) {
				count++;
			}
		}
		return count;
		
	
	}
		

}


package algorithms.shuffle;(array)

import java.util.Random;

public class ShuffleArray {
    public static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        shuffleArray(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
Create the following program for sorting list.

package algorithms.shuffle;(list)

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleList {
    public static void shuffleList(List<Integer> a) {
        int n = a.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(List<Integer> a, int i, int change) {
        int helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        shuffleList(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}


package .lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Reviewing fundamental Java concepts: Methods, Utilities, Exceptions, Equals
 * 
 *
 */
public class Lab01 {

	private Lab01() {
		// empty by design
	}

	// Question 1

	/**
	 * Returns the minimum (most negative) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the minimum (most negative) value that an int can represent
	 */
	public static int minInt() {
		int a = Integer.MIN_VALUE;
		int b = -a;
		return b;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double maxDouble() {
		double a = Double.MAX_VALUE;

		return a;
	}

	// Ques 2

	/**
	 * Removes the last two digits of a positive integer base 10 number that is
	 * greater than <code>99</code>.
	 * 
	 * @param n a positive integer number greater than 99
	 * @return the integer produced by removing the last two digits of n
	 */
	public static int removeLastTwoDigits(int n) {
		int remlast = n / 10;
		int rem2nd = remlast / 10;
		return rem2nd;
	}

	/**
	 * Returns the last one digit of a positive integer base 10 number that is
	 * greater than <code>9</code>. If the last two digits start with a
	 * <code>0</code> then only the last digit is returned.
	 * 
	 * @param n a positive integer number greater than 9
	 * @return the last one digit of n
	 */
	public static int lastOneDigit(int n) {
		int last = n % 10;
		return last;
	}

	public static int lastTwoDigits(int n) {
		int last = n % 10;
		int remlastn = n / 10;
		int second = remlastn % 10;
		int las2Digs = second * 10 + last;
		return las2Digs;
	}

	/**
	 * Computes the age (in years) of a person using the following convoluted
	 * algorithm:
	 * 
	 * <p>
	 * <ul>
	 * <li>start with the person's street <code>address</code>
	 * <li>double it
	 * <li>add 42 to the result from the previous step
	 * <li>multiply the previous step by 50
	 * <li>subtract the person's <code>birthYear</code> from the previous step
	 * <li>subtract 50 from the previous step
	 * <li>add the number of <code>birthdays</code> the person has had this year to
	 * the previous step
	 * <li>subtract 34 from the previous step
	 * <li>the last two digits of the previous step is the age of the person
	 * </ul>
	 * 
	 * <p>
	 * This algorithm works only for people aged 1-99, and for addresses less than
	 * approximately 20000000.
	 * 
	 * @param address   the person's street address number
	 * @param birthYear the person's birth year
	 * @param birthdays the number of birthdays the person has had this year (either
	 *                  0 or 1)
	 * @return the age of the person
	 */
	public static int yourAge(int address, int birthYear, int birthdays) {
		double douaddr = address * 2;
		double plusaddr = douaddr + 42;
		double mulpladdr = plusaddr * 50;
		double subir4Year = mulpladdr - birthYear;
		double subfifty = subir4Year - 50;
		double addbir4d = birthdays + subfifty;
		double subthiry4 = addbir4d - 34;
		int age = lastTwoDigits((int) subthiry4);
		return age;
	}

	// Ques 3
	/**
	 * Computes the standard Rayleigh distribution probability density function (see
	 * the lab document for the actual formula) with scale parameter.
	 * 
	 * @param x     a value
	 * @param sigma scale parameter
	 * @return the standard Rayleigh distribution probability density function
	 *         evaluated at x
	 */
	public static double rayleigh(double x, int sigma) {
		double squasigma = sigma * sigma;
		double firstpa = x / squasigma;
		double p = -(x * x) / (2 * squasigma);
		double sencondpa = Math.exp(p);
		double result = firstpa * sencondpa;
		return result;
	}

	// Ques 4

	/**
	 * Computes the number of characters that are different in two strings of equal
	 * length. The strings are compared character by character and the number of
	 * characters that differ is returned. For example:
	 * 
	 * <pre>
	 * Lab1.distance("talk", "talk")    returns  0
	 * Lab1.distance("talk", "walk")    returns  1
	 * Lab1.distance("well", "walk")    returns  2
	 * 
	 * </pre>
	 * 
	 * @param s a non-null string
	 * @param t a non-null string
	 * @return the number of characters that differ between s and t
	 * @throws IllegalArgumentException if s and t have different lengths
	 */
	public static int distance(String s, String t) {
		if (s.length() != t.length()) {
			throw new IllegalArgumentException("s and t have different length");
		}
		int count = 0;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(j)) {
				count++;

			}
			j++;
		}
		return count;
	}

	// Ques 5
	/**
	 * Determine if the point <code>(x, y)</code> is strictly inside the r with
	 * center <code>(0, 0)</code> and having radius equal to <code>1</code>. A point
	 * on the perimeter of the circle is considered outside of the circle.
	 * 
	 * @param x the x-coordinate of the point
	 * @param y the y-coordinate of the point
	 * @return true if (x, y) is inside the unit circle, and false otherwise
	 */
	public static boolean isInside(double x, double y) {
		boolean result = false;
		double r = Math.sqrt(x * x + y * y);
		if (r < 1)
			result = true;

		return result;
	}

	// Ques 6

	/**
	 * Returns true if year is a leap year and false otherwise.
	 * 
	 * <p>
	 * A year is always a leap year if it is evenly divisible by 400; for all other
	 * years, a year is a leap year if it is evenly divisible by 4 and not evenly
	 * divisible by 100. For example:
	 * 
	 * <pre>
	 * isLeapYear(2000)  returns  true   (2000 is divisible by 400)
	 * isLeapYear(1900)  returns  false  (1900 is divisible by 4 and 100)
	 * isLeapYear(2004)  returns  true   (2004 is divisible by 4 but not 100)
	 * isLeapYear(2005)  returns  false  (2005 is not divisible by 4)
	 * </pre>
	 * 
	 * @param year a year
	 * @return true if year is a leap year and false otherwise
	 * @throws IllegalArgumentException if year is less than 1582 (the year the
	 *                                  Gregorian calendar was adopted)
	 */
	public static boolean isLeapYear(int year) {
		boolean result = false;
		if (year < 1582) {
			throw new IllegalArgumentException("This year is less than 1582");
		}
		if (year % 400 == 0)
			result = true;
		else if (year % 4 == 0 && year % 100 == 0)
			result = false;
		else if (year % 4 == 0 && year % 100 != 0)
			result = true;
		return result;
	}

	// Ques 7
	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the range is
	 * considered outside of the range.
	 * 
	 * @param x     a value
	 * @param range a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0 otherwise
	 */
	public static int contains(double x, Range range) {
		int result = 0;
		if (x > range.getMinimum() && x < range.getMaximum())
			result = 1;
		return result;
	}

	// Ques 8
	/**
	 * Compares two <code>Range</code> instances by their widths.
	 * 
	 * @param r1 a Range
	 * @param r2 a second Range
	 * @return the value 0 if both Range instances are equal; -1 if r1 is narrower
	 *         than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		int result = 0;
		double range1 = r1.getMaximum() - r1.getMinimum();
		double range2 = r2.getMaximum() - r2.getMinimum();
		if (range1 < range2) {
			result = -1;
		} else if (range1 > range2) {
			result = 1;
		}
		return result;
	}

	// Ques 9
	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"minimum: x, maximum: y"</code> where
	 * x is the minimum value of the range and y is the maximum value of the range.
	 * 
	 * @param r a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {

		String result = "minimum: " + r.getMinimum() + "," + " maximum: " + r.getMaximum();
		return result;
	}

	// Ques 10

	/**
	 * Returns the character n positions from the end of the string s. For example,
	 * suppose <code>s</code> is the string <code>"abcd"</code>; then:
	 * 
	 * <pre>
	 * Lab1.charFromEnd(s, 0)  returns 'd'
	 * Lab1.charFromEnd(s, 1)  returns 'c'
	 * Lab1.charFromEnd(s, 2)  returns 'b'
	 * Lab1.charFromEnd(s, 3)  returns 'a'
	 * Lab1.charFromEnd(s, 4)  throws an IllegalArgumentException
	 * Lab1.charFromEnd(s, -1) throws an IllegalArgumentException
	 * </pre>
	 * 
	 * @param s a string of length 1 or greater
	 * @param n the desired location of the character counting from the end of the
	 *          string
	 * @return the character located n positions from the end of the string
	 * @throws IllegalArgumentException if the character located n positions from
	 *                                  the end of the string does not exist
	 */
	public static char charFromEnd(String s, int n) {
		char c = ' ';
		if (n == s.length() || n == -1) {
			throw new IllegalArgumentException(
					"the character located n positions from the end of the string does not exist");
		}
		c = s.charAt(s.length() - n - 1);
		return c;
	}

	// Ques 11
	/**
	 * Sorts a list of three integers so that the elements are in descending order
	 * (largest to smallest). The size of the list remains unchanged.
	 * 
	 * @param t a list
	 * @throws IllegalArgumentException if the size of list is not equal to 3
	 */
	public static void sort2(List<Integer> t) {
		if (t.size() != 3) {
			throw new IllegalArgumentException("the size of list is not equal to 3");
		}
		int a = t.get(0);
		int b = t.get(1);
		int c = t.get(2);
		int max;
		int min;
		int max1 = Math.max(a, b);
		int max2 = Math.max(a, c);
		if (max1 >= max2) {
			max = max1;
		} else
			max = max2;

		int min1 = Math.min(a, b);
		int min2 = Math.min(a, c);
		if (min1 <= min2) {
			min = min1;
		} else
			min = min2;
		t.set(0, max);
		t.set(2, min);

	}

	// Ques 12
	/**
	 * Returns the number of strings in the list t that are equal to the target
	 * string.
	 * 
	 * @param t      the list to search
	 * @param target the string to search for
	 * @return the number of strings in the list t that are equal to target
	 */
	public static int frequency(List<String> t, String target) {
		int count = 0;
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).equals(target)) {
				count++;
			}
		}
		return count;
	}

	// Ques 13

	/**
	 * Sorts the elements of the list t so that the elements are in ascending order.
	 * A precondition of this method is that t must be already sorted in ascending
	 * order except that adjacent pairs of elements in t may be out of order.
	 * Consider the following almost sorted lists:
	 * 
	 * <pre>
	 * [1, 0]                1, 0 is out of order
	 * [0, 2, 1]             2, 1 is out of order
	 * [0, 2, 1, 3]          2, 1 is out of order
	 * [0, 2, 1, 4, 3]       2, 1 and 4, 3 are out of order
	 * [0, 1, 3, 2, 4]       3, 2 is out of order
	 * </pre>
	 * 
	 * <p>
	 * This method switches the positions of the out-of-order adjacent elements thus
	 * repairing the list so that it is in sorted order.
	 * 
	 * @param t a list of almost sorted elements
	 * 
	 *          <pre>
	 *  
	 * t is sorted in ascending order except that adjacent pairs of elements 
	 *       may be out of order
	 *          </pre>
	 */
	public static void repair(List<Integer> t) {
		// if the list has less than 2 elements then is already sorted

		for (int i = 0; i < t.size() - 1; i++) {
			int temp = t.get(i);
			if (t.get(i) > t.get(i + 1)) {
				t.set(i, t.get(i + 1));
				t.set(i + 1, temp);
			}
		}
	}

//Ques 14

	/**
	 * Returns a new list of characters formed by shuffling the characters of the
	 * given list. It is a precondition that the given list t contains at least two
	 * elements, and that the number of elements is an even number. The list is not
	 * modified by this method.
	 * 
	 * <p>
	 * To shuffle the characters in t, imagine splitting the list t in half so that
	 * the first (n / 2) characters of t are in one sublist, and the remaining (n /
	 * 2) characters of t are in the second sublist. The new returned list is formed
	 * by adding the first character of the first sublist to the new list, then
	 * adding the first character of the second sublist, then adding the second
	 * character of the first sublist, then adding the second character of the
	 * second sublist, and so on, until all of the characters in the two sublists
	 * are added to the new list.
	 * 
	 * <p>
	 * For example, if t was the list:
	 * 
	 * <pre>
	 * ['a', 'b', 'c', 'd', 'e', 'f']
	 * </pre>
	 * 
	 * <p>
	 * then splitting t into two sublists yields:
	 * 
	 * <pre>
	 * ['a', 'b', 'c'] and ['d', 'e', 'f']
	 * </pre>
	 * 
	 * <p>
	 * Take the first two characters of each sublist and add them to the new list:
	 * 
	 * <pre>
	 * ['a', 'd']
	 * </pre>
	 * 
	 * <p>
	 * Then take the next two characters of each sublist and add them to the new
	 * list:
	 * 
	 * <pre>
	 * ['a', 'd', 'b', 'e']
	 * </pre>
	 * 
	 * <p>
	 * Then take the next two characters of each sublist and add them to the new
	 * list:
	 * 
	 * <pre>
	 * ['a', 'd', 'b', 'e', 'c', 'f']
	 * </pre>
	 * 
	 * @param t a non-null list of characters
	 * @return a new list equal to the shuffle of the characters in t @pre. t is not
	 *         null @pre. t.size() is greater than or equal to 2 @pre. t.size() is
	 *         an even number
	 */
	public static List<Character> shuffle(List<Character> t) {
		List<Character> a = new ArrayList<>();
		for (int i = 0, j = t.size()/2; i < t.size() / 2 || j < t.size(); i++,j++) {
			a.add(t.get(i));
			a.add(t.get(j));
		}
		return a;

	}

	// Ques 15

	/**
	 * Replaces the elements of a list of angles in degrees with the equivalent
	 * angles in radians. The size of the list remains unchanged.
	 * 
	 * @param t a list of angles in degrees
	 */
	public static void toRadians(List<Double> t) {
		for (int i = 0; i < t.size(); i++) {
			double angle = t.get(i);
			double radian = Math.toRadians(angle);
			t.set(i, radian);
		}
	}
}

