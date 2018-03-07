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
import com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
/* compiled from: VIEW_GROUP_PHOTOS */
public final class GraphQLQuotesAnalysisItem extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuotesAnalysisItem> CREATOR = new C11991();
    public int f12877d;
    @Nullable
    public String f12878e;

    /* compiled from: VIEW_GROUP_PHOTOS */
    final class C11991 implements Creator<GraphQLQuotesAnalysisItem> {
        C11991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuotesAnalysisItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuotesAnalysisItem[i];
        }
    }

    /* compiled from: VIEW_GROUP_PHOTOS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItem.class, new Deserializer());
        }

        public Object m21272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuotesAnalysisItemDeserializer.m5770a(jsonParser, (short) 488);
            Object graphQLQuotesAnalysisItem = new GraphQLQuotesAnalysisItem();
            ((BaseModel) graphQLQuotesAnalysisItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuotesAnalysisItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuotesAnalysisItem).a();
            }
            return graphQLQuotesAnalysisItem;
        }
    }

    /* compiled from: VIEW_GROUP_PHOTOS */
    public final class Serializer extends JsonSerializer<GraphQLQuotesAnalysisItem> {
        public final void m21273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuotesAnalysisItem graphQLQuotesAnalysisItem = (GraphQLQuotesAnalysisItem) obj;
            GraphQLQuotesAnalysisItemDeserializer.m5771a(graphQLQuotesAnalysisItem.w_(), graphQLQuotesAnalysisItem.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLQuotesAnalysisItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuotesAnalysisItem.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m21274a() {
        a(0, 0);
        return this.f12877d;
    }

    @FieldOffset
    @Nullable
    public final String m21278j() {
        this.f12878e = super.a(this.f12878e, 1);
        return this.f12878e;
    }

    public final int jK_() {
        return 2019851078;
    }

    public final GraphQLVisitableModel m21276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLQuotesAnalysisItem() {
        super(3);
    }

    public final void m21277a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12877d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m21275a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21278j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m21274a(), 0);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuotesAnalysisItem(Parcel parcel) {
        super(3);
        this.f12877d = parcel.readInt();
        this.f12878e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m21274a());
        parcel.writeString(m21278j());
    }
}
