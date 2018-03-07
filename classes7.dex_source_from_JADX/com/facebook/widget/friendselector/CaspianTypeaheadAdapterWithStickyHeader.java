package com.facebook.widget.friendselector;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import javax.inject.Inject;

/* compiled from: debugoverlay/ */
public class CaspianTypeaheadAdapterWithStickyHeader extends TypeaheadAdapter implements StickyHeaderAdapter {
    private int f16035e;
    private int f16036f;
    public boolean f16037g;
    private boolean f16038h;
    public boolean f16039i;
    private CaspianFriendSelectorViewFactory f16040j;

    public static CaspianTypeaheadAdapterWithStickyHeader m20030b(InjectorLike injectorLike) {
        return new CaspianTypeaheadAdapterWithStickyHeader(InputMethodManagerMethodAutoProvider.b(injectorLike), (TypeaheadMatcherFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public CaspianTypeaheadAdapterWithStickyHeader(InputMethodManager inputMethodManager, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider, Context context) {
        super(inputMethodManager, typeaheadMatcherFilterProvider);
        this.f16036f = context.getResources().getColor(17170445);
    }

    public final void m20036a(BaseTokenMatcher baseTokenMatcher, ViewFactory viewFactory) {
        super.a(baseTokenMatcher, viewFactory);
        this.f16040j = (CaspianFriendSelectorViewFactory) viewFactory;
    }

    public final View m20035a(int i, View view, ViewGroup viewGroup) {
        View a = super.a(i, view, viewGroup);
        if (this.f16037g) {
            a.setVisibility(8);
        } else if (this.f16039i || (m20033h() && i == m20032g())) {
            a.setVisibility(0);
        } else {
            a.setVisibility(8);
        }
        if (this.c != null && this.c.get(i) != null && (this.c.get(i) instanceof ImmutableSectionedListSection) && ((ImmutableSectionedListSection) this.c.get(i)).c) {
            a.setVisibility(0);
        }
        return a;
    }

    public final View m20034a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a = super.a(i, i2, z, view, viewGroup);
        CaspianFriendSelectorViewFactory.m20014a(a, m20031d(i, i2));
        return a;
    }

    public final View m20037b(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        if (this.f16037g || this.f16038h) {
            return null;
        }
        int[] d = d(i);
        int i3 = d[0];
        if (m20033h() && i3 == m20032g()) {
            return null;
        }
        int i4 = d[1];
        if (i4 != -1) {
            i2 = i4;
        }
        View a = this.f16040j.m20015a(view, viewGroup);
        SimpleUserToken simpleUserToken = (SimpleUserToken) a(i3, i2);
        if (!(simpleUserToken == null || StringUtil.a(simpleUserToken.b()))) {
            ((TextView) a.findViewById(2131562284)).setText(new String(Character.toChars(simpleUserToken.b().codePointAt(0))));
        }
        if (this.f16035e == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f16035e = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return 5;
    }

    public final int m20040e(int i) {
        return this.f16035e;
    }

    public final int m20039d() {
        return this.f16036f;
    }

    public final boolean m20041f(int i) {
        int[] d = d(i);
        return m20031d(d[0], d[1]);
    }

    public final void m20038b(boolean z) {
        this.f16038h = z;
    }

    private boolean m20031d(int i, int i2) {
        if (this.f16037g || this.f16038h || i == m20032g() || i2 == -1) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int i3;
        SimpleUserToken simpleUserToken = (SimpleUserToken) a(i, i2 - 1);
        if (simpleUserToken == null || !StringUtil.a(simpleUserToken.b())) {
            boolean z = false;
        } else {
            int codePointAt = simpleUserToken.b().codePointAt(0);
        }
        simpleUserToken = (SimpleUserToken) a(i, i2);
        if (simpleUserToken == null || !StringUtil.a(simpleUserToken.b())) {
            i3 = 0;
        } else {
            i3 = simpleUserToken.b().codePointAt(0);
        }
        if (codePointAt != i3) {
            return true;
        }
        return false;
    }

    private int m20032g() {
        return m20033h() ? 0 : -1;
    }

    private boolean m20033h() {
        return this.c.size() > 1;
    }
}
