package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.header.TimelineIntroCardAdapter.IntroCardBottomPaddingAndNuxBorderAdapter;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.ui.FeaturedHeaderAdapter;
import com.facebook.timeline.viewfeaturedcontainers.ui.FeaturedHeaderAdapterProvider;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_center_suggestions_tab_impression */
public class TimelineHeaderAdapterFactory {
    private static TimelineHeaderAdapterFactory f11334t;
    private static final Object f11335u = new Object();
    private final QeAccessor f11336a;
    private final FavPhotosVsFeaturedContainersController f11337b;
    private final TimelineHeaderMultiAdapterProvider f11338c;
    private final TimelineHeaderTopAdapterProvider f11339d;
    private final TimelineHeaderNavtilesAdapterProvider f11340e;
    private final TimelineHeaderFullHeaderAdapterProvider f11341f;
    private final TimelineIntroCardMultiAdapterProvider f11342g;
    private final TimelineIntroCardAdapterProvider f11343h;
    private final TimelineIntroCardExternalLinksAdapterProvider f11344i;
    private final TimelineBioNuxController f11345j;
    private final IntroCardCollapseController f11346k;
    private final FeaturedHeaderAdapterProvider f11347l;
    private TimelineUserContext f11348m;
    private TimelineHeaderUserData f11349n;
    private TimelineIntroCardAdapter f11350o;
    @Nullable
    private TimelineHeaderMultiAdapter f11351p;
    @Nullable
    private TimelineHeaderFullHeaderAdapter f11352q;
    @Nullable
    private TimelineIntroCardMultiAdapter f11353r;
    private FeaturedHeaderAdapter f11354s;

    private static TimelineHeaderAdapterFactory m11422b(InjectorLike injectorLike) {
        return new TimelineHeaderAdapterFactory((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FavPhotosVsFeaturedContainersController.m12774a(injectorLike), (TimelineHeaderMultiAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderMultiAdapterProvider.class), (TimelineHeaderTopAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderTopAdapterProvider.class), (TimelineHeaderNavtilesAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderNavtilesAdapterProvider.class), (TimelineHeaderFullHeaderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderFullHeaderAdapterProvider.class), (TimelineIntroCardMultiAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineIntroCardMultiAdapterProvider.class), (TimelineIntroCardAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineIntroCardAdapterProvider.class), (TimelineIntroCardExternalLinksAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineIntroCardExternalLinksAdapterProvider.class), TimelineBioNuxController.m11672a(injectorLike), IntroCardCollapseController.m11666a(injectorLike), (FeaturedHeaderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeaturedHeaderAdapterProvider.class));
    }

    public static TimelineHeaderAdapterFactory m11419a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderAdapterFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11335u) {
                TimelineHeaderAdapterFactory timelineHeaderAdapterFactory;
                if (a2 != null) {
                    timelineHeaderAdapterFactory = (TimelineHeaderAdapterFactory) a2.a(f11335u);
                } else {
                    timelineHeaderAdapterFactory = f11334t;
                }
                if (timelineHeaderAdapterFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11422b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11335u, b3);
                        } else {
                            f11334t = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderAdapterFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineHeaderAdapterFactory(QeAccessor qeAccessor, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, TimelineHeaderMultiAdapterProvider timelineHeaderMultiAdapterProvider, TimelineHeaderTopAdapterProvider timelineHeaderTopAdapterProvider, TimelineHeaderNavtilesAdapterProvider timelineHeaderNavtilesAdapterProvider, TimelineHeaderFullHeaderAdapterProvider timelineHeaderFullHeaderAdapterProvider, TimelineIntroCardMultiAdapterProvider timelineIntroCardMultiAdapterProvider, TimelineIntroCardAdapterProvider timelineIntroCardAdapterProvider, TimelineIntroCardExternalLinksAdapterProvider timelineIntroCardExternalLinksAdapterProvider, TimelineBioNuxController timelineBioNuxController, IntroCardCollapseController introCardCollapseController, FeaturedHeaderAdapterProvider featuredHeaderAdapterProvider) {
        this.f11336a = qeAccessor;
        this.f11337b = favPhotosVsFeaturedContainersController;
        this.f11338c = timelineHeaderMultiAdapterProvider;
        this.f11339d = timelineHeaderTopAdapterProvider;
        this.f11340e = timelineHeaderNavtilesAdapterProvider;
        this.f11341f = timelineHeaderFullHeaderAdapterProvider;
        this.f11342g = timelineIntroCardMultiAdapterProvider;
        this.f11343h = timelineIntroCardAdapterProvider;
        this.f11344i = timelineIntroCardExternalLinksAdapterProvider;
        this.f11345j = timelineBioNuxController;
        this.f11346k = introCardCollapseController;
        this.f11347l = featuredHeaderAdapterProvider;
    }

    public final TimelineHeaderMultiAdapter m11423a(Context context, TimelineUserContext timelineUserContext, TimelineContextualInfoData timelineContextualInfoData, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineHeaderDataLogger timelineHeaderDataLogger, Boolean bool, boolean z) {
        this.f11348m = timelineUserContext;
        this.f11349n = timelineHeaderUserData;
        TimelineHeaderTopAdapter a = this.f11339d.m11482a(context, timelineUserContext, timelineHeaderUserData, z);
        this.f11352q = this.f11341f.m11450a(context, timelineUserContext, timelineHeaderUserData, timelineContextualInfoData, timelineTaggedMediaSetData, timelineHeaderDataLogger, bool);
        TimelineHeaderNavtilesAdapter a2 = this.f11340e.m11458a(context, timelineUserContext, timelineHeaderUserData);
        List arrayList = new ArrayList();
        arrayList.add(a);
        if (m11421a()) {
            arrayList.add(a2);
        }
        arrayList.add(this.f11352q);
        arrayList.add(m11420a(context, timelineHeaderUserData, timelineTaggedMediaSetData, timelineUserContext, z, timelineHeaderDataLogger));
        if (!m11421a()) {
            arrayList.add(a2);
        }
        this.f11351p = TimelineHeaderMultiAdapterProvider.m11452a(timelineHeaderUserData, a, arrayList);
        return this.f11351p;
    }

    private TimelineIntroCardMultiAdapter m11420a(Context context, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineUserContext timelineUserContext, boolean z, TimelineHeaderDataLogger timelineHeaderDataLogger) {
        this.f11350o = this.f11343h.m11510a(context, timelineHeaderUserData, timelineTaggedMediaSetData, timelineUserContext, z, timelineHeaderDataLogger);
        List arrayList = new ArrayList();
        arrayList.add(this.f11350o);
        if (this.f11337b.m12778c()) {
            this.f11354s = this.f11347l.m12886a(context, timelineHeaderUserData, timelineUserContext, z);
            arrayList.add(this.f11354s);
        }
        arrayList.add(this.f11344i.m11535a(context, timelineHeaderUserData, timelineUserContext, z));
        arrayList.add(new IntroCardBottomPaddingAndNuxBorderAdapter(this.f11350o));
        this.f11353r = this.f11342g.m11537a(arrayList, timelineHeaderDataLogger, timelineHeaderUserData, timelineUserContext);
        this.f11350o.f11472t = this.f11353r;
        return this.f11353r;
    }

    private boolean m11421a() {
        return this.f11336a.a(ExperimentsForTimelineAbTestModule.H, false);
    }
}
