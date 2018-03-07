package com.facebook.facecastdisplay;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel.OwnerModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel.OwnerModel.Builder;
import com.facebook.facecastdisplay.protocol.MutateLiveScribeMethod.Params;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.executor.GraphQLCacheAggregator;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: pop_servers */
public class LiveScribeMutator {
    public static final String f4443a = LiveScribeMutator.class.getName();
    private final DefaultBlueServiceOperationFactory f4444b;
    public final GraphQLCacheAggregator f4445c;
    @ForNonUiThread
    private final ExecutorService f4446d;
    public final AbstractFbErrorReporter f4447e;

    public static LiveScribeMutator m4945b(InjectorLike injectorLike) {
        return new LiveScribeMutator(DefaultBlueServiceOperationFactory.b(injectorLike), GraphQLCacheAggregator.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public LiveScribeMutator(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, GraphQLCacheAggregator graphQLCacheAggregator, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4444b = defaultBlueServiceOperationFactory;
        this.f4445c = graphQLCacheAggregator;
        this.f4446d = executorService;
        this.f4447e = abstractFbErrorReporter;
    }

    public final void m4946a(String str, String str2, boolean z, String str3) {
        Params params = new Params(str, str2, str3, z);
        Bundle bundle = new Bundle();
        bundle.putParcelable("mutateLiveScribeParamsKey", params);
        BlueServiceOperationFactoryDetour.a(this.f4444b, "mutate_live_scribe", bundle, ErrorPropagation.BY_ERROR_CODE, null, -1748803110).a();
        m4944a(str2, z);
    }

    private void m4944a(String str, boolean z) {
        GraphQLLiveVideoSubscriptionStatus graphQLLiveVideoSubscriptionStatus;
        Builder builder = new Builder();
        builder.b = str;
        Builder builder2 = builder;
        if (z) {
            graphQLLiveVideoSubscriptionStatus = GraphQLLiveVideoSubscriptionStatus.ALL;
        } else {
            graphQLLiveVideoSubscriptionStatus = GraphQLLiveVideoSubscriptionStatus.OFF;
        }
        builder2.c = graphQLLiveVideoSubscriptionStatus;
        builder = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        int b = flatBufferBuilder.b(builder.b);
        int a2 = flatBufferBuilder.a(builder.c);
        int b2 = flatBufferBuilder.b(builder.d);
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        ExecutorDetour.a(this.f4446d, new 1(this, new OwnerModel(new MutableFlatBuffer(wrap, null, null, true, null))), -1882425906);
    }
}
