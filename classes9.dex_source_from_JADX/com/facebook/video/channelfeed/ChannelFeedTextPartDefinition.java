package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.channelfeed.ChannelFeedExpandingContentTextPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: surface_messenger_ride_service */
public class ChannelFeedTextPartDefinition<E extends HasContext & HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<Props, Void, E, AccessibleTextLayoutView> {
    private static ChannelFeedTextPartDefinition f2512c;
    private static final Object f2513d = new Object();
    private final ChannelFeedExpandingContentTextPartDefinition<E> f2514a;
    private final ChannelFeedBackgroundPartDefinition f2515b;

    private static ChannelFeedTextPartDefinition m2443b(InjectorLike injectorLike) {
        return new ChannelFeedTextPartDefinition(ChannelFeedExpandingContentTextPartDefinition.m2157a(injectorLike), ChannelFeedBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m2445a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f2514a, props);
        subParts.a(this.f2515b, new StylingData(props.f2157a, PaddingStyle.e));
        return null;
    }

    public final boolean m2446a(Object obj) {
        return ChannelFeedExpandingContentTextPartDefinition.m2160a((Props) obj);
    }

    @Inject
    public ChannelFeedTextPartDefinition(ChannelFeedExpandingContentTextPartDefinition channelFeedExpandingContentTextPartDefinition, ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition) {
        this.f2514a = channelFeedExpandingContentTextPartDefinition;
        this.f2515b = channelFeedBackgroundPartDefinition;
    }

    public final ViewType m2444a() {
        return ContentTextLayoutBasePartDefinition.a;
    }

    public static ChannelFeedTextPartDefinition m2442a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2513d) {
                ChannelFeedTextPartDefinition channelFeedTextPartDefinition;
                if (a2 != null) {
                    channelFeedTextPartDefinition = (ChannelFeedTextPartDefinition) a2.a(f2513d);
                } else {
                    channelFeedTextPartDefinition = f2512c;
                }
                if (channelFeedTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2443b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2513d, b3);
                        } else {
                            f2512c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
