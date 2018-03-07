package com.facebook.contacts.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.picker.ContactPickerView.EmptyState;
import com.facebook.contacts.picker.ContactPickerView.OnContactListScrollListener;
import com.facebook.orca.contacts.divebar.DivebarPickerView.2;
import com.facebook.orca.contacts.divebar.DivebarPickerView.3;
import com.facebook.orca.contacts.divebar.DivebarPickerView.4;
import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.google.common.collect.ImmutableList;

/* compiled from: post_fbids */
public abstract class SearchableContactPickerView extends CustomViewGroup {
    private static final Class<?> f6461a = SearchableContactPickerView.class;
    public 2 f6462b;
    public 3 f6463c;
    public 4 f6464d;
    public ContactPickerViewFilterState f6465e = ContactPickerViewFilterState.NONE;
    public BaseSearchableContactPickerListAdapter f6466f;
    public ContactPickerView f6467g;
    public FilterListener f6468h;
    public View f6469i;

    /* compiled from: post_fbids */
    public class C06661 implements OnContactListScrollListener {
        final /* synthetic */ SearchableContactPickerView f6484a;

        public C06661(SearchableContactPickerView searchableContactPickerView) {
            this.f6484a = searchableContactPickerView;
        }

        public final void mo266a(int i) {
            SearchableContactPickerView.m6823b(this.f6484a, i);
        }
    }

    /* compiled from: post_fbids */
    public class C06672 implements OnTouchListener {
        final /* synthetic */ SearchableContactPickerView f6485a;

        public C06672(SearchableContactPickerView searchableContactPickerView) {
            this.f6485a = searchableContactPickerView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            SearchableContactPickerView searchableContactPickerView = this.f6485a;
            if (motionEvent.getAction() == 0) {
                searchableContactPickerView.getSearchBar().mo252c();
                z = true;
            } else {
                z = false;
            }
            return z;
        }
    }

    /* compiled from: post_fbids */
    public class C06683 implements FilterListener {
        final /* synthetic */ SearchableContactPickerView f6486a;

        public C06683(SearchableContactPickerView searchableContactPickerView) {
            this.f6486a = searchableContactPickerView;
        }

        public final void m6840a(int i) {
            this.f6486a.m6824f();
        }

        public final void m6841a(FilteringState filteringState) {
            this.f6486a.m6824f();
        }
    }

    /* compiled from: post_fbids */
    public class C06694 implements OnContactListScrollListener {
        final /* synthetic */ OnContactListScrollListener f6487a;
        final /* synthetic */ SearchableContactPickerView f6488b;

        public C06694(SearchableContactPickerView searchableContactPickerView, OnContactListScrollListener onContactListScrollListener) {
            this.f6488b = searchableContactPickerView;
            this.f6487a = onContactListScrollListener;
        }

        public final void mo266a(int i) {
            this.f6487a.mo266a(i);
            SearchableContactPickerView.m6823b(this.f6488b, i);
        }
    }

    public abstract FaveditSearchBar getSearchBar();

    public SearchableContactPickerView(Context context, BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter, int i) {
        super(context);
        this.f6466f = baseSearchableContactPickerListAdapter;
        this.f6467g = new ContactPickerView(getContext(), i);
        this.f6467g.setAdapter(this.f6466f);
        addView(this.f6467g);
        this.f6467g.f6444d = new C06661(this);
        this.f6469i = getView(2131564801);
        this.f6469i.setOnTouchListener(new C06672(this));
        m6830d();
        this.f6468h = new C06683(this);
    }

    public final void m6829c() {
        ContactPickerListFilter d = this.f6466f.m6711d();
        String trim = getSearchBar().getSearchText().trim();
        if (StringUtil.a(trim)) {
            if (this.f6465e != ContactPickerViewFilterState.NONE) {
                m6826a(ContactPickerViewFilterState.UNFILTERED);
            }
            mo261a();
            d.a(null, this.f6468h);
        } else {
            m6826a(ContactPickerViewFilterState.FILTERING);
            d.a(trim, this.f6468h);
        }
        if (this.f6463c != null) {
            3 3 = this.f6463c;
            if (3.a.i != null) {
                DivebarViewListener divebarViewListener = 3.a.i;
                if (trim != null && !trim.equals("")) {
                    divebarViewListener.d.m7964a(trim);
                }
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (mo263b() && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && getSearchBar().mo255f()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void m6830d() {
        this.f6467g.m6807a();
    }

    public void m6827a(ImmutableList<ContactPickerRow> immutableList) {
        this.f6467g.m6809a((ImmutableList) immutableList);
        if (this.f6465e != ContactPickerViewFilterState.NONE) {
            m6829c();
        }
    }

    protected void m6826a(ContactPickerViewFilterState contactPickerViewFilterState) {
        this.f6465e = contactPickerViewFilterState;
    }

    private void mo261a() {
        boolean z = getSearchBar().mo254e() && this.f6465e != ContactPickerViewFilterState.FILTERED;
        ListView listView = this.f6467g.f6442a;
        if (z) {
            listView.setEnabled(false);
            this.f6469i.setVisibility(0);
            return;
        }
        listView.setEnabled(true);
        this.f6469i.setVisibility(8);
    }

    private void m6824f() {
        if (StringUtil.a(getSearchBar().getSearchText().trim())) {
            this.f6467g.m6810b();
            m6826a(ContactPickerViewFilterState.UNFILTERED);
        } else if (this.f6466f.getCount() == 0) {
            this.f6467g.m6808a(EmptyState.NO_RESULTS);
            m6826a(ContactPickerViewFilterState.FILTERED);
        } else {
            this.f6467g.m6810b();
            m6826a(ContactPickerViewFilterState.FILTERED);
        }
        mo261a();
    }

    public static void m6823b(SearchableContactPickerView searchableContactPickerView, int i) {
        if (i == 1) {
            searchableContactPickerView.getSearchBar().mo253d();
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        int i = -2;
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(2130772759, typedValue, true)) {
            i = (int) typedValue.getDimension(getResources().getDisplayMetrics());
        }
        LayoutParams layoutParams = getSearchBar().getThisView().getLayoutParams();
        layoutParams.height = i;
        getSearchBar().getThisView().setLayoutParams(layoutParams);
        m6829c();
    }

    protected void mo262a(View view, boolean z) {
        Integer.valueOf(z ? 1 : 0);
        if (!z) {
            if (!(this.f6465e == ContactPickerViewFilterState.NONE || this.f6464d == null)) {
                4 4 = this.f6464d;
                if (4.a.i != null) {
                    Object obj;
                    DivebarViewListener divebarViewListener = 4.a.i;
                    if (divebarViewListener.d.f7666f != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        divebarViewListener.d.m7967b();
                    }
                }
            }
            m6826a(ContactPickerViewFilterState.NONE);
            this.f6466f.m6712e();
        } else if (this.f6465e == ContactPickerViewFilterState.NONE) {
            m6826a(ContactPickerViewFilterState.UNFILTERED);
            if (this.f6462b != null) {
                2 2 = this.f6462b;
                if (2.a.i != null) {
                    2.a.i.d.m7966a("chat_bar", "divebar");
                }
            }
        }
        mo261a();
    }

    protected boolean mo263b() {
        return false;
    }
}
