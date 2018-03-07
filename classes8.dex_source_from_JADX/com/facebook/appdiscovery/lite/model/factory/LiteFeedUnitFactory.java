package com.facebook.appdiscovery.lite.model.factory;

import com.facebook.appdiscovery.lite.common.error.AppDiscoveryError;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryException;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppSectionQueryFragmentModel;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppSectionQueryFragmentModel.AppSectionUnitsModel.NodesModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.model.FeedUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: is_mem_cached_entity */
public abstract class LiteFeedUnitFactory<F extends FeedUnit, N> implements AppDiscoveryFeedUnitFactory<AppSectionQueryFragmentModel, F> {
    private static final String f10574b = AppDiscoveryFeedUnitFactory.class.getName();
    protected final AbstractFbErrorReporter f10575a;

    @Nullable
    public abstract F mo745a(AppSectionQueryFragmentModel appSectionQueryFragmentModel);

    public LiteFeedUnitFactory(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10575a = abstractFbErrorReporter;
    }

    public final ImmutableList<N> m12471b(AppSectionQueryFragmentModel appSectionQueryFragmentModel) {
        Builder builder = ImmutableList.builder();
        if (!(appSectionQueryFragmentModel.l() == null || appSectionQueryFragmentModel.l().a().isEmpty())) {
            ImmutableList a = appSectionQueryFragmentModel.l().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (nodesModel != null) {
                    try {
                        builder.c(nodesModel);
                    } catch (Throwable e) {
                        this.f10575a.b(f10574b, new AppDiscoveryException(e, AppDiscoveryError.FETCH_LITE_RESULTS_FAIL));
                    }
                }
            }
        }
        return builder.b();
    }
}
