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
import com.facebook.graphql.deserializers.GraphQLLeadGenContextPageDeserializer;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
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
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: feed_unit_preview */
public final class GraphQLLeadGenContextPage extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenContextPage> CREATOR = new C04211();
    public List<String> f4363d;
    public GraphQLLeadGenContextPageContentStyle f4364e;
    @Nullable
    public String f4365f;
    @Nullable
    public GraphQLImage f4366g;
    @Nullable
    public String f4367h;
    @Nullable
    public GraphQLPhoto f4368i;

    /* compiled from: feed_unit_preview */
    final class C04211 implements Creator<GraphQLLeadGenContextPage> {
        C04211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenContextPage(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenContextPage[i];
        }
    }

    /* compiled from: feed_unit_preview */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenContextPage.class, new Deserializer());
        }

        public Object m8802a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenContextPageDeserializer.m5281a(jsonParser, (short) 173);
            Object graphQLLeadGenContextPage = new GraphQLLeadGenContextPage();
            ((BaseModel) graphQLLeadGenContextPage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenContextPage instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenContextPage).a();
            }
            return graphQLLeadGenContextPage;
        }
    }

    /* compiled from: feed_unit_preview */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenContextPage> {
        public final void m8803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenContextPage graphQLLeadGenContextPage = (GraphQLLeadGenContextPage) obj;
            GraphQLLeadGenContextPageDeserializer.m5282a(graphQLLeadGenContextPage.w_(), graphQLLeadGenContextPage.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenContextPage.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenContextPage.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m8806a() {
        this.f4363d = super.a(this.f4363d, 0);
        return (ImmutableList) this.f4363d;
    }

    @FieldOffset
    public final GraphQLLeadGenContextPageContentStyle m8807j() {
        this.f4364e = (GraphQLLeadGenContextPageContentStyle) super.a(this.f4364e, 1, GraphQLLeadGenContextPageContentStyle.class, GraphQLLeadGenContextPageContentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4364e;
    }

    @FieldOffset
    @Nullable
    public final String m8808k() {
        this.f4365f = super.a(this.f4365f, 2);
        return this.f4365f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8809l() {
        this.f4366g = (GraphQLImage) super.a(this.f4366g, 3, GraphQLImage.class);
        return this.f4366g;
    }

    @FieldOffset
    @Nullable
    public final String m8810m() {
        this.f4367h = super.a(this.f4367h, 4);
        return this.f4367h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m8811n() {
        this.f4368i = (GraphQLPhoto) super.a(this.f4368i, 5, GraphQLPhoto.class);
        return this.f4368i;
    }

    public final int jK_() {
        return 706615818;
    }

    public final GraphQLVisitableModel m8805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8811n() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m8811n());
            if (m8811n() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLLeadGenContextPage) ModelHelper.a(null, this);
                graphQLVisitableModel.f4368i = graphQLPhoto;
            }
        }
        if (m8809l() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8809l());
            if (m8809l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLLeadGenContextPage) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4366g = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLeadGenContextPage() {
        super(7);
    }

    public final int m8804a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int c = flatBufferBuilder.c(m8806a());
        int b = flatBufferBuilder.b(m8808k());
        int a = ModelHelper.a(flatBufferBuilder, m8809l());
        int b2 = flatBufferBuilder.b(m8810m());
        int a2 = ModelHelper.a(flatBufferBuilder, m8811n());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.a(1, m8807j() == GraphQLLeadGenContextPageContentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8807j());
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenContextPage(Parcel parcel) {
        super(7);
        this.f4368i = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f4363d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4364e = GraphQLLeadGenContextPageContentStyle.fromString(parcel.readString());
        this.f4365f = parcel.readString();
        this.f4366g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4367h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8811n());
        parcel.writeList(m8806a());
        parcel.writeString(m8807j().name());
        parcel.writeString(m8808k());
        parcel.writeValue(m8809l());
        parcel.writeString(m8810m());
    }
}
