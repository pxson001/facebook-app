package com.facebook.contextual;

import com.google.common.collect.ImmutableMap;
import java.util.List;

/* compiled from: outgoingMessageLifetime */
public class NumericComparisonBucketMatcher {
    public static final ImmutableMap<String, ComparisonRule> f8531e = ImmutableMap.builder().b("lt", ComparisonRule.LT).b("lte", ComparisonRule.LTE).b("between", ComparisonRule.BETWEEN).b("equal", ComparisonRule.EQ).b("neq", ComparisonRule.NEQ).b("gt", ComparisonRule.GT).b("gte", ComparisonRule.GTE).b();
    public String f8532a;
    public ComparisonRule f8533b;
    public double f8534c;
    public double f8535d;

    /* compiled from: outgoingMessageLifetime */
    public /* synthetic */ class C05591 {
        public static final /* synthetic */ int[] f8530a = new int[ComparisonRule.values().length];

        static {
            try {
                f8530a[ComparisonRule.LT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8530a[ComparisonRule.LTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8530a[ComparisonRule.BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8530a[ComparisonRule.EQ.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8530a[ComparisonRule.NEQ.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8530a[ComparisonRule.GT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8530a[ComparisonRule.GTE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: outgoingMessageLifetime */
    public enum ComparisonRule {
        LT,
        LTE,
        BETWEEN,
        EQ,
        NEQ,
        GT,
        GTE
    }

    public NumericComparisonBucketMatcher(String str, ComparisonRule comparisonRule, List<Double> list) {
        this.f8532a = str;
        this.f8533b = comparisonRule;
        if (this.f8533b == ComparisonRule.BETWEEN) {
            if (list.size() != 2) {
                throw new ContextualConfigError("Mismatching number of values");
            }
            this.f8534c = ((Double) list.get(0)).doubleValue();
            this.f8535d = ((Double) list.get(1)).doubleValue();
            if (this.f8534c >= this.f8535d) {
                throw new ContextualConfigError("Bad values order");
            }
        } else if (list.size() != 1) {
            throw new ContextualConfigError("Mismatching number of values");
        } else {
            this.f8534c = ((Double) list.get(0)).doubleValue();
        }
    }
}
