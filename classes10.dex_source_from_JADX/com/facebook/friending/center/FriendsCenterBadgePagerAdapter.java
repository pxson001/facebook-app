package com.facebook.friending.center;

import android.content.Context;
import com.facebook.fbui.pagerindicator.BadgePagerAdapter;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.inject.Assisted;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;

/* compiled from: altm */
public class FriendsCenterBadgePagerAdapter extends BadgePagerAdapter {
    private final Context f19928a;
    private final ImmutableList<FriendsCenterTabType> f19929b;
    public int f19930c;

    /* compiled from: altm */
    /* synthetic */ class C28021 {
        static final /* synthetic */ int[] f19927a = new int[FriendsCenterTabType.values().length];

        static {
            try {
                f19927a[FriendsCenterTabType.REQUESTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19927a[FriendsCenterTabType.SUGGESTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19927a[FriendsCenterTabType.SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19927a[FriendsCenterTabType.CONTACTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19927a[FriendsCenterTabType.INVITES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19927a[FriendsCenterTabType.FRIENDS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public FriendsCenterBadgePagerAdapter(@Assisted Context context, @Assisted ImmutableList<FriendsCenterTabType> immutableList) {
        this.f19928a = context;
        this.f19929b = immutableList;
    }

    public final CharSequence m20104a(int i) {
        switch (C28021.f19927a[((FriendsCenterTabType) this.f19929b.get(i)).ordinal()]) {
            case 1:
                return this.f19930c > 0 ? Integer.toString(this.f19930c) : null;
            default:
                return null;
        }
    }

    public final CharSequence m20105b(int i) {
        switch (C28021.f19927a[((FriendsCenterTabType) this.f19929b.get(i)).ordinal()]) {
            case 1:
                return this.f19928a.getResources().getQuantityString(2131689518, this.f19930c, new Object[]{Integer.valueOf(this.f19930c)});
            case 2:
                return this.f19928a.getResources().getString(2131239323);
            case 3:
                return this.f19928a.getResources().getString(2131239324);
            case 4:
                return this.f19928a.getResources().getString(2131239326);
            case 5:
                return this.f19928a.getResources().getString(2131239327);
            case 6:
                return this.f19928a.getResources().getString(2131239330);
            default:
                return null;
        }
    }

    public final void m20106c(int i) {
        if (this.f19930c != i) {
            this.f19930c = i;
            a();
        }
    }
}
