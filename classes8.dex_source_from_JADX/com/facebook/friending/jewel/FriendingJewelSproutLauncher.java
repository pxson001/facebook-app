package com.facebook.friending.jewel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.UnifiedPublisherSproutFragment;
import com.facebook.feed.util.composer.sprout.UnifiedPublisherSproutFragment.LauncherSpec;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: finished_downloading_raw_time */
public class FriendingJewelSproutLauncher {
    private static final ImmutableList<FriendingFab> f13221a = ImmutableList.of(FriendingFab.CONTACTS, FriendingFab.SUGGESTIONS, FriendingFab.SEE_ALL_FRIENDS, FriendingFab.SEARCH);
    public final FbUriIntentHandler f13222b;
    public final Context f13223c;
    private final FragmentManager f13224d;
    public final Lazy<User> f13225e;

    /* compiled from: finished_downloading_raw_time */
    public class C13852 implements Runnable {
        final /* synthetic */ FriendingJewelSproutLauncher f13220a;

        public C13852(FriendingJewelSproutLauncher friendingJewelSproutLauncher) {
            this.f13220a = friendingJewelSproutLauncher;
        }

        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("profile_name", ((User) this.f13220a.f13225e.get()).e.i());
            this.f13220a.f13222b.a(this.f13220a.f13223c, StringFormatUtil.a(FBLinks.bf, new Object[]{((User) this.f13220a.f13225e.get()).a, FriendListType.ALL_FRIENDS.name(), FriendListSource.FRIENDS_TAB_SPROUT_LAUNCHER.name()}), bundle);
        }
    }

    /* compiled from: finished_downloading_raw_time */
    public enum FriendingFab {
        CONTACTS(2131361916, 2130839718, 2131233239, "friends_tab_contacts") {
            final Runnable getSproutLauncher(FriendingJewelSproutLauncher friendingJewelSproutLauncher) {
                return FriendingJewelSproutLauncher.m14878a(friendingJewelSproutLauncher, name());
            }
        },
        SEARCH(2131361918, 2130839976, 2131233237, "friends_tab_search") {
            final Runnable getSproutLauncher(FriendingJewelSproutLauncher friendingJewelSproutLauncher) {
                return FriendingJewelSproutLauncher.m14878a(friendingJewelSproutLauncher, name());
            }
        },
        SEE_ALL_FRIENDS(2131361919, 2130839886, 2131233238, "friends_tab_see_all_friends") {
            final Runnable getSproutLauncher(FriendingJewelSproutLauncher friendingJewelSproutLauncher) {
                return new C13852(friendingJewelSproutLauncher);
            }
        },
        SUGGESTIONS(2131363705, 2130839914, 2131233236, "friends_tab_suggestions") {
            final Runnable getSproutLauncher(FriendingJewelSproutLauncher friendingJewelSproutLauncher) {
                return FriendingJewelSproutLauncher.m14878a(friendingJewelSproutLauncher, name());
            }
        };
        
        public final String analyticsName;
        @ColorRes
        public final int colorRes;
        @DrawableRes
        public final int drawableRes;
        @StringRes
        public final int labelRes;

        abstract Runnable getSproutLauncher(FriendingJewelSproutLauncher friendingJewelSproutLauncher);

        private FriendingFab(int i, int i2, @ColorRes int i3, @DrawableRes String str) {
            this.colorRes = i;
            this.drawableRes = i2;
            this.labelRes = i3;
            this.analyticsName = str;
        }
    }

    @Inject
    public FriendingJewelSproutLauncher(FbUriIntentHandler fbUriIntentHandler, Lazy<User> lazy, @Assisted Context context, @Assisted FragmentManager fragmentManager) {
        this.f13222b = fbUriIntentHandler;
        this.f13225e = lazy;
        this.f13223c = context;
        this.f13224d = fragmentManager;
    }

    public final void m14880a() {
        String uuid = SafeUUIDGenerator.a().toString();
        SproutSource sproutSource = SproutSource.FRIENDS_TAB;
        ImmutableList c = m14879c();
        UnifiedPublisherSproutFragment unifiedPublisherSproutFragment = new UnifiedPublisherSproutFragment();
        unifiedPublisherSproutFragment.ap = sproutSource;
        unifiedPublisherSproutFragment.aq = uuid;
        Preconditions.checkNotNull(c);
        Preconditions.checkArgument(c.size() > 0);
        unifiedPublisherSproutFragment.as = (LauncherSpec) c.get(0);
        unifiedPublisherSproutFragment.ar = c.subList(1, c.size()).reverse();
        unifiedPublisherSproutFragment.a(this.f13224d, null);
    }

    public static Runnable m14878a(FriendingJewelSproutLauncher friendingJewelSproutLauncher, final String str) {
        return new Runnable(friendingJewelSproutLauncher) {
            final /* synthetic */ FriendingJewelSproutLauncher f13219b;

            public void run() {
                this.f13219b.f13222b.a(this.f13219b.f13223c, StringFormatUtil.a(FBLinks.cd, new Object[]{FriendsCenterSource.FRIENDS_TAB_SPROUT_LAUNCHER.name(), str}));
            }
        };
    }

    private ImmutableList<LauncherSpec> m14879c() {
        Builder builder = ImmutableList.builder();
        int size = f13221a.size();
        for (int i = 0; i < size; i++) {
            builder.c(m14877a((FriendingFab) f13221a.get(i)));
        }
        return builder.b();
    }

    @VisibleForTesting
    private LauncherSpec m14877a(FriendingFab friendingFab) {
        return new LauncherSpec(this.f13223c.getResources().getColor(friendingFab.colorRes), friendingFab.drawableRes, this.f13223c.getString(friendingFab.labelRes), friendingFab.analyticsName, friendingFab.getSproutLauncher(this));
    }
}
