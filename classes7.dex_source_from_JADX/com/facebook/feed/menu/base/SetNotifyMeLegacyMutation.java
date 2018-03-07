package com.facebook.feed.menu.base;

import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsModels.FeedbackSubscribeMutationFragmentModel.FeedbackModel;
import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsModels.FeedbackSubscribeMutationFragmentModel.FeedbackModel.Builder;
import com.facebook.api.ufiservices.SetNotifyMeMethod;
import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.LegacyMutation;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: all_coworkers_alphabetic_section */
public class SetNotifyMeLegacyMutation implements LegacyMutation<FeedbackModel> {
    private final Lazy<SetNotifyMeMethod> f19441a;
    private final Provider<SingleMethodRunner> f19442b;
    private final Clock f19443c;
    private final GraphQLStory f19444d;
    private final boolean f19445e;

    @Inject
    public SetNotifyMeLegacyMutation(Lazy<SetNotifyMeMethod> lazy, Provider<SingleMethodRunner> provider, Clock clock, @Assisted GraphQLStory graphQLStory, @Assisted boolean z) {
        this.f19441a = lazy;
        this.f19442b = provider;
        this.f19443c = clock;
        this.f19444d = graphQLStory;
        this.f19445e = z;
    }

    public final String m22821a() {
        return "LegacySetNotifyMe";
    }

    public final GraphQLVisitableModel m22822b() {
        Builder builder = new Builder();
        builder.c = this.f19444d.l().j();
        builder = builder;
        builder.b = this.f19445e;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.a);
        int b2 = flatBufferBuilder.b(builder.c);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder.b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new FeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final GraphQLResult<FeedbackModel> m22823c() {
        SetNotifyMeParams.Builder f = SetNotifyMeParams.f();
        f.e = this.f19444d.c();
        f = f;
        f.c = this.f19444d.c();
        f = f;
        f.b = this.f19444d.ai();
        f = f;
        f.a = this.f19444d.l().j();
        f = f;
        f.d = this.f19445e;
        f = f;
        f.f = getClass().getSimpleName();
        ((AbstractSingleMethodRunner) this.f19442b.get()).a((ApiMethod) this.f19441a.get(), f.g());
        return new GraphQLResult(m22822b(), DataFreshnessResult.FROM_SERVER, this.f19443c.a());
    }
}
