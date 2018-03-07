package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.CenterDistanceVideoDisplaySelector;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: targeting */
public class ChannelFeedFullscreenPartDefinition<V extends View> extends BaseSinglePartDefinition<String, VideoViewController, AnyEnvironment, V> {
    private static ChannelFeedFullscreenPartDefinition f2207c;
    private static final Object f2208d = new Object();
    public final VideoDisplayedCoordinator<V> f2209a;
    private final ChannelFeedFullscreenControllerProvider f2210b;

    private static ChannelFeedFullscreenPartDefinition m2212b(InjectorLike injectorLike) {
        return new ChannelFeedFullscreenPartDefinition(CenterDistanceVideoDisplaySelector.b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), (ChannelFeedFullscreenControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedFullscreenControllerProvider.class));
    }

    public final Object m2213a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new ChannelFeedFullscreenController((String) obj, ChannelFeedFullscreenManager.m2197a(this.f2210b));
    }

    public final /* bridge */ /* synthetic */ void m2214a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -604939818);
        this.f2209a.a(view, (VideoViewController) obj2);
        Logger.a(8, EntryType.MARK_POP, -1597466263, a);
    }

    @Inject
    public ChannelFeedFullscreenPartDefinition(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, ChannelFeedFullscreenControllerProvider channelFeedFullscreenControllerProvider) {
        this.f2210b = channelFeedFullscreenControllerProvider;
        this.f2209a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
    }

    public static ChannelFeedFullscreenPartDefinition m2211a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedFullscreenPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2208d) {
                ChannelFeedFullscreenPartDefinition channelFeedFullscreenPartDefinition;
                if (a2 != null) {
                    channelFeedFullscreenPartDefinition = (ChannelFeedFullscreenPartDefinition) a2.a(f2208d);
                } else {
                    channelFeedFullscreenPartDefinition = f2207c;
                }
                if (channelFeedFullscreenPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2212b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2208d, b3);
                        } else {
                            f2207c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedFullscreenPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
