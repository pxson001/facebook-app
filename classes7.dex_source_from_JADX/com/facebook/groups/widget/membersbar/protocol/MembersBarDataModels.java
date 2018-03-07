package com.facebook.groups.widget.membersbar.protocol;

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
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataParsers.MembersBarDataParser;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataParsers.MembersBarDataParser.EdgesParser;
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

/* compiled from: primary_button_intent */
public class MembersBarDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1161229357)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: primary_button_intent */
    public final class MembersBarDataModel extends BaseModel implements GraphQLVisitableModel {
        private int f6054d;
        @Nullable
        private List<EdgesModel> f6055e;

        /* compiled from: primary_button_intent */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MembersBarDataModel.class, new Deserializer());
            }

            public Object m7830a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MembersBarDataParser.m7846a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object membersBarDataModel = new MembersBarDataModel();
                ((BaseModel) membersBarDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (membersBarDataModel instanceof Postprocessable) {
                    return ((Postprocessable) membersBarDataModel).a();
                }
                return membersBarDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1329931146)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: primary_button_intent */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f6052d;
            @Nullable
            private GroupMemberDataModel f6053e;

            /* compiled from: primary_button_intent */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m7831a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m7844b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            /* compiled from: primary_button_intent */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m7832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m7834a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m7845b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ GroupMemberData m7836a() {
                return m7833j();
            }

            public EdgesModel() {
                super(2);
            }

            @Nullable
            private GroupMemberDataModel m7833j() {
                this.f6053e = (GroupMemberDataModel) super.a(this.f6053e, 1, GroupMemberDataModel.class);
                return this.f6053e;
            }

            public final int jK_() {
                return -1730431337;
            }

            public final GraphQLVisitableModel m7835a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7833j() != null) {
                    GroupMemberDataModel groupMemberDataModel = (GroupMemberDataModel) graphQLModelMutatingVisitor.b(m7833j());
                    if (m7833j() != groupMemberDataModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6053e = groupMemberDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7834a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7833j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f6052d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7837a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6052d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: primary_button_intent */
        public class Serializer extends JsonSerializer<MembersBarDataModel> {
            public final void m7838a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MembersBarDataModel membersBarDataModel = (MembersBarDataModel) obj;
                if (membersBarDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(membersBarDataModel.m7840a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    membersBarDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MembersBarDataParser.m7847a(membersBarDataModel.w_(), membersBarDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MembersBarDataModel.class, new Serializer());
            }
        }

        public MembersBarDataModel() {
            super(2);
        }

        public final int m7839a() {
            a(0, 0);
            return this.f6054d;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m7843b() {
            this.f6055e = super.a(this.f6055e, 1, EdgesModel.class);
            return (ImmutableList) this.f6055e;
        }

        public final int jK_() {
            return 103365688;
        }

        public final GraphQLVisitableModel m7841a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7843b() != null) {
                Builder a = ModelHelper.a(m7843b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MembersBarDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6055e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7840a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7843b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f6054d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7842a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6054d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}
