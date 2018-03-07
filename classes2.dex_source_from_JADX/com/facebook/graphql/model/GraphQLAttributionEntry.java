package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_story_visible_height */
public final class GraphQLAttributionEntry extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAttributionEntry> CREATOR = new 1();
    @Nullable
    GraphQLTextWithEntities f17004d;
    @Nullable
    GraphQLEntityCardContextItemIcon f17005e;
    @Deprecated
    @Nullable
    String f17006f;
    GraphQLAttributionSource f17007g;

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23989a() {
        this.f17004d = (GraphQLTextWithEntities) super.m9947a(this.f17004d, 0, GraphQLTextWithEntities.class);
        return this.f17004d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntityCardContextItemIcon m23991j() {
        this.f17005e = (GraphQLEntityCardContextItemIcon) super.m9947a(this.f17005e, 1, GraphQLEntityCardContextItemIcon.class);
        return this.f17005e;
    }

    @FieldOffset
    @Nullable
    public final String m23992k() {
        this.f17006f = super.m9948a(this.f17006f, 2);
        return this.f17006f;
    }

    @FieldOffset
    public final GraphQLAttributionSource m23993l() {
        this.f17007g = (GraphQLAttributionSource) super.m9945a(this.f17007g, 3, GraphQLAttributionSource.class, GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17007g;
    }

    public final int jK_() {
        return -751942829;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23989a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23989a());
            if (m23989a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAttributionEntry) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17004d = graphQLTextWithEntities;
            }
        }
        if (m23991j() != null) {
            GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon = (GraphQLEntityCardContextItemIcon) graphQLModelMutatingVisitor.mo2928b(m23991j());
            if (m23991j() != graphQLEntityCardContextItemIcon) {
                graphQLVisitableModel = (GraphQLAttributionEntry) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17005e = graphQLEntityCardContextItemIcon;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAttributionEntry() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23989a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23991j());
        int b = flatBufferBuilder.m21502b(m23992k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21496a(3, m23993l() == GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23993l());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAttributionEntry(Parcel parcel) {
        super(5);
        this.f17004d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17005e = (GraphQLEntityCardContextItemIcon) parcel.readValue(GraphQLEntityCardContextItemIcon.class.getClassLoader());
        this.f17006f = parcel.readString();
        this.f17007g = GraphQLAttributionSource.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23989a());
        parcel.writeValue(m23991j());
        parcel.writeString(m23992k());
        parcel.writeString(m23993l().name());
    }

    public GraphQLAttributionEntry(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17004d = builder.d;
        this.f17005e = builder.e;
        this.f17006f = builder.f;
        this.f17007g = builder.g;
    }
}
