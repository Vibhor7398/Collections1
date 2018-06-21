package extractingFiles;


import java.util.Scanner;

public class DynamicArrayWithoutArrayList {
	int size,newSize,index;
	int arr[];
	DynamicArrayWithoutArrayList(){
		arr = new int[8];
		size = 8;
		newSize = 8;
	}
	void restructure() {
		newSize=(int) (size*1.5);
		size = newSize;
		int previousArray[] = arr;
		arr = new int[newSize];
		for(int i = 0; i<previousArray.length; i++) {
			arr[i]=previousArray[i];
		}
	}
	void isEmpty() {
		if(index==0) {
			System.out.println("Array is empty");
		}
		else {
			System.out.println("Array is not empty");
		}
	}
	void add(int k) {
		if(index==newSize) {
		restructure();
		}
		arr[index] = k;
		index++;
	}
	void top() {
		System.out.println("Element at top: " + arr[index-1]);
	}
	void pop() {
		if(index>0) {
		int removed = arr[index-1];
		arr[index-1]=0;
		index--;
		System.out.println(removed + " removed");
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Array is empty. No element present to be removed.");
		}
	}
	void size() {
		System.out.println("Present elements in array is: " + (index));
	}
	void display() {
		for(int i = 0; i < index ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	

	public static void main(String[] args) {
		DynamicArrayWithoutArrayList c = new DynamicArrayWithoutArrayList();
		c.isEmpty();
		c.size();
		c.add(2);
		c.pop();
		//c.pop(); //throws exception if not in comments
		c.add(5);
		c.add(8);
		c.add(1);
		c.add(6);
		c.top();
		c.pop();
		c.isEmpty();
		c.top();
		c.add(7);
		c.add(4);
		c.add(3);
		c.add(1);
		c.add(8);
		c.size();
		c.add(5);
		c.add(9);
		c.add(8);
		c.pop();
		c.add(1);
		c.add(6);
		c.add(2);
		c.add(5);
		c.add(8);
		c.add(1);
		c.add(6);
		c.add(6);
		c.add(6);
		c.add(6);
		c.display();
		c.size();

	}

}