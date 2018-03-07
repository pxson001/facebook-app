package com.facebook.events.data;

import android.content.ContentResolver;

/* compiled from: TelephonyManager.getNai failed  */
final class EventsProvider$3 implements Runnable {
    final /* synthetic */ ContentResolver f24372a;
    final /* synthetic */ EventsCommonContract f24373b;
    final /* synthetic */ String f24374c;

    EventsProvider$3(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, String str) {
        this.f24372a = contentResolver;
        this.f24373b = eventsCommonContract;
        this.f24374c = str;
    }

    public final void run() {
        this.f24372a.delete(this.f24373b.m26203c(this.f24374c), null, null);
    }
}
