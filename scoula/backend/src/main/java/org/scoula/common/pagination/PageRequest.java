package org.scoula.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE) // private 생성자 만들고 싶을 때 (외부에서 호출 금지)
public class PageRequest {
    private int page; // 요청 페이지
    private int amount; // 한 페이지 당 데이터 수

    public PageRequest() {
        page = 1;
        amount = 10;
    }

    // 팩토리 메서드, private 생성자 사용하는 곳
    public static PageRequest of(int page, int amount) {
        return new PageRequest(page, amount);
    }

    // offset 값 계산
    public int getOffset() {
        return (page - 1) * amount;
    }
}
