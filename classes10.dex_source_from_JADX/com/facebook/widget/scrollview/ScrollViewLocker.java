package com.facebook.widget.scrollview;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.ArrayList;
import java.util.List;

@ContextScoped
/* compiled from: expiration_year */
public class ScrollViewLocker {
    private static ScrollViewLocker f13001d;
    private static final Object f13002e = new Object();
    public final List<View> f13003a = new ArrayList();
    public LockableScrollView f13004b;
    private View f13005c;

    private static ScrollViewLocker m13040b() {
        return new ScrollViewLocker();
    }

    public final void m13042a(MotionEvent motionEvent) {
        if (this.f13004b != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                this.f13004b.setScrollLock(false);
                this.f13005c = null;
                return;
            }
            boolean z;
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            Rect rect = new Rect();
            for (View view : this.f13003a) {
                if (view.getGlobalVisibleRect(rect)) {
                    if (view == this.f13005c) {
                        int width = ((int) (((float) rect.width()) * 0.33f)) / 2;
                        int height = ((int) (((float) rect.height()) * 0.33f)) / 2;
                        rect.set(rect.left - width, rect.top - height, width + rect.right, height + rect.bottom);
                    }
                    if (rect.contains(rawX, rawY)) {
                        this.f13005c = view;
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z != this.f13004b.getLocked()) {
                this.f13004b.setScrollLock(z);
                if (!z) {
                    this.f13005c = null;
                    this.f13004b.m13038a(motionEvent);
                }
            }
        }
    }

    public static ScrollViewLocker m13039a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ScrollViewLocker b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13002e) {
                ScrollViewLocker scrollViewLocker;
                if (a2 != null) {
                    scrollViewLocker = (ScrollViewLocker) a2.a(f13002e);
                } else {
                    scrollViewLocker = f13001d;
                }
                if (scrollViewLocker == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m13040b();
                        if (a2 != null) {
                            a2.a(f13002e, b3);
                        } else {
                            f13001d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = scrollViewLocker;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m13041a() {
        this.f13004b = null;
        this.f13003a.clear();
        this.f13005c = null;
    }
}
