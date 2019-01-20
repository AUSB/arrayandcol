

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

