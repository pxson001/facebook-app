package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: location_interstitial */
public final class GraphQLTemporalEventInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTemporalEventInfo> CREATOR = new 1();
    long f16678d;
    @Nullable
    GraphQLEventThemePhoto f16679e;
    @Nullable
    String f16680f;

    @FieldOffset
    public final long m23556a() {
        m9949a(0, 0);
        return this.f16678d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventThemePhoto m23559j() {
        this.f16679e = (GraphQLEventThemePhoto) super.m9947a(this.f16679e, 1, GraphQLEventThemePhoto.class);
        return this.f16679e;
    }

    @FieldOffset
    @Nullable
    public final String m23560k() {
        this.f16680f = super.m9948a(this.f16680f, 2);
        return this.f16680f;
    }

    public final int jK_() {
        return 1419332934;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23559j() != null) {
            GraphQLEventThemePhoto graphQLEventThemePhoto = (GraphQLEventThemePhoto) graphQLModelMutatingVisitor.mo2928b(m23559j());
            if (m23559j() != graphQLEventThemePhoto) {
                graphQLVisitableModel = (GraphQLTemporalEventInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16679e = graphQLEventThemePhoto;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTemporalEventInfo() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16678d = mutableFlatBuffer.m21525a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23559j());
        int b = flatBufferBuilder.m21502b(m23560k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21495a(0, m23556a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTemporalEventInfo(Parcel parcel) {
        super(4);
        this.f16678d = parcel.readLong();
        this.f16679e = (GraphQLEventThemePhoto) parcel.readValue(GraphQLEventThemePhoto.class.getClassLoader());
        this.f16680f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(m23556a());
        parcel.writeValue(m23559j());
        parcel.writeString(m23560k());
    }
}
