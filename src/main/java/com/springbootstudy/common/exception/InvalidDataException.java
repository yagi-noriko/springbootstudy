package com.springbootstudy.common.exception;

/**
 * DBデータの不整合を示すException<br>
 * 例：1件しかないはずのデータが複数件存在する、必ず存在するはずのデータがない
 */
public class InvalidDataException extends StudyCommonException {

	public InvalidDataException(String message) {
		super(message);
	}

}
