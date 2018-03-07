package com.facebook.feedplugins.momentscalltoaction;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STICKER_PICKER_SELECTED_STICKER */
public class MomentsCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static MomentsCallToActionPartDefinition f23542f;
    private static final Object f23543g = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f23544a;
    public final AppsInstallHelper f23545b;
    public final Context f23546c;
    public final MomentsCallToActionImpressionHelper f23547d;
    public final MomentsCallToActionLogger f23548e;

    private static MomentsCallToActionPartDefinition m25788b(InjectorLike injectorLike) {
        return new MomentsCallToActionPartDefinition(IdBasedLazy.a(injectorLike, 1837), (Context) injectorLike.getInstance(Context.class), MomentsCallToActionImpressionHelper.m25773a(injectorLike), new MomentsCallToActionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class));
    }

    public final Object m25792a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        final String a = m25787a((FeedEnvironment) anyEnvironment);
        final String d = m25790d(graphQLStory);
        subParts.a((SinglePartDefinition) this.f23544a.get(), ActionLinkCallToActionPartDefinition$Props.m25512a(feedProps, null, new OnClickListener(this) {
            final /* synthetic */ MomentsCallToActionPartDefinition f23541c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1742929682);
                MomentsCallToActionLogger momentsCallToActionLogger = this.f23541c.f23548e;
                String str = a;
                String str2 = d;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_app_photo_overlay_call_to_action");
                honeyClientEvent.b("event_type", "click");
                honeyClientEvent.b("feed_name", str);
                if (str2 != null) {
                    honeyClientEvent.b("promotion_tag", str2);
                }
                momentsCallToActionLogger.f23538a.a(honeyClientEvent);
                AppsInstallHelper appsInstallHelper = this.f23541c.f23545b;
                Context context = this.f23541c.f23546c;
                if (appsInstallHelper.a()) {
                    this.f23541c.f23545b.b("moments://", this.f23541c.f23546c);
                } else {
                    this.f23541c.f23545b.a(this.f23541c.f23546c);
                }
                LogUtils.a(-1737548811, a);
            }
        }, null, this.f23546c.getResources().getDrawable(2130841257)));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25793a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -137906219);
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        this.f23547d.m25785b(graphQLStory);
        MomentsCallToActionLogger momentsCallToActionLogger = this.f23548e;
        String a2 = m25787a(feedEnvironment);
        String d = m25790d(graphQLStory);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_app_photo_overlay_call_to_action");
        honeyClientEvent.b("event_type", "impression");
        honeyClientEvent.b("feed_name", a2);
        if (d != null) {
            honeyClientEvent.b("promotion_tag", d);
        }
        momentsCallToActionLogger.f23538a.a(honeyClientEvent);
        Logger.a(8, EntryType.MARK_POP, -1901556486, a);
    }

    public final boolean m25794a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (!m25789c(graphQLStory)) {
            return false;
        }
        if (!this.f23545b.a() || ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)).b()) {
            return this.f23547d.m25784a(graphQLStory);
        }
        return false;
    }

    @Inject
    public MomentsCallToActionPartDefinition(Lazy<ActionLinkCallToActionPartDefinition> lazy, Context context, MomentsCallToActionImpressionHelper momentsCallToActionImpressionHelper, MomentsCallToActionLogger momentsCallToActionLogger, AppsInstallHelperProvider appsInstallHelperProvider) {
        this.f23544a = lazy;
        this.f23545b = appsInstallHelperProvider.a(new MomentsInstallInfo());
        this.f23546c = context;
        this.f23547d = momentsCallToActionImpressionHelper;
        this.f23548e = momentsCallToActionLogger;
    }

    public static MomentsCallToActionPartDefinition m25786a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MomentsCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23543g) {
                MomentsCallToActionPartDefinition momentsCallToActionPartDefinition;
                if (a2 != null) {
                    momentsCallToActionPartDefinition = (MomentsCallToActionPartDefinition) a2.a(f23543g);
                } else {
                    momentsCallToActionPartDefinition = f23542f;
                }
                if (momentsCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25788b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23543g, b3);
                        } else {
                            f23542f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = momentsCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ActionLinkCallToActionView> m25791a() {
        return ActionLinkCallToActionView.f23054h;
    }

    public static boolean m25789c(GraphQLStory graphQLStory) {
        if (StoryActorHelper.b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
        if (a == null || a.a() == null || a.a().g() != -474438628) {
            return false;
        }
        return true;
    }

    public static <E extends FeedEnvironment> String m25787a(E e) {
        return e.c().a().toString();
    }

    @Nullable
    public static String m25790d(GraphQLStory graphQLStory) {
        if (m25789c(graphQLStory)) {
            return ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)).aj();
        }
        return null;
    }
}
