package com.facebook.analytics.timespent;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Arrays;
import java.util.Random;

/* compiled from: messenger_sticker_asset_flush_android */
public class TimeSpentBitArray {
    public static final Random f13740a = new Random();
    public long f13741b;
    public long f13742c;
    public String f13743d;
    public int[] f13744e;
    public int f13745f;
    public int f13746g;
    public int f13747h;

    /* compiled from: messenger_sticker_asset_flush_android */
    public enum AppEvent {
        FOREGROUNDED,
        USER_ACTION,
        BACKGROUNDED,
        CLOCK_CHANGE,
        IGNORE,
        LOGIN,
        DIALTONE,
        DATASAVINGS
    }

    /* compiled from: messenger_sticker_asset_flush_android */
    /* synthetic */ class C06631 {
        static final /* synthetic */ int[] f15191a = new int[AppEvent.values().length];

        static {
            try {
                f15191a[AppEvent.USER_ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15191a[AppEvent.CLOCK_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15191a[AppEvent.BACKGROUNDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15191a[AppEvent.FOREGROUNDED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15191a[AppEvent.LOGIN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15191a[AppEvent.DIALTONE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15191a[AppEvent.DATASAVINGS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public TimeSpentBitArray() {
        this.f13747h = 1;
        this.f13747h = 2;
        this.f13743d = Integer.toString(Math.abs(f13740a.nextInt()), 36);
        this.f13745f = -1;
        this.f13746g = 0;
        this.f13744e = null;
    }

    private HoneyClientEvent m20171b(long j) {
        long j2 = j - this.f13741b;
        HoneyClientEvent honeyClientEvent = null;
        if (j2 < 0 || j2 >= 64) {
            honeyClientEvent = m20172c(j, AppEvent.USER_ACTION);
        }
        if (this.f13744e == null) {
            int i = 1;
            this.f13742c = j;
            this.f13741b = j;
            this.f13744e = new int[this.f13747h];
            this.f13744e[0] = 1;
            while (i < this.f13747h) {
                this.f13744e[i] = 0;
                i++;
            }
            this.f13745f++;
            this.f13746g++;
        } else {
            int[] iArr = this.f13744e;
            int i2 = ((int) j2) >> 5;
            iArr[i2] = (1 << (((int) j2) & 31)) | iArr[i2];
            this.f13742c = j;
            this.f13746g++;
        }
        return honeyClientEvent;
    }

    private HoneyClientEvent m20172c(long j, AppEvent appEvent) {
        HoneyClientEvent honeyClientEvent;
        if (this.f13744e == null) {
            honeyClientEvent = null;
        } else {
            int min;
            if (j > this.f13742c) {
                min = (int) Math.min(64, (j - this.f13741b) + 1);
            } else {
                min = (int) ((this.f13742c - this.f13741b) + 1);
            }
            honeyClientEvent = new HoneyClientEvent("time_spent_bit_array").m5090b("tos_id", this.f13743d).m5084a("start_time", this.f13741b).m5090b("tos_array", Arrays.toString(this.f13744e)).m5083a("tos_len", min).m5083a("tos_seq", this.f13745f).m5083a("tos_cum", this.f13746g);
            if (appEvent == AppEvent.CLOCK_CHANGE) {
                honeyClientEvent.m5090b("trigger", "clock_change");
            }
        }
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        this.f13744e = null;
        this.f13742c = 0;
        return honeyClientEvent2;
    }

    public final HoneyClientEvent m20173a(long j, AppEvent appEvent) {
        switch (C06631.f15191a[appEvent.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                long j2 = j / 1000;
                if (j2 > this.f13742c) {
                    return m20171b(j2);
                }
                return null;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
            case 7:
                if (this.f13744e != null) {
                    return m20172c(j / 1000, appEvent);
                }
                return null;
            default:
                return null;
        }
    }
}
