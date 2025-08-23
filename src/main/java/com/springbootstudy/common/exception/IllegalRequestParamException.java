package com.springbootstudy.common.exception;

/**
 * 通常操作では発生し得ないリクエストを示すException<br>
 * 例：必ず送信されるはずのパラメーターが送信されていない、画面上入力できないはずの値が設定されている、など。
 */
public class IllegalRequestParamException extends StudyCommonException {

}
