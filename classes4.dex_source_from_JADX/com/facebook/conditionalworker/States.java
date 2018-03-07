package com.facebook.conditionalworker;

import java.util.HashSet;
import java.util.Set;

/* compiled from: is_callable_webrtc */
public class States {
    public final Set<Enum<?>> f10281a = new HashSet(6, 1.0f);

    /* compiled from: is_callable_webrtc */
    public enum NetworkState {
        CONNECTED_THROUGH_MOBILE,
        CONNECTED_THROUGH_WIFI,
        CONNECTED
    }

    /* compiled from: is_callable_webrtc */
    public enum AppState {
        FOREGROUND,
        BACKGROUND
    }

    /* compiled from: is_callable_webrtc */
    public enum LoginState {
        LOGGED_IN
    }

    /* compiled from: is_callable_webrtc */
    public enum BatteryState {
        NOT_LOW
    }

    States() {
    }

    public final void m10783a(Enum<?> enumR) {
        this.f10281a.add(enumR);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (Enum enumR : this.f10281a) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(enumR.getClass().getSimpleName()).append('=');
            stringBuilder.append(enumR);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
