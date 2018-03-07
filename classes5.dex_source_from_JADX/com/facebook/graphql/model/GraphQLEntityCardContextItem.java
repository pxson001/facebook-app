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
import com.facebook.graphql.deserializers.GraphQLEntityCardContextItemDeserializer;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
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
/* compiled from: intern.facebook.com */
public final class GraphQLEntityCardContextItem extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityCardContextItem> CREATOR = new C03001();
    @Nullable
    String f3533d;
    @Nullable
    GraphQLEntityCardContextItemIcon f3534e;
    List<GraphQLEntityCardContextItemLink> f3535f;
    GraphQLEntityCardContextItemType f3536g;
    @Nullable
    String f3537h;
    @Nullable
    GraphQLTextWithEntities f3538i;
    @Nullable
    GraphQLTextWithEntities f3539j;
    @Nullable
    String f3540k;

    /* compiled from: intern.facebook.com */
    final class C03001 implements Creator<GraphQLEntityCardContextItem> {
        C03001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityCardContextItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityCardContextItem[i];
        }
    }

    /* compiled from: intern.facebook.com */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItem.class, new Deserializer());
        }

        public Object m7047a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEntityCardContextItemDeserializer.m4751a(jsonParser, (short) 294);
            Object graphQLEntityCardContextItem = new GraphQLEntityCardContextItem();
            ((BaseModel) graphQLEntityCardContextItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEntityCardContextItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLEntityCardContextItem).a();
            }
            return graphQLEntityCardContextItem;
        }
    }

    /* compiled from: intern.facebook.com */
    public final class Serializer extends JsonSerializer<GraphQLEntityCardContextItem> {
        public final void m7048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEntityCardContextItem graphQLEntityCardContextItem = (GraphQLEntityCardContextItem) obj;
            GraphQLEntityCardContextItemDeserializer.m4752b(graphQLEntityCardContextItem.w_(), graphQLEntityCardContextItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEntityCardContextItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLEntityCardContextItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7051a() {
        this.f3533d = super.a(this.f3533d, 0);
        return this.f3533d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntityCardContextItemIcon m7052j() {
        this.f3534e = (GraphQLEntityCardContextItemIcon) super.a(this.f3534e, 1, GraphQLEntityCardContextItemIcon.class);
        return this.f3534e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEntityCardContextItemLink> m7053k() {
        this.f3535f = super.a(this.f3535f, 2, GraphQLEntityCardContextItemLink.class);
        return (ImmutableList) this.f3535f;
    }

    @FieldOffset
    public final GraphQLEntityCardContextItemType m7054l() {
        this.f3536g = (GraphQLEntityCardContextItemType) super.a(this.f3536g, 3, GraphQLEntityCardContextItemType.class, GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3536g;
    }

    @FieldOffset
    @Nullable
    public final String m7055m() {
        this.f3537h = super.a(this.f3537h, 4);
        return this.f3537h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7056n() {
        this.f3538i = (GraphQLTextWithEntities) super.a(this.f3538i, 5, GraphQLTextWithEntities.class);
        return this.f3538i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7057o() {
        this.f3539j = (GraphQLTextWithEntities) super.a(this.f3539j, 6, GraphQLTextWithEntities.class);
        return this.f3539j;
    }

    @FieldOffset
    @Nullable
    public final String m7058p() {
        this.f3540k = super.a(this.f3540k, 7);
        return this.f3540k;
    }

    public final int jK_() {
        return -1758471761;
    }

    public final GraphQLVisitableModel m7050a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7052j() != null) {
            GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon = (GraphQLEntityCardContextItemIcon) graphQLModelMutatingVisitor.b(m7052j());
            if (m7052j() != graphQLEntityCardContextItemIcon) {
                graphQLVisitableModel = (GraphQLEntityCardContextItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f3534e = graphQLEntityCardContextItemIcon;
            }
        }
        if (m7053k() != null) {
            Builder a = ModelHelper.a(m7053k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEntityCardContextItem graphQLEntityCardContextItem = (GraphQLEntityCardContextItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLEntityCardContextItem.f3535f = a.b();
                graphQLVisitableModel = graphQLEntityCardContextItem;
            }
        }
        if (m7056n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7056n());
            if (m7056n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEntityCardContextItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3538i = graphQLTextWithEntities;
            }
        }
        if (m7057o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7057o());
            if (m7057o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEntityCardContextItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3539j = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntityCardContextItem() {
        super(9);
    }

    public final int m7049a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7051a());
        int a = ModelHelper.a(flatBufferBuilder, m7052j());
        int a2 = ModelHelper.a(flatBufferBuilder, m7053k());
        int b2 = flatBufferBuilder.b(m7055m());
        int a3 = ModelHelper.a(flatBufferBuilder, m7056n());
        int a4 = ModelHelper.a(flatBufferBuilder, m7057o());
        int b3 = flatBufferBuilder.b(m7058p());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.a(3, m7054l() == GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7054l());
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEntityCardContextItem(Parcel parcel) {
        super(9);
        this.f3533d = parcel.readString();
        this.f3534e = (GraphQLEntityCardContextItemIcon) parcel.readValue(GraphQLEntityCardContextItemIcon.class.getClassLoader());
        this.f3535f = ImmutableListHelper.a(parcel.readArrayList(GraphQLEntityCardContextItemLink.class.getClassLoader()));
        this.f3536g = GraphQLEntityCardContextItemType.fromString(parcel.readString());
        this.f3537h = parcel.readString();
        this.f3538i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3539j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3540k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7051a());
        parcel.writeValue(m7052j());
        parcel.writeList(m7053k());
        parcel.writeString(m7054l().name());
        parcel.writeString(m7055m());
        parcel.writeValue(m7056n());
        parcel.writeValue(m7057o());
        parcel.writeString(m7058p());
    }
}
