package com.facebook.events.data;

import android.content.ContentResolver;
import com.facebook.events.model.Event;

/* compiled from: TelephonyManager.getNai failed  */
final class EventsProvider$1 implements Runnable {
    final /* synthetic */ ContentResolver f24366a;
    final /* synthetic */ EventsCommonContract f24367b;
    final /* synthetic */ Event f24368c;

    EventsProvider$1(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, Event event) {
        this.f24366a = contentResolver;
        this.f24367b = eventsCommonContract;
        this.f24368c = event;
    }

    public final void run() {
        EventsProvider.a(this.f24366a, this.f24367b, this.f24368c);
    }
}
