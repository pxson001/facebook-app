package com.facebook.productionprompts.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PromptAnalyticsDeserializer.class)
@Immutable
@JsonSerialize(using = PromptAnalyticsSerializer.class)
/* compiled from: start_sales_time */
public class PromptAnalytics implements Parcelable {
    public static final Creator<PromptAnalytics> CREATOR = new C02611();
    @JsonProperty("composer_session_id")
    @Nullable
    public final String composerSessionId;
    @JsonProperty("prompt_id")
    public final String promptId;
    @JsonProperty("prompt_session_id")
    public final String promptSessionId;
    @JsonProperty("prompt_type")
    public final String promptType;
    @JsonProperty("prompt_view_state")
    @Nullable
    public final String promptViewState;
    @JsonProperty("tracking_string")
    @Nullable
    public final String trackingString;

    /* compiled from: start_sales_time */
    final class C02611 implements Creator<PromptAnalytics> {
        C02611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PromptAnalytics(parcel);
        }

        public final Object[] newArray(int i) {
            return new PromptAnalytics[i];
        }
    }

    private PromptAnalytics(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, String str6) {
        this.promptId = str;
        this.promptType = str2;
        this.promptSessionId = str3;
        this.composerSessionId = str4;
        this.trackingString = str5;
        this.promptViewState = str6;
    }

    public PromptAnalytics(Parcel parcel) {
        this.promptId = parcel.readString();
        this.promptType = parcel.readString();
        this.promptSessionId = parcel.readString();
        this.composerSessionId = parcel.readString();
        this.trackingString = parcel.readString();
        this.promptViewState = parcel.readString();
    }

    private PromptAnalytics() {
        this(null, null, null, null, null, null);
    }

    public static PromptAnalytics m6269a(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, String str6) {
        return new PromptAnalytics(str, str2, str3, str4, str5, str6);
    }

    public static PromptAnalytics m6268a(InlineComposerPromptSession inlineComposerPromptSession, String str) {
        return m6269a(inlineComposerPromptSession.a.b(), inlineComposerPromptSession.a.c(), str, null, inlineComposerPromptSession.b.b, inlineComposerPromptSession.c.f4262a.getName());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.promptId);
        parcel.writeString(this.promptType);
        parcel.writeString(this.promptSessionId);
        parcel.writeString(this.composerSessionId);
        parcel.writeString(this.trackingString);
        parcel.writeString(this.promptViewState);
    }
}
