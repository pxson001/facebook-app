package com.facebook.groups.groupsections.noncursored.sections;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.calls.OrderbyInputGroupsOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSection.FetchGroupSectionString;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: YodaConditions */
public class FavoritesSection extends AbstractGraphQLBackedSection {
    public static FavoritesSection m10731b(InjectorLike injectorLike) {
        return new FavoritesSection(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* synthetic */ Enum mo286c() {
        return mo287i();
    }

    @Inject
    public FavoritesSection(Resources resources) {
        super(resources);
    }

    protected final FetchGroupSectionString mo285b(int i) {
        FetchGroupSectionString b = super.mo285b(i);
        b.a("has_favorited", Boolean.valueOf(true));
        b.a("order", OrderbyInputGroupsOrdering.APP_LANDING);
        return b;
    }

    public final GroupSections mo287i() {
        return GroupSections.FAVORITES_SECTION;
    }

    protected final ArrayList<GroupPogGridData> mo284a(ArrayList<GroupPogGridData> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            GroupPogGridData groupPogGridData = (GroupPogGridData) arrayList.get(i);
            if (!groupPogGridData.f10229g || !groupPogGridData.f10232j) {
                arrayList.remove(groupPogGridData);
            }
        }
        return arrayList;
    }
}
