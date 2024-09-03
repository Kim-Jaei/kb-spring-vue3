package org.scoula.common.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.scoula.common.pagination.PageRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Page<T> {
    private int totalCount; // 전체 데이터 건수
    private int totlaPage; // 전체 페이지 수
    @JsonIgnore // PageRequest 빼고 전달
    private PageRequest pageRequest;
    private List<T> list; // 데이터 목록

    public static <T> Page of(PageRequest pageRequset, int totalCount, List<T> list) {
        int totalPage = (int)Math.ceil((double)totalCount / pageRequset.getAmount()); // 전체 페이지 수 계산
        return new Page(totalCount, totalPage, pageRequset, list);
    }

    public int getPageNum() { return pageRequest.getPage(); }

    public int getAmount() { return pageRequest.getAmount(); }
}
