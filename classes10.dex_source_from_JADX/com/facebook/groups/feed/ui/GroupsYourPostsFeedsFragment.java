package com.facebook.groups.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;

/* compiled from: ThreadViewMessagesAdapterUpdate_failed_patch */
public class GroupsYourPostsFeedsFragment extends GroupsFeedSearchQueryFragment {

    /* compiled from: ThreadViewMessagesAdapterUpdate_failed_patch */
    enum YourPostsFeedTab {
        AVAILABLE(2131238018, Name.q, GroupsFeedTypes.YourAvailableForSalePosts),
        SOLD(2131238019, Name.r, GroupsFeedTypes.YourSoldForSalePosts),
        EXPIRED(2131238023, Name.s, GroupsFeedTypes.YourExpiredForSalePosts);
        
        private final Name mFeedTypeName;
        private final GroupsFeedTypes mGroupsFeedType;
        private final int mTitleId;

        private YourPostsFeedTab(int i, Name name, GroupsFeedTypes groupsFeedTypes) {
            this.mTitleId = i;
            this.mFeedTypeName = name;
            this.mGroupsFeedType = groupsFeedTypes;
        }

        public final int getTitleId() {
            return this.mTitleId;
        }

        public final Name getFeedTypeName() {
            return this.mFeedTypeName;
        }

        public final GroupsFeedTypes getGroupsFeedType() {
            return this.mGroupsFeedType;
        }
    }

    /* compiled from: ThreadViewMessagesAdapterUpdate_failed_patch */
    public class YourPostsFragmentPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ GroupsYourPostsFeedsFragment f22391a;
        public Fragment f22392b;

        public YourPostsFragmentPagerAdapter(GroupsYourPostsFeedsFragment groupsYourPostsFeedsFragment, FragmentManager fragmentManager) {
            this.f22391a = groupsYourPostsFeedsFragment;
            super(fragmentManager);
        }

        public final void m23452b(ViewGroup viewGroup, int i, Object obj) {
            if (this.f22392b != obj) {
                this.f22392b = (Fragment) obj;
            }
            super.b(viewGroup, i, obj);
        }

        public final Fragment m23450a(int i) {
            YourPostsFeedTab yourPostsFeedTab = YourPostsFeedTab.values()[i];
            FeedType feedType = new FeedType(new GroupsFeedTypeValueParams(this.f22391a.av(), yourPostsFeedTab.getGroupsFeedType()), yourPostsFeedTab.getFeedTypeName());
            Bundle bundle = this.f22391a.s;
            GroupsYourPostsFragment groupsYourPostsFragment = new GroupsYourPostsFragment();
            Bundle bundle2 = new Bundle(bundle);
            bundle2.putParcelable("feed_type_arguments_key", feedType);
            groupsYourPostsFragment.g(bundle2);
            return groupsYourPostsFragment;
        }

        public final int m23451b() {
            return YourPostsFeedTab.values().length;
        }

        public final CharSequence J_(int i) {
            return this.f22391a.getContext().getString(YourPostsFeedTab.values()[i].getTitleId());
        }
    }

    public final void m23455a(View view, Bundle bundle) {
        super.a(view, bundle);
        ViewPager viewPager = (ViewPager) e(2131562841);
        viewPager.setAdapter(new YourPostsFragmentPagerAdapter(this, kO_()));
        ((TabbedViewPagerIndicator) e(2131562840)).setViewPager(viewPager);
    }

    public final void m23454a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        GroupsYourPostsFragment groupsYourPostsFragment = (GroupsYourPostsFragment) ((YourPostsFragmentPagerAdapter) ((ViewPager) e(2131562841)).getAdapter()).f22392b;
        if (groupsYourPostsFragment != null) {
            groupsYourPostsFragment.f22401f.b(i, i2, intent);
        }
    }

    public final void m23456e() {
    }
}
