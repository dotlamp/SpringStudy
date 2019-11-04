package com.dotlamp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {
	
	@NonNull /* @NonNull : 특정한 변수에 대해서만 생성자를 작성하고 싶다면 사용*/
	private Chef chef;
	
	/*
	 * @AllArgsConsturctor 어노테이션 이용하면
	 * 아래 생성자 생략해도됨.
	 * public SampleHotel(Chef chef) { this.chef = chef; }
	 */
}
