package com.facebook.feedplugins.groupcommerce;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendversary_polaroids */
public class GroupCommerceSellerActionsPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, String, HasPositionInformation, GroupCommerceSellerActionsView> {
    public static final ViewType f12788a = new C13311();
    private static GroupCommerceSellerActionsPartDefinition f12789i;
    private static final Object f12790j = new Object();
    public final Context f12791b;
    public final ComposerLauncher f12792c;
    public final IFeedIntentBuilder f12793d;
    private final BackgroundPartDefinition f12794e;
    private final DefaultTimeFormatUtil f12795f;
    private final Clock f12796g;
    public final ProductItemUpdateAvailabilityHelper f12797h;

    /* compiled from: friendversary_polaroids */
    final class C13311 extends ViewType {
        C13311() {
        }

        public final View m14572a(Context context) {
            return new GroupCommerceSellerActionsView(context);
        }
    }

    private static GroupCommerceSellerActionsPartDefinition m14576b(InjectorLike injectorLike) {
        return new GroupCommerceSellerActionsPartDefinition((Context) injectorLike.getInstance(Context.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), BackgroundPartDefinition.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ProductItemUpdateAvailabilityHelper.b(injectorLike));
    }

    public final Object m14578a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f12794e, new StylingData(feedProps, PaddingStyle.a));
        return this.f12791b.getResources().getString(StoryCommerceHelper.d(graphQLStory) ? 2131237862 : 2131237863);
    }

    public final /* bridge */ /* synthetic */ void m14579a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -420390401);
        m14575a((FeedProps) obj, (String) obj2, (GroupCommerceSellerActionsView) view);
        Logger.a(8, EntryType.MARK_POP, -1827832100, a);
    }

    public final boolean m14580a(Object obj) {
        return StoryCommerceHelper.c((GraphQLStory) ((FeedProps) obj).a);
    }

    public final void m14581b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GroupCommerceSellerActionsView groupCommerceSellerActionsView = (GroupCommerceSellerActionsView) view;
        groupCommerceSellerActionsView.setOnEditPostClickListener(null);
        groupCommerceSellerActionsView.setOnMarkAsSoldClickListener(null);
    }

    @Inject
    public GroupCommerceSellerActionsPartDefinition(Context context, ComposerLauncher composerLauncher, IFeedIntentBuilder iFeedIntentBuilder, BackgroundPartDefinition backgroundPartDefinition, DefaultTimeFormatUtil defaultTimeFormatUtil, Clock clock, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper) {
        this.f12791b = context;
        this.f12792c = composerLauncher;
        this.f12793d = iFeedIntentBuilder;
        this.f12794e = backgroundPartDefinition;
        this.f12795f = defaultTimeFormatUtil;
        this.f12796g = clock;
        this.f12797h = productItemUpdateAvailabilityHelper;
    }

    public static GroupCommerceSellerActionsPartDefinition m14573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceSellerActionsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12790j) {
                GroupCommerceSellerActionsPartDefinition groupCommerceSellerActionsPartDefinition;
                if (a2 != null) {
                    groupCommerceSellerActionsPartDefinition = (GroupCommerceSellerActionsPartDefinition) a2.a(f12790j);
                } else {
                    groupCommerceSellerActionsPartDefinition = f12789i;
                }
                if (groupCommerceSellerActionsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14576b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12790j, b3);
                        } else {
                            f12789i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceSellerActionsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14577a() {
        return f12788a;
    }

    private void m14575a(final FeedProps<GraphQLStory> feedProps, String str, GroupCommerceSellerActionsView groupCommerceSellerActionsView) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GroupCommerceViewHelper.m14582a(StoryCommerceHelper.d(graphQLStory), groupCommerceSellerActionsView.f12799b, groupCommerceSellerActionsView.getContext());
        groupCommerceSellerActionsView.f12799b.setText(str);
        groupCommerceSellerActionsView.setOnEditPostClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupCommerceSellerActionsPartDefinition f12785b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1869203583);
                this.f12785b.f12792c.a(null, this.f12785b.f12793d.b(graphQLStory).a(), 1758, (Activity) this.f12785b.f12791b);
                Logger.a(2, EntryType.UI_INPUT_END, 518260275, a);
            }
        });
        groupCommerceSellerActionsView.setOnMarkAsSoldClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupCommerceSellerActionsPartDefinition f12787b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1016850694);
                this.f12787b.f12797h.a(feedProps, ToggleAvailabilitySurface.YOUR_POSTS);
                Logger.a(2, EntryType.UI_INPUT_END, -264231642, a);
            }
        });
        GraphQLNode z = StoryCommerceHelper.a(graphQLStory).z();
        if (z != null && z.cs() > 0) {
            if (z.dM() || StoryCommerceHelper.d(graphQLStory)) {
                CharSequence a = m14574a(z.cs());
                if (Strings.isNullOrEmpty(a)) {
                    groupCommerceSellerActionsView.f12800c.setVisibility(8);
                } else {
                    groupCommerceSellerActionsView.f12800c.setVisibility(0);
                    groupCommerceSellerActionsView.f12800c.setText(a);
                }
                if (z.dM()) {
                    groupCommerceSellerActionsView.f12801d.setVisibility(8);
                }
            }
        }
    }

    private String m14574a(long j) {
        long j2 = 1000 * j;
        String a = this.f12795f.a(TimeFormatStyle.MONTH_DAY_YEAR_SHORT_STYLE, j2);
        if (j2 < this.f12796g.a()) {
            return this.f12791b.getResources().getString(2131237870, new Object[]{a});
        }
        return this.f12791b.getResources().getString(2131237871, new Object[]{a});
    }
}
