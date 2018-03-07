package com.facebook.rtc.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.debug.log.BLog;

/* compiled from: application/vnd.wap.multipart.* */
class RecentCallsDb$2 implements Runnable {
    final /* synthetic */ String f19799a;
    final /* synthetic */ boolean f19800b;
    final /* synthetic */ RecentCallsDb f19801c;

    RecentCallsDb$2(RecentCallsDb recentCallsDb, String str, boolean z) {
        this.f19801c = recentCallsDb;
        this.f19799a = str;
        this.f19800b = z;
    }

    public void run() {
        SQLiteDatabase a = this.f19801c.c.a();
        if (a == null || !a.isOpen()) {
            BLog.b(RecentCallsDb.a, "Unable to acquire db for markLastConferenceCallEnded");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("on_going", Boolean.valueOf(false));
        String str = "last_call_time = (SELECT max(last_call_time) FROM person_summary WHERE thread_id = ?) AND thread_id = ?";
        String[] strArr = new String[]{this.f19799a, this.f19799a};
        if (this.f19800b && a.update("person_summary", contentValues, str, strArr) > 0) {
            RecentCallsDb.f(this.f19801c);
        }
    }
}
