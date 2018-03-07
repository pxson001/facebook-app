package com.facebook.feed.rows.core.props;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: missCount */
public class FeedProps<T extends Flattenable> implements Parcelable, HasFeedProps<T> {
    public static final Creator<FeedProps> CREATOR = new C07401();
    public final T f13444a;
    public final FeedProps<Flattenable> f13445b;

    /* compiled from: missCount */
    final class C07401 implements Creator<FeedProps> {
        C07401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedProps(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedProps[i];
        }
    }

    public FeedProps(Parcel parcel) {
        Object obj = 1;
        this.f13444a = FlatBufferModelHelper.a(parcel);
        if (parcel.readInt() != 1) {
            obj = null;
        }
        this.f13445b = obj != null ? new FeedProps(parcel) : null;
    }

    private FeedProps(T t, @Nullable FeedProps<Flattenable> feedProps) {
        this.f13444a = t;
        this.f13445b = feedProps;
    }

    public final T m19804a() {
        return this.f13444a;
    }

    public final Flattenable m19806b() {
        if (this.f13445b == null) {
            return null;
        }
        FeedProps feedProps = this.f13445b;
        while (feedProps.f13445b != null) {
            feedProps = feedProps.f13445b;
        }
        return feedProps.f13444a;
    }

    public final Flattenable m19807c() {
        return this.f13445b == null ? null : this.f13445b.f13444a;
    }

    @Deprecated
    public final ImmutableList<Flattenable> m19808d() {
        Builder builder = ImmutableList.builder();
        for (FeedProps feedProps = this.f13445b; feedProps != null; feedProps = feedProps.f13445b) {
            builder.m1069c(feedProps.f13444a);
        }
        return builder.m1068b();
    }

    @Nullable
    public final <S extends Flattenable> FeedProps<S> m19803a(S s) {
        return s == null ? null : new FeedProps(s, this);
    }

    public final <S extends Flattenable> FeedProps<S> m19805b(S s) {
        return this.f13445b != null ? this.f13445b.m19803a(s) : m19802c(s);
    }

    public static <S extends Flattenable> FeedProps<S> m19801a(S s, @Nullable ImmutableList<Flattenable> immutableList) {
        Preconditions.checkArgument(s != null);
        if (immutableList == null || immutableList.isEmpty()) {
            return m19802c(s);
        }
        FeedProps c = m19802c((Flattenable) immutableList.get(immutableList.size() - 1));
        for (int size = immutableList.size() - 2; size >= 0; size--) {
            c = c.m19803a((Flattenable) immutableList.get(size));
        }
        return new FeedProps(s, c);
    }

    public static <S extends Flattenable> FeedProps<S> m19802c(S s) {
        return new FeedProps(s, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FeedProps)) {
            return false;
        }
        FeedProps feedProps = (FeedProps) obj;
        if (Objects.equal(this.f13444a, feedProps.f13444a) && Objects.equal(this.f13445b, feedProps.f13445b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f13445b == null ? 0 : this.f13445b.hashCode()) + (this.f13444a.hashCode() * 31);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f13444a);
        parcel.writeInt(this.f13445b != null ? 1 : 0);
        if (this.f13445b != null) {
            this.f13445b.writeToParcel(parcel, i);
        }
    }

    public final FeedProps<T> mo2637f() {
        return this;
    }
}
