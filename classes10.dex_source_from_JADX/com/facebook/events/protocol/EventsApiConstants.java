package com.facebook.events.protocol;

import com.facebook.events.model.Event;
import com.facebook.events.model.PrivacyType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: audio_clips_send */
public class EventsApiConstants {

    /* compiled from: audio_clips_send */
    /* synthetic */ class C27001 {
        static final /* synthetic */ int[] f19060a = new int[PrivacyType.values().length];

        static {
            try {
                f19060a[PrivacyType.USER_PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19060a[PrivacyType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19060a[PrivacyType.FRIENDS_OF_GUESTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19060a[PrivacyType.INVITE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static String m19289a(Date date, TimeZone timeZone, boolean z) {
        if (date == null) {
            return null;
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (z) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.format(date);
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm':00'Z", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public static String m19288a(Date date, TimeZone timeZone) {
        return m19289a(date, timeZone, false);
    }

    public static String m19286a(Event event) {
        return m19289a(event.J(), event.L, event.M);
    }

    public static String m19287a(PrivacyType privacyType) {
        switch (C27001.f19060a[privacyType.ordinal()]) {
            case 1:
            case 2:
                return "OPEN";
            case 3:
                return "FRIENDS";
            case 4:
                return "SECRET";
            default:
                throw new IllegalArgumentException("Type does not support setting: " + privacyType);
        }
    }

    public static String m19290b(Event event) {
        if (event.M) {
            return null;
        }
        return m19289a(event.L(), event.L, false);
    }
}
