package com.facebook.graphql.cursor;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;

/* compiled from: messenger_wear/ */
public class ModelCursorLoaderProvider extends AbstractAssistedProvider<ModelCursorLoader> {
    public final ModelCursorLoader m8191a(String str) {
        return new ModelCursorLoader(str, GraphCursorDatabase.m8126a((InjectorLike) this), QuickPerformanceLoggerMethodAutoProvider.a(this), CursorModelCache.m8182a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
