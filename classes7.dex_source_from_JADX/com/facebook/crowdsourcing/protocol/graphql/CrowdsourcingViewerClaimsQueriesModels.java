package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueriesParsers.CrowdsourcingClaimCountQueryParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueriesParsers.CrowdsourcingClaimCountQueryParser.CrowdsourcedFieldParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueriesParsers.CrowdsourcingClaimCountQueryParser.CrowdsourcedFieldParser.ViewerClaimsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: taggable_objects */
public class CrowdsourcingViewerClaimsQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 827931754)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: taggable_objects */
    public final class CrowdsourcingClaimCountQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CrowdsourcedFieldModel f2331d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1210551671)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: taggable_objects */
        public final class CrowdsourcedFieldModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ViewerClaimsModel f2330d;

            /* compiled from: taggable_objects */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CrowdsourcedFieldModel.class, new Deserializer());
                }

                public Object m2353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CrowdsourcedFieldParser.m2373a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object crowdsourcedFieldModel = new CrowdsourcedFieldModel();
                    ((BaseModel) crowdsourcedFieldModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (crowdsourcedFieldModel instanceof Postprocessable) {
                        return ((Postprocessable) crowdsourcedFieldModel).a();
                    }
                    return crowdsourcedFieldModel;
                }
            }

            /* compiled from: taggable_objects */
            public class Serializer extends JsonSerializer<CrowdsourcedFieldModel> {
                public final void m2354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CrowdsourcedFieldModel crowdsourcedFieldModel = (CrowdsourcedFieldModel) obj;
                    if (crowdsourcedFieldModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(crowdsourcedFieldModel.m2361a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        crowdsourcedFieldModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CrowdsourcedFieldParser.m2374a(crowdsourcedFieldModel.w_(), crowdsourcedFieldModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CrowdsourcedFieldModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: taggable_objects */
            public final class ViewerClaimsModel extends BaseModel implements GraphQLVisitableModel {
                private int f2329d;

                /* compiled from: taggable_objects */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ViewerClaimsModel.class, new Deserializer());
                    }

                    public Object m2355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ViewerClaimsParser.m2371a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object viewerClaimsModel = new ViewerClaimsModel();
                        ((BaseModel) viewerClaimsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (viewerClaimsModel instanceof Postprocessable) {
                            return ((Postprocessable) viewerClaimsModel).a();
                        }
                        return viewerClaimsModel;
                    }
                }

                /* compiled from: taggable_objects */
                public class Serializer extends JsonSerializer<ViewerClaimsModel> {
                    public final void m2356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ViewerClaimsModel viewerClaimsModel = (ViewerClaimsModel) obj;
                        if (viewerClaimsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(viewerClaimsModel.m2358a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            viewerClaimsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ViewerClaimsParser.m2372a(viewerClaimsModel.w_(), viewerClaimsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ViewerClaimsModel.class, new Serializer());
                    }
                }

                public ViewerClaimsModel() {
                    super(1);
                }

                public final int m2357a() {
                    a(0, 0);
                    return this.f2329d;
                }

                public final int jK_() {
                    return -1451475924;
                }

                public final GraphQLVisitableModel m2359a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2358a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f2329d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2360a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f2329d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            public CrowdsourcedFieldModel() {
                super(1);
            }

            @Nullable
            public final ViewerClaimsModel m2362a() {
                this.f2330d = (ViewerClaimsModel) super.a(this.f2330d, 0, ViewerClaimsModel.class);
                return this.f2330d;
            }

            public final int jK_() {
                return 409940958;
            }

            public final GraphQLVisitableModel m2363a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2362a() != null) {
                    ViewerClaimsModel viewerClaimsModel = (ViewerClaimsModel) graphQLModelMutatingVisitor.b(m2362a());
                    if (m2362a() != viewerClaimsModel) {
                        graphQLVisitableModel = (CrowdsourcedFieldModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2330d = viewerClaimsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2361a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2362a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: taggable_objects */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingClaimCountQueryModel.class, new Deserializer());
            }

            public Object m2364a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingClaimCountQueryParser.m2375a(jsonParser);
                Object crowdsourcingClaimCountQueryModel = new CrowdsourcingClaimCountQueryModel();
                ((BaseModel) crowdsourcingClaimCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingClaimCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingClaimCountQueryModel).a();
                }
                return crowdsourcingClaimCountQueryModel;
            }
        }

        /* compiled from: taggable_objects */
        public class Serializer extends JsonSerializer<CrowdsourcingClaimCountQueryModel> {
            public final void m2365a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingClaimCountQueryModel crowdsourcingClaimCountQueryModel = (CrowdsourcingClaimCountQueryModel) obj;
                if (crowdsourcingClaimCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingClaimCountQueryModel.m2366a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingClaimCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingClaimCountQueryModel.w_();
                int u_ = crowdsourcingClaimCountQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("crowdsourced_field");
                    CrowdsourcedFieldParser.m2374a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingClaimCountQueryModel.class, new Serializer());
            }
        }

        public CrowdsourcingClaimCountQueryModel() {
            super(1);
        }

        public final void m2369a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2370a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CrowdsourcedFieldModel m2367a() {
            this.f2331d = (CrowdsourcedFieldModel) super.a(this.f2331d, 0, CrowdsourcedFieldModel.class);
            return this.f2331d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2367a() != null) {
                CrowdsourcedFieldModel crowdsourcedFieldModel = (CrowdsourcedFieldModel) graphQLModelMutatingVisitor.b(m2367a());
                if (m2367a() != crowdsourcedFieldModel) {
                    graphQLVisitableModel = (CrowdsourcingClaimCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2331d = crowdsourcedFieldModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2366a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2367a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
