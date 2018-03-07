package com.facebook.widget.dragsortgridview;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/* compiled from: delay_till_next_ping_millisecs */
public abstract class AbstractDragSortGridWithStableIdsAdapter extends AbstractDragSortGridAdapter {
    public Map<Object, Integer> f15929a = Maps.c();

    protected final void m19873a(List<?> list) {
        for (int itemId = ((int) getItemId(getCount() - 1)) + 1; itemId < list.size(); itemId++) {
            this.f15929a.put(list.get(itemId), Integer.valueOf(itemId));
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.f15929a.size()) {
            return -1;
        }
        return (long) ((Integer) this.f15929a.get(getItem(i))).intValue();
    }
}
