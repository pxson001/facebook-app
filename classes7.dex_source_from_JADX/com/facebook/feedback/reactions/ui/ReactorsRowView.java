package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feedback.reactions.ui.widget.ReactorsFaceView;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics;
import com.facebook.pages.common.bannedusers.analytics.PagesBanUserReferrer;
import com.facebook.pages.common.bannedusers.api.PagesBanUserHelper;
import com.facebook.pages.common.bannedusers.api.PagesBanUserHelper.C07351;
import com.facebook.ufiservices.ui.ProfileListConverter;
import com.facebook.ufiservices.ui.ProfileListFriendingController;
import com.facebook.ufiservices.ui.SmartFriendingButtonBinder;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: settingId */
public class ReactorsRowView extends ImageBlockLayout {
    @Inject
    FriendingEventBus f3930h;
    @Inject
    ProfileListFriendingController f3931i;
    @Inject
    FeedbackReactionsController f3932j;
    @Inject
    PagesBanUserHelper f3933k;
    @Inject
    Lazy<PagesBanUserAnalytics> f3934l;
    private ReactorsFaceView f3935m;
    private TextView f3936n;
    private SmartButtonLite f3937o;
    private FriendshipStatusChangedEventSubscriber f3938p;

    private static <T extends View> void m4568a(Class<T> cls, T t) {
        m4569a((Object) t, t.getContext());
    }

    private static void m4569a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ReactorsRowView) obj).m4566a(FriendingEventBus.a(fbInjector), ProfileListFriendingController.b(fbInjector), FeedbackReactionsController.a(fbInjector), new PagesBanUserHelper((Context) fbInjector.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(fbInjector), TasksManager.b(fbInjector), ViewerContextMethodAutoProvider.b(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), Toaster.b(fbInjector)), IdBasedSingletonScopeProvider.b(fbInjector, 8908));
    }

    public ReactorsRowView(Context context) {
        super(context);
        m4564a();
    }

    public ReactorsRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4564a();
    }

    public ReactorsRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4564a();
    }

    private void m4564a() {
        int i;
        m4568a(ReactorsRowView.class, (View) this);
        if (this.f3933k.f9104e.mIsPageContext) {
            i = 2130906728;
        } else {
            i = 2130906727;
        }
        setContentView(i);
        this.f3935m = (ReactorsFaceView) getView(2131566801);
        this.f3936n = (TextView) getView(2131566802);
        this.f3931i.a(new SmartFriendingButtonBinder(), findViewById(2131562095), (TextView) getView(2131566803));
        this.f3938p = this.f3931i.a();
        this.f3937o = (SmartButtonLite) findViewById(2131565675);
    }

    public final void m4571a(ActorReactionPair actorReactionPair, boolean z) {
        this.f3935m.m4700a(actorReactionPair.f3861a, this.f3932j.a(actorReactionPair.f3862b.intValue()));
        this.f3936n.setText(actorReactionPair.f3861a.aa());
        this.f3931i.a(ProfileListConverter.a(actorReactionPair.f3861a));
        if (this.f3937o == null) {
            return;
        }
        if (z) {
            m4570a(actorReactionPair.f3861a.I(), this.f3937o, actorReactionPair.f3861a.H(), actorReactionPair.f3861a.aa());
        } else {
            this.f3937o.setVisibility(8);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1072174201);
        super.onAttachedToWindow();
        this.f3930h.a(this.f3938p);
        this.f3931i.a(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1677155338, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1857853160);
        this.f3931i.a(true);
        super.onDetachedFromWindow();
        this.f3930h.b(this.f3938p);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1761358826, a);
    }

    private void m4570a(boolean z, final SmartButtonLite smartButtonLite, final String str, final String str2) {
        Object obj;
        PagesBanUserHelper pagesBanUserHelper = this.f3933k;
        if (pagesBanUserHelper.f9104e.mUserId.equals(str) || pagesBanUserHelper.f9105f.equals(str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            smartButtonLite.setVisibility(8);
            return;
        }
        smartButtonLite.setVisibility(0);
        smartButtonLite.setFocusable(false);
        if (z) {
            m4567a(smartButtonLite);
            return;
        }
        smartButtonLite.setStyle(2130772383);
        smartButtonLite.setTextColor(getContext().getResources().getColor(2131361932));
        smartButtonLite.setEnabled(true);
        smartButtonLite.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReactorsRowView f3929d;

            /* compiled from: settingId */
            class C03401 implements Runnable {
                final /* synthetic */ C03411 f3925a;

                C03401(C03411 c03411) {
                    this.f3925a = c03411;
                }

                public void run() {
                    String str;
                    this.f3925a.f3929d.m4567a(smartButtonLite);
                    PagesBanUserAnalytics pagesBanUserAnalytics = (PagesBanUserAnalytics) this.f3925a.f3929d.f3934l.get();
                    PagesBanUserHelper pagesBanUserHelper = this.f3925a.f3929d.f3933k;
                    if (pagesBanUserHelper.f9104e.mIsPageContext) {
                        str = pagesBanUserHelper.f9104e.mUserId;
                    } else {
                        str = null;
                    }
                    pagesBanUserAnalytics.m10909a(str, PagesBanUserReferrer.REACTORS);
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1437274144);
                PagesBanUserHelper pagesBanUserHelper = this.f3929d.f3933k;
                String str = str;
                String str2 = str2;
                Runnable c03401 = new C03401(this);
                new FbAlertDialogBuilder(pagesBanUserHelper.f9101b).b(pagesBanUserHelper.f9101b.getResources().getString(2131233254, new Object[]{str2})).a(2131233255, new C07351(pagesBanUserHelper, str, str2, c03401)).b(2131233256, null).b();
                Logger.a(2, EntryType.UI_INPUT_END, 2119357380, a);
            }
        });
    }

    private void m4567a(SmartButtonLite smartButtonLite) {
        if (smartButtonLite != null) {
            smartButtonLite.setStyle(2130772383);
            smartButtonLite.setText(getContext().getString(2131233253));
            smartButtonLite.setEnabled(false);
            smartButtonLite.setOnClickListener(null);
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f3930h.b(this.f3938p);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f3930h.a(this.f3938p);
    }

    private void m4566a(FriendingEventBus friendingEventBus, ProfileListFriendingController profileListFriendingController, FeedbackReactionsController feedbackReactionsController, PagesBanUserHelper pagesBanUserHelper, Lazy<PagesBanUserAnalytics> lazy) {
        this.f3930h = friendingEventBus;
        this.f3931i = profileListFriendingController;
        this.f3932j = feedbackReactionsController;
        this.f3933k = pagesBanUserHelper;
        this.f3934l = lazy;
    }
}
