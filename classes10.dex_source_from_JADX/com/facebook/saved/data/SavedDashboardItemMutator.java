package com.facebook.saved.data;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.data.SavedDashboardItem.Builder;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedDashboardItemFieldsModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.ViewerRecommendationFieldsModel.ViewerRecommendationModel;
import java.nio.ByteBuffer;

/* compiled from: isLimitAdTrackingEnabled */
public class SavedDashboardItemMutator {
    public static SavedDashboardItemMutator m9109a(InjectorLike injectorLike) {
        return new SavedDashboardItemMutator();
    }

    public final SavedDashboardItem m9110a(SavedDashboardItem savedDashboardItem, GraphQLSavedState graphQLSavedState, boolean z) {
        Builder builder = new Builder();
        builder = Builder.m9102a(savedDashboardItem);
        SavedDashboardItemFieldsModel savedDashboardItemFieldsModel = savedDashboardItem.f9112g;
        SavedDashboardItemFieldsModel.Builder builder2 = new SavedDashboardItemFieldsModel.Builder();
        builder2 = SavedDashboardItemFieldsModel.Builder.m9296a(savedDashboardItemFieldsModel);
        builder2.f9266w = graphQLSavedState;
        builder.f9100g = builder2.m9297a();
        builder = builder;
        builder.f9103j = z;
        return builder.m9103a();
    }

    public static SavedDashboardItem m9108a(SavedDashboardItem savedDashboardItem, boolean z) {
        ViewerRecommendationModel viewerRecommendationModel;
        if (z) {
            ViewerRecommendationModel.Builder builder = new ViewerRecommendationModel.Builder();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder.f9324a, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            viewerRecommendationModel = new ViewerRecommendationModel(new MutableFlatBuffer(wrap, null, null, true, null));
        } else {
            viewerRecommendationModel = null;
        }
        SavedDashboardItemFieldsModel.Builder builder2 = new SavedDashboardItemFieldsModel.Builder();
        builder2 = SavedDashboardItemFieldsModel.Builder.m9296a(savedDashboardItem.f9112g);
        builder2.f9265v = viewerRecommendationModel;
        SavedDashboardItemFieldsModel a = builder2.m9297a();
        Builder builder3 = new Builder();
        builder3 = Builder.m9102a(savedDashboardItem);
        builder3.f9100g = a;
        return builder3.m9103a();
    }
}
