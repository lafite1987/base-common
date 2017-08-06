package cn.lfy.common.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultDTO<T> {

	@ApiModelProperty(value = "错误码", required = true)
	private int code = 200;
	@ApiModelProperty(value = "错误信息", required = false)
	private String message = "";
	@ApiModelProperty(value = "数据对象", required = false)
	private T data;
	@ApiModelProperty(value = "重定向地址，当错误码等于302时，请重定向到该地址", required = false)
	private String redirect = "";
	
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

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
}
