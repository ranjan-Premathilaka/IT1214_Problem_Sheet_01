import java.util.Scanner;

class Student{
    int studentId;
    String name;
    int daysAttended;

//constructor
Student(int studentId,String name,int daysAttended){
    this.studentId=studentId;
    this.name=name;
    this.daysAttended=daysAttended;
}

//getters and setters

public int getSdudentId(){
    return studentId;
}
public void setStudentId(int studentId){
    this.studentId=studentId;
}

public int getName(){
    return name;
}
public void setName(String name){
    this.name=name;
}

public int getDaysAttended(){
    return daysAttended;
}
public void setDaysAttended(int daysAttend){
    this.daysAttended=daysAttendend;
}

}



//class classromm

class Classroom{
    Scanner sc = new Scanner(System.in);
    int[] student = new int[10]; 
    int[] arr =new int[10];

            //add a new student method
            public void add(){
            System.out.println("Enter student name :");
            String name = sc.nextline();
            int mark=0;
                    for(int i=1;i<=10;i++){
                        if(arr == 0){
                            student[i]=studentId;
                            arr[i]=1;
                            break;
                        mark=1;
                        }
                    }
                    if(mark=0){
                        System.out.println("cannot add,full filled students");
                    }
            }
            //ends add method

            //method update
            public void attend(){
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            for(int i=1;i<=10;i++){
                 if(student[i]=id){
                    System.out.println("Enter attend days: ");
                    int day = sc.nextInt();
                    daysAttend=day;
                 }
            }
            }

            

        //method display
            public void display() {
                System.out.println("\n--- student Info ---");
            for(int i=1;i<=10;i++){
                if(student[arr] == 1){
                    System.out.println("student id :"+studentId+" , Student name :"+name+" days of attended  :"+daysattended);
                }
            }
                System.out.println("-------------------\n");
            }


        
}




//main class
class Main{
    public static void main(String []args){
        Classroom c1=new Classroom();

        System.out.println("what you want to do? add new student enter 1,change attendance enter 2");
        int check = sc.nextInt();
     
     
        try{  switch(check){
            case 1: add();
            case 2: attend();

            if(check != 1 || check !=2 ){
                throw new IllegalArgumentException("wrong input enter only 1 or 2");
            }
             }}
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());}


    display();

    }
}
