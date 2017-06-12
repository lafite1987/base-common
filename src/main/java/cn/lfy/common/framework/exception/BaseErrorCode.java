package cn.lfy.common.framework.exception;

public interface BaseErrorCode
{

	/**
	 * 今后手机端或网页端与服务端交互时都如下协议数据格式进行交互 协议JSON对象：{“returnCode” :””, “returnMessage” : “”, “returnValue” : “”,” returnUrl “:””} 数据结构由JSON对象构成，外层对象为调用约定对象，里层对象为当前调用接口返回的具体数据对象（被放在外层对象returnValue里）。
	 * 
	 * 该类对returnCode的取值进行描述，设定其范围和定义规则。
	 * 
	 * returnCode : 1. 正确，返回状态码<=1000时为正确,其中普通正确返回值为200，其它有 升级：100、101:更新设置、重定向：300、路由：700 2. 出错，如有异常或错误会有一个>=100000的整数特定状态码，如 100000表示unkonw或undefine的错误码 returnMessage:返回提示信息，特别是当调用失败而服务端又有处理的异常提示 returnValue：当前接口返回来的数据，一个JSON对象
	 * returnUrl：当该属信有返回置时并且returnCode＝＝300时进行页面跳转；普通接口一般为空
	 * 
	 * 注：手机应用与服误端交互访问时，需先解析http协议的状态码，再解析如上自定义协议数据状态码 错误码为以后更高效的定位及帮用户解决特定问题时用，为客服提供FAQ错误码对照表，并能通过log分析错误类别及比例
	 * 
	 * @author likechen
	 * 
	 */
	// 项目或产品名称，该名用于异常处理时该log住 APP_NAME + ERROR_CODE + USER_ID/SN/CELLPHONE_NUMBER/COOIKE_ID(如果能获得)
	static final String APP_NAME = "BI";

	/**
	 * 正确，下面对正确状态码的定义，正确状态码数值<=1000
	 */
	// success code 使用200范围
	static final int SUCCESS = 200;
	// 需要升级程序
	static final int UPGRADE = 100;
	// 需更新配置或数据
	static final int UPGRADE_DATA = 101;
	// 重定向
	static final int REDIRECT = 300;
	// 路由
	static final int ROUTER = 700;

	/**
	 * 出错，下面对错误状态码的定义，错误状态码数值>=100000
	 * 
	 * 每个error code由 6 位的整型数字，分 3 段有含义的数值表示；具体定义方式后面有举例 
	 * 第1段 由第1位数字表示，其代表error的出处 1:server，2:android，3:web page，4:pc client，9:other; 如 1XXXXX，为每个类别定义起始位 
	 * 第2段 由第2～3位数字表示，其代表error的类别
	 * 第3段 由第4～6位数字表示，自然增长，定义是＋
	 */

	// 第1段定义
	static final int SERVER_ERROR = 100000;
	static final int ANDROID_ERROR = 200000;
	static final int WEB_PAGE_ERROR = 300000;
	static final int PC_CLIENT_ERROR = 400000;
	static final int OTHER_ERROR = 900000;

	// 第2段定义，此段数字单独没有意义，必需与第1段及具体错误码结合使用，
	// 未能在初次设计考滤到的类别可自定义
	// 前后端共用类别
	static final int DB = 91000; // DB访问错误
	static final int DS = 92000; // I/O文件类访问错误
	static final int CACHE = 93000; // 缓存类访问错误
	static final int THIRD = 94000; // 特定第三方Local api调用错误，如文件指文计算，文件压缩，IP转城市等
	static final int BS = 95000; // 访问其它应用出错，如其它服务化接口
	static final int SECURITY = 98000; // 安全类出错，试图操作未授权资源
	/**
	 * 账号相关异常
	 */
	static final int ACCOUNT = 99000;
	/**
	 * 独立账号token相关错误
	 */
	static final int TOKEN = 96000;

	// 服务端
	static final int WEB = 10000; // web代码层出错
	static final int BIZ = 20000; // service代码层出错
	static final int DAO = 30000; // dao代码层出错

	// 手机端或PC端
	static final int UI = 50000; // 手机app层出错或PC app层出错
	static final int HTTP = 60000; // 手机服务访问出错

	// Web页面
	static final int JS = 80000; // web html／js前端页面处理出错

	// error code 使用>=100000 && <=999999范围，其中server error code 使用>=100000 && <=199999范围
	// server服务端错务码定义
	static final int ERROR = SERVER_ERROR + 0; // 100000 表示为服务端未知错误unknow，可视为无定义时的默认值undefine
}
