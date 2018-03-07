package com.facebook.timeline.contextual;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.ui.TimelineComponentViewType;
import com.facebook.uicontrib.contextitem.ContextualItemPresenter;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group_update_request_to_join_subscription_level */
public class TimelineContextListItemPresenter implements ContextualItemPresenter<TimelineContextItemData> {
    private static TimelineContextListItemPresenter f10305b;
    private static final Object f10306c = new Object();
    private final ProfileControllerDelegate f10307a;

    /* compiled from: group_update_request_to_join_subscription_level */
    public class TimelineContextItemData {
        public final TimelineContextListItemFieldsModel f10313a;
        public final TimelineComponentViewType f10314b;

        public TimelineContextItemData(TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, TimelineComponentViewType timelineComponentViewType) {
            this.f10313a = timelineContextListItemFieldsModel;
            this.f10314b = timelineComponentViewType;
        }
    }

    private static TimelineContextListItemPresenter m10442a(InjectorLike injectorLike) {
        return new TimelineContextListItemPresenter(ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineContextListItemPresenter(ProfileControllerDelegate profileControllerDelegate) {
        this.f10307a = profileControllerDelegate;
    }

    public boolean mo502a(PlutoniumContextualItemView plutoniumContextualItemView, TimelineContextItemData timelineContextItemData) {
        if (timelineContextItemData.f10313a == null) {
            plutoniumContextualItemView.setVisibility(8);
            return false;
        }
        Uri uri;
        plutoniumContextualItemView.c = this;
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = plutoniumContextualItemView.getResources().getDimensionPixelSize(2131430084);
        plutoniumContextualItemView.setMinimumHeight((resources.getDimensionPixelSize(2131427497) * 2) + dimensionPixelSize);
        TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = timelineContextItemData.f10313a;
        int i = 0;
        if (timelineContextListItemFieldsModel.b() != null) {
            i = Math.max(0, (dimensionPixelSize - timelineContextListItemFieldsModel.b().c()) / 2);
        }
        int i2 = i;
        timelineContextListItemFieldsModel = timelineContextItemData.f10313a;
        i = 0;
        if (timelineContextListItemFieldsModel.b() != null) {
            i = Math.max(0, (dimensionPixelSize - timelineContextListItemFieldsModel.b().a()) / 2);
        }
        int i3 = i;
        timelineContextListItemFieldsModel = timelineContextItemData.f10313a;
        if (timelineContextListItemFieldsModel.b() == null || timelineContextListItemFieldsModel.b().b() == null) {
            uri = null;
        } else {
            uri = Uri.parse(timelineContextListItemFieldsModel.b().b());
        }
        plutoniumContextualItemView.a(dimensionPixelSize, i2, i3, uri, "timeline");
        plutoniumContextualItemView.a(timelineContextItemData.f10313a.g() != null ? timelineContextItemData.f10313a.g().a() : null, 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(m10443a(timelineContextItemData.f10313a));
        TimelineComponentViewType timelineComponentViewType = timelineContextItemData.f10314b;
        if (timelineComponentViewType == TimelineComponentViewType.BEGIN || timelineComponentViewType == TimelineComponentViewType.MIDDLE) {
            i = plutoniumContextualItemView.getResources().getDimensionPixelSize(2131430083);
        } else {
            i = 0;
        }
        plutoniumContextualItemView.m = i;
        plutoniumContextualItemView.n = true;
        plutoniumContextualItemView.a(m10445b(timelineContextItemData.f10313a), timelineContextItemData.f10313a);
        plutoniumContextualItemView.setId(2131560779);
        return true;
    }

    public static TimelineContextListItemPresenter m10444b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineContextListItemPresenter a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f10306c) {
                TimelineContextListItemPresenter timelineContextListItemPresenter;
                if (a3 != null) {
                    timelineContextListItemPresenter = (TimelineContextListItemPresenter) a3.a(f10306c);
                } else {
                    timelineContextListItemPresenter = f10305b;
                }
                if (timelineContextListItemPresenter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        a2 = m10442a(injectorThreadStack.e());
                        if (a3 != null) {
                            a3.a(f10306c, a2);
                        } else {
                            f10305b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = timelineContextListItemPresenter;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    public final void m10446a(PlutoniumContextualItemView plutoniumContextualItemView) {
    }

    public final void m10448b(PlutoniumContextualItemView plutoniumContextualItemView) {
        Object tag = plutoniumContextualItemView.getTag();
        if (tag instanceof TimelineContextListItemFieldsModel) {
            this.f10307a.mo482r().mo504a((TimelineContextListItemFieldsModel) tag, false);
        }
    }

    @Nullable
    protected static Integer m10443a(TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        if (timelineContextListItemFieldsModel.a() == null) {
            return null;
        }
        return Integer.valueOf(timelineContextListItemFieldsModel.a().a());
    }

    protected static boolean m10445b(TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        boolean z;
        boolean z2;
        boolean z3 = timelineContextListItemFieldsModel.ds_() != null;
        if (timelineContextListItemFieldsModel.c() == null || timelineContextListItemFieldsModel.c().b() == null || 2479791 != timelineContextListItemFieldsModel.c().b().g()) {
            z = false;
        } else {
            z = true;
        }
        if (GraphQLTimelineContextListTargetType.COMPOSER.equals(timelineContextListItemFieldsModel.d()) || GraphQLTimelineContextListTargetType.MESSAGE.equals(timelineContextListItemFieldsModel.d())) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z3 || z || z2;
    }
}
