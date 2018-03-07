package com.facebook.reviews.binder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.common.util.SpannableUtil;
import com.facebook.common.util.TriState;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents.ReviewFeedbackUpdatedEvent;
import com.facebook.reviews.handler.LikeReviewClickHandler;
import com.facebook.reviews.handler.LikeReviewClickHandler.C23211;
import com.facebook.reviews.handler.LikeReviewClickHandlerProvider;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import com.facebook.reviews.ui.ReviewFeedRowView;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.helper.ReviewsIntentHelper;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: UNSUPPORTED_SURFACE */
public class ReviewFeedRowViewBinder {
    private static volatile ReviewFeedRowViewBinder f21399l;
    public final DefaultTimeFormatUtil f21400a;
    private final FeedbackPopoverLauncher f21401b;
    private final Provider<TriState> f21402c;
    private final LikeReviewClickHandlerProvider f21403d;
    public final Provider<String> f21404e;
    private final NumberTruncationUtil f21405f;
    private final PrivacyIcons f21406g;
    private final ReviewEventBus f21407h;
    private final ReviewsIntentHelper f21408i;
    public final ReviewsRatingHelper f21409j;
    public final SpannableString f21410k = new SpannableString(" • ");

    /* compiled from: UNSUPPORTED_SURFACE */
    public class C22813 {
        public final /* synthetic */ ReviewFeedRowViewBinder f21391a;

        C22813(ReviewFeedRowViewBinder reviewFeedRowViewBinder) {
            this.f21391a = reviewFeedRowViewBinder;
        }
    }

    public static com.facebook.reviews.binder.ReviewFeedRowViewBinder m25035a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21399l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.binder.ReviewFeedRowViewBinder.class;
        monitor-enter(r1);
        r0 = f21399l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25038b(r0);	 Catch:{ all -> 0x0035 }
        f21399l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21399l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.binder.ReviewFeedRowViewBinder.a(com.facebook.inject.InjectorLike):com.facebook.reviews.binder.ReviewFeedRowViewBinder");
    }

    private static ReviewFeedRowViewBinder m25038b(InjectorLike injectorLike) {
        return new ReviewFeedRowViewBinder(DefaultTimeFormatUtil.a(injectorLike), FeedbackPopoverLauncher.a(injectorLike), IdBasedProvider.a(injectorLike, 758), (LikeReviewClickHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LikeReviewClickHandlerProvider.class), IdBasedProvider.a(injectorLike, 4442), NumberTruncationUtil.a(injectorLike), PrivacyIcons.a(injectorLike), ReviewEventBus.m4876a(injectorLike), new ReviewsIntentHelper(FbUriIntentHandler.a(injectorLike)), ReviewsRatingHelper.m4932a(injectorLike));
    }

    @Inject
    public ReviewFeedRowViewBinder(DefaultTimeFormatUtil defaultTimeFormatUtil, FeedbackPopoverLauncher feedbackPopoverLauncher, Provider<TriState> provider, LikeReviewClickHandlerProvider likeReviewClickHandlerProvider, Provider<String> provider2, NumberTruncationUtil numberTruncationUtil, PrivacyIcons privacyIcons, ReviewEventBus reviewEventBus, ReviewsIntentHelper reviewsIntentHelper, ReviewsRatingHelper reviewsRatingHelper) {
        this.f21400a = defaultTimeFormatUtil;
        this.f21401b = feedbackPopoverLauncher;
        this.f21402c = provider;
        this.f21403d = likeReviewClickHandlerProvider;
        this.f21404e = provider2;
        this.f21405f = numberTruncationUtil;
        this.f21406g = privacyIcons;
        this.f21407h = reviewEventBus;
        this.f21408i = reviewsIntentHelper;
        this.f21409j = reviewsRatingHelper;
        this.f21410k.setSpan(new ForegroundColorSpan(-9801344), 1, 2, 33);
    }

    public final void m25044a(ReviewFeedRowView reviewFeedRowView, ReviewWithFeedback reviewWithFeedback, String str) {
        m25039b(reviewFeedRowView, reviewWithFeedback, str);
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder();
        separatedSpannableStringBuilder.append(this.f21400a.a(TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE, reviewWithFeedback.g() * 1000));
        reviewFeedRowView.setSubtitle(m25032a(separatedSpannableStringBuilder, reviewWithFeedback, reviewFeedRowView.getResources()));
    }

    public static void m25037a(ReviewFeedRowView reviewFeedRowView, CharSequence charSequence) {
        reviewFeedRowView.setTitleOnClickListener(null);
        reviewFeedRowView.setTitleTextAppearance(2131624223);
        reviewFeedRowView.setTitle(charSequence);
    }

    private void m25039b(ReviewFeedRowView reviewFeedRowView, final ReviewWithFeedback reviewWithFeedback, final String str) {
        Uri uri;
        String str2;
        int i;
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder;
        boolean z;
        int i2 = 0;
        if (reviewWithFeedback.bP_() == null || reviewWithFeedback.bP_().j() == null || Strings.isNullOrEmpty(reviewWithFeedback.bP_().j().b())) {
            uri = null;
        } else {
            uri = Uri.parse(reviewWithFeedback.bP_().j().b());
        }
        reviewFeedRowView.setProfilePicture(uri);
        reviewFeedRowView.setTitle(ReviewsGraphQLHelper.m4911a((ReviewWithCreationFields) reviewWithFeedback));
        reviewFeedRowView.setTitleTextAppearance(2131624231);
        if (reviewWithFeedback.j() == null || reviewWithFeedback.j().a() == null || reviewWithFeedback.j().a().a() == null) {
            str2 = null;
        } else {
            str2 = reviewWithFeedback.j().a().a();
        }
        String str3 = str2;
        String b = ReviewsGraphQLHelper.m4913b((ReviewBasicFields) reviewWithFeedback);
        if (!Strings.isNullOrEmpty(b) || ((String) this.f21404e.get()).equals(ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback))) {
            i = 0;
        } else {
            i = 8;
        }
        reviewFeedRowView.setSecondaryActionVisibility(i);
        SpannableStringBuilder a = m25033a(reviewFeedRowView.getResources(), str3, b, reviewWithFeedback.b());
        Resources resources = reviewFeedRowView.getResources();
        int b2 = reviewWithFeedback.b();
        if (Strings.isNullOrEmpty(b)) {
            separatedSpannableStringBuilder = null;
        } else {
            separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(this.f21410k);
            if (str3 == null) {
                separatedSpannableStringBuilder.append(this.f21409j.m4935a(b2, resources.getDimensionPixelSize(2131427404)));
            }
            separatedSpannableStringBuilder.a(b);
        }
        reviewFeedRowView.m25277a(a, (SpannableStringBuilder) separatedSpannableStringBuilder);
        reviewFeedRowView.setFeedbackSummary(m25034a(reviewWithFeedback, reviewFeedRowView.getResources(), str));
        boolean b3 = m25040b(reviewWithFeedback);
        boolean f = m25043f(reviewWithFeedback);
        i = (b3 || f) ? 0 : 8;
        reviewFeedRowView.setFeedbackDividerVisibility(i);
        if (reviewWithFeedback.bO_() == null) {
            z = false;
        } else {
            z = reviewWithFeedback.bO_().y_();
        }
        reviewFeedRowView.setLikeButtonLikeState(z);
        reviewFeedRowView.setLikeButtonClickListener(m25041c(reviewWithFeedback));
        final Context context = reviewFeedRowView.getContext();
        reviewFeedRowView.setCommentButtonClickListener(new OnClickListener(this) {
            final /* synthetic */ ReviewFeedRowViewBinder f21398d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 391189737);
                ReviewFeedRowViewBinder.m25036a(this.f21398d, reviewWithFeedback, context, str);
                Logger.a(2, EntryType.UI_INPUT_END, -1731700711, a);
            }
        });
        if (b3) {
            i = 0;
        } else {
            i = 8;
        }
        reviewFeedRowView.setLikeButtonVisibility(i);
        if (!f) {
            i2 = 8;
        }
        reviewFeedRowView.setCommentButtonVisibility(i2);
    }

    private SpannableString m25032a(SeparatedSpannableStringBuilder separatedSpannableStringBuilder, ReviewWithFeedback reviewWithFeedback, Resources resources) {
        if (reviewWithFeedback == null || reviewWithFeedback.c() == null || reviewWithFeedback.c().a() == null) {
            return new SpannableString(separatedSpannableStringBuilder);
        }
        separatedSpannableStringBuilder.a("");
        SpannableString spannableString = new SpannableString(separatedSpannableStringBuilder);
        Drawable drawable = resources.getDrawable(this.f21406g.a(reviewWithFeedback.c().a(), Size.COMPOSER_FOOTER));
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430064);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131430065);
        drawable.setBounds(dimensionPixelSize2, 0, dimensionPixelSize2 + dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(drawable, 0), spannableString.length() - 1, spannableString.length(), 33);
        return spannableString;
    }

    @Nullable
    private SpannableStringBuilder m25033a(Resources resources, String str, String str2, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f21409j.m4935a(i, resources.getDimensionPixelSize(2131427404)));
        if (!Strings.isNullOrEmpty(str)) {
            spannableStringBuilder.append(this.f21410k);
            CharSequence spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(-9801344), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            return spannableStringBuilder;
        } else if (Strings.isNullOrEmpty(str2)) {
            return spannableStringBuilder;
        } else {
            return null;
        }
    }

    private SpannableStringBuilder m25034a(final ReviewWithFeedback reviewWithFeedback, Resources resources, final String str) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder("   ");
        if (reviewWithFeedback.bO_() != null) {
            int i;
            DefaultFeedbackFields bO_ = reviewWithFeedback.bO_();
            if (bO_.k() == null) {
                i = 0;
            } else {
                i = bO_.k().a();
            }
            int i2 = i;
            if (i2 > 0 && m25040b(reviewWithFeedback)) {
                separatedSpannableStringBuilder.a(resources.getQuantityString(2131689522, i2, new Object[]{Integer.valueOf(i2)}));
            }
            bO_ = reviewWithFeedback.bO_();
            if (bO_.l() == null) {
                i = 0;
            } else {
                i = bO_.l().a();
            }
            i2 = i;
            if (i2 > 0 && m25043f(reviewWithFeedback)) {
                separatedSpannableStringBuilder.a(resources.getQuantityString(2131689524, i2, new Object[]{Integer.valueOf(i2)}));
            }
            SpannableUtil.a(separatedSpannableStringBuilder, new Object[]{new ClickableSpan(this) {
                final /* synthetic */ ReviewFeedRowViewBinder f21390c;

                public void onClick(View view) {
                    ReviewFeedRowViewBinder.m25036a(this.f21390c, reviewWithFeedback, view.getContext(), str);
                }

                public void updateDrawState(TextPaint textPaint) {
                }
            }});
        }
        return separatedSpannableStringBuilder;
    }

    private static boolean m25040b(ReviewWithFeedback reviewWithFeedback) {
        return (reviewWithFeedback.bO_() == null || Strings.isNullOrEmpty(reviewWithFeedback.bO_().z_()) || !reviewWithFeedback.bO_().g()) ? false : true;
    }

    private OnClickListener m25041c(final ReviewWithFeedback reviewWithFeedback) {
        LikeReviewClickHandlerProvider likeReviewClickHandlerProvider = this.f21403d;
        final LikeReviewClickHandler likeReviewClickHandler = new LikeReviewClickHandler(new C22813(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(likeReviewClickHandlerProvider), FeedbackMutationHelper.b(likeReviewClickHandlerProvider));
        return new OnClickListener(this) {
            final /* synthetic */ ReviewFeedRowViewBinder f21394c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1864640860);
                LikeReviewClickHandler likeReviewClickHandler = likeReviewClickHandler;
                ReviewWithFeedback reviewWithFeedback = reviewWithFeedback;
                if (Strings.isNullOrEmpty(reviewWithFeedback.bN_()) || reviewWithFeedback.bO_() == null || reviewWithFeedback.bO_().k() == null) {
                    likeReviewClickHandler.f21628b.a(LikeReviewClickHandler.class.getSimpleName(), "Missing information to like review " + reviewWithFeedback.bN_());
                } else {
                    boolean z = !reviewWithFeedback.bO_().y_();
                    Builder builder = new Builder();
                    builder.c = "pages_public_view";
                    likeReviewClickHandler.f21629c.a(DefaultGraphQLConversionHelper.a(ReviewWithFeedbackModel.a(reviewWithFeedback).m()), builder.a(), false, new C23211(likeReviewClickHandler, reviewWithFeedback, z));
                }
                Logger.a(2, EntryType.UI_INPUT_END, -537626720, a);
            }
        };
    }

    public static void m25042d(ReviewFeedRowViewBinder reviewFeedRowViewBinder, ReviewWithFeedback reviewWithFeedback) {
        if (reviewWithFeedback.bO_() != null) {
            reviewFeedRowViewBinder.f21407h.a(new ReviewFeedbackUpdatedEvent(DefaultGraphQLConversionHelper.a(reviewWithFeedback.bO_())));
        }
    }

    private static boolean m25043f(ReviewWithFeedback reviewWithFeedback) {
        return reviewWithFeedback.bO_() != null && reviewWithFeedback.bO_().c();
    }

    public static void m25036a(ReviewFeedRowViewBinder reviewFeedRowViewBinder, ReviewWithFeedback reviewWithFeedback, Context context, String str) {
        if (reviewWithFeedback != null && reviewWithFeedback.bO_() != null) {
            FeedbackParams.Builder builder = new FeedbackParams.Builder();
            builder.a = DefaultGraphQLConversionHelper.a(reviewWithFeedback.bO_());
            builder = builder;
            builder.d = reviewWithFeedback.bO_().z_();
            builder = builder;
            Builder builder2 = new Builder();
            builder2.c = str;
            builder.g = builder2.a();
            reviewFeedRowViewBinder.f21401b.a(context, builder.a());
        }
    }
}
