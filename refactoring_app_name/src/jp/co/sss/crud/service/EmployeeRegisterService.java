package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.employeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.Constants;

public class EmployeeRegisterService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 登録する値を入力
			System.out.print(Constants.EMP_NAME);
			String emp_name = br.readLine();
			System.out.print(Constants.GENDER_SELECT);
			String Seibetsu = br.readLine();
			System.out.print(Constants.DATE_OF_BIRTH_INPUT);
			String birthday = br.readLine();
			System.out.print(Constants.DEPT_ID_SELECT);
			String deptId = br.readLine();

			List<Employee> searchedEmployees = new ArrayList<Employee>();

			try {
				try {
					searchedEmployees = employeeDAO.insert(emp_name, Seibetsu, birthday, deptId);
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
