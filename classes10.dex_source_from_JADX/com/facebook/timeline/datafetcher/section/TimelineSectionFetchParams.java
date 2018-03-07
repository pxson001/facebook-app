package com.facebook.timeline.datafetcher.section;

import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.timeline.logging.TimelinePerformanceLogger.UnitsFetchTrigger;
import javax.annotation.Nullable;

/* compiled from: graphEventEdit */
public class TimelineSectionFetchParams {
    public final String f10697a;
    public final UnitsFetchTrigger f10698b;
    @Nullable
    public final String f10699c;
    @Nullable
    public final GraphQLRefParam f10700d;
    public final String f10701e;
    public final GraphQLRefParam f10702f;
    public final boolean f10703g;
    public final boolean f10704h;
    public final boolean f10705i;
    public final int f10706j;
    public final String f10707k;

    /* compiled from: graphEventEdit */
    public class Builder {
        public UnitsFetchTrigger f10689a;
        @Nullable
        public String f10690b;
        @Nullable
        public GraphQLRefParam f10691c;
        private String f10692d = "";
        private GraphQLRefParam f10693e;
        public boolean f10694f = false;
        public int f10695g = 0;
        public String f10696h;

        public Builder(TimelineSectionFetchParams timelineSectionFetchParams) {
            this.f10689a = timelineSectionFetchParams.f10698b;
            this.f10690b = timelineSectionFetchParams.f10699c;
            this.f10691c = timelineSectionFetchParams.f10700d;
            this.f10693e = timelineSectionFetchParams.f10702f;
            this.f10692d = timelineSectionFetchParams.f10701e;
            this.f10694f = timelineSectionFetchParams.f10705i;
            this.f10695g = timelineSectionFetchParams.f10706j;
            this.f10696h = timelineSectionFetchParams.f10707k;
        }

        public final Builder m10742a(String str) {
            this.f10690b = str;
            this.f10691c = null;
            return this;
        }

        public final Builder m10744b(String str) {
            this.f10692d = str;
            this.f10693e = null;
            return this;
        }

        public final Builder m10743b(GraphQLRefParam graphQLRefParam) {
            this.f10693e = graphQLRefParam;
            this.f10692d = null;
            return this;
        }

        public final TimelineSectionFetchParams m10745b() {
            return new TimelineSectionFetchParams(this.f10689a, this.f10690b, this.f10691c, this.f10692d, this.f10693e, this.f10694f, this.f10695g, this.f10696h);
        }
    }

    private TimelineSectionFetchParams(UnitsFetchTrigger unitsFetchTrigger, @Nullable String str, @Nullable GraphQLRefParam graphQLRefParam, String str2, GraphQLRefParam graphQLRefParam2, boolean z, int i, String str3) {
        this.f10697a = "timelineFetch" + String.valueOf(System.currentTimeMillis());
        this.f10698b = unitsFetchTrigger;
        this.f10699c = str;
        this.f10700d = graphQLRefParam;
        this.f10701e = str2;
        this.f10702f = graphQLRefParam2;
        boolean z2 = str == null && graphQLRefParam == null;
        this.f10703g = z2;
        this.f10704h = "".equals(str2);
        this.f10705i = z;
        this.f10706j = i;
        this.f10707k = str3;
    }

    public final Builder m10746a() {
        return new Builder(this);
    }
}
