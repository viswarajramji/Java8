package data;


import java.util.List;

public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private int noteBooks;
    private List<String> activity;
    private int mark1;
    private int mark2;

    public Student(){

    }

   
	public Student(String name, int gradeLevel, double gpa, String gender, int noteBooks, List<String> activity,
			int mark1, int mark2) {
		super();
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.noteBooks = noteBooks;
		this.activity = activity;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoteBooks() {
		return noteBooks;
	}

	public void setNoteBooks(int noteBooks) {
		this.noteBooks = noteBooks;
	}

	public List<String> getActivity() {
		return activity;
	}

	public void setActivity(List<String> activity) {
		this.activity = activity;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	
	public String printName() {
		return this.getName();
	}

	public boolean isPassed() {
		return this.mark1>50 && this.mark2>50;
	}
	
	



}