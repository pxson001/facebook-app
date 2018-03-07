package com.facebook.groups.events.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.events.protocol.FetchGroupNameInfoParsers.FetchGroupNameInfoParser;
import com.facebook.groups.events.protocol.FetchGroupNameInfoParsers.FetchGroupNameInfoParser.ParentGroupParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: UNEXPECTED_REDIRECT */
public class FetchGroupNameInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -608144870)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UNEXPECTED_REDIRECT */
    public final class FetchGroupNameInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f21878d;
        @Nullable
        private ParentGroupModel f21879e;
        @Nullable
        private GraphQLGroupPostStatus f21880f;
        @Nullable
        private GraphQLGroupVisibility f21881g;

        /* compiled from: UNEXPECTED_REDIRECT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupNameInfoModel.class, new Deserializer());
            }

            public Object m23020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupNameInfoParser.m23042a(jsonParser);
                Object fetchGroupNameInfoModel = new FetchGroupNameInfoModel();
                ((BaseModel) fetchGroupNameInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupNameInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupNameInfoModel).a();
                }
                return fetchGroupNameInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UNEXPECTED_REDIRECT */
        public final class ParentGroupModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f21877d;

            /* compiled from: UNEXPECTED_REDIRECT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentGroupModel.class, new Deserializer());
                }

                public Object m23021a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentGroupParser.m23040a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentGroupModel = new ParentGroupModel();
                    ((BaseModel) parentGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) parentGroupModel).a();
                    }
                    return parentGroupModel;
                }
            }

            /* compiled from: UNEXPECTED_REDIRECT */
            public class Serializer extends JsonSerializer<ParentGroupModel> {
                public final void m23022a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentGroupModel parentGroupModel = (ParentGroupModel) obj;
                    if (parentGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentGroupModel.m23024a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentGroupParser.m23041a(parentGroupModel.w_(), parentGroupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentGroupModel.class, new Serializer());
                }
            }

            public ParentGroupModel() {
                super(1);
            }

            public final void m23027a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m23026a();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m23028a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m23023a((String) obj);
                }
            }

            @Nullable
            public final String m23026a() {
                this.f21877d = super.a(this.f21877d, 0);
                return this.f21877d;
            }

            private void m23023a(@Nullable String str) {
                this.f21877d = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, str);
                }
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m23025a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23024a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23026a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: UNEXPECTED_REDIRECT */
        public class Serializer extends JsonSerializer<FetchGroupNameInfoModel> {
            public final void m23029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupNameInfoModel fetchGroupNameInfoModel = (FetchGroupNameInfoModel) obj;
                if (fetchGroupNameInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupNameInfoModel.m23032a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupNameInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupNameInfoModel.w_();
                int u_ = fetchGroupNameInfoModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("parent_group");
                    ParentGroupParser.m23041a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("viewer_post_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupNameInfoModel.class, new Serializer());
            }
        }

        public FetchGroupNameInfoModel() {
            super(4);
        }

        public final void m23035a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m23034a();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("visibility".equals(str)) {
                consistencyTuple.a = m23039l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m23036a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m23031a((String) obj);
            } else if ("visibility".equals(str)) {
                m23030a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        public final String m23034a() {
            this.f21878d = super.a(this.f21878d, 0);
            return this.f21878d;
        }

        private void m23031a(@Nullable String str) {
            this.f21878d = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, str);
            }
        }

        @Nullable
        public final ParentGroupModel m23037j() {
            this.f21879e = (ParentGroupModel) super.a(this.f21879e, 1, ParentGroupModel.class);
            return this.f21879e;
        }

        @Nullable
        public final GraphQLGroupPostStatus m23038k() {
            this.f21880f = (GraphQLGroupPostStatus) super.b(this.f21880f, 2, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21880f;
        }

        @Nullable
        public final GraphQLGroupVisibility m23039l() {
            this.f21881g = (GraphQLGroupVisibility) super.b(this.f21881g, 3, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21881g;
        }

        private void m23030a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f21881g = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m23033a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23037j() != null) {
                ParentGroupModel parentGroupModel = (ParentGroupModel) graphQLModelMutatingVisitor.b(m23037j());
                if (m23037j() != parentGroupModel) {
                    graphQLVisitableModel = (FetchGroupNameInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21879e = parentGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23032a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23034a());
            int a = ModelHelper.a(flatBufferBuilder, m23037j());
            int a2 = flatBufferBuilder.a(m23038k());
            int a3 = flatBufferBuilder.a(m23039l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
