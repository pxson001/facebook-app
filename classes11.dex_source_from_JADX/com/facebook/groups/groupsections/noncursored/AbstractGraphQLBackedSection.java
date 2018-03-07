package com.facebook.groups.groupsections.noncursored;

import android.content.res.Resources;
import com.facebook.common.build.BuildConstants;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSection.FetchGroupSectionString;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel.ActorModel.GroupsModel.PageInfoModel;
import com.facebook.uicontrib.pog.PogView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: \< */
public abstract class AbstractGraphQLBackedSection {
    public PageInfoModel f10217a;
    public ArrayList<GroupPogGridData> f10218b;
    public boolean f10219c;
    public boolean f10220d;
    private Resources f10221e;
    public HashMap<String, Integer> f10222f;

    protected abstract ArrayList<GroupPogGridData> mo284a(ArrayList<GroupPogGridData> arrayList);

    public abstract GroupSections mo287i();

    public /* synthetic */ Enum mo286c() {
        return mo287i();
    }

    public AbstractGraphQLBackedSection(Resources resources) {
        this.f10221e = resources;
    }

    public final int m10603a() {
        return this.f10218b != null ? this.f10218b.size() : 0;
    }

    public final int m10609b() {
        return m10603a();
    }

    @Nullable
    public final GroupPogGridData m10604a(int i) {
        if (i < this.f10218b.size()) {
            return (GroupPogGridData) this.f10218b.get(i);
        }
        return null;
    }

    public final boolean m10612d() {
        return !m10614f() || (this.f10217a.m10704j() && !Strings.isNullOrEmpty(this.f10217a.m10702a()));
    }

    public final boolean m10613e() {
        return m10614f() && m10603a() == 0;
    }

    public final boolean m10614f() {
        return this.f10217a != null;
    }

    protected FetchGroupSectionString mo285b(int i) {
        GraphQlQueryString fetchGroupSectionString = new FetchGroupSectionString();
        fetchGroupSectionString.a("group_item_small_cover_photo_size", String.valueOf(PogView.a(this.f10221e)));
        if (BuildConstants.j) {
            fetchGroupSectionString.a("exclude_work_communities", Boolean.valueOf(true));
        }
        if (m10614f()) {
            fetchGroupSectionString.a("end_cursor", this.f10217a.m10702a());
        }
        fetchGroupSectionString.a("count", Integer.valueOf(i));
        return fetchGroupSectionString;
    }

    public final void m10607a(ImmutableList<GroupPogGridData> immutableList, PageInfoModel pageInfoModel) {
        if (this.f10218b == null) {
            this.f10218b = new ArrayList();
        }
        int i = 0;
        while (i < immutableList.size()) {
            if (immutableList.get(i) != null && (this.f10222f == null || !this.f10222f.containsKey(((GroupPogGridData) immutableList.get(i)).f10223a))) {
                this.f10218b.add(immutableList.get(i));
            }
            i++;
        }
        this.f10218b = mo284a(this.f10218b);
        m10602l();
        this.f10217a = pageInfoModel;
    }

    public final void m10616j() {
        this.f10218b = null;
        this.f10222f = null;
        this.f10217a = null;
    }

    public final void m10606a(GroupPogGridData groupPogGridData) {
        if (groupPogGridData != null && this.f10218b != null && this.f10222f != null && this.f10222f.containsKey(groupPogGridData.f10223a)) {
            this.f10218b.remove(((Integer) this.f10222f.get(groupPogGridData.f10223a)).intValue());
            m10602l();
        }
    }

    public final void m10608a(String str, Integer num) {
        if (this.f10218b != null && this.f10222f != null && this.f10222f.containsKey(str)) {
            int intValue = ((Integer) this.f10222f.get(str)).intValue();
            GroupPogGridData groupPogGridData = (GroupPogGridData) this.f10218b.get(intValue);
            if (num == null || num.intValue() != intValue) {
                this.f10218b.remove(intValue);
                if (num == null || num.intValue() >= this.f10218b.size()) {
                    this.f10218b.add(groupPogGridData);
                } else {
                    this.f10218b.add(num.intValue(), groupPogGridData);
                }
                m10602l();
            }
        }
    }

    private void m10602l() {
        if (this.f10222f == null) {
            this.f10222f = new HashMap();
        } else {
            this.f10222f.clear();
        }
        for (int i = 0; i < this.f10218b.size(); i++) {
            this.f10222f.put(((GroupPogGridData) this.f10218b.get(i)).f10223a, Integer.valueOf(i));
        }
    }
}
