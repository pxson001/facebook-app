package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.BaseHeaderSubtitleWithLayoutPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tap_on_internal_attribution_link */
public class ChannelFeedHeaderSubtitleWithLayoutPartDefinition<E extends HasContext & HasMenuButtonProvider> extends BaseSinglePartDefinition<Props, Void, E, TextLayoutView> {
    private static ChannelFeedHeaderSubtitleWithLayoutPartDefinition f2299c;
    private static final Object f2300d = new Object();
    private final BaseHeaderSubtitleWithLayoutPartDefinition<E> f2301a;
    private final ChannelFeedHeaderPartDataProviderForTextLayout f2302b;

    /* compiled from: tap_on_internal_attribution_link */
    public class Props {
        public final FeedProps<GraphQLStory> f2297a;
        public final int f2298b;

        public Props(FeedProps<GraphQLStory> feedProps, int i) {
            this.f2297a = feedProps;
            this.f2298b = i;
        }
    }

    private static ChannelFeedHeaderSubtitleWithLayoutPartDefinition m2275b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderSubtitleWithLayoutPartDefinition(BaseHeaderSubtitleWithLayoutPartDefinition.a(injectorLike), ChannelFeedHeaderPartDataProviderForTextLayout.m2266a(injectorLike));
    }

    public final Object m2276a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f2301a, new com.facebook.feed.rows.sections.header.BaseHeaderSubtitleWithLayoutPartDefinition.Props(props.f2297a, this.f2302b, props.f2298b));
        return null;
    }

    @Inject
    public ChannelFeedHeaderSubtitleWithLayoutPartDefinition(BaseHeaderSubtitleWithLayoutPartDefinition baseHeaderSubtitleWithLayoutPartDefinition, ChannelFeedHeaderPartDataProviderForTextLayout channelFeedHeaderPartDataProviderForTextLayout) {
        this.f2301a = baseHeaderSubtitleWithLayoutPartDefinition;
        this.f2302b = channelFeedHeaderPartDataProviderForTextLayout;
    }

    public static ChannelFeedHeaderSubtitleWithLayoutPartDefinition m2274a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedHeaderSubtitleWithLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2300d) {
                ChannelFeedHeaderSubtitleWithLayoutPartDefinition channelFeedHeaderSubtitleWithLayoutPartDefinition;
                if (a2 != null) {
                    channelFeedHeaderSubtitleWithLayoutPartDefinition = (ChannelFeedHeaderSubtitleWithLayoutPartDefinition) a2.a(f2300d);
                } else {
                    channelFeedHeaderSubtitleWithLayoutPartDefinition = f2299c;
                }
                if (channelFeedHeaderSubtitleWithLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2275b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2300d, b3);
                        } else {
                            f2299c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedHeaderSubtitleWithLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
