package com.facebook.events.invite;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.RowType;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: chat_head_collapsed */
public class InviteePickerAdapter extends TypeaheadAdapter implements StickyHeaderAdapter {
    private int f17732e = 0;
    private final int f17733f;
    private ImmutableMap<String, EventInviteeToken> f17734g = null;
    private Context f17735h;

    private static InviteePickerAdapter m18062c(InjectorLike injectorLike) {
        return new InviteePickerAdapter(InputMethodManagerMethodAutoProvider.b(injectorLike), (TypeaheadMatcherFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public InviteePickerAdapter(InputMethodManager inputMethodManager, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider, Context context) {
        super(inputMethodManager, typeaheadMatcherFilterProvider);
        this.f17735h = context;
        this.f17733f = context.getResources().getColor(2131363350);
    }

    public final View m18063b(int i, View view, ViewGroup viewGroup) {
        View a = a(d(i)[0], view, viewGroup);
        if (this.f17732e == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f17732e = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return RowType.HEADER.ordinal();
    }

    public final int m18065e(int i) {
        return this.f17732e;
    }

    public final int m18064d() {
        return this.f17733f;
    }

    public final boolean m18066f(int i) {
        if (d(i)[1] == -1) {
            return true;
        }
        return false;
    }
}
