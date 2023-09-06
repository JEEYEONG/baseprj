package kr.co.baseprj.paging;

import org.springframework.web.util.UriComponentsBuilder;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Objects.requireNonNullElse;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    private String groupCd = "";
    private Integer offset;

    public static final int MIN_PAGE_SIZE = 5;
    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final int MAX_PAGE_SIZE = 50;

    public SearchCondition() {
    }

    public SearchCondition(Integer page, Integer pageSize) {
        this(page, pageSize, "");
    }

    public SearchCondition(Integer page, Integer pageSize, String groupCd) {
        this.page = page;
        this.pageSize = pageSize;
        this.groupCd = groupCd;
    }

    public String getQueryString() {
        return getQueryString(page);
    }

    public String getQueryString(Integer page) {
        // ?page=10&pageSize=10&option=A&keyword=title
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("groupCd", groupCd)
                .build().toString();

    }
    public String getUserQueryString(Integer page) {
        // ?page=10&pageSize=10&option=A&keyword=title
        return UriComponentsBuilder.newInstance()
            .queryParam("page", page)
            .queryParam("pageSize", pageSize)
            .build().toString();

    }
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = requireNonNullElse(pageSize, DEFAULT_PAGE_SIZE);

        // MIN_PAGE_SIZE <= pageSize <= MAX_PAGE_SIZE
        this.pageSize = max(MIN_PAGE_SIZE, min(this.pageSize, MAX_PAGE_SIZE));
    }
    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", groupCd='" + groupCd + '\'' +
                '}';
    }
}