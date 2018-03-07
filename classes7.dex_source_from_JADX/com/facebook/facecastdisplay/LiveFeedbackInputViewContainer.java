package com.facebook.facecastdisplay;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.HorizontalScrollView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.ComposerPublishServiceHelper.PublishLogger;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.facecastdisplay.LiveEventCommentComposer.LiveEventCommentComposerListener;
import com.facebook.facecastdisplay.analytics.FacecastDisplayLogger;
import com.facebook.facecastdisplay.friendInviter.LiveVideoFriendInviterDialog;
import com.facebook.facecastdisplay.friendInviter.LiveVideoInviteFriendCache;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsInputView;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsInputView.LiveReactionsListener;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: aux_action */
public class LiveFeedbackInputViewContainer extends CustomLinearLayout {
    public static final String f18855j = LiveFeedbackInputViewContainer.class.getName();
    private static final PrefKey f18856k = ((PrefKey) SharedPrefKeys.h.a("live_feedback_input_is_reactions_tap_nux_shown"));
    private static final PrefKey f18857l = ((PrefKey) SharedPrefKeys.h.a("live_feedback_input_is_reactions_swipe_nux_shown"));
    private boolean f18858A;
    private boolean f18859B;
    private boolean f18860C;
    public boolean f18861D;
    private boolean f18862E;
    private boolean f18863F;
    public float f18864G;
    public float f18865H;
    @Inject
    FacecastUtil f18866a;
    @Inject
    FbSharedPreferences f18867b;
    @Inject
    @ForUiThread
    Handler f18868c;
    @Inject
    @LoggedInUserId
    String f18869d;
    @Inject
    Lazy<PrivacyOptionsCache> f18870e;
    @Inject
    Lazy<ComposerPublishServiceHelper> f18871f;
    @Inject
    Lazy<FacecastDisplayLogger> f18872g;
    @Inject
    Toaster f18873h;
    @Inject
    LiveVideoInviteFriendCache f18874i;
    private final GlyphView f18875m;
    private final GlyphView f18876n;
    private final FbTextView f18877o;
    public final LiveEventCommentComposer f18878p;
    private final StreamingReactionsInputView f18879q;
    public final int f18880r;
    @Nullable
    private View f18881s;
    @Nullable
    private GraphQLStory f18882t;
    @Nullable
    public LiveFeedbackInputViewContainerListener f18883u;
    @Nullable
    private LiveVideoFriendInviterDialog f18884v;
    @Nullable
    private BottomSheetDialog f18885w;
    @Nullable
    public String f18886x;
    @Nullable
    public Tooltip f18887y;
    public int f18888z;

    /* compiled from: aux_action */
    class C16351 implements OnClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18846a;

        C16351(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18846a = liveFeedbackInputViewContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1069682595);
            this.f18846a.f18878p;
            Logger.a(2, EntryType.UI_INPUT_END, 352949921, a);
        }
    }

    /* compiled from: aux_action */
    class C16362 implements OnClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18847a;

        C16362(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18847a = liveFeedbackInputViewContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1151784854);
            this.f18847a.m22472g();
            Logger.a(2, EntryType.UI_INPUT_END, -849207727, a);
        }
    }

    /* compiled from: aux_action */
    class C16373 implements LiveEventCommentComposerListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18848a;

        C16373(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18848a = liveFeedbackInputViewContainer;
        }

        public final void mo1443a(String str) {
            if (this.f18848a.f18883u != null) {
                this.f18848a.f18883u.mo116a(str, this.f18848a.f18865H);
            }
        }

        public final void mo1442a() {
            this.f18848a.f18868c.removeCallbacksAndMessages(null);
            this.f18848a.f18878p.f2915i = this.f18848a.f18864G;
            this.f18848a.f18865H = this.f18848a.f18864G;
        }

        public final void mo1444b() {
            if (this.f18848a.f18861D) {
                this.f18848a.m22476i();
            }
        }
    }

    /* compiled from: aux_action */
    class C16384 implements LiveReactionsListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18849a;

        C16384(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18849a = liveFeedbackInputViewContainer;
        }

        public final void mo1445a(int i, boolean z) {
            this.f18849a.m22486n();
            if (this.f18849a.f18883u != null) {
                this.f18849a.f18883u.mo115a(i, z);
            }
        }
    }

    /* compiled from: aux_action */
    public class C16395 {
        final /* synthetic */ LiveFeedbackInputViewContainer f18850a;

        C16395(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18850a = liveFeedbackInputViewContainer;
        }

        public final void m22452a() {
            if (this.f18850a.f18861D) {
                this.f18850a.m22476i();
            }
        }
    }

    /* compiled from: aux_action */
    class C16406 implements OnMenuItemClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18851a;

        C16406(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18851a = liveFeedbackInputViewContainer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18851a.f18878p;
            return true;
        }
    }

    /* compiled from: aux_action */
    class C16417 implements OnMenuItemClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18852a;

        C16417(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18852a = liveFeedbackInputViewContainer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            LiveFeedbackInputViewContainer liveFeedbackInputViewContainer = this.f18852a;
            if (this.f18852a.f18883u != null) {
                this.f18852a.f18883u.mo117f();
            }
            return true;
        }
    }

    /* compiled from: aux_action */
    class C16428 implements OnMenuItemClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18853a;

        C16428(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18853a = liveFeedbackInputViewContainer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18853a.m22474h();
            return true;
        }
    }

    /* compiled from: aux_action */
    class C16439 implements OnMenuItemClickListener {
        final /* synthetic */ LiveFeedbackInputViewContainer f18854a;

        C16439(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
            this.f18854a = liveFeedbackInputViewContainer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardUtil.a(this.f18854a.getContext(), this.f18854a.f18886x);
            ((FacecastDisplayLogger) this.f18854a.f18872g.get()).m3309c();
            this.f18854a.f18873h.b(new ToastBuilder(2131232721));
            return true;
        }
    }

    /* compiled from: aux_action */
    public interface LiveFeedbackInputViewContainerListener {
        void mo115a(int i, boolean z);

        void mo116a(String str, float f);

        void mo117f();
    }

    private static <T extends View> void m22463a(Class<T> cls, T t) {
        m22464a((Object) t, t.getContext());
    }

    private static void m22464a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LiveFeedbackInputViewContainer) obj).m22459a(FacecastUtil.m3107b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3117), IdBasedLazy.a(injectorLike, 5272), IdBasedSingletonScopeProvider.b(injectorLike, 5743), Toaster.b(injectorLike), LiveVideoInviteFriendCache.m22625a(injectorLike));
    }

    private void m22459a(FacecastUtil facecastUtil, FbSharedPreferences fbSharedPreferences, Handler handler, String str, Lazy<PrivacyOptionsCache> lazy, Lazy<ComposerPublishServiceHelper> lazy2, Lazy<FacecastDisplayLogger> lazy3, Toaster toaster, LiveVideoInviteFriendCache liveVideoInviteFriendCache) {
        this.f18866a = facecastUtil;
        this.f18867b = fbSharedPreferences;
        this.f18868c = handler;
        this.f18869d = str;
        this.f18870e = lazy;
        this.f18871f = lazy2;
        this.f18872g = lazy3;
        this.f18873h = toaster;
        this.f18874i = liveVideoInviteFriendCache;
    }

    static /* synthetic */ void m22477i(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
    }

    public LiveFeedbackInputViewContainer(Context context) {
        this(context, null);
    }

    public LiveFeedbackInputViewContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveFeedbackInputViewContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22463a(LiveFeedbackInputViewContainer.class, (View) this);
        setContentView(2130905079);
        setOrientation(0);
        this.f18875m = (GlyphView) findViewById(2131563477);
        this.f18875m.setOnClickListener(new C16351(this));
        OnClickListener c16362 = new C16362(this);
        this.f18876n = (GlyphView) findViewById(2131563478);
        this.f18876n.setOnClickListener(c16362);
        this.f18877o = (FbTextView) findViewById(2131563479);
        this.f18877o.setOnClickListener(c16362);
        this.f18878p = (LiveEventCommentComposer) findViewById(2131563480);
        this.f18878p.f2912f = new C16373(this);
        this.f18879q = (StreamingReactionsInputView) findViewById(2131563481);
        this.f18879q.f3388j = new C16384(this);
        this.f18880r = getResources().getDimensionPixelSize(2131428181);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f18860C) {
            MarginLayoutParams marginLayoutParams;
            if (this.f18881s != null) {
                marginLayoutParams = (MarginLayoutParams) this.f18881s.getLayoutParams();
            } else {
                marginLayoutParams = null;
            }
            MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.f18878p.getLayoutParams();
            MarginLayoutParams marginLayoutParams3 = (MarginLayoutParams) this.f18879q.getLayoutParams();
            int paddingLeft = getPaddingLeft() + marginLayoutParams2.leftMargin;
            int paddingRight = (this.f18888z - getPaddingRight()) - marginLayoutParams2.rightMargin;
            if (this.f18881s != null) {
                paddingLeft += (this.f18881s.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
            }
            if (this.f18861D) {
                paddingRight -= (this.f18879q.getVisibleWidth() + marginLayoutParams3.leftMargin) - getPaddingRight();
            }
            this.f18878p.measure(MeasureSpec.makeMeasureSpec(paddingRight - paddingLeft, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = ((marginLayoutParams2.rightMargin + (this.f18878p.getMeasuredWidth() + marginLayoutParams2.leftMargin)) + getPaddingLeft()) + getPaddingRight();
            if (this.f18881s != null) {
                measuredWidth += marginLayoutParams.rightMargin + (this.f18881s.getMeasuredWidth() + marginLayoutParams.leftMargin);
            }
            if (this.f18861D) {
                measuredWidth += marginLayoutParams3.rightMargin + (this.f18879q.getMeasuredWidth() + marginLayoutParams3.leftMargin);
            }
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    measuredWidth = Math.min(size, measuredWidth);
                    break;
                case 1073741824:
                    measuredWidth = size;
                    break;
            }
            paddingLeft = MeasureSpec.getMode(i2);
            size = MeasureSpec.getSize(i2);
            mode = Math.max(getMeasuredHeight(), this.f18878p.getMeasuredHeight());
            switch (paddingLeft) {
                case Integer.MIN_VALUE:
                    size = Math.min(size, mode);
                    break;
                case 1073741824:
                    break;
                default:
                    size = mode;
                    break;
            }
            setMeasuredDimension(measuredWidth, size);
        }
    }

    public void setStory(FeedProps<GraphQLStory> feedProps) {
        boolean z;
        boolean z2 = true;
        Preconditions.a(((GraphQLStory) feedProps.a).l());
        this.f18882t = (GraphQLStory) feedProps.a;
        this.f18860C = this.f18882t.l().c();
        if (this.f18860C) {
            this.f18878p.setStory(feedProps);
            this.f18878p.setVisibility(0);
        } else {
            this.f18878p.setVisibility(8);
        }
        if (StoryAttachmentHelper.o(this.f18882t) == null || StoryAttachmentHelper.o(this.f18882t).r() == null) {
            z = true;
        } else {
            z = StoryAttachmentHelper.o(this.f18882t).r().al();
        }
        if (!(this.f18866a.m3109a() && this.f18882t.l().n() && (z || this.f18866a.m3117m()))) {
            z2 = false;
        }
        this.f18861D = z2;
        if (this.f18861D) {
            this.f18879q.setStory(this.f18882t);
            this.f18879q.setVisibility(0);
            m22476i();
        } else {
            this.f18879q.setVisibility(8);
        }
        m22462a((FeedProps) feedProps, z);
    }

    private void m22462a(FeedProps<GraphQLStory> feedProps, boolean z) {
        int i = 1;
        this.f18881s = null;
        this.f18875m.setVisibility(8);
        this.f18876n.setVisibility(8);
        this.f18877o.setVisibility(8);
        boolean z2 = m22491q() && z;
        this.f18858A = z2;
        this.f18886x = GraphQLStoryUtil.q(feedProps);
        if (m22492r() || m22493s()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f18859B = z2;
        if (!this.f18858A || this.f18859B) {
            i = 0;
        }
        if (i != 0) {
            this.f18874i.m22627a(StoryAttachmentHelper.o(this.f18882t).r().b());
            this.f18875m.setVisibility(0);
            this.f18881s = this.f18875m;
        }
        if (this.f18859B) {
            FacecastUtil facecastUtil = this.f18866a;
            boolean z3 = false;
            if (facecastUtil.f2822a.a(574, false) && facecastUtil.m3119q()) {
                z3 = true;
            }
            if (z3) {
                this.f18877o.setVisibility(0);
                this.f18881s = this.f18877o;
            } else {
                this.f18876n.setVisibility(0);
                this.f18881s = this.f18876n;
            }
        }
        this.f18878p.f2914h = z;
    }

    public final void m22494a() {
        if (this.f18878p.getVisibility() == 0) {
            this.f18878p.m3199a();
        }
    }

    public final void m22495b() {
        this.f18868c.removeCallbacksAndMessages(null);
        this.f18878p.m3200b();
        if (!(this.f18884v == null || this.f18884v.f == null || !this.f18884v.f.isShowing())) {
            this.f18884v.a();
        }
        if (this.f18885w != null) {
            this.f18885w.dismiss();
        }
    }

    public void setParentViewWidthSize(int i) {
        this.f18888z = i;
    }

    public void setListener(LiveFeedbackInputViewContainerListener liveFeedbackInputViewContainerListener) {
        this.f18883u = liveFeedbackInputViewContainerListener;
    }

    public void setVideoTime(float f) {
        this.f18864G = f;
        if (this.f18879q != null) {
            this.f18879q.f3392n = f;
        }
    }

    public final void m22496c() {
        if (this.f18861D) {
            m22488o();
        }
    }

    public final boolean m22497d() {
        return this.f18861D;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            this.f18868c.removeCallbacksAndMessages(null);
            if (this.f18887y != null) {
                this.f18887y.l();
                this.f18887y = null;
            }
            this.f18878p.m3200b();
        }
    }

    public static void m22471f(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(liveFeedbackInputViewContainer.getContext(), FragmentManagerHost.class);
        if (fragmentManagerHost != null && liveFeedbackInputViewContainer.f18882t != null && StoryAttachmentHelper.o(liveFeedbackInputViewContainer.f18882t) != null && StoryAttachmentHelper.o(liveFeedbackInputViewContainer.f18882t).r() != null && fragmentManagerHost.kO_().a("live_video_invite_friend_dialog") == null) {
            liveFeedbackInputViewContainer.f18884v = new LiveVideoFriendInviterDialog();
            liveFeedbackInputViewContainer.f18884v.am = StoryAttachmentHelper.o(liveFeedbackInputViewContainer.f18882t).r().b();
            if (liveFeedbackInputViewContainer.f18882t.aJ() != null) {
                liveFeedbackInputViewContainer.f18884v.ao = liveFeedbackInputViewContainer.f18882t.aJ().b();
                if (liveFeedbackInputViewContainer.f18882t.aJ().j() != null) {
                    liveFeedbackInputViewContainer.f18884v.ap = liveFeedbackInputViewContainer.f18882t.aJ().j().g();
                }
            }
            liveFeedbackInputViewContainer.f18884v.a(fragmentManagerHost.kO_().a(), "live_video_invite_friend_dialog", true);
            liveFeedbackInputViewContainer.f18884v.an = new C16395(liveFeedbackInputViewContainer);
            liveFeedbackInputViewContainer.f18868c.removeCallbacksAndMessages(null);
        }
    }

    private void m22472g() {
        if (this.f18885w == null) {
            Context context = getContext();
            this.f18885w = new BottomSheetDialog(context);
            Adapter bottomSheetAdapter = new BottomSheetAdapter(context);
            if (this.f18858A) {
                int i;
                if (m22490p()) {
                    i = 2131232706;
                } else {
                    i = 2131232705;
                }
                bottomSheetAdapter.e(i).setIcon(2130839877).setOnMenuItemClickListener(new C16406(this));
            }
            if (this.f18866a.f2822a.a(602, false)) {
                bottomSheetAdapter.e(2131232707).a(2131232708).setIcon(2130843652).setOnMenuItemClickListener(new C16417(this));
            }
            if (m22492r()) {
                MenuItemImpl e = bottomSheetAdapter.e(2131232714);
                e.setIcon(2130840082).setOnMenuItemClickListener(new C16428(this));
                GraphQLPrivacyOptionType a = PrivacyOptionHelper.a(((PrivacyOptionsCache) this.f18870e.get()).a());
                if (a == GraphQLPrivacyOptionType.EVERYONE) {
                    e.a(2131232715);
                } else if (a == GraphQLPrivacyOptionType.FRIENDS) {
                    e.a(2131232716);
                }
            }
            if (m22493s()) {
                bottomSheetAdapter.e(2131232720).setIcon(2130839954).setOnMenuItemClickListener(new C16439(this));
            }
            this.f18885w.m19815a(bottomSheetAdapter);
        }
        if (!this.f18885w.isShowing()) {
            this.f18885w.show();
        }
    }

    private void m22474h() {
        long parseLong = Long.parseLong(this.f18869d);
        GraphQLPrivacyOption a = ((PrivacyOptionsCache) this.f18870e.get()).a();
        String uuid = SafeUUIDGenerator.a().toString();
        Builder builder = new Builder();
        builder.b = parseLong;
        builder = builder;
        builder.j = parseLong;
        Builder builder2 = builder;
        builder2.k = this.f18882t.av();
        builder2 = builder2;
        builder2.g = a.c();
        Builder builder3 = builder2;
        builder3.G = uuid;
        builder3 = builder3;
        builder3.p = ComposerType.SHARE;
        PublishPostParams a2 = builder3.a();
        Intent intent = new Intent();
        intent.putExtra("publishPostParams", a2);
        ((ComposerPublishServiceHelper) this.f18871f.get()).a(intent, new PublishLogger(this) {
            final /* synthetic */ LiveFeedbackInputViewContainer f18841a;

            {
                this.f18841a = r1;
            }

            public final void m22442a(PublishPostParams publishPostParams) {
                this.f18841a.f18873h.b(new ToastBuilder(2131234541));
                ((FacecastDisplayLogger) this.f18841a.f18872g.get()).m3307a();
            }

            public final void m22445b(PublishPostParams publishPostParams) {
            }

            public final void m22443a(String str, PublishPostParams publishPostParams) {
            }

            public final void m22444a(String str, PublishPostParams publishPostParams, ServiceException serviceException) {
                BLog.b(LiveFeedbackInputViewContainer.f18855j, "Share live video failed");
                ((FacecastDisplayLogger) this.f18841a.f18872g.get()).m3308b();
            }
        });
    }

    private void m22476i() {
        if (isEnabled()) {
            this.f18862E = this.f18867b.a(f18856k, false);
            this.f18863F = this.f18867b.a(f18857l, false);
            if (!this.f18862E) {
                m22478j();
            } else if (!this.f18863F) {
                m22481k();
            }
        }
    }

    private void m22478j() {
        HandlerDetour.b(this.f18868c, new Runnable(this) {
            final /* synthetic */ LiveFeedbackInputViewContainer f18842a;

            {
                this.f18842a = r1;
            }

            public void run() {
                this.f18842a.m22482l();
            }
        }, 5000, -1824938766);
    }

    private void m22481k() {
        HandlerDetour.b(this.f18868c, new Runnable(this) {
            final /* synthetic */ LiveFeedbackInputViewContainer f18843a;

            {
                this.f18843a = r1;
            }

            public void run() {
                this.f18843a.m22458a(this.f18843a.f18880r, 0);
                this.f18843a.f18880r;
            }
        }, 10000, -2134045214);
    }

    private void m22482l() {
        this.f18887y = new Tooltip(getContext(), 2);
        this.f18887y.b(2131232702);
        this.f18887y.c(this.f18879q.getLeftMostReactionView());
        this.f18887y.H = new OnDismissListener(this) {
            final /* synthetic */ LiveFeedbackInputViewContainer f18844a;

            {
                this.f18844a = r1;
            }

            public final boolean m22446a(PopoverWindow popoverWindow) {
                this.f18844a.m22486n();
                this.f18844a.f18887y = null;
                return true;
            }
        };
        this.f18887y.d();
    }

    public static void m22485m(LiveFeedbackInputViewContainer liveFeedbackInputViewContainer) {
        liveFeedbackInputViewContainer.f18887y = new Tooltip(liveFeedbackInputViewContainer.getContext(), 2);
        liveFeedbackInputViewContainer.f18887y.b(2131232703);
        liveFeedbackInputViewContainer.f18887y.c((View) liveFeedbackInputViewContainer.getParent());
        liveFeedbackInputViewContainer.f18887y.H = new OnDismissListener(liveFeedbackInputViewContainer) {
            final /* synthetic */ LiveFeedbackInputViewContainer f18845a;

            {
                this.f18845a = r1;
            }

            public final boolean m22447a(PopoverWindow popoverWindow) {
                this.f18845a.m22458a(0, 0);
                this.f18845a.m22488o();
                this.f18845a.f18887y = null;
                return true;
            }
        };
        liveFeedbackInputViewContainer.f18887y.d();
    }

    private void m22486n() {
        if (!this.f18862E) {
            this.f18868c.removeCallbacksAndMessages(null);
            this.f18867b.edit().putBoolean(f18856k, true).commit();
            this.f18862E = true;
        }
        if (!this.f18863F) {
            this.f18868c.removeCallbacksAndMessages(null);
            m22481k();
        }
    }

    private void m22488o() {
        this.f18868c.removeCallbacksAndMessages(null);
        if (!this.f18863F) {
            this.f18867b.edit().putBoolean(f18857l, true).commit();
            this.f18863F = true;
            m22486n();
        }
    }

    private void m22458a(int i, int i2) {
        if (getParent() instanceof HorizontalScrollView) {
            ((HorizontalScrollView) getParent()).smoothScrollTo(i, i2);
        }
    }

    private boolean m22490p() {
        return (this.f18882t == null || this.f18882t.aJ() == null || this.f18882t.aJ().j() == null || this.f18882t.aJ().j().g() != 69076575) ? false : true;
    }

    private boolean m22491q() {
        if (this.f18882t != null && this.f18882t.aJ() != null && this.f18882t.aJ().j().g() == 67338874) {
            return false;
        }
        FacecastUtil facecastUtil = this.f18866a;
        boolean z = false;
        if (facecastUtil.f2822a.a(599, false) && facecastUtil.f2823b != Product.PAA) {
            z = true;
        }
        return z;
    }

    private boolean m22492r() {
        return (!this.f18866a.m3119q() || this.f18882t == null || this.f18882t.av() == null) ? false : true;
    }

    private boolean m22493s() {
        return this.f18866a.m3119q() && this.f18886x != null;
    }
}
