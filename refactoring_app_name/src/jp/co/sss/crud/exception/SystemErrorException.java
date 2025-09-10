package jp.co.sss.crud.exception;

import java.io.IOException;

public class SystemErrorException extends Throwable {

	public SystemErrorException(String message, IOException e) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(message);
	}

	public SystemErrorException(String message, Throwable cause) {
		super(message, cause);

	}

}
