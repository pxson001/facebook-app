package com.facebook.timeline.inforeview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionOptionListData;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionPrivacySelectorView.PrivacyData;
import javax.annotation.Nullable;

/* compiled from: upload_fail_cause */
public class InfoReviewProfileQuestionStatusData implements Parcelable, ProfileQuestionOptionListData, PrivacyData {
    public static final Creator<InfoReviewProfileQuestionStatusData> CREATOR = new C00791();
    private String f868a;
    private String f869b;
    private boolean f870c;
    private String f871d;
    private String f872e;
    private GraphQLPrivacyOption f873f;
    public boolean f874g;
    public boolean f875h;
    public boolean f876i;

    /* compiled from: upload_fail_cause */
    final class C00791 implements Creator<InfoReviewProfileQuestionStatusData> {
        C00791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            InfoReviewProfileQuestionStatusData infoReviewProfileQuestionStatusData = new InfoReviewProfileQuestionStatusData();
            infoReviewProfileQuestionStatusData.m895a((GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel));
            infoReviewProfileQuestionStatusData.m897a(parcel.readString(), parcel.readString());
            infoReviewProfileQuestionStatusData.m898a(parcel.readInt() == 1);
            infoReviewProfileQuestionStatusData.m896a(parcel.readString());
            infoReviewProfileQuestionStatusData.m901b(parcel.readString());
            return infoReviewProfileQuestionStatusData;
        }

        public final Object[] newArray(int i) {
            return new InfoReviewProfileQuestionStatusData[i];
        }
    }

    public final boolean m899a() {
        return true;
    }

    public final void m897a(@Nullable String str, @Nullable String str2) {
        this.f868a = str;
        this.f869b = str2;
    }

    @Nullable
    public final String m900b() {
        return this.f868a;
    }

    public final void m898a(boolean z) {
        this.f870c = z;
    }

    public final boolean m902c() {
        return this.f870c;
    }

    public final void m896a(@Nullable String str) {
        this.f871d = str;
        if (str != null) {
            m897a(str, "page");
            m898a(true);
        }
    }

    public final void m901b(@Nullable String str) {
        this.f872e = str;
    }

    @Nullable
    public final String m903d() {
        return this.f871d;
    }

    @Nullable
    public final String m904e() {
        return this.f872e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f873f);
        parcel.writeString(this.f868a);
        parcel.writeString(this.f869b);
        parcel.writeInt(this.f870c ? 1 : 0);
        parcel.writeString(this.f871d);
        parcel.writeString(this.f872e);
    }

    public final void m895a(@Nullable GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f873f = graphQLPrivacyOption;
    }

    @Nullable
    public final GraphQLPrivacyOption m905f() {
        return this.f873f;
    }
}
