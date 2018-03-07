package com.facebook.friendlist.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.logging.FriendListAnalyticsLogger;
import com.facebook.friendlist.pageadapter.FriendListPagerAdapter;
import com.facebook.friendlist.pageadapter.FriendListTypeHelper;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.RelationshipType;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: active_now */
public class FriendPageFragment extends FbFragment implements AnalyticsFragmentWithExtraData {
    @Inject
    @LoggedInUserId
    public String f20334a;
    @Inject
    public FriendListAnalyticsLogger f20335b;
    public String f20336c;
    public boolean f20337d;
    private FriendListType f20338e;
    private GraphQLFriendshipStatus f20339f;
    private GraphQLSubscribeStatus f20340g;

    /* compiled from: active_now */
    class C29071 extends SimpleOnPageChangeListener {
        final /* synthetic */ FriendPageFragment f20333a;

        C29071(FriendPageFragment friendPageFragment) {
            this.f20333a = friendPageFragment;
        }

        public final void e_(int i) {
            this.f20333a.f20335b.m20677a(((FriendListType) FriendListTypeHelper.m20682a(this.f20333a.f20337d).get(i)).name(), this.f20333a.f20336c);
        }
    }

    public static void m20607a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FriendPageFragment friendPageFragment = (FriendPageFragment) obj;
        String b = String_LoggedInUserIdMethodAutoProvider.b(injectorLike);
        FriendListAnalyticsLogger a = FriendListAnalyticsLogger.m20673a(injectorLike);
        friendPageFragment.f20334a = b;
        friendPageFragment.f20335b = a;
    }

    public static FriendPageFragment m20606a(String str, String str2, String str3, String str4, String str5, FriendListType friendListType, String str6) {
        FriendPageFragment friendPageFragment = new FriendPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.katana.profile.id", str);
        bundle.putString("profile_name", str2);
        bundle.putString("first_name", str3);
        bundle.putString("friendship_status", str4);
        bundle.putString("subscribe_status", str5);
        bundle.putString("target_tab_name", friendListType.name());
        bundle.putString("source_ref", str6);
        friendPageFragment.g(bundle);
        return friendPageFragment;
    }

    public final void m20612c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendPageFragment.class;
        m20607a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f20336c = bundle2.getString("com.facebook.katana.profile.id");
        this.f20337d = this.f20336c.equals(this.f20334a);
        this.f20338e = FriendListType.valueOf(bundle2.getString("target_tab_name"));
        if (bundle2.getString("friendship_status") != null) {
            this.f20339f = GraphQLFriendshipStatus.fromString(bundle2.getString("friendship_status"));
        }
        if (bundle2.getString("subscribe_status") != null) {
            this.f20340g = GraphQLSubscribeStatus.fromString(bundle2.getString("subscribe_status"));
        }
        this.f20335b.m20678a(this.f20338e.name(), bundle2.getString("source_ref"), this.f20336c);
    }

    public final View m20609a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1121071910);
        View inflate = layoutInflater.inflate(2130904512, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1115841, a);
        return inflate;
    }

    public final void m20608G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1723552754);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        String string = this.s.getString("profile_name");
        if (hasTitleBar != null) {
            hasTitleBar.a_(string);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1609665756, a);
    }

    public final void m20610a(View view, Bundle bundle) {
        Object obj;
        int i;
        super.a(view, bundle);
        Bundle bundle2 = this.s;
        String string = bundle2.getString("profile_name");
        String string2 = bundle2.getString("first_name");
        ViewPager viewPager = (ViewPager) e(2131562323);
        viewPager.setOffscreenPageLimit(2);
        FriendListPagerAdapter friendListPagerAdapter = new FriendListPagerAdapter(s(), jW_(), this.f20336c, string, string2, FriendListTypeHelper.m20682a(this.f20337d));
        if (friendListPagerAdapter.f20418e.indexOf(this.f20338e) != -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            int indexOf = friendListPagerAdapter.f20418e.indexOf(this.f20338e);
            Preconditions.checkArgument(indexOf >= 0);
            i = indexOf;
        } else {
            i = 0;
        }
        viewPager.setAdapter(friendListPagerAdapter);
        viewPager.setCurrentItem(i);
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) e(2131562322);
        tabbedViewPagerIndicator.setViewPager(viewPager);
        tabbedViewPagerIndicator.e_(i);
        tabbedViewPagerIndicator.setVisibility(0);
        if (viewPager.getAdapter().b() == 1) {
            tabbedViewPagerIndicator.setUnderlineHeight(0);
        }
        tabbedViewPagerIndicator.l = new C29071(this);
    }

    public final String am_() {
        return "profile_friends_page";
    }

    public final Map<String, Object> m20611c() {
        int value = RelationshipType.getRelationshipType(this.f20337d, this.f20339f, this.f20340g).getValue();
        Map<String, Object> c = Maps.c();
        c.put("relationship_type", Integer.valueOf(value));
        c.put("profile_id", this.f20336c);
        return c;
    }
}
