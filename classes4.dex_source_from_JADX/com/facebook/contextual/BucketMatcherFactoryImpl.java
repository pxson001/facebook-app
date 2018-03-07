package com.facebook.contextual;

import com.facebook.contextual.NumericComparisonBucketMatcher.ComparisonRule;
import java.util.List;

/* compiled from: speex_plc */
public class BucketMatcherFactoryImpl {
    public final BucketMatcher m2007a(String str, String str2, List<Double> list) {
        ComparisonRule comparisonRule = (ComparisonRule) NumericComparisonBucketMatcher.e.get(str2);
        if (comparisonRule != null) {
            return new NumericComparisonBucketMatcher(str, comparisonRule, list);
        }
        throw new ContextualConfigError("Unknown bucket definition");
    }
}
