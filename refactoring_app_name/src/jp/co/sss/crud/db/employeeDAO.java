package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.Constants;

public class employeeDAO {

	public static List<Employee> findAll() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> lEmployee = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();

				//DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getString("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				//department.setDeptName(resultSet.getString("dept_name"));
				//employee.setDepartment(department);
				employee.setDeptName(resultSet.getString("dept_name"));

				lEmployee.add(employee);
			}
			//DTO を戻す 
			return lEmployee;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * @return 
	 * @return 
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByEmp(String empName) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> lEmployee = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + empName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				//DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getString("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				//department.setDeptName(resultSet.getString("dept_name"));
				//employee.setDepartment(department);
				employee.setDeptName(resultSet.getString("dept_name"));

				lEmployee.add(employee);
			}

			//DTO を戻す 
			return lEmployee;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 * @return 
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> lEmployee = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				//DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getString("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				//department.setDeptName(resultSet.getString("dept_name"));
				//employee.setDepartment(department);
				employee.setDeptName(resultSet.getString("dept_name"));

				lEmployee.add(employee);
			}

		} finally

		{
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		//DTOを戻す
		return lEmployee;
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @return 
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static List<Employee> insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		List<Employee> lEmployee = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(Constants.EMP_INF_REG);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
		return lEmployee;
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @return 
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static List<Employee> update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Employee> lEmployee = new ArrayList<>();
		int result = 0;
		ResultSet resultSet = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print(Constants.EMP_NAME);
			String emp_name = br.readLine();
			// 性別を入力
			System.out.print(Constants.GENDER_SELECT);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(Constants.DATE_OF_BIRTH_INPUT);
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print(Constants.DEPT_ID_SELECT);
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			result = preparedStatement.executeUpdate();

			if (result != 0) {
				// DBに接続
				connection = DBManager.getConnection();

				// SQL文を準備
				StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
				sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

				// ステートメントの作成
				preparedStatement = connection.prepareStatement(sql.toString());

				// 検索条件となる値をバインド
				preparedStatement.setInt(1, Integer.parseInt(deptId));

				// SQL文を実行
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Employee employee = new Employee();
					Department department = new Department();
					//DTOへの格納
					employee.setEmpId(resultSet.getInt("emp_id"));
					employee.setEmpName(resultSet.getString("emp_name"));
					employee.setGender(resultSet.getString("gender"));
					employee.setBirthday(resultSet.getString("birthday"));
					//department.setDeptName(resultSet.getString("dept_name"));
					//employee.setDepartment(department);
					employee.setDeptName(resultSet.getString("dept_name"));

					lEmployee.add(employee);

					System.out.println(Constants.EMP_INF_UPDATE);
				}
			}
		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return lEmployee;
	}

	/**
	 * 社員情報を1件削除
	 * @return 
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Employee> lEmployee = new ArrayList<>();

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(Constants.EMP_INF_DELETE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
		return lEmployee;
	}
}
