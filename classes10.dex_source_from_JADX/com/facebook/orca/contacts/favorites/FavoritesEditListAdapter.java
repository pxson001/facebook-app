package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerFilterResult.Type;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.inject.Assisted;
import com.facebook.messaging.contacts.picker.ContactPickerRows;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.listview.DragSortListView.DragSortListAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onComposerPopupClosed */
public class FavoritesEditListAdapter extends BaseSearchableContactPickerListAdapter implements DragSortListAdapter {
    private static final Class<?> f5993e = FavoritesEditListAdapter.class;
    protected final DivebarEditFavoritesRowViewFactory f5994a;
    protected final Context f5995b;
    protected final LayoutInflater f5996c;
    protected ImmutableList<ContactPickerRow> f5997d = RegularImmutableList.a;
    private final Provider<ContactPickerListFilter> f5998f;
    private ImmutableList<ContactPickerRow> f5999g = RegularImmutableList.a;
    private ContactPickerListFilter f6000h;
    private int f6001i = 0;
    private int f6002j = 0;
    private int f6003k = 0;

    /* compiled from: onComposerPopupClosed */
    /* synthetic */ class C08931 {
        static final /* synthetic */ int[] f5992a = new int[Type.values().length];

        static {
            try {
                f5992a[Type.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5992a[Type.EMPTY_CONSTRAINT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5992a[Type.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final /* synthetic */ CustomFilter m5639a() {
        return d();
    }

    @Inject
    public FavoritesEditListAdapter(@Assisted EditFavoritesRowViewFactory editFavoritesRowViewFactory, Context context, Provider<ContactPickerListFilter> provider, LayoutInflater layoutInflater) {
        this.f5994a = editFavoritesRowViewFactory;
        this.f5995b = context;
        this.f5998f = provider;
        this.f5996c = layoutInflater;
    }

    public final void m5640a(ImmutableList<ContactPickerRow> immutableList) {
        int i;
        int i2 = 0;
        this.f5999g = immutableList;
        this.f5997d = this.f5999g;
        AdapterDetour.a(this, 1554871407);
        this.f6001i = 0;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (m5637a((ContactPickerRow) immutableList.get(i))) {
                this.f6001i++;
            }
        }
        this.f6002j = 0;
        i = immutableList.size();
        while (i2 < i && !m5637a((ContactPickerRow) immutableList.get(i2))) {
            this.f6002j++;
            i2++;
        }
        this.f6003k = (this.f6002j + this.f6001i) - 1;
    }

    private static boolean m5637a(ContactPickerRow contactPickerRow) {
        return (contactPickerRow instanceof FavoriteContactRow) || (contactPickerRow instanceof FavoriteGroupRow);
    }

    public int getViewTypeCount() {
        return 8;
    }

    public int getItemViewType(int i) {
        ContactPickerRow contactPickerRow = (ContactPickerRow) this.f5997d.get(i);
        if (contactPickerRow instanceof FavoriteContactRow) {
            return 0;
        }
        if (contactPickerRow instanceof FavoriteGroupRow) {
            return 4;
        }
        if (contactPickerRow instanceof AddFavoriteContactRow) {
            return 1;
        }
        if (contactPickerRow instanceof AddFavoriteGroupRow) {
            return 5;
        }
        if (contactPickerRow instanceof ContactPickerSectionHeaderRow) {
            return 6;
        }
        if (contactPickerRow == ContactPickerRows.f1907d) {
            return 3;
        }
        if (contactPickerRow == ContactPickerRows.f1908e) {
            return 2;
        }
        if (contactPickerRow == ContactPickerRows.f1910g) {
            return 7;
        }
        throw new IllegalArgumentException("Unknown object type " + contactPickerRow.getClass());
    }

    public int getCount() {
        return this.f5997d.size();
    }

    public Object getItem(int i) {
        return this.f5997d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactPickerRow contactPickerRow = (ContactPickerRow) this.f5997d.get(i);
        if (contactPickerRow == ContactPickerRows.f1908e) {
            return this.f5994a.m5614a(view);
        }
        if (contactPickerRow instanceof FavoriteContactRow) {
            return this.f5994a.m5618a((FavoriteContactRow) contactPickerRow, view);
        }
        if (contactPickerRow instanceof AddFavoriteContactRow) {
            return this.f5994a.m5616a((AddFavoriteContactRow) contactPickerRow, view);
        }
        if (contactPickerRow instanceof ContactPickerSectionHeaderRow) {
            return this.f5994a.m5615a((ContactPickerSectionHeaderRow) contactPickerRow, view);
        }
        if (contactPickerRow instanceof FavoriteGroupRow) {
            return this.f5994a.m5619a((FavoriteGroupRow) contactPickerRow, view);
        }
        if (contactPickerRow instanceof AddFavoriteGroupRow) {
            return this.f5994a.m5617a((AddFavoriteGroupRow) contactPickerRow, view);
        }
        if (contactPickerRow == ContactPickerRows.f1907d) {
            return this.f5994a.m5620b(view);
        }
        if (contactPickerRow == ContactPickerRows.f1910g) {
            return this.f5994a.m5613a();
        }
        throw new IllegalArgumentException("Unknown object type " + contactPickerRow.getClass());
    }

    private void m5638b(ImmutableList<ContactPickerRow> immutableList) {
        this.f5997d = immutableList;
        if (immutableList.size() > 0) {
            AdapterDetour.a(this, 374016795);
        } else {
            AdapterDetour.b(this, -753626913);
        }
    }

    public final int m5642b() {
        return this.f6002j;
    }

    public final int m5643c() {
        return this.f6001i != 0 ? this.f6003k : -1;
    }

    public final void m5641a(CharSequence charSequence, ContactPickerFilterResult contactPickerFilterResult) {
        Preconditions.checkNotNull(contactPickerFilterResult);
        switch (C08931.f5992a[contactPickerFilterResult.a.ordinal()]) {
            case 1:
                m5638b(contactPickerFilterResult.e());
                return;
            case 2:
                e();
                return;
            default:
                m5638b(RegularImmutableList.a);
                return;
        }
    }

    public final ContactPickerListFilter m5644d() {
        if (this.f6000h == null) {
            this.f6000h = (ContactPickerListFilter) this.f5998f.get();
            this.f6000h.a(this);
        }
        return this.f6000h;
    }

    public final void m5645e() {
        this.f5997d = this.f5999g;
        if (this.f5997d.size() > 0) {
            AdapterDetour.a(this, 752848612);
        } else {
            AdapterDetour.b(this, -416860744);
        }
    }
}
