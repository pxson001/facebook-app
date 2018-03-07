package com.facebook.messaging.peopleyoumaymessage.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.peopleyoumaymessage.graphql.PeopleYouMayMessageQueryParsers.PeopleYouMayMessageUserInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: download_fbid */
public class PeopleYouMayMessageQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 125611662)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: download_fbid */
    public final class PeopleYouMayMessageUserInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f15995d;
        private boolean f15996e;
        private boolean f15997f;
        @Nullable
        private DefaultNameFieldsModel f15998g;

        /* compiled from: download_fbid */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeopleYouMayMessageUserInfoModel.class, new Deserializer());
            }

            public Object m16130a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PeopleYouMayMessageUserInfoParser.m16143a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object peopleYouMayMessageUserInfoModel = new PeopleYouMayMessageUserInfoModel();
                ((BaseModel) peopleYouMayMessageUserInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (peopleYouMayMessageUserInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) peopleYouMayMessageUserInfoModel).a();
                }
                return peopleYouMayMessageUserInfoModel;
            }
        }

        /* compiled from: download_fbid */
        public class Serializer extends JsonSerializer<PeopleYouMayMessageUserInfoModel> {
            public final void m16131a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PeopleYouMayMessageUserInfoModel peopleYouMayMessageUserInfoModel = (PeopleYouMayMessageUserInfoModel) obj;
                if (peopleYouMayMessageUserInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peopleYouMayMessageUserInfoModel.m16134a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peopleYouMayMessageUserInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PeopleYouMayMessageUserInfoParser.m16144a(peopleYouMayMessageUserInfoModel.w_(), peopleYouMayMessageUserInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PeopleYouMayMessageUserInfoModel.class, new Serializer());
            }
        }

        public PeopleYouMayMessageUserInfoModel() {
            super(4);
        }

        public final void m16138a(String str, ConsistencyTuple consistencyTuple) {
            if ("is_pymm_hidden".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16133m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16139a(String str, Object obj, boolean z) {
            if ("is_pymm_hidden".equals(str)) {
                m16132a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final String m16140j() {
            this.f15995d = super.a(this.f15995d, 0);
            return this.f15995d;
        }

        public final boolean m16141k() {
            a(0, 1);
            return this.f15996e;
        }

        private boolean m16133m() {
            a(0, 2);
            return this.f15997f;
        }

        private void m16132a(boolean z) {
            this.f15997f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        @Nullable
        public final DefaultNameFieldsModel m16142l() {
            this.f15998g = (DefaultNameFieldsModel) super.a(this.f15998g, 3, DefaultNameFieldsModel.class);
            return this.f15998g;
        }

        @Nullable
        public final String m16136a() {
            return m16140j();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m16135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16142l() != null) {
                DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m16142l());
                if (m16142l() != defaultNameFieldsModel) {
                    graphQLVisitableModel = (PeopleYouMayMessageUserInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15998g = defaultNameFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16134a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16140j());
            int a = ModelHelper.a(flatBufferBuilder, m16142l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f15996e);
            flatBufferBuilder.a(2, this.f15997f);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16137a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15996e = mutableFlatBuffer.a(i, 1);
            this.f15997f = mutableFlatBuffer.a(i, 2);
        }
    }
}
