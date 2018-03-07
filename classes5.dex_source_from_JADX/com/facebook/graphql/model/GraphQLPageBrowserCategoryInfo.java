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
import com.facebook.graphql.deserializers.GraphQLPageBrowserCategoryInfoDeserializer;
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
/* compiled from: entity_card */
public final class GraphQLPageBrowserCategoryInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageBrowserCategoryInfo> CREATOR = new C04581();
    @Nullable
    public String f4742d;
    @Nullable
    public String f4743e;

    /* compiled from: entity_card */
    final class C04581 implements Creator<GraphQLPageBrowserCategoryInfo> {
        C04581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPageBrowserCategoryInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPageBrowserCategoryInfo[i];
        }
    }

    /* compiled from: entity_card */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPageBrowserCategoryInfo.class, new Deserializer());
        }

        public Object m9470a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPageBrowserCategoryInfoDeserializer.m5496a(jsonParser, (short) 344);
            Object graphQLPageBrowserCategoryInfo = new GraphQLPageBrowserCategoryInfo();
            ((BaseModel) graphQLPageBrowserCategoryInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPageBrowserCategoryInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLPageBrowserCategoryInfo).a();
            }
            return graphQLPageBrowserCategoryInfo;
        }
    }

    /* compiled from: entity_card */
    public final class Serializer extends JsonSerializer<GraphQLPageBrowserCategoryInfo> {
        public final void m9471a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPageBrowserCategoryInfo graphQLPageBrowserCategoryInfo = (GraphQLPageBrowserCategoryInfo) obj;
            GraphQLPageBrowserCategoryInfoDeserializer.m5497a(graphQLPageBrowserCategoryInfo.w_(), graphQLPageBrowserCategoryInfo.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLPageBrowserCategoryInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLPageBrowserCategoryInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9474a() {
        this.f4742d = super.a(this.f4742d, 0);
        return this.f4742d;
    }

    @FieldOffset
    @Nullable
    public final String m9475j() {
        this.f4743e = super.a(this.f4743e, 1);
        return this.f4743e;
    }

    public final int jK_() {
        return -746477851;
    }

    public final GraphQLVisitableModel m9473a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLPageBrowserCategoryInfo() {
        super(3);
    }

    public final int m9472a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9474a());
        int b2 = flatBufferBuilder.b(m9475j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPageBrowserCategoryInfo(Parcel parcel) {
        super(3);
        this.f4742d = parcel.readString();
        this.f4743e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9474a());
        parcel.writeString(m9475j());
    }
}
