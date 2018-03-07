package com.facebook.http.protocol;

import com.facebook.http.common.FbRequestState;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.interfaces.RequestState;

/* compiled from: replacer */
public final class DefaultRequestStateHolder {
    public static final ThreadLocal<RequestState> f7555a = new ThreadLocal();

    private DefaultRequestStateHolder() {
    }

    public static FbRequestState m12143a(String str, RequestPriority requestPriority) {
        FbRequestState fbRequestState = (FbRequestState) f7555a.get();
        if (fbRequestState == null) {
            return new FbRequestState(str, requestPriority);
        }
        fbRequestState.m11635a(requestPriority);
        return fbRequestState;
    }
}
