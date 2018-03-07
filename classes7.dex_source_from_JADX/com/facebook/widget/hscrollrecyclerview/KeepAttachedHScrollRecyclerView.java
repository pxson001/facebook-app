package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import javax.inject.Inject;

/* compiled from: dac3 */
public class KeepAttachedHScrollRecyclerView extends HScrollRecyclerView implements RecyclerViewKeepAttached {
    @Inject
    public HScrollKeepAttachedLinearLayoutManagerProvider f16136i;
    private boolean f16137m;

    private static <T extends View> void m20174a(Class<T> cls, T t) {
        m20175a((Object) t, t.getContext());
    }

    private static void m20175a(Object obj, Context context) {
        ((KeepAttachedHScrollRecyclerView) obj).f16136i = (HScrollKeepAttachedLinearLayoutManagerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(HScrollKeepAttachedLinearLayoutManagerProvider.class);
    }

    private void m20173a(HScrollKeepAttachedLinearLayoutManagerProvider hScrollKeepAttachedLinearLayoutManagerProvider) {
        this.f16136i = hScrollKeepAttachedLinearLayoutManagerProvider;
    }

    public KeepAttachedHScrollRecyclerView(Context context) {
        this(context, null);
    }

    public KeepAttachedHScrollRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeepAttachedHScrollRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16137m = false;
    }

    protected HScrollLinearLayoutManager getLayoutManagerForInit() {
        m20176m();
        HScrollKeepAttachedLinearLayoutManagerProvider hScrollKeepAttachedLinearLayoutManagerProvider = this.f16136i;
        return new HScrollKeepAttachedLinearLayoutManager(this, getContext(), HScrollRecyclerViewChildMeasurer.a(hScrollKeepAttachedLinearLayoutManagerProvider), HScrollDimensionCache.a(hScrollKeepAttachedLinearLayoutManagerProvider));
    }

    private void m20176m() {
        if (!this.f16137m) {
            m20174a(KeepAttachedHScrollRecyclerView.class, (View) this);
            this.f16137m = true;
        }
    }

    public final boolean gK_() {
        return true;
    }
}
