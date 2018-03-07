package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionDefaultFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionItemConnectionWithFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsEligibleSuggestionsFieldsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: Marker  */
public class FetchTimelineCollectionItemsGraphQLInterfaces {

    /* compiled from: Marker  */
    public interface CollectionWithItemsAndSuggestions extends AppCollectionDefaultFields {
        @Nullable
        String mo397b();

        @Nullable
        String mo395c();

        @Nonnull
        ImmutableList<GraphQLTimelineAppCollectionStyle> mo396d();

        @Nullable
        String mo398j();

        boolean mo399n();

        @Nullable
        String nS_();

        @Nullable
        CollectionItemConnectionWithFieldsModel nU_();

        @Nullable
        String mo402o();

        @Nullable
        DefaultTextWithEntitiesFields mo403p();

        @Nullable
        CollectionsEligibleSuggestionsFieldsModel mo404q();
    }
}
