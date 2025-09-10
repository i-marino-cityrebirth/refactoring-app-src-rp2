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

public class EmployeeUpdateService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 更新する社員IDを入力
			System.out.print(Constants.EMP_ID_UPDATE);

			// 更新する値を入力する
			String empId = br.readLine();
			Integer.parseInt(empId);

			List<Employee> searchedEmployees = new ArrayList<Employee>();

			try {
				try {
					searchedEmployees = employeeDAO.update(empId);
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
