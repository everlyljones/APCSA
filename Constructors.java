/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.constructors;

/**
 *
 * @author ejones2025
 */
public class Constructors {

    public static void main(String[] args) {
        Course csa = new Course("AP Computer Science A", "AP CSA", 1000, "Mr. Nelson");
        System.out.println(csa);
        Course app = new Course();
        app.setCourse("AP Physics 1", "APP1", 100, "Mrs.Rafie");
        System.out.println(app);
        Course cf = new Course("Catholic Faith 12", "CF12", 250, "Mrs. Lonergan");
        System.out.println(cf);
    }
}

class Course {
   
    private String course;
    private String code;
    private int pointsTotal;
    private String name;
    
    public Course (String cr, String cd, int pt, String nm) {
            course = cr;
            code = cd;
            pointsTotal = pt;
            name = nm;
    }
    
    public Course() {
        course = null;
        code = null;
        pointsTotal = 0;
        name = null;    
    }
    
    public void setCourse(String c, String apP1, int par, String mrsRafie){
        course = c;
        code = apP1;
        pointsTotal = par;
        name = mrsRafie;
    }
    
    public String toString(){
        String result = "";
        result = "Course name: " + course + "\n" + "Course code: " + code + "\n" + "Total points: " + pointsTotal + "\n" + "Instuctor name: " + name;
        return result;
    }
}