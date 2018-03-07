package com.facebook.friendsnearby.model;

import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyHighlightQuery;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyNewListSection;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyHighlightQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListSectionModel.TitleModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: _valueToSum */
public class FriendsNearbyNewRowSection extends FriendsNearbySection {
    private final boolean f20521a;
    private final String f20522d;
    private ImmutableList<FriendsNearbyRow> f20523e;

    public static FriendsNearbyNewRowSection m20922a(FriendsNearbyNewListSection friendsNearbyNewListSection, ImmutableSet<String> immutableSet, boolean z, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        String str;
        String b = friendsNearbyNewListSection.m21419b();
        Builder builder = ImmutableList.builder();
        ImmutableList a = friendsNearbyNewListSection.m21420c().m21407a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FriendsNearbyNewListItemModel friendsNearbyNewListItemModel = (FriendsNearbyNewListItemModel) a.get(i);
            FriendsNearbyNewListRow a2 = FriendsNearbyNewListRow.m20898a(friendsNearbyNewListItemModel, b, immutableSet.contains(friendsNearbyNewListItemModel.m21398c().m21375a().m21369b()), friendsNearbyNewListRowProvider);
            if (a2 != null) {
                builder.c(a2);
            }
        }
        TitleModel d = friendsNearbyNewListSection.m21421d();
        if (d == null) {
            str = "";
        } else {
            str = d.m21413a();
        }
        return new FriendsNearbyNewRowSection(str, b, builder.b(), z);
    }

    public static FriendsNearbyNewRowSection m20923a(List<FriendsNearbyHighlightQuery> list, String str, String str2, ImmutableSet<String> immutableSet, boolean z, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        Builder builder = ImmutableList.builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FriendsNearbyHighlightQueryModel friendsNearbyHighlightQueryModel = (FriendsNearbyHighlightQueryModel) it.next();
            FriendsNearbyNewListRow a = FriendsNearbyNewListRow.m20897a(friendsNearbyHighlightQueryModel, str2, immutableSet.contains(friendsNearbyHighlightQueryModel.m21217b()), friendsNearbyNewListRowProvider);
            if (a != null) {
                builder.c(a);
            }
        }
        return new FriendsNearbyNewRowSection(str, str2, builder.b(), z);
    }

    protected final List<FriendsNearbyRow> m20925d() {
        if (this.f20521a) {
            return this.f20523e.size() <= 3 ? this.f20523e : this.f20523e.subList(0, 3);
        } else {
            return this.f20523e;
        }
    }

    public final List<FriendsNearbyRow> m20926e() {
        return this.f20523e;
    }

    public final String mo922g() {
        return this.f20522d;
    }

    public FriendsNearbyNewRowSection(String str, String str2, ImmutableList<FriendsNearbyRow> immutableList, boolean z) {
        super(str);
        this.f20522d = str2;
        this.f20523e = immutableList;
        this.f20521a = z;
    }

    public final void mo921a(ImmutableList<FriendsNearbyRow> immutableList) {
        Builder builder = ImmutableList.builder();
        builder.b(this.f20523e);
        builder.b(immutableList);
        this.f20523e = builder.b();
    }
}
