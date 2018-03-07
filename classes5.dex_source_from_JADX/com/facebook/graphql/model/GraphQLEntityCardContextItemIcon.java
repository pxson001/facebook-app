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
import com.facebook.graphql.deserializers.GraphQLEntityCardContextItemIconDeserializer;
import com.facebook.graphql.enums.GraphQLImageSizingStyle;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: intern */
public final class GraphQLEntityCardContextItemIcon extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityCardContextItemIcon> CREATOR = new C03011();
    @Nullable
    GraphQLImage f3543d;
    GraphQLImageSizingStyle f3544e;

    /* compiled from: intern */
    final class C03011 implements Creator<GraphQLEntityCardContextItemIcon> {
        C03011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityCardContextItemIcon(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityCardContextItemIcon[i];
        }
    }

    /* compiled from: intern */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLImage f3541d;
        public GraphQLImageSizingStyle f3542e = GraphQLImageSizingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: intern */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemIcon.class, new Deserializer());
        }

        public Object m7060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEntityCardContextItemIconDeserializer.m4754a(jsonParser, (short) 295);
            Object graphQLEntityCardContextItemIcon = new GraphQLEntityCardContextItemIcon();
            ((BaseModel) graphQLEntityCardContextItemIcon).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEntityCardContextItemIcon instanceof Postprocessable) {
                return ((Postprocessable) graphQLEntityCardContextItemIcon).a();
            }
            return graphQLEntityCardContextItemIcon;
        }
    }

    /* compiled from: intern */
    public final class Serializer extends JsonSerializer<GraphQLEntityCardContextItemIcon> {
        public final void m7061a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon = (GraphQLEntityCardContextItemIcon) obj;
            GraphQLEntityCardContextItemIconDeserializer.m4755a(graphQLEntityCardContextItemIcon.w_(), graphQLEntityCardContextItemIcon.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEntityCardContextItemIcon.class, new Serializer());
            FbSerializerProvider.a(GraphQLEntityCardContextItemIcon.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7063a() {
        this.f3543d = (GraphQLImage) super.a(this.f3543d, 0, GraphQLImage.class);
        return this.f3543d;
    }

    @FieldOffset
    public final GraphQLImageSizingStyle m7065j() {
        this.f3544e = (GraphQLImageSizingStyle) super.a(this.f3544e, 1, GraphQLImageSizingStyle.class, GraphQLImageSizingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3544e;
    }

    public final int jK_() {
        return 1667242696;
    }

    public final GraphQLVisitableModel m7064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7063a() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7063a());
            if (m7063a() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntityCardContextItemIcon) ModelHelper.a(null, this);
                graphQLVisitableModel.f3543d = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntityCardContextItemIcon() {
        super(3);
    }

    public final int m7062a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7063a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m7065j() == GraphQLImageSizingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7065j());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEntityCardContextItemIcon(Parcel parcel) {
        super(3);
        this.f3543d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3544e = GraphQLImageSizingStyle.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7063a());
        parcel.writeString(m7065j().name());
    }

    public GraphQLEntityCardContextItemIcon(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f3543d = builder.f3541d;
        this.f3544e = builder.f3542e;
    }
}
