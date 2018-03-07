package com.facebook.contacts.picker;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.contacts.divebar.DivebarAvailabilityDialogFragment;
import com.facebook.orca.contacts.divebar.DivebarPickerView.5;
import com.facebook.orca.contacts.divebar.DivebarViewListener;

/* compiled from: post_insights_dialog_close */
public class DivebarSearchableContactPickerView extends SearchableContactPickerView {
    private static final Class<?> f6470i = DivebarSearchableContactPickerView.class;
    public ContactPickerSearchBarView f6471a = ((ContactPickerSearchBarView) getView(2131564796));
    public boolean f6472j;
    public OnFocusChangeListener f6473k;
    public 5 f6474l;

    /* compiled from: post_insights_dialog_close */
    public class C06631 implements OnClickListener {
        final /* synthetic */ DivebarSearchableContactPickerView f6458a;

        public C06631(DivebarSearchableContactPickerView divebarSearchableContactPickerView) {
            this.f6458a = divebarSearchableContactPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1289867924);
            5 5 = this.f6458a.f6474l;
            if (5.a.i != null) {
                DivebarViewListener divebarViewListener = 5.a.i;
                if (((DivebarAvailabilityDialogFragment) divebarViewListener.e.kO_().a("chat_availability_dialog")) == null) {
                    DivebarAvailabilityDialogFragment divebarAvailabilityDialogFragment = new DivebarAvailabilityDialogFragment();
                    divebarAvailabilityDialogFragment.g(new Bundle());
                    divebarAvailabilityDialogFragment.a(divebarViewListener.e.kO_(), "chat_availability_dialog");
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2123334343, a);
        }
    }

    /* compiled from: post_insights_dialog_close */
    public class C06642 {
        public final /* synthetic */ DivebarSearchableContactPickerView f6459a;

        public C06642(DivebarSearchableContactPickerView divebarSearchableContactPickerView) {
            this.f6459a = divebarSearchableContactPickerView;
        }
    }

    /* compiled from: post_insights_dialog_close */
    public class C06653 implements OnClickListener {
        final /* synthetic */ DivebarSearchableContactPickerView f6460a;

        public C06653(DivebarSearchableContactPickerView divebarSearchableContactPickerView) {
            this.f6460a = divebarSearchableContactPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -264925453);
            ContactPickerSearchBarView contactPickerSearchBarView = this.f6460a.f6471a;
            contactPickerSearchBarView.f6372c.requestFocus();
            contactPickerSearchBarView.f6372c.setSelection(contactPickerSearchBarView.f6372c.getText().length());
            contactPickerSearchBarView.f6374e.showSoftInput(contactPickerSearchBarView.f6372c, 1);
            Logger.a(2, EntryType.UI_INPUT_END, 1980477897, a);
        }
    }

    public DivebarSearchableContactPickerView(Context context, BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter, int i) {
        super(context, baseSearchableContactPickerListAdapter, i);
        this.f6471a.mo260a(new C06631(this));
        this.f6471a.f6370a = new C06642(this);
        ContactPickerSearchBarView contactPickerSearchBarView = this.f6471a;
        contactPickerSearchBarView.f6373d.setOnClickListener(new C06653(this));
    }

    public void setSearchHint(String str) {
        this.f6471a.f6372c.setHint(str);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f6472j && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.f6471a.mo255f()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (this.f6472j && getSearchBoxText().length() == 0 && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f6471a.mo252c();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final void mo262a(View view, boolean z) {
        super.mo262a(view, z);
        if (this.f6473k != null) {
            this.f6473k.onFocusChange(view, z);
        }
    }

    public void setSearchBoxText(String str) {
        this.f6471a.setSearchText(str);
    }

    public String getSearchBoxText() {
        return this.f6471a.getSearchText();
    }

    public void mo261a() {
        setSearchBoxText("");
        this.f6471a.mo252c();
        this.f6467g.f6442a.setSelection(0);
    }

    public void m6833a(String str) {
        this.f6471a.setSearchText(str);
    }

    protected ContactPickerSearchBarView getSearchBar() {
        return this.f6471a;
    }

    protected final boolean mo263b() {
        return this.f6472j;
    }
}
