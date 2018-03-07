package com.facebook.feed.history;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.edithistory.EditHistoryAdapter;
import javax.inject.Inject;

/* compiled from: drawerWidth */
public class StoryEditHistoryAdapter extends EditHistoryAdapter {
    @Inject
    public StoryEditHistoryAdapter(TimeFormatUtil timeFormatUtil, LinkifyUtil linkifyUtil) {
        super(timeFormatUtil, linkifyUtil);
    }

    protected final int m8730a() {
        return 2130904340;
    }

    public final void m8731a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        super.a(i, obj, view, i2, viewGroup);
        if (obj == getItem(0)) {
            view.setBackgroundResource(2130840250);
        } else if (obj == getItem(getCount() - 1)) {
            view.setBackgroundResource(2130840247);
        } else {
            view.setBackgroundResource(2130840249);
        }
    }
}
