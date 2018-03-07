package com.facebook.messaging.xma.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.xma.XMAAction;
import com.facebook.messaging.xma.XMAActionHandler;
import com.facebook.messaging.xma.XMAActionHandlerManager;
import com.facebook.messaging.xma.XMAView;
import com.facebook.messaging.xma.ui.XMALongClickHelper.LongClickListener;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.widget.CustomLinearLayout;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: throwback_settings */
public class XMALinearLayout extends CustomLinearLayout implements XMAView {
    @Inject
    public XMALongClickHelper f1603a;
    @Nullable
    private 1 f1604b;

    /* compiled from: throwback_settings */
    class C01691 implements LongClickListener {
        final /* synthetic */ XMALinearLayout f1602a;

        C01691(XMALinearLayout xMALinearLayout) {
            this.f1602a = xMALinearLayout;
        }

        public final void mo69a() {
            this.f1602a.performLongClick();
        }
    }

    private static <T extends View> void m1794a(Class<T> cls, T t) {
        m1795a((Object) t, t.getContext());
    }

    private static void m1795a(Object obj, Context context) {
        ((XMALinearLayout) obj).f1603a = XMALongClickHelper.m1799b(FbInjector.get(context));
    }

    public XMALinearLayout(Context context) {
        super(context);
        m1792a();
    }

    public XMALinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1792a();
    }

    public XMALinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1792a();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m1792a() {
        m1794a(XMALinearLayout.class, (View) this);
        this.f1603a.f1607b = new C01691(this);
    }

    private void m1793a(XMALongClickHelper xMALongClickHelper) {
        this.f1603a = xMALongClickHelper;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1603a.m1800a(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1840911823);
        this.f1603a.m1801b(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1555901936, a);
        return onTouchEvent;
    }

    public void setXMACallback(@Nullable 1 1) {
        this.f1604b = 1;
        m1797a(1);
    }

    public void m1797a(@Nullable 1 1) {
    }

    public final void m1796a(Intent intent, int i) {
        if (this.f1604b != null) {
            1 1 = this.f1604b;
            if (1.a != null && this == 1.b) {
                1.a.a(intent, i);
            }
        }
    }

    public final boolean m1798a(XMAAction xMAAction) {
        if (this.f1604b == null) {
            return false;
        }
        boolean z;
        1 1 = this.f1604b;
        if (1.c != null) {
            XMAActionHandlerManager xMAActionHandlerManager = 1.c;
            Message message = 1.d;
            int i = 0;
            Set<XMAActionHandler> set = (Set) xMAActionHandlerManager.f1573a.get(xMAAction.f1571b);
            if (set != null) {
                for (XMAActionHandler a : set) {
                    i = a.m1743a(message, xMAAction, this) | i;
                }
            }
            if (i != 0) {
                z = true;
                return z;
            }
        }
        z = false;
        return z;
    }
}
