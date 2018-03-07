package com.facebook.tigon.javaservice;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequest;

@DoNotStrip
/* compiled from: last_visible_action_id */
public interface JavaBackedTigonService {
    @DoNotStrip
    void submitHttpRequest(AbstractRequestToken abstractRequestToken, TigonRequest tigonRequest, byte[] bArr);
}
