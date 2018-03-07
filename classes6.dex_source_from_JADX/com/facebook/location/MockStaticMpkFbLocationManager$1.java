package com.facebook.location;

import com.google.common.base.Preconditions;

/* compiled from: {user} */
class MockStaticMpkFbLocationManager$1 implements Runnable {
    final /* synthetic */ MockStaticMpkFbLocationManager f74a;

    MockStaticMpkFbLocationManager$1(MockStaticMpkFbLocationManager mockStaticMpkFbLocationManager) {
        this.f74a = mockStaticMpkFbLocationManager;
    }

    public void run() {
        if (this.f74a.e.get()) {
            MockStaticMpkFbLocationManager mockStaticMpkFbLocationManager = this.f74a;
            ImmutableLocation$Builder a = ImmutableLocation.a(37.484998d, -122.148209d);
            String str = MockStaticMpkFbLocationManager.a;
            Preconditions.checkNotNull(str);
            a.f45a.setProvider(str);
            mockStaticMpkFbLocationManager.a(a.m39b(1.0f).m42c(this.f74a.c.a()).m38a());
            MockStaticMpkFbLocationManager.a(this.f74a, this.f74a.d);
        }
    }
}
