package com.facebook.attachments.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.stickers.client.StickerToPackMetadataLoader;
import com.facebook.stickers.client.StickerToPackMetadataLoader.Params;
import com.facebook.stickers.client.StickerToPackMetadataLoader.Results;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.stickers.service.FetchStickerPacksResult.Availability;
import com.facebook.stickers.store.StickerStoreActivity;
import com.facebook.stickers.ui.StickerAnimator;
import com.facebook.stickers.ui.StickerDraweeView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ufiservices.util.CommentMenuHelper;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: upsell_logo */
public class AttachmentViewSticker extends CustomLinearLayout {
    public static final Class<?> f990j = AttachmentViewSticker.class;
    private static final CallerContext f991k = CallerContext.a(AttachmentViewSticker.class, "comment_attachment_fallback");
    @Inject
    DefaultAndroidThreadUtil f992a;
    @Inject
    AbstractFbErrorReporter f993b;
    @Inject
    SecureContextHelper f994c;
    @Inject
    StickerToPackMetadataLoader f995d;
    @Inject
    Toaster f996e;
    @Inject
    AnalyticsLogger f997f;
    @Inject
    SequenceLogger f998g;
    @Inject
    ErrorDialogs f999h;
    @Inject
    CommentMenuHelper f1000i;
    public String f1001l;
    private int f1002m;
    private boolean f1003n;
    private ProgressDialog f1004o;
    public StickerAnimator f1005p;
    private StickerDraweeView f1006q;
    private ControllerListener f1007r;

    /* compiled from: upsell_logo */
    class C00881 extends BaseControllerListener {
        final /* synthetic */ AttachmentViewSticker f980a;

        C00881(AttachmentViewSticker attachmentViewSticker) {
            this.f980a = attachmentViewSticker;
        }

        public final void m954a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable instanceof AnimatableDrawable) {
                m953a((AnimatableDrawable) animatable);
            }
            Sequence e = this.f980a.f998g.e(StickerSequences.b);
            if (e != null) {
                SequenceLoggerDetour.b(e, "StickerToPostOptimisticComment", 1379621516);
            }
        }

        private void m953a(AnimatableDrawable animatableDrawable) {
            this.f980a.f1005p = new StickerAnimator(animatableDrawable);
            AttachmentViewSticker.m977g(this.f980a);
            this.f980a.f997f.a(new HoneyClientEvent("comment_sticker_viewed"));
        }
    }

    /* compiled from: upsell_logo */
    class C00892 implements OnClickListener {
        final /* synthetic */ AttachmentViewSticker f981a;

        C00892(AttachmentViewSticker attachmentViewSticker) {
            this.f981a = attachmentViewSticker;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -338749082);
            if (this.f981a.f1005p == null || !this.f981a.f1005p.e()) {
                AttachmentViewSticker.m977g(this.f981a);
            } else {
                this.f981a.f1005p.c();
            }
            LogUtils.a(290770789, a);
        }
    }

    /* compiled from: upsell_logo */
    class C00903 implements OnLongClickListener {
        final /* synthetic */ AttachmentViewSticker f982a;

        C00903(AttachmentViewSticker attachmentViewSticker) {
            this.f982a = attachmentViewSticker;
        }

        public boolean onLongClick(View view) {
            return this.f982a.m965a(this.f982a.f1001l);
        }
    }

    /* compiled from: upsell_logo */
    class C00944 implements Callback<Params, Results, Throwable> {
        final /* synthetic */ AttachmentViewSticker f987a;

        /* compiled from: upsell_logo */
        class C00911 implements Runnable {
            final /* synthetic */ C00944 f983a;

            C00911(C00944 c00944) {
                this.f983a = c00944;
            }

            public void run() {
                this.f983a.f987a.m971d();
            }
        }

        /* compiled from: upsell_logo */
        class C00933 implements Runnable {
            final /* synthetic */ C00944 f986a;

            C00933(C00944 c00944) {
                this.f986a = c00944;
            }

            public void run() {
                this.f986a.f987a.m975f();
                this.f986a.f987a.f996e.b(new ToastBuilder(this.f986a.f987a.getResources().getString(2131230758)));
            }
        }

        C00944(AttachmentViewSticker attachmentViewSticker) {
            this.f987a = attachmentViewSticker;
        }

        public final void m957b(Object obj, Object obj2) {
            final Results results = (Results) obj2;
            this.f987a.f992a.a(new Runnable(this) {
                final /* synthetic */ C00944 f985b;

                public void run() {
                    this.f985b.f987a.m975f();
                    switch (C00966.f989a[results.b.ordinal()]) {
                        case 1:
                            return;
                        case 2:
                            Intent intent = new Intent(this.f985b.f987a.getContext(), StickerStoreActivity.class);
                            intent.putExtra("stickerPack", results.a);
                            intent.putExtra("stickerContext", StickerInterface.COMMENTS);
                            this.f985b.f987a.f994c.a(intent, this.f985b.f987a.getContext());
                            return;
                        default:
                            this.f985b.f987a.f999h.a(ErrorDialogParams.a(this.f985b.f987a.getResources()).b(2131231059).l());
                            return;
                    }
                }
            });
        }

        public final void m958c(Object obj, Object obj2) {
            Params params = (Params) obj;
            Throwable th = (Throwable) obj2;
            this.f987a.f992a.a(new C00933(this));
            this.f987a.f993b.a(AttachmentViewSticker.f990j.getName(), "View sticker pack failed (id = " + params.a + ")", th);
        }

        public final void m955a(Object obj, ListenableFuture listenableFuture) {
            this.f987a.f992a.a(new C00911(this));
        }
    }

    /* compiled from: upsell_logo */
    class C00955 implements OnCancelListener {
        final /* synthetic */ AttachmentViewSticker f988a;

        C00955(AttachmentViewSticker attachmentViewSticker) {
            this.f988a = attachmentViewSticker;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f988a.m973e();
        }
    }

    /* compiled from: upsell_logo */
    /* synthetic */ class C00966 {
        static final /* synthetic */ int[] f989a = new int[Availability.values().length];

        static {
            try {
                f989a[Availability.DOWNLOADED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f989a[Availability.IN_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f989a[Availability.NOT_AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m962a(Class<T> cls, T t) {
        m963a((Object) t, t.getContext());
    }

    private static void m963a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AttachmentViewSticker) obj).m961a(DefaultAndroidThreadUtil.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), StickerToPackMetadataLoader.b(fbInjector), Toaster.b(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), (SequenceLogger) SequenceLoggerImpl.a(fbInjector), ErrorDialogs.a(fbInjector), CommentMenuHelper.b(fbInjector));
    }

    private void m961a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, StickerToPackMetadataLoader stickerToPackMetadataLoader, Toaster toaster, AnalyticsLogger analyticsLogger, SequenceLogger sequenceLogger, ErrorDialogs errorDialogs, CommentMenuHelper commentMenuHelper) {
        this.f992a = defaultAndroidThreadUtil;
        this.f993b = abstractFbErrorReporter;
        this.f994c = secureContextHelper;
        this.f995d = stickerToPackMetadataLoader;
        this.f996e = toaster;
        this.f997f = analyticsLogger;
        this.f998g = sequenceLogger;
        this.f999h = errorDialogs;
        this.f1000i = commentMenuHelper;
    }

    public AttachmentViewSticker(Context context) {
        super(context);
        m970c();
    }

    public AttachmentViewSticker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m970c();
    }

    public void setSticker(String str) {
        this.f1001l = str;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.f1002m = i;
    }

    public final void m979a(FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f1003n = m968b((FeedProps) feedProps);
        this.f1001l = ((GraphQLStoryAttachment) feedProps.a).r().b();
        this.f1002m = getResources().getColor(2131362059);
        m978a();
    }

    public final void m978a() {
        this.f1006q.a(this.f1001l, this.f1002m, f991k, this.f1007r);
        m977g(this);
    }

    private void m970c() {
        m962a(AttachmentViewSticker.class, (View) this);
        setContentView(2130903302);
        this.f1006q = (StickerDraweeView) a(2131559716);
        this.f1007r = new C00881(this);
        this.f1006q.setOnClickListener(new C00892(this));
        this.f1006q.setOnLongClickListener(new C00903(this));
    }

    private boolean m965a(String str) {
        if (!this.f1003n) {
            return false;
        }
        Params params = new Params(str);
        this.f995d.a();
        this.f995d.a(new C00944(this));
        this.f995d.a(params);
        return true;
    }

    private boolean m968b(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (!(feedProps.c() instanceof GraphQLComment)) {
            return true;
        }
        return !this.f1000i.a((GraphQLComment) feedProps.c());
    }

    private void m971d() {
        if (this.f1004o == null || !this.f1004o.isShowing()) {
            this.f1004o = new ProgressDialog(getContext());
            this.f1004o.a(true);
            this.f1004o.setCanceledOnTouchOutside(true);
            this.f1004o.a(getResources().getText(2131230739));
            this.f1004o.setOnCancelListener(new C00955(this));
            DialogWindowUtils.a(this.f1004o);
            this.f1004o.show();
        }
    }

    private void m973e() {
        this.f995d.a();
    }

    private void m975f() {
        if (this.f1004o != null) {
            this.f1004o.cancel();
            this.f1004o = null;
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 42166541);
        super.onDetachedFromWindow();
        this.f1005p = null;
        this.f1001l = null;
        this.f1002m = 0;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2032222598, a);
    }

    public static void m977g(AttachmentViewSticker attachmentViewSticker) {
        if (attachmentViewSticker.f1005p != null && !attachmentViewSticker.f1005p.b.isStarted() && !attachmentViewSticker.f1005p.e()) {
            attachmentViewSticker.f1005p.b();
        }
    }
}
