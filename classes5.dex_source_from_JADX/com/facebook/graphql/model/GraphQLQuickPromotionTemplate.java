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
import com.facebook.graphql.deserializers.GraphQLQuickPromotionTemplateDeserializer;
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
/* compiled from: VIEW_NEARBY_FRIENDS */
public final class GraphQLQuickPromotionTemplate extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotionTemplate> CREATOR = new C11981();
    @Nullable
    public String f12875d;
    public List<GraphQLQPTemplateParameter> f12876e;

    /* compiled from: VIEW_NEARBY_FRIENDS */
    final class C11981 implements Creator<GraphQLQuickPromotionTemplate> {
        C11981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotionTemplate(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotionTemplate[i];
        }
    }

    /* compiled from: VIEW_NEARBY_FRIENDS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionTemplate.class, new Deserializer());
        }

        public Object m21256a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuickPromotionTemplateDeserializer.m5764a(jsonParser, (short) 364);
            Object graphQLQuickPromotionTemplate = new GraphQLQuickPromotionTemplate();
            ((BaseModel) graphQLQuickPromotionTemplate).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuickPromotionTemplate instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuickPromotionTemplate).a();
            }
            return graphQLQuickPromotionTemplate;
        }
    }

    /* compiled from: VIEW_NEARBY_FRIENDS */
    public final class Serializer extends JsonSerializer<GraphQLQuickPromotionTemplate> {
        public final void m21257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuickPromotionTemplate graphQLQuickPromotionTemplate = (GraphQLQuickPromotionTemplate) obj;
            GraphQLQuickPromotionTemplateDeserializer.m5765a(graphQLQuickPromotionTemplate.w_(), graphQLQuickPromotionTemplate.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuickPromotionTemplate.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuickPromotionTemplate.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21260a() {
        this.f12875d = super.a(this.f12875d, 0);
        return this.f12875d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLQPTemplateParameter> m21261j() {
        this.f12876e = super.a(this.f12876e, 1, GraphQLQPTemplateParameter.class);
        return (ImmutableList) this.f12876e;
    }

    public final int jK_() {
        return 511940592;
    }

    public final GraphQLVisitableModel m21259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21261j() != null) {
            Builder a = ModelHelper.a(m21261j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuickPromotionTemplate) ModelHelper.a(null, this);
                graphQLVisitableModel.f12876e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuickPromotionTemplate() {
        super(3);
    }

    public final int m21258a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21260a());
        int a = ModelHelper.a(flatBufferBuilder, m21261j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuickPromotionTemplate(Parcel parcel) {
        super(3);
        this.f12875d = parcel.readString();
        this.f12876e = ImmutableListHelper.a(parcel.readArrayList(GraphQLQPTemplateParameter.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21260a());
        parcel.writeList(m21261j());
    }
}
