package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: link_change_content_filter */
public final class GraphQLMessengerContentSubscriptionOption extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMessengerContentSubscriptionOption> CREATOR = new 1();
    @Nullable
    String f17435d;
    @Nullable
    GraphQLPage f17436e;
    @Nullable
    String f17437f;

    @FieldOffset
    @Nullable
    public final String m24539a() {
        this.f17435d = super.m9948a(this.f17435d, 0);
        return this.f17435d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24540j() {
        this.f17436e = (GraphQLPage) super.m9947a(this.f17436e, 1, GraphQLPage.class);
        return this.f17436e;
    }

    @FieldOffset
    @Nullable
    public final String m24541k() {
        this.f17437f = super.m9948a(this.f17437f, 2);
        return this.f17437f;
    }

    public final int jK_() {
        return 1459786904;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24540j() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24540j());
            if (m24540j() != graphQLPage) {
                graphQLVisitableModel = (GraphQLMessengerContentSubscriptionOption) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17436e = graphQLPage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMessengerContentSubscriptionOption() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24539a());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24540j());
        int b2 = flatBufferBuilder.m21502b(m24541k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMessengerContentSubscriptionOption(Parcel parcel) {
        super(4);
        this.f17435d = parcel.readString();
        this.f17436e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17437f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24539a());
        parcel.writeValue(m24540j());
        parcel.writeString(m24541k());
    }
}
