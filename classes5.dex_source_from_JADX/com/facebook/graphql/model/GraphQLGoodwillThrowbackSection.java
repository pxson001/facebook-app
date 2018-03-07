package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackSectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: getPhoneSignalStrengthTime */
public final class GraphQLGoodwillThrowbackSection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackSection> CREATOR = new C03691();
    @Nullable
    GraphQLImage f4034d;
    @Nullable
    String f4035e;
    @Nullable
    GraphQLTextWithEntities f4036f;
    @Nullable
    GraphQLTextWithEntities f4037g;

    /* compiled from: getPhoneSignalStrengthTime */
    final class C03691 implements Creator<GraphQLGoodwillThrowbackSection> {
        C03691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackSection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackSection[i];
        }
    }

    /* compiled from: getPhoneSignalStrengthTime */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackSection.class, new Deserializer());
        }

        public Object m8103a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackSectionDeserializer.m5069a(jsonParser, (short) 405);
            Object graphQLGoodwillThrowbackSection = new GraphQLGoodwillThrowbackSection();
            ((BaseModel) graphQLGoodwillThrowbackSection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackSection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackSection).a();
            }
            return graphQLGoodwillThrowbackSection;
        }
    }

    /* compiled from: getPhoneSignalStrengthTime */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackSection> {
        public final void m8104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = (GraphQLGoodwillThrowbackSection) obj;
            GraphQLGoodwillThrowbackSectionDeserializer.m5070a(graphQLGoodwillThrowbackSection.w_(), graphQLGoodwillThrowbackSection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackSection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackSection.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLImage m8106a() {
        return m8110j();
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLTextWithEntities m8108b() {
        return m8112l();
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLTextWithEntities m8109c() {
        return m8113m();
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8110j() {
        this.f4034d = (GraphQLImage) super.a(this.f4034d, 0, GraphQLImage.class);
        return this.f4034d;
    }

    @FieldOffset
    @Nullable
    public final String m8111k() {
        this.f4035e = super.a(this.f4035e, 1);
        return this.f4035e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8112l() {
        this.f4036f = (GraphQLTextWithEntities) super.a(this.f4036f, 2, GraphQLTextWithEntities.class);
        return this.f4036f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8113m() {
        this.f4037g = (GraphQLTextWithEntities) super.a(this.f4037g, 3, GraphQLTextWithEntities.class);
        return this.f4037g;
    }

    public final int jK_() {
        return -1916653145;
    }

    public final GraphQLVisitableModel m8107a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8110j() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8110j());
            if (m8110j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackSection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4034d = graphQLImage;
            }
        }
        if (m8112l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8112l());
            if (m8112l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackSection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4036f = graphQLTextWithEntities;
            }
        }
        if (m8113m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8113m());
            if (m8113m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackSection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4037g = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackSection() {
        super(5);
    }

    public final int m8105a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8110j());
        int b = flatBufferBuilder.b(m8111k());
        int a2 = ModelHelper.a(flatBufferBuilder, m8112l());
        int a3 = ModelHelper.a(flatBufferBuilder, m8113m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackSection(Parcel parcel) {
        super(5);
        this.f4034d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4035e = parcel.readString();
        this.f4036f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4037g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8110j());
        parcel.writeString(m8111k());
        parcel.writeValue(m8112l());
        parcel.writeValue(m8113m());
    }
}
