package com.facebook.facecast.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Product;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveEventAuthor;
import com.facebook.facecastdisplay.LiveEventCommentDialogFragment;
import com.facebook.facecastdisplay.LiveEventCommentDialogFragment.CommentDialogFragmentListener;
import com.facebook.facecastdisplay.friendInviter.LiveVideoFriendInviterDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: broadcast_comment_dialog */
public class FacecastToolbarContainer extends CustomLinearLayout {
    public static boolean f18531f = false;
    private static final PrefKey f18532g = ((PrefKey) SharedPrefKeys.h.a("tip_jar_bottom_sheet_nux_shown"));
    @Inject
    FacecastUtil f18533a;
    @Inject
    FeedbackControllerProvider f18534b;
    @Inject
    QeAccessor f18535c;
    @Inject
    Lazy<GraphQLActorCache> f18536d;
    @Inject
    TipSeenTracker f18537e;
    private final GlyphView f18538h;
    private final GlyphView f18539i;
    private final GlyphView f18540j;
    public final Tooltip f18541k;
    @Nullable
    public String f18542l;
    @Nullable
    public ComposerTargetData f18543m;
    @Nullable
    public LiveVideoFriendInviterDialog f18544n;
    @Nullable
    public LiveEventCommentDialogFragment f18545o;
    @Nullable
    private GraphQLFeedback f18546p;
    @Nullable
    public OnBroadcasterPostCommentListener f18547q;
    public int f18548r;
    @Nullable
    private List<SavedComment> f18549s;
    @Nullable
    private BottomSheetDialog f18550t;
    private LiveEventAuthor f18551u;

    /* compiled from: broadcast_comment_dialog */
    public interface OnBroadcasterPostCommentListener {
        void mo1411a(String str, int i, LiveEventAuthor liveEventAuthor);
    }

    /* compiled from: broadcast_comment_dialog */
    class C15911 implements OnClickListener {
        final /* synthetic */ FacecastToolbarContainer f18523a;

        C15911(FacecastToolbarContainer facecastToolbarContainer) {
            this.f18523a = facecastToolbarContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2501490);
            FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(this.f18523a.getContext(), FragmentManagerHost.class);
            if (fragmentManagerHost == null || fragmentManagerHost.kO_().a("broadcast_invite_friend_dialog") != null) {
                Logger.a(2, EntryType.UI_INPUT_END, -2106370205, a);
                return;
            }
            if (this.f18523a.f18544n == null) {
                this.f18523a.f18544n = new LiveVideoFriendInviterDialog();
                this.f18523a.f18544n.am = this.f18523a.f18542l;
                if (this.f18523a.f18543m != null) {
                    this.f18523a.f18544n.ao = String.valueOf(this.f18523a.f18543m.targetId);
                    if (this.f18523a.f18543m.targetType == TargetType.GROUP) {
                        this.f18523a.f18544n.ap = 69076575;
                    }
                }
            }
            this.f18523a.f18544n.a(fragmentManagerHost.kO_().a(), "broadcast_invite_friend_dialog", true);
            LogUtils.a(-830395677, a);
        }
    }

    /* compiled from: broadcast_comment_dialog */
    class C15932 implements OnClickListener {
        final /* synthetic */ FacecastToolbarContainer f18525a;

        /* compiled from: broadcast_comment_dialog */
        class C15921 implements CommentDialogFragmentListener {
            final /* synthetic */ C15932 f18524a;

            C15921(C15932 c15932) {
                this.f18524a = c15932;
            }

            public final void mo128a(String str) {
                int i = this.f18524a.f18525a.f18548r;
                this.f18524a.f18525a.m22155a(str, i);
                if (this.f18524a.f18525a.f18547q != null) {
                    this.f18524a.f18525a.f18547q.mo1411a(str, i, FacecastToolbarContainer.getCommentAuthorAuthor(this.f18524a.f18525a));
                }
            }

            public final void mo127a() {
            }
        }

        C15932(FacecastToolbarContainer facecastToolbarContainer) {
            this.f18525a = facecastToolbarContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 486296230);
            FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(this.f18525a.getContext(), FragmentManagerHost.class);
            if (fragmentManagerHost == null || fragmentManagerHost.kO_().a("broadcast_comment_dialog") != null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1289988667, a);
                return;
            }
            if (this.f18525a.f18545o == null) {
                this.f18525a.f18545o = new LiveEventCommentDialogFragment();
                this.f18525a.f18545o.as = new C15921(this);
            }
            this.f18525a.f18545o.a(fragmentManagerHost.kO_().a(), "broadcast_comment_dialog", true);
            LogUtils.a(1951169092, a);
        }
    }

    /* compiled from: broadcast_comment_dialog */
    class C15943 implements OnClickListener {
        final /* synthetic */ FacecastToolbarContainer f18526a;

        C15943(FacecastToolbarContainer facecastToolbarContainer) {
            this.f18526a = facecastToolbarContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1641725624);
            FacecastToolbarContainer.getCommentAuthorAuthor(this.f18526a);
            Logger.a(2, EntryType.UI_INPUT_END, -2096722141, a);
        }
    }

    /* compiled from: broadcast_comment_dialog */
    class C15954 implements OnMenuItemClickListener {
        final /* synthetic */ FacecastToolbarContainer f18527a;

        C15954(FacecastToolbarContainer facecastToolbarContainer) {
            this.f18527a = facecastToolbarContainer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            boolean z;
            if (FacecastToolbarContainer.f18531f) {
                z = false;
            } else {
                z = true;
            }
            FacecastToolbarContainer.f18531f = z;
            return true;
        }
    }

    /* compiled from: broadcast_comment_dialog */
    class C15965 implements OnTooltipClickListener {
        final /* synthetic */ FacecastToolbarContainer f18528a;

        C15965(FacecastToolbarContainer facecastToolbarContainer) {
            this.f18528a = facecastToolbarContainer;
        }

        public final void m22147a() {
            this.f18528a.f18541k.l();
            this.f18528a.f18537e.b();
            FacecastToolbarContainer.getCommentAuthorAuthor(this.f18528a);
        }
    }

    /* compiled from: broadcast_comment_dialog */
    class SavedComment {
        public final String f18529a;
        public final int f18530b;

        public SavedComment(String str, int i) {
            this.f18529a = str;
            this.f18530b = i;
        }
    }

    private static <T extends View> void m22153a(Class<T> cls, T t) {
        m22154a((Object) t, t.getContext());
    }

    private static void m22154a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacecastToolbarContainer) obj).m22152a(FacecastUtil.m3107b(fbInjector), (FeedbackControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 262), TipSeenTracker.b(fbInjector));
    }

    private void m22152a(FacecastUtil facecastUtil, FeedbackControllerProvider feedbackControllerProvider, QeAccessor qeAccessor, Lazy<GraphQLActorCache> lazy, TipSeenTracker tipSeenTracker) {
        this.f18533a = facecastUtil;
        this.f18534b = feedbackControllerProvider;
        this.f18535c = qeAccessor;
        this.f18536d = lazy;
        this.f18537e = tipSeenTracker;
    }

    public FacecastToolbarContainer(Context context) {
        this(context, null);
    }

    public FacecastToolbarContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastToolbarContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22153a(FacecastToolbarContainer.class, (View) this);
        setContentView(2130904232);
        this.f18538h = (GlyphView) a(2131561718);
        this.f18539i = (GlyphView) a(2131561719);
        m22163d();
        this.f18540j = (GlyphView) a(2131561721);
        m22167f();
        this.f18541k = new Tooltip(context, 2);
        this.f18541k.c(this.f18540j);
        m22170h();
    }

    public final void m22174a(String str, ComposerTargetData composerTargetData) {
        this.f18542l = str;
        this.f18543m = composerTargetData;
        m22161c();
    }

    public void setFeedback(GraphQLFeedback graphQLFeedback) {
        this.f18546p = graphQLFeedback;
        m22165e();
    }

    private void m22161c() {
        FacecastUtil facecastUtil = this.f18533a;
        boolean z = false;
        if (facecastUtil.f2822a.a(587, false) && facecastUtil.f2823b != Product.PAA) {
            z = true;
        }
        if (!z || (this.f18543m != null && TargetType.PAGE == this.f18543m.targetType)) {
            this.f18538h.setVisibility(8);
            return;
        }
        this.f18538h.setVisibility(0);
        this.f18538h.setOnClickListener(new C15911(this));
    }

    private void m22163d() {
        if (this.f18533a.f2822a.a(586, false)) {
            this.f18539i.setVisibility(0);
            this.f18539i.setOnClickListener(new C15932(this));
            return;
        }
        this.f18539i.setVisibility(8);
    }

    private void m22155a(String str, int i) {
        if (this.f18546p == null) {
            if (this.f18549s == null) {
                this.f18549s = new ArrayList();
            }
            this.f18549s.add(new SavedComment(str, i));
            return;
        }
        m22158b(str, i);
    }

    private void m22165e() {
        if (!CollectionUtil.a(this.f18549s) && this.f18546p != null) {
            for (SavedComment savedComment : this.f18549s) {
                m22158b(savedComment.f18529a, savedComment.f18530b);
            }
            this.f18549s = null;
        }
    }

    private void m22158b(String str, int i) {
        if (this.f18546p != null) {
            this.f18534b.m5074a(FeedbackControllerParams.f4498a).m5068a(new PendingCommentInputEntry(this.f18546p.z_(), this.f18546p.j(), str, false, false, null, null, true, i), this.f18546p, null);
        }
    }

    public static LiveEventAuthor getCommentAuthorAuthor(FacecastToolbarContainer facecastToolbarContainer) {
        if (facecastToolbarContainer.f18551u != null) {
            return facecastToolbarContainer.f18551u;
        }
        if (facecastToolbarContainer.f18543m == null || TargetType.PAGE != facecastToolbarContainer.f18543m.targetType) {
            GraphQLActor a = ((GraphQLActorCacheImpl) facecastToolbarContainer.f18536d.get()).a();
            if (a != null) {
                facecastToolbarContainer.f18551u = LiveEventAuthor.m3184a(a);
            }
        } else {
            facecastToolbarContainer.f18551u = new LiveEventAuthor(facecastToolbarContainer.f18543m.targetName, String.valueOf(facecastToolbarContainer.f18543m.targetId), false);
        }
        return facecastToolbarContainer.f18551u;
    }

    public void setTimeElapsed(long j) {
        this.f18548r = (int) (j / 1000);
    }

    public void setPostCommentListener(@Nullable OnBroadcasterPostCommentListener onBroadcasterPostCommentListener) {
        this.f18547q = onBroadcasterPostCommentListener;
    }

    public final void m22173a() {
        if (this.f18544n != null) {
            this.f18544n.b();
        }
        if (this.f18545o != null) {
            this.f18545o.b();
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m22167f() {
        if (this.f18535c.a(ExperimentsForFacecastAbtestModule.f2786g, false)) {
            this.f18540j.setVisibility(0);
            this.f18540j.setOnClickListener(new C15943(this));
            return;
        }
        this.f18540j.setVisibility(8);
    }

    public static void m22169g(FacecastToolbarContainer facecastToolbarContainer) {
        int i;
        int i2;
        int i3;
        if (facecastToolbarContainer.f18550t == null) {
            facecastToolbarContainer.f18550t = new BottomSheetDialog(facecastToolbarContainer.getContext());
        }
        if (f18531f) {
            i = 2131238298;
            i2 = 2131238299;
            i3 = 2130839920;
        } else {
            i = 2131238300;
            i2 = 2131238301;
            i3 = 2130843652;
        }
        Adapter bottomSheetAdapter = new BottomSheetAdapter(facecastToolbarContainer.getContext());
        bottomSheetAdapter.e(i).a(i2).setIcon(i3).setOnMenuItemClickListener(new C15954(facecastToolbarContainer));
        facecastToolbarContainer.f18550t.m19815a(bottomSheetAdapter);
        if (!facecastToolbarContainer.f18550t.isShowing()) {
            facecastToolbarContainer.f18550t.show();
        }
    }

    private void m22170h() {
        this.f18541k.a(2131238300);
        this.f18541k.b(2131238301);
        this.f18537e.b = 2;
        this.f18537e.a(f18532g);
        if (this.f18537e.c() && !f18531f && this.f18540j.getVisibility() == 0) {
            this.f18541k.a(new C15965(this));
            this.f18537e.a();
            this.f18541k.d();
        }
    }
}
