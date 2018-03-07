package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = NotificationSeenStatesDeserializer.class)
@Immutable
/* compiled from: negativefeedback_went_back */
public class NotificationSeenStates implements Parcelable {
    public static final Creator<NotificationSeenStates> CREATOR = new C06721();
    @JsonProperty("data")
    public final ImmutableList<NotificationSeenState> notificationSeenStatesList;

    /* compiled from: negativefeedback_went_back */
    final class C06721 implements Creator<NotificationSeenStates> {
        C06721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationSeenStates(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationSeenStates[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = NotificationSeenStates_NotificationSeenStateDeserializer.class)
    @Immutable
    /* compiled from: negativefeedback_went_back */
    public class NotificationSeenState implements Parcelable {
        public static final Creator<NotificationSeenState> CREATOR = new C06731();
        @JsonProperty("id")
        public final String id;
        @JsonProperty("seen_state")
        public final GraphQLStorySeenState seenState;

        /* compiled from: negativefeedback_went_back */
        final class C06731 implements Creator<NotificationSeenState> {
            C06731() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new NotificationSeenState(parcel);
            }

            public final Object[] newArray(int i) {
                return new NotificationSeenState[i];
            }
        }

        private NotificationSeenState() {
            this.id = null;
            this.seenState = null;
        }

        public NotificationSeenState(Parcel parcel) {
            this.id = parcel.readString();
            this.seenState = GraphQLStorySeenState.valueOf(parcel.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.id);
            parcel.writeString(this.seenState.name());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotificationSeenState)) {
                return false;
            }
            NotificationSeenState notificationSeenState = (NotificationSeenState) obj;
            if (Objects.equal(notificationSeenState.id, this.id) && Objects.equal(notificationSeenState.seenState, this.seenState)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.id, this.seenState.name()});
        }

        public String toString() {
            return Objects.toStringHelper(this).add("notification id", this.id).add("seen state", this.seenState.name()).toString();
        }
    }

    private NotificationSeenStates() {
        this.notificationSeenStatesList = null;
    }

    public NotificationSeenStates(Parcel parcel) {
        Collection a = Lists.a();
        parcel.readTypedList(a, NotificationSeenState.CREATOR);
        this.notificationSeenStatesList = ImmutableList.copyOf(a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.notificationSeenStatesList);
    }
}
