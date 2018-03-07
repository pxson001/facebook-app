package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixCommentSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: getterVisibility */
public class FeedbackLoggingParams implements Parcelable {
    public static final Creator<FeedbackLoggingParams> CREATOR = new C09091();
    public final ArrayNode f22389a;
    public final String f22390b;
    public final String f22391c;
    public final FeedbackDisplayType f22392d;
    public final NotificationSource f22393e;
    public final PhotoRemixCommentSource f22394f;
    public final String f22395g;
    private ImmutableList<String> f22396h;

    /* compiled from: getterVisibility */
    final class C09091 implements Creator<FeedbackLoggingParams> {
        C09091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedbackLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedbackLoggingParams[i];
        }
    }

    /* compiled from: getterVisibility */
    public class Builder {
        public ArrayNode f22397a;
        public String f22398b;
        public String f22399c;
        public FeedbackDisplayType f22400d = FeedbackDisplayType.UNKNOWN;
        public NotificationSource f22401e = NotificationSource.UNKNOWN;
        public PhotoRemixCommentSource f22402f = PhotoRemixCommentSource.UNKNOWN;
        public String f22403g;

        public static Builder m30316a(FeedbackLoggingParams feedbackLoggingParams) {
            Builder builder = new Builder();
            if (feedbackLoggingParams != null) {
                builder.f22397a = feedbackLoggingParams.f22389a;
                builder.f22398b = feedbackLoggingParams.f22390b;
                builder.f22399c = feedbackLoggingParams.f22391c;
                builder.f22400d = feedbackLoggingParams.f22392d;
                builder.f22401e = feedbackLoggingParams.f22393e;
                builder.f22402f = feedbackLoggingParams.f22394f;
                builder.f22403g = feedbackLoggingParams.f22395g;
            }
            return builder;
        }

        public final Builder m30317a(ArrayNode arrayNode) {
            this.f22397a = arrayNode;
            return this;
        }

        public final Builder m30318a(String str) {
            this.f22398b = str;
            return this;
        }

        public final Builder m30320b(String str) {
            this.f22399c = str;
            return this;
        }

        public final Builder m30321c(String str) {
            this.f22403g = str;
            return this;
        }

        public final FeedbackLoggingParams m30319a() {
            return new FeedbackLoggingParams(this);
        }
    }

    public FeedbackLoggingParams(ArrayNode arrayNode, String str, String str2) {
        Builder newBuilder = newBuilder();
        newBuilder.f22397a = arrayNode;
        newBuilder = newBuilder;
        newBuilder.f22398b = str;
        newBuilder = newBuilder;
        newBuilder.f22399c = str2;
        newBuilder = newBuilder;
        newBuilder.f22400d = FeedbackDisplayType.UNKNOWN;
        newBuilder = newBuilder;
        newBuilder.f22401e = NotificationSource.UNKNOWN;
        this(newBuilder);
    }

    public FeedbackLoggingParams(Builder builder) {
        this.f22396h = null;
        this.f22389a = builder.f22397a;
        this.f22390b = builder.f22398b;
        this.f22391c = builder.f22399c;
        this.f22392d = builder.f22400d;
        this.f22393e = builder.f22401e;
        this.f22394f = builder.f22402f;
        this.f22395g = builder.f22403g;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public FeedbackLoggingParams(Parcel parcel) {
        JsonNode jsonNode = null;
        this.f22396h = jsonNode;
        try {
            jsonNode = FbObjectMapper.m6612i().m6636a(parcel.readString());
        } catch (JsonProcessingException e) {
            throw new ParcelFormatException("Could not parse parcel " + e.toString());
        } catch (IOException e2) {
            throw new ParcelFormatException("Could not parse parcel " + e2.toString());
        } catch (NullPointerException e3) {
        }
        this.f22389a = (ArrayNode) jsonNode;
        this.f22390b = parcel.readString();
        this.f22391c = parcel.readString();
        this.f22392d = FeedbackDisplayType.values()[parcel.readInt()];
        this.f22393e = NotificationSource.values()[parcel.readInt()];
        this.f22394f = PhotoRemixCommentSource.values()[parcel.readInt()];
        this.f22395g = parcel.readString();
    }

    @Nullable
    public final String m30312a() {
        return this.f22391c;
    }

    public final ImmutableList<String> m30313e() {
        if (this.f22396h == null) {
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
            if (this.f22389a != null) {
                Iterator it = this.f22389a.iterator();
                while (it.hasNext()) {
                    builder.m1069c(((JsonNode) it.next()).mo719B());
                }
            }
            if (this.f22395g != null) {
                builder.m1069c(this.f22395g);
            }
            this.f22396h = builder.m1068b();
        }
        return this.f22396h;
    }

    public final String m30314f() {
        return this.f22390b;
    }

    public final String m30315i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nectar Module: ").append(this.f22390b).append("\n");
        stringBuilder.append("Feedback Source: ").append(this.f22391c).append("\n");
        stringBuilder.append("Tracking Codes: ").append(this.f22389a == null ? null : this.f22389a.toString()).append("\n");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FeedbackLoggingParams feedbackLoggingParams = (FeedbackLoggingParams) obj;
        if (feedbackLoggingParams.f22389a != this.f22389a) {
            return false;
        }
        if (feedbackLoggingParams.f22390b != this.f22390b) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22389a == null ? null : this.f22389a.toString());
        parcel.writeString(this.f22390b);
        parcel.writeString(this.f22391c);
        parcel.writeInt(this.f22392d == null ? FeedbackDisplayType.UNKNOWN.ordinal() : this.f22392d.ordinal());
        parcel.writeInt(this.f22393e == null ? NotificationSource.UNKNOWN.ordinal() : this.f22393e.ordinal());
        parcel.writeInt(this.f22394f == null ? PhotoRemixCommentSource.UNKNOWN.ordinal() : this.f22394f.ordinal());
        parcel.writeString(this.f22395g);
    }
}
