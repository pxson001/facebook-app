package com.facebook.http.common;

import android.content.Context;
import com.facebook.config.server.String_UserAgentStringMethodAutoProvider;
import com.facebook.http.config.DefaultNetworkConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ssl.SSLSocketFactoryHelper;
import org.apache.http.conn.scheme.SocketFactory;

/* compiled from: doUploadFailure */
public class SocketFactory_SslSocketFactoryMethodAutoProvider extends AbstractProvider<SocketFactory> {
    public static SocketFactory m9886b(InjectorLike injectorLike) {
        return FbHttpModule.a(String_UserAgentStringMethodAutoProvider.b(injectorLike), DefaultNetworkConfig.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4023), SSLSocketFactoryHelper.m10199a(injectorLike));
    }

    public Object get() {
        return FbHttpModule.a(String_UserAgentStringMethodAutoProvider.b(this), DefaultNetworkConfig.a(this), (Context) getInstance(Context.class), IdBasedProvider.a(this, 4023), SSLSocketFactoryHelper.m10199a((InjectorLike) this));
    }
}
