package com.facebook.attachments.angora.actionbutton;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: vector_count */
public class CollectionSaveLegacyMutationProvider extends AbstractAssistedProvider<CollectionSaveLegacyMutation> {
    public final CollectionSaveLegacyMutation m816a(GraphQLNode graphQLNode, String str, CurationSurface curationSurface, CurationMechanism curationMechanism, String str2, boolean z) {
        return new CollectionSaveLegacyMutation(IdBasedProvider.a(this, 5895), IdBasedSingletonScopeProvider.a(this, 2289), (Clock) SystemClockMethodAutoProvider.a(this), graphQLNode, str, curationSurface, curationMechanism, str2, z);
    }
}
