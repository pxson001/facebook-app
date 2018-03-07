package com.facebook.groups.editfavorites.adapter;

import android.content.res.Resources;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin redirection */
public class EditFavoritesSectionsPositionManager {
    private final Resources f10100a;
    public HashMap<GroupSections, GroupsSectionInterface> f10101b = new HashMap();

    @Inject
    public EditFavoritesSectionsPositionManager(Resources resources) {
        this.f10100a = resources;
    }

    @Nullable
    public final GroupSections m10444a(int i) {
        for (GroupSections groupSections : GroupSections.values()) {
            int a = m10443a((AbstractGraphQLBackedSection) this.f10101b.get(groupSections));
            if (i < a && a != 0) {
                return groupSections;
            }
            i -= a;
        }
        return null;
    }

    public final boolean m10445b(int i) {
        GroupSections[] values = GroupSections.values();
        int length = values.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = values[i2];
            if (i == i3) {
                return true;
            }
            int a;
            AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10101b.get(obj);
            if (abstractGraphQLBackedSection != null) {
                a = m10443a(abstractGraphQLBackedSection) + i3;
            } else {
                a = i3;
            }
            i2++;
            i3 = a;
        }
        return false;
    }

    public final String m10446c(int i) {
        GroupSections a = m10444a(i);
        if (a != null) {
            switch (a) {
                case FILTERED_GROUPS_SECTION:
                    return this.f10100a.getString(2131242540);
                case FAVORITES_SECTION:
                    return this.f10100a.getString(2131242539);
            }
        }
        return "";
    }

    public static int m10443a(AbstractGraphQLBackedSection abstractGraphQLBackedSection) {
        if (abstractGraphQLBackedSection == null || abstractGraphQLBackedSection.m10613e()) {
            return 0;
        }
        return abstractGraphQLBackedSection.m10603a() + 1;
    }
}
