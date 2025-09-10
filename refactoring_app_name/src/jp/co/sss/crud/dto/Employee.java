package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Constants;

public class Employee {

	private int empId;
	private String empName;
	private String birthday;
	private String gender;
	private String department;
	//private Department department;

	//GetterとSetter
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptName() {
		return department;
	}

	public void setDeptName(String department) {
		this.department = department;
	}

	//	public Department getDepartment() {
	//		return department;
	//	}
	//
	//	public void setDepartment(Department department) {
	//		this.department = department;
	//	}

	//Employee#toStringのオーバーライド例 
	@Override
	public String toString() {

		String gender_ja = "";
		int iGender = 0;

		iGender = Integer.parseInt(gender);

		if (iGender == 0) {
			gender_ja = Constants.NO_ANSWER;
		} else if (iGender == 1) {
			gender_ja = Constants.MAN;

		} else if (iGender == 2) {
			gender_ja = Constants.WOMAN;

		} else if (iGender == 9) {
			gender_ja = Constants.OTHER;
		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday
				+ "\t" + department/*Department.getDeptName()*/;
	}

}
