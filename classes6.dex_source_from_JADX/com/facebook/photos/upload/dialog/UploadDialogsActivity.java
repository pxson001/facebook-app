package com.facebook.photos.upload.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.abtest.ExperimentsForPhotosUploadModule;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.manager.UploadManager$RequestType;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: graph_search_v2_results_page_see_more */
public class UploadDialogsActivity extends FbFragmentActivity {
    public static final PrefKey f13586p = ((PrefKey) SharedPrefKeys.a.a("upload/"));
    private static final Class<?> f13587z = UploadDialogsActivity.class;
    private UploadSuccessBusSubscriber f13588A;
    private FailedMediaUploadBusSubscriber f13589B;
    private String f13590C;
    public UploadOperation f13591D;
    public Intent f13592E;
    public AlertDialog f13593F;
    private Long f13594G;
    @Inject
    UploadManager f13595q;
    @Inject
    MediaUploadEventBus f13596r;
    @Inject
    DefaultUploadDialogConfiguration f13597s;
    @Inject
    Lazy<UploadOperationHelper> f13598t;
    @Inject
    Lazy<FbSharedPreferences> f13599u;
    @Inject
    Lazy<Clock> f13600v;
    @Inject
    AbstractFbErrorReporter f13601w;
    @Inject
    Clock f13602x;
    @Inject
    QeAccessor f13603y;

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08731 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13575a;

        C08731(UploadDialogsActivity uploadDialogsActivity) {
            this.f13575a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13575a.m21295a(this.f13575a.f13591D, "onUploadOptions", "startService / auto retry");
            this.f13575a.startService(this.f13575a.f13592E);
            this.f13575a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08742 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13576a;

        C08742(UploadDialogsActivity uploadDialogsActivity) {
            this.f13576a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13576a.m21295a(this.f13576a.f13591D, "onUploadOptions", "giveupUpload / auto retry");
            this.f13576a.f13595q.e(this.f13576a.f13591D);
            this.f13576a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08753 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13577a;

        C08753(UploadDialogsActivity uploadDialogsActivity) {
            this.f13577a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13577a.m21295a(this.f13577a.f13591D, "onUploadOptions", "startService / manual retry");
            this.f13577a.startService(this.f13577a.f13592E);
            this.f13577a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08764 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13578a;

        C08764(UploadDialogsActivity uploadDialogsActivity) {
            this.f13578a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13578a.m21295a(this.f13578a.f13591D, "onUploadOptions", "giveupUpload / manual retry");
            this.f13578a.f13595q.e(this.f13578a.f13591D);
            this.f13578a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08775 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13579a;

        C08775(UploadDialogsActivity uploadDialogsActivity) {
            this.f13579a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13579a.m21295a(this.f13579a.f13591D, "onUploadOptions", "cancelUpload / fatal");
            this.f13579a.f13595q.c(this.f13579a.f13591D);
            this.f13579a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08786 implements OnCancelListener {
        final /* synthetic */ UploadDialogsActivity f13580a;

        C08786(UploadDialogsActivity uploadDialogsActivity) {
            this.f13580a = uploadDialogsActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f13580a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08797 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13581a;

        C08797(UploadDialogsActivity uploadDialogsActivity) {
            this.f13581a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13581a.m21295a(this.f13581a.f13591D, "onCancelRequest", "cancelUpload");
            this.f13581a.f13595q.c(this.f13581a.f13591D);
            this.f13581a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08808 implements OnClickListener {
        final /* synthetic */ UploadDialogsActivity f13582a;

        C08808(UploadDialogsActivity uploadDialogsActivity) {
            this.f13582a = uploadDialogsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f13582a.m21295a(this.f13582a.f13591D, "onCancelRequest", "ensureUploadAlive");
            this.f13582a.f13595q.c(this.f13582a.f13591D, UploadManager$RequestType.UserRetry, "Continue, not cancel");
            this.f13582a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class C08819 implements OnCancelListener {
        final /* synthetic */ UploadDialogsActivity f13583a;

        C08819(UploadDialogsActivity uploadDialogsActivity) {
            this.f13583a = uploadDialogsActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f13583a.finish();
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class FailedMediaUploadBusSubscriber extends MediaUploadEventSubscriber<MediaUploadFailedEvent> {
        final /* synthetic */ UploadDialogsActivity f13584a;

        public FailedMediaUploadBusSubscriber(UploadDialogsActivity uploadDialogsActivity) {
            this.f13584a = uploadDialogsActivity;
        }

        public final void m21284b(FbEvent fbEvent) {
            MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
            if (this.f13584a.f13591D != null && this.f13584a.f13593F != null && mediaUploadFailedEvent.a.f13793p.equals(this.f13584a.f13591D.f13793p)) {
                this.f13584a.f13593F.dismiss();
                if (!mediaUploadFailedEvent.b) {
                    this.f13584a.f13592E = mediaUploadFailedEvent.a;
                    this.f13584a.f13591D = (UploadOperation) this.f13584a.f13592E.getParcelableExtra("uploadOp");
                    UploadDialogsActivity.m21304j(this.f13584a);
                }
            }
        }

        public final Class<MediaUploadFailedEvent> m21283a() {
            return MediaUploadFailedEvent.class;
        }
    }

    /* compiled from: graph_search_v2_results_page_see_more */
    class UploadSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ UploadDialogsActivity f13585a;

        public UploadSuccessBusSubscriber(UploadDialogsActivity uploadDialogsActivity) {
            this.f13585a = uploadDialogsActivity;
        }

        public final void m21286b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            if (this.f13585a.f13591D != null && this.f13585a.f13593F != null && mediaUploadSuccessEvent.a.f13793p.equals(this.f13585a.f13591D.f13793p)) {
                this.f13585a.f13593F.dismiss();
                UploadDialogsActivity.m21306l(this.f13585a);
            }
        }

        public final Class<MediaUploadSuccessEvent> m21285a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    private static <T extends Context> void m21296a(Class<T> cls, T t) {
        m21297a((Object) t, (Context) t);
    }

    public static void m21297a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((UploadDialogsActivity) obj).m21294a(UploadManager.a(fbInjector), MediaUploadEventBus.a(fbInjector), new DefaultUploadDialogConfiguration((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector)), IdBasedLazy.a(fbInjector, 9468), IdBasedSingletonScopeProvider.b(fbInjector, 3078), IdBasedSingletonScopeProvider.b(fbInjector, 609), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m21294a(UploadManager uploadManager, MediaUploadEventBus mediaUploadEventBus, UploadDialogConfiguration uploadDialogConfiguration, Lazy<UploadOperationHelper> lazy, Lazy<FbSharedPreferences> lazy2, Lazy<Clock> lazy3, FbErrorReporter fbErrorReporter, Clock clock, QeAccessor qeAccessor) {
        this.f13595q = uploadManager;
        this.f13596r = mediaUploadEventBus;
        this.f13597s = uploadDialogConfiguration;
        this.f13598t = lazy;
        this.f13599u = lazy2;
        this.f13600v = lazy3;
        this.f13601w = fbErrorReporter;
        this.f13602x = clock;
        this.f13603y = qeAccessor;
    }

    protected final void m21309b(Bundle bundle) {
        super.b(bundle);
        Class cls = UploadDialogsActivity.class;
        m21297a((Object) this, (Context) this);
        this.f13588A = new UploadSuccessBusSubscriber(this);
        this.f13596r.a(this.f13588A);
        this.f13589B = new FailedMediaUploadBusSubscriber(this);
        this.f13596r.a(this.f13589B);
        setContentView(2130907606);
        if (bundle != null) {
            this.f13591D = (UploadOperation) bundle.getParcelable("upload_op");
        }
        if (this.f13591D == null) {
            m21299b(getIntent());
            return;
        }
        this.f13590C = bundle.getString("action");
        this.f13592E = (Intent) bundle.getParcelable("retry_intent");
        if (bundle.containsKey("eta")) {
            this.f13594G = Long.valueOf(bundle.getLong("eta"));
        }
        m21303i();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("action", this.f13590C);
        bundle.putParcelable("upload_op", this.f13591D);
        bundle.putParcelable("retry_intent", this.f13592E);
    }

    private void m21299b(Intent intent) {
        if (intent != null) {
            this.f13590C = intent.getAction();
            this.f13591D = (UploadOperation) intent.getParcelableExtra("upload_op");
            this.f13592E = (Intent) intent.getParcelableExtra("retry_intent");
            if (intent.hasExtra("eta")) {
                this.f13594G = Long.valueOf(intent.getLongExtra("eta", 0));
            }
        }
        if (this.f13590C == null || this.f13591D == null) {
            this.f13601w.b(f13587z.getSimpleName(), "invalid intent");
            finish();
            return;
        }
        m21303i();
    }

    private void m21303i() {
        this.f13590C.toString();
        String str = this.f13591D.f13793p;
        if ("upload_options".equals(this.f13590C)) {
            m21304j(this);
            return;
        }
        if (!"cancel_request".equals(this.f13590C)) {
            if ("upload_success".equals(this.f13590C)) {
                m21306l(this);
                return;
            } else if ("too_slow_request".equals(this.f13590C)) {
                m21307m();
                return;
            }
        }
        m21305k();
    }

    public static void m21304j(UploadDialogsActivity uploadDialogsActivity) {
        if (uploadDialogsActivity.f13592E == null) {
            uploadDialogsActivity.f13601w.b(f13587z.getSimpleName(), "null retry intent");
            uploadDialogsActivity.finish();
        } else if (uploadDialogsActivity.f13591D.f13756E == null) {
            uploadDialogsActivity.f13601w.b(f13587z.getSimpleName(), "no partial record");
            uploadDialogsActivity.finish();
        } else {
            Builder b;
            uploadDialogsActivity.f13590C = "upload_options";
            if (uploadDialogsActivity.f13591D.m21540h() && uploadDialogsActivity.f13591D.m21542k()) {
                b = new Builder(uploadDialogsActivity).a(uploadDialogsActivity.f13597s.m21274a(uploadDialogsActivity)).c(17301659).b(uploadDialogsActivity.f13597s.f13568a.a(ExperimentsForPhotosUploadModule.f13518w, uploadDialogsActivity.getString(2131236073, new Object[]{"\n\n", "\n"})));
                b.a(uploadDialogsActivity.f13597s.f13568a.a(ExperimentsForPhotosUploadModule.f13517v, uploadDialogsActivity.getString(2131236078)), new C08731(uploadDialogsActivity));
                b.b(uploadDialogsActivity.f13597s.m21275b(uploadDialogsActivity), new C08742(uploadDialogsActivity));
            } else {
                b = new Builder(uploadDialogsActivity).c(17301659);
                uploadDialogsActivity.m21291a(b);
                DefaultUploadDialogConfiguration defaultUploadDialogConfiguration;
                if (uploadDialogsActivity.f13591D.m21540h()) {
                    defaultUploadDialogConfiguration = uploadDialogsActivity.f13597s;
                    b.a(uploadDialogsActivity.getString(2131236077), new C08753(uploadDialogsActivity));
                    b.b(uploadDialogsActivity.f13597s.m21275b(uploadDialogsActivity), new C08764(uploadDialogsActivity));
                } else {
                    defaultUploadDialogConfiguration = uploadDialogsActivity.f13597s;
                    b.a(uploadDialogsActivity.getString(2131236079), new C08775(uploadDialogsActivity));
                }
            }
            b.a(new C08786(uploadDialogsActivity));
            uploadDialogsActivity.f13593F = b.a();
            uploadDialogsActivity.f13593F.show();
        }
    }

    private void m21305k() {
        String string;
        this.f13590C = "cancel_request";
        Builder c = new Builder(this).a(this.f13597s.m21274a(this)).c(17301659);
        DefaultUploadDialogConfiguration defaultUploadDialogConfiguration = this.f13597s;
        UploadOperation uploadOperation = this.f13591D;
        if (uploadOperation.m21520Y()) {
            string = getString(2131236068);
        } else if (uploadOperation.m21532c() == 1) {
            string = defaultUploadDialogConfiguration.f13568a.a(ExperimentsForPhotosUploadModule.f13514s, getString(2131236067));
        } else {
            string = defaultUploadDialogConfiguration.f13568a.a(ExperimentsForPhotosUploadModule.f13519x, getString(2131236070));
        }
        c = c.b(string).b(this.f13597s.m21275b(this), new C08797(this));
        c.a(this.f13597s.m21276c(this), new C08808(this));
        c.a(new C08819(this));
        this.f13593F = c.a();
        this.f13593F.show();
    }

    public static void m21306l(UploadDialogsActivity uploadDialogsActivity) {
        uploadDialogsActivity.f13590C = "upload_success";
        Builder builder = new Builder(uploadDialogsActivity);
        DefaultUploadDialogConfiguration defaultUploadDialogConfiguration = uploadDialogsActivity.f13597s;
        builder = builder.a(uploadDialogsActivity.getString(2131236071, new Object[]{DefaultUploadDialogConfiguration.m21273u(uploadDialogsActivity)})).c(17301659);
        defaultUploadDialogConfiguration = uploadDialogsActivity.f13597s;
        builder = builder.b(uploadDialogsActivity.getString(2131236072));
        defaultUploadDialogConfiguration = uploadDialogsActivity.f13597s;
        uploadDialogsActivity.f13593F = builder.a(uploadDialogsActivity.getString(2131236074), new OnClickListener(uploadDialogsActivity) {
            final /* synthetic */ UploadDialogsActivity f13570a;

            {
                this.f13570a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13570a.m21295a(this.f13570a.f13591D, "onUploadSuccess", "dismiss");
                dialogInterface.dismiss();
                this.f13570a.finish();
            }
        }).a(new OnCancelListener(uploadDialogsActivity) {
            final /* synthetic */ UploadDialogsActivity f13569a;

            {
                this.f13569a = r1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                this.f13569a.finish();
            }
        }).a();
        uploadDialogsActivity.f13593F.show();
    }

    private void m21307m() {
        DefaultUploadDialogConfiguration defaultUploadDialogConfiguration = this.f13597s;
        String string = getString(2131236069, new Object[]{String.valueOf(this.f13594G.longValue())});
        this.f13590C = "cancel_request";
        Builder b = new Builder(this).a(this.f13597s.m21274a(this)).c(17301659).b(string);
        b.b(this.f13597s.m21275b(this), new OnClickListener(this) {
            final /* synthetic */ UploadDialogsActivity f13571a;

            {
                this.f13571a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13571a.m21290a(dialogInterface);
                this.f13571a.finish();
            }
        });
        b.a(this.f13597s.m21276c(this), new OnClickListener(this) {
            final /* synthetic */ UploadDialogsActivity f13572a;

            {
                this.f13572a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f13572a.f13595q.c(this.f13572a.f13591D, UploadManager$RequestType.UserRetry, "Continue, not cancel");
                this.f13572a.finish();
            }
        });
        b.a(new OnCancelListener(this) {
            final /* synthetic */ UploadDialogsActivity f13573a;

            {
                this.f13573a = r1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                this.f13573a.finish();
            }
        });
        this.f13593F = b.a();
        this.f13593F.show();
    }

    private void m21290a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f13591D.f13770S = true;
        this.f13595q.c(this.f13591D);
    }

    protected final void m21308a(Intent intent) {
        super.a(intent);
        if (this.f13593F != null) {
            this.f13593F.dismiss();
            this.f13593F = null;
        }
        m21299b(intent);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -565661128);
        super.onDestroy();
        if (this.f13596r != null) {
            this.f13596r.b(this.f13588A);
            this.f13596r.b(this.f13589B);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1511270982, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21291a(com.facebook.fbui.dialog.AlertDialog.Builder r12) {
        /*
        r11 = this;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f13591D;
        r4 = r0.m21540h();
        r0 = com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic.TRANSIENT_ERROR;
        r5 = r11.f13591D;
        r9 = r5.f13756E;
        r5 = r9;
        if (r5 == 0) goto L_0x008a;
    L_0x0012:
        r9 = r5.f13694d;
        r0 = r9;
        if (r0 != 0) goto L_0x0039;
    L_0x0017:
        r0 = r11.f13601w;
        r6 = f13587z;
        r6 = r6.getSimpleName();
        r7 = new java.lang.StringBuilder;
        r8 = "null diagnostic ";
        r7.<init>(r8);
        r8 = r5.mo1089c();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r0.a(r6, r7);
        if (r4 == 0) goto L_0x0087;
    L_0x0037:
        r0 = com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic.TRANSIENT_ERROR;
    L_0x0039:
        r6 = com.facebook.photos.upload.dialog.UploadDialogsActivity.AnonymousClass15.f13574a;
        r0 = r0.ordinal();
        r0 = r6[r0];
        switch(r0) {
            case 1: goto L_0x0098;
            case 2: goto L_0x00a3;
            case 3: goto L_0x00ae;
            case 4: goto L_0x00cd;
            case 5: goto L_0x00d5;
            case 6: goto L_0x00dd;
            case 7: goto L_0x00e9;
            case 8: goto L_0x00f6;
            case 9: goto L_0x0113;
            case 10: goto L_0x011f;
            case 11: goto L_0x0134;
            default: goto L_0x0044;
        };
    L_0x0044:
        if (r4 == 0) goto L_0x00c6;
    L_0x0046:
        r0 = r11.f13597s;
        r0 = r0.m21281m(r11);
    L_0x004c:
        if (r1 == 0) goto L_0x013d;
    L_0x004e:
        r12.a(r1);
    L_0x0051:
        r1 = new java.lang.StringBuilder;
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r1.<init>(r3);
        if (r2 == 0) goto L_0x007a;
    L_0x005a:
        r2 = r11.f13597s;
        r3 = r11.f13591D;
        r9 = r3.m21520Y();
        if (r9 == 0) goto L_0x015c;
    L_0x0064:
        r9 = 2131236081; // 0x7f0814f1 float:1.8088374E38 double:1.052970531E-314;
        r9 = r11.getString(r9);
    L_0x006b:
        r2 = r9;
        r1.append(r2);
        r2 = com.facebook.common.util.StringUtil.a(r0);
        if (r2 != 0) goto L_0x007a;
    L_0x0075:
        r2 = "\n\n";
        r1.append(r2);
    L_0x007a:
        r2 = com.facebook.common.util.StringUtil.a(r0);
        if (r2 != 0) goto L_0x0083;
    L_0x0080:
        r1.append(r0);
    L_0x0083:
        r12.b(r1);
        return;
    L_0x0087:
        r0 = com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic.PERMANENT_ERROR;
        goto L_0x0039;
    L_0x008a:
        r6 = r11.f13601w;
        r7 = f13587z;
        r7 = r7.getSimpleName();
        r8 = "null record";
        r6.a(r7, r8);
        goto L_0x0039;
    L_0x0098:
        r0 = r11.f13597s;
        r9 = 2131236083; // 0x7f0814f3 float:1.8088378E38 double:1.052970532E-314;
        r9 = r11.getString(r9);
        r0 = r9;
        goto L_0x004c;
    L_0x00a3:
        r0 = r11.f13597s;
        r9 = 2131236084; // 0x7f0814f4 float:1.808838E38 double:1.0529705323E-314;
        r9 = r11.getString(r9);
        r0 = r9;
        goto L_0x004c;
    L_0x00ae:
        if (r5 == 0) goto L_0x0155;
    L_0x00b0:
        r9 = r5.f13693c;
        r0 = r9;
        r5 = com.facebook.common.util.StringUtil.a(r0);
        if (r5 != 0) goto L_0x0155;
    L_0x00b9:
        r5 = 2131236085; // 0x7f0814f5 float:1.8088382E38 double:1.052970533E-314;
        r6 = new java.lang.Object[r2];
        r6[r3] = r0;
        r0 = r11.getString(r5, r6);
    L_0x00c4:
        if (r0 != 0) goto L_0x004c;
    L_0x00c6:
        r0 = r11.f13597s;
        r0 = r0.m21280l(r11);
        goto L_0x004c;
    L_0x00cd:
        r0 = r11.f13597s;
        r0 = r0.m21281m(r11);
        goto L_0x004c;
    L_0x00d5:
        r0 = r11.f13597s;
        r0 = r0.m21280l(r11);
        goto L_0x004c;
    L_0x00dd:
        r0 = r11.f13597s;
        r9 = 2131236089; // 0x7f0814f9 float:1.808839E38 double:1.0529705348E-314;
        r9 = r11.getString(r9);
        r0 = r9;
        goto L_0x004c;
    L_0x00e9:
        r0 = r11.f13597s;
        r9 = 2131236088; // 0x7f0814f8 float:1.8088388E38 double:1.0529705343E-314;
        r9 = r11.getString(r9);
        r0 = r9;
        r2 = r3;
        goto L_0x004c;
    L_0x00f6:
        r0 = r11.f13597s;
        r1 = r11.f13591D;
        r9 = r1.m21520Y();
        if (r9 == 0) goto L_0x0177;
    L_0x0100:
        r9 = 2131236096; // 0x7f081500 float:1.8088405E38 double:1.052970538E-314;
        r9 = r11.getString(r9);
    L_0x0107:
        r1 = r9;
        r0 = r11.f13597s;
        r2 = r11.f13591D;
        r0 = r0.m21277c(r11, r2);
        r2 = r3;
        goto L_0x004c;
    L_0x0113:
        r0 = r11.f13597s;
        r9 = 2131236090; // 0x7f0814fa float:1.8088392E38 double:1.052970535E-314;
        r9 = r11.getString(r9);
        r0 = r9;
        goto L_0x004c;
    L_0x011f:
        r0 = r11.f13597s;
        r2 = r11.f13591D;
        r9 = r2.m21520Y();
        if (r9 == 0) goto L_0x018f;
    L_0x0129:
        r9 = 2131236093; // 0x7f0814fd float:1.8088398E38 double:1.0529705367E-314;
    L_0x012c:
        r9 = r11.getString(r9);
        r0 = r9;
        r2 = r3;
        goto L_0x004c;
    L_0x0134:
        r0 = r11.f13597s;
        r0 = r0.m21282q(r11);
        r2 = r3;
        goto L_0x004c;
    L_0x013d:
        if (r4 == 0) goto L_0x014a;
    L_0x013f:
        r1 = r11.f13597s;
        r1 = r1.m21278h(r11);
        r12.a(r1);
        goto L_0x0051;
    L_0x014a:
        r1 = r11.f13597s;
        r1 = r1.m21279i(r11);
        r12.a(r1);
        goto L_0x0051;
    L_0x0155:
        r0 = r1;
        goto L_0x00c4;
    L_0x015c:
        r9 = r3.m21532c();
        r10 = 1;
        if (r9 != r10) goto L_0x016c;
    L_0x0163:
        r9 = 2131236080; // 0x7f0814f0 float:1.8088372E38 double:1.0529705303E-314;
        r9 = r11.getString(r9);
        goto L_0x006b;
    L_0x016c:
        r9 = 2131236082; // 0x7f0814f2 float:1.8088376E38 double:1.0529705313E-314;
        r9 = r11.getString(r9);
        goto L_0x006b;
    L_0x0177:
        r9 = r1.m21532c();
        r10 = 1;
        if (r9 != r10) goto L_0x0186;
    L_0x017e:
        r9 = 2131236094; // 0x7f0814fe float:1.80884E38 double:1.052970537E-314;
        r9 = r11.getString(r9);
        goto L_0x0107;
    L_0x0186:
        r9 = 2131236095; // 0x7f0814ff float:1.8088403E38 double:1.0529705377E-314;
        r9 = r11.getString(r9);
        goto L_0x0107;
    L_0x018f:
        r9 = 2131236092; // 0x7f0814fc float:1.8088396E38 double:1.052970536E-314;
        goto L_0x012c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.dialog.UploadDialogsActivity.a(com.facebook.fbui.dialog.AlertDialog$Builder):void");
    }

    private void m21295a(UploadOperation uploadOperation, String str, String str2) {
        ((UploadOperationHelper) this.f13598t.get()).m21588d(uploadOperation).m19901a("2.0", f13587z.getSimpleName(), str, -1, -1, str2);
    }
}
