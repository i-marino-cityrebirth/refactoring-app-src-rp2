package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.employeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.Constants;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	/**
	 * ビジネスロジックの実行
	 * DAOのメソッドを呼び出し、ユースケース（登録や更新）を実装する
	 * また実行結果のコンソールへの表示を行う
	 * 
	 * @throws SystemErrorException, IllegalInputException
	 */
	public void execute() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 検索する部署IDを入力
		System.out.print(Constants.DEPT_ID_INPUT);
		try {
			String deptIdInput = br.readLine();
			List<Employee> searchedEmployees = new ArrayList<Employee>();

			try {
				searchedEmployees = employeeDAO.findByDeptId(deptIdInput);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} //deptIdは入力された部署ID 
			ConsoleWriter.showEmployees(searchedEmployees);//コンソール出力

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
