package com.facebook.rtc.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;

/* compiled from: application/vnd.wap.multipart.* */
class RecentCallsDb$3 implements Runnable {
    final /* synthetic */ boolean f19802a;
    final /* synthetic */ boolean f19803b;
    final /* synthetic */ String f19804c;
    final /* synthetic */ String f19805d;
    final /* synthetic */ long f19806e;
    final /* synthetic */ long f19807f;
    final /* synthetic */ boolean f19808g;
    final /* synthetic */ boolean f19809h;
    final /* synthetic */ boolean f19810i;
    final /* synthetic */ boolean f19811j;
    final /* synthetic */ boolean f19812k;
    final /* synthetic */ RecentCallsDb f19813l;

    RecentCallsDb$3(RecentCallsDb recentCallsDb, boolean z, boolean z2, String str, String str2, long j, long j2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f19813l = recentCallsDb;
        this.f19802a = z;
        this.f19803b = z2;
        this.f19804c = str;
        this.f19805d = str2;
        this.f19806e = j;
        this.f19807f = j2;
        this.f19808g = z3;
        this.f19809h = z4;
        this.f19810i = z5;
        this.f19811j = z6;
        this.f19812k = z7;
    }

    public void run() {
        int i;
        String str;
        int i2 = 2;
        SQLiteDatabase a = this.f19813l.c.a();
        if (this.f19802a) {
            i = 3;
        } else if (this.f19803b) {
            i = 2;
        } else {
            i = 1;
        }
        Class cls = RecentCallsDb.a;
        Object[] objArr = new Object[9];
        if (this.f19804c == null) {
            str = "";
        } else {
            str = this.f19804c;
        }
        objArr[0] = str;
        if (this.f19805d == null) {
            str = "";
        } else {
            str = this.f19805d;
        }
        objArr[1] = str;
        objArr[2] = Long.valueOf(this.f19806e);
        objArr[3] = Long.valueOf(this.f19807f);
        objArr[4] = Boolean.valueOf(this.f19808g);
        objArr[5] = Boolean.valueOf(this.f19809h);
        objArr[6] = Boolean.valueOf(this.f19803b);
        objArr[7] = Boolean.valueOf(this.f19810i);
        objArr[8] = Boolean.valueOf(this.f19811j);
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", this.f19804c == null ? "" : this.f19804c);
        contentValues.put("thread_id", this.f19805d == null ? "" : this.f19805d);
        contentValues.put("last_call_time", Long.valueOf(this.f19806e));
        contentValues.put("duration", Long.valueOf(this.f19807f));
        contentValues.put("answered", Boolean.valueOf(this.f19808g));
        String str2 = "direction";
        if (!this.f19809h) {
            i2 = 1;
        }
        contentValues.put(str2, Integer.valueOf(i2));
        contentValues.put("call_type", Integer.valueOf(i));
        contentValues.put("acknowledged", Boolean.valueOf(this.f19810i));
        contentValues.put("seen", Boolean.valueOf(this.f19811j));
        contentValues.put("on_going", Boolean.valueOf(this.f19812k));
        if (a != null && a.isOpen()) {
            if (!this.f19813l.i.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.t, false)) {
                a.delete("person_summary", "user_id = " + this.f19804c, null);
            }
            SQLiteDetour.a(-2141437305);
            long insert = a.insert("person_summary", null, contentValues);
            SQLiteDetour.a(1542326193);
            if (insert >= 0) {
                RecentCallsDb.b(this.f19813l, null);
                RecentCallsDb.e(this.f19813l);
                if (this.f19808g || this.f19809h) {
                    RecentCallsDb.b(this.f19813l, this.f19804c);
                }
                this.f19813l.k = RecentCallsDb.h(this.f19813l);
                RecentCallsDb.f(this.f19813l);
                RecentCallsDb.g(this.f19813l);
            }
        }
    }
}
