package com.facebook.widget.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: initial_typeahead_query */
public abstract class BetterPagerAdapter extends PagerAdapter {
    private final DefaultAndroidThreadUtil f10834a;
    private int f10835b = 0;
    private int f10836c = 0;
    @Nullable
    public Object f10837d;

    public abstract Object mo767b(ViewGroup viewGroup, int i);

    public abstract void mo768c(ViewGroup viewGroup, int i, Object obj);

    protected BetterPagerAdapter(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f10834a = defaultAndroidThreadUtil;
    }

    public final void kR_() {
        boolean z = true;
        this.f10834a.a();
        Preconditions.checkArgument(this.f10835b == 0, "Changing data set while instantiating item!");
        if (this.f10836c != 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Changing data set while destroying item!");
        super.kR_();
    }

    public final Object m12759a(ViewGroup viewGroup, int i) {
        this.f10834a.a();
        this.f10835b++;
        Object b = mo767b(viewGroup, i);
        this.f10835b--;
        return b;
    }

    public final void m12760a(ViewGroup viewGroup, int i, Object obj) {
        this.f10834a.a();
        this.f10836c++;
        mo768c(viewGroup, i, obj);
        this.f10836c--;
    }

    public final void m12762b(ViewGroup viewGroup, int i, Object obj) {
        super.b(viewGroup, i, obj);
        this.f10837d = obj;
    }
}
