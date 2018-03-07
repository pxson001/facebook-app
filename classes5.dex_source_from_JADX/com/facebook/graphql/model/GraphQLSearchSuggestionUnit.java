package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSearchSuggestionUnitDeserializer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VERTEX_PHOTO_VOTE_MODULE */
public final class GraphQLSearchSuggestionUnit extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSearchSuggestionUnit> CREATOR = new C12201();
    @Nullable
    public GraphQLObjectType f13004d;
    public boolean f13005e;
    @Nullable
    public GraphQLImage f13006f;
    @Nullable
    public String f13007g;
    public boolean f13008h;
    public boolean f13009i;
    @Nullable
    public String f13010j;
    @Nullable
    public GraphQLImage f13011k;
    @Nullable
    public GraphQLGraphSearchQueryTitle f13012l;
    public List<GraphQLGraphSearchResultsDisplayStyle> f13013m;
    @Nullable
    public String f13014n;
    public GraphQLSavedState f13015o;

    /* compiled from: VERTEX_PHOTO_VOTE_MODULE */
    final class C12201 implements Creator<GraphQLSearchSuggestionUnit> {
        C12201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSearchSuggestionUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSearchSuggestionUnit[i];
        }
    }

    /* compiled from: VERTEX_PHOTO_VOTE_MODULE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionUnit.class, new Deserializer());
        }

        public Object m21588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSearchSuggestionUnitDeserializer.m5869a(jsonParser, (short) 470);
            Object graphQLSearchSuggestionUnit = new GraphQLSearchSuggestionUnit();
            ((BaseModel) graphQLSearchSuggestionUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSearchSuggestionUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLSearchSuggestionUnit).a();
            }
            return graphQLSearchSuggestionUnit;
        }
    }

    /* compiled from: VERTEX_PHOTO_VOTE_MODULE */
    public final class Serializer extends JsonSerializer<GraphQLSearchSuggestionUnit> {
        public final void m21589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSearchSuggestionUnit graphQLSearchSuggestionUnit = (GraphQLSearchSuggestionUnit) obj;
            GraphQLSearchSuggestionUnitDeserializer.m5870a(graphQLSearchSuggestionUnit.w_(), graphQLSearchSuggestionUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSearchSuggestionUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLSearchSuggestionUnit.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m21594j() {
        if (this.b != null && this.f13004d == null) {
            this.f13004d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f13004d == null || this.f13004d.g() != 0) {
            return this.f13004d;
        }
        return null;
    }

    @FieldOffset
    public final boolean m21595k() {
        a(0, 1);
        return this.f13005e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21596l() {
        this.f13006f = (GraphQLImage) super.a(this.f13006f, 2, GraphQLImage.class);
        return this.f13006f;
    }

    @FieldOffset
    @Nullable
    public final String m21597m() {
        this.f13007g = super.a(this.f13007g, 3);
        return this.f13007g;
    }

    @FieldOffset
    public final boolean m21598n() {
        a(0, 4);
        return this.f13008h;
    }

    @FieldOffset
    public final boolean m21599o() {
        a(0, 5);
        return this.f13009i;
    }

    @FieldOffset
    @Nullable
    public final String m21600p() {
        this.f13010j = super.a(this.f13010j, 6);
        return this.f13010j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21601q() {
        this.f13011k = (GraphQLImage) super.a(this.f13011k, 7, GraphQLImage.class);
        return this.f13011k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryTitle m21602r() {
        this.f13012l = (GraphQLGraphSearchQueryTitle) super.a(this.f13012l, 8, GraphQLGraphSearchQueryTitle.class);
        return this.f13012l;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m21603s() {
        this.f13013m = super.b(this.f13013m, 9, GraphQLGraphSearchResultsDisplayStyle.class);
        return (ImmutableList) this.f13013m;
    }

    @FieldOffset
    @Nullable
    public final String m21604t() {
        this.f13014n = super.a(this.f13014n, 10);
        return this.f13014n;
    }

    @FieldOffset
    public final GraphQLSavedState m21605u() {
        this.f13015o = (GraphQLSavedState) super.a(this.f13015o, 11, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13015o;
    }

    @Nullable
    public final String m21592a() {
        return m21597m();
    }

    public final int jK_() {
        return 574543248;
    }

    public final GraphQLVisitableModel m21591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21596l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21596l());
            if (m21596l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSearchSuggestionUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f13006f = graphQLImage;
            }
        }
        if (m21601q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21601q());
            if (m21601q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLSearchSuggestionUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13011k = graphQLImage;
            }
        }
        if (m21602r() != null) {
            GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle = (GraphQLGraphSearchQueryTitle) graphQLModelMutatingVisitor.b(m21602r());
            if (m21602r() != graphQLGraphSearchQueryTitle) {
                graphQLVisitableModel = (GraphQLSearchSuggestionUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13012l = graphQLGraphSearchQueryTitle;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSearchSuggestionUnit() {
        super(13);
    }

    public final void m21593a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13005e = mutableFlatBuffer.a(i, 1);
        this.f13008h = mutableFlatBuffer.a(i, 4);
        this.f13009i = mutableFlatBuffer.a(i, 5);
    }

    public final int m21590a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = flatBufferBuilder.a(m21594j() != null ? m21594j().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m21596l());
        int b = flatBufferBuilder.b(m21597m());
        int b2 = flatBufferBuilder.b(m21600p());
        int a3 = ModelHelper.a(flatBufferBuilder, m21601q());
        int a4 = ModelHelper.a(flatBufferBuilder, m21602r());
        int e = flatBufferBuilder.e(m21603s());
        int b3 = flatBufferBuilder.b(m21604t());
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m21595k());
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.a(4, m21598n());
        flatBufferBuilder.a(5, m21599o());
        flatBufferBuilder.b(6, b2);
        flatBufferBuilder.b(7, a3);
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, e);
        flatBufferBuilder.b(10, b3);
        if (m21605u() != GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m21605u();
        }
        flatBufferBuilder.a(11, enumR);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSearchSuggestionUnit(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(13);
        this.f13005e = parcel.readByte() == (byte) 1;
        this.f13006f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13007g = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f13008h = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f13009i = z2;
        this.f13010j = parcel.readString();
        this.f13011k = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13012l = (GraphQLGraphSearchQueryTitle) parcel.readValue(GraphQLGraphSearchQueryTitle.class.getClassLoader());
        this.f13013m = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchResultsDisplayStyle.class.getClassLoader()));
        this.f13014n = parcel.readString();
        this.f13015o = GraphQLSavedState.fromString(parcel.readString());
        this.f13004d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (m21595k() ? 1 : 0));
        parcel.writeValue(m21596l());
        parcel.writeString(m21597m());
        if (m21598n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m21599o()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m21600p());
        parcel.writeValue(m21601q());
        parcel.writeValue(m21602r());
        parcel.writeList(m21603s());
        parcel.writeString(m21604t());
        parcel.writeString(m21605u().name());
        parcel.writeParcelable(this.f13004d, i);
    }
}
