package br.com.archtype.enumerated;

public enum OrderQueryEnum {

	ASC(1, "ASC"), DESC(2, "DESC");

	private Integer code;
	private String description;

	private OrderQueryEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public static String getOrder(Integer code) {
		for (OrderQueryEnum e : OrderQueryEnum.values()) {

			if (e.code == code)
				return e.description;

		}
		return "";
	}

}
