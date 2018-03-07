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
import com.facebook.graphql.deserializers.GraphQLWorkExperienceDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: T_JEWEL */
public final class GraphQLWorkExperience extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLWorkExperience> CREATOR = new C12771();
    @Nullable
    GraphQLPage f13460d;
    @Nullable
    String f13461e;
    @Nullable
    GraphQLImage f13462f;
    @Nullable
    GraphQLTextWithEntities f13463g;
    @Nullable
    GraphQLPage f13464h;
    @Nullable
    GraphQLImage f13465i;
    @Nullable
    GraphQLImage f13466j;
    @Nullable
    GraphQLEventTimeRange f13467k;
    @Nullable
    String f13468l;

    /* compiled from: T_JEWEL */
    final class C12771 implements Creator<GraphQLWorkExperience> {
        C12771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLWorkExperience(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLWorkExperience[i];
        }
    }

    /* compiled from: T_JEWEL */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLWorkExperience.class, new Deserializer());
        }

        public Object m22517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLWorkExperienceDeserializer.m6216a(jsonParser, (short) 25);
            Object graphQLWorkExperience = new GraphQLWorkExperience();
            ((BaseModel) graphQLWorkExperience).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLWorkExperience instanceof Postprocessable) {
                return ((Postprocessable) graphQLWorkExperience).a();
            }
            return graphQLWorkExperience;
        }
    }

    /* compiled from: T_JEWEL */
    public final class Serializer extends JsonSerializer<GraphQLWorkExperience> {
        public final void m22518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLWorkExperience graphQLWorkExperience = (GraphQLWorkExperience) obj;
            GraphQLWorkExperienceDeserializer.m6218b(graphQLWorkExperience.w_(), graphQLWorkExperience.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLWorkExperience.class, new Serializer());
            FbSerializerProvider.a(GraphQLWorkExperience.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m22522j() {
        this.f13460d = (GraphQLPage) super.a(this.f13460d, 0, GraphQLPage.class);
        return this.f13460d;
    }

    @FieldOffset
    @Nullable
    public final String m22523k() {
        this.f13461e = super.a(this.f13461e, 1);
        return this.f13461e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22524l() {
        this.f13462f = (GraphQLImage) super.a(this.f13462f, 2, GraphQLImage.class);
        return this.f13462f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22525m() {
        this.f13463g = (GraphQLTextWithEntities) super.a(this.f13463g, 3, GraphQLTextWithEntities.class);
        return this.f13463g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m22526n() {
        this.f13464h = (GraphQLPage) super.a(this.f13464h, 4, GraphQLPage.class);
        return this.f13464h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22527o() {
        this.f13465i = (GraphQLImage) super.a(this.f13465i, 5, GraphQLImage.class);
        return this.f13465i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22528p() {
        this.f13466j = (GraphQLImage) super.a(this.f13466j, 6, GraphQLImage.class);
        return this.f13466j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventTimeRange m22529q() {
        this.f13467k = (GraphQLEventTimeRange) super.a(this.f13467k, 7, GraphQLEventTimeRange.class);
        return this.f13467k;
    }

    @FieldOffset
    @Nullable
    public final String m22530r() {
        this.f13468l = super.a(this.f13468l, 8);
        return this.f13468l;
    }

    @Nullable
    public final String m22521a() {
        return m22523k();
    }

    public final int jK_() {
        return 1201268603;
    }

    public final GraphQLVisitableModel m22520a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPage graphQLPage;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22522j() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m22522j());
            if (m22522j() != graphQLPage) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(null, this);
                graphQLVisitableModel.f13460d = graphQLPage;
            }
        }
        if (m22524l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22524l());
            if (m22524l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13462f = graphQLImage;
            }
        }
        if (m22525m() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22525m());
            if (m22525m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13463g = graphQLTextWithEntities;
            }
        }
        if (m22526n() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m22526n());
            if (m22526n() != graphQLPage) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13464h = graphQLPage;
            }
        }
        if (m22527o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22527o());
            if (m22527o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13465i = graphQLImage;
            }
        }
        if (m22528p() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22528p());
            if (m22528p() != graphQLImage) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13466j = graphQLImage;
            }
        }
        if (m22529q() != null) {
            GraphQLEventTimeRange graphQLEventTimeRange = (GraphQLEventTimeRange) graphQLModelMutatingVisitor.b(m22529q());
            if (m22529q() != graphQLEventTimeRange) {
                graphQLVisitableModel = (GraphQLWorkExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13467k = graphQLEventTimeRange;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLWorkExperience() {
        super(10);
    }

    public final int m22519a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22522j());
        int b = flatBufferBuilder.b(m22523k());
        int a2 = ModelHelper.a(flatBufferBuilder, m22524l());
        int a3 = ModelHelper.a(flatBufferBuilder, m22525m());
        int a4 = ModelHelper.a(flatBufferBuilder, m22526n());
        int a5 = ModelHelper.a(flatBufferBuilder, m22527o());
        int a6 = ModelHelper.a(flatBufferBuilder, m22528p());
        int a7 = ModelHelper.a(flatBufferBuilder, m22529q());
        int b2 = flatBufferBuilder.b(m22530r());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, a6);
        flatBufferBuilder.b(7, a7);
        flatBufferBuilder.b(8, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLWorkExperience(Parcel parcel) {
        super(10);
        this.f13460d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f13461e = parcel.readString();
        this.f13462f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13463g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13464h = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f13465i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13466j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13467k = (GraphQLEventTimeRange) parcel.readValue(GraphQLEventTimeRange.class.getClassLoader());
        this.f13468l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22522j());
        parcel.writeString(m22523k());
        parcel.writeValue(m22524l());
        parcel.writeValue(m22525m());
        parcel.writeValue(m22526n());
        parcel.writeValue(m22527o());
        parcel.writeValue(m22528p());
        parcel.writeValue(m22529q());
        parcel.writeString(m22530r());
    }
}
