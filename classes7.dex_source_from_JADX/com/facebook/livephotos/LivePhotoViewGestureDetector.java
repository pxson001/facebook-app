package com.facebook.livephotos;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewConfiguration;

@TargetApi(16)
/* compiled from: phone_uri */
public class LivePhotoViewGestureDetector implements Callback {
    public int f6621a;
    public int f6622b;
    public final Handler f6623c = new Handler(this);
    public int f6624d;
    public LivePhotoGestureListener f6625e;
    public boolean f6626f = false;
    public long f6627g;

    public LivePhotoViewGestureDetector(Context context, LivePhotoGestureListener livePhotoGestureListener) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f6624d = scaledTouchSlop * scaledTouchSlop;
        this.f6625e = livePhotoGestureListener;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f6626f = true;
                this.f6627g = m8541a();
                this.f6625e.mo360a();
                break;
        }
        return true;
    }

    public static final long m8541a() {
        return SystemClock.elapsedRealtime();
    }
}
