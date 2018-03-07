package com.facebook.groups.memberpicker.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataInterfaces.FBTaggableUserFragment;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBNameFragmentParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBNameFragmentParser.PartsParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBTaggableUserFragmentParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBTaggableUserFragmentParser.BylinesParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBTaggableUserFragmentParser.BylinesParser.ConciseTextParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FullImageFragmentParser;
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

/* compiled from: event_ref_mechanism */
public class GroupSuggestedMemberDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1371736060)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_ref_mechanism */
    public final class FBNameFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PartsModel> f14665d;
        @Nullable
        private String f14666e;

        /* compiled from: event_ref_mechanism */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNameFragmentModel.class, new Deserializer());
            }

            public Object m16651a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBNameFragmentParser.m16697a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBNameFragmentModel = new FBNameFragmentModel();
                ((BaseModel) fBNameFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBNameFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNameFragmentModel).a();
                }
                return fBNameFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1501120714)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_ref_mechanism */
        public final class PartsModel extends BaseModel implements GraphQLVisitableModel {
            private int f14662d;
            private int f14663e;
            @Nullable
            private GraphQLStructuredNamePart f14664f;

            /* compiled from: event_ref_mechanism */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PartsModel.class, new Deserializer());
                }

                public Object m16652a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PartsParser.m16696b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object partsModel = new PartsModel();
                    ((BaseModel) partsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (partsModel instanceof Postprocessable) {
                        return ((Postprocessable) partsModel).a();
                    }
                    return partsModel;
                }
            }

            /* compiled from: event_ref_mechanism */
            public class Serializer extends JsonSerializer<PartsModel> {
                public final void m16653a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PartsModel partsModel = (PartsModel) obj;
                    if (partsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(partsModel.m16655a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        partsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PartsParser.m16695a(partsModel.w_(), partsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PartsModel.class, new Serializer());
                }
            }

            public PartsModel() {
                super(3);
            }

            @Nullable
            private GraphQLStructuredNamePart m16654a() {
                this.f14664f = (GraphQLStructuredNamePart) super.b(this.f14664f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14664f;
            }

            public final int jK_() {
                return 1905097022;
            }

            public final GraphQLVisitableModel m16656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16655a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m16654a());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f14662d, 0);
                flatBufferBuilder.a(1, this.f14663e, 0);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16657a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14662d = mutableFlatBuffer.a(i, 0, 0);
                this.f14663e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: event_ref_mechanism */
        public class Serializer extends JsonSerializer<FBNameFragmentModel> {
            public final void m16658a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBNameFragmentModel fBNameFragmentModel = (FBNameFragmentModel) obj;
                if (fBNameFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNameFragmentModel.m16661a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNameFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBNameFragmentParser.m16698a(fBNameFragmentModel.w_(), fBNameFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBNameFragmentModel.class, new Serializer());
            }
        }

        public FBNameFragmentModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<PartsModel> m16659a() {
            this.f14665d = super.a(this.f14665d, 0, PartsModel.class);
            return (ImmutableList) this.f14665d;
        }

        @Nullable
        private String m16660j() {
            this.f14666e = super.a(this.f14666e, 1);
            return this.f14666e;
        }

        public final int jK_() {
            return 2420395;
        }

        public final GraphQLVisitableModel m16662a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16659a() != null) {
                Builder a = ModelHelper.a(m16659a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBNameFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14665d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16661a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16659a());
            int b = flatBufferBuilder.b(m16660j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1206423124)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_ref_mechanism */
    public final class FBTaggableUserFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBTaggableUserFragment {
        @Nullable
        private List<BylinesModel> f14669d;
        private double f14670e;
        @Nullable
        private String f14671f;
        @Nullable
        private String f14672g;
        @Nullable
        private List<String> f14673h;
        @Nullable
        private FullImageFragmentModel f14674i;
        @Nullable
        private FBNameFragmentModel f14675j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1205310945)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_ref_mechanism */
        public final class BylinesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ConciseTextModel f14668d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_ref_mechanism */
            public final class ConciseTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14667d;

                /* compiled from: event_ref_mechanism */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ConciseTextModel.class, new Deserializer());
                    }

                    public Object m16663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ConciseTextParser.m16699a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object conciseTextModel = new ConciseTextModel();
                        ((BaseModel) conciseTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (conciseTextModel instanceof Postprocessable) {
                            return ((Postprocessable) conciseTextModel).a();
                        }
                        return conciseTextModel;
                    }
                }

                /* compiled from: event_ref_mechanism */
                public class Serializer extends JsonSerializer<ConciseTextModel> {
                    public final void m16664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ConciseTextModel conciseTextModel = (ConciseTextModel) obj;
                        if (conciseTextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(conciseTextModel.m16666a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            conciseTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ConciseTextParser.m16700a(conciseTextModel.w_(), conciseTextModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ConciseTextModel.class, new Serializer());
                    }
                }

                public ConciseTextModel() {
                    super(1);
                }

                @Nullable
                private String m16665a() {
                    this.f14667d = super.a(this.f14667d, 0);
                    return this.f14667d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m16667a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16666a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16665a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: event_ref_mechanism */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BylinesModel.class, new Deserializer());
                }

                public Object m16668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BylinesParser.m16703b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bylinesModel = new BylinesModel();
                    ((BaseModel) bylinesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bylinesModel instanceof Postprocessable) {
                        return ((Postprocessable) bylinesModel).a();
                    }
                    return bylinesModel;
                }
            }

            /* compiled from: event_ref_mechanism */
            public class Serializer extends JsonSerializer<BylinesModel> {
                public final void m16669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BylinesModel bylinesModel = (BylinesModel) obj;
                    if (bylinesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bylinesModel.m16671a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bylinesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BylinesParser.m16704b(bylinesModel.w_(), bylinesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BylinesModel.class, new Serializer());
                }
            }

            public BylinesModel() {
                super(1);
            }

            @Nullable
            private ConciseTextModel m16670a() {
                this.f14668d = (ConciseTextModel) super.a(this.f14668d, 0, ConciseTextModel.class);
                return this.f14668d;
            }

            public final int jK_() {
                return 1608962139;
            }

            public final GraphQLVisitableModel m16672a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16670a() != null) {
                    ConciseTextModel conciseTextModel = (ConciseTextModel) graphQLModelMutatingVisitor.b(m16670a());
                    if (m16670a() != conciseTextModel) {
                        graphQLVisitableModel = (BylinesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14668d = conciseTextModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16671a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16670a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: event_ref_mechanism */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBTaggableUserFragmentModel.class, new Deserializer());
            }

            public Object m16673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBTaggableUserFragmentParser.m16705a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBTaggableUserFragmentModel = new FBTaggableUserFragmentModel();
                ((BaseModel) fBTaggableUserFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBTaggableUserFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBTaggableUserFragmentModel).a();
                }
                return fBTaggableUserFragmentModel;
            }
        }

        /* compiled from: event_ref_mechanism */
        public class Serializer extends JsonSerializer<FBTaggableUserFragmentModel> {
            public final void m16674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBTaggableUserFragmentModel fBTaggableUserFragmentModel = (FBTaggableUserFragmentModel) obj;
                if (fBTaggableUserFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBTaggableUserFragmentModel.m16678a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBTaggableUserFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBTaggableUserFragmentParser.m16706a(fBTaggableUserFragmentModel.w_(), fBTaggableUserFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBTaggableUserFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FullImageFragmentModel mo894m() {
            return m16676o();
        }

        public FBTaggableUserFragmentModel() {
            super(7);
        }

        public final void m16682a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16683a(String str, Object obj, boolean z) {
        }

        @Nonnull
        private ImmutableList<BylinesModel> m16675n() {
            this.f14669d = super.a(this.f14669d, 0, BylinesModel.class);
            return (ImmutableList) this.f14669d;
        }

        @Nullable
        public final String mo891j() {
            this.f14671f = super.a(this.f14671f, 2);
            return this.f14671f;
        }

        @Nullable
        public final String mo892k() {
            this.f14672g = super.a(this.f14672g, 3);
            return this.f14672g;
        }

        @Nonnull
        public final ImmutableList<String> mo893l() {
            this.f14673h = super.a(this.f14673h, 4);
            return (ImmutableList) this.f14673h;
        }

        @Nullable
        private FullImageFragmentModel m16676o() {
            this.f14674i = (FullImageFragmentModel) super.a(this.f14674i, 5, FullImageFragmentModel.class);
            return this.f14674i;
        }

        @Nullable
        private FBNameFragmentModel m16677p() {
            this.f14675j = (FBNameFragmentModel) super.a(this.f14675j, 6, FBNameFragmentModel.class);
            return this.f14675j;
        }

        @Nullable
        public final String m16680a() {
            return mo891j();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m16679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            FullImageFragmentModel fullImageFragmentModel;
            FBNameFragmentModel fBNameFragmentModel;
            h();
            if (m16675n() != null) {
                Builder a = ModelHelper.a(m16675n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FBTaggableUserFragmentModel fBTaggableUserFragmentModel = (FBTaggableUserFragmentModel) ModelHelper.a(null, this);
                    fBTaggableUserFragmentModel.f14669d = a.b();
                    graphQLVisitableModel = fBTaggableUserFragmentModel;
                    if (m16676o() != null) {
                        fullImageFragmentModel = (FullImageFragmentModel) graphQLModelMutatingVisitor.b(m16676o());
                        if (m16676o() != fullImageFragmentModel) {
                            graphQLVisitableModel = (FBTaggableUserFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14674i = fullImageFragmentModel;
                        }
                    }
                    if (m16677p() != null) {
                        fBNameFragmentModel = (FBNameFragmentModel) graphQLModelMutatingVisitor.b(m16677p());
                        if (m16677p() != fBNameFragmentModel) {
                            graphQLVisitableModel = (FBTaggableUserFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14675j = fBNameFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m16676o() != null) {
                fullImageFragmentModel = (FullImageFragmentModel) graphQLModelMutatingVisitor.b(m16676o());
                if (m16676o() != fullImageFragmentModel) {
                    graphQLVisitableModel = (FBTaggableUserFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14674i = fullImageFragmentModel;
                }
            }
            if (m16677p() != null) {
                fBNameFragmentModel = (FBNameFragmentModel) graphQLModelMutatingVisitor.b(m16677p());
                if (m16677p() != fBNameFragmentModel) {
                    graphQLVisitableModel = (FBTaggableUserFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14675j = fBNameFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m16678a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16675n());
            int b = flatBufferBuilder.b(mo891j());
            int b2 = flatBufferBuilder.b(mo892k());
            int c = flatBufferBuilder.c(mo893l());
            int a2 = ModelHelper.a(flatBufferBuilder, m16676o());
            int a3 = ModelHelper.a(flatBufferBuilder, m16677p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f14670e, 0.0d);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, c);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.b(6, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16681a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14670e = mutableFlatBuffer.a(i, 1, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1098422116)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_ref_mechanism */
    public final class FullImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f14676d;
        @Nullable
        private String f14677e;
        private double f14678f;
        @Nullable
        private String f14679g;
        private int f14680h;

        /* compiled from: event_ref_mechanism */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FullImageFragmentModel.class, new Deserializer());
            }

            public Object m16688a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FullImageFragmentParser.m16707a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fullImageFragmentModel = new FullImageFragmentModel();
                ((BaseModel) fullImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fullImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fullImageFragmentModel).a();
                }
                return fullImageFragmentModel;
            }
        }

        /* compiled from: event_ref_mechanism */
        public class Serializer extends JsonSerializer<FullImageFragmentModel> {
            public final void m16689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FullImageFragmentModel fullImageFragmentModel = (FullImageFragmentModel) obj;
                if (fullImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fullImageFragmentModel.m16691a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fullImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FullImageFragmentParser.m16708a(fullImageFragmentModel.w_(), fullImageFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(FullImageFragmentModel.class, new Serializer());
            }
        }

        public FullImageFragmentModel() {
            super(5);
        }

        @Nullable
        private String m16690j() {
            this.f14677e = super.a(this.f14677e, 1);
            return this.f14677e;
        }

        @Nullable
        public final String m16693a() {
            this.f14679g = super.a(this.f14679g, 3);
            return this.f14679g;
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m16692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16691a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16690j());
            int b2 = flatBufferBuilder.b(m16693a());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f14676d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f14678f, 0.0d);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f14680h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16694a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14676d = mutableFlatBuffer.a(i, 0, 0);
            this.f14678f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f14680h = mutableFlatBuffer.a(i, 4, 0);
        }
    }
}
