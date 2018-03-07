package com.facebook.common.hardware;

import android.content.res.Resources.NotFoundException;
import android.telephony.TelephonyManager;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: internal_sample_rate */
public class TelephonyManagerUtils {

    /* compiled from: internal_sample_rate */
    public enum CellType {
        CDMA,
        GSM,
        LTE,
        WCDMA,
        UNKNOWN
    }

    private TelephonyManagerUtils() {
    }

    private static int m27411d(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getPhoneType();
        } catch (NotFoundException e) {
            return -1;
        }
    }

    public static String m27412e(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimCountryIso();
        } catch (Exception e) {
            return null;
        }
    }

    public static String m27413f(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getNetworkCountryIso();
        } catch (Exception e) {
            return null;
        }
    }

    public static String m27406a(String str) {
        return str == null ? "UNKNOWN" : str;
    }

    public static String m27410c(TelephonyManager telephonyManager) {
        return m27408b(m27411d(telephonyManager));
    }

    public static String m27405a(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "GPRS";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "EDGE";
            case 3:
                return "UMTS";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKNOWN";
        }
    }

    public static String m27408b(int i) {
        switch (i) {
            case 0:
                return "NONE";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "GSM";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "CDMA";
            case 3:
                return "SIP";
            default:
                return "UNKNOWN";
        }
    }

    public static String m27409c(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "ABSENT";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "PIN_REQUIRED";
            case 3:
                return "PUK_REQUIRED";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "NETWORK_LOCKED";
            case 5:
                return "READY";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean m27407a(int i, int i2) {
        if (i == 1 || i != 0) {
            return false;
        }
        switch (i2) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return true;
            case 3:
            case 5:
            case 6:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return false;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return true;
            case 7:
                return true;
            case 11:
                return true;
            default:
                return false;
        }
    }
}
