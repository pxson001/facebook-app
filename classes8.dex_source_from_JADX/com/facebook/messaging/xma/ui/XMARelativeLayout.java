package com.facebook.messaging.xma.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.xma.XMAView;
import com.facebook.messaging.xma.ui.XMALongClickHelper.LongClickListener;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: throwback_promotion */
public class XMARelativeLayout extends CustomRelativeLayout implements XMAView {
    @Inject
    public XMALongClickHelper f1611a;
    @Nullable
    private 1 f1612b;

    /* compiled from: throwback_promotion */
    public class C01711 implements LongClickListener {
        final /* synthetic */ XMARelativeLayout f1610a;

        public C01711(XMARelativeLayout xMARelativeLayout) {
            this.f1610a = xMARelativeLayout;
        }

        public final void mo69a() {
            this.f1610a.performLongClick();
        }
    }

    public static void m1803a(Object obj, Context context) {
        ((XMARelativeLayout) obj).f1611a = XMALongClickHelper.m1799b(FbInjector.get(context));
    }

    public XMARelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = XMARelativeLayout.class;
        m1803a(this, getContext());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1611a.m1800a(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1197223858);
        this.f1611a.m1801b(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 243714063, a);
        return onTouchEvent;
    }

    public void setXMACallback(@Nullable 1 1) {
        this.f1612b = 1;
        m1804a(1);
    }

    public void m1804a(@Nullable 1 1) {
    }
}
