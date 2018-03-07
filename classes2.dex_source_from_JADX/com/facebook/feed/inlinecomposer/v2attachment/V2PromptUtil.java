package com.facebook.feed.inlinecomposer.v2attachment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: network_info_finished_req */
public class V2PromptUtil {
    public final Context f12621a;
    private final GlyphColorizer f12622b;

    public static V2PromptUtil m18713b(InjectorLike injectorLike) {
        return new V2PromptUtil((Context) injectorLike.getInstance(Context.class), GlyphColorizer.m11486a(injectorLike));
    }

    @Inject
    public V2PromptUtil(Context context, GlyphColorizer glyphColorizer) {
        this.f12621a = context;
        this.f12622b = glyphColorizer;
    }

    public final Drawable m18714a() {
        return this.f12622b.m11489a(2130838070, -10972929);
    }

    public static Uri m18712a(int i) {
        return ImageRequestBuilder.m18775a(i).m18785m().f12746c;
    }
}
