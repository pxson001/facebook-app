package com.facebook.search.results.rows.sections.newscontext;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.debug.log.BLog;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.rows.FooterButtonClickListenerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Page */
public class ShareTopicFooterPartDefinition<E extends CanFeedback & HasSearchResultsContext & HasFeedItemPosition> extends MultiRowSinglePartDefinition<SearchResultsNewsContextUnit, Void, E, DefaultFooterView> {
    private static ShareTopicFooterPartDefinition f24680f;
    private static final Object f24681g = new Object();
    private final Activity f24682a;
    private final ComposerLauncher f24683b;
    public final SearchResultsLogger f24684c;
    private final DefaultFooterBackgroundPartDefinition<DefaultFooterView> f24685d;
    private final FooterButtonClickListenerPartDefinition f24686e;

    private static ShareTopicFooterPartDefinition m28098b(InjectorLike injectorLike) {
        return new ShareTopicFooterPartDefinition((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ActivityMethodAutoProvider.b(injectorLike), SearchResultsLogger.m25460a(injectorLike), DefaultFooterBackgroundPartDefinition.a(injectorLike), FooterButtonClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m28100a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsNewsContextUnit searchResultsNewsContextUnit = (SearchResultsNewsContextUnit) obj;
        final CanFeedback canFeedback = (CanFeedback) anyEnvironment;
        final GraphQLNode graphQLNode = searchResultsNewsContextUnit.f23490a;
        subParts.a(this.f24686e, new ButtonClickedListener(this) {
            final /* synthetic */ ShareTopicFooterPartDefinition f24679d;

            public final void m28095a(View view, FooterButtonId footerButtonId) {
                if (footerButtonId == FooterButtonId.SHARE) {
                    SearchResultsLogger searchResultsLogger = this.f24679d.f24684c;
                    SearchResultsMutableContext s = ((HasSearchResultsContext) canFeedback).mo1248s();
                    String str = (String) searchResultsNewsContextUnit.mo1322l().orNull();
                    HoneyClientEvent b = SearchResultsLogger.m25459a(Event.ITEM_TAPPED, s).a("tapped_result_position", ((HasFeedItemPosition) canFeedback).mo1245a(Integer.valueOf(((HasFeedItemPosition) canFeedback).mo1245a(graphQLNode)))).a("results_module_role", GraphQLGraphSearchResultRole.NEWS_CONTEXT).a("action", StoryAction.SHARE).b("results_module_extra_logging", str);
                    searchResultsLogger.f21958c.a(b);
                    if (BLog.b(3)) {
                        String str2 = b.d;
                        b.u();
                    }
                    ShareTopicFooterPartDefinition.m28097a(this.f24679d, graphQLNode);
                }
            }
        });
        subParts.a(this.f24685d, new Props(false, false, true, FooterLevel.PAGE, null));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28101a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -91790246);
        ((DefaultFooterView) view).setButtons(ImmutableSet.of(FooterButtonId.SHARE));
        Logger.a(8, EntryType.MARK_POP, -863708411, a);
    }

    @Inject
    public ShareTopicFooterPartDefinition(ComposerLauncher composerLauncher, Activity activity, SearchResultsLogger searchResultsLogger, DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition, FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition) {
        this.f24683b = composerLauncher;
        this.f24682a = activity;
        this.f24684c = searchResultsLogger;
        this.f24685d = defaultFooterBackgroundPartDefinition;
        this.f24686e = footerButtonClickListenerPartDefinition;
    }

    public static ShareTopicFooterPartDefinition m28096a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareTopicFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24681g) {
                ShareTopicFooterPartDefinition shareTopicFooterPartDefinition;
                if (a2 != null) {
                    shareTopicFooterPartDefinition = (ShareTopicFooterPartDefinition) a2.a(f24681g);
                } else {
                    shareTopicFooterPartDefinition = f24680f;
                }
                if (shareTopicFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28098b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24681g, b3);
                        } else {
                            f24680f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = shareTopicFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m28099a() {
        return DefaultFooterView.a;
    }

    public final boolean m28102a(Object obj) {
        return true;
    }

    public static void m28097a(ShareTopicFooterPartDefinition shareTopicFooterPartDefinition, GraphQLNode graphQLNode) {
        shareTopicFooterPartDefinition.f24683b.a(null, ComposerConfigurationFactory.a(ComposerSourceType.SEARCH, Builder.a(graphQLNode.iR()).b()).setIsEditTagEnabled(false).setNectarModule("search_ufi").setDisableFriendTagging(true).setDisableMentions(true).a(), 1756, shareTopicFooterPartDefinition.f24682a);
    }
}
