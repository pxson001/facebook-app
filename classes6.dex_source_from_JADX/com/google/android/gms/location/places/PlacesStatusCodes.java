package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

public class PlacesStatusCodes extends CommonStatusCodes {
    private PlacesStatusCodes() {
    }

    public static Status m8972b(int i) {
        String str;
        switch (i) {
            case 9000:
                str = "PLACES_API_QUOTA_FAILED";
                break;
            case 9001:
                str = "PLACES_API_USAGE_LIMIT_EXCEEDED";
                break;
            case 9002:
                str = "PLACES_API_KEY_INVALID";
                break;
            case 9003:
                str = "PLACES_API_ACCESS_NOT_CONFIGURED";
                break;
            case 9004:
                str = "PLACES_API_INVALID_ARGUMENT";
                break;
            case 9005:
                str = "PLACES_API_RATE_LIMIT_EXCEEDED";
                break;
            case 9006:
                str = "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
                break;
            case 9007:
                str = "PLACES_API_KEY_EXPIRED";
                break;
            case 9008:
                str = "PLACES_API_INVALID_APP";
                break;
            case 9051:
                str = "PLACE_ALIAS_NOT_FOUND";
                break;
            case 9101:
                str = "PLACE_PROXIMITY_UNKNOWN";
                break;
            case 9102:
                str = "NEARBY_ALERTS_NOT_AVAILABLE";
                break;
            default:
                str = CommonStatusCodes.a(i);
                break;
        }
        String str2 = str;
        zzx.a(str2);
        return new Status(i, str2);
    }
}
