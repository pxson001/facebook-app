package com.facebook.uberbar.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06754;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06765;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06786;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: nearby_tiles_db */
public class UberSearchResultsAdapter extends BaseAdapter {
    private static final Object f5098a = new Object();
    private static final Object f5099b = new Object();
    public final LayoutInflater f5100c;
    public List<SearchTypeaheadResult> f5101d = Collections.emptyList();
    private FetchStatus f5102e;
    public C06765 f5103f;
    public C06754 f5104g;
    public C06786 f5105h;
    private FbNetworkManager f5106i;

    /* compiled from: nearby_tiles_db */
    public enum FetchStatus {
        NO_QUERY,
        COMPLETED,
        ONGOING
    }

    /* compiled from: nearby_tiles_db */
    enum RowType {
        NO_RESULTS,
        RESULT,
        LOADING_MORE
    }

    @Inject
    public UberSearchResultsAdapter(LayoutInflater layoutInflater, FbNetworkManager fbNetworkManager) {
        this.f5100c = (LayoutInflater) Preconditions.checkNotNull(layoutInflater);
        this.f5102e = FetchStatus.NO_QUERY;
        this.f5106i = fbNetworkManager;
    }

    public final void m6386a(List<SearchTypeaheadResult> list, FetchStatus fetchStatus) {
        this.f5101d = ImmutableList.copyOf(list);
        this.f5102e = fetchStatus;
        AdapterDetour.a(this, -437909931);
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getItemViewType(int i) {
        return m6384a(i).ordinal();
    }

    public int getCount() {
        if (this.f5102e == FetchStatus.ONGOING || (!this.f5106i.d() && this.f5102e != FetchStatus.NO_QUERY && this.f5102e != FetchStatus.COMPLETED)) {
            return this.f5101d.size() + 1;
        }
        if (this.f5102e == FetchStatus.COMPLETED && this.f5101d.size() == 0) {
            return 1;
        }
        return this.f5101d.size();
    }

    public Object getItem(int i) {
        switch (m6384a(i)) {
            case NO_RESULTS:
                return f5099b;
            case LOADING_MORE:
                return f5098a;
            case RESULT:
                return this.f5101d.get(i);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        RowType a = m6384a(i);
        if (a == RowType.LOADING_MORE) {
            return view == null ? this.f5100c.inflate(2130907587, viewGroup, false) : view;
        } else {
            if (a != RowType.NO_RESULTS) {
                UberbarResultView a2 = m6385a(view, viewGroup).m6395a((SearchTypeaheadResult) getItem(i));
                a2.f5134m = i;
                return a2;
            } else if (view == null) {
                return this.f5100c.inflate(2130907588, viewGroup, false);
            } else {
                return view;
            }
        }
    }

    private RowType m6384a(int i) {
        if ((this.f5102e == FetchStatus.ONGOING || !this.f5106i.d()) && i == this.f5101d.size()) {
            return RowType.LOADING_MORE;
        }
        if (this.f5102e == FetchStatus.COMPLETED && this.f5101d.size() == 0) {
            return RowType.NO_RESULTS;
        }
        return RowType.RESULT;
    }

    private UberbarResultView m6385a(View view, ViewGroup viewGroup) {
        if (view != null) {
            return (UberbarResultView) view;
        }
        UberbarResultView uberbarResultView = new UberbarResultView(viewGroup.getContext());
        uberbarResultView.f5140s = this.f5103f;
        uberbarResultView = uberbarResultView;
        uberbarResultView.f5141t = this.f5104g;
        uberbarResultView = uberbarResultView;
        uberbarResultView.f5142u = this.f5105h;
        return uberbarResultView;
    }
}
