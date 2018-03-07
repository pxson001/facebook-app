package com.facebook.omnistore;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

@DoNotStrip
/* compiled from: mAnimations */
public class IndexQuery extends Countable {

    @DoNotStrip
    /* compiled from: mAnimations */
    public enum QueryOperator {
        LESS_THAN,
        LESS_THAN_EQUAL_TO,
        EQUAL_TO,
        NOT_EQUAL,
        GREATER_THAN,
        GREATER_THAN_EQUAL_TO,
        GLOB
    }

    public static native IndexQuery and(List<IndexQuery> list);

    public static native IndexQuery or(List<IndexQuery> list);

    public static native IndexQuery predicate(String str, QueryOperator queryOperator, String str2);

    static {
        Prerequisites.ensure();
    }
}
