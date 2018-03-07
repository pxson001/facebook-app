package com.facebook.places.checkin.ui;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.widget.LazyView;

/* compiled from: child_elements */
public abstract class BaseCheckinNiemUI {
    protected Resources f18064a;
    protected String f18065b;
    protected final LazyView<LinearLayout> f18066c;
    private final SparseArray<String> f18067d = new SparseArray();

    public abstract void mo1072a();

    public abstract void mo1073a(OnClickListener onClickListener);

    public abstract boolean mo1074a(OnClickListener onClickListener, OnDismissListener onDismissListener);

    protected abstract View mo1075b();

    public abstract void mo1076b(OnClickListener onClickListener);

    public abstract void mo1077c(OnClickListener onClickListener);

    public abstract void mo1078d(OnClickListener onClickListener);

    public abstract void mo1079e(OnClickListener onClickListener);

    public abstract void mo1080f(OnClickListener onClickListener);

    public BaseCheckinNiemUI(LazyView lazyView, String str, Resources resources) {
        this.f18066c = lazyView;
        this.f18065b = str;
        this.f18064a = resources;
    }

    protected final String m22017a(int i, String... strArr) {
        String str = (String) this.f18067d.get(i);
        if (str != null) {
            return str;
        }
        str = this.f18064a.getString(i, strArr);
        this.f18067d.put(i, str);
        return str;
    }

    public final boolean m22024c() {
        return (this.f18066c == null || mo1075b() == null || mo1075b().getVisibility() != 0) ? false : true;
    }
}
