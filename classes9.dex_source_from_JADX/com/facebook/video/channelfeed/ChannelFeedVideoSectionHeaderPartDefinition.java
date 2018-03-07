package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
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
/* compiled from: suggested_codename */
public class ChannelFeedVideoSectionHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<ChannelFeedVideoSectionHeader>, Void, AnyEnvironment, ChannelFeedVideoSectionHeaderView> {
    public static final ViewType f2589a = new C02381();
    private static ChannelFeedVideoSectionHeaderPartDefinition f2590d;
    private static final Object f2591e = new Object();
    public final ChannelFeedFocusDimmingManager f2592b;
    private final TextPartDefinition f2593c;

    /* compiled from: suggested_codename */
    final class C02381 extends ViewType {
        C02381() {
        }

        public final View m2499a(Context context) {
            return new ChannelFeedVideoSectionHeaderView(context);
        }
    }

    private static ChannelFeedVideoSectionHeaderPartDefinition m2501b(InjectorLike injectorLike) {
        return new ChannelFeedVideoSectionHeaderPartDefinition(TextPartDefinition.a(injectorLike), ChannelFeedFocusDimmingManager.m2177a(injectorLike));
    }

    public final Object m2503a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131558927, this.f2593c, ((ChannelFeedVideoSectionHeader) ((FeedProps) obj).a).f2588a);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m2504a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 408542088);
        this.f2592b.m2186a((ChannelFeedVideoSectionHeaderView) view);
        Logger.a(8, EntryType.MARK_POP, 83073877, a);
    }

    public final void m2506b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        this.f2592b.f2184d.remove((ChannelFeedVideoSectionHeaderView) view);
    }

    @Inject
    public ChannelFeedVideoSectionHeaderPartDefinition(TextPartDefinition textPartDefinition, ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
        this.f2593c = textPartDefinition;
        this.f2592b = channelFeedFocusDimmingManager;
    }

    public final ViewType m2502a() {
        return f2589a;
    }

    public final boolean m2505a(Object obj) {
        return true;
    }

    public static ChannelFeedVideoSectionHeaderPartDefinition m2500a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoSectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2591e) {
                ChannelFeedVideoSectionHeaderPartDefinition channelFeedVideoSectionHeaderPartDefinition;
                if (a2 != null) {
                    channelFeedVideoSectionHeaderPartDefinition = (ChannelFeedVideoSectionHeaderPartDefinition) a2.a(f2591e);
                } else {
                    channelFeedVideoSectionHeaderPartDefinition = f2590d;
                }
                if (channelFeedVideoSectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2501b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2591e, b3);
                        } else {
                            f2590d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedVideoSectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
