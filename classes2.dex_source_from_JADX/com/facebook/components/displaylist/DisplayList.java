package com.facebook.components.displaylist;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;

/* compiled from: geometric_decay_constant */
public class DisplayList {
    private PlatformDisplayList f22642a;
    private boolean f22643b;
    private boolean f22644c;

    private DisplayList(PlatformDisplayList platformDisplayList) {
        this.f22642a = platformDisplayList;
    }

    @Nullable
    public static DisplayList m30572a(Activity activity, String str) {
        PlatformDisplayList a;
        if (VERSION.SDK_INT >= 23) {
            a = DisplayListMarshmallow.a(str);
        } else if (VERSION.SDK_INT >= 21) {
            a = DisplayListLollipop.a(str);
        } else {
            a = DisplayListICS.a(activity, str);
        }
        if (a == null) {
            return null;
        }
        return new DisplayList(a);
    }

    public final Canvas m30573a(int i, int i2) {
        if (this.f22644c) {
            throw new DisplayListException(new IllegalStateException("Can't start a DisplayList that is already started"));
        }
        this.f22643b = false;
        Canvas a = this.f22642a.a(i, i2);
        this.f22644c = true;
        return a;
    }

    public final void m30575a(Canvas canvas) {
        if (this.f22644c) {
            this.f22644c = false;
            this.f22642a.a(canvas);
            this.f22643b = true;
            return;
        }
        throw new DisplayListException(new IllegalStateException("Can't end a DisplayList that is not started"));
    }

    public final void m30577b(Canvas canvas) {
        if (this.f22643b) {
            this.f22642a.b(canvas);
            return;
        }
        throw new DisplayListException(new IllegalStateException("Can't draw a DisplayList that is not valid"));
    }

    public final void m30574a(int i, int i2, int i3, int i4) {
        if (this.f22643b) {
            this.f22643b = false;
            this.f22642a.a(i, i2, i3, i4);
            this.f22643b = true;
            return;
        }
        throw new DisplayListException(new IllegalStateException("Can't call setBounds on a DisplayList that is not valid"));
    }

    public final boolean m30576a() {
        return this.f22643b;
    }
}
