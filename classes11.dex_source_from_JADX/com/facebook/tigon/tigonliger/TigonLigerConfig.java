package com.facebook.tigon.tigonliger;

import com.facebook.http.common.HttpHeaders;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: new like count */
public class TigonLigerConfig {
    @DoNotStrip
    public final String[] forwardableHeaders;
    @DoNotStrip
    public final int[] requestTypeAndLimit = new int[3];

    private static TigonLigerConfig m6363a() {
        return new TigonLigerConfig();
    }

    @Inject
    public TigonLigerConfig() {
        this.requestTypeAndLimit[0] = 5;
        this.requestTypeAndLimit[1] = 5;
        this.requestTypeAndLimit[2] = 3;
        this.forwardableHeaders = (String[]) HttpHeaders.a.toArray(new String[HttpHeaders.a.size()]);
    }

    public static TigonLigerConfig m6364a(InjectorLike injectorLike) {
        return m6363a();
    }
}
