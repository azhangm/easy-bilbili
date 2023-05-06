package nuc.zm.server.dto;

import java.util.List;

public class PageDto<T> {

    private int page;

    private int size;

    private long total;

    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setTotal(long total) {
        this.total = total;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }
}
