package com.facebook.messaging.model.attribution;

/* compiled from: user_longitude */
public class AttributionVisibilityBuilder {
    public boolean f1909a;
    public boolean f1910b;
    public boolean f1911c;
    public boolean f1912d;
    public boolean f1913e;

    AttributionVisibilityBuilder() {
    }

    public final AttributionVisibilityBuilder m3266f() {
        this.f1909a = false;
        this.f1910b = false;
        this.f1911c = false;
        this.f1912d = false;
        this.f1913e = false;
        return this;
    }

    public final AttributionVisibility m3267h() {
        return new AttributionVisibility(this);
    }
}
