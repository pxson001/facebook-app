package com.facebook.fbreact.exceptionmanager;

import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import java.util.Set;

/* compiled from: star_rating */
class FbReactExceptionManager$1 implements Runnable {
    final /* synthetic */ Set f3459a;
    final /* synthetic */ Exception f3460b;
    final /* synthetic */ FbReactExceptionManager f3461c;

    FbReactExceptionManager$1(FbReactExceptionManager fbReactExceptionManager, Set set, Exception exception) {
        this.f3461c = fbReactExceptionManager;
        this.f3459a = set;
        this.f3460b = exception;
    }

    public void run() {
        for (NativeModuleCallExceptionHandler a : this.f3459a) {
            a.a(this.f3460b);
        }
    }
}
