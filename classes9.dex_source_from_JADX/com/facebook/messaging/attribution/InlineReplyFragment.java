package com.facebook.messaging.attribution;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.ActionInputAction;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.IsInlineVideoPlayerSupported;
import com.facebook.messaging.attribution.GQLAppAttributionQueryHelper.C08621;
import com.facebook.messaging.attribution.PlatformLaunchHelper.C08791;
import com.facebook.messaging.graphql.threads.AppAttributionQueries.AppAttributionQueryString;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sharing.mediapreview.MediaCheckHelper;
import com.facebook.messaging.sharing.mediapreview.MediaCheckHelper.C20692;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;
import com.facebook.runtimepermissions.RequestPermissionsConfigBuilder;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.bottomsheet.SingleItemRecyclerViewAdapter;
import com.facebook.widget.bottomsheet.SlideUpDialogView;
import com.facebook.widget.bottomsheet.SlideUpDialogView.Listener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: outputX */
public class InlineReplyFragment extends FbDialogFragment {
    public static final String[] aw = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public MediaResource aA;
    @Nullable
    public Intent aB;
    @Nullable
    public String aC;
    @Nullable
    public String aD;
    @Nullable
    private String aE;
    @Nullable
    private String aF;
    @Nullable
    private String aG;
    @Nullable
    public ThreadKey aH;
    public boolean aI;
    private long aJ;
    private boolean aK;
    public boolean aL;
    @Nullable
    public C08791 aM;
    @Nullable
    public ContentAppAttribution aN;
    @Inject
    public DefaultAndroidThreadUtil am;
    @Inject
    public ContentAppAttributionFactory an;
    @Inject
    FbSharedPreferences ao;
    @Inject
    public GQLAppAttributionQueryHelper ap;
    @Inject
    @ForUiThread
    public ListeningExecutorService aq;
    @Inject
    MediaCheckHelper ar;
    @Inject
    public PlatformAttributionLogging as;
    @Inject
    RuntimePermissionsUtil at;
    @Inject
    public SecureContextHelper au;
    @Inject
    @IsInlineVideoPlayerSupported
    Provider<Boolean> av;
    private SingleItemRecyclerViewAdapter ax;
    public SlideUpDialogView ay;
    public InlineReplyView az;

    /* compiled from: outputX */
    class C08641 implements Listener {
        final /* synthetic */ InlineReplyFragment f7816a;

        C08641(InlineReplyFragment inlineReplyFragment) {
            this.f7816a = inlineReplyFragment;
        }

        public final void m8052a() {
            this.f7816a.b();
            if (this.f7816a.aI) {
                this.f7816a.as.m8088c(this.f7816a.aC);
            }
        }
    }

    /* compiled from: outputX */
    class C08652 implements InlineReplyView.Listener {
        final /* synthetic */ InlineReplyFragment f7817a;

        C08652(InlineReplyFragment inlineReplyFragment) {
            this.f7817a = inlineReplyFragment;
        }

        public final void mo287a() {
            InlineReplyFragment inlineReplyFragment = this.f7817a;
            inlineReplyFragment.ay.a();
            if (inlineReplyFragment.aI) {
                inlineReplyFragment.as.m8088c(inlineReplyFragment.aC);
            }
        }

        public final void mo288b() {
            InlineReplyFragment inlineReplyFragment = this.f7817a;
            inlineReplyFragment.am.a();
            if (inlineReplyFragment.aM != null) {
                inlineReplyFragment.aM.m8095a(inlineReplyFragment.aA, inlineReplyFragment.aB, inlineReplyFragment.aD, inlineReplyFragment.aH, inlineReplyFragment.aN);
            }
            inlineReplyFragment.b();
            if (inlineReplyFragment.aI) {
                inlineReplyFragment.as.m8085b(inlineReplyFragment.aC);
            }
        }
    }

    /* compiled from: outputX */
    public class C08663 implements FutureCallback<ContentAppAttribution> {
        final /* synthetic */ InlineReplyFragment f7818a;

        public C08663(InlineReplyFragment inlineReplyFragment) {
            this.f7818a = inlineReplyFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f7818a.aN = (ContentAppAttribution) obj;
        }

        public void onFailure(Throwable th) {
            BLog.b("InlineReplyFragment", "Unable to prefetch ContentAppAttribution", th);
        }
    }

    /* compiled from: outputX */
    public class C08684 implements FutureCallback<List<MediaResource>> {
        final /* synthetic */ InlineReplyFragment f7820a;

        /* compiled from: outputX */
        class C08671 implements OnClickListener {
            final /* synthetic */ C08684 f7819a;

            C08671(C08684 c08684) {
                this.f7819a = c08684;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public C08684(InlineReplyFragment inlineReplyFragment) {
            this.f7820a = inlineReplyFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            List list = (List) obj;
            MediaCheckHelper mediaCheckHelper = this.f7820a.ar;
            Futures.a(mediaCheckHelper.f17403c.a(new C20692(mediaCheckHelper, list)), new C08695(this.f7820a), this.f7820a.aq);
        }

        public void onFailure(Throwable th) {
            BLog.b("InlineReplyFragment", "Failed to copy media resource into local storage", th);
            new FbAlertDialogBuilder(this.f7820a.getContext()).a(2131240034).b(2131240035).a(2131240036, new C08671(this)).a(false).b();
            this.f7820a.b();
        }
    }

    /* compiled from: outputX */
    public class C08695 implements FutureCallback<List<MediaResource>> {
        final /* synthetic */ InlineReplyFragment f7821a;

        public C08695(InlineReplyFragment inlineReplyFragment) {
            this.f7821a = inlineReplyFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            List list = (List) obj;
            boolean z = true;
            if (list.size() != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f7821a.aA = (MediaResource) list.get(0);
            this.f7821a.az.setMediaResource(this.f7821a.aA);
            this.f7821a.az.m8068a();
        }

        public void onFailure(Throwable th) {
            BLog.b("InlineReplyFragment", "Failed to add metadata to media resources", th);
            this.f7821a.b();
        }
    }

    public static void m8058a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InlineReplyFragment) obj).m8057a(DefaultAndroidThreadUtil.b(injectorLike), ContentAppAttributionFactory.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GQLAppAttributionQueryHelper.m8050a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MediaCheckHelper.m17375b(injectorLike), PlatformAttributionLogging.m8077a(injectorLike), RuntimePermissionsUtil.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4102));
    }

    private void m8057a(AndroidThreadUtil androidThreadUtil, ContentAppAttributionFactory contentAppAttributionFactory, FbSharedPreferences fbSharedPreferences, GQLAppAttributionQueryHelper gQLAppAttributionQueryHelper, ListeningExecutorService listeningExecutorService, MediaCheckHelper mediaCheckHelper, PlatformAttributionLogging platformAttributionLogging, RuntimePermissionsUtil runtimePermissionsUtil, SecureContextHelper secureContextHelper, Provider<Boolean> provider) {
        this.am = androidThreadUtil;
        this.an = contentAppAttributionFactory;
        this.ao = fbSharedPreferences;
        this.ap = gQLAppAttributionQueryHelper;
        this.aq = listeningExecutorService;
        this.ar = mediaCheckHelper;
        this.as = platformAttributionLogging;
        this.at = runtimePermissionsUtil;
        this.au = secureContextHelper;
        this.av = provider;
    }

    public final void m8064a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 743932909);
        super.a(bundle);
        Class cls = InlineReplyFragment.class;
        m8058a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.aA = (MediaResource) bundle2.getParcelable("media_resource");
        this.aC = bundle2.getString("app_id");
        this.aD = bundle2.getString("app_package");
        this.aE = bundle2.getString("title");
        this.aF = bundle2.getString("description");
        this.aG = bundle2.getString("cancel_label");
        this.aB = (Intent) bundle2.getParcelable("reply_intent");
        this.aH = (ThreadKey) bundle2.getParcelable("thread_key");
        this.aI = bundle2.getBoolean("is_platform_instance", false);
        this.aJ = bundle2.getLong("dialog_id");
        a(0, 2131625148);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 615357365, a);
    }

    public final void m8066d(Bundle bundle) {
        boolean z = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -730904044);
        super.d(bundle);
        if (!(this.aB == null || this.aB.getBooleanExtra("IS_CHAT_HEADS_HARDWARE_ACCELERATION_DISABLED", true))) {
            z = false;
        }
        if (!z) {
            this.f.getWindow().setFlags(16777216, 16777216);
        }
        if (!(!this.aI || this.aB == null || this.aD == null)) {
            ContentAppAttribution a2 = this.an.a(this.aB, this.aD);
            if (a2 != null) {
                GQLAppAttributionQueryHelper gQLAppAttributionQueryHelper = this.ap;
                GraphQlQueryString appAttributionQueryString = new AppAttributionQueryString();
                appAttributionQueryString.a("app_fbid", String.valueOf(a2.b));
                appAttributionQueryString.a("verification_type", ActionInputAction.OTHER.toString());
                appAttributionQueryString.a("hash_key", a2.d);
                Futures.a(Futures.a(gQLAppAttributionQueryHelper.f7814a.a(GraphQLRequest.a(appAttributionQueryString).a(GraphQLCachePolicy.a).a(86400)), new C08621(gQLAppAttributionQueryHelper, a2)), new C08663(this), this.aq);
            }
        }
        at();
        LogUtils.f(793648637, a);
    }

    public final View m8062a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -17458392);
        this.az = new InlineReplyView(getContext());
        this.ay = new SlideUpDialogView(getContext());
        this.ay.e = 1.0f;
        this.ay.d = 1.0f;
        this.ay.setRecyclerViewBackground(new ColorDrawable(0));
        this.ax = new SingleItemRecyclerViewAdapter(this.az);
        this.ay.setAdapter(this.ax);
        this.ay.o = new C08641(this);
        SlideUpDialogView slideUpDialogView = this.ay;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1948533765, a);
        return slideUpDialogView;
    }

    public final void m8065a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.az.f7831g = new C08652(this);
        InlineReplyView inlineReplyView = this.az;
        CharSequence charSequence = this.aE;
        inlineReplyView.f7829e.setText(charSequence);
        inlineReplyView.f7829e.setVisibility(charSequence == null ? 8 : 0);
        inlineReplyView = this.az;
        charSequence = this.aF;
        inlineReplyView.f7830f.setText(charSequence);
        inlineReplyView.f7830f.setVisibility(charSequence == null ? 8 : 0);
        inlineReplyView = this.az;
        charSequence = this.aG;
        if (charSequence == null) {
            inlineReplyView.f7827c.setText(2131230727);
        } else {
            inlineReplyView.f7827c.setText(charSequence);
        }
    }

    public final void m8067e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("media_resource", this.aA);
        bundle.putString("app_id", this.aC);
        bundle.putString("app_package", this.aD);
        bundle.putString("title", this.aE);
        bundle.putString("description", this.aF);
        bundle.putString("cancel_label", this.aG);
        bundle.putParcelable("reply_intent", this.aB);
        bundle.putParcelable("thread_key", this.aH);
        bundle.putBoolean("is_platform_instance", this.aI);
        bundle.putLong("dialog_id", this.aJ);
    }

    public final void m8060G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 115318634);
        super.G();
        if (this.aK) {
            if (this.at.a(aw)) {
                at();
            } else {
                b();
            }
            this.aL = false;
            this.aK = false;
        }
        LogUtils.f(-781051456, a);
    }

    public final void m8061H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1536370655);
        super.H();
        this.aK = this.aL;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -225368079, a);
    }

    public final void m8063a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m8059b(intent);
        } else {
            super.a(i, i2, intent);
        }
    }

    private void at() {
        ListenableFuture a;
        if (this.aB != null && this.aB.getBooleanExtra("IS_URI_COPIED", false)) {
            a = Futures.a(ImmutableList.of(this.aA));
        } else if (this.at.a(aw)) {
            a = this.ar.m17378a(ImmutableList.of(this.aA));
        } else {
            RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
            requestPermissionsConfigBuilder.a = jW_().getString(2131230894);
            requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder.b = jW_().getString(2131230895);
            requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder.c = RationaleBehavior.ALWAYS_SHOW;
            requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder.d = false;
            this.au.a(RequestPermissionsActivity.m19961a(getContext(), aw, requestPermissionsConfigBuilder.e()), 1, this);
            this.aL = true;
            return;
        }
        Futures.a(a, new C08684(this), this.aq);
    }

    private void m8059b(Intent intent) {
        this.aL = false;
        HashMap hashMap = (HashMap) intent.getSerializableExtra("extra_permission_results");
        Integer num = (Integer) hashMap.get("android.permission.READ_EXTERNAL_STORAGE");
        Integer num2 = (Integer) hashMap.get("android.permission.WRITE_EXTERNAL_STORAGE");
        if (num == null || num2 == null) {
            b();
        } else if (num.intValue() == 0 && num2.intValue() == 0) {
            at();
        } else {
            if (num.intValue() == 1 || num2.intValue() == 1) {
                this.ao.edit().putBoolean(RequestPermissionsPrefKeys.f20406e, false).commit();
            }
            if (num.intValue() == 2 || num2.intValue() == 2) {
                this.ao.edit().putBoolean(RequestPermissionsPrefKeys.f20406e, true).commit();
            }
            b();
        }
    }
}
