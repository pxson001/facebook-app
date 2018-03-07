package com.facebook.photos.data.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: suggested_friend */
public class PhotosDefaultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -936098439)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_friend */
    public final class SizeAwareMediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
        @Nullable
        private GraphQLObjectType f3555d;
        @Nullable
        private DefaultVect2FieldsModel f3556e;
        @Nullable
        private String f3557f;
        @Nullable
        private DefaultImageFieldsModel f3558g;
        @Nullable
        private DefaultImageFieldsModel f3559h;
        @Nullable
        private DefaultImageFieldsModel f3560i;
        @Nullable
        private DefaultImageFieldsModel f3561j;

        /* compiled from: suggested_friend */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f3548a;
            @Nullable
            public DefaultVect2FieldsModel f3549b;
            @Nullable
            public String f3550c;
            @Nullable
            public DefaultImageFieldsModel f3551d;
            @Nullable
            public DefaultImageFieldsModel f3552e;
            @Nullable
            public DefaultImageFieldsModel f3553f;
            @Nullable
            public DefaultImageFieldsModel f3554g;
        }

        /* compiled from: suggested_friend */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SizeAwareMediaModel.class, new Deserializer());
            }

            public Object m4774a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SizeAwareMediaParser.m4789a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object sizeAwareMediaModel = new SizeAwareMediaModel();
                ((BaseModel) sizeAwareMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (sizeAwareMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) sizeAwareMediaModel).a();
                }
                return sizeAwareMediaModel;
            }
        }

        /* compiled from: suggested_friend */
        public class Serializer extends JsonSerializer<SizeAwareMediaModel> {
            public final void m4775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) obj;
                if (sizeAwareMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sizeAwareMediaModel.m4782a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sizeAwareMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SizeAwareMediaParser.m4792b(sizeAwareMediaModel.w_(), sizeAwareMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SizeAwareMediaModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m4781n();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m4780m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m4778k();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m4786c() {
            return m4777j();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m4788g() {
            return m4779l();
        }

        public SizeAwareMediaModel() {
            super(7);
        }

        public SizeAwareMediaModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m4785b() {
            if (this.b != null && this.f3555d == null) {
                this.f3555d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3555d;
        }

        @Nullable
        private DefaultVect2FieldsModel m4777j() {
            this.f3556e = (DefaultVect2FieldsModel) super.a(this.f3556e, 1, DefaultVect2FieldsModel.class);
            return this.f3556e;
        }

        @Nullable
        public final String m4787d() {
            this.f3557f = super.a(this.f3557f, 2);
            return this.f3557f;
        }

        @Nullable
        private DefaultImageFieldsModel m4778k() {
            this.f3558g = (DefaultImageFieldsModel) super.a(this.f3558g, 3, DefaultImageFieldsModel.class);
            return this.f3558g;
        }

        @Nullable
        private DefaultImageFieldsModel m4779l() {
            this.f3559h = (DefaultImageFieldsModel) super.a(this.f3559h, 4, DefaultImageFieldsModel.class);
            return this.f3559h;
        }

        @Nullable
        private DefaultImageFieldsModel m4780m() {
            this.f3560i = (DefaultImageFieldsModel) super.a(this.f3560i, 5, DefaultImageFieldsModel.class);
            return this.f3560i;
        }

        @Nullable
        private DefaultImageFieldsModel m4781n() {
            this.f3561j = (DefaultImageFieldsModel) super.a(this.f3561j, 6, DefaultImageFieldsModel.class);
            return this.f3561j;
        }

        public static SizeAwareMediaModel m4776a(SizeAwareMedia sizeAwareMedia) {
            if (sizeAwareMedia == null) {
                return null;
            }
            if (sizeAwareMedia instanceof SizeAwareMediaModel) {
                return (SizeAwareMediaModel) sizeAwareMedia;
            }
            Builder builder = new Builder();
            builder.f3548a = sizeAwareMedia.b();
            builder.f3549b = DefaultVect2FieldsModel.a(sizeAwareMedia.c());
            builder.f3550c = sizeAwareMedia.d();
            builder.f3551d = DefaultImageFieldsModel.a(sizeAwareMedia.be_());
            builder.f3552e = DefaultImageFieldsModel.a(sizeAwareMedia.g());
            builder.f3553f = DefaultImageFieldsModel.a(sizeAwareMedia.bd_());
            builder.f3554g = DefaultImageFieldsModel.a(sizeAwareMedia.bc_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f3548a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f3549b);
            int b = flatBufferBuilder.b(builder.f3550c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f3551d);
            int a4 = ModelHelper.a(flatBufferBuilder, builder.f3552e);
            int a5 = ModelHelper.a(flatBufferBuilder, builder.f3553f);
            int a6 = ModelHelper.a(flatBufferBuilder, builder.f3554g);
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SizeAwareMediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m4784a() {
            return m4787d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m4783a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4777j() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m4777j());
                if (m4777j() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (SizeAwareMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3556e = defaultVect2FieldsModel;
                }
            }
            if (m4778k() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4778k());
                if (m4778k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SizeAwareMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3558g = defaultImageFieldsModel;
                }
            }
            if (m4779l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4779l());
                if (m4779l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SizeAwareMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3559h = defaultImageFieldsModel;
                }
            }
            if (m4780m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4780m());
                if (m4780m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SizeAwareMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3560i = defaultImageFieldsModel;
                }
            }
            if (m4781n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4781n());
                if (m4781n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SizeAwareMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3561j = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4782a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4785b());
            int a2 = ModelHelper.a(flatBufferBuilder, m4777j());
            int b = flatBufferBuilder.b(m4787d());
            int a3 = ModelHelper.a(flatBufferBuilder, m4778k());
            int a4 = ModelHelper.a(flatBufferBuilder, m4779l());
            int a5 = ModelHelper.a(flatBufferBuilder, m4780m());
            int a6 = ModelHelper.a(flatBufferBuilder, m4781n());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            i();
            return flatBufferBuilder.d();
        }
    }
}
