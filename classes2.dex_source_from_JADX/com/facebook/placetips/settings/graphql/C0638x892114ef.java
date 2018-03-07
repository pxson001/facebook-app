package com.facebook.placetips.settings.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels$GravitySettingsGraphQlFragmentModel.Builder;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels$GravitySettingsGraphQlFragmentModel.Serializer;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1096776403)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: max_age_for_reranking */
public final class C0638x892114ef extends BaseModel implements GraphQLVisitableModel {
    private boolean f14959d;
    @Nullable
    private String f14960e;
    private boolean f14961f;
    private boolean f14962g;

    /* compiled from: max_age_for_reranking */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.m11718a(C0638x892114ef.class, new Deserializer());
        }

        public Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
            flatBufferBuilder.m21513d(C0655xaa8b525f.m21516a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.m21539a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0638x892114ef = new C0638x892114ef();
            ((BaseModel) c0638x892114ef).mo1406a(mutableFlatBuffer2, FlatBuffer.m4026a(mutableFlatBuffer2.f15021a), (Object) jsonParser);
            if (c0638x892114ef instanceof Postprocessable) {
                return ((Postprocessable) c0638x892114ef).mo78a();
            }
            return c0638x892114ef;
        }
    }

    public C0638x892114ef() {
        super(4);
    }

    public C0638x892114ef(MutableFlatBuffer mutableFlatBuffer) {
        super(4);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    public final boolean m21397a() {
        m9949a(0, 0);
        return this.f14959d;
    }

    @Nullable
    public final String m21398b() {
        this.f14960e = super.m9948a(this.f14960e, 1);
        return this.f14960e;
    }

    public final boolean m21399c() {
        m9949a(0, 2);
        return this.f14961f;
    }

    public final boolean m21400d() {
        m9949a(0, 3);
        return this.f14962g;
    }

    public static C0638x892114ef m21393a(C0638x892114ef c0638x892114ef) {
        if (c0638x892114ef == null) {
            return null;
        }
        if (c0638x892114ef instanceof C0638x892114ef) {
            return c0638x892114ef;
        }
        Builder builder = new Builder();
        builder.a = c0638x892114ef.m21397a();
        builder.b = c0638x892114ef.m21398b();
        builder.c = c0638x892114ef.m21399c();
        builder.d = c0638x892114ef.m21400d();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int b = flatBufferBuilder.m21502b(builder.b);
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21498a(0, builder.a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21498a(2, builder.c);
        flatBufferBuilder.m21498a(3, builder.d);
        flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new C0638x892114ef(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return -1423299965;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m21398b());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21498a(0, this.f14959d);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21498a(2, this.f14961f);
        flatBufferBuilder.m21498a(3, this.f14962g);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f14959d = mutableFlatBuffer.m21540a(i, 0);
        this.f14961f = mutableFlatBuffer.m21540a(i, 2);
        this.f14962g = mutableFlatBuffer.m21540a(i, 3);
    }
}
