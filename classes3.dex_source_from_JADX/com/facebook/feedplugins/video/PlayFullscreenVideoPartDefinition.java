package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.VideoAttachmentProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/24x24/sad */
public class PlayFullscreenVideoPartDefinition<E extends HasPrefetcher & HasFeedListType> extends BaseSinglePartDefinition<VideoAttachmentProps, Void, E, View> {
    private static PlayFullscreenVideoPartDefinition f131c;
    private static final Object f132d = new Object();
    private final FullscreenVideoLauncherProvider f133a;
    private final ClickListenerPartDefinition f134b;

    private static PlayFullscreenVideoPartDefinition m133b(InjectorLike injectorLike) {
        return new PlayFullscreenVideoPartDefinition((FullscreenVideoLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FullscreenVideoLauncherProvider.class), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m134a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VideoAttachmentProps videoAttachmentProps = (VideoAttachmentProps) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        videoAttachmentProps.a.a(FeedAnalyticsUtil.a(((HasFeedListType) hasPrefetcher).c()), hasPrefetcher);
        subParts.a(this.f134b, new 1(this, this.f133a.m135a(videoAttachmentProps.a)));
        return null;
    }

    @Inject
    public PlayFullscreenVideoPartDefinition(FullscreenVideoLauncherProvider fullscreenVideoLauncherProvider, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f133a = fullscreenVideoLauncherProvider;
        this.f134b = clickListenerPartDefinition;
    }

    public static PlayFullscreenVideoPartDefinition m132a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlayFullscreenVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f132d) {
                PlayFullscreenVideoPartDefinition playFullscreenVideoPartDefinition;
                if (a2 != null) {
                    playFullscreenVideoPartDefinition = (PlayFullscreenVideoPartDefinition) a2.a(f132d);
                } else {
                    playFullscreenVideoPartDefinition = f131c;
                }
                if (playFullscreenVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m133b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f132d, b3);
                        } else {
                            f131c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = playFullscreenVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
