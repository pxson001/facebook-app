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
import com.facebook.graphql.deserializers.GraphQLLeadGenLegalContentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: feed_promotion_icon_image */
public final class GraphQLLeadGenLegalContent extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenLegalContent> CREATOR = new C04231();
    @Nullable
    String f4379d;
    List<GraphQLLeadGenLegalContentCheckbox> f4380e;
    List<GraphQLTextWithEntities> f4381f;
    @Nullable
    String f4382g;

    /* compiled from: feed_promotion_icon_image */
    final class C04231 implements Creator<GraphQLLeadGenLegalContent> {
        C04231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenLegalContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenLegalContent[i];
        }
    }

    /* compiled from: feed_promotion_icon_image */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenLegalContent.class, new Deserializer());
        }

        public Object m8854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenLegalContentDeserializer.m5303a(jsonParser, (short) 172);
            Object graphQLLeadGenLegalContent = new GraphQLLeadGenLegalContent();
            ((BaseModel) graphQLLeadGenLegalContent).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenLegalContent instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenLegalContent).a();
            }
            return graphQLLeadGenLegalContent;
        }
    }

    /* compiled from: feed_promotion_icon_image */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenLegalContent> {
        public final void m8855a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenLegalContent graphQLLeadGenLegalContent = (GraphQLLeadGenLegalContent) obj;
            GraphQLLeadGenLegalContentDeserializer.m5304a(graphQLLeadGenLegalContent.w_(), graphQLLeadGenLegalContent.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenLegalContent.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenLegalContent.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8858a() {
        this.f4379d = super.a(this.f4379d, 0);
        return this.f4379d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenLegalContentCheckbox> m8859j() {
        this.f4380e = super.a(this.f4380e, 1, GraphQLLeadGenLegalContentCheckbox.class);
        return (ImmutableList) this.f4380e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTextWithEntities> m8860k() {
        this.f4381f = super.a(this.f4381f, 2, GraphQLTextWithEntities.class);
        return (ImmutableList) this.f4381f;
    }

    @FieldOffset
    @Nullable
    public final String m8861l() {
        this.f4382g = super.a(this.f4382g, 3);
        return this.f4382g;
    }

    public final int jK_() {
        return -1148993580;
    }

    public final GraphQLVisitableModel m8857a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8859j() != null) {
            a = ModelHelper.a(m8859j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLLeadGenLegalContent) ModelHelper.a(null, this);
                graphQLVisitableModel.f4380e = a.b();
            }
        }
        if (m8860k() != null) {
            a = ModelHelper.a(m8860k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLLeadGenLegalContent) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4381f = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLeadGenLegalContent() {
        super(5);
    }

    public final int m8856a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8858a());
        int a = ModelHelper.a(flatBufferBuilder, m8859j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8860k());
        int b2 = flatBufferBuilder.b(m8861l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenLegalContent(Parcel parcel) {
        super(5);
        this.f4379d = parcel.readString();
        this.f4380e = ImmutableListHelper.a(parcel.readArrayList(GraphQLLeadGenLegalContentCheckbox.class.getClassLoader()));
        this.f4381f = ImmutableListHelper.a(parcel.readArrayList(GraphQLTextWithEntities.class.getClassLoader()));
        this.f4382g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8858a());
        parcel.writeList(m8859j());
        parcel.writeList(m8860k());
        parcel.writeString(m8861l());
    }
}
