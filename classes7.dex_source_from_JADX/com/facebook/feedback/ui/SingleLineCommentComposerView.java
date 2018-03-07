package com.facebook.feedback.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.R;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout.OnCoverListener;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.ui.CommentComposerHelper.C03701;
import com.facebook.feedback.ui.CommentComposerPostButton.Listener;
import com.facebook.feedback.ui.CommentsHelper.C04006;
import com.facebook.feedback.ui.CommentsHelper.C04017;
import com.facebook.feedback.ui.TypingEventTextWatcher.TextEventsListener;
import com.facebook.friendsharing.photoremix.abtest.ExperimentsForPhotoRemixExperimentsModule;
import com.facebook.friendsharing.photoremix.analytics.PhotoRemixAnalyticsEventBuilder;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixCommentSource;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.StickerItem;
import com.facebook.ipc.media.StickerItem.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.presence.CommentTypingContext;
import com.facebook.presence.CommentTypingContextProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.stickers.keyboard.StickerKeyboardView;
import com.facebook.stickers.keyboard.StickerKeyboardView.StickerKeyboardListener;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.tagging.graphql.data.CommentTaggingDataSource;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.transliteration.TransliterateAnalyticsLogger;
import com.facebook.transliteration.TransliterationActivity;
import com.facebook.transliteration.TransliterationConfig;
import com.facebook.ufiservices.cache.PendingCommentInputCache;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.ufiservices.util.UfiIntentBuilder;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rotateX */
public class SingleLineCommentComposerView extends SegmentedLinearLayout implements Bindable<GraphQLFeedback>, Listener, CommentComposerView, TextEventsListener, StickerKeyboardListener {
    private static final CallerContext f4703q = CallerContext.a(SingleLineCommentComposerView.class, "story_feedback_flyout");
    private static final FunnelDefinition f4704r = FunnelRegistry.k;
    public ProgressiveMentionAutocompleteEditTextHelper f4705A;
    private ImageButton f4706B;
    @Nullable
    private GlyphView f4707C;
    private GlyphView f4708D;
    private CommentComposerPostButton f4709E;
    public CustomKeyboardLayout f4710F;
    public StickerKeyboardView f4711G;
    private Rect f4712H;
    @Nullable
    private CommentTypingContext f4713I;
    @Nullable
    private String f4714J;
    private boolean f4715K;
    private boolean f4716L;
    private boolean f4717M;
    private String f4718N;
    private int f4719O;
    private int f4720P;
    private boolean f4721Q;
    private boolean f4722R;
    private boolean f4723S;
    @Inject
    CommentComposerHelper f4724a;
    @Inject
    CommentTaggingDataSource f4725b;
    @Inject
    FeedbackAnalyticsLogger f4726c;
    @Inject
    FeedbackControllerProvider f4727d;
    @Inject
    FunnelLoggerImpl f4728e;
    @Inject
    PendingCommentInputCache f4729f;
    @Inject
    CommentTypingContextProvider f4730g;
    @Inject
    QeAccessor f4731h;
    @Inject
    NotificationsLogger f4732i;
    @Inject
    TransliterateAnalyticsLogger f4733j;
    @Inject
    Lazy<EditingGalleryFeedbackLauncher> f4734k;
    @Inject
    PhotoRemixAnalyticsEventBuilder f4735l;
    @Inject
    FbDraweeControllerBuilder f4736m;
    @Inject
    TransliterationConfig f4737n;
    @Inject
    DefaultAndroidThreadUtil f4738o;
    @Inject
    SoftInputDetector f4739p;
    public GraphQLFeedback f4740s;
    private MediaItem f4741t;
    private StickerItem f4742u;
    public C04006 f4743v;
    public C04017 f4744w;
    private FeedbackLoggingParams f4745x;
    private NotificationLogObject f4746y;
    private TypingEventTextWatcher f4747z;

    /* compiled from: rotateX */
    class C04592 implements OnCoverListener {
        final /* synthetic */ SingleLineCommentComposerView f4699a;

        C04592(SingleLineCommentComposerView singleLineCommentComposerView) {
            this.f4699a = singleLineCommentComposerView;
        }

        public final void m5227a() {
            if (this.f4699a.f4711G == null || !this.f4699a.f4711G.G) {
                SingleLineCommentComposerView.m5234C(this.f4699a);
            }
        }
    }

    /* compiled from: rotateX */
    class C04603 implements OnFocusChangeListener {
        final /* synthetic */ SingleLineCommentComposerView f4700a;

        C04603(SingleLineCommentComposerView singleLineCommentComposerView) {
            this.f4700a = singleLineCommentComposerView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f4700a.f4710F.a();
            }
        }
    }

    /* compiled from: rotateX */
    class C04614 implements OnClickListener {
        final /* synthetic */ SingleLineCommentComposerView f4701a;

        C04614(SingleLineCommentComposerView singleLineCommentComposerView) {
            this.f4701a = singleLineCommentComposerView;
        }

        public void onClick(View view) {
            CharSequence userText;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -604706657);
            ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4701a.f4705A;
            if (progressiveMentionAutocompleteEditTextHelper.f4651a.get()) {
                userText = progressiveMentionAutocompleteEditTextHelper.f4653c.getUserText();
            } else {
                userText = progressiveMentionAutocompleteEditTextHelper.f4652b.getEditableText();
            }
            CharSequence charSequence = userText;
            C04017 c04017 = this.f4701a.f4744w;
            String charSequence2 = charSequence.toString();
            Intent intent = new Intent(c04017.f4353a.f4380x.getContext(), TransliterationActivity.class);
            intent.putExtra("composer_text", charSequence2);
            intent.putExtra("entry_point", "comments");
            c04017.f4353a.f4376t.a(intent, 1, c04017.f4353a.f4380x);
            Logger.a(2, EntryType.UI_INPUT_END, 14583022, a);
        }
    }

    /* compiled from: rotateX */
    class C04625 implements OnClickListener {
        final /* synthetic */ SingleLineCommentComposerView f4702a;

        C04625(SingleLineCommentComposerView singleLineCommentComposerView) {
            this.f4702a = singleLineCommentComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -964196245);
            C04006 c04006 = this.f4702a.f4743v;
            boolean d = CommentComposerHelper.m4817d(this.f4702a.f4740s);
            CommentPhotoPickerUtil commentPhotoPickerUtil = c04006.f4352a.f4361e;
            Fragment fragment = c04006.f4352a.f4380x;
            boolean z = false;
            if (d && commentPhotoPickerUtil.f4294f.a(ExperimentsForFeedbackTestModule.ae, false)) {
                z = true;
            }
            fragment.a(UfiIntentBuilder.a(fragment.getContext(), z), 954);
            Logger.a(2, EntryType.UI_INPUT_END, 1490579245, a);
        }
    }

    private static <T extends View> void m5242a(Class<T> cls, T t) {
        m5243a((Object) t, t.getContext());
    }

    private static void m5243a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SingleLineCommentComposerView) obj).m5240a(CommentComposerHelper.m4814a(injectorLike), CommentTaggingDataSource.a(injectorLike), FeedbackAnalyticsLogger.a(injectorLike), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FunnelLoggerImpl.a(injectorLike), PendingCommentInputCache.a(injectorLike), (CommentTypingContextProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentTypingContextProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), NotificationsLogger.a(injectorLike), TransliterateAnalyticsLogger.m19046a(injectorLike), IdBasedLazy.a(injectorLike, 6117), PhotoRemixAnalyticsEventBuilder.m5795a(injectorLike), FbDraweeControllerBuilder.a(injectorLike), TransliterationConfig.m19073a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), SoftInputDetector.a(injectorLike));
    }

    private void m5240a(CommentComposerHelper commentComposerHelper, CommentTaggingDataSource commentTaggingDataSource, FeedbackAnalyticsLogger feedbackAnalyticsLogger, FeedbackControllerProvider feedbackControllerProvider, FunnelLogger funnelLogger, PendingCommentInputCache pendingCommentInputCache, CommentTypingContextProvider commentTypingContextProvider, QeAccessor qeAccessor, NotificationsLogger notificationsLogger, TransliterateAnalyticsLogger transliterateAnalyticsLogger, Lazy<EditingGalleryFeedbackLauncher> lazy, PhotoRemixAnalyticsEventBuilder photoRemixAnalyticsEventBuilder, FbDraweeControllerBuilder fbDraweeControllerBuilder, TransliterationConfig transliterationConfig, AndroidThreadUtil androidThreadUtil, SoftInputDetector softInputDetector) {
        this.f4724a = commentComposerHelper;
        this.f4725b = commentTaggingDataSource;
        this.f4726c = feedbackAnalyticsLogger;
        this.f4727d = feedbackControllerProvider;
        this.f4728e = funnelLogger;
        this.f4729f = pendingCommentInputCache;
        this.f4730g = commentTypingContextProvider;
        this.f4731h = qeAccessor;
        this.f4732i = notificationsLogger;
        this.f4733j = transliterateAnalyticsLogger;
        this.f4734k = lazy;
        this.f4735l = photoRemixAnalyticsEventBuilder;
        this.f4736m = fbDraweeControllerBuilder;
        this.f4737n = transliterationConfig;
        this.f4738o = androidThreadUtil;
        this.f4739p = softInputDetector;
    }

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
        int i = 8;
        this.f4740s = graphQLFeedback;
        if (CommentComposerHelper.m4816a(this.f4740s)) {
            m5257x();
            m5255v();
            if (this.f4724a.m4818b(this.f4740s)) {
                i = 0;
            }
            this.f4706B.setVisibility(i);
            GraphQLFeedback graphQLFeedback2 = this.f4740s;
            if (!(graphQLFeedback2 == null || TextUtils.isEmpty(graphQLFeedback2.r()))) {
                View selfAsView = getSelfAsView();
                ViewStub viewStub = (ViewStub) selfAsView.findViewById(2131558486);
                if (viewStub != null) {
                    ((TextView) viewStub.inflate()).setText(selfAsView.getResources().getString(2131233628, new Object[]{graphQLFeedback2.r()}));
                }
            }
            this.f4725b.a(graphQLFeedback);
            ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
            progressiveMentionAutocompleteEditTextHelper.f4656f = this.f4725b;
            if (progressiveMentionAutocompleteEditTextHelper.f4651a.get()) {
                progressiveMentionAutocompleteEditTextHelper.f4653c.setExtraDataSource(progressiveMentionAutocompleteEditTextHelper.f4656f);
            }
            m5259z();
            m5258y();
            setVisibility(0);
            if (this.f4731h.a(ExperimentsForPhotoRemixExperimentsModule.f5367a, false) && this.f4740s != null && this.f4740s.G() != null && this.f4741t == null) {
                m5237F();
            }
            if (this.f4737n.m19075b()) {
                this.f4708D.setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public SingleLineCommentComposerView(Context context) {
        this(context, null);
    }

    public SingleLineCommentComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5239a(context, attributeSet);
    }

    private void m5239a(Context context, AttributeSet attributeSet) {
        int i = 1;
        m5242a(SingleLineCommentComposerView.class, (View) this);
        setOrientation(1);
        setContentView(2130903619);
        final ViewStub viewStub = (ViewStub) a(2131560425);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommentComposerView, 0, 0);
        if (!obtainStyledAttributes.getBoolean(3, false) || "no_upgrade".equals(this.f4731h.a(ExperimentsForFeedbackTestModule.Q, "no_upgrade"))) {
            i = 0;
        }
        if (i != 0) {
            viewStub.setLayoutResource(2130903621);
        }
        this.f4715K = obtainStyledAttributes.getBoolean(2, false);
        this.f4716L = false;
        this.f4719O = obtainStyledAttributes.getResourceId(0, 0);
        this.f4720P = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        this.f4738o.a(new Runnable(this) {
            final /* synthetic */ SingleLineCommentComposerView f4698b;

            public void run() {
                SingleLineCommentComposerView.setUpProgressiveEditTextHelper(this.f4698b, viewStub);
            }
        });
        this.f4712H = new Rect();
        this.f4706B = (ImageButton) a(2131558490);
        this.f4707C = (GlyphView) findViewById(2131560448);
        this.f4708D = (GlyphView) findViewById(2131560458);
        this.f4709E = (CommentComposerPostButton) a(2131558491);
        this.f4710F = (CustomKeyboardLayout) a(2131560874);
        this.f4709E.f4200e = this;
        this.f4710F.h = new C04592(this);
        this.f4728e.a(f4704r);
        setVisibility(8);
        m5258y();
        this.f4736m.a(f4703q);
    }

    public static void setUpProgressiveEditTextHelper(SingleLineCommentComposerView singleLineCommentComposerView, ViewStub viewStub) {
        singleLineCommentComposerView.f4705A = new ProgressiveMentionAutocompleteEditTextHelper((EditText) viewStub.inflate());
        ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = singleLineCommentComposerView.f4705A;
        OnFocusChangeListener c04603 = new C04603(singleLineCommentComposerView);
        progressiveMentionAutocompleteEditTextHelper.f4654d = c04603;
        progressiveMentionAutocompleteEditTextHelper.m5188a().setOnFocusChangeListener(c04603);
        singleLineCommentComposerView.f4747z = new TypingEventTextWatcher(singleLineCommentComposerView);
        progressiveMentionAutocompleteEditTextHelper = singleLineCommentComposerView.f4705A;
        TextWatcher textWatcher = singleLineCommentComposerView.f4747z;
        progressiveMentionAutocompleteEditTextHelper.f4655e = textWatcher;
        progressiveMentionAutocompleteEditTextHelper.m5188a().addTextChangedListener(textWatcher);
    }

    public final void mo244g() {
        m5253t();
        m5251r();
        m5254u();
        String str = "";
        if (this.f4705A != null) {
            str = this.f4705A.m5189c();
            ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
            progressiveMentionAutocompleteEditTextHelper.m5188a().setOnFocusChangeListener(null);
            progressiveMentionAutocompleteEditTextHelper.m5188a().removeTextChangedListener(progressiveMentionAutocompleteEditTextHelper.f4655e);
            progressiveMentionAutocompleteEditTextHelper.m5188a().setCursorVisible(false);
            this.f4705A = null;
        }
        this.f4726c.a(str, this.f4745x);
        this.f4709E.f4200e = null;
        this.f4709E.setOnClickListener(null);
        this.f4710F.h = null;
        this.f4706B.setOnClickListener(null);
        if (this.f4711G != null) {
            this.f4711G.f = null;
        }
        if (this.f4707C != null) {
            this.f4707C.setOnClickListener(null);
        }
        this.f4708D.setOnClickListener(null);
        this.f4744w = null;
        this.f4728e.b(f4704r);
    }

    public void setReshareButtonExperimentClicked(boolean z) {
        this.f4721Q = z;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m5244a(this.f4739p.f);
    }

    private void m5251r() {
        if ((this.f4717M && !this.f4705A.m5189c().equals(this.f4718N)) || (!this.f4717M && this.f4705A.m5188a().length() != 0)) {
            mo254o();
        }
    }

    @VisibleForTesting
    public CommentTypingContext getTypingContext() {
        if (this.f4713I == null && this.f4714J != null) {
            this.f4713I = this.f4730g.m13081a(this.f4714J);
        }
        return this.f4713I;
    }

    private void m5252s() {
        this.f4717M = false;
        this.f4718N = "";
    }

    public void setTransliterationClickListener(C04017 c04017) {
        this.f4744w = c04017;
        this.f4708D.setOnClickListener(new C04614(this));
    }

    public final void mo242a(String str, boolean z) {
        if (!StringUtil.c(str)) {
            this.f4716L = z;
            this.f4747z.f4782b = false;
            EditText a = this.f4705A.m5188a();
            a.setText(str);
            a.setSelection(a.getText().length());
            this.f4747z.f4782b = true;
            m5258y();
        }
    }

    public void setOnMediaPickerOpenListener(C04006 c04006) {
        this.f4743v = c04006;
        this.f4706B.setOnClickListener(new C04625(this));
    }

    public void setMediaItem(MediaItem mediaItem) {
        if (mediaItem != null) {
            this.f4728e.b(f4704r, "media_item_set");
        }
        this.f4741t = mediaItem;
        FbDraweeControllerBuilder fbDraweeControllerBuilder = this.f4736m;
        View selfAsView = getSelfAsView();
        View findViewById = selfAsView.findViewById(2131558487);
        if (findViewById == null) {
            findViewById = selfAsView.findViewById(2131560438);
        }
        if (mediaItem == null) {
            CommentComposerHelper.m4815a((CommentComposerView) this);
        } else {
            findViewById.setVisibility(0);
            FbDraweeView fbDraweeView = (FbDraweeView) selfAsView.findViewById(2131560439);
            int i = fbDraweeView.getLayoutParams().width;
            int i2 = fbDraweeView.getLayoutParams().height;
            ImageRequestBuilder a = ImageRequestBuilder.a(Uri.fromFile(new File(mediaItem.e())));
            a.d = new ResizeOptions(i, i2);
            fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.b(fbDraweeView.getController())).c(a.m())).a(CommentComposerHelper.f4190a).s());
            selfAsView.findViewById(2131560440).setOnClickListener(new C03701(this));
        }
        m5258y();
    }

    public void setFeedbackLoggingParams(FeedbackLoggingParams feedbackLoggingParams) {
        this.f4745x = feedbackLoggingParams;
    }

    public void setNotificationLogObject(NotificationLogObject notificationLogObject) {
        this.f4746y = notificationLogObject;
    }

    public final boolean mo247h() {
        if (!m5235D()) {
            return false;
        }
        m5234C(this);
        return true;
    }

    public final void mo248i() {
        if (CommentComposerHelper.m4816a(this.f4740s) && this.f4705A != null) {
            View a = this.f4705A.m5188a();
            a.requestFocus();
            KeyboardUtils.b(getContext(), a);
        }
    }

    public void setGroupIdForTagging(Long l) {
        ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
        progressiveMentionAutocompleteEditTextHelper.f4658h = l;
        if (progressiveMentionAutocompleteEditTextHelper.f4651a.get()) {
            progressiveMentionAutocompleteEditTextHelper.f4653c.a(l, MentionSurface.COMMENT);
        }
    }

    public View getPhotoButton() {
        return this.f4706B;
    }

    private void m5253t() {
        KeyboardUtils.a(getContext(), this.f4705A.m5188a());
    }

    private void m5254u() {
        if (this.f4740s != null) {
            this.f4726c.b(this.f4745x, this.f4705A.m5189c());
            PendingCommentInputEntry E = m5236E();
            if (this.f4729f.a(E.b, E)) {
                this.f4726c.c(this.f4745x);
            }
        }
    }

    private void m5255v() {
        PendingCommentInputEntry a = this.f4729f.a(this.f4740s.j());
        if (a == null) {
            m5252s();
            return;
        }
        mo251l();
        this.f4717M = true;
        this.f4718N = a.c;
        this.f4726c.a(this.f4745x, this.f4718N);
        if (!this.f4731h.a(ExperimentsForFeedbackTestModule.d, false)) {
            if (a.f != null && this.f4741t == null) {
                setMediaItem(a.f);
                this.f4728e.a(f4704r, "draft_comment_photo_restored");
            }
            this.f4716L = a.e;
            this.f4747z.f4782b = false;
            EditText a2 = this.f4705A.m5188a();
            a2.setText(a.c);
            a2.setSelection(a2.getText().length());
            this.f4747z.f4782b = true;
            if (!StringUtil.c(a.c)) {
                this.f4728e.a(f4704r, "draft_comment_text_restored");
            }
        }
    }

    public final boolean mo243a(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        EditText a = this.f4705A.m5188a();
        a.getGlobalVisibleRect(this.f4712H);
        boolean z = a.getLineCount() * a.getLineHeight() > a.getHeight();
        if (this.f4712H.contains(i, i2) && z) {
            return false;
        }
        if (this.f4711G != null) {
            this.f4711G.getGlobalVisibleRect(this.f4712H);
            if (this.f4712H.contains(i, i2)) {
                return false;
            }
        }
        return true;
    }

    public final void m5261a(Sticker sticker) {
        if (sticker != null) {
            mo250k();
            Builder builder = new Builder();
            builder.d = sticker;
            builder = builder;
            builder.c = Long.parseLong(sticker.a);
            builder = builder;
            builder.b = sticker.c.toString();
            builder = builder;
            StickerItem stickerItem = new StickerItem(builder.c, builder.b, builder.a);
            stickerItem.a = builder.d;
            this.f4742u = stickerItem;
            m5256w();
        }
    }

    public final void m5260a() {
        m5234C(this);
    }

    public final void m5268b() {
    }

    public final void m5269c() {
    }

    public final void m5265a(String str) {
    }

    public final void mo231d() {
        m5256w();
    }

    public final void mo232e() {
        m5233B();
    }

    public final void mo233f() {
        m5234C(this);
    }

    private void m5256w() {
        if (this.f4717M) {
            this.f4726c.a(this.f4745x, this.f4718N, this.f4705A.m5189c());
            m5252s();
        }
        if (!(this.f4746y == null || this.f4715K)) {
            this.f4732i.a(this.f4746y, "beeper_caused_comment");
        }
        if (this.f4716L) {
            this.f4733j.m19062e();
        }
        PendingCommentInputEntry E = m5236E();
        if (E.a == null) {
            Toast.makeText(getContext(), "Posting failed", 1).show();
            return;
        }
        this.f4727d.m5074a(FeedbackControllerParams.f4498a).m5068a(E, this.f4740s, this.f4745x);
        if (this.f4721Q) {
            this.f4728e.b(FunnelRegistry.D, "reshare_" + ComposerFunnelLoggingUtil.m4975a(E));
        } else {
            this.f4728e.b(FunnelRegistry.D, ComposerFunnelLoggingUtil.m4975a(E));
        }
        this.f4728e.b(f4704r, ComposerFunnelLoggingUtil.m4975a(E));
        KeyboardUtils.a(getContext(), this);
        ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
        if (progressiveMentionAutocompleteEditTextHelper.f4651a.get()) {
            progressiveMentionAutocompleteEditTextHelper.f4653c.b();
        }
        mo250k();
    }

    public final void mo241a(CharSequence charSequence, int i, int i2, int i3) {
        if (getTypingContext() != null) {
            getTypingContext().m13079b();
        }
        if (i2 == 0 && i == 0 && !StringUtil.c(charSequence)) {
            this.f4728e.b(f4704r, "text_filled");
        }
    }

    public final void mo254o() {
        if (getTypingContext() != null) {
            getTypingContext().m13080c();
        }
    }

    public final void mo255p() {
        if (this.f4717M) {
            this.f4726c.b(this.f4745x);
        }
        this.f4716L = false;
        m5252s();
        this.f4728e.b(f4704r, "text_cleared");
    }

    public final void mo256q() {
        m5258y();
    }

    public final void mo240a(TaggingProfile taggingProfile) {
        ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
        progressiveMentionAutocompleteEditTextHelper.f4657g = taggingProfile;
        if (progressiveMentionAutocompleteEditTextHelper.f4651a.get()) {
            progressiveMentionAutocompleteEditTextHelper.f4653c.a(taggingProfile);
        }
    }

    public final void mo252m() {
        this.f4728e.a(f4704r, "entry_with_keyboard_shown");
    }

    public final void mo253n() {
        this.f4728e.b(f4704r, "media_item_cleared");
    }

    private void m5257x() {
        if (this.f4740s == null || this.f4740s.z_() == null) {
            this.f4713I = null;
            this.f4714J = null;
            return;
        }
        String z_ = this.f4740s.z_();
        if (this.f4713I != null && z_.equals(this.f4713I.f11146d)) {
            return;
        }
        if (this.f4731h.a(ExperimentsForFeedbackTestModule.y, false)) {
            this.f4714J = z_;
            this.f4713I = null;
            return;
        }
        this.f4713I = this.f4730g.m13081a(z_);
    }

    private void m5258y() {
        Object obj;
        boolean z = true;
        GraphQLFeedback graphQLFeedback = this.f4740s;
        if (graphQLFeedback == null || !graphQLFeedback.m()) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2 = obj;
        CommentComposerPostButton commentComposerPostButton = this.f4709E;
        boolean z2 = (obj2 == null || mo249j()) ? false : true;
        commentComposerPostButton.setShowSticker(z2);
        commentComposerPostButton = this.f4709E;
        if (obj2 == null || !m5235D()) {
            z2 = false;
        } else {
            z2 = true;
        }
        commentComposerPostButton.setSelected(z2);
        commentComposerPostButton = this.f4709E;
        if (obj2 != null || mo249j()) {
            z2 = true;
        } else {
            z2 = false;
        }
        commentComposerPostButton.setEnabled(z2);
        if (!(this.f4724a.m4818b(this.f4740s) && this.f4741t == null && !m5235D())) {
            z = false;
        }
        this.f4706B.setEnabled(z);
    }

    private void m5259z() {
        Resources resources = getResources();
        int i = (this.f4740s.O() == null || StringUtil.a(this.f4740s.O().aG())) ? 0 : 1;
        this.f4705A.m5188a().setHint(i != 0 ? resources.getString(this.f4720P, new Object[]{this.f4740s.O().aG()}) : resources.getString(this.f4719O));
    }

    public final boolean mo249j() {
        if (this.f4705A == null) {
            return false;
        }
        if (StringUtil.c(this.f4705A.m5189c()) && this.f4741t == null) {
            return false;
        }
        return true;
    }

    public final void mo250k() {
        this.f4705A.m5188a().getText().clear();
        this.f4742u = null;
        m5232A();
        m5258y();
    }

    public View getSelfAsView() {
        return this;
    }

    public final void mo251l() {
        if (this.f4705A != null) {
            ProgressiveMentionAutocompleteEditTextHelper progressiveMentionAutocompleteEditTextHelper = this.f4705A;
            if (!progressiveMentionAutocompleteEditTextHelper.f4651a.getAndSet(true)) {
                ViewGroup viewGroup = (ViewGroup) progressiveMentionAutocompleteEditTextHelper.f4652b.getParent();
                progressiveMentionAutocompleteEditTextHelper.f4653c = (MentionsAutoCompleteTextView) LayoutInflater.from(progressiveMentionAutocompleteEditTextHelper.f4652b.getContext()).inflate(2130903620, viewGroup, false);
                progressiveMentionAutocompleteEditTextHelper.f4652b.setOnFocusChangeListener(null);
                progressiveMentionAutocompleteEditTextHelper.f4652b.removeTextChangedListener(progressiveMentionAutocompleteEditTextHelper.f4655e);
                progressiveMentionAutocompleteEditTextHelper.f4652b.setCursorVisible(false);
                progressiveMentionAutocompleteEditTextHelper.f4653c.setOnFocusChangeListener(progressiveMentionAutocompleteEditTextHelper.f4654d);
                progressiveMentionAutocompleteEditTextHelper.f4653c.addTextChangedListener(progressiveMentionAutocompleteEditTextHelper.f4655e);
                progressiveMentionAutocompleteEditTextHelper.f4653c.setText(progressiveMentionAutocompleteEditTextHelper.f4652b.getText());
                progressiveMentionAutocompleteEditTextHelper.f4653c.a(progressiveMentionAutocompleteEditTextHelper.f4658h, MentionSurface.COMMENT);
                if (progressiveMentionAutocompleteEditTextHelper.f4652b.isFocused()) {
                    ViewCompat.d(progressiveMentionAutocompleteEditTextHelper.f4653c, 2);
                    progressiveMentionAutocompleteEditTextHelper.f4653c.requestFocus();
                    ViewCompat.d(progressiveMentionAutocompleteEditTextHelper.f4653c, 0);
                }
                if (progressiveMentionAutocompleteEditTextHelper.f4656f != null) {
                    progressiveMentionAutocompleteEditTextHelper.f4653c.setExtraDataSource(progressiveMentionAutocompleteEditTextHelper.f4656f);
                }
                if (progressiveMentionAutocompleteEditTextHelper.f4657g != null) {
                    progressiveMentionAutocompleteEditTextHelper.f4653c.a(progressiveMentionAutocompleteEditTextHelper.f4657g);
                }
                int indexOfChild = viewGroup.indexOfChild(progressiveMentionAutocompleteEditTextHelper.f4652b);
                viewGroup.removeView(progressiveMentionAutocompleteEditTextHelper.f4652b);
                viewGroup.addView(progressiveMentionAutocompleteEditTextHelper.f4653c, indexOfChild);
                progressiveMentionAutocompleteEditTextHelper.f4652b = null;
            }
        }
    }

    private void m5232A() {
        this.f4741t = null;
        CommentComposerHelper.m4815a((CommentComposerView) this);
        m5258y();
    }

    private void m5233B() {
        this.f4726c.a(this.f4745x);
        KeyboardUtils.a(getContext(), this);
        if (this.f4711G == null) {
            this.f4711G = new StickerKeyboardView(getContext());
            this.f4711G.setInterface(StickerInterface.COMMENTS);
            this.f4711G.f = this;
            this.f4710F.addView(this.f4711G);
            this.f4710F.bringToFront();
        }
        this.f4711G.setVisibility(0);
        this.f4711G.requestFocus();
        m5258y();
        this.f4728e.b(f4704r, "sticker_keyboard_shown");
    }

    public static void m5234C(SingleLineCommentComposerView singleLineCommentComposerView) {
        if (singleLineCommentComposerView.f4711G != null) {
            singleLineCommentComposerView.f4711G.setVisibility(8);
            singleLineCommentComposerView.m5258y();
            singleLineCommentComposerView.f4728e.b(f4704r, "sticker_keyboard_hidden");
        }
    }

    private boolean m5235D() {
        return this.f4711G != null && this.f4711G.isShown();
    }

    private PendingCommentInputEntry m5236E() {
        return new PendingCommentInputEntry(this.f4740s.z_(), this.f4740s.j(), this.f4705A.m5189c(), this.f4715K, this.f4716L, this.f4741t, this.f4742u, false, 0);
    }

    private void m5237F() {
        if (this.f4707C != null && this.f4707C.getVisibility() != 0) {
            this.f4707C.setVisibility(0);
            this.f4707C.setOnClickListener(((EditingGalleryFeedbackLauncher) this.f4734k.get()).m5033a(Uri.parse(this.f4740s.G()), this.f4740s, EntryPoint.PHOTO_REMIX_COMMENT_INPUT, PhotoRemixCommentSource.COMMENT_COMPOSER));
            PhotoRemixAnalyticsEventBuilder photoRemixAnalyticsEventBuilder = this.f4735l;
            String z_ = this.f4740s.z_();
            String G = this.f4740s.G();
            HoneyClientEventFast a = photoRemixAnalyticsEventBuilder.f5370a.a("see_photo_remix_button", false);
            if (a.a()) {
                a.a("photo_remix");
                a.a("feedback_id", z_);
                a.a("remixable_uri", G);
            }
            HoneyClientEventFast honeyClientEventFast = a;
            if (honeyClientEventFast.a()) {
                honeyClientEventFast.b();
            }
        }
    }

    private void m5244a(boolean z) {
        if (!this.f4722R) {
            this.f4723S = z;
            this.f4722R = true;
        } else if (this.f4723S != z) {
            if (z) {
                this.f4728e.b(f4704r, "keyboard_up");
            } else {
                this.f4728e.b(f4704r, "keyboard_down");
            }
            this.f4723S = z;
        }
    }
}
