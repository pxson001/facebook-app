package com.facebook.feed.topicfeeds.switcher;

import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.C29542;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: TPICKER_SCREEN_PARAM;TFETCHER_PARAMS;)V */
public class FeedSwitcherAdapterProvider extends AbstractAssistedProvider<FeedSwitcherAdapter> {
    public final FeedSwitcherAdapter m26534a(boolean z, boolean z2, boolean z3, C29542 c29542) {
        return new FeedSwitcherAdapter(z, z2, z3, c29542, GlyphColorizer.a(this), ScreenUtil.a(this));
    }
}
