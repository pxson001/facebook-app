package com.facebook.groups.feed.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;

/* compiled from: ThreadListFragment_QPBanner_MissingKey */
public class SeenByBlingBarView extends DefaultBlingBarView {
    public final TextView f22540b = ((TextView) c(2131562039));
    public final String f22541c;
    public final String f22542d;

    public SeenByBlingBarView(Context context) {
        super(context, 2130904580);
        Resources resources = getResources();
        this.f22541c = resources.getString(2131233561);
        this.f22542d = resources.getString(2131233562);
    }
}
