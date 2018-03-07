package com.facebook.orca.threadview;

import android.view.View;
import android.widget.ListView;
import com.facebook.widget.listview.DataItemWithId;
import com.facebook.widget.listview.ListViewItemWithDataUtil;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: messenger_group_change_thread_approval_settings */
public class MessagesListViewScrollDeltaHelper {
    private final ListView f7233a;
    private Map<Long, Integer> f7234b = Maps.c();
    private Map<Long, Integer> f7235c = Maps.c();

    public MessagesListViewScrollDeltaHelper(ListView listView) {
        this.f7233a = listView;
    }

    public final int m6920a(int i, int i2) {
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i) {
                int i6;
                View childAt = this.f7233a.getChildAt(i4);
                Object a = ListViewItemWithDataUtil.a(childAt);
                if (a instanceof DataItemWithId) {
                    long a2 = ((DataItemWithId) a).a();
                    int top = childAt.getTop();
                    this.f7235c.put(Long.valueOf(a2), Integer.valueOf(top));
                    if (i5 == 0) {
                        Integer num = (Integer) this.f7234b.get(Long.valueOf(a2));
                        if (num != null) {
                            i5 = top - num.intValue();
                            i6 = 1;
                            i4++;
                            i3 = i5;
                            i5 = i6;
                        }
                    }
                }
                i6 = i5;
                i5 = i3;
                i4++;
                i3 = i5;
                i5 = i6;
            }
        }
        Map map = this.f7234b;
        this.f7234b = this.f7235c;
        this.f7235c = map;
        this.f7235c.clear();
        return i3;
    }
}
