package com.facebook.api.feed.util;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.google.common.base.Objects;

/* compiled from: rtc_force_enable_software_aec */
public class FeedUtils {
    public static boolean m11183a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        if (!(feedUnit instanceof Feedbackable) || !(feedUnit2 instanceof Feedbackable) || ((Feedbackable) feedUnit).mo2890l() == null || ((Feedbackable) feedUnit2).mo2890l() == null) {
            return false;
        }
        return Objects.equal(GraphQlIdParserUtil.a(((Feedbackable) feedUnit).mo2890l().mo2933j()), GraphQlIdParserUtil.a(((Feedbackable) feedUnit2).mo2890l().mo2933j()));
    }

    public static String m11182a(String str, Clock clock) {
        return str + "_" + Long.toString(clock.mo211a() / 1000) + "_" + SafeUUIDGenerator.m2795a().toString();
    }
}
