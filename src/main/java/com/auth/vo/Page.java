package com.auth.vo;
import lombok.Data;

import java.util.Collections;
import java.util.List;
/**
 * Created by yuxb on 16/5/17.
 */

/**
 * 分页封装类
 * 用于做分页查询的基础类，封装了一些分页的相关属性
 *
 * @param <T>
 * @author yuxb
 * @version v1.0
 */

public class Page<T> {

    // 下一页
    private int pageNo;

    // 当前页
    private int currentPage;

    // 每页个个数
    private int pageSize;

    // 总条数
    private int totalCount;

    // 总页数
    private int pageCount;

    // 记录
    private List<T> results;

    public Page() {
        this(1 ,20,0,(List<T>) Collections.EMPTY_LIST);
    }

    public Page(int pageNo, int pageSize, int totalCount, List<T> results) {

        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.results = results;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        if (pageNo <= 0) {
            return 1;
        } else {
            return pageNo > pageCount ? pageCount : pageNo;
        }
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void resetPageNo() {
        pageNo = currentPage + 1;
        pageCount = totalCount % pageSize == 0 ? totalCount / pageSize
                : totalCount / pageSize + 1;
    }

}