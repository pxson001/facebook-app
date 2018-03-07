package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLTimelineAppCollection;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.CharMatcher;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bundle_profile_model */
public class SavedCollectionFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLSavedCollectionFeedUnit, Void, HasPositionInformation, OneButtonFooterView> {
    private static SavedCollectionFooterPartDefinition f9275h;
    private static final Object f9276i = new Object();
    public final AnalyticsLogger f9277a;
    public final SaveButtonUtils f9278b;
    public final FbUriIntentHandler f9279c;
    private final NewsFeedAnalyticsEventBuilder f9280d;
    private final OneButtonFooterStylerPartDefinition f9281e;
    private final ClickListenerPartDefinition f9282f;
    private final TextPartDefinition f9283g;

    private static SavedCollectionFooterPartDefinition m9906b(InjectorLike injectorLike) {
        return new SavedCollectionFooterPartDefinition(AnalyticsLoggerMethodAutoProvider.a(injectorLike), SaveButtonUtils.a(injectorLike), FbUriIntentHandler.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m9908a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) obj;
        subParts.a(this.f9281e, null);
        subParts.a(2131559974, this.f9283g, graphQLSavedCollectionFeedUnit.r().a);
        subParts.a(this.f9282f, new OnClickListener(this) {
            final /* synthetic */ SavedCollectionFooterPartDefinition f9274b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -954469986);
                SavedCollectionFooterPartDefinition savedCollectionFooterPartDefinition = this.f9274b;
                GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = graphQLSavedCollectionFeedUnit;
                savedCollectionFooterPartDefinition.f9277a.a(NewsFeedAnalyticsEventBuilder.b(VisibleItemHelper.c(graphQLSavedCollectionFeedUnit), graphQLSavedCollectionFeedUnit.y() == null ? null : graphQLSavedCollectionFeedUnit.y().b(), "saved_collection_ego_action_link_clicked"));
                GraphQLTimelineAppCollection y = graphQLSavedCollectionFeedUnit.y();
                if (!CharMatcher.anyOf("/").trimFrom(Uri.parse(graphQLSavedCollectionFeedUnit.r().b).getPath()).equals("saved") || y == null) {
                    this.f9274b.f9279c.a(view.getContext(), graphQLSavedCollectionFeedUnit.r().b);
                } else {
                    GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType = null;
                    if (y.t() != null) {
                        graphQLSavedDashboardSectionType = y.t().a();
                    }
                    this.f9274b.f9278b.a(view.getContext(), graphQLSavedDashboardSectionType, y.x(), Referer.MOBILE_NETEGO_SEE_ALL_LINK);
                }
                LogUtils.a(-1742547988, a);
            }
        });
        return null;
    }

    @Inject
    public SavedCollectionFooterPartDefinition(AnalyticsLogger analyticsLogger, SaveButtonUtils saveButtonUtils, FbUriIntentHandler fbUriIntentHandler, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition) {
        this.f9278b = saveButtonUtils;
        this.f9279c = fbUriIntentHandler;
        this.f9277a = analyticsLogger;
        this.f9280d = newsFeedAnalyticsEventBuilder;
        this.f9281e = oneButtonFooterStylerPartDefinition;
        this.f9282f = clickListenerPartDefinition;
        this.f9283g = textPartDefinition;
    }

    public static SavedCollectionFooterPartDefinition m9905a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9276i) {
                SavedCollectionFooterPartDefinition savedCollectionFooterPartDefinition;
                if (a2 != null) {
                    savedCollectionFooterPartDefinition = (SavedCollectionFooterPartDefinition) a2.a(f9276i);
                } else {
                    savedCollectionFooterPartDefinition = f9275h;
                }
                if (savedCollectionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9906b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9276i, b3);
                        } else {
                            f9275h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9907a() {
        return OneButtonFooterView.a;
    }

    public final boolean m9909a(Object obj) {
        return true;
    }
}
