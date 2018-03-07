package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tap_on_attribution_link */
public class ChannelFeedHeaderTextLayoutWidthResolver {
    private static ChannelFeedHeaderTextLayoutWidthResolver f2303g;
    private static final Object f2304h = new Object();
    public final BasePaddingStyleResolver f2305a;
    private final FeedStoryUtil f2306b;
    public final float f2307c;
    public final int f2308d;
    public final int f2309e;
    public final int f2310f;

    private static ChannelFeedHeaderTextLayoutWidthResolver m2278b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderTextLayoutWidthResolver((BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), FeedStoryUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ChannelFeedHeaderTextLayoutWidthResolver(BasePaddingStyleResolver basePaddingStyleResolver, FeedStoryUtil feedStoryUtil, Context context) {
        this.f2305a = basePaddingStyleResolver;
        this.f2306b = feedStoryUtil;
        Resources resources = context.getResources();
        this.f2307c = resources.getDisplayMetrics().density;
        this.f2308d = resources.getDimensionPixelOffset(2131427599);
        this.f2309e = resources.getDimensionPixelOffset(2131427602);
        this.f2310f = resources.getDimensionPixelOffset(2131427600);
    }

    public static ChannelFeedHeaderTextLayoutWidthResolver m2277a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedHeaderTextLayoutWidthResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2304h) {
                ChannelFeedHeaderTextLayoutWidthResolver channelFeedHeaderTextLayoutWidthResolver;
                if (a2 != null) {
                    channelFeedHeaderTextLayoutWidthResolver = (ChannelFeedHeaderTextLayoutWidthResolver) a2.a(f2304h);
                } else {
                    channelFeedHeaderTextLayoutWidthResolver = f2303g;
                }
                if (channelFeedHeaderTextLayoutWidthResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2278b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2304h, b3);
                        } else {
                            f2303g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedHeaderTextLayoutWidthResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
