package com.facebook.confirmation.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsParsers.FBResendContactpointCodeCoreMutationFragmentParser;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsParsers.FBResendContactpointCodeCoreMutationFragmentParser.ViewerParser;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsParsers.FBResendContactpointCodeCoreMutationFragmentParser.ViewerParser.ActorParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: interacted_unit_ids */
public class FBResendContactpointCodeFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1714701036)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: interacted_unit_ids */
    public final class FBResendContactpointCodeCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f10768d;

        /* compiled from: interacted_unit_ids */
        public final class Builder {
            @Nullable
            public ViewerModel f10764a;
        }

        /* compiled from: interacted_unit_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBResendContactpointCodeCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m12692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBResendContactpointCodeCoreMutationFragmentParser.m12715a(jsonParser);
                Object fBResendContactpointCodeCoreMutationFragmentModel = new FBResendContactpointCodeCoreMutationFragmentModel();
                ((BaseModel) fBResendContactpointCodeCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBResendContactpointCodeCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBResendContactpointCodeCoreMutationFragmentModel).a();
                }
                return fBResendContactpointCodeCoreMutationFragmentModel;
            }
        }

        /* compiled from: interacted_unit_ids */
        public class Serializer extends JsonSerializer<FBResendContactpointCodeCoreMutationFragmentModel> {
            public final void m12693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBResendContactpointCodeCoreMutationFragmentModel fBResendContactpointCodeCoreMutationFragmentModel = (FBResendContactpointCodeCoreMutationFragmentModel) obj;
                if (fBResendContactpointCodeCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBResendContactpointCodeCoreMutationFragmentModel.m12709a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBResendContactpointCodeCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBResendContactpointCodeCoreMutationFragmentModel.w_();
                int u_ = fBResendContactpointCodeCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m12714a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBResendContactpointCodeCoreMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 529366490)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: interacted_unit_ids */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f10767d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: interacted_unit_ids */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f10765d;
                @Nullable
                private String f10766e;

                /* compiled from: interacted_unit_ids */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m12694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.m12711a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorModel = new ActorModel();
                        ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorModel instanceof Postprocessable) {
                            return ((Postprocessable) actorModel).a();
                        }
                        return actorModel;
                    }
                }

                /* compiled from: interacted_unit_ids */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m12695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m12698a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorParser.m12712a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m12701a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m12702a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m12696j() {
                    if (this.b != null && this.f10765d == null) {
                        this.f10765d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10765d;
                }

                @Nullable
                private String m12697k() {
                    this.f10766e = super.a(this.f10766e, 1);
                    return this.f10766e;
                }

                @Nullable
                public final String m12700a() {
                    return m12697k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m12699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m12698a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12696j());
                    int b = flatBufferBuilder.b(m12697k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: interacted_unit_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m12703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m12713a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: interacted_unit_ids */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m12704a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m12706a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m12714a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m12705a() {
                this.f10767d = (ActorModel) super.a(this.f10767d, 0, ActorModel.class);
                return this.f10767d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m12707a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12705a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m12705a());
                    if (m12705a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10767d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12706a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12705a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBResendContactpointCodeCoreMutationFragmentModel() {
            super(1);
        }

        public FBResendContactpointCodeCoreMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ViewerModel m12708a() {
            this.f10768d = (ViewerModel) super.a(this.f10768d, 0, ViewerModel.class);
            return this.f10768d;
        }

        public final int jK_() {
            return -143196939;
        }

        public final GraphQLVisitableModel m12710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12708a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m12708a());
                if (m12708a() != viewerModel) {
                    graphQLVisitableModel = (FBResendContactpointCodeCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10768d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12709a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12708a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
