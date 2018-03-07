package com.facebook.photos.upload.protocol;

import android.util.Log;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

/* compiled from: getDownloadStatus failed  */
public class RequestLogger {
    private static final Class<?> f14031a = RequestLogger.class;

    public static <PARAMS, RESULT> void m21739a(ApiMethod<PARAMS, RESULT> apiMethod, PARAMS params) {
        if (Log.isLoggable("log_api_requests", 3)) {
            try {
                ApiRequest a = apiMethod.a(params);
                a.n().name();
                ImmutableList h = a.h();
                if (h != null) {
                    int size = h.size();
                    for (int i = 0; i < size; i++) {
                        NameValuePair nameValuePair = (NameValuePair) h.get(i);
                        nameValuePair.getName();
                        nameValuePair.getValue();
                    }
                }
                List m = a.m();
                if (m != null) {
                    Iterator it = m.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
