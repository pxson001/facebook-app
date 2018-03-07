package com.facebook.feedback.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.GestureDetectorCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.attachments.ui.AttachmentsSection;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.ui.util.CombinedDrawable;
import com.facebook.common.ui.util.CombinedDrawable.Align;
import com.facebook.common.ui.util.CombinedDrawable.Combine;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.flyout.renderer.FeedFlyoutRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.conversion.ActorToProfileConverter;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.translation.ui.TranslatableTextView;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.flyout.renderer.IFlyoutRenderer;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilder.Delegate;
import com.facebook.ufiservices.flyout.views.CommentMetadataView;
import com.facebook.ufiservices.flyout.views.ThreadedCommentView;
import com.facebook.ufiservices.module.AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider;
import com.facebook.ufiservices.ui.FbCommentView;
import com.facebook.ufiservices.ui.UfiSupportedAttachmentStyle;
import com.facebook.ufiservices.util.CommentMenuHelper;
import com.facebook.ufiservices.util.CommentMenuHelper.OnCommentClickListener;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.work.groups.multicompany.bridge.DefaultMultiCompanyGroupIconProvider;
import com.facebook.work.groups.multicompany.bridge.MultiCompanyGroupIconProvider;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: second_value_description */
public class CommentView extends ImageBlockLayout implements FbCommentView, OnCommentClickListener {
    public static final PrefKey f4304h = ((PrefKey) SharedPrefKeys.c.a("flyout_comment_view/"));
    private static final CallerContext f4305s = CallerContext.a(CommentView.class, "story_feedback_flyout");
    private AttachmentsSection f4306A;
    private int f4307B;
    public ActionListener f4308C;
    public NavigationListener f4309D;
    public FeedProps<GraphQLComment> f4310E;
    private GestureDetectorCompat f4311F;
    private OnLongClickListener f4312G;
    public FeedbackLoggingParams f4313H;
    public boolean f4314I;
    private CommentOrderType f4315J;
    private Map<String, SpannableStringBuilder> f4316K;
    private final OnClickListener f4317L;
    private final com.facebook.ufiservices.flyout.views.ThreadedCommentView.NavigationListener f4318M;
    private final Delegate f4319N;
    @Inject
    IFlyoutRenderer f4320i;
    @Inject
    LinkifyUtil f4321j;
    @Inject
    AbstractFbErrorReporter f4322k;
    @Inject
    EmojiUtil f4323l;
    @Inject
    Lazy<CommentMenuHelper> f4324m;
    @UfiSupportedAttachmentStyle
    @Inject
    AttachmentStyleUtil f4325n;
    @Inject
    CommentBackgroundUtil f4326o;
    @Inject
    FeedbackAnalyticsLogger f4327p;
    @Inject
    PendingCommentCache f4328q;
    @Inject
    Lazy<MultiCompanyGroupIconProvider> f4329r;
    private FbDraweeView f4330t;
    private TextView f4331u;
    public TranslatableTextView f4332v;
    private CommentMetadataView f4333w;
    private TextView f4334x;
    private View f4335y;
    private ThreadedCommentView f4336z;

    /* compiled from: second_value_description */
    class C03881 implements OnClickListener {
        final /* synthetic */ CommentView f4295a;

        C03881(CommentView commentView) {
            this.f4295a = commentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1425512526);
            if (GraphQLHelper.b((GraphQLComment) this.f4295a.f4310E.a)) {
                this.f4295a.f4308C.mo275a((GraphQLComment) this.f4295a.f4310E.a, this.f4295a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2051097257, a);
        }
    }

    /* compiled from: second_value_description */
    class C03892 implements com.facebook.ufiservices.flyout.views.ThreadedCommentView.NavigationListener {
        final /* synthetic */ CommentView f4296a;

        C03892(CommentView commentView) {
            this.f4296a = commentView;
        }

        public final void m4888a() {
            this.f4296a.f4327p.f(this.f4296a.f4313H);
            this.f4296a.f4309D.mo271b((GraphQLComment) this.f4296a.f4310E.a, this.f4296a.f4313H);
        }

        public final void m4889a(GraphQLComment graphQLComment) {
            this.f4296a.f4327p.e(this.f4296a.f4313H);
            this.f4296a.f4309D.mo269a((GraphQLComment) this.f4296a.f4310E.a, graphQLComment, this.f4296a.f4313H);
        }

        public final void m4890b() {
            this.f4296a.f4309D.mo268a((GraphQLComment) this.f4296a.f4310E.a, this.f4296a.f4313H);
        }
    }

    /* compiled from: second_value_description */
    class C03903 implements Delegate {
        final /* synthetic */ CommentView f4297a;

        C03903(CommentView commentView) {
            this.f4297a = commentView;
        }

        public final void m4891a(View view) {
            this.f4297a.f4309D.mo270b((GraphQLComment) this.f4297a.f4310E.a);
        }

        public final void m4894b(View view) {
            this.f4297a.f4308C.mo273a((GraphQLComment) this.f4297a.f4310E.a);
        }

        public final void m4892a(View view, FeedbackReaction feedbackReaction) {
        }

        public final void m4895c(View view) {
            this.f4297a.f4309D.mo272c((GraphQLComment) this.f4297a.f4310E.a);
        }

        public final void m4896d(View view) {
        }

        public final void m4897e(View view) {
            this.f4297a.f4309D.mo268a((GraphQLComment) this.f4297a.f4310E.a, this.f4297a.f4313H);
        }

        public final void m4893a(View view, String str, String str2) {
            this.f4297a.f4309D.mo267a((GraphQLComment) this.f4297a.f4310E.a, this.f4297a.getContext(), str, str2);
        }
    }

    /* compiled from: second_value_description */
    class C03914 implements OnLongClickListener {
        final /* synthetic */ CommentView f4298a;

        C03914(CommentView commentView) {
            this.f4298a = commentView;
        }

        public boolean onLongClick(View view) {
            this.f4298a.cancelLongPress();
            this.f4298a.f4332v.cancelLongPress();
            this.f4298a.f4327p.g(this.f4298a.f4313H);
            ((CommentMenuHelper) this.f4298a.f4324m.get()).a((GraphQLComment) this.f4298a.f4310E.a, this.f4298a, this.f4298a.getContext(), this.f4298a);
            return true;
        }
    }

    /* compiled from: second_value_description */
    class C03936 implements OnClickListener {
        final /* synthetic */ CommentView f4301a;

        C03936(CommentView commentView) {
            this.f4301a = commentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 217218812);
            CommentView.m4932q(this.f4301a);
            Logger.a(2, EntryType.UI_INPUT_END, -409281644, a);
        }
    }

    /* compiled from: second_value_description */
    /* synthetic */ class C03947 {
        static final /* synthetic */ int[] f4302a = new int[GraphQLFeedOptimisticPublishState.values().length];

        static {
            try {
                f4302a[GraphQLFeedOptimisticPublishState.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4302a[GraphQLFeedOptimisticPublishState.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: second_value_description */
    public interface ActionListener extends Bindable<GraphQLFeedback> {
        void mo273a(GraphQLComment graphQLComment);

        void mo274a(GraphQLComment graphQLComment, Context context);

        void mo275a(GraphQLComment graphQLComment, FbCommentView fbCommentView);

        void mo276a(String str, GraphQLComment graphQLComment, Context context);

        void mo277b(GraphQLComment graphQLComment);

        void mo278b(GraphQLComment graphQLComment, Context context);
    }

    /* compiled from: second_value_description */
    class GestureListener extends SimpleOnGestureListener {
        final /* synthetic */ CommentView f4303a;

        public GestureListener(CommentView commentView) {
            this.f4303a = commentView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.f4303a.dispatchTouchEvent(obtain);
            obtain.recycle();
        }
    }

    /* compiled from: second_value_description */
    public interface NavigationListener extends Bindable<GraphQLFeedback> {
        void mo266a(GraphQLComment graphQLComment);

        void mo267a(GraphQLComment graphQLComment, Context context, String str, String str2);

        void mo268a(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams);

        void mo269a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, FeedbackLoggingParams feedbackLoggingParams);

        void mo270b(GraphQLComment graphQLComment);

        void mo271b(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams);

        void mo272c(GraphQLComment graphQLComment);
    }

    private static <T extends View> void m4914a(Class<T> cls, T t) {
        m4915a((Object) t, t.getContext());
    }

    private static void m4915a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CommentView) obj).m4913a((IFlyoutRenderer) FeedFlyoutRenderer.m22719b(injectorLike), LinkifyUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), EmojiUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 11480), AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider.a(injectorLike), CommentBackgroundUtil.m4807a(injectorLike), FeedbackAnalyticsLogger.a(injectorLike), PendingCommentCache.a(injectorLike), IdBasedLazy.a(injectorLike, 11777));
    }

    private void m4913a(IFlyoutRenderer iFlyoutRenderer, LinkifyUtil linkifyUtil, FbErrorReporter fbErrorReporter, EmojiUtil emojiUtil, Lazy<CommentMenuHelper> lazy, AttachmentStyleUtil attachmentStyleUtil, CommentBackgroundUtil commentBackgroundUtil, FeedbackAnalyticsLogger feedbackAnalyticsLogger, PendingCommentCache pendingCommentCache, Lazy<MultiCompanyGroupIconProvider> lazy2) {
        this.f4320i = iFlyoutRenderer;
        this.f4321j = linkifyUtil;
        this.f4322k = fbErrorReporter;
        this.f4323l = emojiUtil;
        this.f4324m = lazy;
        this.f4325n = attachmentStyleUtil;
        this.f4326o = commentBackgroundUtil;
        this.f4327p = feedbackAnalyticsLogger;
        this.f4328q = pendingCommentCache;
        this.f4329r = lazy2;
    }

    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4314I = true;
        this.f4317L = new C03881(this);
        this.f4318M = new C03892(this);
        this.f4319N = new C03903(this);
        m4914a(CommentView.class, (View) this);
        this.f4311F = new GestureDetectorCompat(getContext(), new GestureListener(this));
        setContentView(2130903629);
        setThumbnailPadding(getResources().getDimensionPixelSize(2131428721));
        this.f4330t = (FbDraweeView) getView(2131560426);
        this.f4331u = (TextView) getView(2131560441);
        this.f4332v = (TranslatableTextView) getView(2131560442);
        this.f4333w = (CommentMetadataView) getView(2131560444);
        this.f4331u.setMovementMethod(LinkMovementMethod.getInstance());
        this.f4331u.setFocusable(false);
        this.f4332v.setFocusable(true);
        this.f4333w.setSoundEffectsEnabled(false);
        this.f4312G = new C03914(this);
        this.f4332v.setOnLongClickListener(this.f4312G);
        setOnLongClickListener(this.f4312G);
        setBackgroundDrawable(this.f4326o.m4813a(context));
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773278, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{16842904});
        this.f4307B = obtainStyledAttributes.getResourceId(0, 2131361848);
        obtainStyledAttributes.recycle();
    }

    public final void m4940a(GraphQLComment graphQLComment) {
        this.f4308C.mo274a(graphQLComment, getContext());
    }

    public final void m4942a(String str, GraphQLComment graphQLComment) {
        this.f4308C.mo276a(str, graphQLComment, getContext());
    }

    public final void m4943b(GraphQLComment graphQLComment) {
        this.f4309D.mo266a(graphQLComment);
    }

    public final void m4944c(GraphQLComment graphQLComment) {
        ClipboardUtil.a(getContext(), graphQLComment.s().a());
    }

    public final void m4945d(GraphQLComment graphQLComment) {
        this.f4308C.mo278b(graphQLComment, getContext());
    }

    public final void m4939a(ActionListener actionListener, NavigationListener navigationListener) {
        this.f4308C = actionListener;
        this.f4309D = navigationListener;
    }

    public void setThreadedCommentsEnabled(boolean z) {
        this.f4314I = z;
    }

    public void setIsPressed(boolean z) {
    }

    public final void m4941a(DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        if (defaultTextWithEntitiesLongFieldsModel != null) {
            GraphQLComment graphQLComment = (GraphQLComment) this.f4310E.a;
            GraphQLTextWithEntities a = DefaultGraphQLConversionHelper.m5800a((DefaultTextWithEntitiesLongFields) defaultTextWithEntitiesLongFieldsModel);
            Spannable a2 = this.f4321j.a(LinkifyUtilConverter.c(a), true, null);
            CharSequence a3 = (a2 == null || a2.length() == 0) ? a.a() : LinkifyUtil.a(a2);
            CharSequence spannableStringBuilder = new SpannableStringBuilder(a3);
            this.f4323l.a(spannableStringBuilder, (int) this.f4332v.getTextSize());
            if (this.f4332v.b(spannableStringBuilder, GraphQLHelper.a(graphQLComment))) {
                this.f4316K.put(graphQLComment.y(), spannableStringBuilder);
            } else {
                this.f4316K.remove(graphQLComment.y());
            }
        }
    }

    public final void m4937a() {
        this.f4332v.a();
    }

    public CharSequence getContentDescription() {
        Object obj = (this.f4334x == null || this.f4334x.getVisibility() != 0) ? null : 1;
        return StringFormatUtil.formatStrLocaleSafe("%s %s %s", this.f4331u.getContentDescription(), this.f4332v.getContentDescription(), obj != null ? this.f4334x.getContentDescription() : this.f4333w.getContentDescription());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 528706177);
        super.onTouchEvent(motionEvent);
        this.f4311F.a(motionEvent);
        Drawable background = getBackground();
        switch (motionEvent.getAction()) {
            case 0:
                CommentBackgroundUtil.m4808a(background);
                break;
            case 1:
            case 3:
                CommentBackgroundUtil.m4812c(background);
                break;
        }
        LogUtils.a(-61138670, a);
        return true;
    }

    public final void m4938a(FeedProps<GraphQLComment> feedProps, FeedbackLoggingParams feedbackLoggingParams, CommentOrderType commentOrderType, Map<String, SpannableStringBuilder> map) {
        this.f4310E = feedProps;
        this.f4315J = commentOrderType;
        this.f4313H = feedbackLoggingParams;
        this.f4316K = map;
        m4922g();
        m4923h();
        m4924i();
        m4926k();
        m4928m();
        m4929n();
        m4930o();
        m4931p();
        CommentBackgroundUtil.m4812c(getBackground());
    }

    public final void m4946f() {
        CommentBackgroundUtil.m4811b(getBackground());
    }

    private void m4922g() {
        GraphQLComment graphQLComment = (GraphQLComment) this.f4310E.a;
        if (graphQLComment.r() == null) {
            this.f4330t.a(null, f4305s);
            this.f4331u.setText("");
            this.f4330t.setOnClickListener(null);
            return;
        }
        if (graphQLComment.r().ai() != null) {
            this.f4330t.a(Uri.parse(graphQLComment.r().ai().b()), f4305s);
        }
        this.f4331u.setText(LinkifyUtil.a(this.f4321j.a(LinkifyTargetBuilder.a(graphQLComment.r()), null, this.f4307B, false)));
        GraphQLProfile a = ActorToProfileConverter.a(graphQLComment.r());
        if (a == null) {
            this.f4322k.a("flyout_actor_conversion_failed", "Actor type is: " + graphQLComment.r().b() + " " + graphQLComment.r().aw());
            this.f4330t.setOnClickListener(null);
            return;
        }
        this.f4320i.a(this.f4330t, a, null);
    }

    private void m4923h() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        GraphQLComment graphQLComment = (GraphQLComment) this.f4310E.a;
        Drawable drawable4 = graphQLComment.A() ? getResources().getDrawable(2130843879) : null;
        if (graphQLComment.C()) {
            drawable = getResources().getDrawable(2130840063);
        } else {
            drawable = null;
        }
        if (m4920e(graphQLComment)) {
            DefaultMultiCompanyGroupIconProvider defaultMultiCompanyGroupIconProvider = (DefaultMultiCompanyGroupIconProvider) this.f4329r.get();
            drawable2 = null;
        } else {
            drawable2 = null;
        }
        if (drawable4 == null && drawable == null && drawable2 == null) {
            drawable3 = null;
        } else {
            drawable3 = new CombinedDrawable(Combine.HORIZONTAL, Align.CENTER, 1, new Drawable[]{drawable4, drawable, drawable2});
        }
        TextViewUtils.a(this.f4331u, null, null, drawable3, null);
    }

    private static boolean m4920e(GraphQLComment graphQLComment) {
        return (graphQLComment.r() == null || !graphQLComment.r().T() || graphQLComment.r().aM()) ? false : true;
    }

    private void m4924i() {
        if (GraphQLCommentHelper.b((GraphQLComment) this.f4310E.a) && m4925j()) {
            if (this.f4306A == null) {
                this.f4306A = (AttachmentsSection) ((ViewStub) getView(2131560443)).inflate();
            }
            this.f4306A.setVisibility(0);
            this.f4306A.m996a(this.f4310E, this.f4325n);
        } else if (this.f4306A != null) {
            this.f4306A.setVisibility(8);
        }
    }

    private boolean m4925j() {
        return this.f4325n.a(this.f4310E.a(GraphQLCommentHelper.c((GraphQLComment) this.f4310E.a))) != GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    private void m4926k() {
        JsonNode jsonNode;
        GraphQLComment graphQLComment = (GraphQLComment) this.f4310E.a;
        if (this.f4313H == null) {
            jsonNode = null;
        } else {
            jsonNode = this.f4313H.a;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(LinkifyUtil.a(this.f4321j.a(LinkifyUtilConverter.c(graphQLComment.s()), true, jsonNode)));
        this.f4323l.a(spannableStringBuilder, (int) this.f4332v.getTextSize());
        if (TextUtils.getTrimmedLength(spannableStringBuilder) == 0) {
            this.f4332v.setVisibility(8);
            return;
        }
        this.f4332v.setVisibility(0);
        GraphQLTranslatabilityType a = GraphQLHelper.a(graphQLComment);
        if (GraphQLHelper.b(graphQLComment)) {
            CharSequence a2 = this.f4321j.a(spannableStringBuilder, a);
            if (a2 != null) {
                this.f4332v.setUntranslatedText(a2);
            } else {
                this.f4332v.setUntranslatedText(spannableStringBuilder);
            }
        } else {
            this.f4332v.setUntranslatedText(spannableStringBuilder);
        }
        if (this.f4316K.containsKey(graphQLComment.y())) {
            this.f4332v.a((CharSequence) this.f4316K.get(graphQLComment.y()), a);
            this.f4332v.b();
        } else {
            this.f4332v.c();
        }
        m4927l();
    }

    private void m4927l() {
        this.f4332v.setClickable(true);
        this.f4332v.setLongClickable(true);
        this.f4332v.setOnClickListener(this.f4317L);
    }

    private void m4928m() {
        switch (C03947.f4302a[this.f4328q.c(((GraphQLComment) this.f4310E.a).H()).ordinal()]) {
            case 1:
                this.f4333w.setVisibility(0);
                m4933r();
                m4936u();
                return;
            case 2:
                this.f4333w.setVisibility(8);
                m4934s();
                m4935t();
                return;
            default:
                this.f4333w.setVisibility(0);
                m4934s();
                m4936u();
                return;
        }
    }

    private void m4929n() {
        this.f4333w.a((GraphQLComment) this.f4310E.a);
        this.f4333w.setDelegate(this.f4319N);
    }

    private void m4930o() {
        GraphQLComment graphQLComment = (GraphQLComment) this.f4310E.a;
        int i = (graphQLComment.l() != null && GraphQLHelper.d(graphQLComment.l()) && this.f4314I) ? 1 : 0;
        if (i != 0 && !GraphQLHelper.i(graphQLComment.l()).isEmpty()) {
            if (this.f4336z == null) {
                this.f4336z = (ThreadedCommentView) ((ViewStub) getView(2131560446)).inflate();
            }
            this.f4336z.setVisibility(0);
            this.f4336z.j = this.f4318M;
            this.f4336z.a(graphQLComment, this.f4315J);
        } else if (this.f4336z != null) {
            this.f4336z.setVisibility(8);
        }
    }

    private void m4931p() {
        this.f4331u.setContentDescription(this.f4331u.getText());
        this.f4332v.setContentDescription(this.f4332v.getText());
        this.f4333w.setContentDescription(this.f4333w.getText());
        this.f4330t.setContentDescription(getContext().getString(2131233315, new Object[]{this.f4331u.getText()}));
    }

    public static void m4932q(CommentView commentView) {
        final GraphQLComment graphQLComment = (GraphQLComment) commentView.f4310E.a;
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(commentView.getContext());
        figPopoverMenuWindow.b(2131820593);
        figPopoverMenuWindow.p = new OnMenuItemClickListener(commentView) {
            final /* synthetic */ CommentView f4300b;

            public final boolean m4898a(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == 2131568699) {
                    this.f4300b.f4308C.mo277b(graphQLComment);
                } else if (itemId == 2131568700) {
                    this.f4300b.f4308C.mo274a(graphQLComment, this.f4300b.getContext());
                }
                return true;
            }
        };
        figPopoverMenuWindow.f(commentView.f4335y);
    }

    private void m4933r() {
        if (this.f4335y == null) {
            this.f4335y = ((ViewStub) getView(2131560447)).inflate();
            this.f4335y.setOnClickListener(new C03936(this));
        }
        this.f4335y.setVisibility(0);
    }

    private void m4934s() {
        if (this.f4335y != null) {
            this.f4335y.setVisibility(8);
        }
    }

    private void m4935t() {
        if (this.f4334x == null) {
            this.f4334x = (TextView) ((ViewStub) getView(2131560445)).inflate();
        } else {
            this.f4334x.setVisibility(0);
        }
    }

    private void m4936u() {
        if (this.f4334x != null) {
            this.f4334x.setVisibility(8);
        }
    }
}
