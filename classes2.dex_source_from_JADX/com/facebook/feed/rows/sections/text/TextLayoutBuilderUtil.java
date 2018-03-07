package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: host_name_v6 */
public class TextLayoutBuilderUtil {
    private static TextLayoutBuilderUtil f20856d;
    private static final Object f20857e = new Object();
    private final BasePaddingStyleResolver f20858a;
    private final FeedRenderUtils f20859b;
    private final float f20860c;

    private static TextLayoutBuilderUtil m28587b(InjectorLike injectorLike) {
        return new TextLayoutBuilderUtil(DefaultPaddingStyleResolver.m19157a(injectorLike), FeedRenderUtils.m14652a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public TextLayoutBuilderUtil(BasePaddingStyleResolver basePaddingStyleResolver, FeedRenderUtils feedRenderUtils, Resources resources) {
        this.f20858a = basePaddingStyleResolver;
        this.f20859b = feedRenderUtils;
        this.f20860c = resources.getDisplayMetrics().density;
    }

    public static TextLayoutBuilder m28585a(Context context, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer) {
        TextLayoutBuilder textLayoutBuilder = new TextLayoutBuilder();
        textLayoutBuilder.m28604b(context.getResources().getDimensionPixelSize(2131430351));
        textLayoutBuilder.m28606c(ContextUtils.m2503c(context, 2130772561, 2131362048));
        textLayoutBuilder.m28590a(context.getResources().getDimension(2131430350));
        textLayoutBuilder.m28603b(1.0f);
        textLayoutBuilder.m28600a(false);
        textLayoutBuilder.f20866f = true;
        textLayoutBuilder.f20864d = fbTextLayoutCacheWarmer;
        return textLayoutBuilder;
    }

    public static TextLayoutBuilderUtil m28586a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextLayoutBuilderUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20857e) {
                TextLayoutBuilderUtil textLayoutBuilderUtil;
                if (a2 != null) {
                    textLayoutBuilderUtil = (TextLayoutBuilderUtil) a2.mo818a(f20857e);
                } else {
                    textLayoutBuilderUtil = f20856d;
                }
                if (textLayoutBuilderUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28587b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20857e, b3);
                        } else {
                            f20856d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textLayoutBuilderUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m28589a(TextLayoutBuilder textLayoutBuilder, @Nullable FeedProps<GraphQLStory> feedProps) {
        textLayoutBuilder.m28592a(m28588a((FeedProps) feedProps));
    }

    public final int m28588a(@Nullable FeedProps<GraphQLStory> feedProps) {
        return this.f20859b.m14654a() - (this.f20858a.m19174a(PaddingStyle.f13071a, (FeedProps) feedProps, this.f20860c) * 2);
    }
}
