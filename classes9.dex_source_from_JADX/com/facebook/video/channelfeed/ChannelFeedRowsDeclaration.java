package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: switchFeed() not supported yet */
public class ChannelFeedRowsDeclaration implements FeedRowSupportDeclaration {
    private static ChannelFeedRowsDeclaration f2481a;
    private static final Object f2482b = new Object();

    private static ChannelFeedRowsDeclaration m2411a() {
        return new ChannelFeedRowsDeclaration();
    }

    public final void m2413a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(ChannelFeedHeaderPartDefinition.f2287a, ChannelFeedSocialContextHeaderPartDefinition.f2483a, ChannelFeedVideoPartDefinition.f2384b, ChannelFeedVideoPlaysBlingBarPartDefinition.f2536a, ChannelFeedBlingBarPartDefinition.f2105a, ChannelFeedVideoSectionHeaderPartDefinition.f2589a, ChannelFeedVideoSectionSeeMorePartDefinition.f2602a, VideoHomePublisherInfoPartDefinition.f2701a, SocialContextPartDefinition.f2650a, MultiShareChannelFeedDividerPartDefinition.f2621a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }

    public static ChannelFeedRowsDeclaration m2412a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedRowsDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f2482b) {
                ChannelFeedRowsDeclaration channelFeedRowsDeclaration;
                if (a3 != null) {
                    channelFeedRowsDeclaration = (ChannelFeedRowsDeclaration) a3.a(f2482b);
                } else {
                    channelFeedRowsDeclaration = f2481a;
                }
                if (channelFeedRowsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m2411a();
                        if (a3 != null) {
                            a3.a(f2482b, a2);
                        } else {
                            f2481a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = channelFeedRowsDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
