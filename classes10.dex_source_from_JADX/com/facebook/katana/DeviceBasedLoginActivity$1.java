package com.facebook.katana;

/* compiled from: SEGMENT_UPLOADING_FAILURE */
class DeviceBasedLoginActivity$1 implements Runnable {
    final /* synthetic */ DeviceBasedLoginActivity f24172a;

    DeviceBasedLoginActivity$1(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        this.f24172a = deviceBasedLoginActivity;
    }

    public void run() {
        if (!this.f24172a.N.booleanValue() || this.f24172a.E) {
            this.f24172a.H = false;
        } else if (!this.f24172a.K) {
            DeviceBasedLoginActivity.k(this.f24172a);
        }
    }
}
