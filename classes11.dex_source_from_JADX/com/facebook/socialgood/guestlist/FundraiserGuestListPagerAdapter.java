package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.base.fragment.FbFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* compiled from: PAGE_NUX */
public class FundraiserGuestListPagerAdapter extends FragmentPagerAdapter {
    private final Context f12677a;
    public final FbFragment[] f12678b;
    public List<FundraiserGuestListTab> f12679c;
    private ImmutableList<Integer> f12680d;
    public String f12681e;

    public FundraiserGuestListPagerAdapter(FragmentManager fragmentManager, Context context, List<FundraiserGuestListTab> list, String str) {
        super(fragmentManager);
        this.f12677a = context;
        this.f12679c = list;
        this.f12681e = str;
        List<FundraiserGuestListTab> list2 = this.f12679c;
        Builder builder = new Builder();
        for (FundraiserGuestListTab fundraiserGuestListTab : list2) {
            switch (fundraiserGuestListTab) {
                case INVITED:
                    builder.c(Integer.valueOf(2131242341));
                    break;
                case SHARED:
                    builder.c(Integer.valueOf(2131242340));
                    break;
                case DONATED:
                    builder.c(Integer.valueOf(2131242342));
                    break;
                case NOT_DONATED:
                    builder.c(Integer.valueOf(2131242343));
                    break;
                default:
                    break;
            }
        }
        this.f12680d = builder.b();
        this.f12678b = new FbFragment[this.f12679c.size()];
    }

    public final CharSequence J_(int i) {
        return this.f12677a.getResources().getString(((Integer) this.f12680d.get(i)).intValue());
    }

    public final Fragment m13163a(int i) {
        return this.f12678b[i];
    }

    public final int m13164b() {
        return this.f12678b.length;
    }

    public final ImmutableSet<String> m13165f() {
        Collection hashSet = new HashSet();
        for (FbFragment fbFragment : this.f12678b) {
            if (fbFragment != null && (fbFragment instanceof FundraiserMessageGuestsFragment)) {
                hashSet.addAll(ImmutableSet.copyOf(((FundraiserMessageGuestsFragment) fbFragment).f12692f));
            }
        }
        return ImmutableSet.copyOf(hashSet);
    }
}
