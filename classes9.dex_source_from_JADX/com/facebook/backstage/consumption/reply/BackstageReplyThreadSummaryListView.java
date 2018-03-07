package com.facebook.backstage.consumption.reply;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.BackstagePanelViewProvider;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationState;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.consumption.StatusBarColorChanger;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.reply.ReplyDataProvider.ReplyThreadSummaryListObserver;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.ui.LazyView;
import com.facebook.backstage.ui.LazyView.OnInflateRunner;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: ride_provider_name */
public class BackstageReplyThreadSummaryListView extends FrameLayout {
    @Inject
    BackstageAnalyticsLogger f4901a;
    @Inject
    ReplyDataProvider f4902b;
    @Inject
    ReplyThreadSummaryListAdapterProvider f4903c;
    private final C05081 f4904d;
    private final ReplyThreadSummaryListObserver f4905e;
    private final SimpleAnimationHelper f4906f;
    public final SwipeRefreshLayout f4907g;
    private final View f4908h;
    public final LazyView<BackstageReplyThreadView> f4909i;
    public final ReplyThreadSummaryListAdapter f4910j;
    private final RecyclerView f4911k;
    public CameraHolder f4912l;
    public CameraFlowLauncher f4913m;
    private BackstageNavigatorApi f4914n;
    private StatusBarColorChanger f4915o;

    /* compiled from: ride_provider_name */
    public class C05081 {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4895a;

        C05081(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4895a = backstageReplyThreadSummaryListView;
        }

        public final void m4750a(View view, ReplyThreadSummary replyThreadSummary) {
            if (replyThreadSummary.m4919i()) {
                AnimatingEmojiView animatingEmojiView = (AnimatingEmojiView) view;
                animatingEmojiView.m4742b();
                animatingEmojiView.m4741a(this.f4895a);
                return;
            }
            ((BackstageReplyThreadView) this.f4895a.f4909i.m5715a()).m4771a(replyThreadSummary);
        }
    }

    /* compiled from: ride_provider_name */
    class C05092 implements ReplyThreadSummaryListObserver {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4896a;

        C05092(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4896a = backstageReplyThreadSummaryListView;
        }

        public final void mo154a(ImmutableList<ReplyThreadSummary> immutableList) {
            this.f4896a.f4901a.m4263a(immutableList.size());
            this.f4896a.f4910j.f4971e = immutableList;
            this.f4896a.f4910j.notifyDataSetChanged();
            this.f4896a.f4907g.setRefreshing(false);
        }
    }

    /* compiled from: ride_provider_name */
    class C05103 implements OnInflateRunner<BackstageReplyThreadView> {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4897a;

        C05103(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4897a = backstageReplyThreadSummaryListView;
        }

        public final void mo137a(View view) {
            ((BackstageReplyThreadView) view).m4770a(this.f4897a.f4912l, this.f4897a.f4913m);
        }
    }

    /* compiled from: ride_provider_name */
    class C05114 implements OnClickListener {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4898a;

        C05114(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4898a = backstageReplyThreadSummaryListView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1165928845);
            this.f4898a.f4910j;
            Logger.a(2, EntryType.UI_INPUT_END, 1150399753, a);
        }
    }

    /* compiled from: ride_provider_name */
    class C05125 implements OnRefreshListener {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4899a;

        C05125(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4899a = backstageReplyThreadSummaryListView;
        }

        public final void m4753a() {
            this.f4899a.f4902b.m4805a(true);
        }
    }

    /* compiled from: ride_provider_name */
    class C05136 implements OnGlobalLayoutListener {
        final /* synthetic */ BackstageReplyThreadSummaryListView f4900a;

        C05136(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
            this.f4900a = backstageReplyThreadSummaryListView;
        }

        public void onGlobalLayout() {
            this.f4900a.f4907g.setRefreshing(true);
            this.f4900a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    private static <T extends View> void m4756a(Class<T> cls, T t) {
        m4757a((Object) t, t.getContext());
    }

    private static void m4757a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackstageReplyThreadSummaryListView) obj).m4755a(BackstageAnalyticsLogger.m4259a(injectorLike), ReplyDataProvider.m4801a(injectorLike), (ReplyThreadSummaryListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReplyThreadSummaryListAdapterProvider.class));
    }

    public BackstageReplyThreadSummaryListView(Context context) {
        this(context, null);
    }

    public BackstageReplyThreadSummaryListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageReplyThreadSummaryListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4904d = new C05081(this);
        this.f4905e = new C05092(this);
        this.f4906f = new SimpleAnimationHelper(this, null);
        m4756a(BackstageReplyThreadSummaryListView.class, (View) this);
        View.inflate(context, 2130903370, this);
        setClickable(true);
        this.f4911k = (RecyclerView) findViewById(2131559891);
        this.f4909i = new LazyView((ViewStub) findViewById(2131559892), new C05103(this));
        this.f4911k.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f4911k.v = true;
        ReplyThreadSummaryListAdapterProvider replyThreadSummaryListAdapterProvider = this.f4903c;
        this.f4910j = new ReplyThreadSummaryListAdapter((BackstagePanelViewProvider) replyThreadSummaryListAdapterProvider.getOnDemandAssistedProviderForStaticDi(BackstagePanelViewProvider.class), ScreenUtil.m4547a(replyThreadSummaryListAdapterProvider), this.f4904d, this.f4911k);
        this.f4907g = (SwipeRefreshLayout) findViewById(2131559857);
        this.f4908h = findViewById(2131559890);
        this.f4908h.setOnClickListener(new C05114(this));
        this.f4907g.e = new C05125(this);
        this.f4910j.f4971e = new Builder().b();
        this.f4911k.setAdapter(this.f4910j);
    }

    public final void m4764a(CameraHolder cameraHolder, CameraFlowLauncher cameraFlowLauncher) {
        this.f4912l = cameraHolder;
        this.f4913m = cameraFlowLauncher;
    }

    public final void m4765a(BackstageNavigatorApi backstageNavigatorApi, StatusBarColorChanger statusBarColorChanger) {
        setFocusable(true);
        requestFocus();
        this.f4906f.m4560a(AnimationType.SLIDE_FROM_RIGHT);
        this.f4914n = backstageNavigatorApi;
        this.f4915o = statusBarColorChanger;
        this.f4902b.m4804a(this.f4905e);
        this.f4902b.m4805a(false);
        getViewTreeObserver().addOnGlobalLayoutListener(new C05136(this));
        this.f4915o.m4564a(2131361850);
    }

    private void m4755a(BackstageAnalyticsLogger backstageAnalyticsLogger, ReplyDataProvider replyDataProvider, ReplyThreadSummaryListAdapterProvider replyThreadSummaryListAdapterProvider) {
        this.f4901a = backstageAnalyticsLogger;
        this.f4902b = replyDataProvider;
        this.f4903c = replyThreadSummaryListAdapterProvider;
    }

    public static void m4759b(BackstageReplyThreadSummaryListView backstageReplyThreadSummaryListView) {
        backstageReplyThreadSummaryListView.f4906f.m4562b(AnimationType.SLIDE_FROM_RIGHT);
        backstageReplyThreadSummaryListView.f4902b.m4807b(backstageReplyThreadSummaryListView.f4905e);
        backstageReplyThreadSummaryListView.f4910j.f4971e = null;
        backstageReplyThreadSummaryListView.f4910j.notifyDataSetChanged();
        backstageReplyThreadSummaryListView.f4907g.setRefreshing(false);
        backstageReplyThreadSummaryListView.f4915o.m4563a();
        backstageReplyThreadSummaryListView.f4914n.m4492a(NavigationState.REPLY, NavigationState.MAIN_LIST);
        backstageReplyThreadSummaryListView.f4901a.m4264a(Event.CLOSE_REPLY_LIST);
    }

    public final boolean m4766a() {
        if (this.f4909i.m5716b() && ((BackstageReplyThreadView) this.f4909i.m5715a()).m4772a()) {
            return true;
        }
        Object obj;
        if (this.f4906f.f4648e == AnimationState.HIDDEN) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return false;
        }
        this.f4910j;
        return true;
    }
}
