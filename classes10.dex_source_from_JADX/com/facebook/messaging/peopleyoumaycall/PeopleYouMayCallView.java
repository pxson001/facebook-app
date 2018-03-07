package com.facebook.messaging.peopleyoumaycall;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: report_attribution_fragment */
public class PeopleYouMayCallView extends CustomFrameLayout {
    @Inject
    PeopleYouMayCallAdapter f3454a;
    @Inject
    PeopleYouMayCallViewHelper f3455b;
    private RecyclerView f3456c;
    private LinearLayoutManager f3457d;
    private GridLayoutManager f3458e;

    private static <T extends View> void m3342a(Class<T> cls, T t) {
        m3343a((Object) t, t.getContext());
    }

    private static void m3343a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PeopleYouMayCallView) obj).m3341a(new PeopleYouMayCallAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector)), PeopleYouMayCallViewHelper.m3347b(fbInjector));
    }

    private void m3341a(PeopleYouMayCallAdapter peopleYouMayCallAdapter, PeopleYouMayCallViewHelper peopleYouMayCallViewHelper) {
        this.f3454a = peopleYouMayCallAdapter;
        this.f3455b = peopleYouMayCallViewHelper;
    }

    public PeopleYouMayCallView(Context context) {
        super(context, null, 2130773769);
        m3340a();
    }

    public PeopleYouMayCallView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 2130773769);
        m3340a();
    }

    public PeopleYouMayCallView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3340a();
    }

    private void m3340a() {
        m3342a(PeopleYouMayCallView.class, (View) this);
        setContentView(2130906165);
        this.f3456c = (RecyclerView) c(2131560745);
        this.f3457d = new LinearLayoutManager(getContext());
        this.f3457d.b(0);
        this.f3458e = new GridLayoutManager(getContext(), 4);
        this.f3456c.setLayoutManager(this.f3457d);
        this.f3456c.setAdapter(this.f3454a);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2005139991);
        super.onSizeChanged(i, i2, i3, i4);
        this.f3458e.a(this.f3455b.m3348a(i));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 150811862, a);
    }

    public void setData(PeopleYouMayCallViewData peopleYouMayCallViewData) {
        int dimensionPixelSize;
        Resources resources = getResources();
        if (peopleYouMayCallViewData.f3460b) {
            dimensionPixelSize = resources.getDimensionPixelSize(2131433699);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(2131433698);
        }
        this.f3456c.setLayoutManager(this.f3457d);
        PeopleYouMayCallAdapter peopleYouMayCallAdapter = this.f3454a;
        peopleYouMayCallAdapter.f3446b = peopleYouMayCallViewData;
        peopleYouMayCallAdapter.f3447c = peopleYouMayCallAdapter.f3446b.f3459a;
        peopleYouMayCallAdapter.notifyDataSetChanged();
        this.f3456c.getLayoutParams().height = dimensionPixelSize;
        this.f3456c.requestLayout();
    }

    public void setListener(PeopleYouMayCallListener peopleYouMayCallListener) {
        this.f3454a.f3448d = peopleYouMayCallListener;
    }
}
