package com.facebook.feed.data.freshfeed.ranking;

import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.multifeed.ranking.core.value_model.ClientValueModelHolderProvider;

/* compiled from: session_key */
public class ClientFeedUnitEdgeScorerProvider extends AbstractAssistedProvider<ClientFeedUnitEdgeScorer> {
    public final ClientFeedUnitEdgeScorer m9360a(String str) {
        return new ClientFeedUnitEdgeScorer(str, SystemClockMethodAutoProvider.m1498a(this), ClientRankingSignalStore.m9365a((InjectorLike) this), (ClientValueModelHolderProvider) getOnDemandAssistedProviderForStaticDi(ClientValueModelHolderProvider.class));
    }
}
