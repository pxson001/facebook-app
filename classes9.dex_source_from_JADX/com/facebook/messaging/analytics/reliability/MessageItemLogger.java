package com.facebook.messaging.analytics.reliability;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.text.linkify.SafeLinkifier;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: p2p_history_get_more_success */
public class MessageItemLogger {
    private static MessageItemLogger f7648d;
    private static final Object f7649e = new Object();
    public final AnalyticsLogger f7650a;
    private final MessageUtil f7651b;
    public final BaseAnalyticsConfig f7652c;

    private static MessageItemLogger m7931b(InjectorLike injectorLike) {
        return new MessageItemLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), MessageUtil.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike));
    }

    @Inject
    public MessageItemLogger(AnalyticsLogger analyticsLogger, MessageUtil messageUtil, BaseAnalyticsConfig baseAnalyticsConfig) {
        this.f7650a = analyticsLogger;
        this.f7651b = messageUtil;
        this.f7652c = baseAnalyticsConfig;
    }

    public static MessageItemLogger m7930a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageItemLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7649e) {
                MessageItemLogger messageItemLogger;
                if (a2 != null) {
                    messageItemLogger = (MessageItemLogger) a2.a(f7649e);
                } else {
                    messageItemLogger = f7648d;
                }
                if (messageItemLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7931b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7649e, b3);
                        } else {
                            f7648d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageItemLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m7932a(Message message) {
        int i = 1;
        if (this.f7652c.a("message_text_linkified") && MessageUtil.A(message) && !MessageUtil.Q(message)) {
            TracerDetour.a("linkify_message", 1920956257);
            try {
                Spannable spannableString = new SpannableString(message.f);
                boolean a = SafeLinkifier.a(spannableString, 1);
                boolean a2 = SafeLinkifier.a(spannableString, 2);
                boolean a3 = SafeLinkifier.a(spannableString, 4);
                boolean a4 = SafeLinkifier.a(spannableString, 8);
                HoneyClientEvent a5 = new HoneyClientEvent("message_text_linkified").a("web_url", a ? 1 : 0).a("email_address", a2 ? 1 : 0).a("phone_number", a3 ? 1 : 0);
                String str = "map_address";
                if (!a4) {
                    i = 0;
                }
                this.f7650a.a(a5.a(str, i).b("message_id", message.a));
            } finally {
                TracerDetour.a(988668154);
            }
        }
    }

    public final void m7933b(Message message) {
        if (this.f7652c.a("message_viewed_with_unavailable_attachment")) {
            HoneyClientEventFast a = this.f7650a.a("message_viewed_with_unavailable_attachment", false);
            if (a.a()) {
                a.a("message_view").a("message_id", message.a);
                a.b();
            }
        }
    }
}
