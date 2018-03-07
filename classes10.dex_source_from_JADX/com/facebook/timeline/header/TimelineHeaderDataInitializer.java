package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.minipreview.MiniPreviewCoverPhotoProcessor;
import com.facebook.timeline.header.coverphoto.TimelineCoverPhotoLoggingHelper;
import com.facebook.timeline.header.data.TimelineHeaderCoverPhotoData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.intent.ModelBundleGraphQLModels.ModelBundleExtendedGraphQLModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderCoverPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderCoverPhotoFieldsModel.Builder;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: friends_center_outgoing_impression */
public class TimelineHeaderDataInitializer {
    private static TimelineHeaderDataInitializer f11360e;
    private static final Object f11361f = new Object();
    private final Context f11362a;
    private final Provider<GraphQLActorCache> f11363b;
    private final Provider<TimelineCoverPhotoLoggingHelper> f11364c;
    private final Provider<MiniPreviewCoverPhotoProcessor> f11365d;

    private static TimelineHeaderDataInitializer m11428b(InjectorLike injectorLike) {
        return new TimelineHeaderDataInitializer((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 262), IdBasedProvider.a(injectorLike, 11266), IdBasedSingletonScopeProvider.a(injectorLike, 8617));
    }

    @Inject
    public TimelineHeaderDataInitializer(Context context, Provider<GraphQLActorCache> provider, Provider<TimelineCoverPhotoLoggingHelper> provider2, Provider<MiniPreviewCoverPhotoProcessor> provider3) {
        this.f11362a = context;
        this.f11363b = provider;
        this.f11364c = provider2;
        this.f11365d = provider3;
    }

    public final void m11430a(@Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL, TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData) {
        if (modelBundleProfileGraphQL != null) {
            TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel = null;
            if (modelBundleProfileGraphQL instanceof ModelBundleExtendedGraphQLModel) {
                timelineHeaderFocusedCoverPhotoFieldsModel = ((ModelBundleExtendedGraphQLModel) modelBundleProfileGraphQL).b();
            }
            timelineHeaderUserData.a(Long.toString(timelineContext.b), modelBundleProfileGraphQL.C_(), modelBundleProfileGraphQL.dB_(), timelineHeaderFocusedCoverPhotoFieldsModel, modelBundleProfileGraphQL.d());
        } else if (timelineContext.i()) {
            GraphQLActor a = ((GraphQLActorCacheImpl) this.f11363b.get()).a();
            if (a != null) {
                TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel2;
                String l = Long.toString(timelineContext.b);
                String aa = a.aa();
                DefaultImageFieldsModel a2 = DefaultGraphQLConversionHelper.a(a.ai());
                GraphQLFocusedPhoto x = a.x();
                if (x == null) {
                    timelineHeaderFocusedCoverPhotoFieldsModel2 = null;
                } else {
                    TimelineHeaderCoverPhotoFieldsModel timelineHeaderCoverPhotoFieldsModel;
                    if (x == null || x.j() == null) {
                        timelineHeaderCoverPhotoFieldsModel = null;
                    } else {
                        Builder builder = new Builder();
                        builder.d = DefaultGraphQLConversionHelper.a(x.j().P());
                        timelineHeaderCoverPhotoFieldsModel = builder.a();
                    }
                    TimelineHeaderCoverPhotoFieldsModel timelineHeaderCoverPhotoFieldsModel2 = timelineHeaderCoverPhotoFieldsModel;
                    TimelineHeaderFocusedCoverPhotoFieldsModel.Builder builder2 = new TimelineHeaderFocusedCoverPhotoFieldsModel.Builder();
                    builder2.b = timelineHeaderCoverPhotoFieldsModel2;
                    GraphQLVect2 a3 = x.a();
                    if (a3 != null) {
                        builder2.a = DefaultGraphQLConversionHelper.a(a3);
                    }
                    timelineHeaderFocusedCoverPhotoFieldsModel2 = builder2.a();
                }
                timelineHeaderUserData.a(l, aa, a2, timelineHeaderFocusedCoverPhotoFieldsModel2, a.E());
            }
        }
        m11429a(timelineHeaderUserData, timelineHeaderUserData.P());
    }

    public static TimelineHeaderDataInitializer m11427a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderDataInitializer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11361f) {
                TimelineHeaderDataInitializer timelineHeaderDataInitializer;
                if (a2 != null) {
                    timelineHeaderDataInitializer = (TimelineHeaderDataInitializer) a2.a(f11361f);
                } else {
                    timelineHeaderDataInitializer = f11360e;
                }
                if (timelineHeaderDataInitializer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11428b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11361f, b3);
                        } else {
                            f11360e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderDataInitializer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m11429a(TimelineHeaderUserData timelineHeaderUserData, TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel) {
        Object obj;
        TimelineHeaderCoverPhotoData timelineHeaderCoverPhotoData = timelineHeaderUserData.g;
        if (!TimelineHeaderViewHelper.b(timelineHeaderFocusedCoverPhotoFieldsModel) || timelineHeaderFocusedCoverPhotoFieldsModel.b().g().equals(timelineHeaderCoverPhotoData.b)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            ((TimelineCoverPhotoLoggingHelper) this.f11364c.get()).m11733a();
            String g = timelineHeaderFocusedCoverPhotoFieldsModel.b().g();
            ListenableFuture a = ((MiniPreviewCoverPhotoProcessor) this.f11365d.get()).a(timelineHeaderFocusedCoverPhotoFieldsModel.b().g(), TimelineHeaderViewHelper.a(this.f11362a));
            timelineHeaderCoverPhotoData = timelineHeaderUserData.g;
            timelineHeaderCoverPhotoData.b = g;
            timelineHeaderCoverPhotoData.c = a;
        }
    }
}
