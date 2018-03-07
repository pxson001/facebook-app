package com.facebook.controller.mutation.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: rtt= */
public abstract class RecursiveFeedbackTransform extends GraphQLCachingVisitor implements CacheVisitor {
    private final TypedModelVisitor<GraphQLVisitableModel> f3026a;
    private final Set<String> f3027b;
    @Nullable
    private final ConsistencyMemoryCache f3028c;

    /* compiled from: rtt= */
    class C01451 implements TypedModelVisitor<GraphQLVisitableModel> {
        final /* synthetic */ RecursiveFeedbackTransform f3032a;

        C01451(RecursiveFeedbackTransform recursiveFeedbackTransform) {
            this.f3032a = recursiveFeedbackTransform;
        }

        @Nullable
        public final Object mo266a(@Nullable Object obj) {
            GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) obj;
            if (graphQLVisitableModel instanceof GraphQLFeedback) {
                return this.f3032a.mo267a((GraphQLFeedback) graphQLVisitableModel);
            }
            if (graphQLVisitableModel instanceof PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) {
                GraphQLFeedback a = this.f3032a.mo267a(PhotosMetadataConversionHelper.a((PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) graphQLVisitableModel));
                ByteBuffer byteBuffer = null;
                if (a != null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a2 = PhotosMetadataConversionHelper.a(flatBufferBuilder, a);
                    if (a2 != 0) {
                        flatBufferBuilder.d(a2);
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        byteBuffer = new PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }
                return byteBuffer;
            } else if (graphQLVisitableModel.jK_() == -126857307) {
                return this.f3032a.m3338a(graphQLVisitableModel);
            } else {
                return graphQLVisitableModel;
            }
        }
    }

    protected abstract GraphQLFeedback mo267a(GraphQLFeedback graphQLFeedback);

    public RecursiveFeedbackTransform(@Nullable ConsistencyMemoryCache consistencyMemoryCache, String... strArr) {
        this.f3026a = new C01451(this);
        this.f3027b = ImmutableSet.copyOf(strArr);
        this.f3028c = consistencyMemoryCache;
    }

    public RecursiveFeedbackTransform(String... strArr) {
        this(null, strArr);
    }

    protected final GraphQLVisitableModel m3338a(GraphQLVisitableModel graphQLVisitableModel) {
        return this.f3028c == null ? graphQLVisitableModel : this.f3028c.mo876c(graphQLVisitableModel);
    }

    public final <T> T mo269b(T t) {
        if (t instanceof List) {
            List<FeedUpdate> list = (List) t;
            if (!list.isEmpty() && (list.get(0) instanceof FeedUpdate)) {
                T a = Lists.a(list.size());
                for (FeedUpdate feedUpdate : list) {
                    a.add(new FeedUpdate(feedUpdate.c, (FeedUnit) mo270a(feedUpdate.d)));
                }
                return a;
            }
        }
        return new RecursiveModelTransformer(GraphQLVisitableModel.class, this.f3026a).m3273a((Object) t);
    }

    public final Set<String> mo268a() {
        return this.f3027b;
    }
}
