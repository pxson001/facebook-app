package com.facebook.localcontent.menus.structured;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLInterfaces.AvailableMenusQuery.PageProductLists.Nodes;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.AvailableMenusQueryModel.PageProductListsModel.NodesModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: duration_in_viewport_before_intermediate_image */
public class StructuredMenuPagerAdapter extends FragmentPagerAdapter {
    private static final String f15133a = StructuredMenuPagerAdapter.class.getSimpleName();
    private final AbstractFbErrorReporter f15134b;
    private final int f15135c;
    public ArrayList<StructuredMenuListFragment> f15136d = new ArrayList();
    private final ImmutableList<? extends Nodes> f15137e;

    @Inject
    public StructuredMenuPagerAdapter(FbErrorReporter fbErrorReporter, @Assisted FragmentManager fragmentManager, @Assisted ImmutableList<? extends Nodes> immutableList, @Assisted Integer num) {
        super(fragmentManager);
        this.f15137e = immutableList;
        for (int i = 0; i < b(); i++) {
            this.f15136d.add(null);
        }
        this.f15134b = fbErrorReporter;
        this.f15135c = num.intValue();
    }

    public final CharSequence J_(int i) {
        if (((NodesModel) this.f15137e.get(i)).c() != null) {
            return ((NodesModel) this.f15137e.get(i)).c().toUpperCase(Locale.getDefault());
        }
        this.f15134b.b(f15133a, "Null tab title");
        return null;
    }

    public final int m17578b() {
        return this.f15137e.size();
    }

    public final Fragment m17577a(int i) {
        Fragment fragment = (StructuredMenuListFragment) this.f15136d.get(i);
        if (fragment != null) {
            return fragment;
        }
        String b = ((NodesModel) this.f15137e.get(i)).b();
        int i2 = this.f15135c;
        StructuredMenuListFragment structuredMenuListFragment = new StructuredMenuListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("local_content_menu_id", b);
        bundle.putInt("local_content_padding_top", i2);
        structuredMenuListFragment.g(bundle);
        fragment = structuredMenuListFragment;
        this.f15136d.set(i, fragment);
        return fragment;
    }
}
