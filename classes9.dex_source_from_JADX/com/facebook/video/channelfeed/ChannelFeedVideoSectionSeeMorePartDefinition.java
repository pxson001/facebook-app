package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: successful_deeplink */
public class ChannelFeedVideoSectionSeeMorePartDefinition extends MultiRowSinglePartDefinition<FeedProps<ChannelFeedVideoSectionSeeMore>, OnClickListener, HasSinglePublisherChannelInfo, View> {
    public static final ViewType f2602a = ViewType.a(2130903549);
    private static ChannelFeedVideoSectionSeeMorePartDefinition f2603d;
    private static final Object f2604e = new Object();
    private final TextPartDefinition f2605b;
    private final Resources f2606c;

    private static ChannelFeedVideoSectionSeeMorePartDefinition m2510b(InjectorLike injectorLike) {
        return new ChannelFeedVideoSectionSeeMorePartDefinition(TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m2512a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object string;
        final ChannelFeedEnvironment channelFeedEnvironment = (ChannelFeedEnvironment) anyEnvironment;
        final ChannelFeedVideoSectionSeeMore channelFeedVideoSectionSeeMore = (ChannelFeedVideoSectionSeeMore) ((FeedProps) obj).a;
        if (channelFeedVideoSectionSeeMore.f2598c) {
            string = this.f2606c.getString(2131237301, new Object[]{channelFeedVideoSectionSeeMore.f2596a});
        } else {
            string = this.f2606c.getString(2131237300, new Object[]{channelFeedVideoSectionSeeMore.f2596a});
        }
        subParts.a(2131558927, this.f2605b, string);
        return new OnClickListener(this) {
            final /* synthetic */ ChannelFeedVideoSectionSeeMorePartDefinition f2601c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2065767552);
                ChannelFeedEnvironment channelFeedEnvironment = channelFeedEnvironment;
                String str = channelFeedVideoSectionSeeMore.f2597b;
                if (channelFeedEnvironment.f2141u != null) {
                    channelFeedEnvironment.f2141u.apply(str);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 830243395, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m2513a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1787282327);
        view.setOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, -1419504274, a);
    }

    @Inject
    public ChannelFeedVideoSectionSeeMorePartDefinition(TextPartDefinition textPartDefinition, Resources resources) {
        this.f2605b = textPartDefinition;
        this.f2606c = resources;
    }

    public final ViewType m2511a() {
        return f2602a;
    }

    public final boolean m2514a(Object obj) {
        return true;
    }

    public static ChannelFeedVideoSectionSeeMorePartDefinition m2509a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoSectionSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2604e) {
                ChannelFeedVideoSectionSeeMorePartDefinition channelFeedVideoSectionSeeMorePartDefinition;
                if (a2 != null) {
                    channelFeedVideoSectionSeeMorePartDefinition = (ChannelFeedVideoSectionSeeMorePartDefinition) a2.a(f2604e);
                } else {
                    channelFeedVideoSectionSeeMorePartDefinition = f2603d;
                }
                if (channelFeedVideoSectionSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2510b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2604e, b3);
                        } else {
                            f2603d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedVideoSectionSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2515b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
