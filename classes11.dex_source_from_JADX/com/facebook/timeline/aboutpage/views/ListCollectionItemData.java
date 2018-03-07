package com.facebook.timeline.aboutpage.views;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.Builder;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.timeline.aboutpage.model.TimelineAppCollectionItemNode;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionSuggestionFieldsModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: Ljava/util/Collection */
public class ListCollectionItemData {
    public final String f13837a;
    public final DefaultTextWithEntitiesLongFields f13838b;
    public final DefaultTextWithEntitiesFields f13839c;
    public final DefaultImageFields f13840d;
    public final String f13841e;
    public final GraphQLObjectType f13842f;
    public final GraphQLTimelineAppSectionType f13843g;
    public final TimelineAppCollectionItemNode f13844h;
    public boolean f13845i;
    public boolean f13846j;
    public Action f13847k;
    public RequestStatus f13848l = RequestStatus.REQUEST_NONE;

    /* compiled from: Ljava/util/Collection */
    public enum RequestStatus {
        REQUEST_NONE,
        REQUEST_PENDING,
        REQUEST_FAILED
    }

    public ListCollectionItemData(String str, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, DefaultImageFields defaultImageFields, String str2, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, GraphQLObjectType graphQLObjectType, TimelineAppCollectionItemNode timelineAppCollectionItemNode, boolean z, boolean z2) {
        this.f13837a = str;
        this.f13838b = defaultTextWithEntitiesLongFields;
        this.f13839c = defaultTextWithEntitiesFields;
        this.f13840d = defaultImageFields;
        this.f13841e = str2;
        this.f13843g = graphQLTimelineAppSectionType;
        this.f13842f = graphQLObjectType;
        this.f13844h = timelineAppCollectionItemNode;
        this.f13845i = z;
        this.f13846j = z2;
    }

    public String toString() {
        return Objects.toStringHelper(ListCollectionItemData.class).add("id", this.f13837a).add("title", this.f13838b).toString();
    }

    public static ListCollectionItemData m14994a(AppCollectionItemModel appCollectionItemModel, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        String g;
        GraphQLObjectType b;
        if (appCollectionItemModel.nH_() != null) {
            g = appCollectionItemModel.nH_().m14374g();
            b = appCollectionItemModel.nH_().m14371b();
        } else {
            b = new GraphQLObjectType(0);
            g = null;
        }
        return new ListCollectionItemData(g, appCollectionItemModel.m14299l(), appCollectionItemModel.m14297j(), appCollectionItemModel.nI_(), appCollectionItemModel.m14300m(), graphQLTimelineAppSectionType, b, appCollectionItemModel.nH_() == null ? null : new TimelineAppCollectionItemNode(appCollectionItemModel), false, false);
    }

    public static ListCollectionItemData m14995a(AppCollectionSuggestionFieldsModel appCollectionSuggestionFieldsModel, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        Preconditions.checkNotNull(appCollectionSuggestionFieldsModel);
        Preconditions.checkNotNull(appCollectionSuggestionFieldsModel.m14325d());
        GraphQLObjectType d = appCollectionSuggestionFieldsModel.m14325d();
        DefaultTextWithEntitiesLongFields a = m14993a(appCollectionSuggestionFieldsModel.nK_());
        DefaultTextWithEntitiesFields defaultTextWithEntitiesFields = null;
        if (appCollectionSuggestionFieldsModel.m14325d() != null && appCollectionSuggestionFieldsModel.m14325d().g() == 2479791 && appCollectionSuggestionFieldsModel.nJ_() != null && !appCollectionSuggestionFieldsModel.nJ_().isEmpty()) {
            defaultTextWithEntitiesFields = m14993a((String) appCollectionSuggestionFieldsModel.nJ_().get(0));
        } else if (appCollectionSuggestionFieldsModel.m14325d() != null && appCollectionSuggestionFieldsModel.m14325d().g() == -1304042141) {
            defaultTextWithEntitiesFields = m14993a(appCollectionSuggestionFieldsModel.m14326g());
        }
        return new ListCollectionItemData(appCollectionSuggestionFieldsModel.mo386b(), a, defaultTextWithEntitiesFields, appCollectionSuggestionFieldsModel.nL_(), appCollectionSuggestionFieldsModel.m14327j(), graphQLTimelineAppSectionType, d, new TimelineAppCollectionItemNode(appCollectionSuggestionFieldsModel), true, false);
    }

    public static DefaultTextWithEntitiesLongFields m14993a(String str) {
        Builder builder = new Builder();
        builder.b = str;
        return builder.a();
    }
}
