package org.example.resp;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Resp<T> extends CommonMessage {
	private T data;
	
	@Builder
	public Resp(int code, String msg, T data, Map<String, String> errors) {
		super(code, msg);
		this.data = data;
	}
	
	public static <T> Resp<T> of(T data) {
		return Resp.<T>builder().data(data).build();
	}
	
	public static <T> Resp<T> of() {
		return Resp.<T>builder().build();
	}
	
	public static <T> Resp<T> of(T data, String msg) {
		return Resp.<T>builder()
				.data(data)
				.msg(msg)
				.build();
	}
}