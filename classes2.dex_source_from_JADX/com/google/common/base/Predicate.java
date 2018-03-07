package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: work_android_in_app_browser */
public interface Predicate<T> {
    boolean apply(@Nullable T t);

    boolean equals(@Nullable Object obj);
}
