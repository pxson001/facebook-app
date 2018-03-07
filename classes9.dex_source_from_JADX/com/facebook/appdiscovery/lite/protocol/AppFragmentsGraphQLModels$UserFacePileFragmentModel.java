package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.ActorFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.UserFacePileFragmentParser;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 702630869)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class AppFragmentsGraphQLModels$UserFacePileFragmentModel extends BaseModel implements ActorFacePileFragment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private GraphQLObjectType f4074d;
    @Nullable
    private String f4075e;
    @Nullable
    private String f4076f;
    @Nullable
    private DefaultImageFieldsModel f4077g;
    @Nullable
    private String f4078h;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(AppFragmentsGraphQLModels$UserFacePileFragmentModel.class, new Deserializer());
        }

        public Object m3996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(UserFacePileFragmentParser.m4044a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object appFragmentsGraphQLModels$UserFacePileFragmentModel = new AppFragmentsGraphQLModels$UserFacePileFragmentModel();
            ((BaseModel) appFragmentsGraphQLModels$UserFacePileFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (appFragmentsGraphQLModels$UserFacePileFragmentModel instanceof Postprocessable) {
                return ((Postprocessable) appFragmentsGraphQLModels$UserFacePileFragmentModel).a();
            }
            return appFragmentsGraphQLModels$UserFacePileFragmentModel;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<AppFragmentsGraphQLModels$UserFacePileFragmentModel> {
        public final void m3997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AppFragmentsGraphQLModels$UserFacePileFragmentModel appFragmentsGraphQLModels$UserFacePileFragmentModel = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) obj;
            if (appFragmentsGraphQLModels$UserFacePileFragmentModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(appFragmentsGraphQLModels$UserFacePileFragmentModel.m4001a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                appFragmentsGraphQLModels$UserFacePileFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            UserFacePileFragmentParser.m4047b(appFragmentsGraphQLModels$UserFacePileFragmentModel.w_(), appFragmentsGraphQLModels$UserFacePileFragmentModel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(AppFragmentsGraphQLModels$UserFacePileFragmentModel.class, new Serializer());
        }
    }

    @Nullable
    public final /* synthetic */ DefaultImageFields m4008d() {
        return m3999k();
    }

    public AppFragmentsGraphQLModels$UserFacePileFragmentModel() {
        super(5);
    }

    public final void m4004a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m4005a(String str, Object obj, boolean z) {
    }

    @Nullable
    private GraphQLObjectType m3998j() {
        if (this.b != null && this.f4074d == null) {
            this.f4074d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f4074d;
    }

    @Nullable
    public final String m4007c() {
        this.f4075e = super.a(this.f4075e, 1);
        return this.f4075e;
    }

    @Nullable
    public final String m4006b() {
        this.f4076f = super.a(this.f4076f, 2);
        return this.f4076f;
    }

    @Nullable
    private DefaultImageFieldsModel m3999k() {
        this.f4077g = (DefaultImageFieldsModel) super.a(this.f4077g, 3, DefaultImageFieldsModel.class);
        return this.f4077g;
    }

    @Nullable
    private String m4000l() {
        this.f4078h = super.a(this.f4078h, 4);
        return this.f4078h;
    }

    @Nullable
    public final String m4003a() {
        return m4007c();
    }

    public final int jK_() {
        return 2645995;
    }

    public final GraphQLVisitableModel m4002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3999k() != null) {
            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3999k());
            if (m3999k() != defaultImageFieldsModel) {
                graphQLVisitableModel = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f4077g = defaultImageFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m4001a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3998j());
        int b = flatBufferBuilder.b(m4007c());
        int b2 = flatBufferBuilder.b(m4006b());
        int a2 = ModelHelper.a(flatBufferBuilder, m3999k());
        int b3 = flatBufferBuilder.b(m4000l());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, b3);
        i();
        return flatBufferBuilder.d();
    }
}
