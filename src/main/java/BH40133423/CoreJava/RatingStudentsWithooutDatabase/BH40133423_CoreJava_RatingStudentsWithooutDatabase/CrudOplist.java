package BH40133423.CoreJava.RatingStudentsWithooutDatabase.BH40133423_CoreJava_RatingStudentsWithooutDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CrudOplist {
	public static ArrayList<ArrayList<String> > Distribution= new ArrayList<ArrayList<String> >(); 
    public static ArrayList<ArrayList<String> > Assignments= new ArrayList<ArrayList<String> >();
   void crudDistribution() {
	   Scanner in=new Scanner(System.in);
	   int cho=5;
	   while(cho!=0) {
	   System.out.println("1-Add Assignment Category.");
	   System.out.println("2-Remove Assignment Category.");
	   System.out.println("3-Display Assignment Category.");
	   System.out.println("0-Exit.");
	   
	   cho=in.nextInt();
	   switch(cho){
		   case 1:
			   addDistri();
			   break;
		   case 3:
			   disDistri();
			   break;
		   case 2:
			   remDistri();
			   break;
		   
	   }
	   }
   }
   void addDistri() {
	   Scanner in=new Scanner(System.in);
	   System.out.println("Enter name of Assigment category:-");
	   String na=in.next();
	   System.out.println("Enter weight of category in number out of 100:-");
	   String we=in.next();
	   Distribution.add(new ArrayList<String>(Arrays.asList(na,we)));
	   System.out.println("Insertion Completed");
   }
   void disDistri() {
	   System.out.println(Distribution);
   }
   void remDistri() {
	   Scanner in=new Scanner(System.in);
	   System.out.println("Srno---Assignmet---Weight");
	   
	   for(int i=0;i<=Distribution.size()-1;i++) {
		   System.out.println(i+"---"+Distribution.get(i).get(0)+"---"+Distribution.get(i).get(1));
		   
	   }
	   System.out.println("Enter srno of assignment you want to remove:-");
	   int k=in.nextInt();
	   Distribution.remove(k);
   }
   void crudAssign() {
	   Scanner in=new Scanner(System.in);
	   int cho=5;
	   while(cho!=0) {
	   System.out.println("1-Enroll Student in Subject.");
	   System.out.println("2-Remove Student.");
	   System.out.println("3-Display Assignments..");
	   System.out.println("0-Exit.");
	   
	   cho=in.nextInt();
	   switch(cho){
		   case 1:
			   enroll();
			   break;
		   case 3:
			   disass();
			   break;
		   case 2:
			   remstu();
			   break;
		   
	   }
	   }
	   
   }
   void enroll() {
	   Scanner in=new Scanner(System.in);
	   System.out.println("Enter name of Student:-");
	   String na=in.next();
	   System.out.println("Enter name of Subject ex-Coputer_Science note-If space in between subject name replace space with _(underscore):-");
	   String sa=in.next();
	   System.out.println("Enter assignment category:-");
	   
	   String ac=in.next();
	   System.out.println("Enter submission date in format of date-month-year ex-21-jul-2021:-");
	   String sd=in.next();
	   System.out.println("Enter points:-");
	   String po=in.next();
	   Assignments.add(new ArrayList<String>(Arrays.asList(na,sa,ac,sd,po)));
	   System.out.println("Insertion completed");
	   
	   
	   
	   
   }
   void remstu() {
	   Scanner in=new Scanner(System.in);
	   System.out.println("Srno---Student_Name---Subject---Assignment_Category---Date_of_Submission---Points");
	   
	   for(int i=0;i<=Distribution.size()-1;i++) {
		   System.out.println(i+"---"+Assignments.get(i).get(0)+"---"+Assignments.get(i).get(1)+"---"+Assignments.get(i).get(2)+"---"+Assignments.get(i).get(3)+"---"+Assignments.get(i).get(4));
		   
	   }
	   System.out.println("Enter srno of student you want to remove:-");
	   int k=in.nextInt();
	   Assignments.remove(k);
   }
   void disass() {
System.out.println("Srno---Student_Name---Subject---Assignment_Category---Date_of_Submission---Points");
	   
	   for(int i=0;i<=Distribution.size()-1;i++) {
		   System.out.println(i+"---"+Assignments.get(i).get(0)+"---"+Assignments.get(i).get(1)+"---"+Assignments.get(i).get(2)+"---"+Assignments.get(i).get(3)+"---"+Assignments.get(i).get(4));
		   
	   }
   }
   void cpa(String na) {
	   ArrayList<String> sub=new ArrayList<String>();
	   ArrayList<ArrayList<String> > Assign= new ArrayList<ArrayList<String> >();
	   
       	 for(int i=0;i<=Assignments.size()-1;i++) {
       		 if(Assignments.get(i).get(0).toString().equals(na)) {
       			 if(sub.contains(Assignments.get(i).get(1))) {
       				continue;
       			 }
       			 else {
       				 sub.add(Assignments.get(i).get(1).toString());
       			 }
       		 }
       	 }
       	 for(int k=0;k<=sub.size()-1;k++) {
       		ArrayList<String> val=new ArrayList<String>();
       		val.add(sub.get(k));
       		for(int j=0;j<=Distribution.size()-1;j++) {
					
       			double sc=0;
       			double n1=0,n2=0,n3=0;
       	 for(int i=0;i<=Assignments.size()-1;i++) {
       		
       		if(Assignments.get(i).get(0).toString().equals(na)) {
       			if(Assignments.get(i).get(1).toString().equals(sub.get(k).toString())) {
       				//System.out.println("ok");
       		       if(Assignments.get(i).get(2).toString().equals(Distribution.get(j).get(0).toString())) {
       		    	  
       		    	  n1=Double.parseDouble(Distribution.get(j).get(1).toString());
       		    	  n2=Double.parseDouble(Assignments.get(i).get(4).toString());
       		    	  n3++;
       		    	 // System.out.println(n1);
       		    	  //System.out.println(n3);
       		    	  //System.out.println(sc);
       		       }
       		    
       			}
       			
       		}
       		if(n3!=0) {
       		sc=n1/n3;
       		sc*=n2;
       		}
       	 }
       	//sc=n1/n3;
   		//sc*=n2;
       	 sc/=100;
       val.add(String.valueOf(sc));
       
       		}
       		Assign.addAll(Arrays.asList(val));
       		
       	 }
       	 for(int i=0;i<=Assign.size()-1;i++) {
       		 double or=0;
       		 for(int j=1;j<=Assign.get(i).size()-1;j++) {
       			 or=or+Double.parseDouble(Assign.get(i).get(j).toString());
       		 }
       		 Assign.get(i).add(String.valueOf(or));
       	 }
       	 System.out.print("Subject--");
       	for(int i=0;i<=Distribution.size()-1;i++) {
 		   if(i!=Distribution.size()-1) {
       		System.out.print(Distribution.get(i).get(0).toString()+"--");
 		   }
 		   else {
 			   System.out.print(Distribution.get(i).get(0).toString());
 			   System.out.println("--Overall Rating(%)");
 		   }
 	   }
       	System.out.println(Assign);
   }
   void cpp(String sna) {
	   ArrayList<String> sub=new ArrayList<String>();
	   ArrayList<ArrayList<String> > Assign= new ArrayList<ArrayList<String> >();
	   for(int i=0;i<=Assignments.size()-1;i++) {
     		 if(Assignments.get(i).get(1).toString().equals(sna)) {
     			 if(sub.contains(Assignments.get(i).get(0))) {
     				continue;
     			 }
     			 else {
     				 sub.add(Assignments.get(i).get(0).toString());
     			 }
     		 }
     	 }
	   for(int k=0;k<=sub.size()-1;k++) {
      		ArrayList<String> val=new ArrayList<String>();
      		val.add(sub.get(k));
      		for(int j=0;j<=Distribution.size()-1;j++) {
					
      			double sc=0;
      			double n1=0,n2=0,n3=0;
      	 for(int i=0;i<=Assignments.size()-1;i++) {
      		
      		if(Assignments.get(i).get(1).toString().equals(sna)) {
      			if(Assignments.get(i).get(0).toString().equals(sub.get(k).toString())) {
      				//System.out.println("ok");
      		       if(Assignments.get(i).get(2).toString().equals(Distribution.get(j).get(0).toString())) {
      		    	  
      		    	  n1=Double.parseDouble(Distribution.get(j).get(1).toString());
      		    	  n2=Double.parseDouble(Assignments.get(i).get(4).toString());
      		    	  n3++;
      		    	  //System.out.println(n1);
      		    	  //System.out.println(n3);
      		    	  //System.out.println(sc);
      		       }
      		    
      			}
      			
      		}
      		if(n3!=0) {
      		sc=n1/n3;
      		sc*=n2;
      		}
      	 }
      	//sc=n1/n3;
  		//sc*=n2;
      	 sc/=100;
      val.add(String.valueOf(sc));
      
      		}
      		Assign.addAll(Arrays.asList(val));
      		
      	 }
      	 for(int i=0;i<=Assign.size()-1;i++) {
      		 double or=0;
      		 for(int j=1;j<=Assign.get(i).size()-1;j++) {
      			 or=or+Double.parseDouble(Assign.get(i).get(j).toString());
      		 }
      		 Assign.get(i).add(String.valueOf(or));
      	 }
      	System.out.print("Student Name--");
       	for(int i=0;i<=Distribution.size()-1;i++) {
 		   if(i!=Distribution.size()-1) {
       		System.out.print(Distribution.get(i).get(0).toString()+"--");
 		   }
 		   else {
 			   System.out.print(Distribution.get(i).get(0).toString());
 			   System.out.println("--Overall Rating(%)");
 		   }
 	   }
       	System.out.println(Assign);
   }
    public static void main(String[]args) {
    	CrudOplist c=new CrudOplist();
    	
    	Distribution.add(new ArrayList<String>(Arrays.asList("Test","40")));
    	Distribution.add(new ArrayList<String>(Arrays.asList("Quiz","20")));
    	Distribution.add(new ArrayList<String>(Arrays.asList("Lab Work","10")));
    	Distribution.add(new ArrayList<String>(Arrays.asList("Project","30")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Ananth","Electro_Fields","Test","21-Jul-16","100")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Bhagath","Electro_Fields","Test","21-Jul-16","78")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Chaya","Electro_Fields","Test","21-Jul-16","68")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Esharath","Electro_Fields","Test","21-Jul-16","87")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Bhagath","Electro_Fields","Quiz","22-Jul-16","20")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Chaya","Electro_Fields","Lab Work","23-Jul-16","10")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Ananth","Electro_Fields","Project","24-Jul-16","100")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Devanth","Electro_Fields","Project","24-Jul-16","100")));
    	Assignments.add(new ArrayList<String>(Arrays.asList("Ananth","Computer_Science","Test","24-Jul-16","100")));
    	Scanner in=new Scanner(System.in);
    	int choo=5;
    	while(choo!=0) {
    	System.out.println("1-Add/Remove Assignment Category.");
    	System.out.println("2-Enroll/Remove Students from Assignment.");
    	System.out.println("3-Compute & display student average score per assignment category &overall  rating for assigned subject");
    	System.out.println("4-Compute & Display subject average score per assignment category &overall rating for assigned student");
        choo=in.nextInt();
    	switch(choo) {
    	case 1:
    		c.crudDistribution();
    		break;
    	case 2:
    		c.crudAssign();
    		break;
    	case 3:
    		System.out.println("Enter the name of student:");
    		String name=in.next();
    		c.cpa(name);
    		break;
    	case 4:
    		System.out.println("Enter the name of subject:");
    		String sna=in.next();
    		//System.out.print(sna);
    		c.cpp(sna);
    		break;
    	}
    	
    	}
    }
}
