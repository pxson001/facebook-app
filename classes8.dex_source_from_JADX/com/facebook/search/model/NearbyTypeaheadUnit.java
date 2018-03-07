package com.facebook.search.model;

import android.location.Location;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.google.common.base.Objects;

/* compiled from: TO_RIGHT_OF */
public class NearbyTypeaheadUnit extends TypeaheadUnit implements NullStateModuleUnit {
    public final String f22156a;
    public final String f22157b;
    private final String f22158c;
    private final GraphQLPageCategoryType f22159d;
    private final Location f22160e;
    private final String f22161f;
    public final String f22162g;
    private final String f22163h;
    private final PresenceSource f22164i;
    public final int f22165j;
    private final Type f22166k;

    /* compiled from: TO_RIGHT_OF */
    public class Builder {
        public String f22145a;
        public String f22146b;
        public String f22147c;
        public GraphQLPageCategoryType f22148d;
        public Location f22149e;
        public String f22150f;
        public String f22151g;
        public String f22152h;
        public PresenceSource f22153i;
        public int f22154j;
        public Type f22155k = Type.unset;

        public final Builder m25669a(double d, double d2) {
            Location location = new Location(null);
            location.setLatitude(d);
            location.setLongitude(d2);
            this.f22149e = location;
            return this;
        }

        public final Builder m25670a(Type type) {
            if (type == null) {
                type = Type.unset;
            }
            this.f22155k = type;
            return this;
        }
    }

    public NearbyTypeaheadUnit(Builder builder) {
        this.f22156a = builder.f22145a;
        this.f22157b = builder.f22146b;
        this.f22158c = builder.f22147c;
        this.f22159d = builder.f22148d;
        this.f22160e = builder.f22149e;
        this.f22161f = builder.f22150f;
        this.f22162g = builder.f22151g;
        this.f22163h = builder.f22152h;
        this.f22164i = builder.f22153i;
        this.f22165j = builder.f22154j;
        this.f22166k = builder.f22155k;
    }

    public final SuggestionGroup.Type m25675k() {
        return SuggestionGroup.Type.NEARBY;
    }

    public final Type mo1223p() {
        return this.f22166k;
    }

    public final <T> T m25672a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1226a(this);
    }

    public final void m25674a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25772a(this);
    }

    public final boolean m25676l() {
        return true;
    }

    public final void m25673a(HoneyClientEvent honeyClientEvent) {
        if (this.f22166k != null) {
            honeyClientEvent.b("keyword_source", this.f22166k.name()).a("local_module_rank", this.f22165j);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NearbyTypeaheadUnit)) {
            return false;
        }
        NearbyTypeaheadUnit nearbyTypeaheadUnit = (NearbyTypeaheadUnit) obj;
        if (this.f22156a.equals(nearbyTypeaheadUnit.f22156a) && this.f22157b.equals(nearbyTypeaheadUnit.f22157b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f22157b, this.f22156a});
    }

    public String toString() {
        return "NearbyTypeaheadUnit[" + this.f22157b + "]";
    }
}
