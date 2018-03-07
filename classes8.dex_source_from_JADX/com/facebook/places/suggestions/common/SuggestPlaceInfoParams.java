package com.facebook.places.suggestions.common;

import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.graphql.enums.GraphQLPlaceHoursType;
import com.facebook.location.ImmutableLocation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: search_ts_token */
public class SuggestPlaceInfoParams {
    public final CrowdsourcingSource f3746A;
    public final ImmutableLocation f3747B;
    public final ImmutableList<Long> f3748C;
    public final CrowdEntryPoint f3749D;
    public final CrowdEndpoint f3750E;
    public final String f3751a;
    public final String f3752b;
    public final String f3753c;
    public final String f3754d;
    public final String f3755e;
    public final String f3756f;
    public final CrowdsourcedHours f3757g;
    public final GraphQLPlaceHoursType f3758h;
    public final String f3759i;
    public final String f3760j;
    public final ImmutableList<String> f3761k;
    public final String f3762l;
    public final ImmutableLocation f3763m;
    public final ImmutableList<Long> f3764n;
    public final ImmutableList<Long> f3765o;
    public final String f3766p;
    public final String f3767q;
    public final String f3768r;
    public final String f3769s;
    public final String f3770t;
    public final CrowdsourcedHours f3771u;
    public final GraphQLPlaceHoursType f3772v;
    public final String f3773w;
    public final String f3774x;
    public final ImmutableList<String> f3775y;
    public final String f3776z;

    /* compiled from: search_ts_token */
    public class Builder {
        public CrowdsourcingSource f3715A;
        private ImmutableLocation f3716B;
        private ImmutableList<Long> f3717C;
        public CrowdEntryPoint f3718D;
        public CrowdEndpoint f3719E;
        private String f3720a;
        private String f3721b;
        private String f3722c;
        public String f3723d;
        public String f3724e;
        public String f3725f;
        public CrowdsourcedHours f3726g;
        public GraphQLPlaceHoursType f3727h;
        private String f3728i;
        public String f3729j;
        public ImmutableList<String> f3730k;
        public String f3731l;
        public ImmutableLocation f3732m;
        private ImmutableList<Long> f3733n;
        public ImmutableList<Long> f3734o;
        private String f3735p;
        private String f3736q;
        public String f3737r;
        public String f3738s;
        public String f3739t;
        public CrowdsourcedHours f3740u;
        public GraphQLPlaceHoursType f3741v;
        private String f3742w;
        public String f3743x;
        public ImmutableList<String> f3744y;
        public String f3745z;

        public Builder(String str) {
            this.f3720a = str;
        }

        public final SuggestPlaceInfoParams m3637a() {
            return new SuggestPlaceInfoParams(this.f3720a, this.f3721b, this.f3722c, this.f3723d, this.f3724e, this.f3725f, this.f3726g, this.f3727h, this.f3728i, this.f3729j, this.f3730k, this.f3731l, this.f3732m, this.f3733n, this.f3734o, this.f3735p, this.f3736q, this.f3737r, this.f3738s, this.f3739t, this.f3740u, this.f3741v, this.f3742w, this.f3743x, this.f3744y, this.f3745z, this.f3715A, this.f3716B, this.f3717C, this.f3718D, this.f3719E);
        }

        public final Builder m3636a(String str) {
            this.f3721b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder m3639b(String str) {
            Preconditions.checkNotNull(str);
            this.f3722c = str;
            return this;
        }

        public final Builder m3641f(String str) {
            this.f3728i = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder m3638b(ImmutableList<Long> immutableList) {
            this.f3733n = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }

        public final Builder m3642i(String str) {
            this.f3735p = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder m3643j(String str) {
            Preconditions.checkNotNull(str);
            this.f3736q = str;
            return this;
        }

        public final Builder m3644n(String str) {
            this.f3742w = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder m3640e(ImmutableList<Long> immutableList) {
            this.f3717C = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }
    }

    public static Builder m3645a(String str) {
        return new Builder(str);
    }

    private SuggestPlaceInfoParams(String str, String str2, String str3, String str4, String str5, String str6, CrowdsourcedHours crowdsourcedHours, GraphQLPlaceHoursType graphQLPlaceHoursType, String str7, String str8, ImmutableList<String> immutableList, String str9, ImmutableLocation immutableLocation, ImmutableList<Long> immutableList2, ImmutableList<Long> immutableList3, String str10, String str11, String str12, String str13, String str14, CrowdsourcedHours crowdsourcedHours2, GraphQLPlaceHoursType graphQLPlaceHoursType2, String str15, String str16, ImmutableList<String> immutableList4, String str17, CrowdsourcingSource crowdsourcingSource, ImmutableLocation immutableLocation2, ImmutableList<Long> immutableList5, CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
        this.f3751a = str;
        this.f3752b = str2;
        this.f3753c = str3;
        this.f3754d = str4;
        this.f3755e = str5;
        this.f3756f = str6;
        this.f3757g = crowdsourcedHours;
        this.f3758h = graphQLPlaceHoursType;
        this.f3759i = str7;
        this.f3760j = str8;
        this.f3761k = immutableList;
        this.f3762l = str9;
        this.f3763m = immutableLocation;
        this.f3764n = immutableList2;
        this.f3765o = immutableList3;
        this.f3766p = str10;
        this.f3767q = str11;
        this.f3768r = str12;
        this.f3769s = str13;
        this.f3770t = str14;
        this.f3771u = crowdsourcedHours2;
        this.f3772v = graphQLPlaceHoursType2;
        this.f3773w = str15;
        this.f3774x = str16;
        this.f3775y = immutableList4;
        this.f3776z = str17;
        this.f3747B = immutableLocation2;
        this.f3746A = crowdsourcingSource;
        this.f3748C = immutableList5;
        this.f3749D = crowdEntryPoint;
        this.f3750E = crowdEndpoint;
    }
}
