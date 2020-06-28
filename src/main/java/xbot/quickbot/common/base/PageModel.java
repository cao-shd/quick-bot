package xbot.quickbot.common.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonView;
import xbot.quickbot.common.view.TableView;

import java.util.List;

public class PageModel<T> extends Page<T> {

    @Override
    @JsonView(TableView.class)
    public List<T> getRecords() {
        return super.getRecords();
    }

    @Override
    @JsonView(TableView.class)
    public long getTotal() {
        return super.getTotal();
    }

    @Override
    @JsonView(TableView.class)
    public long getSize() {
        return super.getSize();
    }

    @Override
    @JsonView(TableView.class)
    public long getCurrent() {
        return super.getCurrent();
    }

}
