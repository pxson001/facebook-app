package com.facebook.groups.sideshow.ui;

import android.content.Context;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.groups.sideshow.model.RecentActiveGroupRow;

/* compiled from: was_overlay_shown */
public class RecentActiveGroupRowView extends ContentView {
    public RecentActiveGroupRow f349h;

    public RecentActiveGroupRowView(Context context) {
        super(context);
        setContentView(2130906748);
        setThumbnailSize(ThumbnailSize.LARGE);
        setMaxLinesFromThumbnailSize(false);
        if (getBackground() == null) {
            setBackgroundResource(2130839797);
        }
    }
}
