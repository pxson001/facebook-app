package com.facebook.messaging.analytics.navigation;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.activitytracer.ActivityTrace;
import com.facebook.debug.activitytracer.ActivityTracer;
import com.facebook.debug.activitytracer.ActivityTracer.2;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageAttachmentInfo;
import com.facebook.messaging.model.messages.MessageAttachmentInfoFactory;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_initiate_csc */
public class MessagingAnalyticsLogger {
    public final AnalyticsLogger f7627a;
    private final NavigationLogger f7628b;
    private final MessageUtil f7629c;
    public final MessageAttachmentInfoFactory f7630d;
    private final ThreadUnreadCountUtil f7631e;
    private final ThreadParticipantUtils f7632f;
    public final ActivityTracer f7633g;
    private final Provider<String> f7634h;

    public static MessagingAnalyticsLogger m7908b(InjectorLike injectorLike) {
        return new MessagingAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike), MessageUtil.a(injectorLike), MessageAttachmentInfoFactory.b(injectorLike), ThreadUnreadCountUtil.m10184a(injectorLike), ThreadParticipantUtils.m10155a(injectorLike), ActivityTracer.a(injectorLike), IdBasedProvider.a(injectorLike, 4439));
    }

    public static MessagingAnalyticsLogger m7905a(InjectorLike injectorLike) {
        return m7908b(injectorLike);
    }

    @Inject
    public MessagingAnalyticsLogger(AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, MessageUtil messageUtil, MessageAttachmentInfoFactory messageAttachmentInfoFactory, ThreadUnreadCountUtil threadUnreadCountUtil, ThreadParticipantUtils threadParticipantUtils, ActivityTracer activityTracer, Provider<String> provider) {
        this.f7627a = analyticsLogger;
        this.f7628b = navigationLogger;
        this.f7629c = messageUtil;
        this.f7630d = messageAttachmentInfoFactory;
        this.f7631e = threadUnreadCountUtil;
        this.f7632f = threadParticipantUtils;
        this.f7633g = activityTracer;
        this.f7634h = provider;
    }

    public final void m7914a(String str, String str2) {
        m7904a(str, str2, (String) this.f7634h.get());
    }

    public final void m7915a(String str, String str2, @Nullable Activity activity, @Nullable Map<String, String> map) {
        String str3 = (String) this.f7634h.get();
        m7904a(str, str2, str3);
        this.f7628b.a(activity, str, str2, str3, map);
    }

    public final void m7912a(String str) {
        ActivityTrace activityTrace = this.f7633g.g;
        if (activityTrace != null) {
            activityTrace.c(str);
        }
    }

    public final void m7913a(String str, Object obj) {
        ActivityTrace activityTrace = this.f7633g.g;
        if (activityTrace != null) {
            activityTrace.a(str, obj);
        }
    }

    public final void m7916b(String str) {
        ActivityTrace activityTrace = this.f7633g.g;
        if (activityTrace != null) {
            activityTrace.a(str);
        }
    }

    public final void m7911a(Message message, @Nullable NavigationTrigger navigationTrigger, @Nullable MessageSendTrigger messageSendTrigger) {
        ActivityTrace activityTrace = this.f7633g.g;
        if (activityTrace != null) {
            if (MessageUtil.A(message)) {
                activityTrace.a("has_text");
            }
            if (navigationTrigger != null) {
                activityTrace.a(navigationTrigger.toString());
            }
            if (messageSendTrigger != null) {
                activityTrace.a("message_send_trigger", messageSendTrigger);
            }
            MessageAttachmentInfo a = this.f7630d.a(message);
            m7910b(activityTrace, "has_like", a.f);
            m7910b(activityTrace, "has_sticker", a.e);
            m7907a(activityTrace, "num_photos", a.b);
            m7907a(activityTrace, "num_videos", a.c);
            m7907a(activityTrace, "num_audio_clips", a.d);
            m7907a(activityTrace, "num_share_attachments", a.g);
            m7910b(activityTrace, "has_payment", a.h);
            m7910b(activityTrace, "has_xma", a.i);
        }
    }

    private ActivityTrace m7904a(String str, String str2, String str3) {
        ActivityTrace a = this.f7633g.a("navigation", StringFormatUtil.formatStrLocaleSafe("Navigation from %s to %s", str, str2));
        if (a == null) {
            return null;
        }
        if (!(a.g == null || a.g == str)) {
            a.a("prev_source:" + str);
        }
        a.g = str;
        a.c(str2).i = str3;
        return a;
    }

    public final void m7917c(String str) {
        ActivityTrace activityTrace = this.f7633g.g;
        if (activityTrace != null && activityTrace.h == str) {
            activityTrace.j = (String) this.f7634h.get();
            ActivityTracer activityTracer = this.f7633g;
            activityTracer.b.a();
            HandlerDetour.a(activityTracer.f, new 2(activityTracer), 963974095);
        }
    }

    public static void m7906a(HoneyClientEvent honeyClientEvent, String str, int i) {
        if (i > 0) {
            honeyClientEvent.a(str, i);
        }
    }

    public static void m7909b(HoneyClientEvent honeyClientEvent, String str, int i) {
        if (i > 0) {
            honeyClientEvent.a(str, true);
        }
    }

    private static void m7907a(ActivityTrace activityTrace, String str, int i) {
        if (i > 0) {
            activityTrace.a(str, Integer.valueOf(i));
        }
    }

    private static void m7910b(ActivityTrace activityTrace, String str, int i) {
        if (i > 0) {
            activityTrace.a(str);
        }
    }
}
