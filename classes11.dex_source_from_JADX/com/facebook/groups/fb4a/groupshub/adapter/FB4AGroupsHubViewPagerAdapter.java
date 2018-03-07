package com.facebook.groups.fb4a.groupshub.adapter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.groups.adapter.AbstractFragmentHolderFragmentPagerAdapter;
import com.facebook.groups.fb4a.createrpanel.FB4AGroupsCreateTabFragment;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupGridFragment;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import com.facebook.groups.fb4a.react.GroupsReactFragment;
import com.facebook.groups.fb4a.react.GroupsReactFragment.Builder;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: _null_notif_story */
public class FB4AGroupsHubViewPagerAdapter extends AbstractFragmentHolderFragmentPagerAdapter {
    private Resources f10201a;
    public ImmutableList<GroupsHubTab> f10202b;
    private FB4AGroupsHubExperiments f10203c;

    /* compiled from: _null_notif_story */
    public interface GroupsHubTab {
        Fragment mo272a();

        boolean mo273b();

        int mo274c();

        TabType mo275d();
    }

    /* compiled from: _null_notif_story */
    class DiscoverGroupsHubTab implements GroupsHubTab {
        private Intent f10197a;

        DiscoverGroupsHubTab(Intent intent) {
            this.f10197a = intent;
        }

        public final Fragment mo272a() {
            String string = this.f10197a.getExtras().getString("extra_navigation_source");
            Bundle bundle = new Bundle();
            if (string != null) {
                bundle.putString("navSource", string);
            }
            Builder av = GroupsReactFragment.av();
            ImmersiveReactFragment.Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.a = StringFormatUtil.formatStrLocaleSafe("/groups_discovery");
            newBuilder = newBuilder;
            newBuilder.b = "FBGroupsDiscoveryRoute";
            newBuilder = newBuilder;
            newBuilder.k = true;
            av = av.a(newBuilder.a());
            Bundle bundle2 = av.a.getBundle("init_props");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putAll(bundle);
            av.a.putBundle("init_props", bundle2);
            av = av;
            String str = "cold_perf_marker";
            String str2 = "perfMarkerColdStart";
            Bundle bundle3 = av.a.getBundle("init_props");
            if (bundle3 == null) {
                bundle3 = new Bundle();
            }
            if (2097168 != null) {
                av.a.putInt(str, 2097168);
                bundle3.putString(str2, String.valueOf(2097168));
            }
            av.a.putBundle("init_props", bundle3);
            return av.a();
        }

        public final boolean mo273b() {
            return true;
        }

        public final int mo274c() {
            return 2131242500;
        }

        public final TabType mo275d() {
            return TabType.DISCOVER;
        }
    }

    /* compiled from: _null_notif_story */
    public class GroupsCreateHubTab implements GroupsHubTab {
        private boolean f10198a;
        private boolean f10199b;
        public int f10200c = 2131242501;

        GroupsCreateHubTab(boolean z, boolean z2) {
            this.f10198a = z;
            this.f10199b = z2;
        }

        public final Fragment mo272a() {
            if (!this.f10198a) {
                return new FB4AGroupsCreateTabFragment();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_creator_panel_enabled", this.f10199b);
            Builder av = GroupsReactFragment.av();
            ImmersiveReactFragment.Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.b = "FBGroupsCreationRoute";
            newBuilder = newBuilder;
            newBuilder.h = 1;
            newBuilder = newBuilder;
            newBuilder.e = true;
            newBuilder = newBuilder;
            newBuilder.d = 2131242504;
            newBuilder = newBuilder;
            newBuilder.k = true;
            newBuilder = newBuilder;
            newBuilder.f = bundle;
            return av.a(newBuilder.a()).a();
        }

        public final boolean mo273b() {
            return this.f10198a;
        }

        public final int mo274c() {
            return this.f10200c;
        }

        public final TabType mo275d() {
            return TabType.CREATE;
        }
    }

    /* compiled from: _null_notif_story */
    class GroupsGroupsHubTab implements GroupsHubTab {
        public final Fragment mo272a() {
            FB4AGroupGridFragment fB4AGroupGridFragment = new FB4AGroupGridFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("doNotSetTitleBar", true);
            fB4AGroupGridFragment.g(bundle);
            return fB4AGroupGridFragment;
        }

        public final boolean mo273b() {
            return false;
        }

        public final int mo274c() {
            return 2131242499;
        }

        public final TabType mo275d() {
            return TabType.GROUPS;
        }
    }

    /* compiled from: _null_notif_story */
    public enum TabType {
        GROUPS,
        DISCOVER,
        CREATE
    }

    @Inject
    public FB4AGroupsHubViewPagerAdapter(@Assisted Intent intent, @Assisted FragmentManager fragmentManager, Resources resources, FB4AGroupsHubExperiments fB4AGroupsHubExperiments) {
        super(fragmentManager);
        this.f10201a = resources;
        this.f10203c = fB4AGroupsHubExperiments;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.c(new GroupsGroupsHubTab());
        if (this.f10203c.b()) {
            builder.c(new DiscoverGroupsHubTab(intent));
        }
        if (this.f10203c.c()) {
            builder.c(new GroupsCreateHubTab(this.f10203c.d(), this.f10203c.f()));
        }
        this.f10202b = builder.b();
    }

    public final int m10546b() {
        return this.f10202b.size();
    }

    public final Fragment m10545a(int i) {
        return ((GroupsHubTab) this.f10202b.get(i)).mo272a();
    }

    public final CharSequence J_(int i) {
        return this.f10201a.getString(((GroupsHubTab) this.f10202b.get(i)).mo274c());
    }

    public final int m10544a(TabType tabType) {
        for (int i = 0; i < this.f10202b.size(); i++) {
            if (((GroupsHubTab) this.f10202b.get(i)).mo275d().equals(tabType)) {
                return i;
            }
        }
        return 0;
    }
}
