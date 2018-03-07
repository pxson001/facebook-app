package com.facebook.backstage.consumption;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.backstage.consumption.BackstageFragment.C04323;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: saved/.* */
public class BackstageProfilesRecyclerAdapter extends Adapter {
    public final ImmutableList<BackstageProfile> f4568a;
    public final ImmutableList<BackstageProfile> f4569b;
    private final C04323 f4570c;
    private final BackstagePanelViewProvider f4571d;
    public final BackstageNavigatorApi f4572e = BackstageNavigatorApi.m4489a();
    private int f4573f;
    public BackstageImportButton f4574g;
    public boolean f4575h;

    /* compiled from: saved/.* */
    public class C04463 implements OnClickListener {
        final /* synthetic */ BackstageProfilesRecyclerAdapter f4567a;

        public C04463(BackstageProfilesRecyclerAdapter backstageProfilesRecyclerAdapter) {
            this.f4567a = backstageProfilesRecyclerAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1821493164);
            this.f4567a.f4572e.m4492a(NavigationState.MAIN_LIST, NavigationState.AUDIENCE_CONTROL);
            Logger.a(2, EntryType.UI_INPUT_END, 238943182, a);
        }
    }

    @Inject
    public BackstageProfilesRecyclerAdapter(@Assisted OnPanelClick onPanelClick, @Assisted ImmutableList<BackstageProfile> immutableList, @Assisted ImmutableList<BackstageProfile> immutableList2, BackstagePanelViewProvider backstagePanelViewProvider) {
        this.f4570c = onPanelClick;
        this.f4568a = immutableList;
        this.f4569b = immutableList2;
        this.f4571d = backstagePanelViewProvider;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == this.f4568a.size() && this.f4569b.size() != 0) {
            return 2;
        }
        if (this.f4569b.size() == 0 && this.f4575h) {
            if (this.f4568a.size() == 0) {
                return 3;
            }
            if (this.f4568a.size() == 1 && ((BackstageProfile) this.f4568a.get(0)).f5115d) {
                return 3;
            }
        }
        return 0;
    }

    public final ViewHolder m4516a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return this.f4571d.m4507a((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903362, viewGroup, false));
            case 1:
                MainListActionPanelController mainListActionPanelController = new MainListActionPanelController((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903359, viewGroup, false), this.f4570c);
                this.f4574g = mainListActionPanelController.f4610l;
                this.f4574g.setBadgeCount(this.f4573f);
                return mainListActionPanelController;
            case 2:
                return new ViewHolder(this, (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903360, viewGroup, false)) {
                    final /* synthetic */ BackstageProfilesRecyclerAdapter f4565l;
                };
            case 3:
                View view = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903353, viewGroup, false);
                view.findViewById(2131559842).setOnClickListener(new C04463(this));
                return new ViewHolder(this, view) {
                    final /* synthetic */ BackstageProfilesRecyclerAdapter f4566l;
                };
            default:
                return null;
        }
    }

    public final void m4517a(ViewHolder viewHolder, int i) {
        if (i == 0) {
            if (this.f4568a.size() == 0) {
                ((MainListActionPanelController) viewHolder).m4533a(null);
            } else {
                ((MainListActionPanelController) viewHolder).m4533a((BackstageProfile) this.f4568a.get(0));
            }
        } else if (i < this.f4568a.size()) {
            ((BackstagePanelView) viewHolder).m4506a((BackstageProfile) this.f4568a.get(i), this.f4570c);
        } else if (this.f4569b.size() != 0 && i != this.f4568a.size()) {
            ((BackstagePanelView) viewHolder).m4506a((BackstageProfile) this.f4569b.get(i - (this.f4568a.size() + 1)), this.f4570c);
        }
    }

    public final int aZ_() {
        int i;
        int i2 = 1;
        if (this.f4575h) {
            i = 2;
        } else {
            i = 1;
        }
        int size = this.f4568a.size() + this.f4569b.size();
        if (this.f4569b.isEmpty()) {
            i2 = 0;
        }
        return Math.max(i, i2 + size);
    }

    public final void m4518e(int i) {
        this.f4573f = i;
        if (this.f4574g != null) {
            this.f4574g.setBadgeCount(i);
        }
    }
}
