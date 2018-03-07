package com.facebook.timeline.contextual;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
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
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group_mediaset_page_size */
public class TimelineIntroCardAboutItemsPresenter extends TimelineContextListItemPresenter {
    private static TimelineIntroCardAboutItemsPresenter f10339c;
    private static final Object f10340d = new Object();
    private final boolean f10341a;
    private final int f10342b;

    private static TimelineIntroCardAboutItemsPresenter m10473c(InjectorLike injectorLike) {
        return new TimelineIntroCardAboutItemsPresenter(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public TimelineIntroCardAboutItemsPresenter(Boolean bool, ProfileControllerDelegate profileControllerDelegate, Context context) {
        super(profileControllerDelegate);
        this.f10341a = bool.booleanValue();
        this.f10342b = ContextCompat.b(context, 2131361936);
    }

    public final boolean mo502a(PlutoniumContextualItemView plutoniumContextualItemView, TimelineContextItemData timelineContextItemData) {
        if (timelineContextItemData.f10313a == null) {
            plutoniumContextualItemView.setVisibility(8);
            return false;
        } else if (this.f10341a && timelineContextItemData.f10313a.dr_() == GraphQLTimelineContextListItemType.FOLLOWER_COUNT) {
            plutoniumContextualItemView.setVisibility(8);
            return false;
        } else {
            Uri uri;
            plutoniumContextualItemView.c = this;
            Resources resources = plutoniumContextualItemView.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(2131429858);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(2131429940);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(2131429940);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(2131429931);
            plutoniumContextualItemView.setMinimumHeight((dimensionPixelSize + dimensionPixelSize2) + dimensionPixelSize3);
            plutoniumContextualItemView.setThumbnailPadding(resources.getDimensionPixelSize(2131429939));
            plutoniumContextualItemView.setPadding(dimensionPixelSize4, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3);
            TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = timelineContextItemData.f10313a;
            if (timelineContextListItemFieldsModel == null || timelineContextListItemFieldsModel.b() == null || timelineContextListItemFieldsModel.b().b() == null) {
                uri = null;
            } else {
                uri = Uri.parse(timelineContextListItemFieldsModel.b().b());
            }
            plutoniumContextualItemView.a(dimensionPixelSize, 0, 0, uri, "timeline");
            plutoniumContextualItemView.a(this.f10342b, timelineContextItemData.f10313a.g() != null ? timelineContextItemData.f10313a.g().a() : null, 2, SizeUtil.c(resources, 2131427402));
            plutoniumContextualItemView.a(null, 0, 0);
            plutoniumContextualItemView.n = false;
            plutoniumContextualItemView.a(TimelineContextListItemPresenter.m10445b(timelineContextItemData.f10313a), timelineContextItemData.f10313a);
            return true;
        }
    }

    public static TimelineIntroCardAboutItemsPresenter m10472a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineIntroCardAboutItemsPresenter c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10340d) {
                TimelineIntroCardAboutItemsPresenter timelineIntroCardAboutItemsPresenter;
                if (a2 != null) {
                    timelineIntroCardAboutItemsPresenter = (TimelineIntroCardAboutItemsPresenter) a2.a(f10340d);
                } else {
                    timelineIntroCardAboutItemsPresenter = f10339c;
                }
                if (timelineIntroCardAboutItemsPresenter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        c = m10473c(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10340d, c);
                        } else {
                            f10339c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = timelineIntroCardAboutItemsPresenter;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
