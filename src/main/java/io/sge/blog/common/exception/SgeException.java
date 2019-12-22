package io.sge.blog.common.exception;

public class SgeException extends RuntimeException {

	private static final long serialVersionUID = 5887320929767994679L;
	private final int errCode;

	public SgeException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public SgeException(String msg) {
		this(msg, 9999);
	}

	public int getErrCode() {
		return errCode;// 이 메서드는 주로 getMessage()와 함께 사용될 것이다.
	}
}
