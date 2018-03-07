package com.facebook.reviews.binder;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.ui.UserPlacesToReviewView;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: UNSET_FOCUSED_VIEW */
public class UserPlacesToReviewViewBinder {
    private static volatile UserPlacesToReviewViewBinder f21419e;
    public final FbUriIntentHandler f21420a;
    public final Resources f21421b;
    public final ReviewsRatingHelper f21422c;
    public final UserReviewsListComposerLauncherAndHandler f21423d;

    public static com.facebook.reviews.binder.UserPlacesToReviewViewBinder m25048a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21419e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.binder.UserPlacesToReviewViewBinder.class;
        monitor-enter(r1);
        r0 = f21419e;	 Catch:{ all -> 0x003a }
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
        r0 = m25049b(r0);	 Catch:{ all -> 0x0035 }
        f21419e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21419e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.binder.UserPlacesToReviewViewBinder.a(com.facebook.inject.InjectorLike):com.facebook.reviews.binder.UserPlacesToReviewViewBinder");
    }

    private static UserPlacesToReviewViewBinder m25049b(InjectorLike injectorLike) {
        return new UserPlacesToReviewViewBinder(FbUriIntentHandler.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ReviewsRatingHelper.m4932a(injectorLike), UserReviewsListComposerLauncherAndHandler.m25177a(injectorLike));
    }

    @Inject
    public UserPlacesToReviewViewBinder(FbUriIntentHandler fbUriIntentHandler, Resources resources, ReviewsRatingHelper reviewsRatingHelper, UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler) {
        this.f21420a = fbUriIntentHandler;
        this.f21421b = resources;
        this.f21422c = reviewsRatingHelper;
        this.f21423d = userReviewsListComposerLauncherAndHandler;
    }

    public final void m25050a(UserPlacesToReviewView userPlacesToReviewView, final PlaceToReviewModel placeToReviewModel) {
        String str;
        C22852 c22852;
        CharSequence charSequence = null;
        if (placeToReviewModel.bS_() == null || placeToReviewModel.bS_().a() == null) {
            str = null;
        } else {
            str = placeToReviewModel.bS_().a().a();
        }
        String str2 = str;
        Uri parse = str2 == null ? null : Uri.parse(str2);
        if (parse == null) {
            userPlacesToReviewView.f21791i.setImageDrawable(userPlacesToReviewView.getResources().getDrawable(2130842668));
        } else {
            userPlacesToReviewView.f21791i.a(parse, UserPlacesToReviewView.f21790h);
        }
        userPlacesToReviewView.f21792j.setText(placeToReviewModel.d());
        if (placeToReviewModel.b() != null) {
            charSequence = placeToReviewModel.b().a();
        }
        userPlacesToReviewView.f21793k.setText(charSequence);
        int a = placeToReviewModel.bQ_() == null ? 0 : (int) placeToReviewModel.bQ_().a();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (a > 0) {
            spannableStringBuilder.append(this.f21422c.m4935a(a, this.f21421b.getDimensionPixelSize(2131427400)));
        }
        if (!(placeToReviewModel.g() == null || Strings.isNullOrEmpty(placeToReviewModel.g().a()))) {
            spannableStringBuilder.append(placeToReviewModel.g().a());
        }
        userPlacesToReviewView.f21794l.setText(spannableStringBuilder);
        userPlacesToReviewView.f21795m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UserPlacesToReviewViewBinder f21416b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -579438723);
                this.f21416b.f21423d.m25180a(placeToReviewModel.bR_(), placeToReviewModel.c(), placeToReviewModel.d(), 1759, (Activity) view.getContext(), ComposerSourceType.USER_REVIEWS_LIST, CurationSurface.USER_SEE_ALL_REVIEWS, CurationMechanism.REVIEW_BUTTON);
                Logger.a(2, EntryType.UI_INPUT_END, -994553530, a);
            }
        });
        if (placeToReviewModel.c() == null) {
            c22852 = null;
        } else {
            c22852 = new OnClickListener(this) {
                final /* synthetic */ UserPlacesToReviewViewBinder f21418b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1528673752);
                    this.f21418b.f21420a.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, placeToReviewModel.c()));
                    Logger.a(2, EntryType.UI_INPUT_END, -90875352, a);
                }
            };
        }
        userPlacesToReviewView.setOnClickListener(c22852);
    }
}
