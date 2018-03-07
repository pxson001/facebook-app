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
/* compiled from: liger_trace_event */
public final class GraphQLGraphSearchQueryTitle extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQueryTitle> CREATOR = new 1();
    @Nullable
    public String f17551d;

    @FieldOffset
    @Nullable
    public final String m24711a() {
        this.f17551d = super.m9948a(this.f17551d, 0);
        return this.f17551d;
    }

    public final int jK_() {
        return -1696096378;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLGraphSearchQueryTitle() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24711a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGraphSearchQueryTitle(Parcel parcel) {
        super(2);
        this.f17551d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24711a());
    }
}
