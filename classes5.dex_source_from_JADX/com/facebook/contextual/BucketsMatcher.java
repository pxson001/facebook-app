package com.facebook.contextual;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.contextual.NumericComparisonBucketMatcher.1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: active_team_with_ball */
public class BucketsMatcher {
    public List<BucketMatcher> f11599a = new ArrayList();

    public final String m19727a(double d) {
        for (NumericComparisonBucketMatcher numericComparisonBucketMatcher : this.f11599a) {
            Object obj = 1;
            switch (1.a[numericComparisonBucketMatcher.b.ordinal()]) {
                case 1:
                    if (d >= numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (d > numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                case 3:
                    if (d < numericComparisonBucketMatcher.c || d >= numericComparisonBucketMatcher.d) {
                        obj = null;
                        break;
                    }
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    if (d != numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                case 5:
                    if (d == numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                case 6:
                    if (d <= numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                case 7:
                    if (d < numericComparisonBucketMatcher.c) {
                        obj = null;
                        break;
                    }
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                return numericComparisonBucketMatcher.a;
            }
        }
        return null;
    }
}
