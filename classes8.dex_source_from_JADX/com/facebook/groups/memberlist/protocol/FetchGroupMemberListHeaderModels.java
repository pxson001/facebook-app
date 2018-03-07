package com.facebook.groups.memberlist.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberListHeaderParsers.FetchGroupMemberListHeaderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: extra_from_uri */
public class FetchGroupMemberListHeaderModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -128836434)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_from_uri */
    public final class FetchGroupMemberListHeaderModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f14503d;
        @Nullable
        private String f14504e;
        @Nullable
        private String f14505f;
        @Nullable
        private GraphQLGroupAdminType f14506g;
        @Nullable
        private GraphQLGroupJoinState f14507h;
        @Nullable
        private GraphQLGroupVisibility f14508i;

        /* compiled from: extra_from_uri */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupMemberListHeaderModel.class, new Deserializer());
            }

            public Object m16171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupMemberListHeaderParser.m16187a(jsonParser);
                Object fetchGroupMemberListHeaderModel = new FetchGroupMemberListHeaderModel();
                ((BaseModel) fetchGroupMemberListHeaderModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupMemberListHeaderModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupMemberListHeaderModel).a();
                }
                return fetchGroupMemberListHeaderModel;
            }
        }

        /* compiled from: extra_from_uri */
        public class Serializer extends JsonSerializer<FetchGroupMemberListHeaderModel> {
            public final void m16172a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchGroupMemberListHeaderModel fetchGroupMemberListHeaderModel = (FetchGroupMemberListHeaderModel) obj;
                if (fetchGroupMemberListHeaderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupMemberListHeaderModel.m16178a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupMemberListHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchGroupMemberListHeaderParser.m16188a(fetchGroupMemberListHeaderModel.w_(), fetchGroupMemberListHeaderModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(FetchGroupMemberListHeaderModel.class, new Serializer());
            }
        }

        public FetchGroupMemberListHeaderModel() {
            super(6);
        }

        public final void m16181a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m16177o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = m16185l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else if ("visibility".equals(str)) {
                consistencyTuple.a = m16186m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m16182a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m16175a((String) obj);
            } else if ("viewer_join_state".equals(str)) {
                m16173a((GraphQLGroupJoinState) obj);
            } else if ("visibility".equals(str)) {
                m16174a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        private String m16176n() {
            this.f14503d = super.a(this.f14503d, 0);
            return this.f14503d;
        }

        @Nullable
        private String m16177o() {
            this.f14504e = super.a(this.f14504e, 1);
            return this.f14504e;
        }

        private void m16175a(@Nullable String str) {
            this.f14504e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        public final String m16183j() {
            this.f14505f = super.a(this.f14505f, 2);
            return this.f14505f;
        }

        @Nullable
        public final GraphQLGroupAdminType m16184k() {
            this.f14506g = (GraphQLGroupAdminType) super.b(this.f14506g, 3, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14506g;
        }

        @Nullable
        public final GraphQLGroupJoinState m16185l() {
            this.f14507h = (GraphQLGroupJoinState) super.b(this.f14507h, 4, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14507h;
        }

        private void m16173a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f14507h = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupVisibility m16186m() {
            this.f14508i = (GraphQLGroupVisibility) super.b(this.f14508i, 5, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14508i;
        }

        private void m16174a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14508i = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        @Nullable
        public final String m16180a() {
            return m16176n();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m16179a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16178a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16176n());
            int b2 = flatBufferBuilder.b(m16177o());
            int b3 = flatBufferBuilder.b(m16183j());
            int a = flatBufferBuilder.a(m16184k());
            int a2 = flatBufferBuilder.a(m16185l());
            int a3 = flatBufferBuilder.a(m16186m());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
