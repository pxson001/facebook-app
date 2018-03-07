package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsParsers.AlbumPrivacyOptionsParser;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsParsers.AlbumPrivacyOptionsParser.PrivacyScopeParser;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsParsers.AlbumPrivacyOptionsParser.PrivacyScopeParser.PrivacyOptionsParser;
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

/* compiled from: sticker_pack_selected */
public class FetchComposerPrivacyOptionsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1821092483)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: sticker_pack_selected */
    public final class AlbumPrivacyOptionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PrivacyScopeModel f4139d;

        /* compiled from: sticker_pack_selected */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AlbumPrivacyOptionsModel.class, new Deserializer());
            }

            public Object m6054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AlbumPrivacyOptionsParser.m6073a(jsonParser);
                Object albumPrivacyOptionsModel = new AlbumPrivacyOptionsModel();
                ((BaseModel) albumPrivacyOptionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (albumPrivacyOptionsModel instanceof Postprocessable) {
                    return ((Postprocessable) albumPrivacyOptionsModel).a();
                }
                return albumPrivacyOptionsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -769663937)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: sticker_pack_selected */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyOptionsModel f4138d;

            /* compiled from: sticker_pack_selected */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m6055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m6071a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -458061977)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: sticker_pack_selected */
            public final class PrivacyOptionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<GraphQLPrivacyOptionsContentEdge> f4137d;

                /* compiled from: sticker_pack_selected */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PrivacyOptionsModel.class, new Deserializer());
                    }

                    public Object m6056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PrivacyOptionsParser.m6069a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object privacyOptionsModel = new PrivacyOptionsModel();
                        ((BaseModel) privacyOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (privacyOptionsModel instanceof Postprocessable) {
                            return ((Postprocessable) privacyOptionsModel).a();
                        }
                        return privacyOptionsModel;
                    }
                }

                /* compiled from: sticker_pack_selected */
                public class Serializer extends JsonSerializer<PrivacyOptionsModel> {
                    public final void m6057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) obj;
                        if (privacyOptionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(privacyOptionsModel.m6058a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            privacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PrivacyOptionsParser.m6070a(privacyOptionsModel.w_(), privacyOptionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PrivacyOptionsModel.class, new Serializer());
                    }
                }

                public PrivacyOptionsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<GraphQLPrivacyOptionsContentEdge> m6060a() {
                    this.f4137d = super.a(this.f4137d, 0, GraphQLPrivacyOptionsContentEdge.class);
                    return (ImmutableList) this.f4137d;
                }

                public final int jK_() {
                    return 780090561;
                }

                public final GraphQLVisitableModel m6059a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6060a() != null) {
                        Builder a = ModelHelper.a(m6060a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PrivacyOptionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4137d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6058a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6060a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sticker_pack_selected */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m6061a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m6062a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m6072a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            public PrivacyScopeModel() {
                super(1);
            }

            @Nullable
            public final PrivacyOptionsModel m6064a() {
                this.f4138d = (PrivacyOptionsModel) super.a(this.f4138d, 0, PrivacyOptionsModel.class);
                return this.f4138d;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m6063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6064a() != null) {
                    PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) graphQLModelMutatingVisitor.b(m6064a());
                    if (m6064a() != privacyOptionsModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4138d = privacyOptionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6062a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6064a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sticker_pack_selected */
        public class Serializer extends JsonSerializer<AlbumPrivacyOptionsModel> {
            public final void m6065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AlbumPrivacyOptionsModel albumPrivacyOptionsModel = (AlbumPrivacyOptionsModel) obj;
                if (albumPrivacyOptionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(albumPrivacyOptionsModel.m6066a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    albumPrivacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = albumPrivacyOptionsModel.w_();
                int u_ = albumPrivacyOptionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("privacy_scope");
                    PrivacyScopeParser.m6072a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AlbumPrivacyOptionsModel.class, new Serializer());
            }
        }

        public AlbumPrivacyOptionsModel() {
            super(1);
        }

        @Nullable
        public final PrivacyScopeModel m6068a() {
            this.f4139d = (PrivacyScopeModel) super.a(this.f4139d, 0, PrivacyScopeModel.class);
            return this.f4139d;
        }

        public final int jK_() {
            return 63344207;
        }

        public final GraphQLVisitableModel m6067a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6068a() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m6068a());
                if (m6068a() != privacyScopeModel) {
                    graphQLVisitableModel = (AlbumPrivacyOptionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4139d = privacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6066a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6068a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
