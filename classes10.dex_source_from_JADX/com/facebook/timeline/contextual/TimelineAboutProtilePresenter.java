package com.facebook.timeline.contextual;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.contextual.TimelineContextListItemPresenter.TimelineContextItemData;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.ui.TimelineComponentViewType;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group_update_push_subscription_level */
public class TimelineAboutProtilePresenter extends TimelineContextListItemPresenter {
    private static TimelineAboutProtilePresenter f10308b;
    private static final Object f10309c = new Object();
    private final boolean f10310a;

    private static TimelineAboutProtilePresenter m10450c(InjectorLike injectorLike) {
        return new TimelineAboutProtilePresenter(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineAboutProtilePresenter(Boolean bool, ProfileControllerDelegate profileControllerDelegate) {
        super(profileControllerDelegate);
        this.f10310a = bool.booleanValue();
    }

    public final boolean mo502a(PlutoniumContextualItemView plutoniumContextualItemView, TimelineContextItemData timelineContextItemData) {
        if (timelineContextItemData.f10313a == null) {
            plutoniumContextualItemView.setVisibility(8);
            return false;
        } else if (this.f10310a && timelineContextItemData.f10313a.dr_() == GraphQLTimelineContextListItemType.FOLLOWER_COUNT) {
            plutoniumContextualItemView.setVisibility(8);
            return false;
        } else {
            int dimensionPixelSize;
            Uri uri;
            plutoniumContextualItemView.c = this;
            Resources resources = plutoniumContextualItemView.getResources();
            int dimensionPixelSize2 = plutoniumContextualItemView.getResources().getDimensionPixelSize(2131429858);
            if (timelineContextItemData.f10314b == TimelineComponentViewType.BEGIN) {
                dimensionPixelSize = resources.getDimensionPixelSize(2131429860);
            } else {
                dimensionPixelSize = resources.getDimensionPixelSize(2131429859);
            }
            int i = dimensionPixelSize;
            if (timelineContextItemData.f10314b == TimelineComponentViewType.END) {
                dimensionPixelSize = resources.getDimensionPixelSize(2131429861);
            } else {
                dimensionPixelSize = resources.getDimensionPixelSize(2131429859);
            }
            int i2 = dimensionPixelSize;
            plutoniumContextualItemView.setMinimumHeight((dimensionPixelSize2 + i) + i2);
            plutoniumContextualItemView.setThumbnailPadding(plutoniumContextualItemView.getPaddingLeft());
            plutoniumContextualItemView.setPadding(resources.getDimensionPixelSize(2131429862), i, plutoniumContextualItemView.getPaddingRight(), i2);
            TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = timelineContextItemData.f10313a;
            if (timelineContextListItemFieldsModel.b() == null || timelineContextListItemFieldsModel.b().b() == null) {
                uri = null;
            } else {
                uri = Uri.parse(timelineContextListItemFieldsModel.b().b());
            }
            plutoniumContextualItemView.a(dimensionPixelSize2, 0, 0, uri, "timeline");
            plutoniumContextualItemView.a(timelineContextItemData.f10313a.g() != null ? timelineContextItemData.f10313a.g().a() : null, 2, SizeUtil.c(resources, 2131427402));
            plutoniumContextualItemView.a(null, 0, 0);
            plutoniumContextualItemView.a(TimelineContextListItemPresenter.m10443a(timelineContextItemData.f10313a));
            plutoniumContextualItemView.n = false;
            plutoniumContextualItemView.a(TimelineContextListItemPresenter.m10445b(timelineContextItemData.f10313a), timelineContextItemData.f10313a);
            plutoniumContextualItemView.setId(2131560779);
            return true;
        }
    }

    public static TimelineAboutProtilePresenter m10449a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineAboutProtilePresenter c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10309c) {
                TimelineAboutProtilePresenter timelineAboutProtilePresenter;
                if (a2 != null) {
                    timelineAboutProtilePresenter = (TimelineAboutProtilePresenter) a2.a(f10309c);
                } else {
                    timelineAboutProtilePresenter = f10308b;
                }
                if (timelineAboutProtilePresenter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        c = m10450c(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10309c, c);
                        } else {
                            f10308b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = timelineAboutProtilePresenter;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
