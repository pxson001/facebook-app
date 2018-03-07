package com.facebook.groups.feed.data;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.ForSaleInputForSaleAvailability;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryCommerceModifier.Builder;
import com.facebook.search.api.GraphSearchQueryTabModifier;
import com.facebook.search.util.GraphSearchConfig;

/* compiled from: faceweb/f?href=/browse/page_tips */
public class GroupsGraphSearchHelper {
    private static GraphSearchQuery m15632a(FetchGroupInformationModel fetchGroupInformationModel, String str, ScopedSearchStyle scopedSearchStyle, GraphSearchConfig graphSearchConfig) {
        boolean z;
        boolean z2 = false;
        if (fetchGroupInformationModel == null) {
            z = true;
        } else {
            DraculaReturnValue b = fetchGroupInformationModel.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (z) {
            return GraphSearchQuery.e;
        }
        if (fetchGroupInformationModel.p() != GraphQLGroupJoinState.MEMBER) {
            b = fetchGroupInformationModel.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.f(i, 17, GraphQLGroupVisibility.class) != GraphQLGroupVisibility.OPEN;
        } else {
            z = false;
        }
        if (z || !graphSearchConfig.f8906g) {
            scopedSearchStyle = ScopedSearchStyle.SINGLE_STATE;
        }
        b = fetchGroupInformationModel.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        String k = mutableFlatBuffer.k(i, 13);
        ScopedEntityType scopedEntityType = ScopedEntityType.GROUP;
        String valueOf = String.valueOf(str);
        if (ScopedSearchStyle.TAB == scopedSearchStyle) {
            z2 = true;
        }
        GraphSearchQuery a = GraphSearchQuery.a(scopedEntityType, valueOf, k, scopedSearchStyle, z2);
        if (!GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(fetchGroupInformationModel))) {
            return a;
        }
        ModifierKeys modifierKeys = ModifierKeys.GROUP_COMMERCE;
        Builder builder = new Builder();
        builder.a = true;
        builder = builder;
        builder.b = true;
        Builder builder2 = builder;
        builder2.c = ForSaleInputForSaleAvailability.AVAILABLE;
        a.a(modifierKeys, builder2.a());
        return a;
    }

    public static GraphSearchQuery m15633b(FetchGroupInformationModel fetchGroupInformationModel, String str, boolean z, GraphSearchConfig graphSearchConfig) {
        GraphSearchQuery a = m15632a(fetchGroupInformationModel, str, ScopedSearchStyle.TAB, graphSearchConfig);
        ModifierKeys modifierKeys = ModifierKeys.SCOPED_TAB;
        GraphSearchQueryTabModifier.Builder builder = new GraphSearchQueryTabModifier.Builder();
        builder.a = z;
        a.a(modifierKeys, builder.a());
        return a;
    }
}
