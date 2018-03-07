package com.facebook.gametime.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.gametime.ui.reaction.GametimeMatchupFragment;
import com.facebook.gametime.ui.reaction.GametimeReactionUtil.LoadType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import java.util.List;

/* compiled from: TD;>; */
public class GametimePagerAdapter extends FragmentPagerAdapter {
    private final String f25090a;
    private final List<TabInfo> f25091b;

    /* compiled from: TD;>; */
    public class TabInfo {
        public final LoadType f25087a;
        public final Surface f25088b;
        public final String f25089c;

        public TabInfo(LoadType loadType, Surface surface, String str) {
            this.f25087a = loadType;
            this.f25088b = surface;
            this.f25089c = str;
        }
    }

    public GametimePagerAdapter(String str, List<TabInfo> list, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f25090a = str;
        this.f25091b = list;
    }

    public final Fragment m27081a(int i) {
        LoadType loadType = ((TabInfo) this.f25091b.get(i)).f25087a;
        String str = this.f25090a;
        Surface surface = ((TabInfo) this.f25091b.get(i)).f25088b;
        Bundle bundle = new Bundle();
        GametimeMatchupFragment gametimeMatchupFragment = new GametimeMatchupFragment();
        bundle.putBoolean("ptr_enabled", true);
        bundle.putString("page_id", str);
        bundle.putSerializable("load_type", loadType);
        bundle.putSerializable("reaction_surface", surface);
        gametimeMatchupFragment.g(bundle);
        return gametimeMatchupFragment;
    }

    public final int m27082b() {
        return this.f25091b.size();
    }

    public final CharSequence J_(int i) {
        return ((TabInfo) this.f25091b.get(i)).f25089c;
    }

    public final int m27080a(Object obj) {
        return -2;
    }
}
