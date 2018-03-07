package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.view.RichDocumentAdapter;
import java.util.Arrays;

/* compiled from: offer_view */
public class RichDocumentScrollbarHelper implements InjectableComponentWithContext {
    private final Context f7346a;
    public final RichDocumentAdapter f7347b;
    public final LinearLayoutManager f7348c;
    public final SimpleRichDocumentBlockHeightPredictor f7349d;
    public int f7350e;
    public int f7351f;
    public int f7352g;
    private View f7353h;
    public int f7354i;
    public int[] f7355j;
    public float f7356k;

    /* compiled from: offer_view */
    class C08401 extends AdapterDataObserver {
        final /* synthetic */ RichDocumentScrollbarHelper f7345a;

        C08401(RichDocumentScrollbarHelper richDocumentScrollbarHelper) {
            this.f7345a = richDocumentScrollbarHelper;
        }

        public final void m7606b(int i, int i2) {
            super.b(i, i2);
            Object obj = new int[(this.f7345a.f7355j.length + i2)];
            Arrays.fill(obj, Integer.MIN_VALUE);
            System.arraycopy(this.f7345a.f7355j, 0, obj, 0, this.f7345a.f7355j.length);
            this.f7345a.f7355j = obj;
        }
    }

    public RichDocumentScrollbarHelper(Context context, LinearLayoutManager linearLayoutManager, RichDocumentAdapter richDocumentAdapter) {
        this(context, linearLayoutManager, richDocumentAdapter, new SimpleRichDocumentBlockHeightPredictor(context));
    }

    private RichDocumentScrollbarHelper(Context context, LinearLayoutManager linearLayoutManager, RichDocumentAdapter richDocumentAdapter, SimpleRichDocumentBlockHeightPredictor simpleRichDocumentBlockHeightPredictor) {
        this.f7346a = context;
        this.f7348c = linearLayoutManager;
        this.f7347b = richDocumentAdapter;
        this.f7354i = 0;
        this.f7349d = simpleRichDocumentBlockHeightPredictor;
        this.f7355j = new int[this.f7347b.aZ_()];
        Arrays.fill(this.f7355j, Integer.MIN_VALUE);
        this.f7347b.a(new C08401(this));
    }

    public final int m7608a() {
        m7607d();
        return this.f7350e;
    }

    public final int m7609b() {
        m7607d();
        return this.f7351f;
    }

    public final int m7610c() {
        m7607d();
        return this.f7352g;
    }

    private void m7607d() {
        View f = this.f7348c.f(0);
        if (f != null) {
            int i = this.f7348c.i(f);
            if (this.f7353h != f || this.f7354i != i) {
                int i2;
                this.f7353h = f;
                this.f7354i = i;
                int i3 = 0;
                int c = LayoutManager.c(f);
                int v = (this.f7348c.v() + c) - 1;
                for (i2 = c; i2 <= v; i2++) {
                    this.f7355j[i2] = LayoutManager.g(this.f7348c.f(i2 - c));
                }
                i2 = 0;
                while (i2 < c) {
                    v = this.f7355j[i2] + i3;
                    i2++;
                    i3 = v;
                }
                i2 = Math.abs(this.f7354i) + i3;
                while (c < this.f7355j.length) {
                    if (this.f7355j[c] == Integer.MIN_VALUE) {
                        int intValue;
                        int[] iArr = this.f7355j;
                        BlockData e = this.f7347b.m6882e(c);
                        SimpleRichDocumentBlockHeightPredictor simpleRichDocumentBlockHeightPredictor = this.f7349d;
                        if (simpleRichDocumentBlockHeightPredictor.f7488c.containsKey(Integer.valueOf(e.mo272n()))) {
                            intValue = ((Integer) simpleRichDocumentBlockHeightPredictor.f7488c.get(Integer.valueOf(e.mo272n()))).intValue();
                        } else {
                            intValue = simpleRichDocumentBlockHeightPredictor.f7489d;
                        }
                        iArr[c] = intValue;
                    }
                    i3 += this.f7355j[c];
                    c++;
                }
                this.f7352g = this.f7348c.x();
                float f2 = ((float) i2) / ((float) i3);
                if (i2 <= this.f7351f || f2 >= this.f7356k) {
                    this.f7351f = i2;
                    this.f7350e = i3;
                    this.f7356k = f2;
                }
            }
        }
    }

    public Context getContext() {
        return this.f7346a;
    }
}
