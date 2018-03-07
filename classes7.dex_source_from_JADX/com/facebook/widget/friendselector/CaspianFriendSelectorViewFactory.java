package com.facebook.widget.friendselector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment.FriendSelectorViewFactory;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.ClearButtonMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;

/* compiled from: dec3 */
public class CaspianFriendSelectorViewFactory extends DefaultViewFactory implements FriendSelectorViewFactory {
    public LayoutInflater f16033a;
    private boolean f16034b;

    public CaspianFriendSelectorViewFactory(boolean z, boolean z2) {
        super(z);
        this.f16034b = z2;
    }

    public final View mo1226a(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        this.f16033a = layoutInflater;
        return layoutInflater.inflate(2130904503, viewGroup, false);
    }

    public final TextView mo1227a(View view) {
        return (TextView) view.findViewById(2131562304);
    }

    public final View mo1228b(View view) {
        return view.findViewById(2131562302);
    }

    public final BetterListView mo1229c(View view) {
        return (BetterListView) view.findViewById(2131562303);
    }

    public final TokenizedAutoCompleteTextView mo1230d(View view) {
        TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView = (TokenizedAutoCompleteTextView) view.findViewById(2131562301);
        tokenizedAutoCompleteTextView.setClearButtonMode(ClearButtonMode.WHILE_EDITING);
        return tokenizedAutoCompleteTextView;
    }

    public final View mo1231e(View view) {
        return view.findViewById(2131562299);
    }

    public final View mo1232f(View view) {
        return view.findViewById(2131562300);
    }

    public final ViewStub mo1233g(View view) {
        return (ViewStub) view.findViewById(2131562305);
    }

    public final View m20025d(ViewGroup viewGroup) {
        return new CaspianFriendSelectorSectionHeader(viewGroup.getContext());
    }

    public final void m20019a(View view, SectionedListSection sectionedListSection) {
        ((CaspianFriendSelectorSectionHeader) view).m20005a(sectionedListSection.a());
    }

    public final View m20016a(ViewGroup viewGroup) {
        CaspianFriendSelectorItemRow caspianFriendSelectorItemRow = new CaspianFriendSelectorItemRow(viewGroup.getContext());
        if (!this.f16034b) {
            caspianFriendSelectorItemRow.m20003a();
        }
        return caspianFriendSelectorItemRow;
    }

    public final void m20020a(View view, BaseToken baseToken, boolean z) {
        ((CaspianFriendSelectorItemRow) view).m20004a(baseToken, z);
    }

    public final View m20022b(ViewGroup viewGroup) {
        CaspianFriendSelectorItemRow caspianFriendSelectorItemRow = new CaspianFriendSelectorItemRow(viewGroup.getContext());
        if (!this.f16034b) {
            caspianFriendSelectorItemRow.m20003a();
        }
        return caspianFriendSelectorItemRow;
    }

    public final void m20023b(View view, BaseToken baseToken, boolean z) {
        ((CaspianFriendSelectorItemRow) view).m20004a(baseToken, z);
    }

    public final View m20015a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f16033a.inflate(2130904498, viewGroup, false);
        }
        return view;
    }

    public static void m20014a(View view, boolean z) {
        if (view instanceof CaspianFriendSelectorItemRow) {
            ((CaspianFriendSelectorItemRow) view).setAsHeaderItem(z);
        }
    }
}
