package cn.myth.base;

public class ResultData<T> extends Result {

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T data;

	@SuppressWarnings("unchecked")
	@Override
	public void setResult(Result result) {
		super.setResult(result);
		if (result instanceof ResultData) {
			this.setData((((ResultData<T>) result).getData()));
		}
	}
}
