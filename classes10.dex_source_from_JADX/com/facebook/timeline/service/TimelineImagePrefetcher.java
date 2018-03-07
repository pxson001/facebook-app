package com.facebook.timeline.service;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.List;

@ContextScoped
/* compiled from: extra_location_range */
public class TimelineImagePrefetcher {
    private static final CallerContext f12717a = CallerContext.a(TimelineImagePrefetcher.class);
    private static TimelineImagePrefetcher f12718e;
    private static final Object f12719f = new Object();
    private final ImagePipeline f12720b;
    private final TimelineHeaderImagesExtractor f12721c;
    private final TimelineProtilesImagesExtractor f12722d;

    private static TimelineImagePrefetcher m12672b(InjectorLike injectorLike) {
        return new TimelineImagePrefetcher(ImagePipelineMethodAutoProvider.a(injectorLike), TimelineHeaderImagesExtractor.m12658a(injectorLike), TimelineProtilesImagesExtractor.m12675a(injectorLike));
    }

    @Inject
    private TimelineImagePrefetcher(ImagePipeline imagePipeline, TimelineHeaderImagesExtractor timelineHeaderImagesExtractor, TimelineProtilesImagesExtractor timelineProtilesImagesExtractor) {
        this.f12720b = imagePipeline;
        this.f12721c = timelineHeaderImagesExtractor;
        this.f12722d = timelineProtilesImagesExtractor;
    }

    public final void m12674a(TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel, TimelineImagePrefetchDataSubscriber timelineImagePrefetchDataSubscriber) {
        m12671a(timelineImagePrefetchDataSubscriber, this.f12721c.m12662a(timelineHeaderUserFieldsModel));
    }

    public final void m12673a(ProtilesResult protilesResult, TimelineImagePrefetchDataSubscriber timelineImagePrefetchDataSubscriber) {
        m12671a(timelineImagePrefetchDataSubscriber, this.f12722d.m12678a(protilesResult));
    }

    private void m12671a(TimelineImagePrefetchDataSubscriber timelineImagePrefetchDataSubscriber, List<Uri> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            timelineImagePrefetchDataSubscriber.f12716c = size;
            if (size > 0) {
                timelineImagePrefetchDataSubscriber.f12714a.m12597a();
            }
            for (Uri a : list) {
                this.f12720b.f(ImageRequest.a(a), f12717a).a(timelineImagePrefetchDataSubscriber, DirectExecutor.INSTANCE);
            }
        }
    }

    public static TimelineImagePrefetcher m12670a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineImagePrefetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12719f) {
                TimelineImagePrefetcher timelineImagePrefetcher;
                if (a2 != null) {
                    timelineImagePrefetcher = (TimelineImagePrefetcher) a2.a(f12719f);
                } else {
                    timelineImagePrefetcher = f12718e;
                }
                if (timelineImagePrefetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12672b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12719f, b3);
                        } else {
                            f12718e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineImagePrefetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
