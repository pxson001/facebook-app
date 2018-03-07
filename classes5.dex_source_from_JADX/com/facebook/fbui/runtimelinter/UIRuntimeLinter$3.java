package com.facebook.fbui.runtimelinter;

import java.util.List;

/* compiled from: YOUTUBE */
class UIRuntimeLinter$3 implements Runnable {
    final /* synthetic */ UIRuntimeLinter f12195a;

    UIRuntimeLinter$3(UIRuntimeLinter uIRuntimeLinter) {
        this.f12195a = uIRuntimeLinter;
    }

    public void run() {
        List d = UIRuntimeLinter.d(this.f12195a);
        UIRuntimeLinter.a(this.f12195a, (RuntimeLinterRule) d.get(this.f12195a.d.nextInt(d.size())));
        this.f12195a.o = null;
    }
}
