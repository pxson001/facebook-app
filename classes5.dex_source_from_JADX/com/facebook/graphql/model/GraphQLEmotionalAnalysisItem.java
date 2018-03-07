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
import com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemDeserializer;
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
/* compiled from: ios_add_info_button */
public final class GraphQLEmotionalAnalysisItem extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEmotionalAnalysisItem> CREATOR = new C02971();
    public int f3525d;
    @Nullable
    public GraphQLImage f3526e;
    @Nullable
    public GraphQLPage f3527f;

    /* compiled from: ios_add_info_button */
    final class C02971 implements Creator<GraphQLEmotionalAnalysisItem> {
        C02971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEmotionalAnalysisItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEmotionalAnalysisItem[i];
        }
    }

    /* compiled from: ios_add_info_button */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItem.class, new Deserializer());
        }

        public Object m7004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEmotionalAnalysisItemDeserializer.m4738a(jsonParser, (short) 481);
            Object graphQLEmotionalAnalysisItem = new GraphQLEmotionalAnalysisItem();
            ((BaseModel) graphQLEmotionalAnalysisItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEmotionalAnalysisItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLEmotionalAnalysisItem).a();
            }
            return graphQLEmotionalAnalysisItem;
        }
    }

    /* compiled from: ios_add_info_button */
    public final class Serializer extends JsonSerializer<GraphQLEmotionalAnalysisItem> {
        public final void m7005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEmotionalAnalysisItem graphQLEmotionalAnalysisItem = (GraphQLEmotionalAnalysisItem) obj;
            GraphQLEmotionalAnalysisItemDeserializer.m4739a(graphQLEmotionalAnalysisItem.w_(), graphQLEmotionalAnalysisItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItem.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m7006a() {
        a(0, 0);
        return this.f3525d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7010j() {
        this.f3526e = (GraphQLImage) super.a(this.f3526e, 1, GraphQLImage.class);
        return this.f3526e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m7011k() {
        this.f3527f = (GraphQLPage) super.a(this.f3527f, 2, GraphQLPage.class);
        return this.f3527f;
    }

    public final int jK_() {
        return -1707999019;
    }

    public final GraphQLVisitableModel m7008a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7010j() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7010j());
            if (m7010j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEmotionalAnalysisItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f3526e = graphQLImage;
            }
        }
        if (m7011k() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m7011k());
            if (m7011k() != graphQLPage) {
                graphQLVisitableModel = (GraphQLEmotionalAnalysisItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3527f = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEmotionalAnalysisItem() {
        super(4);
    }

    public final void m7009a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3525d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m7007a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7010j());
        int a2 = ModelHelper.a(flatBufferBuilder, m7011k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m7006a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEmotionalAnalysisItem(Parcel parcel) {
        super(4);
        this.f3525d = parcel.readInt();
        this.f3526e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3527f = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m7006a());
        parcel.writeValue(m7010j());
        parcel.writeValue(m7011k());
    }
}
