package com.facebook.groups.groupsgrid.adapter;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.groups.editfavorites.intent.GroupEditFavoritesIntentBuilder;
import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.groupsgrid.adapter.Enums.ViewTypes;
import com.facebook.groups.groupsgrid.fragment.AbstractGroupsPogGridFragment.C12202;
import com.facebook.groups.groupsgrid.utils.ResizeValues;
import com.facebook.groups.groupsgrid.view.GroupsSectionedGridSectionHeader;
import com.facebook.groups.groupsgrid.view.SectionNullStateView;
import com.facebook.groups.groupsgrid.viewholder.GroupPogViewHolder;
import com.facebook.groups.groupsgrid.viewholder.GroupSectionHeaderViewHolder;
import com.facebook.groups.groupsgrid.viewholder.SectionNullStateViewHolder;
import com.facebook.groups.groupsgrid.viewholder.SectionTailLoadingIndicatorViewHolder;
import com.facebook.groups.preferences.GroupsPrefKeys;
import com.facebook.groups.preferences.GroupsPreferenceHelper;
import com.facebook.groups.widget.groupgriditem.GroupsGroupGridItemView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: X-Origin-Hit */
public class GroupsRecyclerViewSectionedGridAdapter extends Adapter<ViewHolder> {
    private static final Class<?> f10326a = GroupsRecyclerViewSectionedGridAdapter.class;
    private static final FilteredGroupsSectionOrdering f10327b = FilteredGroupsSectionOrdering.RECENTLY_VISITED;
    public final SectionState f10328c = new SectionState(this);
    public final C12202 f10329d;
    public final GroupsPreferenceHelper f10330e;
    private final GroupEditFavoritesIntentBuilder f10331f;
    private final Resources f10332g;
    public final SecureContextHelper f10333h;
    private ResizeValues f10334i;
    public int f10335j;
    @Nullable
    public HashMap<GroupSections, GroupsSectionInterface> f10336k;
    @Nullable
    public WeakReference<PopoverMenuWindow> f10337l;

    /* compiled from: X-Origin-Hit */
    class C12132 implements OnClickListener {
        final /* synthetic */ GroupsRecyclerViewSectionedGridAdapter f10318a;

        C12132(GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter) {
            this.f10318a = groupsRecyclerViewSectionedGridAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -217012416);
            GroupsRecyclerViewSectionedGridAdapter.m10743a(this.f10318a, view);
            Logger.a(2, EntryType.UI_INPUT_END, -1772584074, a);
        }
    }

    /* compiled from: X-Origin-Hit */
    class C12165 implements OnDismissListener {
        final /* synthetic */ GroupsRecyclerViewSectionedGridAdapter f10324a;

        C12165(GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter) {
            this.f10324a = groupsRecyclerViewSectionedGridAdapter;
        }

        public final boolean m10742a(PopoverWindow popoverWindow) {
            this.f10324a.f10337l = null;
            return false;
        }
    }

    /* compiled from: X-Origin-Hit */
    class EmptyViewHolder extends ViewHolder {
        EmptyViewHolder(View view) {
            super(view);
        }
    }

    @Inject
    public GroupsRecyclerViewSectionedGridAdapter(@Assisted ResizeValues resizeValues, SecureContextHelper secureContextHelper, GroupsPreferenceHelper groupsPreferenceHelper, @Assisted C12202 c12202, GroupEditFavoritesIntentBuilder groupEditFavoritesIntentBuilder, Resources resources) {
        this.f10333h = secureContextHelper;
        this.f10330e = groupsPreferenceHelper;
        this.f10332g = resources;
        this.f10334i = resizeValues;
        this.f10329d = c12202;
        this.f10331f = groupEditFavoritesIntentBuilder;
    }

    public final void a_(RecyclerView recyclerView) {
        super.a_(recyclerView);
        recyclerView.getRecycledViewPool().a(ViewTypes.POG.ordinal(), this.f10334i.f10357b * (this.f10334i.f10358c + 2));
    }

    @Nullable
    public final GroupPogGridData m10752e(int i) {
        if (!m10745f() || m10754f(i)) {
            return null;
        }
        GroupSections g = m10746g(i);
        int h = m10747h(i);
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10336k.get(g);
        if (abstractGraphQLBackedSection != null) {
            try {
                if (abstractGraphQLBackedSection.m10614f() && h != -1) {
                    return abstractGraphQLBackedSection.m10604a(h);
                }
            } catch (Throwable e) {
                BLog.b(f10326a, "CursorIndexOutOfBoundsException ", e);
            }
        }
        BLog.b(f10326a, "getGridItemData failed");
        return null;
    }

    public final boolean m10754f(int i) {
        return getItemViewType(i) != ViewTypes.POG.ordinal();
    }

    public final FilteredGroupsSectionOrdering m10751d() {
        return FilteredGroupsSectionOrdering.valueOf(this.f10330e.a(GroupsPrefKeys.f, f10327b.name()));
    }

    @Nullable
    private GroupSections m10746g(int i) {
        if (!m10745f()) {
            return null;
        }
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10336k.get(GroupSections.HIDDEN_GROUPS_SECTION);
        if (abstractGraphQLBackedSection != null && !abstractGraphQLBackedSection.f10219c && this.f10328c.f10344f != -1 && i > this.f10328c.f10344f) {
            return GroupSections.HIDDEN_GROUPS_SECTION;
        }
        if (i > this.f10328c.f10341c) {
            return GroupSections.FILTERED_GROUPS_SECTION;
        }
        if (this.f10328c.f10343e == -1 || i <= this.f10328c.f10343e) {
            return i > this.f10328c.f10339a ? GroupSections.FAVORITES_SECTION : null;
        } else {
            return GroupSections.RECENTLY_JOINED_SECTION;
        }
    }

    private int m10747h(int i) {
        int i2 = 0;
        GroupSections g = m10746g(i);
        if (g != null) {
            int i3;
            int i4;
            if (this.f10328c.f10340b != -1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.f10328c.f10342d != -1) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (this.f10328c.f10341c != -1) {
                i2 = this.f10328c.f10341c + 1;
            }
            switch (g) {
                case FAVORITES_SECTION:
                    return (i - 1) - i3;
                case RECENTLY_JOINED_SECTION:
                    return (i - this.f10328c.f10343e) - 1;
                case FILTERED_GROUPS_SECTION:
                    return (i - i2) - i4;
                case HIDDEN_GROUPS_SECTION:
                    return (i - this.f10328c.f10344f) - 1;
            }
        }
        return -1;
    }

    public final ViewHolder m10749a(ViewGroup viewGroup, int i) {
        if (i == ViewTypes.POG.ordinal()) {
            GroupsGroupGridItemView groupsGroupGridItemView = new GroupsGroupGridItemView(viewGroup.getContext());
            groupsGroupGridItemView.t = true;
            return new GroupPogViewHolder(groupsGroupGridItemView);
        } else if (i == ViewTypes.FAVORITES_SECTION_HEADER.ordinal() || i == ViewTypes.FILTERED_GROUPS_SECTION_HEADER.ordinal() || i == ViewTypes.RECENTLY_JOINED_SECTION_HEADER.ordinal() || i == ViewTypes.HIDDEN_GROUPS_SECTION_HEADER.ordinal()) {
            return new GroupSectionHeaderViewHolder(new GroupsSectionedGridSectionHeader(viewGroup.getContext()));
        } else {
            if (i == ViewTypes.FILTERED_GROUPS_NULL_STATE.ordinal() || i == ViewTypes.FAVORITES_NULL_STATE.ordinal() || i == ViewTypes.GENERAL_NULL_STATE.ordinal()) {
                return new SectionNullStateViewHolder(new SectionNullStateView(viewGroup.getContext()));
            }
            if (i == ViewTypes.SECTION_LOADING.ordinal()) {
                return new SectionTailLoadingIndicatorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130904740, viewGroup, false));
            }
            return new EmptyViewHolder(new View(viewGroup.getContext()));
        }
    }

    public final void m10750a(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == ViewTypes.FAVORITES_NULL_STATE.ordinal() || itemViewType == ViewTypes.FILTERED_GROUPS_NULL_STATE.ordinal() || itemViewType == ViewTypes.GENERAL_NULL_STATE.ordinal()) {
            SectionNullStateViewHolder sectionNullStateViewHolder = (SectionNullStateViewHolder) viewHolder;
            if (itemViewType == ViewTypes.FILTERED_GROUPS_NULL_STATE.ordinal()) {
                sectionNullStateViewHolder.f10375l.m10774a(2131242522);
            } else if (itemViewType == ViewTypes.FAVORITES_NULL_STATE.ordinal()) {
                sectionNullStateViewHolder.f10375l.m10774a(2131242521);
            } else if (itemViewType == ViewTypes.GENERAL_NULL_STATE.ordinal()) {
                sectionNullStateViewHolder.f10375l.m10774a(2131242523);
            }
        } else if (itemViewType == ViewTypes.FAVORITES_SECTION_HEADER.ordinal() || itemViewType == ViewTypes.FILTERED_GROUPS_SECTION_HEADER.ordinal() || itemViewType == ViewTypes.RECENTLY_JOINED_SECTION_HEADER.ordinal() || itemViewType == ViewTypes.HIDDEN_GROUPS_SECTION_HEADER.ordinal()) {
            m10744a((GroupSectionHeaderViewHolder) viewHolder, itemViewType);
        } else if (itemViewType == ViewTypes.SECTION_LOADING.ordinal()) {
            GroupSections a = this.f10328c.m10763a(i);
            if (a != null && this.f10336k != null && this.f10336k.get(a) != null) {
                ((SectionTailLoadingIndicatorViewHolder) viewHolder).f10376l.setVisibility(((AbstractGraphQLBackedSection) this.f10336k.get(a)).f10220d ? 0 : 8);
            }
        } else if (itemViewType == ViewTypes.POG.ordinal()) {
            GroupPogGridData e = m10752e(i);
            if (e != null) {
                GroupPogViewHolder groupPogViewHolder = (GroupPogViewHolder) viewHolder;
                if (m10746g(i).equals(GroupSections.FAVORITES_SECTION)) {
                    groupPogViewHolder.f10373l.setId(2131558845);
                } else {
                    groupPogViewHolder.f10373l.setId(2131558844);
                }
                groupPogViewHolder.f10373l.a(e, Double.valueOf(this.f10334i.f10356a).doubleValue());
                return;
            }
            BLog.b(f10326a, "Tried to bind pog to null object, skipping.");
        }
    }

    private static int m10748i(int i) {
        if (i == ViewTypes.FAVORITES_SECTION_HEADER.ordinal()) {
            return 2131558846;
        }
        if (i == ViewTypes.FILTERED_GROUPS_SECTION_HEADER.ordinal()) {
            return 2131558847;
        }
        return 2131558848;
    }

    private void m10744a(final GroupSectionHeaderViewHolder groupSectionHeaderViewHolder, int i) {
        GroupsSectionedGridSectionHeader groupsSectionedGridSectionHeader;
        int i2;
        String string;
        C12121 c12121;
        String str;
        C12121 c121212;
        GroupsSectionedGridSectionHeader groupsSectionedGridSectionHeader2;
        OnClickListener onClickListener;
        Drawable drawable;
        int i3;
        String str2;
        boolean z = false;
        Drawable drawable2 = null;
        if (i == ViewTypes.FAVORITES_SECTION_HEADER.ordinal()) {
            String string2;
            final Intent a = this.f10331f.m10474a();
            groupsSectionedGridSectionHeader = groupSectionHeaderViewHolder.f10374l;
            i2 = m10748i(i);
            string = this.f10332g.getString(2131242514);
            if (a != null) {
                string2 = this.f10332g.getString(2131242518);
            } else {
                string2 = null;
            }
            c12121 = new OnClickListener(this) {
                final /* synthetic */ GroupsRecyclerViewSectionedGridAdapter f10317b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1368913307);
                    if (a != null) {
                        this.f10317b.f10333h.a(a, view.getContext());
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1529240158, a);
                }
            };
            str = string2;
            c121212 = c12121;
        } else {
            if (i == ViewTypes.RECENTLY_JOINED_SECTION_HEADER.ordinal()) {
                groupsSectionedGridSectionHeader = groupSectionHeaderViewHolder.f10374l;
                i2 = m10748i(i);
                string = this.f10332g.getString(2131242515);
                z = SectionState.m10760a(this.f10336k);
                str = string;
                groupsSectionedGridSectionHeader2 = groupsSectionedGridSectionHeader;
                string = null;
                onClickListener = null;
                int i4 = i2;
                drawable = null;
                i3 = i4;
            } else if (i == ViewTypes.FILTERED_GROUPS_SECTION_HEADER.ordinal()) {
                groupsSectionedGridSectionHeader2 = groupSectionHeaderViewHolder.f10374l;
                i3 = m10748i(i);
                str = this.f10332g.getString(Helper.m10756a(m10751d(), false));
                string = this.f10332g.getString(2131242517);
                drawable = this.f10332g.getDrawable(2130838448);
                onClickListener = new C12132(this);
                if (SectionState.m10760a(this.f10336k) || this.f10328c.f10343e != -1) {
                    z = true;
                }
                groupsSectionedGridSectionHeader2.m10772a(i3, str, string, drawable, onClickListener, z);
                return;
            } else if (i == ViewTypes.HIDDEN_GROUPS_SECTION_HEADER.ordinal()) {
                final boolean b = SectionState.m10761b(this.f10336k);
                groupsSectionedGridSectionHeader = groupSectionHeaderViewHolder.f10374l;
                i2 = m10748i(i);
                string = this.f10332g.getString(2131242516);
                str = b ? this.f10332g.getString(2131242519) : this.f10332g.getString(2131242520);
                Drawable drawable3 = b ? this.f10332g.getDrawable(2130838448) : this.f10332g.getDrawable(2130843822);
                C12143 c12143 = new OnClickListener(this) {
                    final /* synthetic */ GroupsRecyclerViewSectionedGridAdapter f10321c;

                    public void onClick(View view) {
                        boolean z;
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1812459489);
                        C12202 c12202 = this.f10321c.f10329d;
                        if (b) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int e = groupSectionHeaderViewHolder.e();
                        c12202.f10349a.as().mo281a(GroupSections.HIDDEN_GROUPS_SECTION, z);
                        if (!z) {
                            c12202.f10349a.f10178g.b(e + 1);
                        }
                        LogUtils.a(1434818331, a);
                    }
                };
                C12143 c121432;
                if (!SectionState.m10760a(this.f10336k) && this.f10328c.f10343e == -1 && this.f10328c.f10341c == -1) {
                    c121432 = c12143;
                    drawable2 = drawable3;
                    Object obj = c121432;
                } else {
                    z = true;
                    c121432 = c12143;
                    i3 = i2;
                    drawable = drawable3;
                    groupsSectionedGridSectionHeader2 = groupsSectionedGridSectionHeader;
                    Object obj2 = c121432;
                    str2 = string;
                    string = str;
                    str = str2;
                }
            } else {
                return;
            }
            groupsSectionedGridSectionHeader2.m10772a(i3, str, string, drawable, onClickListener, z);
        }
        c12121 = c121212;
        groupsSectionedGridSectionHeader2 = groupsSectionedGridSectionHeader;
        onClickListener = c12121;
        str2 = str;
        str = string;
        string = str2;
        int i5 = i2;
        drawable = drawable2;
        i3 = i5;
        groupsSectionedGridSectionHeader2.m10772a(i3, str, string, drawable, onClickListener, z);
    }

    public final int aZ_() {
        if (!m10745f()) {
            return 0;
        }
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10336k.get(GroupSections.FAVORITES_SECTION);
        AbstractGraphQLBackedSection abstractGraphQLBackedSection2 = (AbstractGraphQLBackedSection) this.f10336k.get(GroupSections.FILTERED_GROUPS_SECTION);
        int i = 0;
        for (AbstractGraphQLBackedSection abstractGraphQLBackedSection3 : this.f10336k.values()) {
            int i2;
            if (Helper.m10757a(abstractGraphQLBackedSection3)) {
                i++;
            } else {
                if (abstractGraphQLBackedSection != null && abstractGraphQLBackedSection == abstractGraphQLBackedSection3 && abstractGraphQLBackedSection.m10614f() && SectionState.m10760a(this.f10336k)) {
                    i += 1 + 1;
                }
                if (abstractGraphQLBackedSection2 == abstractGraphQLBackedSection3 && abstractGraphQLBackedSection2.m10614f() && abstractGraphQLBackedSection != null && !abstractGraphQLBackedSection.m10612d()) {
                    i += 1 + 1;
                }
            }
            if (abstractGraphQLBackedSection3.f10219c) {
                i -= abstractGraphQLBackedSection3.m10603a();
            }
            if (this.f10328c.m10762a(abstractGraphQLBackedSection3.mo286c()) == -1 || abstractGraphQLBackedSection3.f10219c) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        return this.f10335j + i;
    }

    public int getItemViewType(int i) {
        if (!m10745f()) {
            return ViewTypes.LOADING.ordinal();
        }
        if (i == this.f10328c.f10339a) {
            return ViewTypes.FAVORITES_SECTION_HEADER.ordinal();
        }
        if (i == this.f10328c.f10341c) {
            return ViewTypes.FILTERED_GROUPS_SECTION_HEADER.ordinal();
        }
        if (i == this.f10328c.f10343e) {
            return ViewTypes.RECENTLY_JOINED_SECTION_HEADER.ordinal();
        }
        if (i == this.f10328c.f10344f) {
            return ViewTypes.HIDDEN_GROUPS_SECTION_HEADER.ordinal();
        }
        if (i == this.f10328c.f10345g) {
            return ViewTypes.GENERAL_NULL_STATE.ordinal();
        }
        if (i == this.f10328c.f10340b) {
            return ViewTypes.FAVORITES_NULL_STATE.ordinal();
        }
        if (i == this.f10328c.f10342d) {
            return ViewTypes.FILTERED_GROUPS_NULL_STATE.ordinal();
        }
        Object obj;
        if (this.f10328c.m10763a(i) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return ViewTypes.SECTION_LOADING.ordinal();
        }
        if (i >= 0) {
            return ViewTypes.POG.ordinal();
        }
        return ViewTypes.INVALID.ordinal();
    }

    public final synchronized void m10753e() {
        if (!(this.f10337l == null || this.f10337l.get() == null)) {
            ((PopoverMenuWindow) this.f10337l.get()).l();
        }
    }

    public static synchronized void m10743a(GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter, View view) {
        synchronized (groupsRecyclerViewSectionedGridAdapter) {
            PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
            PopoverMenu c = popoverMenuWindow.c();
            c.a(groupsRecyclerViewSectionedGridAdapter.f10332g.getColorStateList(2131364102));
            FilteredGroupsSectionOrdering d = groupsRecyclerViewSectionedGridAdapter.m10751d();
            for (final FilteredGroupsSectionOrdering filteredGroupsSectionOrdering : FilteredGroupsSectionOrdering.values()) {
                int a = Helper.m10756a(filteredGroupsSectionOrdering, true);
                int a2 = Helper.m10755a(filteredGroupsSectionOrdering);
                MenuItemImpl a3 = c.a(a);
                a3.setIcon(a2);
                a3.setCheckable(true);
                a3.setChecked(filteredGroupsSectionOrdering.equals(d));
                a3.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsRecyclerViewSectionedGridAdapter) {
                    final /* synthetic */ GroupsRecyclerViewSectionedGridAdapter f10323b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter = this.f10323b;
                        FilteredGroupsSectionOrdering filteredGroupsSectionOrdering = filteredGroupsSectionOrdering;
                        if (filteredGroupsSectionOrdering != groupsRecyclerViewSectionedGridAdapter.m10751d()) {
                            GroupsPreferenceHelper groupsPreferenceHelper = groupsRecyclerViewSectionedGridAdapter.f10330e;
                            PrefKey prefKey = GroupsPrefKeys.f;
                            String name = filteredGroupsSectionOrdering.name();
                            if (!(prefKey == null || (name != null && groupsPreferenceHelper.a.a(prefKey) && groupsPreferenceHelper.a(prefKey, null).equals(name)))) {
                                groupsPreferenceHelper.a.edit().a(prefKey, name).commit();
                            }
                            C12202 c12202 = groupsRecyclerViewSectionedGridAdapter.f10329d;
                            c12202.f10349a.as().mo279a(c12202.f10349a.ao.m10751d());
                        }
                        return true;
                    }
                });
            }
            popoverMenuWindow.f(view);
            groupsRecyclerViewSectionedGridAdapter.f10337l = new WeakReference(popoverMenuWindow);
            popoverMenuWindow.a(new C12165(groupsRecyclerViewSectionedGridAdapter));
        }
    }

    private boolean m10745f() {
        if (this.f10336k == null) {
            return false;
        }
        for (AbstractGraphQLBackedSection f : this.f10336k.values()) {
            if (f.m10614f()) {
                return true;
            }
        }
        return false;
    }
}
