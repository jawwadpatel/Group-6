package group6.module.student;

import group6.IModule.IStudent;
import group6.IModule.IStudentUnitRecord;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * Module Class  
 * This implements IStudent and has set of getters/setters. It is used as an object
 * to represent a student.
 */

public class Student implements IStudent {
    private Integer id; private String fn;
            private String ln;
private StudentUnitRecordList su;

/**
* Student constructor method.                           
*
* @param  id as student ID.
* @param  fn as First name.
* @param  ln as Last name.
* @param  su as student grade records object.
*/

public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) 
{ this.id = id; this.fn = fn;
        this.ln = ln;
        this.su = 
        su == null ? new StudentUnitRecordList() : 
                su;
}

    public Integer getID() { return this.id; 
} public String getFirstName() { 
return fn; }

    public void setFirstName( String firstName ) { 
this.fn = firstName; }

public String getLastName() { 
    return ln; }
    public void setLastName( String lastName ) { 

        
this.ln = lastName; }

public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
        public IStudentUnitRecord getUnitRecord( String unitCode ) {
for ( IStudentUnitRecord r : su ) 
            if ( r.getUnitCode().equals(unitCode)) 
return r; 

return null;
        
}

public StudentUnitRecordList getUnitRecords() { return su; }}
