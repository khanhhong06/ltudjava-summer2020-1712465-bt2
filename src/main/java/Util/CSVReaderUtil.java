package Util;

import Model.Entities.Schedule;
import Model.Entities.Student;
import Model.Entities.Subject;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {
    private String FileURL;
    private CSVReader reader;
    private List<Student> listStudent;
    private List<Schedule> listSchedule;
    private List<Subject> listSubject;

    public CSVReaderUtil(String url){
        this.FileURL = url;
        this.listStudent = null;
        this.listSchedule = null;
        this.listSubject = null;
    }

    public List<Schedule> getListSchedule() {
        return listSchedule;
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public List<Subject> getListSubject() {
        return listSubject;
    }

    public void readList(int mode){
        reader = null;
        try{
            reader = new CSVReader(new FileReader(FileURL));
            String[] line;
            line = reader.readNext();
            switch (mode){
                case 0:
                    List<Student> students = new ArrayList<Student>();
                    while ((line = reader.readNext()) != null){
                        Student student = new Student();
                        student.setMSSV(line[0]);
                        student.setStudentName(line[1]);
                        student.setStudentSex(line[2]);
                        student.setStudentNationID(line[3]);
                        students.add(student);
                    }
                    this.listStudent = students;
                    break;
                case 1:
                    List<Schedule> schedules = new ArrayList<Schedule>();
                    while ((line = reader.readNext()) != null){
                        Schedule schedule = new Schedule();
                        schedule.setSubNo(line[0]);
                        schedule.setRoom(line[2]);
                        schedules.add(schedule);
                    }
                    listSchedule = schedules;
                    break;
                default:
                    List<Subject> subjects = new ArrayList<Subject>();
                    while ((line = reader.readNext()) != null){
                        Subject subject = new Subject();
                        subject.setSubNo(line[0]);
                        subject.setSubName(line[1]);
                        subjects.add(subject);
                    }
                    listSubject = subjects;
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
