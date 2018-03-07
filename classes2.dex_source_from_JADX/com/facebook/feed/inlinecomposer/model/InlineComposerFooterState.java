package com.facebook.feed.inlinecomposer.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.locale.Locales;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: media_controls */
public class InlineComposerFooterState {
    public final String f14572a;
    public final String f14573b;
    public final String f14574c;
    @Nullable
    public final Drawable f14575d;

    private InlineComposerFooterState(String str, String str2, String str3, Drawable drawable) {
        this.f14572a = str;
        this.f14573b = str2;
        this.f14574c = str3;
        this.f14575d = drawable;
    }

    public static InlineComposerFooterState m20988a(Resources resources, InlineComposerModel inlineComposerModel, Locales locales) {
        Drawable drawable = null;
        if (inlineComposerModel.f12918m != 0) {
            drawable = resources.getDrawable(inlineComposerModel.f12918m);
        }
        return new InlineComposerFooterState(inlineComposerModel.f12915j.toUpperCase(locales.m2609a()), inlineComposerModel.f12914i.toUpperCase(locales.m2609a()), inlineComposerModel.f12916k.toUpperCase(locales.m2609a()), drawable);
    }
}
