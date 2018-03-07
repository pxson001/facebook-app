package com.facebook.backstage.consumption;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.backstage.consumption.BackstageProfilesRecyclerAdapter.OnPanelClick;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: scan */
public class BackstageGridView extends FrameLayout {
    @Inject
    public BackstageProfilesRecyclerAdapterProvider f4505a;
    private final SwipeRefreshLayout f4506b;
    private final RecyclerView f4507c;
    private final LayoutManager f4508d;
    private BackstageProfilesRecyclerAdapter f4509e;
    private int f4510f;

    private static <T extends View> void m4479a(Class<T> cls, T t) {
        m4480a((Object) t, t.getContext());
    }

    private static void m4480a(Object obj, Context context) {
        ((BackstageGridView) obj).f4505a = (BackstageProfilesRecyclerAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(BackstageProfilesRecyclerAdapterProvider.class);
    }

    public BackstageGridView(Context context) {
        this(context, null);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public BackstageGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4479a(BackstageGridView.class, (View) this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130903356, this);
        this.f4506b = (SwipeRefreshLayout) inflate.findViewById(2131559857);
        this.f4507c = (RecyclerView) inflate.findViewById(2131559858);
        this.f4507c.v = true;
        this.f4508d = new LinearLayoutManager(getContext());
        this.f4507c.setLayoutManager(this.f4508d);
    }

    public final void m4482a(ImmutableList<BackstageProfile> immutableList, ImmutableList<BackstageProfile> immutableList2, OnPanelClick onPanelClick, boolean z) {
        this.f4509e = new BackstageProfilesRecyclerAdapter(onPanelClick, immutableList, immutableList2, (BackstagePanelViewProvider) this.f4505a.getOnDemandAssistedProviderForStaticDi(BackstagePanelViewProvider.class));
        this.f4509e.f4575h = z;
        this.f4509e.m4518e(this.f4510f);
        this.f4507c.setAdapter(this.f4509e);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f4506b.e = onRefreshListener;
    }

    public void setRefreshing(boolean z) {
        this.f4506b.setRefreshing(z);
    }

    public final boolean m4483a() {
        this.f4506b.setRefreshing(false);
        return false;
    }

    public final boolean m4484b() {
        if (this.f4509e != null) {
            BackstageProfilesRecyclerAdapter backstageProfilesRecyclerAdapter = this.f4509e;
            Object obj = (backstageProfilesRecyclerAdapter.f4569b.isEmpty() && backstageProfilesRecyclerAdapter.f4568a.isEmpty()) ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public View getImportButton() {
        return this.f4509e.f4574g;
    }

    public final void m4481a(int i) {
        this.f4510f = i;
        if (this.f4509e != null) {
            this.f4509e.m4518e(this.f4510f);
        }
    }

    public final void m4485c() {
        m4481a(0);
    }

    private void m4478a(BackstageProfilesRecyclerAdapterProvider backstageProfilesRecyclerAdapterProvider) {
        this.f4505a = backstageProfilesRecyclerAdapterProvider;
    }
}
