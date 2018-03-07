package com.facebook.crudolib.appstrictmode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: see_first_actors */
public final class AppStrictMode {

    /* compiled from: see_first_actors */
    public final class AppPolicy {
        public static final AppPolicy f2856a = new AppPolicy(0);
        public final int f2857b;

        private AppPolicy(int i) {
            this.f2857b = i;
        }

        public final String toString() {
            return "AppStrictMode.AppPolicy{mask=" + this.f2857b + "}";
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: see_first_actors */
    @interface Penalty {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: see_first_actors */
    public @interface Violation {
    }
}
