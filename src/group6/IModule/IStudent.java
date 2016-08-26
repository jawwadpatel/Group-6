package group6.IModule;

import group6.module.student.StudentUnitRecordList;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * Student interface 
 * Includes getter and setter properties
 */

public interface IStudent {

    public Integer getID();

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public void addUnitRecord( IStudentUnitRecord record );
    public IStudentUnitRecord getUnitRecord( String unitCode );

    public StudentUnitRecordList getUnitRecords();

}
