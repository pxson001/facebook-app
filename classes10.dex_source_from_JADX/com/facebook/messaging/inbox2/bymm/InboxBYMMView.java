package com.facebook.messaging.inbox2.bymm;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: set_email */
public class InboxBYMMView extends CustomFrameLayout implements InboxUnitViewWithRecyclerView {
    @Inject
    public InboxBYMMAdapter f2686a;
    private BetterRecyclerView f2687b;
    private InboxBYMMViewData f2688c;
    private LinearLayoutManager f2689d;

    private static <T extends View> void m2657a(Class<T> cls, T t) {
        m2658a((Object) t, t.getContext());
    }

    private static void m2658a(Object obj, Context context) {
        ((InboxBYMMView) obj).f2686a = new InboxBYMMAdapter(LayoutInflaterMethodAutoProvider.b(FbInjector.get(context)));
    }

    private void m2656a(InboxBYMMAdapter inboxBYMMAdapter) {
        this.f2686a = inboxBYMMAdapter;
    }

    public InboxBYMMView(Context context) {
        super(context);
        m2655a();
    }

    public InboxBYMMView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2655a();
    }

    public InboxBYMMView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2655a();
    }

    private void m2655a() {
        m2657a(InboxBYMMView.class, (View) this);
        setContentView(2130904859);
        this.f2687b = (BetterRecyclerView) c(2131563085);
        BetterRecyclerView betterRecyclerView = this.f2687b;
        getContext();
        betterRecyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        this.f2689d = new LinearLayoutManager(getContext());
        this.f2689d.b(0);
        this.f2687b.setLayoutManager(this.f2689d);
        this.f2687b.setAdapter(this.f2686a);
    }

    public void setData(InboxBYMMViewData inboxBYMMViewData) {
        this.f2688c = inboxBYMMViewData;
        this.f2687b.setLayoutManager(this.f2689d);
        InboxBYMMAdapter inboxBYMMAdapter = this.f2686a;
        inboxBYMMAdapter.f2678c = this.f2688c;
        inboxBYMMAdapter.f2680e = inboxBYMMAdapter.f2678c.f2690a;
        inboxBYMMAdapter.notifyDataSetChanged();
        this.f2687b.requestLayout();
    }

    public BetterRecyclerView getRecyclerView() {
        return this.f2687b;
    }

    public InboxAdapter getInboxAdapter() {
        return this.f2686a;
    }
}
