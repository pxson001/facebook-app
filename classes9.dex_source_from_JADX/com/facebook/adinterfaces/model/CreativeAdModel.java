package com.facebook.adinterfaces.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative.ObjectStorySpec;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative.ObjectStorySpec.LinkData;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative.ObjectStorySpec.LinkData.CallToAction;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative.ObjectStorySpec.LinkData.CallToAction.Type;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative.ObjectStorySpec.LinkData.CallToAction.Value;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.google.common.base.Preconditions;

/* compiled from: \a */
public class CreativeAdModel implements Parcelable {
    public static final Creator<CreativeAdModel> CREATOR = new C25121();
    public String f21768a;
    public String f21769b;
    public String f21770c;
    public String f21771d;
    public String f21772e;
    public String f21773f;
    public GraphQLCallToActionType f21774g;
    public String f21775h;
    public String f21776i;
    public String f21777j;

    /* compiled from: \a */
    final class C25121 implements Creator<CreativeAdModel> {
        C25121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeAdModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeAdModel[i];
        }
    }

    /* compiled from: \a */
    public class Builder {
        public GraphQLCallToActionType f21760a;
        public String f21761b;
        public String f21762c;
        public String f21763d;
        public String f21764e;
        public String f21765f;
        public String f21766g;
        public String f21767h;

        public final CreativeAdModel m22863a() {
            return new CreativeAdModel(this);
        }
    }

    protected CreativeAdModel(Builder builder) {
        this.f21768a = builder.f21762c;
        this.f21769b = builder.f21763d;
        this.f21770c = builder.f21764e;
        this.f21771d = builder.f21765f;
        this.f21772e = builder.f21766g;
        this.f21773f = builder.f21767h;
        this.f21774g = builder.f21760a;
        this.f21775h = builder.f21761b;
        this.f21777j = builder.f21767h;
    }

    protected CreativeAdModel(Parcel parcel) {
        this.f21768a = parcel.readString();
        this.f21769b = parcel.readString();
        this.f21770c = parcel.readString();
        this.f21771d = parcel.readString();
        this.f21772e = parcel.readString();
        this.f21773f = parcel.readString();
        this.f21774g = (GraphQLCallToActionType) parcel.readSerializable();
        this.f21775h = parcel.readString();
        this.f21776i = parcel.readString();
        this.f21777j = parcel.readString();
    }

    public final void m22865f(String str) {
        this.f21775h = str;
    }

    public final GraphQLCallToActionType m22864e() {
        return this.f21774g;
    }

    public final Creative m22866h() {
        boolean z;
        boolean z2 = false;
        Preconditions.checkState(this.f21768a != null);
        if (this.f21770c != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f21774g != GraphQLCallToActionType.LIKE_PAGE) {
            if (this.f21771d != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            if (!(this.f21772e == null && this.f21773f == null)) {
                z2 = true;
            }
            Preconditions.checkState(z2);
        }
        GraphQlCallInput graphQlCallInput = null;
        if (this.f21774g == GraphQLCallToActionType.LIKE_PAGE) {
            Creative creative = new Creative();
            creative.a("object_id", this.f21768a);
            graphQlCallInput = creative;
            graphQlCallInput.a("body", this.f21770c);
            creative = graphQlCallInput;
            if (this.f21772e == null) {
                creative.a("image_url", this.f21773f);
                return creative;
            }
            creative.a("image_hash", this.f21772e);
            return creative;
        }
        if (!(this.f21774g == GraphQLCallToActionType.NO_BUTTON || this.f21774g == null)) {
            CallToAction callToAction = new CallToAction();
            callToAction.a("type", Type.valueOf(this.f21774g.name()));
            graphQlCallInput = callToAction;
            Value value = new Value();
            value.a("link", this.f21775h);
            graphQlCallInput.a("value", value);
            graphQlCallInput = graphQlCallInput;
        }
        LinkData linkData = new LinkData();
        linkData.a("name", this.f21769b);
        GraphQlCallInput graphQlCallInput2 = linkData;
        graphQlCallInput2.a("message", this.f21770c);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("description", " ");
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("link", this.f21771d);
        graphQlCallInput2 = graphQlCallInput2;
        if (this.f21772e == null) {
            graphQlCallInput2.a("picture", this.f21773f);
        } else {
            graphQlCallInput2.a("image_hash", this.f21772e);
        }
        if (graphQlCallInput != null) {
            graphQlCallInput2.a("call_to_action", graphQlCallInput);
        }
        ObjectStorySpec objectStorySpec = new ObjectStorySpec();
        objectStorySpec.a("page_id", this.f21768a);
        graphQlCallInput = objectStorySpec;
        graphQlCallInput.a("link_data", graphQlCallInput2);
        graphQlCallInput = graphQlCallInput;
        Creative creative2 = new Creative();
        creative2.a("object_story_spec", graphQlCallInput);
        return creative2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21768a);
        parcel.writeString(this.f21769b);
        parcel.writeString(this.f21770c);
        parcel.writeString(this.f21771d);
        parcel.writeString(this.f21772e);
        parcel.writeString(this.f21773f);
        parcel.writeSerializable(this.f21774g);
        parcel.writeString(this.f21775h);
        parcel.writeString(this.f21776i);
        parcel.writeString(this.f21777j);
    }
}
