package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import org.apache.http.conn.scheme.SchemeRegistry;

/* compiled from: docString */
public class SchemeRegistryMethodAutoProvider extends AbstractProvider<SchemeRegistry> {
    public Object get() {
        return FbHttpModule.a(SocketFactory_SslSocketFactoryMethodAutoProvider.m9886b(this));
    }
}
