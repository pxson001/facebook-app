package com.facebook.device_id;

/* compiled from: scheduled_publish_timestamp */
class C0206xea4c49e1 implements Runnable {
    final /* synthetic */ UniqueDeviceIdBroadcastAppStateReceiverRegistration f2920a;
    private final UniqueDeviceIdBroadcastSender f2921b;

    public C0206xea4c49e1(UniqueDeviceIdBroadcastAppStateReceiverRegistration uniqueDeviceIdBroadcastAppStateReceiverRegistration, UniqueDeviceIdBroadcastSender uniqueDeviceIdBroadcastSender) {
        this.f2920a = uniqueDeviceIdBroadcastAppStateReceiverRegistration;
        this.f2921b = uniqueDeviceIdBroadcastSender;
    }

    public void run() {
        this.f2921b.i();
    }
}
