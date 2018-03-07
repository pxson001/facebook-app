package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.fbui.widget.header.SectionHeaderView;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder.Listener;
import com.facebook.friendsnearby.model.FriendsNearbyNewRowSection;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.ui.FriendsNearbyRowView.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Webview control */
public class FriendsNearbyListAdapter extends SectionedListAdapter implements StickyHeaderAdapter {
    private final Context f20933c;
    private final QeAccessor f20934d;
    public FriendsNearbyNewDataHolder f20935e;
    private OnClickListener f20936f;
    private FriendsNearbyFragment f20937g;
    private int f20938h = -1;
    private boolean f20939i = true;

    /* compiled from: Webview control */
    public class C29711 implements Listener {
        final /* synthetic */ FriendsNearbyListAdapter f20930a;

        public C29711(FriendsNearbyListAdapter friendsNearbyListAdapter) {
            this.f20930a = friendsNearbyListAdapter;
        }

        public final void mo924a() {
            AdapterDetour.a(this.f20930a, -1074766279);
        }

        public final void mo926b() {
            AdapterDetour.a(this.f20930a, -1624445861);
        }

        public final void mo925a(String str) {
            AdapterDetour.a(this.f20930a, 1498175742);
        }
    }

    /* compiled from: Webview control */
    class FakeHeader extends View {
        final /* synthetic */ FriendsNearbyListAdapter f20932a;

        public FakeHeader(FriendsNearbyListAdapter friendsNearbyListAdapter, Context context) {
            this.f20932a = friendsNearbyListAdapter;
            super(context);
        }
    }

    /* compiled from: Webview control */
    enum ViewTypes {
        HEADER,
        FAKE_HEADER,
        CHILD,
        CHILD_MORE
    }

    public final /* synthetic */ Object m21909a(int i, int i2) {
        return m21903d(i, i2);
    }

    public final /* synthetic */ Object m21911b(int i) {
        return m21904g(i);
    }

    @Inject
    public FriendsNearbyListAdapter(@Assisted OnClickListener onClickListener, @Assisted FriendsNearbyFragment friendsNearbyFragment, Context context, QeAccessor qeAccessor) {
        this.f20936f = onClickListener;
        this.f20937g = friendsNearbyFragment;
        this.f20933c = context;
        this.f20934d = qeAccessor;
    }

    private FriendsNearbySection m21904g(int i) {
        return (FriendsNearbySection) this.f20935e.m20885b().get(i);
    }

    public final int m21914c() {
        return this.f20935e.m20885b().size();
    }

    public final View m21908a(int i, @Nullable View view, ViewGroup viewGroup) {
        View a;
        ViewTypes viewTypes = ViewTypes.values()[m21906a(i)];
        if (view == null) {
            a = m21900a(viewTypes);
        } else {
            a = view;
        }
        if (viewTypes == ViewTypes.HEADER) {
            if (this.f20938h < 0) {
                this.f20938h = m21899a(a);
            }
            ((SectionHeaderView) a).setTitleText(m21904g(i).a());
        }
        return a;
    }

    public final int m21906a(int i) {
        if (this.f20935e.m20895i()) {
            return ViewTypes.FAKE_HEADER.ordinal();
        }
        return ViewTypes.HEADER.ordinal();
    }

    private FriendsNearbyRow m21903d(int i, int i2) {
        return (FriendsNearbyRow) ((FriendsNearbySection) this.f20935e.m20885b().get(i)).b().get(i2);
    }

    public final int m21915c(int i) {
        FriendsNearbySection g = m21904g(i);
        if (m21901a(g)) {
            return g.b().size() + 1;
        }
        return g.b().size();
    }

    private View m21900a(ViewTypes viewTypes) {
        switch (viewTypes) {
            case HEADER:
                SectionHeaderView sectionHeaderView = new SectionHeaderView(this.f20933c);
                sectionHeaderView.setBackgroundResource(2131361993);
                sectionHeaderView.setTopDivider(2131363924);
                return sectionHeaderView;
            case FAKE_HEADER:
                return new FakeHeader(this, this.f20933c);
            default:
                throw new IllegalArgumentException("Invalid header view type: " + viewTypes);
        }
    }

    private View m21902b(ViewTypes viewTypes) {
        switch (viewTypes) {
            case CHILD:
                return new FriendsNearbyRowView(this.f20933c);
            case CHILD_MORE:
                return new FriendsNearbyMoreRowView(this.f20933c);
            default:
                throw new IllegalArgumentException(String.format("Invalid child view type: %s", new Object[]{viewTypes.toString()}));
        }
    }

    public final View m21907a(int i, int i2, boolean z, @Nullable View view, ViewGroup viewGroup) {
        View b;
        ViewTypes viewTypes = ViewTypes.values()[m21916c(i, i2)];
        if (view == null) {
            b = m21902b(viewTypes);
        } else {
            b = view;
        }
        if (viewTypes == ViewTypes.CHILD) {
            ((FriendsNearbyRowView) b).m21986a(m21903d(i, i2), this.f20936f);
        } else if (viewTypes == ViewTypes.CHILD_MORE) {
            Preconditions.checkState(!this.f20935e.m20895i());
            FriendsNearbySection g = m21904g(i);
            FriendsNearbyMoreRowView friendsNearbyMoreRowView = (FriendsNearbyMoreRowView) b;
            FriendsNearbyFragment friendsNearbyFragment = this.f20937g;
            friendsNearbyMoreRowView.f20990c = g;
            friendsNearbyMoreRowView.f20991d = friendsNearbyFragment;
        }
        return b;
    }

    public final int m21916c(int i, int i2) {
        FriendsNearbySection g = m21904g(i);
        if (m21901a(g) && i2 == g.b().size()) {
            return ViewTypes.CHILD_MORE.ordinal();
        }
        return ViewTypes.CHILD.ordinal();
    }

    private boolean m21901a(FriendsNearbySection friendsNearbySection) {
        if (!(friendsNearbySection instanceof FriendsNearbyNewRowSection) || this.f20934d.a(ExperimentsForFriendsNearbyModule.f20447a, false)) {
            return friendsNearbySection.c();
        }
        if (friendsNearbySection.f20520b != null) {
            return true;
        }
        return false;
    }

    public final boolean m21913b(int i, int i2) {
        return true;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    protected final boolean m21912b() {
        if (this.f20935e == null || this.f20935e.m20885b() == null) {
            return true;
        }
        ImmutableList b = this.f20935e.m20885b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (!((FriendsNearbySection) b.get(i)).e().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final View m21910b(int i, @Nullable View view, ViewGroup viewGroup) {
        Object obj;
        if (this.f20935e.m20895i() || isEmpty()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return null;
        }
        if (!this.f20939i || i != 0) {
            return m21908a(d(m21905h(i))[0], view, viewGroup);
        }
        SectionHeaderView sectionHeaderView = (SectionHeaderView) m21908a(0, view, viewGroup);
        FriendsNearbyNewDataHolder friendsNearbyNewDataHolder = this.f20935e;
        sectionHeaderView.setTitleText(friendsNearbyNewDataHolder.f20488f.m21011c(friendsNearbyNewDataHolder.f20494l));
        return sectionHeaderView;
    }

    public final int o_(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    public final int m21918e(int i) {
        if (this.f20938h < 0) {
            this.f20938h = m21899a(m21900a(ViewTypes.HEADER));
        }
        return this.f20938h;
    }

    public final int m21917d() {
        return this.f20933c.getResources().getColor(2131361993);
    }

    public final boolean m21919f(int i) {
        int h = m21905h(i);
        if (h < 0 || h >= getCount()) {
            return false;
        }
        if (d(h)[1] != -1) {
            return false;
        }
        return true;
    }

    private int m21905h(int i) {
        return i - (this.f20939i ? 1 : 0);
    }

    private static int m21899a(View view) {
        view.setLayoutParams(new LayoutParams(-1, -2));
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }
}
