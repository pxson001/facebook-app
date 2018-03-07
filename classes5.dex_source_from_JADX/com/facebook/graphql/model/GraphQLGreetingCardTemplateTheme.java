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
import com.facebook.graphql.deserializers.GraphQLGreetingCardTemplateThemeDeserializer;
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
/* compiled from: friends_text */
public final class GraphQLGreetingCardTemplateTheme extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGreetingCardTemplateTheme> CREATOR = new C03871();
    @Nullable
    public String f4137d;
    @Nullable
    public String f4138e;

    /* compiled from: friends_text */
    final class C03871 implements Creator<GraphQLGreetingCardTemplateTheme> {
        C03871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGreetingCardTemplateTheme(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGreetingCardTemplateTheme[i];
        }
    }

    /* compiled from: friends_text */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardTemplateTheme.class, new Deserializer());
        }

        public Object m8363a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGreetingCardTemplateThemeDeserializer.m5140a(jsonParser, (short) 225);
            Object graphQLGreetingCardTemplateTheme = new GraphQLGreetingCardTemplateTheme();
            ((BaseModel) graphQLGreetingCardTemplateTheme).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGreetingCardTemplateTheme instanceof Postprocessable) {
                return ((Postprocessable) graphQLGreetingCardTemplateTheme).a();
            }
            return graphQLGreetingCardTemplateTheme;
        }
    }

    /* compiled from: friends_text */
    public final class Serializer extends JsonSerializer<GraphQLGreetingCardTemplateTheme> {
        public final void m8364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGreetingCardTemplateTheme graphQLGreetingCardTemplateTheme = (GraphQLGreetingCardTemplateTheme) obj;
            GraphQLGreetingCardTemplateThemeDeserializer.m5141a(graphQLGreetingCardTemplateTheme.w_(), graphQLGreetingCardTemplateTheme.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGreetingCardTemplateTheme.class, new Serializer());
            FbSerializerProvider.a(GraphQLGreetingCardTemplateTheme.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8367a() {
        this.f4137d = super.a(this.f4137d, 0);
        return this.f4137d;
    }

    @FieldOffset
    @Nullable
    public final String m8368j() {
        this.f4138e = super.a(this.f4138e, 1);
        return this.f4138e;
    }

    public final int jK_() {
        return 1582898406;
    }

    public final GraphQLVisitableModel m8366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGreetingCardTemplateTheme() {
        super(3);
    }

    public final int m8365a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8367a());
        int b2 = flatBufferBuilder.b(m8368j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGreetingCardTemplateTheme(Parcel parcel) {
        super(3);
        this.f4137d = parcel.readString();
        this.f4138e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8367a());
        parcel.writeString(m8368j());
    }
}
