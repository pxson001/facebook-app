package com.facebook.captcha.helper;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiException;
import com.google.common.base.Throwables;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: is_bootstrap_entity */
public class CaptchaHelper {
    public static boolean m12598b(ServiceException serviceException) {
        if (serviceException == null) {
            return false;
        }
        if (serviceException.a() != ErrorCode.API_ERROR) {
            return false;
        }
        String g = ((ApiException) Throwables.getRootCause(serviceException)).b().g();
        if (g == null) {
            return false;
        }
        try {
            try {
                if (new JSONObject(g).getJSONObject("error").getInt("code") == 3115) {
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        } catch (JSONException e2) {
            return false;
        }
    }
}
