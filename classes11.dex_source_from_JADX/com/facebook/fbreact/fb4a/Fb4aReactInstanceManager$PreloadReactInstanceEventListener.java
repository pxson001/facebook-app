package com.facebook.fbreact.fb4a;

import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;

/* compiled from: f0273dc36423d199f3d6ce3a4035622a */
class Fb4aReactInstanceManager$PreloadReactInstanceEventListener implements ReactInstanceEventListener {
    final /* synthetic */ Fb4aReactInstanceManager f7291a;

    public Fb4aReactInstanceManager$PreloadReactInstanceEventListener(Fb4aReactInstanceManager fb4aReactInstanceManager) {
        this.f7291a = fb4aReactInstanceManager;
    }

    public final void m8506a(ReactContext reactContext) {
        this.f7291a.j.b(this.f7291a.l);
        this.f7291a.l = null;
        ((FbReactInstanceHolder) this.f7291a.e.get()).c().b(this);
    }
}
