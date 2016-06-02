/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> longerList2;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		longerList2 = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList2.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

	}


	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

	}


	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here

		// test empty list, get should throw an exception
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test out of bound cases
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test longer list contents
		for (int i = 0; i <LONG_LIST_LENGTH; i++){
			int b = longerList2.remove(0);
			//System.out.println(i + ": " + b);
			assertEquals("Check "+i+ " element", (Integer)i, (Integer)b);
		}

		// test off the end of the longer array
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}

	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// TODO: implement this test
		longerList.add(44);
		assertEquals("Check last added element", (Integer)44, longerList.get(longerList.size()-1));
		longerList.add(92);
		assertEquals("Check last added element", (Integer)92, longerList.get(longerList.size()-1));

		emptyList.add(4);
		assertEquals("Check adding to empty list", (Integer)4, emptyList.get(0));

		shortList.add("C");
		assertEquals("Check adding to list of strings", "C", shortList.get(2));
		assertEquals("Check adding to list of strings", "B", shortList.get(1));
		assertEquals("Check adding to list of strings", "A", shortList.get(0));
	}


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test

		// Check for different list sizes
		assertEquals("Check size is correct", 3, list1.size());
		assertEquals("Check size is correct", 10, longerList.size());

		// Test for empty list
		assertEquals("Check size is correct", 0, emptyList.size());

		// Test for different element type
		assertEquals("Check size is correct", 2, shortList.size());

	}



	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// TODO: implement this test
		try {
			emptyList.add(1, 87);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.add(-1, 8);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			longerList.add(11, 8);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// Test add for long list in middle
		longerList.add(5, 22);
		assertEquals("Add: Check element is 4", (Integer)4, longerList.get(4));
		assertEquals("Add: Check element is 5", (Integer)22, longerList.get(5));
		assertEquals("Add: Check element is 22", (Integer)5, longerList.get(6));
		assertEquals(11, longerList.size());

		// Test add for long list at front
		longerList.add(0, 33);
		assertEquals("Add: Check element is 33", (Integer)33, longerList.get(0));
		assertEquals("Add: Check element is 0", (Integer)0, longerList.get(1));
		assertEquals("Add: Check element is 1", (Integer)1, longerList.get(2));
		assertEquals(12, longerList.size());

		// Test add for shortList at end
		shortList.add(2, "C");
		assertEquals("Add: Check element is B", "B", shortList.get(1));
		assertEquals("Add: Check element is C", "C", shortList.get(2));
		assertEquals(3, shortList.size());

	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		// TODO: implement this test
		shortList.set(0, "D");
		assertEquals("Set: Check element is D", "D", shortList.get(0));
		assertEquals("Set: Check element is B", "B", shortList.get(1));
		shortList.set(1, "G");
		assertEquals("Set: Check element is G", "G", shortList.get(1));
		assertEquals("Set: Check element is D", "D", shortList.get(0));
		
		try {
			shortList.set(-1, "D");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		
		try {
			shortList.set(3, "D");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		
		assertEquals("Set: Check element is 0", (Integer)0, longerList.get(0));
		assertEquals("Set: Check element is 1", (Integer)1, longerList.get(1));
		assertEquals("Set: Check element is 2", (Integer)2 , longerList.get(2));
		
		longerList.set(0, 33);
		assertEquals("Set: Check element is 33", (Integer)33, longerList.get(0));
		assertEquals("Set: Check element is 1", (Integer)1, longerList.get(1));
		assertEquals("Set: Check element is 2", (Integer)2 , longerList.get(2));
		assertEquals(10, longerList.size());

		
	}


	// TODO: Optionally add more test methods.

}
