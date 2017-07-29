package cn.lfy.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		objectMapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	/**
	 * 将对象序列化成json字符串
	 * @param object
	 * @return
	 */
	public static String object2Json(Object object) {
		if (object == null) {
			return "";
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.info("object2Json exception. object:" + object.toString(),e);
			return "";
		}
	}

	/**
	 * json转换成java bean
	 */
	public static <T> T json2Object(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			logger.error("json2Object exception. json:" + json, e);
			return null;
		}
	}

	/**
	 * json转换成List<Object>
	 *
	 */
	public static <T> List<T> json2List(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return Lists.newArrayList();
		}
		try {
			JavaType javaType = objectMapper.getTypeFactory()
					.constructParametricType(ArrayList.class, clazz);
			return objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			logger.error("json2List exception. json:" + json, e);
			return Lists.newArrayList();
		}
	}

	/**
	 * json转换map<Object,Object>
	 */
	public static <K, V> Map<K, V> json2Map(String json, Class<K> keyClass,
			Class<V> valueClass) {
		if (StringUtils.isBlank(json)) {
			return Maps.newHashMap();
		}

		try {
			JavaType javaType = objectMapper.getTypeFactory()
					.constructParametricType(HashMap.class, keyClass,
							valueClass);
			return objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			logger.error("json2Map exception. json:" + json, e);
			return Maps.newHashMap();
		}
	}

	public static void main(String[] args) {
		String userJson = "{\"type\":\"REFRESH\",\"data\":{\"version\":2}}";
		JsonNode jsonNode;
		try {
			jsonNode = objectMapper.readTree(userJson);
			System.out.println(jsonNode.get("data").get("version").intValue());
			System.out.println(jsonNode.get("type").textValue());
			Map<String, Object> map = JsonUtil.json2Map(userJson, String.class, Object.class);
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
