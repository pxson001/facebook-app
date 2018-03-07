package com.facebook.graphql.model;

import com.facebook.graphql.model.interfaces.HasTracking;
import javax.annotation.Nullable;

/* compiled from: onSurfaceTextureDestroyed */
public interface SuggestedPageUnitItem extends HasSponsoredImpression, HasTracking {
    @Nullable
    GraphQLSponsoredData mo546A();

    @Nullable
    GraphQLImage mo547a(int i);

    @Nullable
    GraphQLPage mo548m();

    @Nullable
    String mo549n();

    @Nullable
    GraphQLImage mo550o();

    @Nullable
    GraphQLVect2 mo551p();

    @Nullable
    GraphQLPagesYouMayLikeFeedUnitItemContentConnection mo552q();

    boolean mo553r();

    @Nullable
    GraphQLTextWithEntities mo554w();

    @Nullable
    GraphQLTextWithEntities mo555z();
}
