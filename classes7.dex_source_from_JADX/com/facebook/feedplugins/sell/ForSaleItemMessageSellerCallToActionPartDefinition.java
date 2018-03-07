package com.facebook.feedplugins.sell;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition$Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
/* compiled from: SIN */
public class ForSaleItemMessageSellerCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static ForSaleItemMessageSellerCallToActionPartDefinition f23789e;
    private static final Object f23790f = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f23791a;
    public final Context f23792b;
    public final FbUriIntentHandler f23793c;
    public final AnalyticsLogger f23794d;

    private static ForSaleItemMessageSellerCallToActionPartDefinition m25963b(InjectorLike injectorLike) {
        return new ForSaleItemMessageSellerCallToActionPartDefinition((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 1837), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m25965a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        final FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
        if (o == null || o.z() == null) {
            str = null;
        } else {
            str = o.z().dp();
        }
        final String str2 = str;
        subParts.a((SinglePartDefinition) this.f23791a.get(), ActionLinkCallToActionPartDefinition$Props.m25512a(feedProps, null, new OnClickListener(this) {
            final /* synthetic */ ForSaleItemMessageSellerCallToActionPartDefinition f23788c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1157365753);
                HoneyClientEventFast a2 = this.f23788c.f23794d.a("for_sale_item_message_seller_button_clicked", false);
                if (a2.a()) {
                    a2.a("for_sale_item_id", str2).b();
                }
                this.f23788c.f23793c.a(this.f23788c.f23792b, StringFormatUtil.formatStrLocaleSafe(FBLinks.R, StoryActorHelper.b((GraphQLStory) feedProps.a).H()));
                Logger.a(2, EntryType.UI_INPUT_END, 1277109361, a);
            }
        }, null, null));
        return null;
    }

    public final boolean m25966a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (!ActionLinkCallToActionPartDefinition.b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
        return a.a() != null && a.a().g() == -1270456557;
    }

    @Inject
    public ForSaleItemMessageSellerCallToActionPartDefinition(Context context, FbUriIntentHandler fbUriIntentHandler, Lazy<ActionLinkCallToActionPartDefinition> lazy, AnalyticsLogger analyticsLogger) {
        this.f23792b = context;
        this.f23793c = fbUriIntentHandler;
        this.f23791a = lazy;
        this.f23794d = analyticsLogger;
    }

    public static ForSaleItemMessageSellerCallToActionPartDefinition m25962a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ForSaleItemMessageSellerCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23790f) {
                ForSaleItemMessageSellerCallToActionPartDefinition forSaleItemMessageSellerCallToActionPartDefinition;
                if (a2 != null) {
                    forSaleItemMessageSellerCallToActionPartDefinition = (ForSaleItemMessageSellerCallToActionPartDefinition) a2.a(f23790f);
                } else {
                    forSaleItemMessageSellerCallToActionPartDefinition = f23789e;
                }
                if (forSaleItemMessageSellerCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25963b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23790f, b3);
                        } else {
                            f23789e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = forSaleItemMessageSellerCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ActionLinkCallToActionView> m25964a() {
        return ActionLinkCallToActionView.f23054h;
    }
}
