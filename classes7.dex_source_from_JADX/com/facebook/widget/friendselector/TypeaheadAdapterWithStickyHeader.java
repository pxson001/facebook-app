package com.facebook.widget.friendselector;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.userfilter.TypeaheadUserSearchFilterProvider;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.RowType;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import javax.inject.Inject;

/* compiled from: day_time_text */
public class TypeaheadAdapterWithStickyHeader extends TypeaheadAdapter implements StickyHeaderAdapter {
    private final int f16121e;
    private final CustomFilter f16122f;
    private int f16123g = 0;

    public static TypeaheadAdapterWithStickyHeader m20144b(InjectorLike injectorLike) {
        return new TypeaheadAdapterWithStickyHeader(InputMethodManagerMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), (TypeaheadMatcherFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class), (TypeaheadUserSearchFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadUserSearchFilterProvider.class));
    }

    @Inject
    public TypeaheadAdapterWithStickyHeader(InputMethodManager inputMethodManager, Context context, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider, TypeaheadUserSearchFilterProvider typeaheadUserSearchFilterProvider) {
        super(inputMethodManager, typeaheadMatcherFilterProvider);
        this.f16121e = context.getResources().getColor(2131362252);
        this.f16122f = typeaheadUserSearchFilterProvider.a(e());
    }

    public final View m20146b(int i, View view, ViewGroup viewGroup) {
        View a = a(d(i)[0], view, viewGroup);
        if (this.f16123g == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f16123g = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return RowType.HEADER.ordinal();
    }

    public final int m20148e(int i) {
        return this.f16123g;
    }

    public final int m20147d() {
        return this.f16121e;
    }

    public final boolean m20149f(int i) {
        if (d(i)[1] == -1) {
            return true;
        }
        return false;
    }

    public CustomFilter m20145a() {
        return this.f16122f;
    }
}
