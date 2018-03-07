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
import com.facebook.graphql.deserializers.GraphQLTimelineSectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: UNIT_STACK */
public final class GraphQLTimelineSection extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineSection> CREATOR = new C12541();
    @Nullable
    public String f13335d;
    @Nullable
    public String f13336e;
    @Nullable
    public GraphQLTimelineSectionUnitsConnection f13337f;
    @Nullable
    public String f13338g;
    public int f13339h;

    /* compiled from: UNIT_STACK */
    final class C12541 implements Creator<GraphQLTimelineSection> {
        C12541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineSection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineSection[i];
        }
    }

    /* compiled from: UNIT_STACK */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f13330d;
        @Nullable
        public String f13331e;
        @Nullable
        public GraphQLTimelineSectionUnitsConnection f13332f;
        @Nullable
        public String f13333g;
        public int f13334h;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: UNIT_STACK */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimelineSection.class, new Deserializer());
        }

        public Object m22182a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimelineSectionDeserializer.m6084a(jsonParser, (short) 104);
            Object graphQLTimelineSection = new GraphQLTimelineSection();
            ((BaseModel) graphQLTimelineSection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimelineSection instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimelineSection).a();
            }
            return graphQLTimelineSection;
        }
    }

    /* compiled from: UNIT_STACK */
    public final class Serializer extends JsonSerializer<GraphQLTimelineSection> {
        public final void m22183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) obj;
            GraphQLTimelineSectionDeserializer.m6085b(graphQLTimelineSection.w_(), graphQLTimelineSection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTimelineSection.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimelineSection.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22188j() {
        this.f13335d = super.a(this.f13335d, 0);
        return this.f13335d;
    }

    @FieldOffset
    @Nullable
    public final String m22189k() {
        this.f13336e = super.a(this.f13336e, 1);
        return this.f13336e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineSectionUnitsConnection m22190l() {
        this.f13337f = (GraphQLTimelineSectionUnitsConnection) super.a(this.f13337f, 2, GraphQLTimelineSectionUnitsConnection.class);
        return this.f13337f;
    }

    @FieldOffset
    @Nullable
    public final String m22191m() {
        this.f13338g = super.a(this.f13338g, 3);
        return this.f13338g;
    }

    @FieldOffset
    public final int m22192n() {
        a(0, 4);
        return this.f13339h;
    }

    @Nullable
    public final String m22186a() {
        return m22188j();
    }

    public final int jK_() {
        return 1129832260;
    }

    public final GraphQLVisitableModel m22185a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22190l() != null) {
            GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection = (GraphQLTimelineSectionUnitsConnection) graphQLModelMutatingVisitor.b(m22190l());
            if (m22190l() != graphQLTimelineSectionUnitsConnection) {
                graphQLVisitableModel = (GraphQLTimelineSection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13337f = graphQLTimelineSectionUnitsConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTimelineSection() {
        super(6);
    }

    public final void m22187a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13339h = mutableFlatBuffer.a(i, 4, 0);
    }

    public final int m22184a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22188j());
        int b2 = flatBufferBuilder.b(m22189k());
        int a = ModelHelper.a(flatBufferBuilder, m22190l());
        int b3 = flatBufferBuilder.b(m22191m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.a(4, m22192n(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineSection(Parcel parcel) {
        super(6);
        this.f13335d = parcel.readString();
        this.f13336e = parcel.readString();
        this.f13337f = (GraphQLTimelineSectionUnitsConnection) parcel.readValue(GraphQLTimelineSectionUnitsConnection.class.getClassLoader());
        this.f13338g = parcel.readString();
        this.f13339h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22188j());
        parcel.writeString(m22189k());
        parcel.writeValue(m22190l());
        parcel.writeString(m22191m());
        parcel.writeInt(m22192n());
    }

    public GraphQLTimelineSection(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f13335d = builder.f13330d;
        this.f13336e = builder.f13331e;
        this.f13337f = builder.f13332f;
        this.f13338g = builder.f13333g;
        this.f13339h = builder.f13334h;
    }
}
