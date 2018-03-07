package com.facebook.video.commercialbreak;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker.MessageListener;
import com.facebook.video.commercialbreak.CommercialBreakMessageConstants.Type;
import com.facebook.video.commercialbreak.logging.CommercialBreakLogger;
import com.facebook.video.commercialbreak.logging.CommercialBreakLogger$1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: logSelectedSuggestionToActivityLogParams */
public class CommercialBreakMessageSubscriber {
    public static final String f9740a = CommercialBreakMessageSubscriber.class.getSimpleName();
    public final SkywalkerSubscriptionConnector f9741b;
    private final ObjectMapper f9742c;
    private final AbstractFbErrorReporter f9743d;
    public final DefaultAndroidThreadUtil f9744e;
    public final Provider<Boolean> f9745f;
    public final Toaster f9746g;
    private final String f9747h;
    public final String f9748i;
    public final CommercialBreakLogger f9749j;

    /* compiled from: logSelectedSuggestionToActivityLogParams */
    public class CommercialBreakMessage {
        public final String f9736a;
        public final Type f9737b;
        public final long f9738c;
        public final long f9739d;

        public CommercialBreakMessage(String str, @Nullable Type type, long j, long j2) {
            this.f9736a = str;
            this.f9737b = type;
            this.f9738c = j;
            this.f9739d = j2;
        }

        public String toString() {
            return "Message: \nvideo id = " + this.f9736a + "\ntype = " + this.f9737b + "\ncommercial break length ms = " + this.f9738c + "\ncommercial break start time ms = " + this.f9739d;
        }
    }

    @Inject
    public CommercialBreakMessageSubscriber(@Assisted String str, SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, AndroidThreadUtil androidThreadUtil, Provider<Boolean> provider, Toaster toaster, CommercialBreakLogger commercialBreakLogger) {
        this.f9747h = str;
        this.f9748i = "video_broadcast/commercial_break_" + str;
        this.f9741b = skywalkerSubscriptionConnector;
        this.f9742c = objectMapper;
        this.f9743d = fbErrorReporter;
        this.f9744e = androidThreadUtil;
        this.f9745f = provider;
        this.f9746g = toaster;
        this.f9749j = commercialBreakLogger;
    }

    public final void m11444a(final MessageListener messageListener) {
        HoneyClientEvent honeyClientEvent;
        CommercialBreakLogger commercialBreakLogger = this.f9749j;
        String str = this.f9747h;
        if (1 != 0) {
            honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_subscription_success");
            honeyClientEvent.c = "commercial_break";
            honeyClientEvent = honeyClientEvent;
        } else {
            honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_subscription_failure");
            honeyClientEvent.c = "commercial_break";
            honeyClientEvent = honeyClientEvent;
        }
        honeyClientEvent.b("host_video_id", str);
        commercialBreakLogger.a.a(honeyClientEvent);
        this.f9741b.a(this.f9748i, new FutureCallback<JsonNode>(this) {
            final /* synthetic */ CommercialBreakMessageSubscriber f9735b;

            public void onFailure(Throwable th) {
                String str = CommercialBreakMessageSubscriber.f9740a;
            }

            public void onSuccess(@Nullable Object obj) {
                final JsonNode jsonNode = (JsonNode) obj;
                if (jsonNode != null) {
                    this.f9735b.f9744e.a(new Runnable(this) {
                        final /* synthetic */ C10261 f9733b;

                        public void run() {
                            String str = CommercialBreakMessageSubscriber.f9740a;
                            jsonNode.B();
                            CommercialBreakMessage a = CommercialBreakMessageSubscriber.m11443a(this.f9733b.f9735b, jsonNode.B());
                            CommercialBreakLogger commercialBreakLogger = this.f9733b.f9735b.f9749j;
                            String str2 = this.f9733b.f9735b.f9748i;
                            HoneyClientEvent honeyClientEvent;
                            if (a == null) {
                                honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_receive_invalid_message");
                                honeyClientEvent.c = "commercial_break";
                                honeyClientEvent = honeyClientEvent;
                                honeyClientEvent.b("topic", str2);
                                commercialBreakLogger.a.a(honeyClientEvent);
                            } else {
                                switch (CommercialBreakLogger$1.f9750a[a.f9737b.ordinal()]) {
                                    case 1:
                                        honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_receive_intent");
                                        honeyClientEvent.c = "commercial_break";
                                        honeyClientEvent = honeyClientEvent;
                                        honeyClientEvent.a("commercial_break_length_ms", a.f9738c);
                                        break;
                                    case 2:
                                        honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_receive_start");
                                        honeyClientEvent.c = "commercial_break";
                                        honeyClientEvent = honeyClientEvent;
                                        honeyClientEvent.a("commercial_break_start_time_ms", a.f9739d);
                                        break;
                                    default:
                                        honeyClientEvent = new HoneyClientEvent("commercial_break_skywalker_receive_invalid_message");
                                        honeyClientEvent.c = "commercial_break";
                                        honeyClientEvent = honeyClientEvent;
                                        break;
                                }
                                honeyClientEvent.b("topic", str2);
                                honeyClientEvent.b("host_video_id", a.f9736a);
                                commercialBreakLogger.a.a(honeyClientEvent);
                            }
                            if (a != null) {
                                messageListener.a(a);
                                if (((Boolean) this.f9733b.f9735b.f9745f.get()).booleanValue()) {
                                    this.f9733b.f9735b.f9746g.a(new ToastBuilder(a.toString()));
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static CommercialBreakMessage m11443a(CommercialBreakMessageSubscriber commercialBreakMessageSubscriber, String str) {
        JsonNode a;
        JsonNode b;
        JsonNode b2;
        Throwable e;
        JsonNode jsonNode;
        Type valueOf;
        String str2;
        long j;
        long j2;
        CommercialBreakMessage commercialBreakMessage = null;
        try {
            a = commercialBreakMessageSubscriber.f9742c.a(str);
            b = a.b("type");
            try {
                b2 = a.b("commercial_break_length_ms");
            } catch (IOException e2) {
                e = e2;
                b2 = null;
                BLog.a(f9740a, e, "Failed to parse payload: %s", new Object[]{str});
                a = null;
                jsonNode = b2;
                if (b != null) {
                    try {
                        valueOf = Type.valueOf(b.B().toUpperCase(Locale.US));
                        str2 = commercialBreakMessageSubscriber.f9747h;
                        if (jsonNode == null) {
                            j = -1;
                        } else {
                            j = jsonNode.D();
                        }
                        if (a == null) {
                            j2 = 0;
                        } else {
                            j2 = a.D();
                        }
                        commercialBreakMessage = new CommercialBreakMessage(str2, valueOf, j, j2);
                    } catch (Throwable e3) {
                        commercialBreakMessageSubscriber.f9743d.a(f9740a, "Received message with an invalid type", e3);
                    }
                }
                return commercialBreakMessage;
            }
            try {
                a = a.b("commercial_break_start_time_ms");
                jsonNode = b2;
            } catch (IOException e4) {
                e3 = e4;
                BLog.a(f9740a, e3, "Failed to parse payload: %s", new Object[]{str});
                a = null;
                jsonNode = b2;
                if (b != null) {
                    valueOf = Type.valueOf(b.B().toUpperCase(Locale.US));
                    str2 = commercialBreakMessageSubscriber.f9747h;
                    if (jsonNode == null) {
                        j = jsonNode.D();
                    } else {
                        j = -1;
                    }
                    if (a == null) {
                        j2 = a.D();
                    } else {
                        j2 = 0;
                    }
                    commercialBreakMessage = new CommercialBreakMessage(str2, valueOf, j, j2);
                }
                return commercialBreakMessage;
            }
        } catch (IOException e5) {
            e3 = e5;
            b2 = null;
            b = null;
            BLog.a(f9740a, e3, "Failed to parse payload: %s", new Object[]{str});
            a = null;
            jsonNode = b2;
            if (b != null) {
                valueOf = Type.valueOf(b.B().toUpperCase(Locale.US));
                str2 = commercialBreakMessageSubscriber.f9747h;
                if (jsonNode == null) {
                    j = -1;
                } else {
                    j = jsonNode.D();
                }
                if (a == null) {
                    j2 = 0;
                } else {
                    j2 = a.D();
                }
                commercialBreakMessage = new CommercialBreakMessage(str2, valueOf, j, j2);
            }
            return commercialBreakMessage;
        }
        if (b != null) {
            valueOf = Type.valueOf(b.B().toUpperCase(Locale.US));
            str2 = commercialBreakMessageSubscriber.f9747h;
            if (jsonNode == null) {
                j = jsonNode.D();
            } else {
                j = -1;
            }
            if (a == null) {
                j2 = a.D();
            } else {
                j2 = 0;
            }
            commercialBreakMessage = new CommercialBreakMessage(str2, valueOf, j, j2);
        }
        return commercialBreakMessage;
    }
}
