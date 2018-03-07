package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

/* compiled from: search_places */
public class PageInsightsOverviewCardMetricComponentView extends CustomLinearLayout {
    @Inject
    public GlyphColorizer f2172a;
    public final FbTextView f2173b = ((FbTextView) a(2131565610));
    public final FbTextView f2174c = ((FbTextView) a(2131565609));
    public final FbTextView f2175d = ((FbTextView) a(2131565611));

    public static void m3169a(Object obj, Context context) {
        ((PageInsightsOverviewCardMetricComponentView) obj).f2172a = GlyphColorizer.a(FbInjector.get(context));
    }

    public PageInsightsOverviewCardMetricComponentView(Context context) {
        super(context);
        Class cls = PageInsightsOverviewCardMetricComponentView.class;
        m3169a(this, getContext());
        setOrientation(0);
        setContentView(2130906062);
        CustomViewUtils.b(this, ContextCompat.a(context, 2130842474));
    }
}
