package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_logs_upload_setting_set */
public class SearchThreadNameAndParticipantsResult extends BaseResult implements Parcelable {
    public static final Creator<SearchThreadNameAndParticipantsResult> CREATOR = new C20541();
    public final ThreadsCollection f17294a;
    public final ImmutableList<User> f17295b;
    private final long f17296c;

    /* compiled from: contact_logs_upload_setting_set */
    final class C20541 implements Creator<SearchThreadNameAndParticipantsResult> {
        C20541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchThreadNameAndParticipantsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchThreadNameAndParticipantsResult[i];
        }
    }

    public static FetchGroupThreadsResultBuilder newBuilder() {
        return new FetchGroupThreadsResultBuilder();
    }

    SearchThreadNameAndParticipantsResult(FetchGroupThreadsResultBuilder fetchGroupThreadsResultBuilder) {
        super(fetchGroupThreadsResultBuilder.f17053a, fetchGroupThreadsResultBuilder.f17056d);
        Preconditions.checkNotNull(fetchGroupThreadsResultBuilder.f17053a);
        this.f17294a = fetchGroupThreadsResultBuilder.f17054b;
        this.f17295b = ImmutableList.copyOf(fetchGroupThreadsResultBuilder.f17055c);
        this.f17296c = fetchGroupThreadsResultBuilder.f17057e;
    }

    public SearchThreadNameAndParticipantsResult(Parcel parcel) {
        super(parcel);
        this.f17294a = (ThreadsCollection) parcel.readParcelable(ThreadsCollection.class.getClassLoader());
        this.f17295b = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
        this.f17296c = parcel.readLong();
    }

    public final ThreadsCollection m17172d() {
        return this.f17294a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f17294a, i);
        parcel.writeList(this.f17295b);
        parcel.writeLong(this.f17296c);
    }
}
