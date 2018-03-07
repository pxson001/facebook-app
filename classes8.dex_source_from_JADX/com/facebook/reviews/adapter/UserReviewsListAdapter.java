package com.facebook.reviews.adapter;

import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.resources.ui.FbTextView;
import com.facebook.reviews.adapter.UserReviewsListBaseSection.SectionChangedListener;
import com.facebook.reviews.binder.UserPlacesToReviewViewBinder;
import com.facebook.reviews.binder.UserReviewFeedRowViewBinder;
import com.facebook.reviews.binder.UserReviewsSeeMoreViewBinder;
import com.facebook.reviews.binder.UserReviewsSeeMoreViewBinder.C22891;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.ui.ReviewFeedRowView;
import com.facebook.reviews.ui.UserPlacesToReviewView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: UPLOAD_STARTED */
public class UserReviewsListAdapter extends SectionedListAdapter implements SectionChangedListener, StickyHeaderAdapter {
    private final Resources f21367c;
    private final UserPlacesToReviewViewBinder f21368d;
    private final UserReviewFeedRowViewBinder f21369e;
    private final UserReviewsSeeMoreViewBinder f21370f;
    public ArrayList<UserReviewsListBaseSection> f21371g = new ArrayList();
    private int f21372h = 0;

    @Inject
    public UserReviewsListAdapter(Resources resources, UserPlacesToReviewViewBinder userPlacesToReviewViewBinder, UserReviewFeedRowViewBinder userReviewFeedRowViewBinder, UserReviewsSeeMoreViewBinder userReviewsSeeMoreViewBinder) {
        this.f21367c = resources;
        this.f21368d = userPlacesToReviewViewBinder;
        this.f21369e = userReviewFeedRowViewBinder;
        this.f21370f = userReviewsSeeMoreViewBinder;
    }

    public final void m25003a(List<UserReviewsListBaseSection> list) {
        this.f21371g.addAll(list);
        AdapterDetour.a(this, -817823836);
    }

    public final void mo1169f() {
        AdapterDetour.a(this, -1045451951);
    }

    private UserReviewsListViewTypes m24997d(int i, int i2) {
        UserReviewsListBaseSection userReviewsListBaseSection = (UserReviewsListBaseSection) this.f21371g.get(i);
        if (userReviewsListBaseSection.mo1165j() && i2 == userReviewsListBaseSection.mo1166k()) {
            return userReviewsListBaseSection.mo1167l().mo1168a();
        }
        return userReviewsListBaseSection.mo1162a(i2);
    }

    public final View m25004b(int i, View view, ViewGroup viewGroup) {
        View a = m25001a(d(i)[0], view, viewGroup);
        a.setLayoutParams(new LayoutParams(-1, -2));
        a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.f21372h = a.getMeasuredHeight();
        return a;
    }

    public final int o_(int i) {
        return m24998g(d(i)[0]).ordinal();
    }

    private UserReviewsListViewTypes m24998g(int i) {
        return ((UserReviewsListBaseSection) this.f21371g.get(i)).mo1164i();
    }

    public final int m25011e(int i) {
        UserReviewsListViewTypes g = m24998g(d(i)[0]);
        switch (g) {
            case DEFAULT_HEADER:
                return this.f21372h;
            case NO_HEADER:
                return 0;
            default:
                throw new IllegalStateException("Trying to get height for unhandled section type: " + g);
        }
    }

    public final int m25010d() {
        return this.f21367c.getColor(2131361920);
    }

    public final boolean m25013f(int i) {
        if (i < 0 || i >= getCount()) {
            return false;
        }
        if (d(i)[1] != -1) {
            return false;
        }
        return true;
    }

    public int getViewTypeCount() {
        return UserReviewsListViewTypes.values().length;
    }

    protected final int m25007c() {
        return this.f21371g.size();
    }

    protected final View m25001a(int i, View view, ViewGroup viewGroup) {
        View a;
        UserReviewsListViewTypes g = m24998g(i);
        if (view == null) {
            a = m24996a(viewGroup, g);
        } else {
            a = view;
        }
        switch (g) {
            case DEFAULT_HEADER:
                ((FbTextView) a).setText(((UserReviewsListBaseSection) this.f21371g.get(i)).a());
                break;
            case NO_HEADER:
                break;
            default:
                throw new IllegalStateException("Unexpected header view type: " + g);
        }
        return a;
    }

    protected final int m24999a(int i) {
        return m24998g(i).ordinal();
    }

    protected final Object m25005b(int i) {
        return this.f21371g.get(i);
    }

    protected final int m25008c(int i) {
        UserReviewsListBaseSection userReviewsListBaseSection = (UserReviewsListBaseSection) this.f21371g.get(i);
        return (userReviewsListBaseSection.mo1165j() ? 1 : 0) + userReviewsListBaseSection.mo1166k();
    }

    protected final Object m25002a(int i, int i2) {
        UserReviewsListBaseSection userReviewsListBaseSection = (UserReviewsListBaseSection) this.f21371g.get(i);
        if (userReviewsListBaseSection.mo1165j() && i2 == userReviewsListBaseSection.mo1166k()) {
            return userReviewsListBaseSection.mo1167l();
        }
        return userReviewsListBaseSection.mo1163b(i2);
    }

    protected final View m25000a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a;
        UserReviewsListViewTypes d = m24997d(i, i2);
        if (view == null) {
            a = m24996a(viewGroup, d);
        } else {
            a = view;
        }
        Object a2 = m25002a(i, i2);
        switch (d) {
            case USER_REVIEW:
                this.f21369e.m25061a((ReviewFeedRowView) a, (EdgesModel) a2);
                break;
            case PLACES_TO_REVIEW:
                this.f21368d.m25050a((UserPlacesToReviewView) a, (PlaceToReviewModel) a2);
                break;
            case SEE_MORE:
                a.setOnClickListener(new C22891(this.f21370f, (UserReviewsListSeeMoreFooter) a2));
                break;
            case BLANK_FOOTER:
            case LOADING_MORE:
                break;
            case REVIEW_WITH_NO_ATTACHMENT:
                this.f21369e.m25060a((ReviewFeedRowView) a, (Pair) a2);
                break;
            default:
                throw new IllegalStateException("Unexpected child view type: " + d);
        }
        return a;
    }

    protected final boolean m25006b(int i, int i2) {
        return true;
    }

    protected final int m25009c(int i, int i2) {
        return m24997d(i, i2).ordinal();
    }

    private static View m24996a(ViewGroup viewGroup, UserReviewsListViewTypes userReviewsListViewTypes) {
        switch (userReviewsListViewTypes) {
            case DEFAULT_HEADER:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130907628, viewGroup, false);
            case NO_HEADER:
                return new View(viewGroup.getContext());
            case USER_REVIEW:
            case REVIEW_WITH_NO_ATTACHMENT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130906843, viewGroup, false);
            case PLACES_TO_REVIEW:
                return new UserPlacesToReviewView(viewGroup.getContext());
            case SEE_MORE:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130905106, viewGroup, false);
            case BLANK_FOOTER:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130906844, viewGroup, false);
            case LOADING_MORE:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130906853, viewGroup, false);
            default:
                throw new IllegalStateException("Unexpected view type: " + userReviewsListViewTypes);
        }
    }
}
