package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.VideoAttachmentProps;
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
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/24x24/wow */
public class LogFullscreenVideoDisplayedPartDefinition<E extends HasFeedListType & HasPrefetcher & HasScrollListenerSupport> extends BaseSinglePartDefinition<VideoAttachmentProps, ScrollListener, E, View> {
    private static LogFullscreenVideoDisplayedPartDefinition f124f;
    private static final Object f125g = new Object();
    public final VideoLoggingUtils f126a;
    public final VideoAutoPlaySettingsChecker f127b;
    private final ChannelFeedEligibilityUtil f128c;
    public VideoDisplayedInfo f129d = new VideoDisplayedInfo();
    public VideoPlayerParams f130e;

    private static LogFullscreenVideoDisplayedPartDefinition m128b(InjectorLike injectorLike) {
        return new LogFullscreenVideoDisplayedPartDefinition(VideoLoggingUtils.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike));
    }

    public final Object m129a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VideoAttachmentProps videoAttachmentProps = (VideoAttachmentProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        videoAttachmentProps.a.a(FeedAnalyticsUtil.a(hasFeedListType.c()), (HasPrefetcher) hasFeedListType);
        this.f130e = videoAttachmentProps.b.a();
        return new ScrollListener(this, videoAttachmentProps.a, this.f128c.a(videoAttachmentProps.a.d, hasFeedListType.c().a()));
    }

    public final /* bridge */ /* synthetic */ void m130a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 848171768);
        m127a((ScrollListener) obj2, (HasFeedListType) anyEnvironment, view);
        Logger.a(8, EntryType.MARK_POP, -2140758652, a);
    }

    public final void m131b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ScrollListener scrollListener = (ScrollListener) obj2;
        ((HasScrollListenerSupport) ((HasFeedListType) anyEnvironment)).b(scrollListener);
        scrollListener.e = null;
    }

    @Inject
    public LogFullscreenVideoDisplayedPartDefinition(VideoLoggingUtils videoLoggingUtils, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, ChannelFeedEligibilityUtil channelFeedEligibilityUtil) {
        this.f126a = videoLoggingUtils;
        this.f127b = videoAutoPlaySettingsChecker;
        this.f128c = channelFeedEligibilityUtil;
    }

    public static LogFullscreenVideoDisplayedPartDefinition m126a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LogFullscreenVideoDisplayedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f125g) {
                LogFullscreenVideoDisplayedPartDefinition logFullscreenVideoDisplayedPartDefinition;
                if (a2 != null) {
                    logFullscreenVideoDisplayedPartDefinition = (LogFullscreenVideoDisplayedPartDefinition) a2.a(f125g);
                } else {
                    logFullscreenVideoDisplayedPartDefinition = f124f;
                }
                if (logFullscreenVideoDisplayedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m128b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f125g, b3);
                        } else {
                            f124f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = logFullscreenVideoDisplayedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m127a(ScrollListener scrollListener, E e, View view) {
        scrollListener.e = view;
        ((HasScrollListenerSupport) e).a(scrollListener);
        this.f129d.b(false);
    }
}
