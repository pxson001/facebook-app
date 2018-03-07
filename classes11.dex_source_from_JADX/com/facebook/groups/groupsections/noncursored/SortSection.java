package com.facebook.groups.groupsections.noncursored;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.calls.OrderbyInputGroupsOrdering;
import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSection.FetchGroupSectionString;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: [J) */
public class SortSection extends AbstractGraphQLBackedSection {
    public final Comparator<GroupPogGridData> f10291b = new C12081(this);
    public final Comparator<GroupPogGridData> f10292c = new C12092(this);
    public final Comparator<GroupPogGridData> f10293d = new C12103(this);
    public FilteredGroupsSectionOrdering f10294e = FilteredGroupsSectionOrdering.RECENTLY_VISITED;

    /* compiled from: [J) */
    class C12081 implements Comparator<GroupPogGridData> {
        final /* synthetic */ SortSection f10287a;

        C12081(SortSection sortSection) {
            this.f10287a = sortSection;
        }

        public int compare(Object obj, Object obj2) {
            return ((GroupPogGridData) obj).f10224b.compareToIgnoreCase(((GroupPogGridData) obj2).f10224b);
        }
    }

    /* compiled from: [J) */
    class C12092 implements Comparator<GroupPogGridData> {
        final /* synthetic */ SortSection f10288a;

        C12092(SortSection sortSection) {
            this.f10288a = sortSection;
        }

        public int compare(Object obj, Object obj2) {
            return SortSection.m10664b(((GroupPogGridData) obj).f10226d, ((GroupPogGridData) obj2).f10226d);
        }
    }

    /* compiled from: [J) */
    class C12103 implements Comparator<GroupPogGridData> {
        final /* synthetic */ SortSection f10289a;

        C12103(SortSection sortSection) {
            this.f10289a = sortSection;
        }

        public int compare(Object obj, Object obj2) {
            return SortSection.m10664b(((GroupPogGridData) obj).f10227e, ((GroupPogGridData) obj2).f10227e);
        }
    }

    public static SortSection m10665b(InjectorLike injectorLike) {
        return new SortSection(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* synthetic */ Enum mo286c() {
        return mo287i();
    }

    @Inject
    public SortSection(Resources resources) {
        super(resources);
    }

    public final GroupSections mo287i() {
        return GroupSections.FILTERED_GROUPS_SECTION;
    }

    protected final ArrayList<GroupPogGridData> mo284a(ArrayList<GroupPogGridData> arrayList) {
        Comparator comparator;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GroupPogGridData groupPogGridData = (GroupPogGridData) it.next();
            if (!groupPogGridData.f10232j || groupPogGridData.f10230h || groupPogGridData.f10229g) {
                it.remove();
            }
        }
        switch (this.f10294e) {
            case ALPHABETICAL:
                comparator = this.f10291b;
                break;
            case LATEST_ACTIVITY:
                comparator = this.f10293d;
                break;
            default:
                comparator = this.f10292c;
                break;
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    protected final FetchGroupSectionString mo285b(int i) {
        OrderbyInputGroupsOrdering orderbyInputGroupsOrdering;
        FetchGroupSectionString b = super.mo285b(i);
        String str = "order";
        switch (this.f10294e) {
            case ALPHABETICAL:
                orderbyInputGroupsOrdering = OrderbyInputGroupsOrdering.NAME;
                break;
            case LATEST_ACTIVITY:
                orderbyInputGroupsOrdering = OrderbyInputGroupsOrdering.LAST_ACTIVITY_TIME;
                break;
            default:
                orderbyInputGroupsOrdering = OrderbyInputGroupsOrdering.VIEWER_VISITATION;
                break;
        }
        b.a(str, orderbyInputGroupsOrdering);
        b.a("has_hidden", Boolean.valueOf(false));
        b.a("has_favorited", Boolean.valueOf(false));
        b.a("recently_added", Boolean.valueOf(false));
        return b;
    }

    public static int m10664b(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        if (j > j2) {
            return -1;
        }
        return 1;
    }
}
