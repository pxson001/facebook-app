package com.facebook.messaging.send.service;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.messaging.service.model.NewMessageResult;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: recent_active_groups */
public class SendViaMqttResult {
    public final Result f3964a;
    private final Details f3965b;
    private final int f3966c;
    private final Exception f3967d;
    public final NewMessageResult f3968e;
    private final boolean f3969f;
    public final String f3970g;

    /* compiled from: recent_active_groups */
    public enum Details {
        NONE(null, 0),
        MQTT_EXCEPTION("mqtt exception", 900),
        MQTT_REMOTEEXCEPTION("mqtt remote exception", 901),
        MQTT_IOEXCEPTION("mqtt io exception", 902),
        SEND_SKIPPED_BROADCAST("message is a broadcast", 903),
        SEND_SKIPPED_FB_SHARE("message is a fb story share", 904),
        SEND_SKIPPED_PAYMENT_MESSAGE("message is a payment message", 905),
        SEND_SKIPPED_HAS_APP_ATTRIBUTION("message has app attribution", 906),
        SEND_SKIPPED_HAS_LOCATION_SHARE("message has location share", 907),
        SEND_SKIPPED_MEDIA_UPLOAD_FAILED("media upload failed", 909),
        SEND_SKIPPED_DYNAMIC_PRICING_ENABLED("dynamic message pricing is enabled", 910),
        SEND_FAILED_NOT_CONNECTED("MQTT not connected", 911),
        SEND_FAILED_TIMED_OUT_AFTER_PUBLISH("timed out after publish", 912),
        SEND_FAILED_TIMED_OUT_WAITING_FOR_RESPONSE("timed out waiting for response", 913),
        SEND_FAILED_SERVER_RETURNED_FAILURE("server returned failure", 914),
        SEND_FAILED_PUBLISH_FAILED("publish failed", 915),
        SEND_FAILED_UNKNOWN_EXCEPTION("Failed to send via MQTT (%1$s)", 916),
        SEND_FAILED_NO_RETRY("Failure, no retry", 917),
        SEND_FAILED_THRIFT_EXCEPTION("thrift serialize failed", 918),
        SEND_FAILED_PUBLISH_FAILED_WITH_EXCEPTION("publish failed with exception", 919),
        SEND_SKIPPED_HAS_EVENT_MESSAGE("message has event message", 920),
        SEND_SKIPPED_HAS_FLOWER_BORDER("message has flower border", 921),
        SEND_SKIPPED_HAS_PLATFORM_METADATA("message has platform metadata", 922);
        
        public final int errorCode;
        public final String message;

        private Details(String str, int i) {
            this.message = str;
            this.errorCode = i;
        }
    }

    /* compiled from: recent_active_groups */
    public enum Result {
        SKIPPED,
        FAILED,
        SUCCEEDED;

        public final boolean isFailure() {
            return this == FAILED;
        }
    }

    private SendViaMqttResult(Result result, Details details, int i, Exception exception, NewMessageResult newMessageResult, boolean z, @Nullable String str) {
        boolean z2 = true;
        boolean z3;
        switch (result) {
            case SUCCEEDED:
                if (details == Details.NONE) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                if (exception == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                if (newMessageResult == null) {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                break;
            case FAILED:
                if (details != Details.NONE) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                if (newMessageResult != null) {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                break;
            case SKIPPED:
                if (details != Details.NONE) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                if (newMessageResult != null) {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                break;
        }
        this.f3964a = result;
        this.f3965b = details;
        this.f3966c = i;
        this.f3967d = exception;
        this.f3968e = newMessageResult;
        this.f3969f = z;
        this.f3970g = str;
    }

    public static SendViaMqttResult m3698a(Details details) {
        return new SendViaMqttResult(Result.SKIPPED, details, 0, null, null, false, null);
    }

    public static SendViaMqttResult m3699a(Details details, int i, @Nullable String str, boolean z) {
        return new SendViaMqttResult(Result.FAILED, details, i, null, null, z, str);
    }

    public static SendViaMqttResult m3700a(Details details, int i, boolean z) {
        return m3699a(details, i, null, z);
    }

    public static SendViaMqttResult m3702a(Exception exception, int i) {
        return new SendViaMqttResult(Result.FAILED, Details.SEND_FAILED_UNKNOWN_EXCEPTION, i, exception, null, false, null);
    }

    public static SendViaMqttResult m3697a(int i, boolean z, @Nullable String str) {
        return new SendViaMqttResult(Result.FAILED, Details.SEND_FAILED_NO_RETRY, i, null, null, z, str);
    }

    public static SendViaMqttResult m3701a(NewMessageResult newMessageResult, boolean z) {
        return new SendViaMqttResult(Result.SUCCEEDED, Details.NONE, 0, null, newMessageResult, z, null);
    }

    public final Result m3703a() {
        return this.f3964a;
    }

    public final String m3704c() {
        Preconditions.checkState(this.f3964a == Result.SKIPPED);
        return this.f3965b.message;
    }

    public final String m3705d() {
        Preconditions.checkState(this.f3964a.isFailure());
        if (this.f3965b == Details.SEND_FAILED_UNKNOWN_EXCEPTION) {
            return StringFormatUtil.formatStrLocaleSafe(this.f3965b.message, this.f3967d);
        }
        if (this.f3965b == Details.SEND_FAILED_PUBLISH_FAILED_WITH_EXCEPTION) {
            return StringFormatUtil.formatStrLocaleSafe("%s %s", this.f3965b.message, this.f3970g);
        }
        return this.f3965b.message;
    }

    public final int m3706e() {
        Preconditions.checkState(this.f3964a.isFailure());
        return this.f3966c;
    }

    public final boolean m3707f() {
        return this.f3964a.isFailure() && this.f3965b == Details.SEND_FAILED_NO_RETRY;
    }

    public final boolean m3708g() {
        return this.f3969f;
    }
}
