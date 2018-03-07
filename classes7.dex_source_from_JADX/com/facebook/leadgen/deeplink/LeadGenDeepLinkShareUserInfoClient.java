package com.facebook.leadgen.deeplink;

import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutation.LeadGenDeepLinkUserInfoCreateMutationString;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel.LeadGenDeepLinkUserStatusModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.LeadGenDeepLinkUserInfoCreateInputData;
import com.facebook.graphql.calls.LeadGenDeepLinkUserInfoCreateInputData.DisclaimerResponses;
import com.facebook.graphql.calls.LeadGenDeepLinkUserInfoCreateInputData.DisclaimerResponses.IsChecked;
import com.facebook.graphql.calls.LeadGenDeepLinkUserInfoCreateInputData.FieldsData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: pin_title */
public class LeadGenDeepLinkShareUserInfoClient {
    private GraphQLQueryExecutor f6377a;
    public final AbstractFbErrorReporter f6378b;

    /* compiled from: pin_title */
    class C05791 implements Function<GraphQLResult<LeadGenDeepLinkUserInfoCoreMutationFieldsModel>, LeadGenDeepLinkUserInfoCoreMutationFieldsModel> {
        final /* synthetic */ LeadGenDeepLinkShareUserInfoClient f6376a;

        C05791(LeadGenDeepLinkShareUserInfoClient leadGenDeepLinkShareUserInfoClient) {
            this.f6376a = leadGenDeepLinkShareUserInfoClient;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            Preconditions.checkNotNull(graphQLResult.e);
            return (LeadGenDeepLinkUserInfoCoreMutationFieldsModel) graphQLResult.e;
        }
    }

    @Inject
    public LeadGenDeepLinkShareUserInfoClient(GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f6377a = graphQLQueryExecutor;
        this.f6378b = abstractFbErrorReporter;
    }

    public final ListenableFuture<LeadGenDeepLinkUserInfoCoreMutationFieldsModel> m8215a(String str, String str2, ImmutableMap<String, String> immutableMap, ImmutableMap<String, String> immutableMap2) {
        ImmutableList b = m8214b(immutableMap2);
        Builder builder = ImmutableList.builder();
        Iterator it = immutableMap.keySet().iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            FieldsData fieldsData = new FieldsData();
            fieldsData.a("field_key", str3);
            fieldsData.a("values", ImmutableList.of(immutableMap.get(str3)));
            builder.c(fieldsData);
        }
        List b2 = builder.b();
        LeadGenDeepLinkUserInfoCreateInputData leadGenDeepLinkUserInfoCreateInputData = new LeadGenDeepLinkUserInfoCreateInputData();
        leadGenDeepLinkUserInfoCreateInputData.a("ad_id", str);
        leadGenDeepLinkUserInfoCreateInputData.a("lead_gen_data_id", str2);
        leadGenDeepLinkUserInfoCreateInputData.a("fields_data", b2);
        leadGenDeepLinkUserInfoCreateInputData.a("disclaimer_responses", b);
        GraphQLVisitableModel a = m8213a();
        GraphQlQueryString leadGenDeepLinkUserInfoCreateMutationString = new LeadGenDeepLinkUserInfoCreateMutationString();
        leadGenDeepLinkUserInfoCreateMutationString.a("input", leadGenDeepLinkUserInfoCreateInputData);
        return Futures.a(this.f6377a.a(GraphQLRequest.a(leadGenDeepLinkUserInfoCreateMutationString).a(a)), new C05791(this), MoreExecutors.a());
    }

    private static GraphQLVisitableModel m8213a() {
        LeadGenDeepLinkUserStatusModel.Builder builder = new LeadGenDeepLinkUserStatusModel.Builder();
        builder.f565a = true;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f566b);
        int b2 = flatBufferBuilder.b(builder.f567c);
        int b3 = flatBufferBuilder.b(builder.f568d);
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, builder.f565a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel = new LeadGenDeepLinkUserStatusModel(new MutableFlatBuffer(wrap, null, null, true, null));
        LeadGenDeepLinkUserInfoCoreMutationFieldsModel.Builder builder2 = new LeadGenDeepLinkUserInfoCoreMutationFieldsModel.Builder();
        builder2.f564a = leadGenDeepLinkUserStatusModel;
        LeadGenDeepLinkUserInfoCoreMutationFieldsModel.Builder builder3 = builder2;
        flatBufferBuilder = new FlatBufferBuilder(128);
        b = ModelHelper.a(flatBufferBuilder, builder3.f564a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new LeadGenDeepLinkUserInfoCoreMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private ImmutableList<DisclaimerResponses> m8214b(ImmutableMap<String, String> immutableMap) {
        Builder builder = ImmutableList.builder();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            DisclaimerResponses disclaimerResponses = new DisclaimerResponses();
            disclaimerResponses.a("checkbox_key", (String) entry.getKey());
            String str = (String) entry.getValue();
            for (IsChecked isChecked : IsChecked.values()) {
                if (isChecked.toString().equalsIgnoreCase(str)) {
                    break;
                }
            }
            this.f6378b.a(SoftError.a("LEADGEN", "Error attempting to parse Illegal Enum Value for IsChecked. Value - (" + str + ")").g());
            IsChecked isChecked2 = IsChecked.FALSE;
            disclaimerResponses.a("is_checked", isChecked2);
            builder.c(disclaimerResponses);
        }
        return builder.b();
    }
}
