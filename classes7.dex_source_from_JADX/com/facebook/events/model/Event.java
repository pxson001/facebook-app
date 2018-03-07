package com.facebook.events.model;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* compiled from: sync_bad_new_message_delta */
public class Event implements Parcelable, Comparable<Event> {
    public static final Creator<Event> CREATOR = new C02321();
    public boolean f2640A = true;
    private GraphQLEventGuestStatus f2641B = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLEventWatchStatus f2642C;
    public boolean f2643D;
    public String f2644E;
    public String f2645F;
    public boolean f2646G;
    private Date f2647H;
    private long f2648I;
    private Date f2649J;
    private long f2650K;
    public TimeZone f2651L;
    public boolean f2652M;
    public LatitudeLongitude f2653N;
    public long f2654O = -1;
    public String f2655P;
    public String f2656Q;
    public TimeZone f2657R;
    public int f2658S;
    public String f2659T;
    public Uri f2660U;
    public String f2661V;
    public Uri f2662W;
    public Uri f2663X;
    public Uri f2664Y;
    public String f2665Z;
    public String f2666a;
    private EnumSet<EventViewerCapability> aa;
    public boolean ab;
    public String ac;
    public int ad;
    public String ae;
    public int af;
    public String ag;
    public int ah;
    public EventUser ai;
    public String aj;
    public String ak;
    public String al;
    public String am;
    public ComposerTargetDataPrivacyScopeFieldsModel an;
    public String f2667b;
    public EventCommonTextWithEntitiesModel f2668c;
    public GraphQLEventPrivacyType f2669d;
    public EventType f2670e;
    public PrivacyType f2671f;
    public PrivacyKind f2672g;
    public boolean f2673h;
    public boolean f2674i;
    public boolean f2675j;
    public boolean f2676k;
    public GraphQLConnectionStyle f2677l;
    public GraphQLEventActionStyle f2678m;
    public String f2679n;
    public int f2680o;
    public ImmutableList<String> f2681p;
    public String f2682q;
    public String f2683r;
    public String f2684s;
    public String f2685t;
    public String f2686u;
    public String f2687v;
    public String f2688w;
    public boolean f2689x;
    public boolean f2690y;
    public long f2691z;

    /* compiled from: sync_bad_new_message_delta */
    final class C02321 implements Creator<Event> {
        C02321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        public final Object[] newArray(int i) {
            return new Event[i];
        }
    }

    /* compiled from: sync_bad_new_message_delta */
    /* synthetic */ class C02332 {
        static final /* synthetic */ int[] f2587a = new int[GraphQLEventWatchStatus.values().length];

        static {
            try {
                f2587a[GraphQLEventWatchStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2587a[GraphQLEventWatchStatus.WATCHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2587a[GraphQLEventWatchStatus.UNWATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2587a[GraphQLEventWatchStatus.DECLINED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: sync_bad_new_message_delta */
    public class Builder {
        public boolean f2588A = true;
        public GraphQLEventGuestStatus f2589B = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        public GraphQLEventWatchStatus f2590C;
        public boolean f2591D;
        public String f2592E;
        public String f2593F;
        public boolean f2594G;
        public Date f2595H;
        public Date f2596I;
        public TimeZone f2597J;
        public boolean f2598K = false;
        public LatitudeLongitude f2599L;
        public long f2600M = -1;
        public String f2601N;
        public String f2602O;
        public TimeZone f2603P;
        public int f2604Q;
        public String f2605R;
        public Uri f2606S;
        public String f2607T;
        public Uri f2608U;
        public Uri f2609V;
        public Uri f2610W;
        public String f2611X;
        public EnumSet<EventViewerCapability> f2612Y = EnumSet.noneOf(EventViewerCapability.class);
        public boolean f2613Z;
        public String f2614a;
        public String aa;
        public int ab;
        public String ac;
        public int ad;
        public String ae;
        public int af;
        public EventUser ag;
        public String ah;
        public String ai;
        public String aj;
        public String ak;
        public ComposerTargetDataPrivacyScopeFieldsModel al;
        public String f2615b;
        public EventCommonTextWithEntitiesModel f2616c;
        public GraphQLEventPrivacyType f2617d;
        public EventType f2618e;
        public PrivacyKind f2619f;
        public PrivacyType f2620g;
        public boolean f2621h;
        public boolean f2622i;
        public boolean f2623j;
        public boolean f2624k;
        public GraphQLConnectionStyle f2625l;
        public GraphQLEventActionStyle f2626m;
        public String f2627n;
        public int f2628o;
        public ImmutableList<String> f2629p;
        public String f2630q;
        public String f2631r;
        public String f2632s;
        public String f2633t;
        public String f2634u;
        public String f2635v;
        public String f2636w;
        public boolean f2637x;
        public boolean f2638y;
        public long f2639z;

        public Builder(Event event) {
            this.f2614a = event.f2666a;
            this.f2615b = event.f2667b;
            this.f2616c = event.f2668c;
            this.f2617d = event.f2669d;
            this.f2618e = event.f2670e;
            this.f2619f = event.f2672g;
            this.f2620g = event.f2671f;
            this.f2625l = event.f2677l;
            this.f2626m = event.f2678m;
            this.f2621h = event.f2673h;
            this.f2623j = event.f2675j;
            this.f2624k = event.f2676k;
            this.f2627n = event.f2679n;
            this.f2628o = event.f2680o;
            this.f2629p = event.f2681p;
            this.f2630q = event.f2682q;
            this.f2631r = event.f2683r;
            this.f2632s = event.f2684s;
            this.f2633t = event.f2685t;
            this.f2634u = event.f2686u;
            this.f2635v = event.f2687v;
            this.f2636w = event.f2688w;
            this.f2637x = event.f2689x;
            this.f2588A = event.f2640A;
            this.f2589B = event.m2991D();
            this.f2591D = event.f2643D;
            this.f2592E = event.f2644E;
            this.f2593F = event.f2645F;
            this.f2594G = event.f2646G;
            this.f2595H = event.m2992J();
            this.f2596I = event.m2994L();
            this.f2597J = event.f2651L;
            this.f2598K = event.f2652M;
            this.f2600M = event.f2654O;
            this.f2601N = event.f2655P;
            this.f2599L = event.f2653N;
            this.f2602O = event.f2656Q;
            this.f2603P = event.f2657R;
            this.f2604Q = event.f2658S;
            this.f2605R = event.f2659T;
            this.f2606S = event.f2660U;
            this.f2607T = event.f2661V;
            this.f2608U = event.f2662W;
            this.f2609V = event.f2663X;
            this.f2610W = event.f2664Y;
            this.f2611X = event.f2665Z;
            this.f2613Z = event.ab;
            m2981a(event.ae());
            this.aa = event.ac;
            this.ab = event.ad;
            this.ac = event.ae;
            this.ad = event.af;
            this.ae = event.ag;
            this.af = event.ah;
            this.ag = event.ai;
            this.ah = event.aj;
            this.ai = event.ak;
            this.aj = event.al;
            this.ak = event.am;
            this.al = event.an;
        }

        public final Builder m2979a(long j) {
            this.f2639z = j;
            return this;
        }

        public final Builder m2977a() {
            this.f2600M = -1;
            this.f2601N = null;
            this.f2599L = null;
            this.f2602O = null;
            this.f2603P = null;
            this.f2604Q = 0;
            this.f2605R = null;
            return this;
        }

        public final Builder m2980a(long j, String str) {
            this.f2600M = j;
            this.f2601N = str;
            this.f2599L = null;
            this.f2602O = null;
            this.f2603P = null;
            this.f2604Q = 0;
            this.f2605R = null;
            return this;
        }

        public final Builder m2978a(double d, double d2) {
            this.f2599L = new LatitudeLongitude(d, d2);
            return this;
        }

        public final Builder m2982b(long j) {
            this.f2600M = j;
            return this;
        }

        public final Builder m2981a(EnumSet<EventViewerCapability> enumSet) {
            if (enumSet == null) {
                this.f2612Y.clear();
            } else {
                this.f2612Y = enumSet;
            }
            return this;
        }

        public final Event m2983b() {
            return new Event(this);
        }
    }

    public int compareTo(Object obj) {
        Event event = (Event) obj;
        long K = m2993K();
        long K2 = event.m2993K();
        if (K < K2) {
            return -1;
        }
        return K > K2 ? 1 : 0;
    }

    public static GraphQLEventGuestStatus m2984a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        switch (C02332.f2587a[graphQLEventWatchStatus.ordinal()]) {
            case 1:
                return GraphQLEventGuestStatus.GOING;
            case 2:
                return GraphQLEventGuestStatus.MAYBE;
            case 3:
                return GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 4:
                return GraphQLEventGuestStatus.NOT_GOING;
            default:
                return GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }

    public final boolean m3003b() {
        return this.f2646G || (this.f2677l != GraphQLConnectionStyle.INTERESTED ? this.f2641B != GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : this.f2642C != GraphQLEventWatchStatus.UNWATCHED);
    }

    public Event(Builder builder) {
        this.f2666a = builder.f2614a;
        this.f2667b = builder.f2615b;
        this.f2668c = builder.f2616c;
        this.f2669d = builder.f2617d;
        this.f2670e = builder.f2618e;
        this.f2672g = builder.f2619f;
        this.f2671f = builder.f2620g;
        this.f2673h = builder.f2621h;
        this.f2674i = builder.f2622i;
        this.f2675j = builder.f2623j;
        this.f2676k = builder.f2624k;
        this.f2677l = builder.f2625l;
        this.f2678m = builder.f2626m;
        this.f2679n = builder.f2627n;
        this.f2680o = builder.f2628o;
        this.f2681p = builder.f2629p;
        this.f2682q = builder.f2630q;
        this.f2683r = builder.f2631r;
        this.f2684s = builder.f2632s;
        this.f2685t = builder.f2633t;
        this.f2686u = builder.f2634u;
        this.f2687v = builder.f2635v;
        this.f2688w = builder.f2636w;
        this.f2689x = builder.f2637x;
        this.f2690y = builder.f2638y;
        this.f2691z = builder.f2639z;
        this.f2640A = builder.f2588A;
        this.f2641B = builder.f2589B;
        this.f2642C = builder.f2590C;
        this.f2643D = builder.f2591D;
        this.f2644E = builder.f2592E;
        this.f2645F = builder.f2593F;
        this.f2646G = builder.f2594G;
        this.f2647H = builder.f2595H;
        if (this.f2647H != null) {
            this.f2648I = builder.f2595H.getTime();
        }
        this.f2649J = builder.f2596I;
        if (this.f2649J != null) {
            this.f2650K = builder.f2596I.getTime();
        }
        this.f2651L = builder.f2597J;
        this.f2652M = builder.f2598K;
        this.f2653N = builder.f2599L;
        this.f2654O = builder.f2600M;
        this.f2655P = builder.f2601N;
        this.f2659T = builder.f2605R;
        this.f2656Q = builder.f2602O;
        this.f2657R = builder.f2603P;
        this.f2658S = builder.f2604Q;
        this.f2660U = builder.f2606S;
        this.f2661V = builder.f2607T;
        this.f2662W = builder.f2608U;
        this.f2663X = builder.f2609V;
        this.f2664Y = builder.f2610W;
        this.f2665Z = builder.f2611X;
        this.aa = builder.f2612Y;
        this.ab = builder.f2613Z;
        this.ac = builder.aa;
        this.ad = builder.ab;
        this.ae = builder.ac;
        this.af = builder.ad;
        this.ag = builder.ae;
        this.ah = builder.af;
        this.ai = builder.ag;
        this.aj = builder.ah;
        this.ak = builder.ai;
        this.al = builder.aj;
        this.am = builder.ak;
        this.an = builder.al;
    }

    public final String m3004c() {
        return this.f2666a;
    }

    public final boolean m2990A() {
        return this.f2690y;
    }

    public final GraphQLEventGuestStatus m2991D() {
        Preconditions.checkNotNull(this.f2641B);
        return this.f2641B;
    }

    public final Date m2992J() {
        if (this.f2647H == null) {
            throw new IllegalStateException("Event (" + this.f2666a + ") has null start date, which is not allowed.");
        }
        if (this.f2648I != this.f2647H.getTime()) {
            this.f2647H = new Date(this.f2648I);
        }
        return this.f2647H;
    }

    public final long m2993K() {
        if (this.f2647H != null) {
            return this.f2648I;
        }
        throw new IllegalStateException("Event (" + this.f2666a + ") has null start date, which is not allowed.");
    }

    public final Date m2994L() {
        if (this.f2649J == null) {
            return null;
        }
        if (this.f2650K != this.f2649J.getTime()) {
            this.f2649J = new Date(this.f2650K);
        }
        return this.f2649J;
    }

    public final long m2995M() {
        if (this.f2649J != null) {
            return this.f2649J.getTime();
        }
        throw new IllegalStateException("Event (" + this.f2666a + ") has null end date, unexpected method call.");
    }

    public final long m3000a(long j) {
        return this.f2649J == null ? j : this.f2649J.getTime();
    }

    public final boolean m2996P() {
        return this.f2653N != null;
    }

    public final double m2997Q() {
        return this.f2653N.f2759a;
    }

    public final double m2998R() {
        return this.f2653N.f2760b;
    }

    public final String m2999Z() {
        return this.f2661V;
    }

    public final EnumSet<EventViewerCapability> ae() {
        return this.aa.clone();
    }

    public final boolean m3001a(EventViewerCapability eventViewerCapability) {
        return this.aa.contains(eventViewerCapability);
    }

    public final String an() {
        if (this.ai == null || this.ai.f2753h != GraphQLFriendshipStatus.ARE_FRIENDS) {
            return null;
        }
        return this.ai.f2748c;
    }

    public static boolean m2989b(long j) {
        return j > 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        String str = null;
        int i3 = 1;
        parcel.writeString(this.f2666a);
        parcel.writeString(this.f2667b);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f2668c);
        parcel.writeString(this.f2669d != null ? this.f2669d.toString() : "");
        parcel.writeParcelable(this.f2670e, i);
        parcel.writeParcelable(this.f2672g, i);
        parcel.writeParcelable(this.f2671f, i);
        if (this.f2673h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f2674i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f2675j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f2676k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f2677l != null ? this.f2677l.toString() : "");
        parcel.writeString(this.f2678m != null ? this.f2678m.toString() : "");
        parcel.writeString(this.f2679n);
        parcel.writeInt(this.f2680o);
        parcel.writeStringList(this.f2681p);
        parcel.writeString(this.f2682q);
        parcel.writeString(this.f2683r);
        parcel.writeString(this.f2684s);
        parcel.writeString(this.f2685t);
        parcel.writeString(this.f2686u);
        parcel.writeString(this.f2687v);
        parcel.writeString(this.f2688w);
        parcel.writeInt(this.f2689x ? 1 : 0);
        if (this.f2690y) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.f2691z);
        if (this.f2640A) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f2641B == null ? null : this.f2641B.name());
        if (this.f2642C != null) {
            str = this.f2642C.name();
        }
        parcel.writeString(str);
        if (this.f2643D) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f2644E);
        parcel.writeString(this.f2645F);
        if (this.f2646G) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.f2647H.getTime());
        if (this.f2649J == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(this.f2649J.getTime());
        }
        if (this.f2651L == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f2651L.getID());
        }
        if (this.f2652M) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f2656Q);
        if (this.f2653N == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(this.f2653N.f2759a);
            parcel.writeDouble(this.f2653N.f2760b);
        }
        parcel.writeLong(this.f2654O);
        parcel.writeString(this.f2655P);
        if (this.f2657R == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f2657R.getID());
        }
        parcel.writeInt(this.f2658S);
        parcel.writeParcelable(this.f2660U, i);
        parcel.writeString(this.f2661V);
        parcel.writeParcelable(this.f2662W, i);
        parcel.writeParcelable(this.f2663X, i);
        parcel.writeParcelable(this.f2664Y, i);
        parcel.writeString(this.f2665Z);
        parcel.writeLong(EventViewerCapability.serializeCapabilities(this.aa));
        if (!this.ab) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.ac);
        parcel.writeInt(this.ad);
        parcel.writeString(this.ae);
        parcel.writeInt(this.af);
        parcel.writeString(this.ag);
        parcel.writeInt(this.ah);
        parcel.writeParcelable(this.ai, i);
        parcel.writeString(this.aj);
        parcel.writeString(this.ak);
        parcel.writeString(this.al);
        parcel.writeString(this.am);
        FlatBufferModelHelper.a(parcel, this.an);
    }

    public Event(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f2666a = parcel.readString();
        this.f2667b = parcel.readString();
        this.f2668c = (EventCommonTextWithEntitiesModel) FlatBufferModelHelper.a(parcel);
        this.f2669d = GraphQLEventPrivacyType.fromString(parcel.readString());
        this.f2670e = (EventType) parcel.readParcelable(EventType.class.getClassLoader());
        this.f2672g = (PrivacyKind) parcel.readParcelable(PrivacyKind.class.getClassLoader());
        this.f2671f = (PrivacyType) parcel.readParcelable(PrivacyType.class.getClassLoader());
        this.f2673h = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2674i = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2675j = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2676k = z;
        this.f2677l = GraphQLConnectionStyle.fromString(parcel.readString());
        this.f2678m = GraphQLEventActionStyle.fromString(parcel.readString());
        this.f2679n = parcel.readString();
        this.f2680o = parcel.readInt();
        Collection createStringArrayList = parcel.createStringArrayList();
        if (CollectionUtil.a(createStringArrayList)) {
            this.f2681p = RegularImmutableList.a;
        } else {
            this.f2681p = ImmutableList.copyOf(createStringArrayList);
        }
        this.f2682q = parcel.readString();
        this.f2683r = parcel.readString();
        this.f2684s = parcel.readString();
        this.f2685t = parcel.readString();
        this.f2686u = parcel.readString();
        this.f2687v = parcel.readString();
        this.f2688w = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2689x = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2690y = z;
        this.f2691z = parcel.readLong();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2640A = z;
        this.f2641B = GraphQLEventGuestStatus.fromString(parcel.readString());
        this.f2642C = GraphQLEventWatchStatus.fromString(parcel.readString());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2643D = z;
        this.f2644E = parcel.readString();
        this.f2645F = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2646G = z;
        this.f2648I = parcel.readLong();
        this.f2647H = new Date(this.f2648I);
        if (parcel.readInt() == 1) {
            this.f2650K = parcel.readLong();
            this.f2649J = new Date(this.f2650K);
        }
        if (parcel.readInt() == 1) {
            this.f2651L = TimeZone.getTimeZone(parcel.readString());
        }
        this.f2652M = parcel.readInt() == 1;
        this.f2656Q = parcel.readString();
        if (parcel.readInt() == 1) {
            this.f2653N = new LatitudeLongitude(parcel.readDouble(), parcel.readDouble());
        }
        this.f2654O = parcel.readLong();
        this.f2655P = parcel.readString();
        if (parcel.readInt() == 1) {
            this.f2657R = TimeZone.getTimeZone(parcel.readString());
        }
        this.f2658S = parcel.readInt();
        this.f2660U = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2661V = parcel.readString();
        this.f2662W = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2663X = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2664Y = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2665Z = parcel.readString();
        this.aa = EventViewerCapability.deserializeCapabilities(parcel.readLong());
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.ab = z2;
        this.ac = parcel.readString();
        this.ad = parcel.readInt();
        this.ae = parcel.readString();
        this.af = parcel.readInt();
        this.ag = parcel.readString();
        this.ah = parcel.readInt();
        this.ai = (EventUser) parcel.readParcelable(EventUser.class.getClassLoader());
        this.aj = parcel.readString();
        this.ak = parcel.readString();
        this.al = parcel.readString();
        this.am = parcel.readString();
        this.an = (ComposerTargetDataPrivacyScopeFieldsModel) FlatBufferModelHelper.a(parcel);
    }

    public static boolean m2985a(Event event) {
        if (event == null || event.f2677l == null || event.f2677l != GraphQLConnectionStyle.INTERESTED) {
            return false;
        }
        return true;
    }

    public static boolean m2986a(@Nullable GraphQLConnectionStyle graphQLConnectionStyle) {
        return graphQLConnectionStyle != null && graphQLConnectionStyle == GraphQLConnectionStyle.RSVP;
    }

    public static boolean m2987a(GraphQLEventPrivacyType graphQLEventPrivacyType) {
        return graphQLEventPrivacyType == GraphQLEventPrivacyType.PRIVATE_TYPE || graphQLEventPrivacyType == GraphQLEventPrivacyType.GROUP;
    }

    public final boolean as() {
        return m2988a(this.f2652M, this.f2648I, this.f2650K);
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public static boolean m2988a(boolean z, long j, long j2) {
        return (z ? 86400000 + j : Math.max(j, j2)) < System.currentTimeMillis();
    }

    public final boolean m3002a(String str) {
        if (this.f2686u.equals(str) || !StringUtil.a(this.f2687v)) {
            return true;
        }
        for (int i = 0; i < this.f2681p.size(); i++) {
            if (((String) this.f2681p.get(i)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Event) && Objects.equal(this.f2666a, ((Event) obj).f2666a));
    }

    public int hashCode() {
        return this.f2666a != null ? this.f2666a.hashCode() : 0;
    }
}
