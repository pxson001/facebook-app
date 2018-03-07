package com.facebook.api.feedtype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: sgny_facepile_size_param */
public class FeedType<T> implements Parcelable {
    public static final Creator<FeedType> CREATOR = new C02471();
    public static final FeedType f5038a = new FeedType("most_recent", Name.f5046a);
    public static final FeedType f5039b = new FeedType("top_stories", Name.f5046a);
    public static final FeedType f5040c = new FeedType("dash_feed", Name.f5049d);
    public static final FeedType f5041d = new FeedType("dash_importance", Name.f5050e);
    public static final FeedType f5042e = new FeedType("good_friends", Name.f5048c);
    public final T f5043f;
    public final Name f5044g;
    public String f5045h = "native_newsfeed";

    /* compiled from: sgny_facepile_size_param */
    public class Name implements Parcelable {
        public static final Creator<Name> CREATOR = new C02461();
        public static final Name f5046a = new Name("news_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5047b = new Name("friendlist_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5048c = new Name("good_friends_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5049d = new Name("dash_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5050e = new Name("dash_importance", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5051f = new Name("hashtag_feed", CachePolicy.NO_CACHE);
        public static final Name f5052g = new Name("page_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5053h = new Name("page_news_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5054i = new Name("stories_about_page_feed", CachePolicy.NO_CACHE);
        public static final Name f5055j = new Name("stories_about_topic_feed", CachePolicy.NO_CACHE);
        public static final Name f5056k = new Name("topic_feed", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5057l = new Name("graph_search_feed_type", CachePolicy.NO_CACHE);
        public static final Name f5058m = new Name("reaction_feed_type", CachePolicy.NO_CACHE);
        public static final Name f5059n = new Name("event_feed_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5060o = new Name("group_feed_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5061p = new Name("cross_group_for_sale_posts_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5062q = new Name("group_feed_owner_authored_available_for_sale_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5063r = new Name("group_feed_owner_authored_sold_for_sale_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5064s = new Name("group_feed_owner_authored_expired_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5065t = new Name("group_feed_available_for_sale_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5066u = new Name("group_feed_pending_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5067v = new Name("group_feed_pinned_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5068w = new Name("group_feed_reported_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5069x = new Name("goodwill_throwback_feed_type", CachePolicy.NO_CACHE);
        public static final Name f5070y = new Name("today_on_this_day_feed_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public static final Name f5071z = new Name("gametime_plays_feed_type", CachePolicy.DISK_AND_MEMORY_CACHE);
        public final String f5072A;
        public final CachePolicy f5073B;

        /* compiled from: sgny_facepile_size_param */
        final class C02461 implements Creator<Name> {
            C02461() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Name(parcel);
            }

            public final Object[] newArray(int i) {
                return new Name[i];
            }
        }

        private Name(String str, CachePolicy cachePolicy) {
            this.f5072A = str;
            this.f5073B = cachePolicy;
        }

        public Name(Parcel parcel) {
            this.f5072A = parcel.readString();
            this.f5073B = CachePolicy.valueOf(parcel.readString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f5072A);
            parcel.writeString(this.f5073B.name());
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            Name name = (Name) obj;
            return name != null && this.f5072A.equals(name.f5072A);
        }
    }

    /* compiled from: sgny_facepile_size_param */
    public enum CachePolicy {
        DISK_AND_MEMORY_CACHE,
        MEMORY_ONLY_CACHE,
        NO_CACHE
    }

    /* compiled from: sgny_facepile_size_param */
    final class C02471 implements Creator<FeedType> {
        C02471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedType(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedType[i];
        }
    }

    public FeedType(T t, Name name) {
        this.f5043f = Preconditions.checkNotNull(t);
        this.f5044g = name;
    }

    public FeedType(T t, Name name, String str) {
        this.f5043f = Preconditions.checkNotNull(t);
        this.f5044g = name;
        this.f5045h = str;
    }

    public FeedType(Parcel parcel) {
        this.f5043f = parcel.readValue(getClass().getClassLoader());
        this.f5044g = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f5045h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FeedType)) {
            return false;
        }
        return Objects.equal(m8961a(), ((FeedType) obj).m8961a()) && Objects.equal(this.f5044g, ((FeedType) obj).f5044g);
    }

    public int hashCode() {
        return Objects.hashCode(m8961a());
    }

    public String toString() {
        return m8961a();
    }

    public final String m8961a() {
        return this.f5043f.toString();
    }

    public final T m8962b() {
        return this.f5043f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f5043f);
        parcel.writeParcelable(this.f5044g, i);
        parcel.writeString(this.f5045h);
    }

    public final Name m8963c() {
        return this.f5044g;
    }

    public final CachePolicy m8964e() {
        return this.f5044g.f5073B;
    }
}
