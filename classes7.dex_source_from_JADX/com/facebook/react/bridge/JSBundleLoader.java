package com.facebook.react.bridge;

import android.content.Context;

/* compiled from: group_purposes */
public abstract class JSBundleLoader {

    /* compiled from: group_purposes */
    final class C10141 extends JSBundleLoader {
        final /* synthetic */ String f11505a;
        final /* synthetic */ Context f11506b;

        C10141(String str, Context context) {
            this.f11505a = str;
            this.f11506b = context;
        }

        public final void mo661a(ReactBridge reactBridge) {
            if (this.f11505a.startsWith("assets://")) {
                reactBridge.loadScriptFromAssets(this.f11506b.getAssets(), this.f11505a.replaceFirst("assets://", ""));
            } else {
                reactBridge.loadScriptFromFile(this.f11505a, "file://" + this.f11505a);
            }
        }

        public final String mo660a() {
            return (this.f11505a.startsWith("assets://") ? "" : "file://") + this.f11505a;
        }
    }

    /* compiled from: group_purposes */
    final class C10152 extends JSBundleLoader {
        final /* synthetic */ String f11507a;
        final /* synthetic */ String f11508b;

        C10152(String str, String str2) {
            this.f11507a = str;
            this.f11508b = str2;
        }

        public final void mo661a(ReactBridge reactBridge) {
            reactBridge.loadScriptFromFile(this.f11507a, this.f11508b);
        }

        public final String mo660a() {
            return this.f11508b;
        }
    }

    public abstract String mo660a();

    public abstract void mo661a(ReactBridge reactBridge);

    public static JSBundleLoader m13452a(Context context, String str) {
        return new C10141(str, context);
    }

    public static JSBundleLoader m13453a(String str, String str2) {
        return new C10152(str2, str);
    }
}
