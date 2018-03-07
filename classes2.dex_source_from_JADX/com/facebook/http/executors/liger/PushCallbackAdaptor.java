package com.facebook.http.executors.liger;

import com.facebook.http.engine.HttpPushCallback;
import com.facebook.http.push.ImagePushSubscriber;
import com.facebook.proxygen.PushCallbacks;
import java.util.Set;

/* compiled from: profile_pic_media_type */
class PushCallbackAdaptor implements PushCallbacks {
    private final Set<HttpPushCallback> f8831a;

    public PushCallbackAdaptor(Set<HttpPushCallback> set) {
        this.f8831a = set;
    }

    public void pushStarted(String str, String str2) {
        for (ImagePushSubscriber a : this.f8831a) {
            a.a(str, str2);
        }
    }
}
