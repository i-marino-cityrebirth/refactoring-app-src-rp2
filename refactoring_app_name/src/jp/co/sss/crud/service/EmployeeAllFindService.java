package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.employeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {

		List<Employee> searchedEmployees = new ArrayList<Employee>();

		try {
			searchedEmployees = employeeDAO.findAll();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ConsoleWriter.showEmployees(searchedEmployees);//コンソール出力
	}
}
