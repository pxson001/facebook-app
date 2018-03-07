package com.facebook.messaging.contacts.picker;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerFilterResult.Type;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerInviteFriendsRow;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerListFilterReceiver;
import com.facebook.contacts.picker.ContactPickerMontageRow;
import com.facebook.contacts.picker.ContactPickerPaymentEligibleFooterRow;
import com.facebook.contacts.picker.ContactPickerPhoneContactRow;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.contacts.picker.ContactPickerSectionSplitterRow;
import com.facebook.contacts.picker.ContactPickerTincanRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerViewFactory;
import com.facebook.contacts.picker.ContactPickerViewMoreRow;
import com.facebook.contacts.picker.DivebarNearbyFriendsRow;
import com.facebook.contacts.picker.FavoritesSectionHeaderRow;
import com.facebook.contacts.picker.PickablePhoneContactRow;
import com.facebook.messaging.contacts.picker.util.MessagingContactLoggingHelper;
import com.facebook.orca.contacts.picker.DivebarContactPickerViewFactory;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: tap_conversation_starter */
public class ContactPickerViewListAdapter extends BaseSearchableContactPickerListAdapter {
    private static final Class<?> f2039a = ContactPickerViewListAdapter.class;
    private final DivebarContactPickerViewFactory f2040b;
    private final Provider<? extends ContactPickerListFilter> f2041c;
    @Nullable
    private final MessagingContactLoggingHelper f2042d;
    private ImmutableList<ContactPickerRow> f2043e;
    private ImmutableList<ContactPickerRow> f2044f;
    private ContactPickerListFilter f2045g;

    /* compiled from: tap_conversation_starter */
    class C03401 implements FilterListener {
        final /* synthetic */ ContactPickerViewListAdapter f2033a;

        C03401(ContactPickerViewListAdapter contactPickerViewListAdapter) {
            this.f2033a = contactPickerViewListAdapter;
        }

        public final void m1859a(int i) {
        }

        public final void m1860a(FilteringState filteringState) {
            if (this.f2033a.getCount() > 0) {
                AdapterDetour.a(this.f2033a, -6211604);
            } else {
                AdapterDetour.b(this.f2033a, 1279091779);
            }
        }
    }

    /* compiled from: tap_conversation_starter */
    /* synthetic */ class C03412 {
        static final /* synthetic */ int[] f2034a = new int[Type.values().length];

        static {
            try {
                f2034a[Type.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2034a[Type.EMPTY_CONSTRAINT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2034a[Type.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: tap_conversation_starter */
    enum RowType {
        CONTACT_ROW,
        SECTION_HEADER,
        SECTION_SPLITTER,
        FAVORITES_SECTION_HEADER,
        INVITE_FRIENDS,
        GROUP_ROW,
        NEARBY_FRIENDS,
        FRIENDS_WITH_NEW_POSTS,
        VIEW_MORE_INLINE,
        LOADING_MORE,
        PHONE_CONTACT_ROW,
        PAYMENT_ELIGIBLE_FOOTER,
        MONTAGE_ROW,
        MONTAGE_AUDIENCE_ROW,
        TINCAN_ROW
    }

    /* compiled from: tap_conversation_starter */
    class WrapperFilter implements ContactPickerListFilter {
        private final ContactPickerListFilter f2037a;
        public final FilterListener f2038b;

        public WrapperFilter(ContactPickerListFilter contactPickerListFilter, FilterListener filterListener) {
            this.f2037a = contactPickerListFilter;
            this.f2038b = filterListener;
        }

        public final void m1865a(ContactPickerListFilterReceiver contactPickerListFilterReceiver) {
            this.f2037a.a(contactPickerListFilterReceiver);
        }

        public final void m1866a(ImmutableList<UserIdentifier> immutableList) {
            this.f2037a.a(immutableList);
        }

        public final void m1864a(RowCreator rowCreator) {
            this.f2037a.a(rowCreator);
        }

        public final void m1867a(CharSequence charSequence) {
            this.f2037a.a(charSequence, this.f2038b);
        }

        public final void m1868a(CharSequence charSequence, final FilterListener filterListener) {
            this.f2037a.a(charSequence, new FilterListener(this) {
                final /* synthetic */ WrapperFilter f2036b;

                public final void m1861a(int i) {
                    filterListener.a(i);
                    this.f2036b.f2038b.a(i);
                }

                public final void m1862a(FilteringState filteringState) {
                    filterListener.a(filteringState);
                    this.f2036b.f2038b.a(filteringState);
                }
            });
        }

        public final FilteringState m1869b() {
            return this.f2037a.b();
        }

        public final void m1863a() {
            this.f2037a.a();
        }
    }

    public final /* synthetic */ CustomFilter m1872a() {
        return d();
    }

    public /* synthetic */ Object getItem(int i) {
        return m1870a(i);
    }

    public ContactPickerViewListAdapter(ContactPickerViewFactory contactPickerViewFactory, Provider<? extends ContactPickerListFilter> provider) {
        this(contactPickerViewFactory, provider, null);
    }

    public ContactPickerViewListAdapter(ContactPickerViewFactory contactPickerViewFactory, Provider<? extends ContactPickerListFilter> provider, @Nullable MessagingContactLoggingHelper messagingContactLoggingHelper) {
        this.f2043e = RegularImmutableList.a;
        this.f2044f = RegularImmutableList.a;
        this.f2040b = contactPickerViewFactory;
        this.f2041c = provider;
        this.f2042d = messagingContactLoggingHelper;
    }

    public final void m1873a(ImmutableList<ContactPickerRow> immutableList) {
        this.f2043e = immutableList;
        this.f2044f = this.f2043e;
        AdapterDetour.a(this, -592470535);
    }

    public final void m1874a(CharSequence charSequence, ContactPickerFilterResult contactPickerFilterResult) {
        Preconditions.checkNotNull(contactPickerFilterResult);
        switch (C03412.f2034a[contactPickerFilterResult.a.ordinal()]) {
            case 1:
                m1871b(contactPickerFilterResult.e());
                return;
            case 2:
                e();
                return;
            default:
                m1871b(RegularImmutableList.a);
                return;
        }
    }

    public final void m1876e() {
        this.f2044f = this.f2043e;
        if (getCount() > 0) {
            AdapterDetour.a(this, 1848180864);
        } else {
            AdapterDetour.b(this, -1591827781);
        }
    }

    private void m1871b(ImmutableList<ContactPickerRow> immutableList) {
        this.f2044f = immutableList;
        if (getCount() > 0) {
            AdapterDetour.a(this, -781965895);
        } else {
            AdapterDetour.b(this, 1233788945);
        }
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getItemViewType(int i) {
        ContactPickerRow a = m1870a(i);
        if (a instanceof ContactPickerUserRow) {
            return RowType.CONTACT_ROW.ordinal();
        }
        if (a instanceof ContactPickerGroupRow) {
            return RowType.GROUP_ROW.ordinal();
        }
        if (a instanceof FavoritesSectionHeaderRow) {
            return RowType.FAVORITES_SECTION_HEADER.ordinal();
        }
        if (a instanceof ContactPickerViewMoreRow) {
            return RowType.VIEW_MORE_INLINE.ordinal();
        }
        if (a instanceof DivebarNearbyFriendsRow) {
            return RowType.NEARBY_FRIENDS.ordinal();
        }
        if (a instanceof ContactPickerSectionHeaderRow) {
            return RowType.SECTION_HEADER.ordinal();
        }
        if (a instanceof ContactPickerSectionSplitterRow) {
            return RowType.SECTION_SPLITTER.ordinal();
        }
        if (a instanceof ContactPickerInviteFriendsRow) {
            return RowType.INVITE_FRIENDS.ordinal();
        }
        if (a == ContactPickerRows.f1909f) {
            return RowType.LOADING_MORE.ordinal();
        }
        if (a instanceof ContactPickerPhoneContactRow) {
            return RowType.PHONE_CONTACT_ROW.ordinal();
        }
        if (a instanceof PickablePhoneContactRow) {
            return RowType.PHONE_CONTACT_ROW.ordinal();
        }
        if (a instanceof ContactPickerPaymentEligibleFooterRow) {
            return RowType.PAYMENT_ELIGIBLE_FOOTER.ordinal();
        }
        if (a instanceof ContactPickerMontageRow) {
            return RowType.MONTAGE_ROW.ordinal();
        }
        if (a instanceof ContactPickerTincanRow) {
            return RowType.TINCAN_ROW.ordinal();
        }
        throw new IllegalArgumentException("Unknown object type " + a.getClass());
    }

    public int getCount() {
        return (this.f2045g == null || this.f2045g.b() != FilteringState.FILTERING) ? this.f2044f.size() : this.f2044f.size() + 1;
    }

    private ContactPickerRow m1870a(int i) {
        if (i == this.f2044f.size()) {
            return ContactPickerRows.f1909f;
        }
        return (ContactPickerRow) this.f2044f.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int i) {
        ContactPickerRow a = m1870a(i);
        if ((a instanceof ContactPickerSectionHeaderRow) || (a instanceof ContactPickerPaymentEligibleFooterRow) || (a instanceof FavoritesSectionHeaderRow) || a == ContactPickerRows.f1909f) {
            return false;
        }
        if (a instanceof ContactPickerUserRow) {
            ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) a;
            if (!contactPickerUserRow.r || (!contactPickerUserRow.w && (contactPickerUserRow.u || contactPickerUserRow.v))) {
                return false;
            }
        }
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactPickerRow a = m1870a(i);
        if (a instanceof ContactPickerUserRow) {
            return this.f2040b.m5799a((ContactPickerUserRow) a, view);
        }
        if (a instanceof ContactPickerGroupRow) {
            return this.f2040b.m5793a((ContactPickerGroupRow) a, view);
        }
        if (a instanceof FavoritesSectionHeaderRow) {
            return this.f2040b.m5802a((FavoritesSectionHeaderRow) a, view);
        }
        if (a instanceof ContactPickerViewMoreRow) {
            return this.f2040b.m5800a((ContactPickerViewMoreRow) a, view);
        }
        if (a instanceof DivebarNearbyFriendsRow) {
            return this.f2040b.m5801a((DivebarNearbyFriendsRow) a, view);
        }
        if (a instanceof ContactPickerSectionHeaderRow) {
            if (this.f2042d != null) {
                this.f2042d.m1885a(viewGroup.getContext(), (ContactPickerSectionHeaderRow) a);
            }
            return this.f2040b.m5797a((ContactPickerSectionHeaderRow) a, view);
        } else if (a instanceof ContactPickerSectionSplitterRow) {
            return this.f2040b.m5804b(view);
        } else {
            if (a instanceof ContactPickerInviteFriendsRow) {
                return this.f2040b.m5792a(view, (ContactPickerInviteFriendsRow) a);
            }
            if (a == ContactPickerRows.f1909f) {
                return this.f2040b.m5791a(view);
            }
            if (a instanceof ContactPickerPhoneContactRow) {
                return this.f2040b.m5796a((ContactPickerPhoneContactRow) a, view);
            }
            if (a instanceof PickablePhoneContactRow) {
                return this.f2040b.m5803a((PickablePhoneContactRow) a, view);
            }
            if (a instanceof ContactPickerPaymentEligibleFooterRow) {
                return this.f2040b.m5795a((ContactPickerPaymentEligibleFooterRow) a, view);
            }
            if (a instanceof ContactPickerMontageRow) {
                return this.f2040b.m5794a((ContactPickerMontageRow) a, view);
            }
            if (a instanceof ContactPickerTincanRow) {
                return this.f2040b.m5798a((ContactPickerTincanRow) a, view);
            }
            throw new IllegalArgumentException("Unknown object type " + a.getClass());
        }
    }

    public final ContactPickerListFilter m1875d() {
        if (this.f2045g == null && this.f2041c != null) {
            this.f2045g = new WrapperFilter((ContactPickerListFilter) this.f2041c.get(), new C03401(this));
            this.f2045g.a(this);
        }
        return this.f2045g;
    }
}
