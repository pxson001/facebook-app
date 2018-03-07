package com.facebook.groups.editfavorites.adapter;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.groups.editfavorites.fragment.GroupsEditFavoritesFragment.C11792;
import com.facebook.groups.editfavorites.view.GroupEditFavoritesSectionHeaderView;
import com.facebook.groups.editfavorites.view.GroupFavoriteRowView;
import com.facebook.groups.editfavorites.view.GroupFavoriteRowView.C11831;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.widget.grouproundicon.GroupsEmptyDrawablePicker;
import com.facebook.widget.listview.DragSortListView.DragSortListAdapter;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.base.Strings;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: add_link_attachment */
public class GroupsEditFavoritesAdapter extends FbBaseAdapter implements DragSortListAdapter, StickyHeaderAdapter {
    public final EditFavoritesSectionsPositionManager f10104a;
    public HashMap<GroupSections, GroupsSectionInterface> f10105b = new HashMap();
    private Resources f10106c;
    public C11792 f10107d;

    /* compiled from: add_link_attachment */
    enum ViewTypes {
        FAVORITE_ROW,
        SECTION_HEADER
    }

    @Inject
    public GroupsEditFavoritesAdapter(EditFavoritesSectionsPositionManager editFavoritesSectionsPositionManager, Resources resources) {
        this.f10104a = editFavoritesSectionsPositionManager;
        this.f10106c = resources;
    }

    public final int m10449b() {
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10105b.get(GroupSections.FAVORITES_SECTION);
        if (abstractGraphQLBackedSection == null || EditFavoritesSectionsPositionManager.m10443a(abstractGraphQLBackedSection) == 0) {
            return -1;
        }
        return 1;
    }

    public final int m10451c() {
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10105b.get(GroupSections.FAVORITES_SECTION);
        if (abstractGraphQLBackedSection == null || EditFavoritesSectionsPositionManager.m10443a(abstractGraphQLBackedSection) == 0) {
            return -1;
        }
        return EditFavoritesSectionsPositionManager.m10443a(abstractGraphQLBackedSection) - 1;
    }

    public final View m10447a(int i, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i]) {
            case FAVORITE_ROW:
                return new GroupFavoriteRowView(viewGroup.getContext());
            case SECTION_HEADER:
                return new GroupEditFavoritesSectionHeaderView(viewGroup.getContext());
            default:
                return null;
        }
    }

    public final void m10448a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i2]) {
            case FAVORITE_ROW:
                GroupPogGridData groupPogGridData = (GroupPogGridData) obj;
                if (groupPogGridData != null) {
                    GroupFavoriteRowView groupFavoriteRowView = (GroupFavoriteRowView) view;
                    groupFavoriteRowView.f10135g = this.f10107d;
                    if (Strings.isNullOrEmpty(groupPogGridData.f10225c)) {
                        ((GenericDraweeHierarchy) groupFavoriteRowView.f10134f.getHierarchy()).b(GroupsEmptyDrawablePicker.a(true));
                        groupFavoriteRowView.f10134f.a(null, GroupFavoriteRowView.f10129b);
                    } else {
                        ((GenericDraweeHierarchy) groupFavoriteRowView.f10134f.getHierarchy()).b(null);
                        groupFavoriteRowView.f10134f.a(Uri.parse(groupPogGridData.f10225c), GroupFavoriteRowView.f10129b);
                    }
                    groupFavoriteRowView.f10133e.setText(groupPogGridData.f10224b);
                    if (groupPogGridData.f10229g) {
                        groupFavoriteRowView.f10131c.setVisibility(0);
                        groupFavoriteRowView.f10132d.setImageDrawable(groupFavoriteRowView.f10130a.getDrawable(2130840636));
                        groupFavoriteRowView.f10132d.setGlyphColor(groupFavoriteRowView.f10130a.getColor(2131364021));
                        groupFavoriteRowView.f10132d.setContentDescription(groupFavoriteRowView.f10130a.getString(2131242542));
                    } else {
                        groupFavoriteRowView.f10131c.setVisibility(4);
                        groupFavoriteRowView.f10132d.setImageDrawable(groupFavoriteRowView.f10130a.getDrawable(2130840635));
                        groupFavoriteRowView.f10132d.setGlyphColor(groupFavoriteRowView.f10130a.getColor(2131364020));
                        groupFavoriteRowView.f10132d.setContentDescription(groupFavoriteRowView.f10130a.getString(2131242541));
                    }
                    groupFavoriteRowView.f10132d.setOnClickListener(new C11831(groupFavoriteRowView, groupPogGridData));
                    return;
                }
                return;
            case SECTION_HEADER:
                ((GroupEditFavoritesSectionHeaderView) view).m10479a((String) obj);
                return;
            default:
                return;
        }
    }

    public int getCount() {
        EditFavoritesSectionsPositionManager editFavoritesSectionsPositionManager = this.f10104a;
        int i = 0;
        if (!editFavoritesSectionsPositionManager.f10101b.isEmpty()) {
            GroupSections[] values = GroupSections.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                int a;
                AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) editFavoritesSectionsPositionManager.f10101b.get(values[i2]);
                if (abstractGraphQLBackedSection != null) {
                    a = EditFavoritesSectionsPositionManager.m10443a(abstractGraphQLBackedSection) + i;
                } else {
                    a = i;
                }
                i2++;
                i = a;
            }
        }
        return i;
    }

    public Object getItem(int i) {
        EditFavoritesSectionsPositionManager editFavoritesSectionsPositionManager;
        if (this.f10104a.m10445b(i)) {
            String c;
            editFavoritesSectionsPositionManager = this.f10104a;
            if (editFavoritesSectionsPositionManager.m10445b(i)) {
                c = editFavoritesSectionsPositionManager.m10446c(i);
            } else {
                c = "";
            }
            return c;
        }
        GroupPogGridData groupPogGridData;
        if (this.f10104a.m10444a(i) == GroupSections.FAVORITES_SECTION) {
            i = i;
        }
        editFavoritesSectionsPositionManager = this.f10104a;
        if (editFavoritesSectionsPositionManager.m10445b(i)) {
            groupPogGridData = null;
        } else {
            GroupSections a = editFavoritesSectionsPositionManager.m10444a(i);
            if (a == null) {
                groupPogGridData = null;
            } else {
                int a2;
                AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) editFavoritesSectionsPositionManager.f10101b.get(a);
                int i2 = i;
                for (Object obj : GroupSections.values()) {
                    a2 = EditFavoritesSectionsPositionManager.m10443a((AbstractGraphQLBackedSection) editFavoritesSectionsPositionManager.f10101b.get(obj));
                    if (i2 < a2) {
                        a2 = i2;
                        break;
                    }
                    i2 -= a2;
                }
                a2 = -1;
                int i3 = a2;
                if (i3 == -1) {
                    groupPogGridData = null;
                } else {
                    groupPogGridData = abstractGraphQLBackedSection.m10604a(i3 - 1);
                }
            }
        }
        return groupPogGridData;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (this.f10104a.m10445b(i)) {
            return ViewTypes.SECTION_HEADER.ordinal();
        }
        return ViewTypes.FAVORITE_ROW.ordinal();
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final View m10450b(int i, View view, ViewGroup viewGroup) {
        View groupEditFavoritesSectionHeaderView;
        if (view == null) {
            groupEditFavoritesSectionHeaderView = new GroupEditFavoritesSectionHeaderView(viewGroup.getContext());
        } else {
            groupEditFavoritesSectionHeaderView = view;
        }
        ((GroupEditFavoritesSectionHeaderView) groupEditFavoritesSectionHeaderView).m10479a(this.f10104a.m10446c(i));
        return groupEditFavoritesSectionHeaderView;
    }

    public final int o_(int i) {
        return ViewTypes.SECTION_HEADER.ordinal();
    }

    public final int m10453e(int i) {
        return this.f10106c.getDimensionPixelSize(2131434717);
    }

    public final int m10452d() {
        return 0;
    }

    public final boolean m10454f(int i) {
        return this.f10104a.m10445b(i);
    }
}
