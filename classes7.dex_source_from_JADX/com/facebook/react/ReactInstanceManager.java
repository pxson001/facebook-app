package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: hasLaunchedComposer */
public abstract class ReactInstanceManager {

    /* compiled from: hasLaunchedComposer */
    public class Builder {
        protected final List<ReactPackage> f11357a = new ArrayList();
        @Nullable
        public String f11358b;
        @Nullable
        public String f11359c;
        @Nullable
        protected NotThreadSafeBridgeIdleDebugListener f11360d;
        @Nullable
        public Application f11361e;
        public boolean f11362f;
        @Nullable
        public LifecycleState f11363g;
        @Nullable
        public UIImplementationProvider f11364h;
        @Nullable
        public NativeModuleCallExceptionHandler f11365i;
        @Nullable
        public JSCConfig f11366j;
        @Nullable
        protected Activity f11367k;
        @Nullable
        protected DefaultHardwareBackBtnHandler f11368l;

        protected Builder() {
        }

        public final Builder m13243a(@Nullable UIImplementationProvider uIImplementationProvider) {
            this.f11364h = uIImplementationProvider;
            return this;
        }

        public final Builder m13244a(String str) {
            String str2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "assets://" + str;
            }
            this.f11358b = str2;
            return this;
        }

        private Builder m13237c(String str) {
            this.f11358b = str;
            return this;
        }

        public final Builder m13247b(String str) {
            this.f11359c = str;
            return this;
        }

        public final Builder m13241a(ReactPackage reactPackage) {
            this.f11357a.add(reactPackage);
            return this;
        }

        public final Builder m13238a(Application application) {
            this.f11361e = application;
            return this;
        }

        public final Builder m13245a(boolean z) {
            this.f11362f = z;
            return this;
        }

        public final Builder m13240a(LifecycleState lifecycleState) {
            this.f11363g = lifecycleState;
            return this;
        }

        public final Builder m13242a(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
            this.f11365i = nativeModuleCallExceptionHandler;
            return this;
        }

        public final Builder m13239a(JSCConfig jSCConfig) {
            this.f11366j = jSCConfig;
            return this;
        }

        public ReactInstanceManager mo639a() {
            boolean z = false;
            boolean z2 = this.f11362f || this.f11358b != null;
            Assertions.a(z2, "JS Bundle File has to be provided when dev support is disabled");
            if (!(this.f11359c == null && this.f11358b == null)) {
                z = true;
            }
            Assertions.a(z, "Either MainModuleName or JS Bundle File needs to be provided");
            if (this.f11364h == null) {
                this.f11364h = new UIImplementationProvider();
            }
            return new ReactInstanceManagerImpl((Context) Assertions.a(this.f11361e, "Application property has not been set with this builder"), this.f11367k, this.f11368l, this.f11358b, this.f11359c, this.f11357a, this.f11362f, this.f11360d, (LifecycleState) Assertions.a(this.f11363g, "Initial lifecycle state was not set"), this.f11364h, this.f11365i, this.f11366j);
        }
    }

    /* compiled from: hasLaunchedComposer */
    public interface ReactInstanceEventListener {
        void m13248a(ReactContext reactContext);
    }

    public abstract DevSupportManager mo621a();

    public abstract List<ViewManager> mo622a(ReactApplicationContext reactApplicationContext);

    public abstract void mo623a(int i, int i2, Intent intent);

    public abstract void mo624a(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler);

    public abstract void mo625a(ReactInstanceEventListener reactInstanceEventListener);

    public abstract void mo626a(ReactRootView reactRootView);

    public abstract void mo627b();

    public abstract void mo628b(ReactInstanceEventListener reactInstanceEventListener);

    public abstract void mo629b(ReactRootView reactRootView);

    public abstract boolean mo630c();

    public abstract void mo631d();

    public abstract void mo632e();

    public abstract void mo633f();

    public abstract void mo634g();

    public abstract String mo635h();

    public abstract void mo636i();

    @VisibleForTesting
    @Nullable
    public abstract ReactContext mo637j();

    public static Builder m13249k() {
        return new Builder();
    }
}
