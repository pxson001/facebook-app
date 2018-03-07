package com.facebook.pages.data.graphql.notificationcounts;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.FetchNotificationCountsQueryParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.FetchNotificationCountsQueryParser.AdminedPagesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: mMyself */
public class FetchNotificationCountsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 777969601)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mMyself */
    public final class FetchNotificationCountsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdminedPagesModel f8363d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1211611989)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mMyself */
        public final class AdminedPagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PageNotificationCountsModel> f8362d;

            /* compiled from: mMyself */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminedPagesModel.class, new Deserializer());
                }

                public Object m8314a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminedPagesParser.a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminedPagesModel = new AdminedPagesModel();
                    ((BaseModel) adminedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminedPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) adminedPagesModel).a();
                    }
                    return adminedPagesModel;
                }
            }

            /* compiled from: mMyself */
            public class Serializer extends JsonSerializer<AdminedPagesModel> {
                public final void m8315a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminedPagesModel adminedPagesModel = (AdminedPagesModel) obj;
                    if (adminedPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminedPagesModel.m8317a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminedPagesParser.a(adminedPagesModel.w_(), adminedPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminedPagesModel.class, new Serializer());
                }
            }

            public AdminedPagesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<PageNotificationCountsModel> m8316a() {
                this.f8362d = super.a(this.f8362d, 0, PageNotificationCountsModel.class);
                return (ImmutableList) this.f8362d;
            }

            public final int jK_() {
                return 1239953364;
            }

            public final GraphQLVisitableModel m8318a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8316a() != null) {
                    Builder a = ModelHelper.a(m8316a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AdminedPagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8362d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8317a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8316a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mMyself */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchNotificationCountsQueryModel.class, new Deserializer());
            }

            public Object m8319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchNotificationCountsQueryParser.a(jsonParser);
                Object fetchNotificationCountsQueryModel = new FetchNotificationCountsQueryModel();
                ((BaseModel) fetchNotificationCountsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchNotificationCountsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchNotificationCountsQueryModel).a();
                }
                return fetchNotificationCountsQueryModel;
            }
        }

        public FetchNotificationCountsQueryModel() {
            super(1);
        }

        @Nullable
        private AdminedPagesModel m8320a() {
            this.f8363d = (AdminedPagesModel) super.a(this.f8363d, 0, AdminedPagesModel.class);
            return this.f8363d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m8322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8320a() != null) {
                AdminedPagesModel adminedPagesModel = (AdminedPagesModel) graphQLModelMutatingVisitor.b(m8320a());
                if (m8320a() != adminedPagesModel) {
                    graphQLVisitableModel = (FetchNotificationCountsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8363d = adminedPagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8321a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8320a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
