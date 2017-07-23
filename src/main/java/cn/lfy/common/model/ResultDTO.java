package cn.lfy.common.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultDTO<T> {

	@ApiModelProperty(value = "错误码", required = true)
	private int code;
	@ApiModelProperty(value = "错误信息", required = false)
	private String message = "";
	@ApiModelProperty(value = "数据对象", required = false)
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
