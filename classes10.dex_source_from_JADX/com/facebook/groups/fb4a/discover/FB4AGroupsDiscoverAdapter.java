package com.facebook.groups.fb4a.discover;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.debug.log.BLog;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverFragment.C31371;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Turn on to print all Liger trace events in logcat. */
public class FB4AGroupsDiscoverAdapter extends FbBaseAdapter {
    public RetryClickedListener f21911a;
    public boolean f21912b;
    private boolean f21913c;
    public List<FB4ADiscoverRowDataModel> f21914d = new ArrayList();
    public Set<String> f21915e = new HashSet();
    public C31371 f21916f;
    private LoadingIndicatorView f21917g;

    /* compiled from: Turn on to print all Liger trace events in logcat. */
    enum ViewTypes {
        DISCOVER_ROW,
        LOADING_BAR
    }

    public final void m23051a(FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel) {
        this.f21915e.add(fB4ADiscoverRowDataModel.m22260a().m22249m());
    }

    public final boolean m23053a() {
        return (this.f21914d.isEmpty() || this.f21915e.size() == this.f21914d.size()) ? false : true;
    }

    public int getCount() {
        int size = this.f21914d == null ? 0 : this.f21914d.size();
        if (this.f21913c) {
            return size + 1;
        }
        return size;
    }

    public Object getItem(int i) {
        return (this.f21914d == null || i >= this.f21914d.size()) ? null : (FB4ADiscoverRowDataModel) this.f21914d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m23049a(int i, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i]) {
            case DISCOVER_ROW:
                return new FB4ADiscoverRowView(viewGroup.getContext());
            case LOADING_BAR:
                this.f21917g = (LoadingIndicatorView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905116, viewGroup, false);
                return this.f21917g;
            default:
                return new View(viewGroup.getContext());
        }
    }

    public final void m23050a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i2]) {
            case DISCOVER_ROW:
                boolean z;
                FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = (FB4ADiscoverRowDataModel) obj;
                FB4ADiscoverRowView fB4ADiscoverRowView = (FB4ADiscoverRowView) view;
                fB4ADiscoverRowView.f21909t = this.f21916f;
                if (!(fB4ADiscoverRowDataModel == null || fB4ADiscoverRowDataModel.m22260a() == null || fB4ADiscoverRowDataModel.m22260a().m22247k() == null || fB4ADiscoverRowDataModel.m22260a().m22247k().m22235a().size() >= 3)) {
                    m23051a(fB4ADiscoverRowDataModel);
                    BLog.a("FB4AGroupsDiscoverAdapter", "Members count for suggested group is less than 3");
                }
                if (fB4ADiscoverRowDataModel == null || fB4ADiscoverRowDataModel.m22260a() == null || fB4ADiscoverRowDataModel.m22260a().m22249m() == null || this.f21915e.contains(fB4ADiscoverRowDataModel.m22260a().m22249m())) {
                    z = true;
                } else {
                    z = false;
                }
                fB4ADiscoverRowView.m23048a(fB4ADiscoverRowDataModel, z);
                return;
            case LOADING_BAR:
                if (this.f21912b) {
                    if (this.f21913c && !this.f21917g.f()) {
                        this.f21917g.a();
                    }
                    this.f21917g.setVisibility(this.f21913c ? 0 : 8);
                    return;
                }
                this.f21917g.a(this.f21917g.getContext().getResources().getString(2131230811), this.f21911a);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        if (i == this.f21914d.size() && this.f21913c) {
            return ViewTypes.LOADING_BAR.ordinal();
        }
        if (i < this.f21914d.size()) {
            return ViewTypes.DISCOVER_ROW.ordinal();
        }
        BLog.a("FB4AGroupsDiscoverAdapter", "Position is greater than the number of item exist");
        return -1;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final void m23052a(boolean z) {
        if (z != this.f21913c) {
            this.f21913c = z;
            AdapterDetour.a(this, 1563358188);
        }
    }
}
