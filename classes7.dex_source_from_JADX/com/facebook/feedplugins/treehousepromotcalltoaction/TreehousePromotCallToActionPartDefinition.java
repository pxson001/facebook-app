package com.facebook.feedplugins.treehousepromotcalltoaction;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition$Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SHORT */
public class TreehousePromotCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static TreehousePromotCallToActionPartDefinition f23830f;
    private static final Object f23831g = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f23832a;
    public final Context f23833b;
    public final TreehousePromotCallToActionLogger f23834c;
    public final AppsInstallHelper f23835d;
    private final GlyphColorizer f23836e;

    private static TreehousePromotCallToActionPartDefinition m25980b(InjectorLike injectorLike) {
        return new TreehousePromotCallToActionPartDefinition(IdBasedLazy.a(injectorLike, 1837), (Context) injectorLike.getInstance(Context.class), new TreehousePromotCallToActionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class), GlyphColorizer.a(injectorLike));
    }

    public final Object m25983a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        final String b = m25981b((FeedEnvironment) anyEnvironment);
        final String aE = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)).aE();
        subParts.a((SinglePartDefinition) this.f23832a.get(), ActionLinkCallToActionPartDefinition$Props.m25512a(feedProps, null, new OnClickListener(this) {
            final /* synthetic */ TreehousePromotCallToActionPartDefinition f23829c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 146225095);
                this.f23829c.f23835d.a(aE, this.f23829c.f23833b);
                TreehousePromotCallToActionLogger treehousePromotCallToActionLogger = this.f23829c.f23834c;
                String str = b;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("android_media_story_groups_app_promo_call_to_action");
                honeyClientEvent.b("event_type", "click");
                honeyClientEvent.b("feed_name", str);
                honeyClientEvent.b("promotion_tag", "groups_app_promotion_cta");
                treehousePromotCallToActionLogger.f23826a.a(honeyClientEvent);
                Logger.a(2, EntryType.UI_INPUT_END, 1297974089, a);
            }
        }, null, this.f23836e.a(2130839682, -10972929)));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25984a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 325000571);
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        TreehousePromotCallToActionLogger treehousePromotCallToActionLogger = this.f23834c;
        String b = m25981b(feedEnvironment);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("android_media_story_groups_app_promo_call_to_action");
        honeyClientEvent.b("event_type", "impression");
        honeyClientEvent.b("feed_name", b);
        honeyClientEvent.b("promotion_tag", "groups_app_promotion_cta");
        treehousePromotCallToActionLogger.f23826a.a(honeyClientEvent);
        Logger.a(8, EntryType.MARK_POP, 1847500617, a);
    }

    public final boolean m25985a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (graphQLStory == null || StoryActorHelper.b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.a(graphQLStory) || StoryAttachmentHelper.o(graphQLStory) == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
        if (a == null || a.a() == null || a.a().g() != 1222095750) {
            return false;
        }
        if (!this.f23835d.a() || a.b()) {
            return true;
        }
        return false;
    }

    @Inject
    public TreehousePromotCallToActionPartDefinition(Lazy<ActionLinkCallToActionPartDefinition> lazy, Context context, TreehousePromotCallToActionLogger treehousePromotCallToActionLogger, AppsInstallHelperProvider appsInstallHelperProvider, GlyphColorizer glyphColorizer) {
        this.f23832a = lazy;
        this.f23833b = context;
        this.f23834c = treehousePromotCallToActionLogger;
        this.f23835d = appsInstallHelperProvider.a(new TreehouseInstallInfo());
        this.f23836e = glyphColorizer;
    }

    public static TreehousePromotCallToActionPartDefinition m25979a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TreehousePromotCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23831g) {
                TreehousePromotCallToActionPartDefinition treehousePromotCallToActionPartDefinition;
                if (a2 != null) {
                    treehousePromotCallToActionPartDefinition = (TreehousePromotCallToActionPartDefinition) a2.a(f23831g);
                } else {
                    treehousePromotCallToActionPartDefinition = f23830f;
                }
                if (treehousePromotCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25980b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23831g, b3);
                        } else {
                            f23830f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = treehousePromotCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ActionLinkCallToActionView> m25982a() {
        return ActionLinkCallToActionView.f23054h;
    }

    public static <E extends FeedEnvironment> String m25981b(E e) {
        if (e == null || e.c() == null || e.c().a() == null) {
            return null;
        }
        return e.c().a().toString();
    }
}
