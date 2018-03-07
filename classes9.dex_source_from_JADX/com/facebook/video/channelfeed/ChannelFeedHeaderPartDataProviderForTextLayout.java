package com.facebook.video.channelfeed;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.LazyResources;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderTimeInfoFormatter;
import com.facebook.feedplugins.graphqlstory.header.HeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.graphqlstory.header.HeaderPartDataProviderForTextLayout.HeaderSubtitleData;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tapped_fundraiser_share_attachment */
public class ChannelFeedHeaderPartDataProviderForTextLayout implements HeaderPartDataProviderForTextLayout {
    private static ChannelFeedHeaderPartDataProviderForTextLayout f2280d;
    private static final Object f2281e = new Object();
    private final DefaultHeaderTimeInfoFormatter f2282a;
    public final Lazy<String> f2283b;
    public final Lazy<String> f2284c;

    private static ChannelFeedHeaderPartDataProviderForTextLayout m2267b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderPartDataProviderForTextLayout((Context) injectorLike.getInstance(Context.class), DefaultHeaderTimeInfoFormatter.a(injectorLike));
    }

    @Inject
    public ChannelFeedHeaderPartDataProviderForTextLayout(Context context, DefaultHeaderTimeInfoFormatter defaultHeaderTimeInfoFormatter) {
        this.f2282a = defaultHeaderTimeInfoFormatter;
        this.f2283b = LazyResources.a(context, 2131233387);
        this.f2284c = LazyResources.a(context, 2131233386);
    }

    public static ChannelFeedHeaderPartDataProviderForTextLayout m2266a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedHeaderPartDataProviderForTextLayout b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2281e) {
                ChannelFeedHeaderPartDataProviderForTextLayout channelFeedHeaderPartDataProviderForTextLayout;
                if (a2 != null) {
                    channelFeedHeaderPartDataProviderForTextLayout = (ChannelFeedHeaderPartDataProviderForTextLayout) a2.a(f2281e);
                } else {
                    channelFeedHeaderPartDataProviderForTextLayout = f2280d;
                }
                if (channelFeedHeaderPartDataProviderForTextLayout == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2267b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2281e, b3);
                        } else {
                            f2280d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedHeaderPartDataProviderForTextLayout;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final HeaderSubtitleData m2268a(FeedProps<GraphQLStory> feedProps, TextPaint textPaint, Paint paint, int i) {
        Flattenable flattenable = feedProps.a;
        String a = this.f2282a.a(feedProps);
        GraphQLSponsoredData r = GraphQLStoryUtil.r(feedProps);
        String str = (r == null || !r.n()) ? null : r.b() ? (String) this.f2283b.get() : (String) this.f2284c.get();
        CharSequence charSequence = str;
        if (!StoryProps.n(feedProps) || charSequence == null) {
            Object obj = a;
        }
        return new HeaderSubtitleData((int) Math.ceil((double) textPaint.measureText(charSequence.toString())), charSequence, 0);
    }
}
