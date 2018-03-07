package com.facebook.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listeners.BaseAnimationListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms.gcm.INetworkTaskCallback */
public class NotificationTextSwitcher extends CustomTextSwitcher {
    public CharSequence f5676a;
    public AnimationListener f5677b;
    public long f5678c;
    public AtomicBoolean f5679d;
    private AtomicBoolean f5680e;
    private Handler f5681f = new C05211(this);

    /* compiled from: com.google.android.gms.gcm.INetworkTaskCallback */
    class C05211 extends Handler {
        final /* synthetic */ NotificationTextSwitcher f5674a;

        C05211(NotificationTextSwitcher notificationTextSwitcher) {
            this.f5674a = notificationTextSwitcher;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f5674a.getOutAnimation().setAnimationListener(this.f5674a.f5677b);
                this.f5674a.setText(this.f5674a.f5676a);
            } else if (message.what == 1) {
                this.f5674a.m10468a((CharSequence) message.obj, this.f5674a.f5678c);
                sendMessageDelayed(Message.obtain(message), this.f5674a.f5678c * 2);
            } else if (message.what == 2) {
                this.f5674a.setCurrentText(this.f5674a.f5676a);
                this.f5674a.f5679d.set(false);
            }
        }
    }

    /* compiled from: com.google.android.gms.gcm.INetworkTaskCallback */
    class C05222 extends BaseAnimationListener {
        final /* synthetic */ NotificationTextSwitcher f5675a;

        C05222(NotificationTextSwitcher notificationTextSwitcher) {
            this.f5675a = notificationTextSwitcher;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f5675a.f5679d.get()) {
                this.f5675a.f5679d.set(false);
                this.f5675a.getOutAnimation().setAnimationListener(null);
            }
        }
    }

    public NotificationTextSwitcher(Context context) {
        super(context);
        m10464b();
    }

    public NotificationTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10464b();
    }

    private void m10464b() {
        this.f5677b = new C05222(this);
        this.f5679d = new AtomicBoolean(false);
        this.f5680e = new AtomicBoolean(false);
    }

    public void setText(CharSequence charSequence) {
        if (!this.f5679d.get()) {
            this.f5676a = charSequence;
        }
        super.setText(charSequence);
    }

    public final void m10468a(CharSequence charSequence, long j) {
        if (!this.f5679d.getAndSet(true)) {
            if (VERSION.SDK_INT == 14 || VERSION.SDK_INT == 15) {
                setCurrentText(charSequence);
                this.f5681f.sendEmptyMessageDelayed(2, j);
                return;
            }
            setText(charSequence);
            this.f5681f.sendEmptyMessageDelayed(0, j);
        }
    }

    public final void m10469b(CharSequence charSequence, long j) {
        if (!this.f5680e.getAndSet(true)) {
            this.f5678c = j;
            this.f5681f.sendMessageDelayed(Message.obtain(this.f5681f, 1, charSequence), this.f5678c);
        }
    }

    public final void m10467a() {
        this.f5681f.removeMessages(0);
        this.f5681f.removeMessages(1);
        this.f5679d.set(false);
        this.f5680e.set(false);
    }

    public String getText() {
        return this.f5676a == null ? "" : (String) this.f5676a;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 75915469);
        m10467a();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1436451383, a);
    }
}
