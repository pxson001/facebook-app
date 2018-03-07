package com.facebook.reaction.ui.welcomeheader;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.WelcomeHeaderInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionFollowActionSyncEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionFollowActionSyncEventSubscriber;
import com.facebook.reaction.event.ReactionUiEvents.ReactionUpdateLikeButtonEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionUpdateLikeButtonEventSubscriber;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionPageFieldsWithPlaceTipsInfoModel;
import com.facebook.reaction.ui.welcomeheader.ReactionFollowActionHelper.C22571;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: Unable to get new slide for swipe */
public class ReactionWelcomeHeaderActionButtonsView extends SegmentedLinearLayout {
    @Inject
    ComposerLauncher f21223a;
    @Inject
    ReactionEventBus f21224b;
    @Inject
    ReactionFollowActionHelper f21225c;
    @Inject
    ReactionIntentFactory f21226d;
    @Inject
    RawLikeHelper f21227e;
    private ImageWithTextView f21228f;
    private FbEventSubscriber f21229g;
    private GlyphColorizer f21230h;
    public ReactionInteractionTracker f21231i;
    private ImageWithTextView f21232j;
    public ReactionPageFieldsWithPlaceTipsInfoModel f21233k;
    private Fragment f21234l;
    private Surface f21235m;
    private FbEventSubscriber f21236n;
    public boolean f21237o;

    /* compiled from: Unable to get new slide for swipe */
    class C22591 extends ReactionUpdateLikeButtonEventSubscriber {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21216a;

        C22591(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21216a = reactionWelcomeHeaderActionButtonsView;
        }

        public final void m24827b(FbEvent fbEvent) {
            ReactionUpdateLikeButtonEvent reactionUpdateLikeButtonEvent = (ReactionUpdateLikeButtonEvent) fbEvent;
            this.f21216a.f21237o = reactionUpdateLikeButtonEvent.f18933b;
            ReactionWelcomeHeaderActionButtonsView.m24834a(this.f21216a, this.f21216a.f21237o);
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22602 extends ReactionFollowActionSyncEventSubscriber {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21217a;

        C22602(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21217a = reactionWelcomeHeaderActionButtonsView;
        }

        public final void m24828b(FbEvent fbEvent) {
            ReactionFollowActionSyncEvent reactionFollowActionSyncEvent = (ReactionFollowActionSyncEvent) fbEvent;
            this.f21217a.f21225c.f21208c = reactionFollowActionSyncEvent.f18906b;
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22613 implements OnClickListener {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21218a;

        C22613(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21218a = reactionWelcomeHeaderActionButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 815475048);
            this.f21218a.m24844d();
            Logger.a(2, EntryType.UI_INPUT_END, -1261041507, a);
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22624 implements OnClickListener {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21219a;

        C22624(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21219a = reactionWelcomeHeaderActionButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 344123413);
            this.f21219a.m24842c();
            Logger.a(2, EntryType.UI_INPUT_END, -2019692782, a);
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22635 implements OnMenuItemClickListener {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21220a;

        C22635(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21220a = reactionWelcomeHeaderActionButtonsView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f21220a.f21233k;
            return true;
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22646 implements OnMenuItemClickListener {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21221a;

        C22646(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21221a = reactionWelcomeHeaderActionButtonsView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ReactionFollowActionHelper reactionFollowActionHelper = this.f21221a.f21225c;
            String eG_ = this.f21221a.f21233k.eG_();
            GraphQLSubscribeStatus graphQLSubscribeStatus = reactionFollowActionHelper.f21208c;
            reactionFollowActionHelper.f21208c = !GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(graphQLSubscribeStatus) ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CAN_SUBSCRIBE;
            ListenableFuture a;
            if (!GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(reactionFollowActionHelper.f21208c)) {
                a = reactionFollowActionHelper.f21207b.a(eG_, SubscribeLocation.PROFILE);
                reactionFollowActionHelper.f21206a.a(a, new C22571(reactionFollowActionHelper, graphQLSubscribeStatus));
            } else if (GraphQLSubscribeStatus.CAN_SUBSCRIBE.equals(graphQLSubscribeStatus)) {
                a = reactionFollowActionHelper.f21207b.a(eG_, ActorSubscribeInputData.SubscribeLocation.PROFILE);
                reactionFollowActionHelper.f21206a.a(a, new C22571(reactionFollowActionHelper, graphQLSubscribeStatus));
            }
            this.f21221a.f21224b.a(new ReactionFollowActionSyncEvent(this.f21221a.f21225c.f21208c, this.f21221a.f21231i.m18945b()));
            return true;
        }
    }

    /* compiled from: Unable to get new slide for swipe */
    class C22657 implements MutationCallback<String> {
        final /* synthetic */ ReactionWelcomeHeaderActionButtonsView f21222a;

        C22657(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
            this.f21222a = reactionWelcomeHeaderActionButtonsView;
        }

        public final /* bridge */ /* synthetic */ void m24829a(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m24831b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m24832c(Object obj) {
        }

        public final void m24830a(Object obj, ServiceException serviceException) {
            this.f21222a.f21224b.a(new ReactionUpdateLikeButtonEvent(!this.f21222a.f21237o, this.f21222a.f21231i.m18945b()));
        }
    }

    private static <T extends View> void m24835a(Class<T> cls, T t) {
        m24836a((Object) t, t.getContext());
    }

    private static void m24836a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionWelcomeHeaderActionButtonsView) obj).m24833a((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ReactionEventBus.m22919a(injectorLike), new ReactionFollowActionHelper(DefaultAndroidThreadUtil.b(injectorLike), FriendingClient.b(injectorLike)), ReactionIntentFactory.m22683a(injectorLike), RawLikeHelper.b(injectorLike));
    }

    public ReactionWelcomeHeaderActionButtonsView(Context context) {
        super(context);
        m24839b();
    }

    public ReactionWelcomeHeaderActionButtonsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24839b();
    }

    private void m24839b() {
        this.f21230h = new GlyphColorizer(getResources());
        setContentView(2130906722);
        m24835a(ReactionWelcomeHeaderActionButtonsView.class, (View) this);
        this.f21236n = new C22591(this);
        this.f21229g = new C22602(this);
    }

    public final void m24849a(ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel, Fragment fragment, Surface surface, ReactionInteractionTracker reactionInteractionTracker, boolean z, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        this.f21231i = reactionInteractionTracker;
        this.f21233k = reactionPageFieldsWithPlaceTipsInfoModel;
        this.f21234l = fragment;
        this.f21235m = surface;
        this.f21237o = z;
        this.f21225c.f21208c = graphQLSubscribeStatus;
        this.f21232j = (ImageWithTextView) findViewById(2131566790);
        if (this.f21233k.c()) {
            m24834a(this, this.f21237o);
            this.f21232j.setOnClickListener(new C22613(this));
        } else {
            this.f21232j.setVisibility(8);
        }
        this.f21228f = (ImageWithTextView) findViewById(2131566791);
        if (this.f21235m == null || ReactionSurfaceUtil.m4777c(this.f21235m)) {
            this.f21228f.setVisibility(8);
        } else {
            this.f21228f.setImageDrawable(this.f21230h.a(2130840023, -1));
            this.f21228f.setOnClickListener(new C22624(this));
        }
        if (this.f21228f.getVisibility() == 8 && this.f21232j.getVisibility() == 8) {
            setVisibility(8);
        }
    }

    public final boolean m24850a() {
        return this.f21237o;
    }

    public GraphQLSubscribeStatus getFollowSubscribeStatus() {
        return this.f21225c.f21208c;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1392962336);
        super.onDetachedFromWindow();
        this.f21224b.b(this.f21229g);
        this.f21224b.b(this.f21236n);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 652744175, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1531028269);
        super.onAttachedToWindow();
        this.f21224b.a(this.f21229g);
        this.f21224b.a(this.f21236n);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1137414522, a);
    }

    private void m24842c() {
        ReactionAttachmentIntent a = ReactionIntentFactory.m22703a(this.f21233k.eG_(), this.f21233k.k(), null);
        if (a.f18831d != null) {
            this.f21223a.a(null, (ComposerConfiguration) a.f18831d.getParcelableExtra("composer_configuration"), 1756, this.f21234l);
            this.f21231i.m18936a(this.f21233k.eG_(), WelcomeHeaderInteractionType.HEADER_CHECK_IN);
        }
    }

    private int getFollowStateTitle() {
        return GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(this.f21225c.f21208c) ? 2131235387 : 2131235386;
    }

    private void m24844d() {
        if (this.f21237o) {
            PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(getContext());
            PopoverMenu c = popoverMenuWindow.c();
            c.a(2131235370).setOnMenuItemClickListener(new C22635(this));
            c.a(getFollowStateTitle()).setOnMenuItemClickListener(new C22646(this));
            popoverMenuWindow.f(this.f21232j);
            return;
        }
        this.f21233k;
    }

    public static void m24847e(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView) {
        reactionWelcomeHeaderActionButtonsView.f21224b.a(new ReactionUpdateLikeButtonEvent(!reactionWelcomeHeaderActionButtonsView.f21237o, reactionWelcomeHeaderActionButtonsView.f21231i.m18945b()));
        reactionWelcomeHeaderActionButtonsView.f21231i.m18936a(reactionWelcomeHeaderActionButtonsView.f21233k.eG_(), WelcomeHeaderInteractionType.HEADER_LIKE_TAP);
        reactionWelcomeHeaderActionButtonsView.f21224b.a(new ReactionFollowActionSyncEvent(reactionWelcomeHeaderActionButtonsView.f21237o ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CANNOT_SUBSCRIBE, reactionWelcomeHeaderActionButtonsView.f21231i.m18945b()));
        reactionWelcomeHeaderActionButtonsView.f21227e.a(reactionWelcomeHeaderActionButtonsView.f21233k.eG_(), reactionWelcomeHeaderActionButtonsView.f21237o, null, "reaction_dialog", null, null, null, true, new C22657(reactionWelcomeHeaderActionButtonsView));
    }

    public static void m24834a(ReactionWelcomeHeaderActionButtonsView reactionWelcomeHeaderActionButtonsView, boolean z) {
        if (z) {
            reactionWelcomeHeaderActionButtonsView.f21232j.setText(2131235369);
            reactionWelcomeHeaderActionButtonsView.f21232j.setTextColor(-10972929);
            reactionWelcomeHeaderActionButtonsView.f21232j.setImageDrawable(reactionWelcomeHeaderActionButtonsView.f21230h.a(2130839953, -10972929));
            return;
        }
        reactionWelcomeHeaderActionButtonsView.f21232j.setText(2131233426);
        reactionWelcomeHeaderActionButtonsView.f21232j.setTextColor(-1);
        reactionWelcomeHeaderActionButtonsView.f21232j.setImageDrawable(reactionWelcomeHeaderActionButtonsView.f21230h.a(2130839953, -1));
    }

    private void m24833a(ComposerLauncher composerLauncher, ReactionEventBus reactionEventBus, ReactionFollowActionHelper reactionFollowActionHelper, ReactionIntentFactory reactionIntentFactory, RawLikeHelper rawLikeHelper) {
        this.f21223a = composerLauncher;
        this.f21224b = reactionEventBus;
        this.f21225c = reactionFollowActionHelper;
        this.f21226d = reactionIntentFactory;
        this.f21227e = rawLikeHelper;
    }
}
