package cn.myth.base;

public class Result {
	private Exception exception = null;

	public boolean isSuccess() {
		return exception == null;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public void setResult(Result res) {
		setException(res.getException());
	}

	public Result() {
		// TODO Auto-generated constructor stub
	}

}
