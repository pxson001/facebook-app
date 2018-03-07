package com.facebook.saved.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.saved.adapter.SavedDashboardListItemType;
import com.facebook.saved.controller.SavedDashboardLoadMoreController.OnLoadMoreListener;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.data.SavedDashboardListItem;
import com.facebook.saved.data.SavedDashboardListSectionHeader;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.helper.SavedListItemHelper;
import com.facebook.saved.views.SavedDashboardSavedItemView;
import com.facebook.saved.views.SavedDashboardSavedItemView.SavedItemEventListener;
import com.facebook.saved.views.SavedDashboardSectionHeaderView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invite_notification_type */
public class SavedItemsListAdapter extends FbBaseAdapter implements OnLoadMoreListener, StickyHeaderAdapter {
    private final Resources f9147a;
    private final LayoutInflater f9148b;
    private final SavedListItemHelper f9149c;
    public ArrayList<SavedDashboardListItem> f9150d;
    public ItemsFreshness f9151e = ItemsFreshness.NONE;
    public ListState f9152f;
    public ArrayList<Integer> f9153g;
    public SavedItemEventListener f9154h;
    public OnClickListener f9155i;

    /* compiled from: invite_notification_type */
    public enum ItemsFreshness {
        FROM_SERVER,
        FROM_CACHE,
        NONE
    }

    /* compiled from: invite_notification_type */
    public enum ListState {
        IDLE,
        LOADING_MORE,
        LOAD_MORE_FAILED
    }

    @Inject
    public SavedItemsListAdapter(Resources resources, LayoutInflater layoutInflater, SavedListItemHelper savedListItemHelper) {
        this.f9147a = resources;
        this.f9148b = layoutInflater;
        this.f9149c = savedListItemHelper;
        this.f9150d = new ArrayList();
        this.f9152f = ListState.IDLE;
        this.f9153g = new ArrayList();
    }

    public final void m9143a(ImmutableList<? extends SavedDashboardListItem> immutableList, ItemsFreshness itemsFreshness) {
        this.f9150d.clear();
        this.f9150d.addAll(immutableList);
        this.f9153g.clear();
        m9139a(this.f9150d, 0);
        this.f9151e = itemsFreshness;
        AdapterDetour.a(this, -1131174611);
    }

    public final void m9147b(ImmutableList<SavedDashboardListItem> immutableList, ItemsFreshness itemsFreshness) {
        ArrayList a;
        Integer valueOf = Integer.valueOf(this.f9150d.size());
        List list = this.f9150d;
        if (list.isEmpty()) {
            a = Lists.a(immutableList);
        } else if (immutableList.isEmpty()) {
            a = Lists.a(list);
        } else {
            ArrayList a2 = Lists.a(list);
            SavedDashboardListItem savedDashboardListItem = (SavedDashboardListItem) list.get(list.size() - 1);
            Preconditions.checkArgument(savedDashboardListItem instanceof SavedDashboardItem, "Last item of list should never be a header.");
            SavedDashboardListItem savedDashboardListItem2 = (SavedDashboardListItem) immutableList.get(0);
            Preconditions.checkArgument(savedDashboardListItem2 instanceof SavedDashboardListSectionHeader, "First item of second list should always be a header.");
            if (!((SavedDashboardItem) savedDashboardListItem).f9109d.equals(((SavedDashboardListSectionHeader) savedDashboardListItem2).f9120a)) {
                a2.add(immutableList.get(0));
            }
            a2.addAll(immutableList.subList(1, immutableList.size()));
            a = a2;
        }
        this.f9150d = a;
        this.f9151e = m9138a(this.f9151e, itemsFreshness);
        m9139a(this.f9150d, valueOf.intValue());
        AdapterDetour.a(this, -1011751857);
    }

    public final void mo418b() {
        this.f9152f = ListState.LOADING_MORE;
        AdapterDetour.a(this, -234762893);
    }

    public final void mo419c() {
        this.f9152f = ListState.IDLE;
        AdapterDetour.a(this, -2035568628);
    }

    public final void mo420e() {
        this.f9152f = ListState.IDLE;
        AdapterDetour.a(this, -669619833);
    }

    public final void mo422g() {
        this.f9152f = ListState.IDLE;
        AdapterDetour.a(this, -745295808);
    }

    public final void mo421f() {
        this.f9152f = ListState.LOAD_MORE_FAILED;
        AdapterDetour.a(this, 996092158);
    }

    public int getCount() {
        int size = this.f9150d.size();
        Object obj = (ListState.LOADING_MORE.equals(this.f9152f) || ListState.LOAD_MORE_FAILED.equals(this.f9152f)) ? 1 : null;
        return (obj != null ? 1 : 0) + size;
    }

    public Object getItem(int i) {
        if (i < this.f9150d.size()) {
            return this.f9150d.get(i);
        }
        switch (this.f9152f) {
            case LOADING_MORE:
                return SavedDashboardListItemType.SAVED_DASHBOARD_LOAD_MORE;
            case LOAD_MORE_FAILED:
                return SavedDashboardListItemType.SAVED_DASHBOARD_LOAD_MORE_FAILED;
            default:
                throw new IllegalArgumentException("Invalid position for current list state. Position: " + i + " State: " + this.f9152f);
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (i < this.f9150d.size()) {
            return ((SavedDashboardListItem) this.f9150d.get(i)).mo423a().ordinal();
        }
        switch (this.f9152f) {
            case LOADING_MORE:
                return SavedDashboardListItemType.SAVED_DASHBOARD_LOAD_MORE.ordinal();
            case LOAD_MORE_FAILED:
                return SavedDashboardListItemType.SAVED_DASHBOARD_LOAD_MORE_FAILED.ordinal();
            default:
                throw new IllegalArgumentException("Invalid position for current list state. Position: " + i + " State: " + this.f9152f);
        }
    }

    public int getViewTypeCount() {
        return SavedDashboardListItemType.values().length;
    }

    public final View m9140a(int i, ViewGroup viewGroup) {
        switch (SavedDashboardListItemType.fromOrdinal(i)) {
            case SAVED_DASHBOARD_LIST_SECTION_HEADER:
                return this.f9148b.inflate(2130906947, viewGroup, false);
            case SAVED_DASHBOARD_SAVED_ITEM:
                return this.f9148b.inflate(2130906946, viewGroup, false);
            case SAVED_DASHBOARD_LOAD_MORE:
                return this.f9148b.inflate(2130906945, viewGroup, false);
            case SAVED_DASHBOARD_LOAD_MORE_FAILED:
                return this.f9148b.inflate(2130906944, viewGroup, false);
            default:
                throw new IllegalStateException("Unexpected itemViewType: " + i);
        }
    }

    @Nullable
    public final View m9145b(int i, @Nullable View view, ViewGroup viewGroup) {
        View a;
        if (view == null) {
            a = a(SavedDashboardListItemType.SAVED_DASHBOARD_LIST_SECTION_HEADER.ordinal(), viewGroup);
        } else {
            a = view;
        }
        int size = this.f9153g.size();
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) this.f9153g.get(i3);
            if (i < num.intValue()) {
                break;
            }
            i2 = num.intValue();
        }
        int i4 = i2;
        if (i4 < 0) {
            return null;
        }
        ((SavedDashboardSectionHeaderView) a).m9513a((SavedDashboardListSectionHeader) getItem(i4));
        return a;
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m9150e(int i) {
        return this.f9147a.getDimensionPixelSize(2131432256);
    }

    public final int m9149d() {
        return this.f9147a.getColor(2131363596);
    }

    public final boolean m9153f(int i) {
        if (i < 0 || i >= getCount() - 1) {
            return false;
        }
        boolean z = i >= this.f9150d.size() ? false : ((SavedDashboardListItem) this.f9150d.get(i)).mo423a() == SavedDashboardListItemType.SAVED_DASHBOARD_LIST_SECTION_HEADER;
        return z;
    }

    public boolean isEnabled(int i) {
        Object item = getItem(i);
        return (item instanceof SavedDashboardItem) && !((SavedDashboardItem) item).f9115j;
    }

    public final void m9141a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (SavedDashboardListItemType.fromOrdinal(i2)) {
            case SAVED_DASHBOARD_LIST_SECTION_HEADER:
                ((SavedDashboardSectionHeaderView) view).m9513a((SavedDashboardListSectionHeader) obj);
                return;
            case SAVED_DASHBOARD_SAVED_ITEM:
                SavedDashboardSavedItemView savedDashboardSavedItemView = (SavedDashboardSavedItemView) view;
                savedDashboardSavedItemView.m9511a((SavedDashboardItem) obj);
                savedDashboardSavedItemView.f9355e = this.f9154h;
                return;
            case SAVED_DASHBOARD_LOAD_MORE_FAILED:
                view.setOnClickListener(this.f9155i);
                return;
            default:
                return;
        }
    }

    public final void m9142a(SavedDashboardItem savedDashboardItem) {
        int indexOf = this.f9150d.indexOf(savedDashboardItem);
        if (indexOf != -1) {
            this.f9150d.set(indexOf, savedDashboardItem);
            AdapterDetour.a(this, 10802947);
        }
    }

    private static ItemsFreshness m9138a(ItemsFreshness itemsFreshness, ItemsFreshness itemsFreshness2) {
        switch (itemsFreshness2) {
            case FROM_SERVER:
                return itemsFreshness == ItemsFreshness.FROM_CACHE ? ItemsFreshness.FROM_CACHE : ItemsFreshness.FROM_SERVER;
            case FROM_CACHE:
                return ItemsFreshness.FROM_CACHE;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("No rule is specified for merging %s and %s", itemsFreshness, itemsFreshness2));
        }
    }

    public final boolean m9144a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems) {
        if (this.f9150d.isEmpty()) {
            return true;
        }
        ImmutableList immutableList = (ImmutableList) savedDashboardPaginatedSavedItems.f9121a.or(RegularImmutableList.a);
        int size = immutableList.size();
        if (this.f9150d.size() != size) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (!((SavedDashboardListItem) this.f9150d.get(i)).equals(immutableList.get(i))) {
                return true;
            }
        }
        return false;
    }

    private void m9139a(List<SavedDashboardListItem> list, int i) {
        while (i < list.size()) {
            if (((SavedDashboardListItem) list.get(i)).mo423a() == SavedDashboardListItemType.SAVED_DASHBOARD_LIST_SECTION_HEADER) {
                this.f9153g.add(Integer.valueOf(i));
            }
            i++;
        }
    }
}
