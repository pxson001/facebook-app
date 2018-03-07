package com.facebook.platform.common;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.platform.common.action.PlatformAppCall;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: structured_survey_flow_pages */
public class PlatformAppResults {

    /* compiled from: structured_survey_flow_pages */
    /* synthetic */ class C02211 {
        static final /* synthetic */ int[] f3997a = new int[ErrorCode.values().length];

        static {
            try {
                f3997a[ErrorCode.CONNECTION_FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3997a[ErrorCode.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static Bundle m5892a(PlatformAppCall platformAppCall, String str, long j, List<String> list) {
        Object obj = (platformAppCall == null || !platformAppCall.m5913d()) ? null : 1;
        String str2 = obj != null ? "access_token" : "com.facebook.platform.extra.ACCESS_TOKEN";
        String str3 = obj != null ? "expires_seconds_since_epoch" : "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
        String str4 = obj != null ? "permissions" : "com.facebook.platform.extra.PERMISSIONS";
        Bundle bundle = new Bundle();
        if (list instanceof ArrayList) {
            list = (ArrayList) list;
        } else {
            Object arrayList = new ArrayList(list);
        }
        bundle.putString(str2, str);
        bundle.putLong(str3, j);
        bundle.putStringArrayList(str4, list);
        return bundle;
    }

    public static Bundle m5895a(PlatformAppCall platformAppCall, Throwable th, String str) {
        return m5890a(platformAppCall, ErrorCodeUtil.a(th), th, true, str);
    }

    public static Bundle m5894a(PlatformAppCall platformAppCall, Throwable th) {
        return m5890a(platformAppCall, ErrorCodeUtil.a(th), th, false, null);
    }

    public static Bundle m5890a(PlatformAppCall platformAppCall, ErrorCode errorCode, Throwable th, boolean z, String str) {
        String str2;
        String string;
        switch (C02211.f3997a[errorCode.ordinal()]) {
            case 1:
                str2 = "NetworkError";
                break;
            case 2:
                str2 = "UnknownError";
                break;
            default:
                str2 = "ApplicationError";
                break;
        }
        String str3 = null;
        JSONObject jSONObject = new JSONObject();
        String message = th.getMessage();
        if (th instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) th;
            OperationResult operationResult = serviceException.result;
            if (operationResult != null) {
                Bundle g = operationResult.g();
                if (g != null) {
                    string = g.getString("originalExceptionMessage");
                    if (string == null) {
                        string = message;
                    }
                    str3 = m5896a(g, serviceException);
                    String str4 = string;
                    jSONObject = m5898a(str3);
                    message = str4;
                }
            }
        }
        if (z) {
            return m5899b(platformAppCall, str2, str, str3);
        }
        String str5;
        string = jSONObject.toString();
        Bundle bundle = new Bundle();
        bundle.putString(m5897a(platformAppCall), str2);
        bundle.putString(m5900b(platformAppCall), message);
        Object obj = (platformAppCall == null || !platformAppCall.m5913d()) ? null : 1;
        if (obj != null) {
            str5 = "error_json";
        } else {
            str5 = "com.facebook.platform.status.ERROR_JSON";
        }
        bundle.putString(str5, string);
        return bundle;
    }

    public static Bundle m5893a(PlatformAppCall platformAppCall, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(m5897a(platformAppCall), str);
        bundle.putString(m5900b(platformAppCall), str2);
        return bundle;
    }

    public static Bundle m5891a(PlatformAppCall platformAppCall, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(m5897a(platformAppCall), "UserCanceled");
        bundle.putString(m5900b(platformAppCall), str);
        return bundle;
    }

    private static String m5896a(Bundle bundle, ServiceException serviceException) {
        String str = "";
        if (bundle.containsKey("result")) {
            Parcelable parcelable = bundle.getParcelable("result");
            if (serviceException.errorCode.equals(ErrorCode.API_ERROR) && (parcelable instanceof ApiErrorResult)) {
                return ((ApiErrorResult) parcelable).mJsonResponse;
            }
        }
        return str;
    }

    private static JSONObject m5898a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!(str == null || str.length() == 0)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has("error_code")) {
                    jSONObject.put("error_code", jSONObject2.get("error_code"));
                }
                if (jSONObject2.has("error_subcode")) {
                    jSONObject.put("error_subcode", jSONObject2.get("error_subcode"));
                }
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    private static Bundle m5899b(PlatformAppCall platformAppCall, String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (str3 != null) {
            try {
                jSONObject2 = new JSONObject(str3);
            } catch (JSONException e) {
                return m5893a(platformAppCall, str, str2);
            }
        }
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.getJSONObject("error");
        } else {
            jSONObject = jSONObject2;
        }
        if (jSONObject != null) {
            String string = jSONObject.getString("code");
            String str4 = "fbplatse:";
            if (string != null) {
                str4 = "(#" + string + ") " + str4;
            }
            String string2 = jSONObject.getString("message");
            if (string2 != null && string2.startsWith(str4)) {
                jSONObject = new JSONObject(string2.substring(str4.length()));
                if (jSONObject.has("message_android")) {
                    return m5893a(platformAppCall, str, jSONObject.getString("message_android"));
                }
                if (jSONObject.has("message")) {
                    return m5893a(platformAppCall, str, jSONObject.getString("message"));
                }
            }
        }
        return m5893a(platformAppCall, str, str2);
    }

    public static String m5897a(PlatformAppCall platformAppCall) {
        Object obj = (platformAppCall == null || !platformAppCall.m5913d()) ? null : 1;
        return obj != null ? "error_type" : "com.facebook.platform.status.ERROR_TYPE";
    }

    public static String m5900b(PlatformAppCall platformAppCall) {
        Object obj = (platformAppCall == null || !platformAppCall.m5913d()) ? null : 1;
        return obj != null ? "error_description" : "com.facebook.platform.status.ERROR_DESCRIPTION";
    }
}
