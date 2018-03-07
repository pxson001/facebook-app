package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: groups/createtab */
public class SponsoredImpression extends BaseImpression {
    public static final Creator<SponsoredImpression> CREATOR = new C08581();
    public static final SponsoredImpression f21615n = new SponsoredImpression();
    @JsonIgnore
    private final List<String> f21616o;
    @JsonIgnore
    public boolean f21617p;
    @JsonIgnore
    public boolean f21618q;
    @JsonIgnore
    public int f21619r;
    @JsonIgnore
    public boolean f21620s;
    @JsonIgnore
    public int f21621t;
    @JsonIgnore
    public boolean f21622u;
    @JsonIgnore
    public boolean f21623v;
    @JsonIgnore
    public boolean f21624w;
    @JsonIgnore
    public boolean f21625x;
    @JsonIgnore
    public boolean f21626y;

    /* compiled from: groups/createtab */
    final class C08581 implements Creator<SponsoredImpression> {
        C08581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SponsoredImpression(parcel);
        }

        public final Object[] newArray(int i) {
            return new SponsoredImpression[i];
        }
    }

    public SponsoredImpression() {
        this.f21616o = Lists.m1296a();
        this.f21617p = false;
        this.f21618q = false;
        this.f21622u = false;
        this.f21621t = 0;
        this.f21623v = false;
        this.f21624w = false;
        this.f21625x = false;
        this.f21619r = 0;
        this.f21620s = false;
        this.f21626y = false;
    }

    private SponsoredImpression(NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields) {
        this();
        m29330b(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields);
    }

    public SponsoredImpression(GraphQLStory graphQLStory) {
        this();
        if (graphQLStory != null) {
            m29330b(graphQLStory.ay());
            if (graphQLStory.m22326L() != null) {
                m29330b(graphQLStory.m22326L().ay());
            }
            if (StoryHierarchyHelper.m27434a(graphQLStory) != null) {
                ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    m29330b(((GraphQLStory) j.get(i)).ay());
                }
            }
        }
    }

    public SponsoredImpression(Parcel parcel) {
        super(parcel);
        this.f21616o = parcel.readArrayList(String.class.getClassLoader());
        this.f21617p = ParcelUtil.a(parcel);
        this.f21618q = ParcelUtil.a(parcel);
        this.f21621t = parcel.readInt();
        this.f21622u = ParcelUtil.a(parcel);
        this.f21624w = false;
        this.f21625x = false;
        this.f21619r = 0;
        this.f21620s = false;
    }

    public static SponsoredImpression m29328a(NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields) {
        if (newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields == null || !IsValidUtil.m22943a(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields)) {
            return f21615n;
        }
        return new SponsoredImpression(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields);
    }

    public final List<String> m29332a(ImpressionType impressionType, ArrayNode arrayNode, long j, int i, Integer num) {
        Preconditions.checkNotNull(this.f21616o);
        List<String> a = Lists.m1296a();
        for (String str : this.f21616o) {
            if (!Strings.isNullOrEmpty(str) && ((impressionType != ImpressionType.SUBSEQUENT || str.contains("IS_ORIGINAL")) && (impressionType != ImpressionType.VIEWABILITY || str.contains("IS_VIEWABLE")))) {
                CharSequence charSequence;
                CharSequence charSequence2;
                CharSequence charSequence3 = (impressionType == ImpressionType.ORIGINAL && m29331v()) ? "1" : "0";
                CharSequence charSequence4 = "IS_ORIGINAL";
                if (impressionType == ImpressionType.ORIGINAL) {
                    charSequence = "1";
                } else {
                    charSequence = "0";
                }
                String replace = str.replace(charSequence4, charSequence);
                charSequence4 = "IS_VIEWABLE";
                if (impressionType == ImpressionType.VIEWABILITY) {
                    charSequence2 = "1";
                } else {
                    charSequence2 = "0";
                }
                Object replace2 = replace.replace(charSequence4, charSequence2).replace("TRACKING", m29329a(arrayNode)).replace("CLIENT_TIMESTAMP", String.valueOf(j / 1000)).replace("CLIENT_STORY_POSITION", String.valueOf(this.f21619r)).replace("SEQUENCE_ID", String.valueOf(i)).replace("FROM_AUTOSCROLL", charSequence3);
                if (num != null) {
                    replace2 = replace2.replace("IMAGE_LOAD_STATE", String.valueOf(num));
                }
                a.add(replace2);
            }
        }
        return a;
    }

    public final int m29341n() {
        return this.f21621t;
    }

    private boolean m29331v() {
        return this.f21620s;
    }

    public final boolean mo3121k() {
        return !this.f21616o.isEmpty();
    }

    public final long mo3168d() {
        return 60000;
    }

    public final long mo3169f() {
        return 60000;
    }

    public final int mo3170g() {
        return 3;
    }

    public final boolean mo3118a() {
        return true;
    }

    public final boolean mo3119b() {
        for (int i = 0; i < this.f21616o.size(); i++) {
            if (((String) this.f21616o.get(i)).contains("IS_ORIGINAL")) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo3120c() {
        for (int i = 0; i < this.f21616o.size(); i++) {
            if (((String) this.f21616o.get(i)).contains("IS_VIEWABLE")) {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f21616o);
        ParcelUtil.a(parcel, this.f21617p);
        ParcelUtil.a(parcel, this.f21618q);
        parcel.writeInt(this.f21621t);
        ParcelUtil.a(parcel, this.f21622u);
    }

    private void m29330b(NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields) {
        if (newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields != null && IsValidUtil.m22943a(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields)) {
            List list = this.f21616o;
            if (!(list == null || newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2962a() == null)) {
                list.add(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2962a());
            }
            this.f21617p |= newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.L_();
            this.f21618q |= newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2963b();
            this.f21621t = Math.max(this.f21621t, newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2965d());
            this.j = Math.max(this.f19787j, newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2968k());
            this.k = Math.max(this.f19788k, newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2967j());
            this.f21622u = (!newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2964c() ? 1 : 0) | this.f21622u;
            this.f21623v |= newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2966g();
            this.f21625x |= newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.M_();
            this.f21626y |= newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.K_();
        }
    }

    private static String m29329a(ArrayNode arrayNode) {
        if (arrayNode != null) {
            try {
                return URLEncoder.encode(arrayNode.toString(), "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return "";
    }

    public final boolean m29336c(ImpressionType impressionType) {
        return (this.f19789l == mo3170g() + -1 ? 1 : null) != null && impressionType == ImpressionType.ORIGINAL;
    }
}
