package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: video_upload_spherical_metadata_found */
public class AgentItemSuggestion implements CommerceBubbleModel {
    public static final Creator<AgentItemSuggestion> CREATOR = new C00621();
    public final PlatformGenericAttachmentItem f562a;
    @Nullable
    public final Uri f563b;
    @Nullable
    public final String f564c;
    @Nullable
    public final String f565d;
    @Nullable
    public final String f566e;
    @Nullable
    public final String f567f;

    /* compiled from: video_upload_spherical_metadata_found */
    final class C00621 implements Creator<AgentItemSuggestion> {
        C00621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AgentItemSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new AgentItemSuggestion[i];
        }
    }

    public AgentItemSuggestion(AgentItemSuggestionBuilder agentItemSuggestionBuilder) {
        this.f562a = (PlatformGenericAttachmentItem) Preconditions.checkNotNull(agentItemSuggestionBuilder.f568a);
        this.f563b = agentItemSuggestionBuilder.f569b;
        this.f564c = agentItemSuggestionBuilder.f570c;
        this.f565d = agentItemSuggestionBuilder.f571d;
        this.f566e = agentItemSuggestionBuilder.f572e;
        this.f567f = agentItemSuggestionBuilder.f573f;
    }

    public AgentItemSuggestion(Parcel parcel) {
        this.f562a = (PlatformGenericAttachmentItem) parcel.readParcelable(PlatformGenericAttachmentItem.class.getClassLoader());
        this.f563b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f564c = parcel.readString();
        this.f565d = parcel.readString();
        this.f566e = parcel.readString();
        this.f567f = parcel.readString();
    }

    public final String mo74a() {
        return this.f562a.f447a;
    }

    public final CommerceBubbleModelType mo75b() {
        return CommerceBubbleModelType.AGENT_ITEM_SUGGESTION;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return ImmutableList.of(this.f562a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f562a, i);
        parcel.writeParcelable(this.f563b, i);
        parcel.writeString(this.f564c);
        parcel.writeString(this.f565d);
        parcel.writeString(this.f566e);
        parcel.writeString(this.f567f);
    }
}
