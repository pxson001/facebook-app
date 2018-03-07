package com.facebook.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms.signin.internal.forceCodeForRefreshToken */
public class CyclingTextSwitcher extends CustomTextSwitcher {
    public boolean f5609a;
    public CharSequence[] f5610b;
    private final CyclingHandler f5611c;

    /* compiled from: com.google.android.gms.signin.internal.forceCodeForRefreshToken */
    class CyclingHandler extends Handler {
        private final WeakReference<CyclingTextSwitcher> f5608a;

        public CyclingHandler(CyclingTextSwitcher cyclingTextSwitcher) {
            this.f5608a = new WeakReference(cyclingTextSwitcher);
        }

        public void handleMessage(Message message) {
            CyclingTextSwitcher cyclingTextSwitcher = (CyclingTextSwitcher) this.f5608a.get();
            if (cyclingTextSwitcher != null) {
                int i = message.arg1;
                int i2 = message.arg2;
                if (cyclingTextSwitcher.f5609a) {
                    cyclingTextSwitcher.setText(cyclingTextSwitcher.f5610b[i]);
                } else {
                    cyclingTextSwitcher.setCurrentText(cyclingTextSwitcher.f5610b[i]);
                }
                cyclingTextSwitcher.m10415a(cyclingTextSwitcher.m10412a(i + 1), (long) i2);
            }
        }
    }

    public CyclingTextSwitcher(Context context) {
        this(context, null);
    }

    public CyclingTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5609a = true;
        this.f5611c = new CyclingHandler(this);
    }

    public void setAnimated(boolean z) {
        this.f5609a = z;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 799004445);
        m10414a();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2099572577, a);
    }

    public final void m10420a(int[] iArr, long j, TimeUnit timeUnit) {
        String[] strArr = new String[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = getResources().getString(iArr[i]);
        }
        m10417a(strArr, j, timeUnit);
    }

    private void m10417a(String[] strArr, long j, TimeUnit timeUnit) {
        m10414a();
        this.f5610b = strArr;
        if (this.f5610b.length > 0) {
            setCurrentText(strArr[0]);
            if (this.f5610b.length > 1) {
                m10415a(1, timeUnit.toMillis(j));
            } else {
                m10414a();
            }
        }
    }

    private int m10412a(int i) {
        return this.f5610b == null ? i : i % this.f5610b.length;
    }

    private void m10415a(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.arg1 = i;
        obtain.arg2 = (int) j;
        this.f5611c.sendMessageDelayed(obtain, j);
    }

    private void m10414a() {
        this.f5611c.removeMessages(0);
    }
}
