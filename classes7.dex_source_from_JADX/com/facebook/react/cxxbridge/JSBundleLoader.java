package com.facebook.react.cxxbridge;

import android.content.Context;

/* compiled from: group_purposes */
public abstract class JSBundleLoader {

    /* compiled from: group_purposes */
    final class C10261 extends JSBundleLoader {
        final /* synthetic */ String f11612a;
        final /* synthetic */ Context f11613b;

        C10261(String str, Context context) {
            this.f11612a = str;
            this.f11613b = context;
        }

        public final void mo715a(CatalystInstanceImpl catalystInstanceImpl) {
            if (this.f11612a.startsWith("assets://")) {
                catalystInstanceImpl.loadScriptFromAssets(this.f11613b.getAssets(), this.f11612a);
            } else {
                catalystInstanceImpl.loadScriptFromFile(this.f11612a, this.f11612a);
            }
        }

        public final String mo714a() {
            return this.f11612a;
        }
    }

    /* compiled from: group_purposes */
    final class C10272 extends JSBundleLoader {
        final /* synthetic */ String f11614a;
        final /* synthetic */ String f11615b;

        C10272(String str, String str2) {
            this.f11614a = str;
            this.f11615b = str2;
        }

        public final void mo715a(CatalystInstanceImpl catalystInstanceImpl) {
            catalystInstanceImpl.loadScriptFromFile(this.f11614a, this.f11615b);
        }

        public final String mo714a() {
            return this.f11615b;
        }
    }

    public abstract String mo714a();

    public abstract void mo715a(CatalystInstanceImpl catalystInstanceImpl);

    public static JSBundleLoader m13659a(Context context, String str) {
        return new C10261(str, context);
    }

    public static JSBundleLoader m13660a(String str, String str2) {
        return new C10272(str2, str);
    }
}
