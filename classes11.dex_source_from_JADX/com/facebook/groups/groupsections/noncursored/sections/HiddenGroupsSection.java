package com.facebook.groups.groupsections.noncursored.sections;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSection.FetchGroupSectionString;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: Xo8WBi6jzSxKDVR4drqm84yr9iU */
public class HiddenGroupsSection extends AbstractGraphQLBackedSection {
    public static HiddenGroupsSection m10736b(InjectorLike injectorLike) {
        return new HiddenGroupsSection(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* synthetic */ Enum mo286c() {
        return mo287i();
    }

    @Inject
    public HiddenGroupsSection(Resources resources) {
        super(resources);
    }

    public final GroupSections mo287i() {
        return GroupSections.HIDDEN_GROUPS_SECTION;
    }

    protected final ArrayList<GroupPogGridData> mo284a(ArrayList<GroupPogGridData> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            GroupPogGridData groupPogGridData = (GroupPogGridData) arrayList.get(i);
            if (!groupPogGridData.f10232j || groupPogGridData.f10229g || !groupPogGridData.f10230h) {
                arrayList.remove(groupPogGridData);
            }
        }
        return arrayList;
    }

    protected final FetchGroupSectionString mo285b(int i) {
        FetchGroupSectionString b = super.mo285b(i);
        b.a("has_favorited", Boolean.valueOf(false));
        b.a("has_hidden", Boolean.valueOf(true));
        return b;
    }
}
