package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.util.FqlQueryBuilderUtils;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: titlebar_back_pressed */
public abstract class FqlGeneratedQuery extends FqlQuery {
    private static final FqlQueryBuilderUtils f1200k = new FqlQueryBuilderUtils();

    public FqlGeneratedQuery(Context context, @Nullable Intent intent, String str, @Nullable ServiceOperationListener serviceOperationListener, String str2, String str3, Class cls) {
        this(context, intent, str, serviceOperationListener, str2, str3, m1227a(cls));
    }

    private FqlGeneratedQuery(Context context, @Nullable Intent intent, String str, @Nullable ServiceOperationListener serviceOperationListener, String str2, String str3, Set<String> set) {
        FqlQueryBuilderUtils fqlQueryBuilderUtils = new FqlQueryBuilderUtils();
        super(context, intent, str, FqlQueryBuilderUtils.a(str2, str3, set), serviceOperationListener);
    }

    private static Set<String> m1227a(Class cls) {
        return f1200k.a(cls);
    }
}
