package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: conversations/# */
public class FetchThreadResult implements Parcelable {
    public static final Creator<FetchThreadResult> CREATOR = new C20301();
    public static final FetchThreadResult f17178a = new FetchThreadResult(DataFetchDisposition.a, null, null, null, RegularImmutableList.a, -1, RegularImmutableList.a);
    public final DataFetchDisposition f17179b;
    @Nullable
    public final ThreadSummary f17180c;
    @Nullable
    public final MessagesCollection f17181d;
    public final ImmutableList<User> f17182e;
    public final long f17183f;
    @Nonnull
    public final ImmutableList<FetchThreadHandlerChange> f17184g;
    @Nullable
    public Map<String, String> f17185h;

    /* compiled from: conversations/# */
    final class C20301 implements Creator<FetchThreadResult> {
        C20301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadResult[i];
        }
    }

    /* compiled from: conversations/# */
    public class Builder {
        public DataFetchDisposition f17171a;
        public ThreadSummary f17172b;
        public MessagesCollection f17173c;
        public ImmutableList<User> f17174d;
        private Map<String, String> f17175e;
        public long f17176f;
        @Nonnull
        private ImmutableList<FetchThreadHandlerChange> f17177g = RegularImmutableList.a;

        public Builder(FetchThreadResult fetchThreadResult) {
            this.f17171a = fetchThreadResult.f17179b;
            this.f17172b = fetchThreadResult.f17180c;
            this.f17173c = fetchThreadResult.f17181d;
            this.f17174d = fetchThreadResult.f17182e;
            this.f17176f = fetchThreadResult.f17183f;
            this.f17177g = fetchThreadResult.f17184g;
        }

        public final Builder m17142a(DataFetchDisposition dataFetchDisposition) {
            this.f17171a = dataFetchDisposition;
            return this;
        }

        public final Builder m17144a(ThreadSummary threadSummary) {
            this.f17172b = threadSummary;
            return this;
        }

        public final Builder m17143a(MessagesCollection messagesCollection) {
            this.f17173c = messagesCollection;
            return this;
        }

        public final Builder m17146a(@Nullable Map<String, String> map) {
            this.f17175e = map;
            return this;
        }

        public final Builder m17145a(ImmutableList<User> immutableList) {
            this.f17174d = immutableList;
            return this;
        }

        public final Builder m17141a(long j) {
            this.f17176f = j;
            return this;
        }

        public final Builder m17148b(ImmutableList<FetchThreadHandlerChange> immutableList) {
            this.f17177g = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }

        public final FetchThreadResult m17147a() {
            return new FetchThreadResult(this.f17171a, this.f17172b, this.f17173c, this.f17175e, this.f17174d, this.f17176f, this.f17177g);
        }
    }

    private FetchThreadResult(DataFetchDisposition dataFetchDisposition, @Nullable ThreadSummary threadSummary, @Nullable MessagesCollection messagesCollection, @Nullable Map<String, String> map, ImmutableList<User> immutableList, long j, ImmutableList<FetchThreadHandlerChange> immutableList2) {
        this.f17179b = (DataFetchDisposition) Preconditions.checkNotNull(dataFetchDisposition);
        this.f17180c = threadSummary;
        this.f17181d = messagesCollection;
        this.f17182e = immutableList;
        this.f17185h = map;
        this.f17183f = j;
        this.f17184g = (ImmutableList) Preconditions.checkNotNull(immutableList2);
    }

    public FetchThreadResult(Parcel parcel) {
        this.f17179b = (DataFetchDisposition) parcel.readParcelable(DataFetchDisposition.class.getClassLoader());
        this.f17180c = (ThreadSummary) parcel.readParcelable(ThreadSummary.class.getClassLoader());
        this.f17181d = (MessagesCollection) parcel.readParcelable(MessagesCollection.class.getClassLoader());
        parcel.readMap(new HashMap(), Map.class.getClassLoader());
        Collection readArrayList = parcel.readArrayList(User.class.getClassLoader());
        this.f17182e = readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
        this.f17183f = parcel.readLong();
        this.f17184g = ImmutableList.copyOf(parcel.readArrayList(FetchThreadHandlerChange.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17179b, i);
        parcel.writeParcelable(this.f17180c, i);
        parcel.writeParcelable(this.f17181d, i);
        parcel.writeMap(this.f17185h);
        parcel.writeList(this.f17182e);
        parcel.writeLong(this.f17183f);
        parcel.writeList(this.f17184g);
    }

    public final boolean m17151a() {
        return (this.f17181d == null && this.f17180c == null) ? false : true;
    }

    public static Builder m17150b() {
        return new Builder();
    }

    public static Builder m17149a(FetchThreadResult fetchThreadResult) {
        return new Builder(fetchThreadResult);
    }
}
