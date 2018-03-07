package com.facebook.feedplugins.base.blingbar;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hashtag_feed_title */
public class BlingBarFlyoutPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, AnyEnvironment, View> {
    private static BlingBarFlyoutPartDefinition f21201d;
    private static final Object f21202e = new Object();
    public final FlyoutLauncher f21203a;
    private final ClickListenerPartDefinition f21204b;
    public final FeedDiscoveryFunnelLoggerUtil f21205c;

    private static BlingBarFlyoutPartDefinition m28930b(InjectorLike injectorLike) {
        return new BlingBarFlyoutPartDefinition(ClickListenerPartDefinition.m19353a(injectorLike), FlyoutLauncher.m28357a(injectorLike), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f21204b, new OnClickListener(this) {
            final /* synthetic */ BlingBarFlyoutPartDefinition f22275c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1988069967);
                this.f22275c.f21205c.m28901d(graphQLStory);
                this.f22275c.f21203a.m28363a(feedProps, view, FlyoutContext.BLINGBAR);
                Logger.a(2, EntryType.UI_INPUT_END, -1906846207, a);
            }
        });
        return null;
    }

    @Inject
    public BlingBarFlyoutPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FlyoutLauncher flyoutLauncher, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        this.f21203a = flyoutLauncher;
        this.f21204b = clickListenerPartDefinition;
        this.f21205c = feedDiscoveryFunnelLoggerUtil;
    }

    public static BlingBarFlyoutPartDefinition m28929a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarFlyoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21202e) {
                BlingBarFlyoutPartDefinition blingBarFlyoutPartDefinition;
                if (a2 != null) {
                    blingBarFlyoutPartDefinition = (BlingBarFlyoutPartDefinition) a2.mo818a(f21202e);
                } else {
                    blingBarFlyoutPartDefinition = f21201d;
                }
                if (blingBarFlyoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28930b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21202e, b3);
                        } else {
                            f21201d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarFlyoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
