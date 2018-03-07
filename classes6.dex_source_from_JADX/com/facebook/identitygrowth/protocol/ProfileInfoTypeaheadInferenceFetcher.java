package com.facebook.identitygrowth.protocol;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadFetcher.ResultTransformer;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQL.ProfileInfoTypeaheadInferenceQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoTypeaheadInferenceQueryModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoTypeaheadInferenceQueryModel.ProfileInferenceModel.EdgesModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLInterfaces.TypeaheadResultPage;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mFramePackModel */
public class ProfileInfoTypeaheadInferenceFetcher extends ProfileInfoTypeaheadFetcher<ProfileInfoTypeaheadInferenceQueryModel> {
    private final AbstractFbErrorReporter f11111a;
    private final FbObjectMapper f11112b;

    /* compiled from: mFramePackModel */
    class C06901 implements ResultTransformer<ProfileInfoTypeaheadInferenceQueryModel> {
        final /* synthetic */ ProfileInfoTypeaheadInferenceFetcher f11110a;

        C06901(ProfileInfoTypeaheadInferenceFetcher profileInfoTypeaheadInferenceFetcher) {
            this.f11110a = profileInfoTypeaheadInferenceFetcher;
        }

        @Nullable
        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            List a = Lists.a();
            ImmutableList a2 = ((ProfileInfoTypeaheadInferenceQueryModel) graphQLResult.e).m17887a().m17883a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                a.add(((EdgesModel) a2.get(i)).m17879a());
            }
            return a;
        }
    }

    public static ProfileInfoTypeaheadInferenceFetcher m17852b(InjectorLike injectorLike) {
        return new ProfileInfoTypeaheadInferenceFetcher(SimpleExecutor.m22275b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileInfoTypeaheadInferenceFetcher(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, FbObjectMapper fbObjectMapper) {
        super(simpleExecutor, graphQLQueryExecutor);
        this.f11111a = abstractFbErrorReporter;
        this.f11112b = fbObjectMapper;
    }

    @Nullable
    @VisibleForTesting
    private List<String> m17851a(List<Bundle> list) {
        List<String> a = Lists.a();
        for (Bundle bundle : list) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                JsonGenerator a2 = this.f11112b.b().a(byteArrayOutputStream, JsonEncoding.UTF8);
                a2.f();
                a2.a("profile_section", bundle.getString("profile_section"));
                a2.f("page_ids");
                a2.b(bundle.getString("typeahead_existing_fields_page_id"));
                a2.e();
                a2.g();
                a2.close();
                a.add(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
            } catch (Exception e) {
                this.f11111a.a("identitygrowth", "Failed to fetch typeahead inference graphql results because of error processing json");
                return null;
            }
        }
        return a;
    }

    public final void m17853a(String str, List<Bundle> list, @Nullable FutureCallback<List<TypeaheadResultPage>> futureCallback) {
        List a = m17851a(list);
        GraphQlQueryString profileInfoTypeaheadInferenceQueryString = new ProfileInfoTypeaheadInferenceQueryString();
        profileInfoTypeaheadInferenceQueryString.a("profile_section", str).a("existing_profile_inputs", a).a("results_num", Integer.toString(10));
        m17848a(profileInfoTypeaheadInferenceQueryString, futureCallback, new C06901(this));
    }
}
