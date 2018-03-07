package com.facebook.saved.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLRecentSaveTimeframe;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLParsers.FetchRecentSaveInfoGraphQLParser;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLParsers.FetchRecentSaveInfoGraphQLParser.SaverInfoParser;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLParsers.FetchRecentSaveInfoGraphQLParser.SaverInfoParser.RecentSaveInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fetchVideoBroadcastPlayCount */
public class FetchRecentSaveInfoGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1936948317)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetchVideoBroadcastPlayCount */
    public final class FetchRecentSaveInfoGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SaverInfoModel f14421d;

        /* compiled from: fetchVideoBroadcastPlayCount */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchRecentSaveInfoGraphQLModel.class, new Deserializer());
            }

            public Object m18293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchRecentSaveInfoGraphQLParser.m18314a(jsonParser);
                Object fetchRecentSaveInfoGraphQLModel = new FetchRecentSaveInfoGraphQLModel();
                ((BaseModel) fetchRecentSaveInfoGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchRecentSaveInfoGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchRecentSaveInfoGraphQLModel).a();
                }
                return fetchRecentSaveInfoGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2123775217)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchVideoBroadcastPlayCount */
        public final class SaverInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RecentSaveInfoModel f14420d;

            /* compiled from: fetchVideoBroadcastPlayCount */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SaverInfoModel.class, new Deserializer());
                }

                public Object m18294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SaverInfoParser.m18312a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object saverInfoModel = new SaverInfoModel();
                    ((BaseModel) saverInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (saverInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) saverInfoModel).a();
                    }
                    return saverInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1291887992)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fetchVideoBroadcastPlayCount */
            public final class RecentSaveInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLRecentSaveTimeframe f14418d;
                private int f14419e;

                /* compiled from: fetchVideoBroadcastPlayCount */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RecentSaveInfoModel.class, new Deserializer());
                    }

                    public Object m18295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RecentSaveInfoParser.m18310a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object recentSaveInfoModel = new RecentSaveInfoModel();
                        ((BaseModel) recentSaveInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (recentSaveInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) recentSaveInfoModel).a();
                        }
                        return recentSaveInfoModel;
                    }
                }

                /* compiled from: fetchVideoBroadcastPlayCount */
                public class Serializer extends JsonSerializer<RecentSaveInfoModel> {
                    public final void m18296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RecentSaveInfoModel recentSaveInfoModel = (RecentSaveInfoModel) obj;
                        if (recentSaveInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(recentSaveInfoModel.m18297a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            recentSaveInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RecentSaveInfoParser.m18311a(recentSaveInfoModel.w_(), recentSaveInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(RecentSaveInfoModel.class, new Serializer());
                    }
                }

                public RecentSaveInfoModel() {
                    super(2);
                }

                @Nullable
                public final GraphQLRecentSaveTimeframe m18298a() {
                    this.f14418d = (GraphQLRecentSaveTimeframe) super.b(this.f14418d, 0, GraphQLRecentSaveTimeframe.class, GraphQLRecentSaveTimeframe.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f14418d;
                }

                public final int m18301j() {
                    a(0, 1);
                    return this.f14419e;
                }

                public final int jK_() {
                    return -645496986;
                }

                public final GraphQLVisitableModel m18299a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18297a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m18298a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f14419e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m18300a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f14419e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: fetchVideoBroadcastPlayCount */
            public class Serializer extends JsonSerializer<SaverInfoModel> {
                public final void m18302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SaverInfoModel saverInfoModel = (SaverInfoModel) obj;
                    if (saverInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(saverInfoModel.m18303a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        saverInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SaverInfoParser.m18313a(saverInfoModel.w_(), saverInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SaverInfoModel.class, new Serializer());
                }
            }

            public SaverInfoModel() {
                super(1);
            }

            @Nullable
            public final RecentSaveInfoModel m18305a() {
                this.f14420d = (RecentSaveInfoModel) super.a(this.f14420d, 0, RecentSaveInfoModel.class);
                return this.f14420d;
            }

            public final int jK_() {
                return -2090593085;
            }

            public final GraphQLVisitableModel m18304a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18305a() != null) {
                    RecentSaveInfoModel recentSaveInfoModel = (RecentSaveInfoModel) graphQLModelMutatingVisitor.b(m18305a());
                    if (m18305a() != recentSaveInfoModel) {
                        graphQLVisitableModel = (SaverInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14420d = recentSaveInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18303a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18305a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fetchVideoBroadcastPlayCount */
        public class Serializer extends JsonSerializer<FetchRecentSaveInfoGraphQLModel> {
            public final void m18306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchRecentSaveInfoGraphQLModel fetchRecentSaveInfoGraphQLModel = (FetchRecentSaveInfoGraphQLModel) obj;
                if (fetchRecentSaveInfoGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchRecentSaveInfoGraphQLModel.m18307a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchRecentSaveInfoGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchRecentSaveInfoGraphQLModel.w_();
                int u_ = fetchRecentSaveInfoGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("saver_info");
                    SaverInfoParser.m18313a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchRecentSaveInfoGraphQLModel.class, new Serializer());
            }
        }

        public FetchRecentSaveInfoGraphQLModel() {
            super(1);
        }

        @Nullable
        public final SaverInfoModel m18309a() {
            this.f14421d = (SaverInfoModel) super.a(this.f14421d, 0, SaverInfoModel.class);
            return this.f14421d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m18308a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18309a() != null) {
                SaverInfoModel saverInfoModel = (SaverInfoModel) graphQLModelMutatingVisitor.b(m18309a());
                if (m18309a() != saverInfoModel) {
                    graphQLVisitableModel = (FetchRecentSaveInfoGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14421d = saverInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18307a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18309a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
