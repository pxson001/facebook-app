package com.facebook.messaging.contacts.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.facebook.contacts.picker.BaseContactPickerListAdapter;
import com.facebook.contacts.picker.ContactIndexablePickerRow;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.contacts.picker.ContactPickerSectionSplitterRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.FavoritesSectionHeaderRow;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerSectionContactUploadView.Listener;
import com.facebook.messaging.contacts.picker.constants.ContactPickerCymkRow;
import com.facebook.messaging.contacts.picker.util.MessagingContactLoggingHelper;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowView;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollItemData;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollItemData.DataSource;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollView;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollViewAdapter;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollViewListener;
import com.facebook.messaging.ui.header.ActionableSectionHeaderView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_conversation_thread */
public class ContactPickerViewIndexableListAdapter extends BaseContactPickerListAdapter implements SectionIndexer, StickyHeaderAdapter {
    private static final Class<?> f2019c = ContactPickerViewIndexableListAdapter.class;
    @Inject
    public MessagingContactLoggingHelper f2020a;
    @Inject
    public SecureContextHelper f2021b;
    private final Context f2022d;
    private ImmutableList<ContactPickerRow> f2023e = RegularImmutableList.a;
    public HashMap<Integer, Integer> f2024f = Maps.c();
    public HashMap<Integer, Integer> f2025g = Maps.c();
    public String[] f2026h;
    private int f2027i = -1;
    private int f2028j;
    private int f2029k = 0;
    private Listener f2030l;
    private ContactPickerSectionContactSyncPermanentRowView.Listener f2031m;
    @Nullable
    private ContactPickerHScrollViewListener f2032n;

    /* compiled from: tap_conversation_thread */
    public class C03392 {
        final /* synthetic */ ContactPickerViewIndexableListAdapter f2018a;

        C03392(ContactPickerViewIndexableListAdapter contactPickerViewIndexableListAdapter) {
            this.f2018a = contactPickerViewIndexableListAdapter;
        }
    }

    /* compiled from: tap_conversation_thread */
    enum RowType {
        CONTACT_ROW,
        SECTION_HEADER,
        SECTION_SPLITTER,
        FAVORITES_HEADER,
        CONTACT_UPLOAD_ROW,
        CONTACT_SYNC_PERMANENT_ROW,
        CHAT_AVAILABILITY_TOGGLE_ROW,
        INVITE_PERMANENT_ROW,
        INVITE_FRIENDS_UPSELL_ROW,
        NEW_GROUPS_ROW,
        SMS_TAKEOVER_PERMANENT_ROW,
        H_SCROLL_ROW,
        IMAGE_CODE_ROW,
        CYMK_ROW
    }

    private static ContactPickerViewIndexableListAdapter m1849b(InjectorLike injectorLike) {
        ContactPickerViewIndexableListAdapter contactPickerViewIndexableListAdapter = new ContactPickerViewIndexableListAdapter((Context) injectorLike.getInstance(Context.class));
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        contactPickerViewIndexableListAdapter.f2020a = MessagingContactLoggingHelper.m1884b(injectorLike);
        contactPickerViewIndexableListAdapter.f2021b = secureContextHelper;
        return contactPickerViewIndexableListAdapter;
    }

    public int getCount() {
        return this.f2023e.size();
    }

    public Object getItem(int i) {
        return this.f2023e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int i) {
        Object item = getItem(i);
        return (item instanceof ContactPickerUserRow) || (item instanceof ContactPickerSectionPermanentInviteRow) || (item instanceof ContactPickerNewGroupsRow) || (item instanceof ContactPickerSectionSmsTakeoverPermanentRow) || (item instanceof ImageCodePickerRow);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactPickerRow contactPickerRow = (ContactPickerRow) this.f2023e.get(i);
        if (contactPickerRow instanceof ContactPickerUserRow) {
            return m1841a((ContactPickerUserRow) contactPickerRow, view);
        }
        if (contactPickerRow instanceof ContactPickerSectionSplitterRow) {
            return m1839a(view);
        }
        if (contactPickerRow instanceof ContactPickerSectionHeaderRow) {
            this.f2020a.m1885a(viewGroup.getContext(), (ContactPickerSectionHeaderRow) contactPickerRow);
            return m1840a((ContactPickerSectionHeaderRow) contactPickerRow, view);
        } else if (contactPickerRow instanceof FavoritesSectionHeaderRow) {
            return m1842a((FavoritesSectionHeaderRow) contactPickerRow, view);
        } else {
            if (contactPickerRow instanceof ContactPickerSectionContactUploadRow) {
                return m1848b(view);
            }
            if (contactPickerRow instanceof ContactPickerSectionContactSyncPermanentRow) {
                return m1850c(view);
            }
            if (contactPickerRow instanceof ContactPickerToggleChatAvailabilityRow) {
                return m1846a((ContactPickerToggleChatAvailabilityRow) contactPickerRow, view);
            }
            if (contactPickerRow instanceof ContactPickerSectionInviteFriendsUpsellRow) {
                return m1851d(view);
            }
            if (contactPickerRow instanceof ContactPickerSectionPermanentInviteRow) {
                return m1844a((ContactPickerSectionPermanentInviteRow) contactPickerRow, view);
            }
            if (contactPickerRow instanceof ContactPickerNewGroupsRow) {
                return m1852e(view);
            }
            if (contactPickerRow instanceof ContactPickerSectionSmsTakeoverPermanentRow) {
                return m1845a((ContactPickerSectionSmsTakeoverPermanentRow) contactPickerRow, view);
            }
            if (contactPickerRow instanceof ContactPickerHScrollRow) {
                return m1843a((ContactPickerHScrollRow) contactPickerRow, view);
            }
            if (contactPickerRow instanceof ImageCodePickerRow) {
                return m1847a((ImageCodePickerRow) contactPickerRow, view);
            }
            if (contactPickerRow instanceof ContactPickerCymkRow) {
                return m1853f(view);
            }
            throw new IllegalArgumentException("Unknown object type " + contactPickerRow.getClass());
        }
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getItemViewType(int i) {
        ContactPickerRow contactPickerRow = (ContactPickerRow) this.f2023e.get(i);
        if (contactPickerRow instanceof ContactPickerUserRow) {
            return RowType.CONTACT_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionSplitterRow) {
            return RowType.SECTION_SPLITTER.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionHeaderRow) {
            return RowType.SECTION_HEADER.ordinal();
        }
        if (contactPickerRow instanceof FavoritesSectionHeaderRow) {
            return RowType.FAVORITES_HEADER.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionContactUploadRow) {
            return RowType.CONTACT_UPLOAD_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionContactSyncPermanentRow) {
            return RowType.CONTACT_SYNC_PERMANENT_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerToggleChatAvailabilityRow) {
            return RowType.CHAT_AVAILABILITY_TOGGLE_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionPermanentInviteRow) {
            return RowType.INVITE_PERMANENT_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionInviteFriendsUpsellRow) {
            return RowType.INVITE_FRIENDS_UPSELL_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerNewGroupsRow) {
            return RowType.NEW_GROUPS_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerSectionSmsTakeoverPermanentRow) {
            return RowType.SMS_TAKEOVER_PERMANENT_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerHScrollRow) {
            return RowType.H_SCROLL_ROW.ordinal();
        }
        if (contactPickerRow instanceof ImageCodePickerRow) {
            return RowType.IMAGE_CODE_ROW.ordinal();
        }
        if (contactPickerRow instanceof ContactPickerCymkRow) {
            return RowType.CYMK_ROW.ordinal();
        }
        throw new IllegalArgumentException("Unknown object type " + contactPickerRow.getClass());
    }

    @Inject
    public ContactPickerViewIndexableListAdapter(Context context) {
        this.f2022d = context;
    }

    public final void m1854a(ImmutableList<ContactPickerRow> immutableList) {
        this.f2023e = immutableList;
        this.f2024f.clear();
        this.f2025g.clear();
        List a = Lists.a();
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ContactPickerRow contactPickerRow = (ContactPickerRow) immutableList.get(i2);
            if (contactPickerRow instanceof ContactIndexablePickerRow) {
                a.add(((ContactIndexablePickerRow) contactPickerRow).a());
                this.f2024f.put(Integer.valueOf(a.size() - 1), Integer.valueOf(i));
            }
            this.f2025g.put(Integer.valueOf(i), Integer.valueOf(a.size() - 1));
            i++;
        }
        this.f2026h = new String[a.size()];
        a.toArray(this.f2026h);
        AdapterDetour.a(this, 276483176);
    }

    private View m1841a(ContactPickerUserRow contactPickerUserRow, View view) {
        view = (ContactPickerListItem) view;
        if (view == null) {
            view = new ContactPickerListItem(this.f2022d);
        }
        view.setContactRow(contactPickerUserRow);
        return view;
    }

    private View m1839a(View view) {
        ContactPickerSectionSplitterView contactPickerSectionSplitterView = (ContactPickerSectionSplitterView) view;
        if (contactPickerSectionSplitterView == null) {
            return new ContactPickerSectionSplitterView(this.f2022d);
        }
        return contactPickerSectionSplitterView;
    }

    private View m1840a(ContactPickerSectionHeaderRow contactPickerSectionHeaderRow, View view) {
        view = (ActionableSectionHeaderView) view;
        if (view == null) {
            view = new ActionableSectionHeaderView(this.f2022d);
        }
        view.setText(contactPickerSectionHeaderRow.a);
        return view;
    }

    private View m1842a(FavoritesSectionHeaderRow favoritesSectionHeaderRow, View view) {
        view = (ActionableSectionHeaderView) view;
        if (view == null) {
            view = new ActionableSectionHeaderView(this.f2022d);
        }
        view.setText(favoritesSectionHeaderRow.a);
        view.setActionButtonText(favoritesSectionHeaderRow.b);
        view.f4855c = favoritesSectionHeaderRow.c;
        return view;
    }

    private View m1846a(ContactPickerToggleChatAvailabilityRow contactPickerToggleChatAvailabilityRow, View view) {
        view = (ContactPickerToggleChatAvailabilityItem) view;
        if (view == null) {
            view = new ContactPickerToggleChatAvailabilityItem(this.f2022d);
        }
        view.f2011e = contactPickerToggleChatAvailabilityRow;
        User user = view.f2011e.f2013a;
        view.f2008b.setText(user.j());
        view.f2009c.setParams(UserTileViewParams.a(user, view.f2007a.b(user)));
        boolean z = view.f2011e.f2014b;
        view.f2012f.setChecked(z);
        view.f2010d.setVisibility(z ? 0 : 8);
        return view;
    }

    private View m1848b(View view) {
        ContactPickerSectionContactUploadView contactPickerSectionContactUploadView = (ContactPickerSectionContactUploadView) view;
        if (contactPickerSectionContactUploadView != null) {
            return contactPickerSectionContactUploadView;
        }
        view = new ContactPickerSectionContactUploadView(this.f2022d);
        view.f1973t = this.f2030l;
        return view;
    }

    private View m1850c(View view) {
        ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView = (ContactPickerSectionContactSyncPermanentRowView) view;
        if (contactPickerSectionContactSyncPermanentRowView != null) {
            return contactPickerSectionContactSyncPermanentRowView;
        }
        view = new ContactPickerSectionContactSyncPermanentRowView(this.f2022d);
        view.f1939m = this.f2031m;
        return view;
    }

    private View m1851d(View view) {
        ContactPickerSectionInviteFriendsUpsellView contactPickerSectionInviteFriendsUpsellView = (ContactPickerSectionInviteFriendsUpsellView) view;
        if (contactPickerSectionInviteFriendsUpsellView == null) {
            return new ContactPickerSectionInviteFriendsUpsellView(this.f2022d);
        }
        return contactPickerSectionInviteFriendsUpsellView;
    }

    private View m1844a(ContactPickerSectionPermanentInviteRow contactPickerSectionPermanentInviteRow, View view) {
        view = (ContactPickerSectionTopRowView) view;
        if (view == null) {
            view = new ContactPickerSectionTopRowView(this.f2022d);
        }
        view.setTextResource(contactPickerSectionPermanentInviteRow.f1983a);
        view.setIconResource(contactPickerSectionPermanentInviteRow.f1984b);
        return view;
    }

    private View m1852e(View view) {
        ContactPickerNewGroupsView contactPickerNewGroupsView = (ContactPickerNewGroupsView) view;
        if (contactPickerNewGroupsView == null) {
            return new ContactPickerNewGroupsView(this.f2022d);
        }
        return contactPickerNewGroupsView;
    }

    private View m1845a(ContactPickerSectionSmsTakeoverPermanentRow contactPickerSectionSmsTakeoverPermanentRow, View view) {
        view = (ContactPickerSectionTopRowView) view;
        if (view == null) {
            view = new ContactPickerSectionTopRowView(this.f2022d);
        }
        view.setText(contactPickerSectionSmsTakeoverPermanentRow.f1986a);
        view.setIconResource(contactPickerSectionSmsTakeoverPermanentRow.f1987b);
        return view;
    }

    private View m1843a(final ContactPickerHScrollRow contactPickerHScrollRow, View view) {
        int i;
        view = (ContactPickerHScrollView) view;
        if (view == null) {
            view = new ContactPickerHScrollView(this.f2022d);
        }
        boolean z = contactPickerHScrollRow.f1796a;
        Resources resources = view.getResources();
        view.f3827c = z;
        view.f3826b.getLayoutParams().height = view.f3827c ? resources.getDimensionPixelSize(2131433818) : resources.getDimensionPixelSize(2131433819);
        view.f3825a.f3831c = z;
        ImmutableList immutableList = contactPickerHScrollRow.f1797b;
        ContactPickerHScrollViewAdapter contactPickerHScrollViewAdapter = view.f3825a;
        contactPickerHScrollViewAdapter.f3833e = immutableList;
        contactPickerHScrollViewAdapter.notifyDataSetChanged();
        view.f3825a.f3832d = this.f2032n;
        immutableList = contactPickerHScrollRow.f1797b;
        if (immutableList == null || immutableList.isEmpty()) {
            i = 0;
        } else {
            DataSource dataSource = ((ContactPickerHScrollItemData) immutableList.get(0)).f3818c;
            i = (dataSource == DataSource.BYMM || dataSource == DataSource.BOTS) ? 1 : 0;
        }
        if (i != 0) {
            final Set hashSet = new HashSet();
            view.f3826b.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ ContactPickerViewIndexableListAdapter f2017c;

                public final void m1838a(RecyclerView recyclerView, int i, int i2) {
                    this.f2017c.f2020a.m1886a((LinearLayoutManager) recyclerView.getLayoutManager(), hashSet, contactPickerHScrollRow.f1797b);
                }
            });
        }
        return view;
    }

    private View m1847a(ImageCodePickerRow imageCodePickerRow, View view) {
        view = (ContactPickerSectionTopRowView) view;
        if (view == null) {
            view = new ContactPickerSectionTopRowView(this.f2022d);
        }
        view.setText(imageCodePickerRow.f2050a);
        view.setIconResource(imageCodePickerRow.f2051b);
        return view;
    }

    private View m1853f(View view) {
        view = (ContactsYouMayKnowView) view;
        if (view == null) {
            view = new ContactsYouMayKnowView(this.f2022d);
        }
        view.setListener(new C03392(this));
        return view;
    }

    public Object[] getSections() {
        return this.f2026h;
    }

    public int getPositionForSection(int i) {
        if (this.f2024f.containsKey(Integer.valueOf(i))) {
            return ((Integer) this.f2024f.get(Integer.valueOf(i))).intValue();
        }
        return this.f2025g.size() - 1;
    }

    public int getSectionForPosition(int i) {
        return ((Integer) this.f2025g.get(Integer.valueOf(i))).intValue();
    }

    @TargetApi(16)
    public final View m1855b(int i, View view, ViewGroup viewGroup) {
        int positionForSection = getPositionForSection(getSectionForPosition(i));
        int itemViewType = getItemViewType(positionForSection);
        if (itemViewType == RowType.CONTACT_UPLOAD_ROW.ordinal() || itemViewType == RowType.CONTACT_SYNC_PERMANENT_ROW.ordinal() || itemViewType == RowType.CHAT_AVAILABILITY_TOGGLE_ROW.ordinal() || itemViewType == RowType.INVITE_FRIENDS_UPSELL_ROW.ordinal() || itemViewType == RowType.INVITE_PERMANENT_ROW.ordinal() || itemViewType == RowType.NEW_GROUPS_ROW.ordinal() || itemViewType == RowType.SMS_TAKEOVER_PERMANENT_ROW.ordinal() || itemViewType == RowType.CYMK_ROW.ordinal()) {
            return null;
        }
        if (this.f2027i != itemViewType) {
            view = null;
        }
        this.f2027i = itemViewType;
        return getView(positionForSection, view, viewGroup);
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m1857e(int i) {
        return this.f2028j;
    }

    public final int m1856d() {
        return this.f2029k;
    }

    public final boolean m1858f(int i) {
        if (i < 0 || i >= getCount() || getSectionForPosition(i) + 1 >= this.f2026h.length || getPositionForSection(getSectionForPosition(i)) != i) {
            return false;
        }
        return true;
    }
}
