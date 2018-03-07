package com.facebook.messaging.sms.broadcast;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.Contacts;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: qrcode_save_pressed */
public class SmsTakeoverContactsObserver {
    public final MonotonicClock f4078a;
    public final Handler f4079b;
    private final ContentResolver f4080c;
    public final BaseFbBroadcastManager f4081d;
    public long f4082e;
    public Runnable f4083f = new C06101(this);
    private ContentObserver f4084g = new ContentObserver(this, this.f4079b) {
        final /* synthetic */ SmsTakeoverContactsObserver f4076a;

        public void onChange(boolean z) {
            long j = 0;
            super.onChange(z);
            if (this.f4076a.f4082e == 0) {
                this.f4076a.f4082e = this.f4076a.f4078a.now();
            } else {
                j = this.f4076a.f4078a.now() - this.f4076a.f4082e;
            }
            if (j < 30000) {
                HandlerDetour.a(this.f4076a.f4079b, this.f4076a.f4083f);
                HandlerDetour.b(this.f4076a.f4079b, this.f4076a.f4083f, 5000, 191292366);
            }
        }
    };
    private ContentObserver f4085h = new ContentObserver(this, this.f4079b) {
        final /* synthetic */ SmsTakeoverContactsObserver f4077a;

        public void onChange(boolean z) {
            super.onChange(z);
            HandlerDetour.a(this.f4077a.f4079b, this.f4077a.f4083f);
            this.f4077a.f4082e = 0;
        }
    };

    /* compiled from: qrcode_save_pressed */
    class C06101 implements Runnable {
        final /* synthetic */ SmsTakeoverContactsObserver f4075a;

        C06101(SmsTakeoverContactsObserver smsTakeoverContactsObserver) {
            this.f4075a = smsTakeoverContactsObserver;
        }

        public void run() {
            SmsTakeoverContactsObserver smsTakeoverContactsObserver = this.f4075a;
            smsTakeoverContactsObserver.f4081d.a(MessagesBroadcastIntents.z);
            smsTakeoverContactsObserver.f4082e = 0;
        }
    }

    @Inject
    public SmsTakeoverContactsObserver(MonotonicClock monotonicClock, Handler handler, ContentResolver contentResolver, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f4078a = monotonicClock;
        this.f4079b = handler;
        this.f4080c = contentResolver;
        this.f4081d = baseFbBroadcastManager;
    }

    public final void m3761a() {
        this.f4080c.registerContentObserver(Contacts.CONTENT_URI, true, this.f4084g);
        this.f4080c.registerContentObserver(Calls.CONTENT_URI, true, this.f4085h);
    }

    public final void m3762b() {
        HandlerDetour.a(this.f4079b, this.f4083f);
        this.f4080c.unregisterContentObserver(this.f4084g);
        this.f4080c.unregisterContentObserver(this.f4085h);
        this.f4082e = 0;
    }
}
