package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.event.HoneyClientEventFastInternal;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.protocol.coupons.ClaimCouponParams;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLCoupon;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ufiservices.UFIService;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video broadcast poll failed for  */
public class ClaimCouponActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static ClaimCouponActionButton f712l;
    private static final Object f713m = new Object();
    public final Resources f714a;
    public final UFIService f715b;
    public final TasksManager f716c;
    public final IFeedIntentBuilder f717d;
    public final Context f718e;
    private final ViewerContext f719f;
    private final ErrorDialogs f720g;
    private final FbNetworkManager f721h;
    public final AnalyticsLogger f722i;
    private final ActionButtonComponent f723j;
    private final SinglePartDefinition f724k = new ClaimCouponActionButtonPartDefinition(this);

    /* compiled from: video broadcast poll failed for  */
    class ClaimCouponActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ ClaimCouponActionButton f708a;

        public ClaimCouponActionButtonPartDefinition(ClaimCouponActionButton claimCouponActionButton) {
            this.f708a = claimCouponActionButton;
        }

        public final Object m769a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps feedProps = (FeedProps) obj;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
            ClaimCouponActionButton claimCouponActionButton = this.f708a;
            GraphQLCoupon a = ClaimCouponActionButton.m774a(graphQLStoryAttachment);
            if (a == null) {
                return new State(false, null, null);
            }
            return new State(true, this.f708a.f714a.getString(ClaimCouponActionButton.m777c(a)), ClaimCouponActionButton.m772a(this.f708a, a, TrackableFeedProps.a(feedProps), StoryProps.p(AttachmentProps.e(feedProps))));
        }

        public final /* bridge */ /* synthetic */ void m770a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, 2105027935);
            m768a((State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, -861799027, a);
        }

        private static void m768a(State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (state.f709a) {
                GlyphWithTextView glyphWithTextView = ((AttachmentHasButton) v).getActionButton().a;
                actionButton.setVisibility(0);
                actionButton.g = true;
                glyphWithTextView.setText(state.f710b);
                glyphWithTextView.setImageResource(2130839476);
                glyphWithTextView.setOnClickListener(state.f711c);
                glyphWithTextView.setBackgroundResource(2130839739);
                return;
            }
            actionButton.setVisibility(8);
        }

        public final void m771b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().a();
            }
        }
    }

    /* compiled from: video broadcast poll failed for  */
    public class State {
        public final boolean f709a;
        public final String f710b;
        public final OnClickListener f711c;

        public State(boolean z, String str, OnClickListener onClickListener) {
            this.f709a = z;
            this.f710b = str;
            this.f711c = onClickListener;
        }
    }

    private static ClaimCouponActionButton m776b(InjectorLike injectorLike) {
        return new ClaimCouponActionButton((Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), new UFIService(DefaultBlueServiceOperationFactory.b(injectorLike), FeedbackGraphQLGenerator.a(injectorLike)), TasksManager.b(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ErrorDialogs.a(injectorLike), FbNetworkManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ActionButtonComponent.a(injectorLike));
    }

    public static ClaimCouponActionButton m773a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClaimCouponActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f713m) {
                ClaimCouponActionButton claimCouponActionButton;
                if (a2 != null) {
                    claimCouponActionButton = (ClaimCouponActionButton) a2.a(f713m);
                } else {
                    claimCouponActionButton = f712l;
                }
                if (claimCouponActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m776b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f713m, b3);
                        } else {
                            f712l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = claimCouponActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ClaimCouponActionButton(Context context, ViewerContext viewerContext, Resources resources, UFIService uFIService, TasksManager tasksManager, IFeedIntentBuilder iFeedIntentBuilder, ErrorDialogs errorDialogs, FbNetworkManager fbNetworkManager, AnalyticsLogger analyticsLogger, ActionButtonComponent actionButtonComponent) {
        this.f718e = context;
        this.f719f = viewerContext;
        this.f714a = resources;
        this.f715b = uFIService;
        this.f716c = tasksManager;
        this.f717d = iFeedIntentBuilder;
        this.f720g = errorDialogs;
        this.f721h = fbNetworkManager;
        this.f722i = analyticsLogger;
        this.f723j = actionButtonComponent;
    }

    public final Component m779a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLCoupon a = m774a((GraphQLStoryAttachment) feedProps.a);
        if (a == null) {
            return null;
        }
        ActionButtonComponent$Builder a2 = this.f723j.a(componentContext).m737j(2130839476).m732a(true);
        int c = m777c(a);
        a2.f643a.f647a = a2.b(c);
        return a2.m730a(m772a(this, a, TrackableFeedProps.a(feedProps), StoryProps.p(AttachmentProps.e(feedProps)))).d();
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m780a() {
        return this.f724k;
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m781b() {
        return null;
    }

    @Nullable
    public static GraphQLCoupon m774a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
        if (a == null) {
            return null;
        }
        return a.r();
    }

    public static void m775a(ClaimCouponActionButton claimCouponActionButton, String str) {
        int i = claimCouponActionButton.f721h.d() ? 2131230758 : 2131230759;
        ErrorDialogs errorDialogs = claimCouponActionButton.f720g;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(claimCouponActionButton.f718e);
        a.b = str;
        errorDialogs.a(a.b(i).l());
    }

    public static OnClickListener m772a(ClaimCouponActionButton claimCouponActionButton, final GraphQLCoupon graphQLCoupon, final ArrayNode arrayNode, final boolean z) {
        return new OnClickListener(claimCouponActionButton) {
            final /* synthetic */ ClaimCouponActionButton f707d;

            public void onClick(final View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1784371270);
                ClaimCouponParams claimCouponParams = new ClaimCouponParams(graphQLCoupon.p(), ClaimCouponActionButton.m778d(graphQLCoupon));
                UFIService uFIService = this.f707d.f715b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("claimCouponParams", claimCouponParams);
                this.f707d.f716c.a("email_coupon", BlueServiceOperationFactoryDetour.a(uFIService.a, "feed_claim_coupon", bundle, ErrorPropagation.BY_ERROR_CODE, null, -1673728360).a(), new AbstractDisposableFutureCallback(this) {
                    final /* synthetic */ C00701 f703b;

                    protected final void m766a(Object obj) {
                        if (StringUtil.a(ClaimCouponActionButton.m778d(graphQLCoupon), "claim")) {
                            HoneyClientEventFast a = this.f703b.f707d.f722i.a("tap_coupon_attachment", true);
                            if (a.a()) {
                                HoneyClientEventFast a2 = a.a("event_type", "claim_offer").a("tracking", arrayNode);
                                boolean z = z;
                                HoneyClientEventFastInternal honeyClientEventFastInternal = a2.a;
                                honeyClientEventFastInternal.k = z;
                                honeyClientEventFastInternal.a("sponsored", z);
                                a2 = a2;
                                ClaimCouponActionButton claimCouponActionButton = this.f703b.f707d;
                                a2.a("native_newsfeed");
                                a.b();
                            }
                        }
                        graphQLCoupon.a(true);
                        this.f703b.f707d.f717d.a(this.f703b.f707d.f718e, StringFormatUtil.formatStrLocaleSafe(FBLinks.aC, graphQLCoupon.p()));
                        CharSequence string = this.f703b.f707d.f714a.getString(ClaimCouponActionButton.m777c(graphQLCoupon));
                        if (view instanceof FbButton) {
                            ((FbButton) view).setText(string);
                        } else {
                            ((GlyphWithTextView) view).setText(string);
                        }
                    }

                    protected final void m767a(Throwable th) {
                        if (StringUtil.a(ClaimCouponActionButton.m778d(graphQLCoupon), "claim")) {
                            ClaimCouponActionButton.m775a(this.f703b.f707d, this.f703b.f707d.f714a.getString(2131233398));
                        } else if (StringUtil.a(ClaimCouponActionButton.m778d(graphQLCoupon), "resend")) {
                            ClaimCouponActionButton.m775a(this.f703b.f707d, this.f703b.f707d.f714a.getString(2131233399));
                        }
                    }
                });
                Logger.a(2, EntryType.UI_INPUT_END, 1895386587, a);
            }
        };
    }

    public static int m777c(GraphQLCoupon graphQLCoupon) {
        if (!graphQLCoupon.q()) {
            return 2131233394;
        }
        if (graphQLCoupon.o()) {
            return 2131233393;
        }
        return 2131233392;
    }

    public static String m778d(GraphQLCoupon graphQLCoupon) {
        return graphQLCoupon.o() ? "resend" : "claim";
    }
}
