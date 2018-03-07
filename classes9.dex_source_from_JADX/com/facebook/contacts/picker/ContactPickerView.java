package com.facebook.contacts.picker;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: postpay */
public class ContactPickerView extends CustomViewGroup {
    private static final Class<?> f6441b = ContactPickerView.class;
    public BetterListView f6442a = ((BetterListView) getView(2131564799));
    public OnRowClickedListener f6443c;
    public OnContactListScrollListener f6444d;
    private EmptyListViewItem f6445e = ((EmptyListViewItem) getView(2131564800));
    private BaseContactPickerListAdapter f6446f;

    /* compiled from: postpay */
    class C06581 implements OnScrollListener {
        final /* synthetic */ ContactPickerView f6438a;

        C06581(ContactPickerView contactPickerView) {
            this.f6438a = contactPickerView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            ContactPickerView contactPickerView = this.f6438a;
            if (contactPickerView.f6444d != null) {
                contactPickerView.f6444d.mo266a(i);
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: postpay */
    class C06592 implements OnItemClickListener {
        final /* synthetic */ ContactPickerView f6439a;

        C06592(ContactPickerView contactPickerView) {
            this.f6439a = contactPickerView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f6439a.m6805a(i);
        }
    }

    /* compiled from: postpay */
    public enum EmptyState {
        LOADING,
        NO_RESULTS
    }

    /* compiled from: postpay */
    public interface OnContactListScrollListener {
        void mo266a(int i);
    }

    /* compiled from: postpay */
    public interface OnRowClickedListener {
        void m6804a(ContactPickerRow contactPickerRow, int i);
    }

    public ContactPickerView(Context context, int i) {
        super(context);
        setContentView(i);
        this.f6442a.setDividerHeight(0);
        this.f6442a.setBroadcastInteractionChanges(true);
        this.f6442a.setOnScrollListener(new C06581(this));
        this.f6442a.setOnItemClickListener(new C06592(this));
    }

    public void setListOnDrawListener(OnDrawListener onDrawListener) {
        if (this.f6442a != null) {
            this.f6442a.setOnDrawListenerTo(onDrawListener);
        }
    }

    public int getListChildCount() {
        if (this.f6442a == null) {
            return 0;
        }
        return this.f6442a.getChildCount();
    }

    public void setAdapter(BaseContactPickerListAdapter baseContactPickerListAdapter) {
        this.f6446f = baseContactPickerListAdapter;
        this.f6442a.setAdapter(baseContactPickerListAdapter);
    }

    public BaseContactPickerListAdapter getAdapter() {
        return this.f6446f;
    }

    public final void m6809a(ImmutableList<ContactPickerRow> immutableList) {
        this.f6446f.m6708a(immutableList);
        if (immutableList.isEmpty()) {
            m6808a(EmptyState.NO_RESULTS);
        } else {
            m6810b();
        }
    }

    public final void m6807a() {
        m6808a(EmptyState.LOADING);
    }

    public final void m6810b() {
        this.f6445e.a(false);
        this.f6445e.setVisibility(8);
        this.f6445e.setMessage(2131230932);
    }

    public final void m6808a(EmptyState emptyState) {
        Preconditions.checkNotNull(emptyState);
        switch (emptyState) {
            case LOADING:
                this.f6445e.setMessage(2131230933);
                this.f6445e.a(true);
                break;
            case NO_RESULTS:
                this.f6445e.setMessage(2131230932);
                this.f6445e.a(false);
                break;
        }
        this.f6445e.setVisibility(0);
    }

    public void setFastScrollEnabled(boolean z) {
        this.f6442a.setFastScrollEnabled(z);
        this.f6442a.setFastScrollAlwaysVisible(z);
    }

    public void setStickyHeaderEnabled(boolean z) {
        this.f6442a.setStickyHeaderEnabled(z);
    }

    private void m6805a(int i) {
        ContactPickerRow contactPickerRow = (ContactPickerRow) this.f6446f.getItem(i);
        if (this.f6443c != null) {
            this.f6443c.m6804a(contactPickerRow, i);
        }
    }
}
