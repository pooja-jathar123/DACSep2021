/* HashMap:  
-It stores object/ data in the key value form.
-Key shd be  unique value
-
*/

//*********************Iterating map *****************************

import java.util.*; 
class Student implements Comparable<Student>{          // for usig sort method - we need to implement Comparable interface
	int roll,age;
	String name;
	double marks;
	
	Student(){

	}
	Student(int roll, String name, double marks , int age){
		this.roll=roll;
		this.name=name;
		this.marks=marks;
		this.age=age;
	}
	public void printNameAndMarks(){
		System.out.println("Name = " + name + " Marks = " + marks);
	}
	public String toString(){
		return "[ Student roll = "+roll+", name = "+name+",  marks = "+marks+ " , age = "+age+"]";
	}
	public int hashCode(){
		return (int)(roll+marks);
	}
	public boolean equals(Object ob){
		Student s=(Student)ob;
		System.out.println("equals() called---------------------");
		if(s==null)
			return false;
		if(this.roll == s.roll && this.name.equals(s.name) && this.marks == s.marks && this.age ==s.age)                       
                             			//this.name.equals(s.name): useed .equals here bcz we want to compare and content not the ref
			return true;
		else
			return false;
	}
	//default comparison : based on marks for sorting
	//******* overriding compareTo method which is abstract method present in Comparable interface  
	public int compareTo(Student s){
		
		//********comparison  on the basis of marks
		if (this.marks > s.marks)           
		    return 1;
		if(this.marks < s.marks)
			return -1;
		return 0;                                //if we are writing return inside if then we have to write one return outside if also
		
		//********sorting on the basis of marks using wrapper class
		/*
		Double marks1= this.marks;
		Double marks2= s.marks;
		return marks1.compareTo(marks2);
		*/
		
		//**** sorting on the basis of name  -- using compareTo() method of String
	    //return this.name.compareTo(s.name);              
	}
}

class HashMapDemo{
	
	public static void main(String args[]){
		
		//**display () method
		
		Map<Integer, Student> map1 = new HashMap<Integer, Student>();
		//OR 
		//Map<Integer, Student> map1 = new HashMap<>();
		
		Student s1=   new Student (10, "Rohit", 65.7, 122); 
		Student s2=   new Student (20, "Pooja", 45.3,  42); 
		
		//add elemts to map  -- put(key,value) method
		map1.put(1,s1);                                                                      //adding objects by creating obj first
		map1.put(2,s2);                                                                    
		map1.put(3, new Student(30 ,"Amar",  67.5, 34));            //directly creating and adding objects  
		map1.put(4, new Student(40 ,"Rakhi",  67.5, 34));
		System.out.println();
		
		//Retrieve elements from map   --  get() method
		Student s = map1.get(3);     
        System.out.println("map1.get(3): ");		
		System.out.println(s);
		System.out.println();
		
		//Iterating map using EntrySet  --  entry
		System.out.println("Map 1 elements: ");
		Set<Map.Entry<Integer,Student>> set1 = map1.entrySet();
		for(Map.Entry<Integer,Student> entry : set1){
			System.out.println(entry);                                                        // will print key:value
		}
		
		//Iterating map using EntrySet -- getValue()
		System.out.println("Map 1 elements  Only value: ");
		Set<Map.Entry<Integer,Student>> set2 = map1.entrySet();
		for(Map.Entry<Integer,Student> entry : set2){
			System.out.println(entry.getValue());                                   //will print only values
		}
		
		//Iterating map using EntrySet -- getKey()
		System.out.println("Map 1 elements  Only keys: ");
		Set<Map.Entry<Integer,Student>> set3 = map1.entrySet();
		for(Map.Entry<Integer,Student> entry : set3){
			System.out.println(entry.getKey());                                       //will print only keys
		}
		
		//keySet() method
		Set<Integer> kset1 = map1.keySet();
		System.out.println("Map 1 keys retrived through keySet : ");
		for(Integer k : kset1){
			System.out.println(k);                                       //will print only keys
		}
		
		//values() method
		Collection<Student> elements  = map1.values();
		System.out.println("Map 1 keys retrived through values : ");
		for(Student s3 : elements){
			System.out.println(s3);                                       //will print only values
		}
		
		
		
	}
}