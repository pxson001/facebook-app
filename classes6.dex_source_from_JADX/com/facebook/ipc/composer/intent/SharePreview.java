package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StoryInstagramHelper;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.model.LinksPreview.Media;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SharePreviewDeserializer.class)
@JsonSerialize(using = SharePreviewSerializer.class)
/* compiled from: life_event_type_identifier */
public class SharePreview implements Parcelable {
    @JsonIgnore
    public static final Creator<SharePreview> CREATOR = new C07421();
    @JsonProperty("image_height")
    public final int imageHeight;
    @JsonProperty("image_url")
    public final String imageUrl;
    @JsonProperty("image_width")
    public final int imageWidth;
    @JsonProperty("is_override")
    public final boolean isOverride;
    @JsonProperty("original_share_actor_name")
    public final String originalShareActorName;
    @JsonProperty("reshare_message")
    public final String reshareMessage;
    @JsonProperty("sub_title")
    public final String subTitle;
    @JsonProperty("summary")
    public final String summary;
    @JsonProperty("title")
    public final String title;

    /* compiled from: life_event_type_identifier */
    final class C07421 implements Creator<SharePreview> {
        C07421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SharePreview(parcel);
        }

        public final Object[] newArray(int i) {
            return new SharePreview[i];
        }
    }

    /* compiled from: life_event_type_identifier */
    public class Builder {
        public String f11593a;
        public String f11594b;
        public String f11595c;
        public String f11596d;
        public boolean f11597e;
        public int f11598f;
        public int f11599g;
        public String f11600h;
        public String f11601i;

        public final Builder m18289a(String str) {
            this.f11593a = str;
            return this;
        }

        public final Builder m18291b(String str) {
            this.f11594b = str;
            return this;
        }

        public final Builder m18292c(String str) {
            this.f11595c = str;
            return this;
        }

        public final Builder m18293d(String str) {
            this.f11596d = str;
            return this;
        }

        public final SharePreview m18290a() {
            return new SharePreview(this);
        }
    }

    @JsonIgnore
    public SharePreview(Parcel parcel) {
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.summary = parcel.readString();
        this.imageUrl = parcel.readString();
        this.isOverride = ParcelUtil.a(parcel);
        this.imageWidth = parcel.readInt();
        this.imageHeight = parcel.readInt();
        this.reshareMessage = parcel.readString();
        this.originalShareActorName = parcel.readString();
    }

    @JsonIgnore
    private SharePreview() {
        this(new Builder());
    }

    @JsonIgnore
    public SharePreview(Builder builder) {
        this.title = builder.f11593a;
        this.subTitle = builder.f11594b;
        this.summary = builder.f11595c;
        this.imageUrl = builder.f11596d;
        this.isOverride = builder.f11597e;
        this.imageWidth = builder.f11598f;
        this.imageHeight = builder.f11599g;
        this.reshareMessage = builder.f11600h;
        this.originalShareActorName = builder.f11601i;
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.summary);
        parcel.writeString(this.imageUrl);
        ParcelUtil.a(parcel, this.isOverride);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeString(this.reshareMessage);
        parcel.writeString(this.originalShareActorName);
    }

    @JsonIgnore
    private static SharePreview m18295a(LinksPreview linksPreview) {
        String str;
        int i;
        int i2;
        Media a = linksPreview.m7697a();
        String str2 = StringUtil.a(linksPreview.name) ? linksPreview.description : linksPreview.name;
        if (a != null) {
            str = a.src;
            i = a.width;
            i2 = a.height;
        } else {
            i = 0;
            str = null;
            i2 = 0;
        }
        Builder builder = new Builder();
        builder.f11593a = str2;
        Builder builder2 = builder;
        builder2.f11594b = linksPreview.description;
        builder2 = builder2;
        builder2.f11595c = linksPreview.caption;
        builder2 = builder2;
        builder2.f11596d = str;
        Builder builder3 = builder2;
        builder3.f11597e = false;
        Builder builder4 = builder3;
        builder4.f11598f = i;
        builder4 = builder4;
        builder4.f11599g = i2;
        return builder4.m18290a();
    }

    @JsonIgnore
    public static SharePreview m18296a(LinksPreview linksPreview, SharePreview sharePreview) {
        if (sharePreview == null) {
            return m18295a(linksPreview);
        }
        String str = sharePreview.title != null ? sharePreview.title : linksPreview.name;
        String str2 = sharePreview.subTitle != null ? sharePreview.subTitle : linksPreview.description;
        String str3 = sharePreview.summary != null ? sharePreview.summary : linksPreview.caption;
        String str4 = sharePreview.imageUrl;
        int i = sharePreview.imageWidth;
        int i2 = sharePreview.imageHeight;
        if (str4 == null) {
            Media a = linksPreview.m7697a();
            if (a != null) {
                str4 = a.src;
                i = a.width;
                i2 = a.height;
            }
        }
        Builder builder = new Builder();
        builder.f11593a = str;
        Builder builder2 = builder;
        builder2.f11594b = str2;
        builder2 = builder2;
        builder2.f11595c = str3;
        builder2 = builder2;
        builder2.f11596d = str4;
        builder2 = builder2;
        builder2.f11597e = false;
        builder2 = builder2;
        builder2.f11598f = i;
        builder2 = builder2;
        builder2.f11599g = i2;
        builder2 = builder2;
        builder2.f11600h = sharePreview.reshareMessage;
        builder2 = builder2;
        builder2.f11601i = sharePreview.originalShareActorName;
        return builder2.m18290a();
    }

    @JsonIgnore
    public static SharePreview m18294a(GraphQLStory graphQLStory) {
        if (!StorySharingHelper.b(graphQLStory)) {
            return null;
        }
        GraphQLStoryAttachment graphQLStoryAttachment;
        GraphQLEntity av = graphQLStory.av();
        if (av == null || StringUtil.a(av.d())) {
            graphQLStoryAttachment = null;
        } else {
            graphQLStoryAttachment = StorySharingHelper.a(graphQLStory, graphQLStory.M());
            if (graphQLStoryAttachment == null) {
                graphQLStoryAttachment = graphQLStory.L() != null ? StorySharingHelper.a(graphQLStory, graphQLStory.L().M()) : null;
            }
        }
        GraphQLStoryAttachment graphQLStoryAttachment2 = graphQLStoryAttachment;
        if (graphQLStoryAttachment2 == null || graphQLStoryAttachment2.A() == null) {
            return null;
        }
        String a;
        String aa;
        if (PrivacyOptionHelper.a(GraphQLStoryHelper.c(graphQLStory))) {
            a = StoryTextHelper.a(graphQLStory);
            aa = StoryActorHelper.b(graphQLStory) != null ? StoryActorHelper.b(graphQLStory).aa() : null;
        } else {
            aa = null;
            a = null;
        }
        GraphQLEntity av2 = graphQLStory.av();
        int a2 = GraphQLHelper.a(av2);
        GraphQLNode z = graphQLStoryAttachment2.z();
        Builder builder;
        switch (a2) {
            case -1703624614:
                if (!StoryInstagramHelper.a(graphQLStory) && !StoryInstagramHelper.b(graphQLStory)) {
                    return null;
                }
                builder = new Builder();
                builder.f11593a = graphQLStoryAttachment2.A();
                builder = builder;
                builder.f11594b = m18301b(graphQLStory, graphQLStoryAttachment2);
                builder = builder;
                builder.f11595c = m18302c(graphQLStory, graphQLStoryAttachment2);
                builder = builder;
                builder.f11596d = m18298a(graphQLStoryAttachment2.r());
                builder = builder;
                builder.f11600h = a;
                builder = builder;
                builder.f11601i = aa;
                return builder.m18290a();
            case 63344207:
            case 77090322:
            case 82650203:
            case 514783620:
                GraphQLMedia r = graphQLStoryAttachment2.r();
                if ((r == null || !av2.d().equals(r.b())) && (graphQLStoryAttachment2.z() == null || !av2.d().equals(z.dp()))) {
                    return null;
                }
                builder = new Builder();
                builder.f11593a = m18299a(graphQLStory, graphQLStoryAttachment2);
                builder = builder;
                builder.f11594b = m18301b(graphQLStory, graphQLStoryAttachment2);
                builder = builder;
                builder.f11595c = m18302c(graphQLStory, graphQLStoryAttachment2);
                builder = builder;
                builder.f11596d = m18298a(r);
                builder = builder;
                builder.f11600h = a;
                builder = builder;
                builder.f11601i = aa;
                return builder.m18290a();
            default:
                return null;
        }
    }

    @JsonIgnore
    private static String m18299a(GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment) {
        String A = graphQLStoryAttachment.A();
        if (!StringUtil.a(A)) {
            return A;
        }
        A = m18300a(graphQLStory.aH());
        if (StringUtil.a(A)) {
            return m18300a(StoryHierarchyHelper.b(graphQLStory));
        }
        return A;
    }

    @JsonIgnore
    private static String m18301b(GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment) {
        String a = m18300a(graphQLStoryAttachment.n());
        if (a != null) {
            return a;
        }
        return graphQLStory != null ? m18300a(graphQLStory.aH()) : null;
    }

    @JsonIgnore
    private static String m18302c(GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.u() != null) {
            return graphQLStoryAttachment.u().a();
        }
        if (graphQLStoryAttachment.y() != null) {
            return graphQLStoryAttachment.y();
        }
        return graphQLStory != null ? m18297a(StoryActorHelper.b(graphQLStory)) : null;
    }

    @JsonIgnore
    private static String m18298a(GraphQLMedia graphQLMedia) {
        return (graphQLMedia == null || graphQLMedia.S() == null) ? null : graphQLMedia.S().b();
    }

    @JsonIgnore
    private static String m18300a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return (graphQLTextWithEntities == null || StringUtil.a(graphQLTextWithEntities.a())) ? null : graphQLTextWithEntities.a();
    }

    @JsonIgnore
    private static String m18297a(GraphQLActor graphQLActor) {
        return graphQLActor != null ? graphQLActor.aa() : null;
    }

    @JsonIgnore
    public String toString() {
        return "SharePreview{title='" + this.title + '\'' + ", subTitle='" + this.subTitle + '\'' + ", summary='" + this.summary + '\'' + ", imageUrl='" + this.imageUrl + '\'' + '}';
    }
}
