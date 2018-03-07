package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.text.Layout.Alignment;
import android.util.TypedValue;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: graphql_id */
public class SubtitleTextLayoutBuilderHolder {
    public final TextLayoutBuilder f21930a = new TextLayoutBuilder();

    @Inject
    public SubtitleTextLayoutBuilderHolder(@Assisted Context context, RTLUtil rTLUtil, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843282, typedValue, true);
        this.f21930a.m28604b(context.getResources().getDimensionPixelSize(2131428835));
        this.f21930a.m28606c(typedValue.data);
        this.f21930a.m28600a(false);
        this.f21930a.m28590a((float) context.getResources().getDimensionPixelSize(2131428237));
        this.f21930a.m28597a(rTLUtil.m6557a() ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL);
        this.f21930a.f20866f = true;
        this.f21930a.f20864d = fbTextLayoutCacheWarmer;
    }
}
