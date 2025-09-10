package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.Constants;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();//対象者がいませんでした と表示 
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	private static void showHeader() {

		System.out.println(Constants.RECORD_DISPLAY);
	}

	private static void showNonExistTarget() {

		System.out.println(Constants.NO_TRG_PERSON);
	}
}
