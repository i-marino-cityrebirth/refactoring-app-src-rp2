package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
import jp.co.sss.crud.util.Constants;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 *初回変更
 *developブランチを利用したコード変更
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException,
			SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeFindByDeptIdService employeeFindByDeptIdService = new EmployeeFindByDeptIdService();
		EmployeeAllFindService employeeAllFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeRegisterService employeeRegisterService = new EmployeeRegisterService();
		EmployeeUpdateService employeeUpdateService = new EmployeeUpdateService();
		EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(Constants.EMP_MGM_SYSTEM);
			System.out.println(Constants.ALL_DISPLAY);
			System.out.println(Constants.EMP_NAME_SERCH);
			System.out.println(Constants.DEPT_ID_SERCH);
			System.out.println(Constants.NEW_REG);
			System.out.println(Constants.UPDATE);
			System.out.println(Constants.DElETE);
			System.out.println(Constants.END);
			System.out.print(Constants.MSG_MENU);

			// メニュー番号の入力
			String menuNoInput = br.readLine();
			menuNo = Integer.parseInt(menuNoInput);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				employeeAllFindService.execute();
				break;

			case 2:

				// 検索機能の呼出
				employeeFindByEmpNameService.execute();
				break;

			case 3:

				// 検索機能の呼出
				employeeFindByDeptIdService.execute();
				break;

			case 4:

				employeeRegisterService.execute();
				break;

			case 5:

				// 更新機能の呼出
				employeeUpdateService.execute();
				System.out.println(Constants.EMP_INF_UPDATE);

				break;

			case 6:

				// 削除機能の呼出
				employeeDeleteService.execute();
				break;

			}
		} while (menuNo != 7);
		System.out.println(Constants.END_SYSTEM);
	}
}
