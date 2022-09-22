package assignment1;
import java.util.ArrayList;

import org.joda.time.DateTime;


public class LectureManagementSystem {
	static ArrayList<Student> electronicsStudentList = new ArrayList<Student>(); //list of electronics students
	static ArrayList<Module> electronicModuleList = new ArrayList<Module>();   	 //list of electronics modules
	static ArrayList<CourseProgram> electronicsCourseProgramList = new ArrayList<CourseProgram>(); //electronics courses lecturer1 teaches
	
	static ArrayList<Module> lecturer1Modules = new ArrayList<Module>();		 //modules lecturer1 teaches
	static ArrayList<Module> lecturer2Modules = new ArrayList<Module>();         //modules lecturer2 teaches
	static ArrayList<Module> lecturer3Modules = new ArrayList<Module>();         //modules lecturer3 teaches
	static ArrayList<Module> lecturer4Modules = new ArrayList<Module>();         //modules lecturer4 teaches
	static ArrayList<Module> lecturer5Modules = new ArrayList<Module>();         //modules lecturer5 teaches
	
	 // instantiating 5 students
	static Student student1 = new Student("Aidan", 22, new DateTime(2000, 9, 4, 7, 2, 9, 4), 19458984, electronicModuleList, electronicsCourseProgramList);
	static Student student2 = new Student("Paul", 21, new DateTime(2001, 7, 4, 0, 8, 3, 1), 15263748, electronicModuleList, electronicsCourseProgramList);
	static Student student3 = new Student("Johnny", 22, new DateTime(2000, 6, 4, 5, 9, 4, 0), 14523567, electronicModuleList, electronicsCourseProgramList);
	static Student student4 = new Student("Bill", 20, new DateTime(2002, 3, 4, 0, 8, 0, 5), 19987651, electronicModuleList, electronicsCourseProgramList);
	static Student student5 = new Student("Tom", 23, new DateTime(1999, 5, 4, 5, 5, 9, 2), 198053409, electronicModuleList, electronicsCourseProgramList);

	 // instantiating 5 lecturers
	static Lecturer lecturer1 = new Lecturer("Matty", 45, new DateTime(1977, 4, 8, 3, 8, 5, 0), 83726182, lecturer1Modules);
	static Lecturer lecturer2 = new Lecturer("Thomas", 59, new DateTime(1963, 3, 7, 2, 7, 4, 9), 85749382, lecturer2Modules);
	static Lecturer lecturer3 = new Lecturer("Jack", 40, new DateTime(1982, 2, 6, 1, 8, 3, 8), 85940392,  lecturer3Modules);
	static Lecturer lecturer4 = new Lecturer("Kyle", 30, new DateTime(1992, 1, 5, 0, 7, 2, 7), 56473829, lecturer4Modules);
	static Lecturer lecturer5 = new Lecturer("Mike", 60, new DateTime(1962, 9, 4, 9, 6, 1, 6), 29223495, lecturer5Modules);

	// instantiating 6 modules
	static Module module1 = new Module("Software Engineering", "CT417", electronicsStudentList, electronicsCourseProgramList, lecturer1);
	static Module module2 = new Module("Digital Signal Processing", "EE445", electronicsStudentList, electronicsCourseProgramList, lecturer1);
	static Module module3 = new Module("System on Chip I", "EE451", electronicsStudentList, electronicsCourseProgramList, lecturer2);
	static Module module4 = new Module("System on Chip II", "EE452", electronicsStudentList, electronicsCourseProgramList, lecturer3);
	static Module module5 = new Module("Embedded Systems Applications Programming", "EE347", electronicsStudentList, electronicsCourseProgramList, lecturer4);
	static Module module6 = new Module("Mobile Networks: Architecture and Services", "EE4101", electronicsStudentList, electronicsCourseProgramList, lecturer5);

	 // instantiating 2 course programs
	static CourseProgram ECE = new CourseProgram("ECE", electronicModuleList, electronicsStudentList, new DateTime(2022, 9, 4, 0, 0, 0, 0), new DateTime(2023, 5, 20, 0, 0, 0, 0));
	static CourseProgram EEE = new CourseProgram("EEE", electronicModuleList, electronicsStudentList, new DateTime(2022, 9, 4, 0, 0, 0, 0), new DateTime(2023, 5, 20, 0, 0, 0, 0));
	
	public static void main (String[]args) {
		populateLists(); //populate all ArrayLists
		
		for(int a=0; a<electronicsCourseProgramList.size();a++) {
			//print out the list of courses
			System.out.println("Course Name: "+ electronicsCourseProgramList.get(a).getName());
			
			//print out the courses start and end dates
			System.out.println("Starts: "+ electronicsCourseProgramList.get(a).getStartDate().getMonthOfYear() + ", "+ electronicsCourseProgramList.get(a).getStartDate().getYear()+ 
					" | End: "+ electronicsCourseProgramList.get(a).getEndDate().getMonthOfYear() + ", "+ electronicsCourseProgramList.get(a).getEndDate().getYear());

			for(int b=0; b<electronicsCourseProgramList.get(a).getModules().size(); b++) {
				
				//print out the modules ID, name, lecturer and lecturer's username
				System.out.println("	Module "+ (b+1) + ": "+ electronicsCourseProgramList.get(a).getModules().get(b).getID()+" - "+electronicsCourseProgramList.get(a).getModules().get(b).getName()
						+ "(taught by " + electronicsCourseProgramList.get(a).getModules().get(b).getLecturer().getName()+" ["+ electronicsCourseProgramList.get(a).getModules().get(b).getLecturer().getUsername() + "])");
			}
			System.out.println();
			for(int b=0; b<electronicsCourseProgramList.get(a).getStudents().size(); b++) {
				//print out all the user's enrolled in a given course, their ID and their username
				System.out.println("	Student "+ (b+1) + ": "+ electronicsCourseProgramList.get(a).getStudents().get(b).getID()+" - "+electronicsCourseProgramList.get(a).getStudents().get(b).getName() + " (" +electronicsCourseProgramList.get(a).getStudents().get(b).getUsername() +")");
			}
		}
		
		//printing out the modules each student studies
		for(int a=0; a<electronicsStudentList.size(); a++) {
			System.out.println(electronicsStudentList.get(a).getName() + " studies: ");
			for(int b=0; b<electronicsStudentList.get(a).getModules().size();b++) {
				System.out.println("	•"+electronicsStudentList.get(a).getModules().get(b).getName());
			}
		}
		
		//printing out the modules each lecturer teaches
				for(int a=0; a<electronicsStudentList.size(); a++) {
					System.out.println(electronicsStudentList.get(a).getName() + " studies: ");
					for(int b=0; b<electronicsStudentList.get(a).getModules().size();b++) {
						System.out.println("	•"+electronicsStudentList.get(a).getModules().get(b).getName());
					}
				}
	}
	
	public static void populateLists() {
		//populating list of electronics students
		electronicsStudentList.add(student1);
		electronicsStudentList.add(student2);
		electronicsStudentList.add(student3);
		electronicsStudentList.add(student4);
		electronicsStudentList.add(student5);
		
		//populating list of electronics modules
		electronicModuleList.add(module1);
		electronicModuleList.add(module2);
		electronicModuleList.add(module3);
		electronicModuleList.add(module4);
		electronicModuleList.add(module5);
		electronicModuleList.add(module6);
		
		//populating list of each lecturer's modules
		lecturer1Modules.add(module1);
		lecturer1Modules.add(module2);
		lecturer2Modules.add(module3);
		lecturer3Modules.add(module4);
		lecturer4Modules.add(module5);
		lecturer5Modules.add(module6);
		
		//populating list of electronics courses
		electronicsCourseProgramList.add(ECE);
		electronicsCourseProgramList.add(EEE);
	}
}
