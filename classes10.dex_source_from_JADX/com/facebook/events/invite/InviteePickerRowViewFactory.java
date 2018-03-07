package com.facebook.events.invite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.InviteePickerHeaderRow;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;

/* compiled from: chat_bar_online_status_change */
public class InviteePickerRowViewFactory implements ViewFactory {
    public static InviteePickerRowViewFactory m18068a(InjectorLike injectorLike) {
        return new InviteePickerRowViewFactory();
    }

    public final View m18069a(ViewGroup viewGroup) {
        return new InviteePickerRow(viewGroup.getContext());
    }

    public final View m18074b(ViewGroup viewGroup) {
        return new InviteePickerRow(viewGroup.getContext());
    }

    public final View m18078e(ViewGroup viewGroup) {
        return new View(viewGroup.getContext());
    }

    public final void m18073a(View view, BaseToken baseToken, boolean z) {
        ((InviteePickerRow) view).m18067a(baseToken, z);
    }

    public final void m18075b(View view, BaseToken baseToken, boolean z) {
        ((InviteePickerRow) view).m18067a(baseToken, z);
    }

    public final View m18076c(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130907582, viewGroup, false);
    }

    public final View m18077d(ViewGroup viewGroup) {
        return new InviteePickerHeaderRow(viewGroup.getContext());
    }

    public final void m18072a(View view, SectionedListSection sectionedListSection) {
        InviteePickerHeaderRow inviteePickerHeaderRow = (InviteePickerHeaderRow) view;
        inviteePickerHeaderRow.a.setText(sectionedListSection.a());
        inviteePickerHeaderRow.setVisibility(sectionedListSection.a() != null ? 0 : 8);
    }

    public final void m18071a(View view, OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
    }

    public final TriState m18070a() {
        return TriState.UNSET;
    }
}
