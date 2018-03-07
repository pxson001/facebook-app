package com.facebook.fbui.runtimelinter;

/* compiled from: YOUTUBE */
class UIRuntimeLinter$2 implements Runnable {
    final /* synthetic */ UIRuntimeLinter f12194a;

    UIRuntimeLinter$2(UIRuntimeLinter uIRuntimeLinter) {
        this.f12194a = uIRuntimeLinter;
    }

    public void run() {
        for (RuntimeLinterRule a : UIRuntimeLinter.d(this.f12194a)) {
            UIRuntimeLinter.a(this.f12194a, a);
        }
    }
}
