package com.facebook.react.common;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@Deprecated
/* compiled from: getLatency */
public class ApplicationHolder {
    public static Application f11578a;

    public static void m13593a(Application application) {
        f11578a = application;
    }

    @DoNotStrip
    public static Application getApplication() {
        return (Application) Assertions.b(f11578a);
    }
}
