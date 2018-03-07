package com.facebook.greetingcards.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.greetingcards.model.CardPhoto.Type;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@JsonSerialize(using = GreetingCardSerializer.class)
/* compiled from: TRIGHT;) */
public class GreetingCard implements Parcelable {
    public static final Creator<GreetingCard> CREATOR = new C12891();
    public final Slide f13521a;
    public final ImmutableList<Slide> f13522b;
    public final Slide f13523c;
    public final String f13524d;
    public final String f13525e;
    public final String f13526f;

    /* compiled from: TRIGHT;) */
    final class C12891 implements Creator<GreetingCard> {
        C12891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GreetingCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new GreetingCard[i];
        }
    }

    /* compiled from: TRIGHT;) */
    public class Slide implements Parcelable {
        public static final Creator<Slide> CREATOR = new C12901();
        public final String f13518a;
        public final String f13519b;
        public final ImmutableList<CardPhoto> f13520c;

        /* compiled from: TRIGHT;) */
        final class C12901 implements Creator<Slide> {
            C12901() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Slide(parcel);
            }

            public final Object[] newArray(int i) {
                return new Slide[i];
            }
        }

        public Slide(String str, String str2, ImmutableList<CardPhoto> immutableList) {
            this.f13518a = str;
            this.f13519b = str2;
            this.f13520c = immutableList;
        }

        public static Slide m22713a(Slide slide, Map<Uri, String> map) {
            Builder builder = ImmutableList.builder();
            ImmutableList immutableList = slide.f13520c;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Object obj = (CardPhoto) immutableList.get(i);
                if (map.containsKey(obj.f13513a)) {
                    obj = new CardPhoto(obj.f13513a, Type.LOCAL_UPLOADED, (String) map.get(obj.f13513a), obj.f13516d, null);
                }
                builder.c(obj);
            }
            return new Slide(slide.f13518a, slide.f13519b, builder.b());
        }

        public Slide(Parcel parcel) {
            this.f13518a = parcel.readString();
            this.f13519b = parcel.readString();
            this.f13520c = ImmutableList.copyOf(parcel.readArrayList(CardPhoto.class.getClassLoader()));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f13518a);
            parcel.writeString(this.f13519b);
            parcel.writeList(this.f13520c);
        }
    }

    public GreetingCard(Slide slide, ImmutableList<Slide> immutableList, Slide slide2, String str, String str2, @Nullable String str3) {
        this.f13521a = slide;
        this.f13522b = immutableList;
        this.f13523c = slide2;
        this.f13524d = (String) Preconditions.checkNotNull(str);
        this.f13525e = (String) Preconditions.checkNotNull(str2);
        this.f13526f = str3;
    }

    public static GreetingCard m22715a(GreetingCard greetingCard, Map<Uri, String> map) {
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = greetingCard.f13522b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(Slide.m22713a((Slide) immutableList.get(i), map));
        }
        return new GreetingCard(Slide.m22713a(greetingCard.f13521a, map), builder.b(), Slide.m22713a(greetingCard.f13523c, map), greetingCard.f13524d, greetingCard.f13525e, greetingCard.f13526f);
    }

    public static GreetingCard m22714a(GreetingCard greetingCard) {
        return new GreetingCard(new Slide(greetingCard.f13521a.f13518a, "", greetingCard.f13521a.f13520c), greetingCard.f13522b, new Slide(greetingCard.f13523c.f13518a, "", greetingCard.f13523c.f13520c), greetingCard.f13524d, greetingCard.f13525e, greetingCard.f13526f);
    }

    public GreetingCard(Parcel parcel) {
        this.f13521a = (Slide) parcel.readParcelable(Slide.class.getClassLoader());
        this.f13522b = ImmutableList.copyOf(parcel.readArrayList(Slide.class.getClassLoader()));
        this.f13523c = (Slide) parcel.readParcelable(Slide.class.getClassLoader());
        this.f13524d = parcel.readString();
        this.f13525e = parcel.readString();
        this.f13526f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f13521a, i);
        parcel.writeList(this.f13522b);
        parcel.writeParcelable(this.f13523c, i);
        parcel.writeString(this.f13524d);
        parcel.writeString(this.f13525e);
        parcel.writeString(this.f13526f);
    }
}
