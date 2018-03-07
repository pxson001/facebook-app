package com.facebook.fbreact.funnellogger;

import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_target_data */
public class AnalyticsFunnelLoggerNativeModule extends ReactContextBaseJavaModule {
    private final FunnelLoggerImpl f7319a;

    @Inject
    public AnalyticsFunnelLoggerNativeModule(@Assisted ReactApplicationContext reactApplicationContext, FunnelLoggerImpl funnelLoggerImpl) {
        super(reactApplicationContext);
        this.f7319a = funnelLoggerImpl;
    }

    public String getName() {
        return "RKAnalyticsFunnelLogger";
    }

    @ReactMethod
    public void startFunnel(String str, int i) {
        FunnelDefinition b = FunnelDefinition.b(str);
        if (b == null) {
            return;
        }
        if (i == 0) {
            this.f7319a.a(b);
        } else {
            this.f7319a.a(b, (long) i);
        }
    }

    @ReactMethod
    public void endFunnel(String str, int i) {
        FunnelDefinition b = FunnelDefinition.b(str);
        if (b == null) {
            return;
        }
        if (i == 0) {
            this.f7319a.b(b);
        } else {
            this.f7319a.b(b, (long) i);
        }
    }

    @ReactMethod
    public void addActionToFunnel(String str, int i, String str2, @Nullable String str3) {
        FunnelDefinition b = FunnelDefinition.b(str);
        if (b == null) {
            return;
        }
        if (str3 != null) {
            m8513a(b, i, str2, str3);
        } else if (i == 0) {
            this.f7319a.b(b, str2);
        } else {
            this.f7319a.b(b, (long) i, str2);
        }
    }

    private void m8513a(FunnelDefinition funnelDefinition, int i, String str, String str2) {
        if (i == 0) {
            this.f7319a.a(funnelDefinition, str, str2);
            return;
        }
        this.f7319a.a(funnelDefinition, (long) i, str, str2);
    }

    @ReactMethod
    public void addFunnelTag(String str, int i, String str2) {
        FunnelDefinition b = FunnelDefinition.b(str);
        if (b == null) {
            return;
        }
        if (i == 0) {
            this.f7319a.a(b, str2);
        } else {
            this.f7319a.a(b, (long) i, str2);
        }
    }

    @ReactMethod
    public void cancelFunnel(String str, int i) {
        FunnelDefinition b = FunnelDefinition.b(str);
        if (b == null) {
            return;
        }
        if (i == 0) {
            this.f7319a.c(b);
        } else {
            this.f7319a.c(b, (long) i);
        }
    }
}
