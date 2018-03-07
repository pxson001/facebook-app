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
import com.facebook.graphql.deserializers.GraphQLEducationExperienceDeserializer;
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
/* compiled from: ios_feed_add_photo_button */
public final class GraphQLEducationExperience extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEducationExperience> CREATOR = new C02951();
    @Nullable
    String f3516d;
    @Nullable
    GraphQLImage f3517e;
    @Nullable
    GraphQLTextWithEntities f3518f;
    @Nullable
    GraphQLImage f3519g;
    @Nullable
    GraphQLImage f3520h;
    @Nullable
    GraphQLPage f3521i;
    @Nullable
    GraphQLEventTimeRange f3522j;
    @Nullable
    String f3523k;

    /* compiled from: ios_feed_add_photo_button */
    final class C02951 implements Creator<GraphQLEducationExperience> {
        C02951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEducationExperience(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEducationExperience[i];
        }
    }

    /* compiled from: ios_feed_add_photo_button */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEducationExperience.class, new Deserializer());
        }

        public Object m6968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEducationExperienceDeserializer.m4725a(jsonParser, (short) 24);
            Object graphQLEducationExperience = new GraphQLEducationExperience();
            ((BaseModel) graphQLEducationExperience).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEducationExperience instanceof Postprocessable) {
                return ((Postprocessable) graphQLEducationExperience).a();
            }
            return graphQLEducationExperience;
        }
    }

    /* compiled from: ios_feed_add_photo_button */
    public final class Serializer extends JsonSerializer<GraphQLEducationExperience> {
        public final void m6969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEducationExperience graphQLEducationExperience = (GraphQLEducationExperience) obj;
            GraphQLEducationExperienceDeserializer.m4727b(graphQLEducationExperience.w_(), graphQLEducationExperience.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEducationExperience.class, new Serializer());
            FbSerializerProvider.a(GraphQLEducationExperience.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6973j() {
        this.f3516d = super.a(this.f3516d, 0);
        return this.f3516d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6974k() {
        this.f3517e = (GraphQLImage) super.a(this.f3517e, 1, GraphQLImage.class);
        return this.f3517e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6975l() {
        this.f3518f = (GraphQLTextWithEntities) super.a(this.f3518f, 2, GraphQLTextWithEntities.class);
        return this.f3518f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6976m() {
        this.f3519g = (GraphQLImage) super.a(this.f3519g, 3, GraphQLImage.class);
        return this.f3519g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6977n() {
        this.f3520h = (GraphQLImage) super.a(this.f3520h, 4, GraphQLImage.class);
        return this.f3520h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m6978o() {
        this.f3521i = (GraphQLPage) super.a(this.f3521i, 5, GraphQLPage.class);
        return this.f3521i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventTimeRange m6979p() {
        this.f3522j = (GraphQLEventTimeRange) super.a(this.f3522j, 6, GraphQLEventTimeRange.class);
        return this.f3522j;
    }

    @FieldOffset
    @Nullable
    public final String m6980q() {
        this.f3523k = super.a(this.f3523k, 7);
        return this.f3523k;
    }

    @Nullable
    public final String m6972a() {
        return m6973j();
    }

    public final int jK_() {
        return 1264055058;
    }

    public final GraphQLVisitableModel m6971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6974k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6974k());
            if (m6974k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(null, this);
                graphQLVisitableModel.f3517e = graphQLImage;
            }
        }
        if (m6975l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6975l());
            if (m6975l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3518f = graphQLTextWithEntities;
            }
        }
        if (m6976m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6976m());
            if (m6976m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3519g = graphQLImage;
            }
        }
        if (m6977n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6977n());
            if (m6977n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3520h = graphQLImage;
            }
        }
        if (m6978o() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m6978o());
            if (m6978o() != graphQLPage) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3521i = graphQLPage;
            }
        }
        if (m6979p() != null) {
            GraphQLEventTimeRange graphQLEventTimeRange = (GraphQLEventTimeRange) graphQLModelMutatingVisitor.b(m6979p());
            if (m6979p() != graphQLEventTimeRange) {
                graphQLVisitableModel = (GraphQLEducationExperience) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3522j = graphQLEventTimeRange;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEducationExperience() {
        super(9);
    }

    public final int m6970a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6973j());
        int a = ModelHelper.a(flatBufferBuilder, m6974k());
        int a2 = ModelHelper.a(flatBufferBuilder, m6975l());
        int a3 = ModelHelper.a(flatBufferBuilder, m6976m());
        int a4 = ModelHelper.a(flatBufferBuilder, m6977n());
        int a5 = ModelHelper.a(flatBufferBuilder, m6978o());
        int a6 = ModelHelper.a(flatBufferBuilder, m6979p());
        int b2 = flatBufferBuilder.b(m6980q());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, a6);
        flatBufferBuilder.b(7, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEducationExperience(Parcel parcel) {
        super(9);
        this.f3516d = parcel.readString();
        this.f3517e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3518f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3519g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3520h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3521i = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f3522j = (GraphQLEventTimeRange) parcel.readValue(GraphQLEventTimeRange.class.getClassLoader());
        this.f3523k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6973j());
        parcel.writeValue(m6974k());
        parcel.writeValue(m6975l());
        parcel.writeValue(m6976m());
        parcel.writeValue(m6977n());
        parcel.writeValue(m6978o());
        parcel.writeValue(m6979p());
        parcel.writeString(m6980q());
    }
}
