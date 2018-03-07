package com.facebook.drawee.fbpipeline;

import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.C0093x5209d3a;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.AnimatedDrawableFactoryMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: msg_type */
public class DegradableDraweeControllerProvider extends AbstractAssistedProvider<DegradableDraweeController> {
    public final DegradableDraweeController m19481a(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier2, Uri uri, String str, FbDraweeCallerContext fbDraweeCallerContext) {
        return new DegradableDraweeController(ResourcesMethodAutoProvider.m6510a(this), DeferredReleaserMethodAutoProvider.m20759a(this), C0093x5209d3a.m2600a(this), AnimatedDrawableFactoryMethodAutoProvider.m20763a(this), DialtoneControllerImpl.m8272a((InjectorLike) this), AnalyticsLoggerMethodAutoProvider.m3509a(this), supplier, supplier2, uri, str, fbDraweeCallerContext, QeInternalImplMethodAutoProvider.m3744a(this));
    }
}
