package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: it_IT */
public class PageStyleFactory {
    private final Context f18732a;
    private final BasePaddingStyleResolver f18733b;
    private final FeedRenderUtils f18734c;

    public static PageStyleFactory m26330b(InjectorLike injectorLike) {
        return new PageStyleFactory((Context) injectorLike.getInstance(Context.class), FeedRenderUtils.m14652a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike));
    }

    @Inject
    public PageStyleFactory(Context context, FeedRenderUtils feedRenderUtils, BasePaddingStyleResolver basePaddingStyleResolver) {
        this.f18732a = context;
        this.f18734c = feedRenderUtils;
        this.f18733b = basePaddingStyleResolver;
    }

    public static PageStyleFactory m26329a(InjectorLike injectorLike) {
        return m26330b(injectorLike);
    }

    public final PageStyle m26332a(float f, PaddingStyle paddingStyle, boolean z) {
        return PageStyle.a(f, this.f18734c.m14654a() - SizeUtil.m19191a(this.f18732a, this.f18733b.m19175a(paddingStyle).f13047d.mo2553a(0) * 2.0f), z);
    }

    public final PageStyle m26331a(float f, PaddingStyle paddingStyle) {
        return m26332a(f, paddingStyle, false);
    }

    public final PageStyle m26333a(PaddingStyle paddingStyle) {
        int a = this.f18734c.m14654a() - SizeUtil.m19191a(this.f18732a, this.f18733b.m19175a(paddingStyle).f13047d.mo2553a(0) * 2.0f);
        return PageStyle.a((float) SizeUtil.m19198c(this.f18732a, (float) a), a, true);
    }
}
