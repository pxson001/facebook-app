package com.facebook.events.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.support.v4.content.CursorLoader;

/* compiled from: completion_url */
public class EventsCursorLoader extends CursorLoader {
    public final /* synthetic */ Object m16942d() {
        return f();
    }

    public EventsCursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context, uri, strArr, str, strArr2, str2);
    }

    public final Cursor m16943f() {
        int threadPriority = Process.getThreadPriority(Process.myTid());
        Process.setThreadPriority(0);
        try {
            Cursor f = super.f();
            return f;
        } finally {
            Process.setThreadPriority(threadPriority);
        }
    }
}
