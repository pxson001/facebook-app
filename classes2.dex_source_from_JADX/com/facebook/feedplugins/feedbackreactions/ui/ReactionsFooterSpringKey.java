package com.facebook.feedplugins.feedbackreactions.ui;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;

/* compiled from: get_terms_and_conditions */
public class ReactionsFooterSpringKey implements ContextStateKey<String, Spring> {
    private final String f22404a;
    private final SpringSystem f22405b;

    public ReactionsFooterSpringKey(String str, SpringSystem springSystem) {
        this.f22404a = getClass() + str;
        this.f22405b = springSystem;
    }

    public final Object mo2130a() {
        Spring a = this.f22405b.m7838a().m7814a(SpringConfig.m7843b(11.0d, 0.0d));
        a.f4216c = true;
        return a;
    }

    public final Object mo2131b() {
        return this.f22404a;
    }
}
