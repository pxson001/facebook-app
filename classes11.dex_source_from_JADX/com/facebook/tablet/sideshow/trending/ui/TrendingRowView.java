package com.facebook.tablet.sideshow.trending.ui;

import android.content.Context;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.tablet.sideshow.trending.model.TrendingRow;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Optional;

/* compiled from: oauth/device */
public class TrendingRowView extends ContentView {
    public TrendingRow f4898h;
    public Optional<BetterTextView> f4899i;
    public Optional<BetterTextView> f4900j;

    public TrendingRowView(Context context) {
        super(context);
        setContentView(2130907567);
        setMaxLinesFromThumbnailSize(false);
        if (getBackground() == null) {
            setBackgroundResource(2130839797);
        }
        this.f4899i = getOptionalView(2131566842);
        this.f4900j = getOptionalView(2131562388);
    }
}
