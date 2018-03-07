package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_file_uri */
public final class GraphQLEventCategoryData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventCategoryData> CREATOR = new 1();
    @Nullable
    public String f17100d;
    @Nullable
    public String f17101e;

    @FieldOffset
    @Nullable
    public final String m24110a() {
        this.f17100d = super.m9948a(this.f17100d, 0);
        return this.f17100d;
    }

    @FieldOffset
    @Nullable
    public final String m24111j() {
        this.f17101e = super.m9948a(this.f17101e, 1);
        return this.f17101e;
    }

    public final int jK_() {
        return 1852662114;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLEventCategoryData() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24110a());
        int b2 = flatBufferBuilder.m21502b(m24111j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventCategoryData(Parcel parcel) {
        super(3);
        this.f17100d = parcel.readString();
        this.f17101e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24110a());
        parcel.writeString(m24111j());
    }
}
