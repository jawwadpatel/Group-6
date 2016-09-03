package group6.module.student;

import group6.IModule.IStudent;
import group6.IModule.IStudentUnitRecord;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * Module Class  
 * Purpose of this class is yet to be identified. 
 */

public class StudentProxy implements IStudent {
private Integer I;
private String l;



    private String Il;
    private StudentManager lI;
    public StudentProxy( Integer id, String fn, String Il) {
        this.I = id;
        this.l = fn;

        
        this.Il = Il;
this.lI = StudentManager.get();}

    public Integer getID() { return I; 

    
    
}
public String getFirstName() { 
        return l; }

    public String getLastName() { 
return Il; 
}
public void setFirstName(String firstName) {

    
    
    
    lI.getStudent(I).setFirstName(firstName);}
    public void setLastName(String lastName) {
        
        
        
        lI.getStudent(I).setLastName(lastName);}

    
    
        public void addUnitRecord(IStudentUnitRecord record) {
        lI.getStudent(I).addUnitRecord(record);}
        public IStudentUnitRecord getUnitRecord(String unitCode) {

            
 
            
            
            
            
            
                    return lI.getStudent(I).getUnitRecord(unitCode);}


        
  
        
        
        
        
                                public StudentUnitRecordList getUnitRecords() { return lI.getStudent(I).getUnitRecords();}}
