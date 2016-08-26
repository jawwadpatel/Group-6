package group6.controller;

import group6.module.unit.UnitManager;
import group6.module.student.StudentUnitRecordManager;
import group6.module.student.StudentManager;
import group6.IModule.IStudent;
import group6.IModule.IUnit;
import group6.IModule.IStudentUnitRecord;
import group6.view.cgUI;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * UI controller  
 * This class has set of function which enables/disables controllers on the GUI
 * and perform certain tasks such as save and populate drop-down lists.
 */

public class cgCTL {

	cgUI CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL() {
	}

        /**
         * execute method.                           
         * <p>
         * It kick starts the UI properties by setting their visibility and 
         * availability to either true/false. 
         * </p>
         */
        
	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);

		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	}

        /**
         * unitSelected method.                           
         * <p>
         * The method populated the drop-down list item on the UI with the
         * course IDs/names. Based on this function result, certain UI elements
         * are made available.
         * <p>
         *
         * @param  code is used to retrieve students within that subject/course.          
         */
	public void unitSelected(String code) {

		if (code.equals("NONE"))
			CGUI.setState2(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	}
        
        /**
         * studentSelected method.                           
         * <p>
         * It collects student's grades based on its ID that is selected from
         * student drop-down list.
         * </p>
         *
         * @param  id is used to retrieve student's grades.          
         */
	
        public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}

		else {
			IStudent s = StudentManager.get().getStudent(id);

			IStudentUnitRecord r = s.getUnitRecord(cuc);

			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;

		}
	}
        /**
         * checkGrade method.                           
         * <p>
         * The method is used to evaluate student's grade based on (FL,PS,DI,HD).
         * <p>
         * @param  f is float variable which holds assignment 1 grade.   
         * @param  g is float variable which holds assignment 2 grade parameter.
         * @param  h is float variable which holds exam grade parameter.
         * @return String (FL,PS,DI,HD)
         */
	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) {
			CGUI.setState6(true);
		}
		return s;
	}
        /**
         * enableChangeMarks method.                           
         * <p>
         * It is used to set assignment 1,2, and exam text fields enable.
         * </p>
         */
	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	}

         /**
         * saveGrade method.                           
         * <p>
         * The method is used to save changes to student's grade into XML file.
         * <p>
         * @param  asg1 is float variable which holds assignment 1 grade.   
         * @param  asg2 is float variable which holds assignment 2 grade parameter.
         * @param  exam is float variable which holds exam grade parameter.
         */
	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.UM().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAsg1(asg1);
		r.setAsg2(asg2);
		r.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	}
}
