package com.facebook.graphql.model.extras;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.google.common.collect.ImmutableList;

/* compiled from: home_stories_overlay */
public class FeedUnitExtra extends BaseExtra {
    public static final Creator<FeedUnitExtra> CREATOR = new C08351();
    public ImmutableList<String> f20930a = null;
    public boolean f20931b = false;
    public ImmutableList<String> f20932c = null;

    /* compiled from: home_stories_overlay */
    final class C08351 implements Creator<FeedUnitExtra> {
        C08351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedUnitExtra[i];
        }
    }

    protected FeedUnitExtra(Parcel parcel) {
        super((byte) 0);
    }

    public int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        int a = super.mo1403a(flatBufferBuilder);
        int c = flatBufferBuilder.m21509c(this.f20930a);
        int c2 = flatBufferBuilder.m21509c(this.f20932c);
        flatBufferBuilder.m21510c(7);
        if (a > 0) {
            flatBufferBuilder.m21507b(0, a);
        }
        flatBufferBuilder.m21507b(3, c);
        flatBufferBuilder.m21498a(5, this.f20931b);
        flatBufferBuilder.m21507b(6, c2);
        return flatBufferBuilder.m21511d();
    }

    public void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
        super.mo1412a(mutableFlatBuffer, mutableFlatBuffer.m21560g(i, 0));
        this.f20930a = BaseExtra.m28652a(mutableFlatBuffer.m21558f(i, 3));
        this.f20931b = mutableFlatBuffer.m21540a(i, 5);
        this.f20932c = BaseExtra.m28652a(mutableFlatBuffer.m21558f(i, 6));
    }
}
