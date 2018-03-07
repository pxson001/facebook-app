package com.facebook.widget.images;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.SettableDataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: reportPrivacyCheckupActions */
public class FirstAvailableImageUrisHelper {
    private static final Class<?> f5796a = FirstAvailableImageUrisHelper.class;
    public final ImagePipeline f5797b;

    public static FirstAvailableImageUrisHelper m8363b(InjectorLike injectorLike) {
        return new FirstAvailableImageUrisHelper(ImagePipelineMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FirstAvailableImageUrisHelper(ImagePipeline imagePipeline) {
        this.f5797b = imagePipeline;
    }

    public static void m8362a(FirstAvailableImageUrisHelper firstAvailableImageUrisHelper, Iterator it, SettableDataSource settableDataSource, CallerContext callerContext) {
        Preconditions.checkArgument(it.hasNext());
        final ImageRequest imageRequest = (ImageRequest) it.next();
        final SettableDataSource settableDataSource2 = settableDataSource;
        final Iterator it2 = it;
        final CallerContext callerContext2 = callerContext;
        firstAvailableImageUrisHelper.f5797b.c(imageRequest, callerContext).a(new BaseDataSubscriber<CloseableReference<CloseableImage>>(firstAvailableImageUrisHelper) {
            final /* synthetic */ FirstAvailableImageUrisHelper f5795e;

            public final void m8360e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                settableDataSource2.a(closeableReference);
                CloseableReference.c(closeableReference);
            }

            public final void m8361f(DataSource dataSource) {
                Throwable e = dataSource.e();
                if (it2.hasNext()) {
                    FirstAvailableImageUrisHelper.m8362a(this.f5795e, it2, settableDataSource2, callerContext2);
                } else {
                    settableDataSource2.b(e);
                }
            }
        }, MoreExecutors.a());
    }
}
