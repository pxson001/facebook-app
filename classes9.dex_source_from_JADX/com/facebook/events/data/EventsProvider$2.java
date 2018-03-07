package com.facebook.events.data;

import android.content.ContentResolver;

/* compiled from: TelephonyManager.getNai failed  */
final class EventsProvider$2 implements Runnable {
    final /* synthetic */ ContentResolver f24369a;
    final /* synthetic */ EventsCommonContract f24370b;
    final /* synthetic */ int f24371c;

    EventsProvider$2(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, int i) {
        this.f24369a = contentResolver;
        this.f24370b = eventsCommonContract;
        this.f24371c = i;
    }

    public final void run() {
        EventsProvider.b(this.f24369a, this.f24370b, this.f24371c);
    }
}
