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
import com.facebook.graphql.deserializers.GraphQLNativeTemplateBundleDeserializer;
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
/* compiled from: extra_data.txt */
public final class GraphQLNativeTemplateBundle extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNativeTemplateBundle> CREATOR = new C04391();
    @Nullable
    public String f4524d;

    /* compiled from: extra_data.txt */
    final class C04391 implements Creator<GraphQLNativeTemplateBundle> {
        C04391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNativeTemplateBundle(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNativeTemplateBundle[i];
        }
    }

    /* compiled from: extra_data.txt */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateBundle.class, new Deserializer());
        }

        public Object m9156a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNativeTemplateBundleDeserializer.m5392a(jsonParser, (short) 570);
            Object graphQLNativeTemplateBundle = new GraphQLNativeTemplateBundle();
            ((BaseModel) graphQLNativeTemplateBundle).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNativeTemplateBundle instanceof Postprocessable) {
                return ((Postprocessable) graphQLNativeTemplateBundle).a();
            }
            return graphQLNativeTemplateBundle;
        }
    }

    /* compiled from: extra_data.txt */
    public final class Serializer extends JsonSerializer<GraphQLNativeTemplateBundle> {
        public final void m9157a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNativeTemplateBundle graphQLNativeTemplateBundle = (GraphQLNativeTemplateBundle) obj;
            GraphQLNativeTemplateBundleDeserializer.m5393a(graphQLNativeTemplateBundle.w_(), graphQLNativeTemplateBundle.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLNativeTemplateBundle.class, new Serializer());
            FbSerializerProvider.a(GraphQLNativeTemplateBundle.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9160a() {
        this.f4524d = super.a(this.f4524d, 0);
        return this.f4524d;
    }

    public final int jK_() {
        return 1537671603;
    }

    public final GraphQLVisitableModel m9159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLNativeTemplateBundle() {
        super(2);
    }

    public final int m9158a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9160a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNativeTemplateBundle(Parcel parcel) {
        super(2);
        this.f4524d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9160a());
    }
}
