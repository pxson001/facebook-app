package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bundleIdentifier */
public class SaleGroupsNearYouFooterPartDefinition<E extends HasPositionInformation & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLSaleGroupsNearYouFeedUnit>, Void, E, OneButtonFooterView> {
    public static final ViewType f9375a = new C11241();
    private static final PaddingStyle f9376b;
    private static SaleGroupsNearYouFooterPartDefinition f9377i;
    private static final Object f9378j = new Object();
    public final SecureContextHelper f9379c;
    private final ClickListenerPartDefinition f9380d;
    private final ResourceIdTextPartDefinition f9381e;
    private final BackgroundPartDefinition f9382f;
    public final UriIntentMapper f9383g;
    public final AnalyticsLogger f9384h;

    /* compiled from: bundleIdentifier */
    final class C11241 extends ViewType {
        C11241() {
        }

        public final View m9970a(Context context) {
            return new OneButtonFooterView(context);
        }
    }

    private static SaleGroupsNearYouFooterPartDefinition m9972b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m9974a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        Flattenable flattenable = feedProps.a;
        subParts.a(this.f9382f, new StylingData(feedProps, f9376b));
        ClickListenerPartDefinition clickListenerPartDefinition = this.f9380d;
        final FeedListType c = ((HasFeedListType) hasPositionInformation).c();
        subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ SaleGroupsNearYouFooterPartDefinition f9374b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1147043405);
                SaleGroupsNearYouFooterPartDefinition saleGroupsNearYouFooterPartDefinition = this.f9374b;
                FeedListType feedListType = c;
                String name = (feedListType == null || feedListType.a() == null) ? null : feedListType.a().name();
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sgny_see_all_click");
                honeyClientEvent.c = "native_newsfeed";
                honeyClientEvent = honeyClientEvent;
                if (name != null) {
                    honeyClientEvent.b("feed_name", name);
                }
                saleGroupsNearYouFooterPartDefinition.f9384h.a(honeyClientEvent);
                Context context = view.getContext();
                this.f9374b.f9379c.a(this.f9374b.f9383g.a(context, FBLinks.fj), context);
                Logger.a(2, EntryType.UI_INPUT_END, 452700588, a);
            }
        });
        subParts.a(2131559974, this.f9381e, Integer.valueOf(2131233486));
        return null;
    }

    static {
        Builder g = Builder.g();
        g.b = 4.0f;
        f9376b = g.i();
    }

    public static SaleGroupsNearYouFooterPartDefinition m9971a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SaleGroupsNearYouFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9378j) {
                SaleGroupsNearYouFooterPartDefinition saleGroupsNearYouFooterPartDefinition;
                if (a2 != null) {
                    saleGroupsNearYouFooterPartDefinition = (SaleGroupsNearYouFooterPartDefinition) a2.a(f9378j);
                } else {
                    saleGroupsNearYouFooterPartDefinition = f9377i;
                }
                if (saleGroupsNearYouFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9972b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9378j, b3);
                        } else {
                            f9377i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saleGroupsNearYouFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SaleGroupsNearYouFooterPartDefinition(SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, BackgroundPartDefinition backgroundPartDefinition, UriIntentMapper uriIntentMapper, AnalyticsLogger analyticsLogger) {
        this.f9379c = secureContextHelper;
        this.f9380d = clickListenerPartDefinition;
        this.f9381e = resourceIdTextPartDefinition;
        this.f9382f = backgroundPartDefinition;
        this.f9383g = uriIntentMapper;
        this.f9384h = analyticsLogger;
    }

    public final ViewType m9973a() {
        return f9375a;
    }

    public final boolean m9975a(Object obj) {
        return true;
    }
}
