package com.facebook.http.common;

import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.config.server.String_UserAgentStringMethodAutoProvider;
import com.facebook.http.config.DefaultNetworkConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import org.apache.http.params.HttpParams;

/* compiled from: reg_status */
public class HttpParamsMethodAutoProvider extends AbstractProvider<HttpParams> {
    public static HttpParams m12342b(InjectorLike injectorLike) {
        DefaultSocketConfig b = SocketConfigMethodAutoProvider.m12343b(injectorLike);
        String b2 = String_UserAgentStringMethodAutoProvider.m12348b(injectorLike);
        DefaultNetworkConfig a = DefaultNetworkConfig.m12349a(injectorLike);
        QuickExperimentControllerImpl.m10166a(injectorLike);
        C0055x2995691a.m1881a(injectorLike);
        return FbHttpModule.m12169a(b, b2, a);
    }

    public Object get() {
        DefaultSocketConfig b = SocketConfigMethodAutoProvider.m12343b(this);
        String b2 = String_UserAgentStringMethodAutoProvider.m12348b(this);
        DefaultNetworkConfig a = DefaultNetworkConfig.m12349a(this);
        QuickExperimentControllerImpl.m10166a((InjectorLike) this);
        C0055x2995691a.m1881a(this);
        return FbHttpModule.m12169a(b, b2, a);
    }
}
