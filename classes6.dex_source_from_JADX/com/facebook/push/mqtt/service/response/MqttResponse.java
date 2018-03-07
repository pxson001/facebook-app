package com.facebook.push.mqtt.service.response;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.OperationResult;
import javax.annotation.Nullable;

/* compiled from: single_photo_publish */
public class MqttResponse<T> {
    public final boolean f4336a;
    public final T f4337b;
    public final ErrorType f4338c;
    public final Exception f4339d;
    public final long f4340e;

    /* compiled from: single_photo_publish */
    public enum ErrorType {
        MQTT_FAILED_TO_CONNECT,
        MQTT_PUBLISH_FAILED,
        MQTT_DID_NOT_RECEIVE_RESPONSE,
        MQTT_EXCEPTION
    }

    private MqttResponse(boolean z, T t, @Nullable ErrorType errorType, @Nullable Exception exception, long j) {
        this.f4336a = z;
        this.f4337b = t;
        this.f4338c = errorType;
        this.f4339d = exception;
        this.f4340e = j;
    }

    public static <T> MqttResponse<T> m6434a(T t, long j) {
        return new MqttResponse(true, t, null, null, j);
    }

    public static <T> MqttResponse<T> m6432a(ErrorType errorType, long j) {
        return new MqttResponse(false, null, errorType, null, j);
    }

    public static <T> MqttResponse<T> m6433a(Exception exception, long j) {
        return new MqttResponse(false, null, ErrorType.MQTT_EXCEPTION, exception, j);
    }

    public final OperationResult m6435a() {
        if (this.f4336a) {
            return OperationResult.a;
        }
        if (this.f4338c == ErrorType.MQTT_EXCEPTION) {
            return OperationResult.a(ErrorCode.MQTT_SEND_FAILURE, ErrorCodeUtil.b(this.f4339d), this.f4339d);
        }
        return OperationResult.a(ErrorCode.MQTT_SEND_FAILURE, this.f4338c.name());
    }
}
