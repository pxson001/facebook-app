package com.facebook.attachments.angora.actionbutton;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.DefaultSavableObjectExtraFieldsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.DefaultSavableObjectExtraFieldsModel.Builder;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.protocol.UpdateTimelineAppCollectionMethod;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.LegacyMutation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: vectors */
public class CollectionSaveLegacyMutation implements LegacyMutation<DefaultSavableObjectExtraFieldsModel> {
    private final Provider<UpdateTimelineAppCollectionMethod> f779a;
    private final Provider<SingleMethodRunner> f780b;
    private final Clock f781c;
    private final GraphQLNode f782d;
    private final CurationSurface f783e;
    private final CurationMechanism f784f;
    @Nullable
    private final String f785g;
    @Nullable
    private final String f786h;
    private final boolean f787i;

    public final /* synthetic */ GraphQLVisitableModel m814b() {
        return m812d();
    }

    @Inject
    public CollectionSaveLegacyMutation(Provider<UpdateTimelineAppCollectionMethod> provider, Provider<SingleMethodRunner> provider2, Clock clock, @Assisted GraphQLNode graphQLNode, @Nullable @Assisted String str, @Assisted CurationSurface curationSurface, @Assisted CurationMechanism curationMechanism, @Nullable @Assisted String str2, @Assisted boolean z) {
        this.f779a = provider;
        this.f780b = provider2;
        this.f781c = clock;
        this.f782d = graphQLNode;
        this.f785g = str;
        this.f783e = curationSurface;
        this.f784f = curationMechanism;
        this.f786h = str2;
        this.f787i = z;
    }

    public final String m813a() {
        return "LegacyCollectionSave";
    }

    private DefaultSavableObjectExtraFieldsModel m812d() {
        GraphQLSavedState graphQLSavedState;
        Builder builder = new Builder();
        builder.b = this.f782d.dp();
        Builder builder2 = builder;
        if (this.f787i) {
            graphQLSavedState = GraphQLSavedState.SAVED;
        } else {
            graphQLSavedState = GraphQLSavedState.NOT_SAVED;
        }
        builder2.d = graphQLSavedState;
        builder = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        int b = flatBufferBuilder.b(builder.b);
        int a2 = ModelHelper.a(flatBufferBuilder, builder.c);
        int a3 = flatBufferBuilder.a(builder.d);
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultSavableObjectExtraFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final GraphQLResult<DefaultSavableObjectExtraFieldsModel> m815c() {
        Action action;
        UpdateTimelineAppCollectionParams.Builder builder = new UpdateTimelineAppCollectionParams.Builder();
        if (this.f787i) {
            action = Action.ADD;
        } else {
            action = Action.REMOVE;
        }
        builder.c = action;
        UpdateTimelineAppCollectionParams.Builder builder2 = builder;
        builder2.a = this.f782d.gK().b();
        builder2 = builder2;
        builder2.b = this.f782d.dp();
        builder2 = builder2;
        builder2.l = this.f785g;
        builder2 = builder2;
        builder2.d = this.f783e;
        builder2 = builder2;
        builder2.e = this.f784f;
        builder2 = builder2;
        builder2.k = this.f786h;
        UpdateTimelineAppCollectionParams.Builder builder3 = builder2;
        if (this.f787i) {
            builder3.g = this.f782d.gK().q().c();
        }
        ((AbstractSingleMethodRunner) this.f780b.get()).a((ApiMethod) this.f779a.get(), builder3.a());
        return new GraphQLResult(m812d(), DataFreshnessResult.FROM_SERVER, this.f781c.a());
    }
}
