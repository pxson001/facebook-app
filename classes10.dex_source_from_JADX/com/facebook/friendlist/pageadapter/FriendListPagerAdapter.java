package com.facebook.friendlist.pageadapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.fragment.AllFriendListFragment;
import com.facebook.friendlist.fragment.FriendListFragment;
import com.facebook.friendlist.fragment.MutualFriendListFragment;
import com.facebook.friendlist.fragment.RecentlyAddedFriendListFragment;
import com.facebook.friendlist.fragment.SuggestionsFriendListFragment;
import com.facebook.friendlist.fragment.WithNewPostsFriendListFragment;
import com.google.common.collect.ImmutableList;

/* compiled from: accountAuthenticatorResponse */
public class FriendListPagerAdapter extends FragmentPagerAdapter {
    private final Resources f20414a;
    private final String f20415b;
    private final String f20416c;
    private final String f20417d;
    public final ImmutableList<FriendListType> f20418e;

    /* compiled from: accountAuthenticatorResponse */
    /* synthetic */ class C29221 {
        static final /* synthetic */ int[] f20413a = new int[FriendListType.values().length];

        static {
            try {
                f20413a[FriendListType.ALL_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20413a[FriendListType.MUTUAL_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20413a[FriendListType.RECENTLY_ADDED_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20413a[FriendListType.SUGGESTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20413a[FriendListType.FRIENDS_WITH_NEW_POSTS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public FriendListPagerAdapter(FragmentManager fragmentManager, Resources resources, String str, String str2, String str3, ImmutableList<FriendListType> immutableList) {
        super(fragmentManager);
        this.f20414a = resources;
        this.f20415b = str;
        this.f20416c = str2;
        this.f20417d = str3;
        this.f20418e = immutableList;
    }

    private FriendListType m20679e(int i) {
        return (FriendListType) this.f20418e.get(i);
    }

    public final int m20681b() {
        return this.f20418e.size();
    }

    public final CharSequence J_(int i) {
        switch (C29221.f20413a[m20679e(i).ordinal()]) {
            case 2:
                return this.f20414a.getString(2131241966);
            case 3:
                return this.f20414a.getString(2131241967);
            case 4:
                return this.f20414a.getString(2131241968);
            case 5:
                return this.f20414a.getString(2131241969);
            default:
                return this.f20414a.getString(2131241965);
        }
    }

    public final Fragment m20680a(int i) {
        String str;
        String str2;
        String str3;
        switch (C29221.f20413a[m20679e(i).ordinal()]) {
            case 2:
                str = this.f20415b;
                str2 = this.f20416c;
                str3 = this.f20417d;
                MutualFriendListFragment mutualFriendListFragment = new MutualFriendListFragment();
                mutualFriendListFragment.g(FriendListFragment.m20589b(str, str2, str3));
                return mutualFriendListFragment;
            case 3:
                str = this.f20415b;
                str2 = this.f20416c;
                str3 = this.f20417d;
                RecentlyAddedFriendListFragment recentlyAddedFriendListFragment = new RecentlyAddedFriendListFragment();
                recentlyAddedFriendListFragment.g(FriendListFragment.m20589b(str, str2, str3));
                return recentlyAddedFriendListFragment;
            case 4:
                str = this.f20415b;
                str2 = this.f20416c;
                str3 = this.f20417d;
                SuggestionsFriendListFragment suggestionsFriendListFragment = new SuggestionsFriendListFragment();
                suggestionsFriendListFragment.g(FriendListFragment.m20589b(str, str2, str3));
                return suggestionsFriendListFragment;
            case 5:
                str = this.f20415b;
                str2 = this.f20416c;
                str3 = this.f20417d;
                WithNewPostsFriendListFragment withNewPostsFriendListFragment = new WithNewPostsFriendListFragment();
                withNewPostsFriendListFragment.g(FriendListFragment.m20589b(str, str2, str3));
                return withNewPostsFriendListFragment;
            default:
                str = this.f20415b;
                str2 = this.f20416c;
                str3 = this.f20417d;
                AllFriendListFragment allFriendListFragment = new AllFriendListFragment();
                allFriendListFragment.g(FriendListFragment.m20589b(str, str2, str3));
                return allFriendListFragment;
        }
    }
}
