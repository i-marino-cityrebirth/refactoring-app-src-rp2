package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.employeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.Constants;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// 削除する社員IDを入力
		System.out.print(Constants.EMP_ID_DELETE);

		List<Employee> searchedEmployees = new ArrayList<Employee>();

		searchedEmployees = employeeDAO.delete();

	}
}
