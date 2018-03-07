package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadFetcher.ResultTransformer;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoCurrentCityPredictionQueryModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoCurrentCityPredictionQueryModel.CurrentCityPredictionsModel.EdgesModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLInterfaces.TypeaheadResultPage;
import com.facebook.location.FbLocationCache;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mFutureLock */
public class ProfileInfoCurrentCityFetcher extends ProfileInfoTypeaheadFetcher<ProfileInfoCurrentCityPredictionQueryModel> {
    public final FbLocationCache f11107a;
    public final Toaster f11108b;
    public boolean f11109c = false;

    /* compiled from: mFutureLock */
    public class C06881 implements FutureCallback<List<TypeaheadResultPage>> {
        final /* synthetic */ FutureCallback f11102a;
        final /* synthetic */ ProfileInfoCurrentCityFetcher f11103b;

        public C06881(ProfileInfoCurrentCityFetcher profileInfoCurrentCityFetcher, FutureCallback futureCallback) {
            this.f11103b = profileInfoCurrentCityFetcher;
            this.f11102a = futureCallback;
        }

        public void onSuccess(Object obj) {
            List list = (List) obj;
            this.f11103b.f11109c = false;
            this.f11102a.onSuccess(list);
        }

        public void onFailure(Throwable th) {
            this.f11103b.f11108b.b(new ToastBuilder(2131230759));
            this.f11103b.f11109c = false;
        }
    }

    /* compiled from: mFutureLock */
    public class C06892 implements ResultTransformer<ProfileInfoCurrentCityPredictionQueryModel> {
        final /* synthetic */ ProfileInfoCurrentCityFetcher f11104a;

        public C06892(ProfileInfoCurrentCityFetcher profileInfoCurrentCityFetcher) {
            this.f11104a = profileInfoCurrentCityFetcher;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            List a = Lists.a();
            ImmutableList a2 = ((ProfileInfoCurrentCityPredictionQueryModel) graphQLResult.e).m17871a().m17866a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                a.add(((EdgesModel) a2.get(i)).m17862a());
            }
            return a;
        }
    }

    @Inject
    public ProfileInfoCurrentCityFetcher(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor, FbLocationCache fbLocationCache, Toaster toaster) {
        super(simpleExecutor, graphQLQueryExecutor);
        this.f11107a = fbLocationCache;
        this.f11108b = toaster;
    }

    public final void mo1069a() {
        if (this.f11109c) {
            this.f11109c = false;
        }
        super.mo1069a();
    }
}
