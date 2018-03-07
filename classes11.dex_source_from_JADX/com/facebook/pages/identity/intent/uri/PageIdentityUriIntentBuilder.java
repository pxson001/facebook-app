package com.facebook.pages.identity.intent.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: page_selected */
public class PageIdentityUriIntentBuilder extends UriIntentBuilder {
    private static volatile PageIdentityUriIntentBuilder f4142c;
    private final Lazy<BookmarkManager> f4143a;
    private final Lazy<Toaster> f4144b;

    /* compiled from: page_selected */
    class C05671 implements IUriTemplateIntentBuilder {
        final /* synthetic */ PageIdentityUriIntentBuilder f4141a;

        C05671(PageIdentityUriIntentBuilder pageIdentityUriIntentBuilder) {
            this.f4141a = pageIdentityUriIntentBuilder;
        }

        public final Intent m5092a(Context context, Bundle bundle) {
            PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
            newBuilder.a = "Platform Faceweb Picker Flow";
            newBuilder = newBuilder;
            newBuilder.c = PaymentsFlowType.PICKER_SCREEN;
            PickerScreenAnalyticsParams e = newBuilder.e();
            PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder2 = PaymentMethodsPickerScreenFetcherParams.newBuilder();
            newBuilder2.a = true;
            PaymentMethodsPickerScreenFetcherParams d = newBuilder2.d();
            PickerScreenCommonParamsBuilder newBuilder3 = PickerScreenCommonParams.newBuilder();
            newBuilder3.a = e;
            PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder3;
            pickerScreenCommonParamsBuilder.b = PickerScreenStyleParams.newBuilder().c();
            pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
            pickerScreenCommonParamsBuilder.c = PickerScreenStyle.PAYMENT_METHODS;
            pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
            pickerScreenCommonParamsBuilder.d = PaymentItemType.NONE;
            pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
            pickerScreenCommonParamsBuilder.h = d;
            pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
            pickerScreenCommonParamsBuilder.g = context.getResources().getString(2131233858);
            Intent a = PickerScreenActivity.a(context, pickerScreenCommonParamsBuilder.j());
            a.putExtra("request_code", 42);
            return a;
        }
    }

    public static com.facebook.pages.identity.intent.uri.PageIdentityUriIntentBuilder m5093a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4142c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.identity.intent.uri.PageIdentityUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f4142c;	 Catch:{ all -> 0x003a }
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
        r0 = m5094b(r0);	 Catch:{ all -> 0x0035 }
        f4142c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4142c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.intent.uri.PageIdentityUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.pages.identity.intent.uri.PageIdentityUriIntentBuilder");
    }

    private static PageIdentityUriIntentBuilder m5094b(InjectorLike injectorLike) {
        return new PageIdentityUriIntentBuilder(IdBasedSingletonScopeProvider.b(injectorLike, 4985), IdBasedLazy.a(injectorLike, 3588));
    }

    @Inject
    public PageIdentityUriIntentBuilder(Lazy<BookmarkManager> lazy, Lazy<Toaster> lazy2) {
        this.f4143a = lazy;
        this.f4144b = lazy2;
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_parent_activity", true);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/album_list"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_PAGES_ALBUM_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/services_list"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGES_SERVICES_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/service/{#%s}"), "com.facebook.katana.profile.id", "page_service_id_extra"), FragmentChromeActivity.class, ContentFragmentType.PAGES_SINGLE_SERVICE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/info"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_INFORMATION_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/vistor_posts"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_VISITOR_POSTS_FRAGMENT.ordinal(), bundle);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/child_locations"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGES_CHILD_LOCATIONS_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/events_list"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_EVENTS_LIST_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/recommendations"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGES_REVIEWS_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/residence"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_RESIDENCE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.do, "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGES_VIDEO_HUB_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dp, "page_video_list_id", "com.facebook.katana.profile.id", "pages_navigation_source"), FragmentChromeActivity.class, ContentFragmentType.PAGES_VIDEO_LIST_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dq, "com.facebook.katana.profile.id", "pages_navigation_source"), FragmentChromeActivity.class, ContentFragmentType.PAGES_VIDEO_LIST_ALL_VIDEOS_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/reaction"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_REACTION_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/call_to_action"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGE_CALL_TO_ACTION_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/{#%s}/contactinbox"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.PAGES_CONTACT_INBOX_FRAGMENT.ordinal());
        a(FBLinks.a("platform_get_payments"), new C05671(this));
    }

    public final Intent m5095a(Context context, String str) {
        Uri parse = Uri.parse(str);
        if (parse != null && "/edit/general/delete_complete".equals(parse.getPath())) {
            ((BookmarkManager) this.f4143a.get()).a();
            ((Toaster) this.f4144b.get()).a(new ToastBuilder(2131235541));
        }
        return super.a(context, str);
    }
}
