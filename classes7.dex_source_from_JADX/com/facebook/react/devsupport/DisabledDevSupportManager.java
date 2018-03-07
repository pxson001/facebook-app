package com.facebook.react.devsupport;

import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.modules.debug.DeveloperSettings;

/* compiled from: full_refresh ( */
public class DisabledDevSupportManager implements DevSupportManager {
    private final DefaultNativeModuleCallExceptionHandler f11625a = new DefaultNativeModuleCallExceptionHandler();

    public final boolean mo717a() {
        return false;
    }

    public final DeveloperSettings mo718b() {
        return null;
    }

    public final String mo719c() {
        return null;
    }

    public final String mo720d() {
        return null;
    }

    public final String mo721e() {
        return null;
    }

    public final boolean mo722f() {
        return false;
    }

    public final void m13686a(Exception exception) {
        this.f11625a.m13450a(exception);
    }
}
