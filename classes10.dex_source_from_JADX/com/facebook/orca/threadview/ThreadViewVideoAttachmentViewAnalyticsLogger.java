package com.facebook.orca.threadview;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.model.messages.Message;
import javax.inject.Inject;

/* compiled from: maybeShowThreadListTooltip */
public class ThreadViewVideoAttachmentViewAnalyticsLogger {
    private final AnalyticsLogger f8123a;
    private final FbNetworkManager f8124b;

    private static ThreadViewVideoAttachmentViewAnalyticsLogger m8046b(InjectorLike injectorLike) {
        return new ThreadViewVideoAttachmentViewAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    public ThreadViewVideoAttachmentViewAnalyticsLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager) {
        this.f8123a = analyticsLogger;
        this.f8124b = fbNetworkManager;
    }

    public static ThreadViewVideoAttachmentViewAnalyticsLogger m8045a(InjectorLike injectorLike) {
        return m8046b(injectorLike);
    }

    public final void m8047a(String str, Message message, VideoAttachmentData videoAttachmentData) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "video_upload";
        honeyClientEvent = honeyClientEvent.b("network", this.f8124b.p());
        if (message != null) {
            honeyClientEvent.a("thread_key", message.b).b("message_id", message.a).b("offline_threading_id", message.n).a("message_type", message.l);
        }
        if (videoAttachmentData != null) {
            honeyClientEvent.a("source", videoAttachmentData.h).a("duration_ms", videoAttachmentData.d).a("filesize", videoAttachmentData.e);
        }
        this.f8123a.a(honeyClientEvent);
    }
}
