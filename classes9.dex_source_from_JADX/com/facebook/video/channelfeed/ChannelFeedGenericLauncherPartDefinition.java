package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener.OnLaunchCallback;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: targetedNux */
public class ChannelFeedGenericLauncherPartDefinition<E extends AnyEnvironment, V extends View> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static ChannelFeedGenericLauncherPartDefinition f2229c;
    private static final Object f2230d = new Object();
    private final LaunchChannelFeedClickListenerProvider f2231a;
    private final Lazy<VideoZeroDialogPartDefinition> f2232b;

    /* compiled from: targetedNux */
    public final class Props {
        public final ChannelFeedParams f2226a;
        public final AtomicReference<FullscreenTransitionListener> f2227b;
        public final OnLaunchCallback f2228c;

        public Props(ChannelFeedParams channelFeedParams, AtomicReference<FullscreenTransitionListener> atomicReference, OnLaunchCallback onLaunchCallback) {
            this.f2226a = channelFeedParams;
            this.f2227b = atomicReference;
            this.f2228c = onLaunchCallback;
        }
    }

    private static ChannelFeedGenericLauncherPartDefinition m2244b(InjectorLike injectorLike) {
        return new ChannelFeedGenericLauncherPartDefinition((LaunchChannelFeedClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LaunchChannelFeedClickListenerProvider.class), IdBasedLazy.a(injectorLike, 1817));
    }

    public final Object m2245a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a((SinglePartDefinition) this.f2232b.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(this.f2231a.a(props.f2226a, null, props.f2227b, null, props.f2228c)));
        return null;
    }

    @Inject
    public ChannelFeedGenericLauncherPartDefinition(LaunchChannelFeedClickListenerProvider launchChannelFeedClickListenerProvider, Lazy<VideoZeroDialogPartDefinition> lazy) {
        this.f2231a = launchChannelFeedClickListenerProvider;
        this.f2232b = lazy;
    }

    public static ChannelFeedGenericLauncherPartDefinition m2243a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedGenericLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2230d) {
                ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition;
                if (a2 != null) {
                    channelFeedGenericLauncherPartDefinition = (ChannelFeedGenericLauncherPartDefinition) a2.a(f2230d);
                } else {
                    channelFeedGenericLauncherPartDefinition = f2229c;
                }
                if (channelFeedGenericLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2244b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2230d, b3);
                        } else {
                            f2229c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedGenericLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
