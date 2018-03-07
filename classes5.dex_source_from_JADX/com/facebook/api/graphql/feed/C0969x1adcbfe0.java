package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser.ViewerActsAsPageParser;
import com.facebook.api.graphql.feedback.C0963x86c33d71;
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
@ModelWithFlatBufferFormatHash(a = 2106355611)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: app_center_categories */
public final class C0969x1adcbfe0 extends BaseModel implements C0963x86c33d71, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f9298d;
    @Nullable
    private String f9299e;
    @Nullable
    private DefaultImageFieldsModel f9300f;

    /* compiled from: app_center_categories */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0969x1adcbfe0.class, new Deserializer());
        }

        public Object m15870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ViewerActsAsPageParser.m15887a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0969x1adcbfe0 = new C0969x1adcbfe0();
            ((BaseModel) c0969x1adcbfe0).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0969x1adcbfe0 instanceof Postprocessable) {
                return ((Postprocessable) c0969x1adcbfe0).a();
            }
            return c0969x1adcbfe0;
        }
    }

    /* compiled from: app_center_categories */
    public class Serializer extends JsonSerializer<C0969x1adcbfe0> {
        public final void m15871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0969x1adcbfe0 c0969x1adcbfe0 = (C0969x1adcbfe0) obj;
            if (c0969x1adcbfe0.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0969x1adcbfe0.m15873a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0969x1adcbfe0.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ViewerActsAsPageParser.m15888a(c0969x1adcbfe0.w_(), c0969x1adcbfe0.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0969x1adcbfe0.class, new Serializer());
        }
    }

    @Nullable
    public final /* synthetic */ DefaultImageFields mo1113d() {
        return m15872j();
    }

    public C0969x1adcbfe0() {
        super(3);
    }

    public final void m15876a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m15877a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final String mo1111b() {
        this.f9298d = super.a(this.f9298d, 0);
        return this.f9298d;
    }

    @Nullable
    public final String mo1112c() {
        this.f9299e = super.a(this.f9299e, 1);
        return this.f9299e;
    }

    @Nullable
    private DefaultImageFieldsModel m15872j() {
        this.f9300f = (DefaultImageFieldsModel) super.a(this.f9300f, 2, DefaultImageFieldsModel.class);
        return this.f9300f;
    }

    @Nullable
    public final String m15875a() {
        return mo1111b();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m15874a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m15872j() != null) {
            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15872j());
            if (m15872j() != defaultImageFieldsModel) {
                graphQLVisitableModel = (C0969x1adcbfe0) ModelHelper.a(null, this);
                graphQLVisitableModel.f9300f = defaultImageFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m15873a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(mo1111b());
        int b2 = flatBufferBuilder.b(mo1112c());
        int a = ModelHelper.a(flatBufferBuilder, m15872j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        i();
        return flatBufferBuilder.d();
    }
}
