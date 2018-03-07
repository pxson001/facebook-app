package com.facebook.timeline.aboutpage.model;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContactItemType;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionItemContainingMutationFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionSuggestionContainingMutationFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemContainingMutationFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemContainingMutationFieldsModel.Builder;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionSuggestionContainingMutationFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionSuggestionFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionItemNodeFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionItemNodeFieldsModel.AddressModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsFirstFiveGroupMembersFieldsModel.GroupMembersModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: Max date cannot be before min date. */
public class TimelineAppCollectionItemNode {
    public final String f13150a;
    public final String f13151b;
    public final String f13152c;
    public final GroupMembersModel f13153d;
    public final GraphQLTimelineAppSectionType f13154e;
    public final GraphQLTimelineContactItemType f13155f;
    public final AddressModel f13156g;
    public final GraphQLObjectType f13157h;
    private GroupJoinStatus f13158i;
    private GraphQLFriendshipStatus f13159j;
    private GraphQLSubscribeStatus f13160k;
    public boolean f13161l;
    public final ImmutableList<? extends SavableTimelineAppCollection> f13162m;
    private ImmutableList<? extends SavableTimelineAppCollection> f13163n;
    private AppCollectionItemContainingMutationFields f13164o;
    private AppCollectionSuggestionContainingMutationFields f13165p;

    private TimelineAppCollectionItemNode(String str, CollectionItemNodeFieldsModel collectionItemNodeFieldsModel, AppCollectionItemContainingMutationFields appCollectionItemContainingMutationFields) {
        Preconditions.checkNotNull(collectionItemNodeFieldsModel);
        this.f13150a = str;
        this.f13151b = collectionItemNodeFieldsModel.m14374g();
        this.f13152c = collectionItemNodeFieldsModel.m14375j();
        this.f13153d = collectionItemNodeFieldsModel.nO_();
        this.f13158i = GroupJoinStatus.fromString(collectionItemNodeFieldsModel.m14378m().name());
        this.f13159j = collectionItemNodeFieldsModel.m14373d();
        this.f13160k = collectionItemNodeFieldsModel.m14377l();
        this.f13161l = collectionItemNodeFieldsModel.nM_();
        this.f13162m = collectionItemNodeFieldsModel.m14380o();
        this.f13163n = collectionItemNodeFieldsModel.m14379n();
        if (appCollectionItemContainingMutationFields == null) {
            appCollectionItemContainingMutationFields = new Builder().m14214a();
        }
        this.f13164o = appCollectionItemContainingMutationFields;
        this.f13165p = null;
        this.f13154e = collectionItemNodeFieldsModel.m14376k();
        this.f13155f = collectionItemNodeFieldsModel.nN_();
        this.f13156g = collectionItemNodeFieldsModel.m14372c();
        this.f13157h = collectionItemNodeFieldsModel.m14371b();
    }

    public TimelineAppCollectionItemNode(AppCollectionItemModel appCollectionItemModel) {
        this(appCollectionItemModel.mo384d(), appCollectionItemModel.nH_(), appCollectionItemModel);
    }

    public TimelineAppCollectionItemNode(AppCollectionSuggestionFieldsModel appCollectionSuggestionFieldsModel) {
        Preconditions.checkNotNull(appCollectionSuggestionFieldsModel);
        this.f13150a = appCollectionSuggestionFieldsModel.mo386b();
        this.f13151b = appCollectionSuggestionFieldsModel.mo386b();
        this.f13152c = null;
        this.f13153d = null;
        this.f13158i = null;
        this.f13159j = null;
        this.f13160k = null;
        this.f13161l = false;
        this.f13162m = appCollectionSuggestionFieldsModel.m14329l();
        this.f13163n = appCollectionSuggestionFieldsModel.m14328k();
        this.f13164o = null;
        this.f13165p = AppCollectionSuggestionFieldsModel.m14315a(appCollectionSuggestionFieldsModel);
        this.f13154e = null;
        this.f13155f = null;
        this.f13156g = null;
        this.f13157h = appCollectionSuggestionFieldsModel.m14325d();
    }

    @Nullable
    public final SavableTimelineAppCollection m13936b() {
        if (this.f13164o != null) {
            Object g = this.f13164o.mo385g();
        } else {
            String c = this.f13165p.mo387c();
        }
        if (g != null) {
            int size = this.f13162m.size();
            for (int i = 0; i < size; i++) {
                SavableTimelineAppCollection savableTimelineAppCollection = (SavableTimelineAppCollection) this.f13162m.get(i);
                if (Objects.equal(g, savableTimelineAppCollection.b())) {
                    return savableTimelineAppCollection;
                }
            }
        }
        if (this.f13163n.isEmpty()) {
            return null;
        }
        return (SavableTimelineAppCollection) this.f13163n.get(0);
    }

    public final boolean m13937c() {
        if (this.f13164o != null) {
            if (StringUtil.a(this.f13164o.mo385g())) {
                return false;
            }
            return true;
        } else if (StringUtil.a(this.f13165p.mo387c())) {
            return false;
        } else {
            return true;
        }
    }

    public final void m13932a(@Nullable SavableTimelineAppCollection savableTimelineAppCollection) {
        if (savableTimelineAppCollection == null) {
            m13931a(null);
            return;
        }
        boolean z;
        int size = this.f13162m.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equal(savableTimelineAppCollection.b(), ((SavableTimelineAppCollection) this.f13162m.get(i)).b())) {
                z = true;
                break;
            }
        }
        z = false;
        Preconditions.checkState(z, "Trying to set a non-supported collection!");
        m13931a(savableTimelineAppCollection.b());
    }

    private void m13931a(String str) {
        if (this.f13164o != null) {
            AppCollectionItemContainingMutationFieldsModel a = AppCollectionItemContainingMutationFieldsModel.m14217a(this.f13164o);
            Builder builder = new Builder();
            builder.f13240a = a.mo384d();
            builder.f13241b = a.mo385g();
            Builder builder2 = builder;
            builder2.f13241b = str;
            this.f13164o = builder2.m14214a();
            return;
        }
        AppCollectionSuggestionContainingMutationFieldsModel a2 = AppCollectionSuggestionContainingMutationFieldsModel.m14304a(this.f13165p);
        AppCollectionSuggestionContainingMutationFieldsModel.Builder builder3 = new AppCollectionSuggestionContainingMutationFieldsModel.Builder();
        builder3.f13300a = a2.mo386b();
        builder3.f13301b = a2.mo387c();
        AppCollectionSuggestionContainingMutationFieldsModel.Builder builder4 = builder3;
        builder4.f13301b = str;
        this.f13165p = builder4.m14301a();
    }

    public final GraphQLFriendshipStatus m13938f() {
        return this.f13159j != null ? this.f13159j : GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public final void m13933a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (graphQLFriendshipStatus == null) {
            this.f13159j = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        } else {
            this.f13159j = graphQLFriendshipStatus;
        }
    }

    public final GraphQLSubscribeStatus m13939g() {
        return this.f13160k != null ? this.f13160k : GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public final void m13934a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (graphQLSubscribeStatus == null) {
            this.f13160k = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        } else {
            this.f13160k = graphQLSubscribeStatus;
        }
    }

    public final GroupJoinStatus m13940i() {
        return this.f13158i != null ? this.f13158i : GroupJoinStatus.UNKNOWN;
    }

    public final void m13935a(GroupJoinStatus groupJoinStatus) {
        if (groupJoinStatus == null) {
            this.f13158i = GroupJoinStatus.UNKNOWN;
        } else {
            this.f13158i = groupJoinStatus;
        }
    }
}
