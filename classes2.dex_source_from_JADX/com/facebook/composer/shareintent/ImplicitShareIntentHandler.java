package com.facebook.composer.shareintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.ipc.RedirectableLaunchAuthActivityUtil;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.composer.analytics.ComposerPerformanceLogger;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.publish.ComposerPublishService;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.shareintent.util.AbstractShareIntentHandler;
import com.facebook.composer.shareintent.util.ExperimentsForShareIntentUtilModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.platform.common.PlatformConstants.MediaType;
import com.facebook.platform.common.activity.PlatformIntentDemuxer;
import com.facebook.platform.common.activity.PlatformWrapperActivity;
import com.facebook.platform.composer.composer.PlatformComposerActivity;
import com.facebook.platform.composer.composer.PlatformComposerLauncher;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: platform_get_canonical_profile_ids */
public class ImplicitShareIntentHandler extends AbstractShareIntentHandler implements AnalyticsActivity, IAuthNotRequired {
    private static boolean f9670Q = true;
    @Inject
    ComposerPerformanceLogger f9671F;
    @Inject
    ComposerPublishServiceHelper f9672G;
    @Inject
    LoggedInUserSessionManager f9673H;
    @Inject
    MediaStorage f9674I;
    @Inject
    PlatformComposerLauncher f9675J;
    @Inject
    PlatformComposerPerformanceLogger f9676K;
    @Inject
    Provider<PlatformIntentDemuxer> f9677L;
    @Inject
    QeAccessor f9678M;
    @Inject
    FbAndroidAuthActivityUtil f9679N;
    @Inject
    SecureContextHelper f9680O;
    @Inject
    Toaster f9681P;
    private boolean f9682R;
    public PlatformIntentDemuxer f9683S;
    private boolean f9684T;
    private Bundle f9685U;

    private static <T extends Context> void m14683a(Class<T> cls, T t) {
        m14684a((Object) t, (Context) t);
    }

    public static void m14684a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ImplicitShareIntentHandler) obj).m14681a(ComposerPerformanceLogger.m14909a(injectorLike), ComposerPublishServiceHelper.b(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), MediaStorage.a(injectorLike), PlatformComposerLauncher.b(injectorLike), PlatformComposerPerformanceLogger.a(injectorLike), IdBasedProvider.m1811a(injectorLike, 9629), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbAndroidAuthActivityUtil.b(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), Toaster.m6454b(injectorLike));
    }

    public final String am_() {
        return "composer";
    }

    protected final String mo1943i() {
        return ImplicitShareIntentHandler.class.getName();
    }

    protected final void mo1944k() {
        super.mo1944k();
        Class cls = ImplicitShareIntentHandler.class;
        m14684a((Object) this, (Context) this);
    }

    private void m14681a(ComposerPerformanceLogger composerPerformanceLogger, ComposerPublishServiceHelper composerPublishServiceHelper, LoggedInUserAuthDataStore loggedInUserAuthDataStore, MediaStorage mediaStorage, PlatformComposerLauncher platformComposerLauncher, PlatformComposerPerformanceLogger platformComposerPerformanceLogger, Provider<PlatformIntentDemuxer> provider, QeAccessor qeAccessor, RedirectableLaunchAuthActivityUtil redirectableLaunchAuthActivityUtil, SecureContextHelper secureContextHelper, Toaster toaster) {
        this.f9671F = composerPerformanceLogger;
        this.f9672G = composerPublishServiceHelper;
        this.f9673H = loggedInUserAuthDataStore;
        this.f9674I = mediaStorage;
        this.f9675J = platformComposerLauncher;
        this.f9676K = platformComposerPerformanceLogger;
        this.f9677L = provider;
        this.f9678M = qeAccessor;
        this.f9679N = redirectableLaunchAuthActivityUtil;
        this.f9680O = secureContextHelper;
        this.f9681P = toaster;
    }

    protected final void mo790b(Bundle bundle) {
        super.mo790b(bundle);
        setContentView(2130904847);
        this.f9685U = bundle;
        mo1944k();
    }

    protected final void mo797j() {
        if (this.f9685U == null) {
            if (m14688p()) {
                m14687l(this, getIntent());
            } else {
                m14689q();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 773972459) {
            mo1944k();
            this.f9697r.f9873c.mo385b(917509, "ComposerLaunchTTIExternalShare");
            this.f9697r.f9873c.mo385b(917510, "ComposerLaunchTTIPlatformShare");
            this.f9692G = -1;
            if (i == 23) {
                m14686b(i2, intent);
            } else if (i == 22) {
                m14679a(i2, intent);
            } else if (this.f9683S != null) {
                this.f9683S.a(i, i2, intent);
            } else if (!this.f9682R) {
                if (i2 != -1) {
                    switch (i) {
                        case 42:
                        case 1756:
                        case 2210:
                            setResult(0);
                            break;
                    }
                    finish();
                } else if (i == 2210) {
                    m14704a(new 1(this));
                } else {
                    switch (i) {
                        case 42:
                            setResult(-1);
                            break;
                        case 1756:
                            if (!intent.getBooleanExtra("is_uploading_media", false)) {
                                if (!getIntent().getBooleanExtra("is_draft", false)) {
                                    Intent intent2 = new Intent(this, ComposerPublishService.class);
                                    intent2.putExtras(intent);
                                    startService(intent2);
                                    break;
                                }
                                this.f9672G.c(intent);
                                this.f9681P.m6455a(new ToastBuilder(2131238355));
                                break;
                            }
                            break;
                        default:
                            BLog.b(mo1943i(), "Unexpected request code received %d", new Object[]{Integer.valueOf(i)});
                            break;
                    }
                    finish();
                }
            }
        }
    }

    private void m14679a(int i, Intent intent) {
        if (i == -1 && !this.f9684T && intent != null && intent.hasExtra("attachment_uris") && this.f9678M.mo596a(ExperimentsForShareIntentModule.a, false)) {
            ArrayList arrayList;
            this.f9684T = true;
            Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("attachment_uris");
            Cursor query = getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, null, null, null);
            if (query == null) {
                arrayList = new ArrayList(0);
            } else {
                arrayList = new ArrayList(query.getCount());
                int columnIndex = query.getColumnIndex("_data");
                if (!(query.getCount() == 0 || columnIndex == -1)) {
                    while (query.moveToNext()) {
                        arrayList.add(Uri.parse("file://" + query.getString(columnIndex)));
                    }
                }
                query.close();
            }
            ArrayList arrayList2 = arrayList;
            if (parcelableArrayListExtra != null) {
                arrayList2.removeAll(parcelableArrayListExtra);
            }
            Collections.shuffle(arrayList2);
            ArrayList arrayList3 = new ArrayList(arrayList2.subList(0, Math.min(3, arrayList2.size())));
            if (arrayList3.isEmpty()) {
                finish();
                return;
            }
            Intent intent2 = new Intent(this, MediaChainingActivity.class);
            intent2.putParcelableArrayListExtra("uris", arrayList3);
            this.f9680O.mo660a(intent2, 23, (Activity) this);
            return;
        }
        finish();
    }

    private void m14686b(int i, Intent intent) {
        if (i == -1 && intent != null && intent.hasExtra("selected_uris")) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selected_uris");
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                finish();
                return;
            }
            Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
            intent2.setType("image/*");
            intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", parcelableArrayListExtra);
            m14687l(this, intent2);
            return;
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f9683S != null) {
            this.f9683S.c(bundle);
        }
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 721974180);
        if (this.f9682R) {
            PlatformComposerLauncher.a(this);
        }
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2029547801, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -42145988);
        if (this.f9683S != null) {
            this.f9683S.a();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1593166263, a);
    }

    public void onBackPressed() {
        if (this.f9682R) {
            this.f9675J.b();
        } else {
            super.onBackPressed();
        }
    }

    private boolean m14688p() {
        return this.f9673H.m2522b();
    }

    private void m14689q() {
        this.f9679N.a(this, false);
    }

    public static void m14687l(ImplicitShareIntentHandler implicitShareIntentHandler, Intent intent) {
        if (intent.getBooleanExtra("com.facebook.platform.extra.WEB_SHARE_NATIVE_TREATMENT", false) || AbstractShareIntentHandler.m14699f(intent) || intent.hasExtra("extra_composer_moments_object_uuids") || !implicitShareIntentHandler.f9675J.c.m2189a(739, false)) {
            implicitShareIntentHandler.m14705b(intent);
        } else {
            implicitShareIntentHandler.m14680a(implicitShareIntentHandler.f9685U, intent);
        }
    }

    private void m14680a(Bundle bundle, Intent intent) {
        boolean z = true;
        this.f9682R = !this.f9678M.mo596a(ExperimentsForShareIntentModule.b, true);
        Intent a = PlatformComposerActivity.a(this);
        ComposerConfiguration d = m14707d(intent);
        if (d == null) {
            finish();
            return;
        }
        a.putExtra("extra_composer_configuration", d);
        List initialAttachments = d.getInitialAttachments();
        if (initialAttachments == null || initialAttachments.isEmpty()) {
            z = false;
        }
        this.f9676K.a(this.f9692G, f9670Q, ImmutableMap.of("bypass_platform_composer_activity", String.valueOf(this.f9682R), "has_media", String.valueOf(z)));
        f9670Q = false;
        this.f9676K.b();
        if (this.f9682R) {
            this.f9675J.a(bundle, this, 2131559223, a);
        } else {
            this.f9680O.mo660a(a, 22, (Activity) this);
        }
        overridePendingTransition(0, 0);
    }

    @Nullable
    protected final Runnable mo1942a(Intent intent, int i) {
        String stringExtra = intent.getStringExtra("com.facebook.platform.extra.APPLICATION_ID");
        if (stringExtra == null) {
            return super.mo1942a(intent, i);
        }
        Object obj;
        if (intent.getType().startsWith("*/*") && AbstractShareIntentHandler.m14700o(intent)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || m14715n()) {
            this.f9671F.f9873c.mo395e(917510, "ComposerLaunchTTIPlatformShare");
            Intent a = m14677a(stringExtra, intent);
            if (a != null) {
                return new 2(this, new Intent(a));
            }
            setResult(0);
            finish();
            return null;
        }
        this.f9681P.m6456b(new ToastBuilder(2131234540));
        finish();
        return null;
    }

    @Nullable
    private Intent m14677a(String str, Intent intent) {
        String queryParameter;
        String stringExtra = intent.getStringExtra("com.facebook.platform.extra.METADATA");
        String stringExtra2 = intent.getStringExtra("extra_launch_uri");
        if (stringExtra2 != null) {
            queryParameter = Uri.parse(stringExtra2).getQueryParameter("composer_session_id");
        } else {
            queryParameter = null;
        }
        Bundle bundle = new Bundle();
        if (m14709g(intent)) {
            String b = AbstractShareIntentHandler.m14697b(intent.getStringExtra("android.intent.extra.TEXT"));
            if (b != null) {
                bundle.putString("link", b);
            }
        } else if (m14712j(intent)) {
            ImmutableList e = m14708e(intent);
            ArrayList arrayList = new ArrayList();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                ComposerAttachment composerAttachment = (ComposerAttachment) e.get(i);
                if (!(composerAttachment.b() == null || composerAttachment.c() == null)) {
                    Bundle bundle2 = new Bundle();
                    String str2 = "type";
                    if (composerAttachment.b().b().mType == Type.Video) {
                        stringExtra2 = MediaType.VIDEO.name();
                    } else {
                        stringExtra2 = MediaType.PHOTO.name();
                    }
                    bundle2.putString(str2, stringExtra2);
                    bundle2.putString("uri", composerAttachment.c().toString());
                    arrayList.add(bundle2);
                }
            }
            bundle.putParcelableArrayList("MEDIA", arrayList);
        } else {
            m14714k(intent);
            return null;
        }
        return m14675a(intent, str, bundle, stringExtra, queryParameter);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent m14675a(android.content.Intent r10, java.lang.String r11, android.os.Bundle r12, @javax.annotation.Nullable java.lang.String r13, @javax.annotation.Nullable java.lang.String r14) {
        /*
        r9 = this;
        r0 = "IS_NATIVE_INTENT";
        r1 = 1;
        r12.putBoolean(r0, r1);
        r4 = 1;
        r5 = 0;
        r6 = "android.intent.extra.TEXT";
        r6 = r10.getStringExtra(r6);
        r6 = com.facebook.composer.shareintent.util.AbstractShareIntentHandler.m14697b(r6);
        r7 = new java.lang.CharSequence[r4];
        r7[r5] = r6;
        r7 = com.facebook.common.util.StringUtil.m3591a(r7);
        if (r7 != 0) goto L_0x00b5;
    L_0x001c:
        r6 = android.net.Uri.parse(r6);
        if (r6 == 0) goto L_0x00b5;
    L_0x0022:
        r7 = "file";
        r8 = r6.getScheme();
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x00b5;
    L_0x002e:
        r7 = "content";
        r6 = r6.getScheme();
        r6 = r7.equals(r6);
        if (r6 != 0) goto L_0x00b5;
    L_0x003a:
        r0 = r4;
        if (r0 == 0) goto L_0x007e;
    L_0x003d:
        r0 = "com.facebook.platform.extra.TITLE";
        r0 = r10.getStringExtra(r0);
        if (r0 == 0) goto L_0x004a;
    L_0x0045:
        r1 = "TITLE";
        r12.putString(r1, r0);
    L_0x004a:
        r0 = "com.facebook.platform.extra.SUBTITLE";
        r0 = r10.getStringExtra(r0);
        if (r0 == 0) goto L_0x0057;
    L_0x0052:
        r1 = "SUBTITLE";
        r12.putString(r1, r0);
    L_0x0057:
        r0 = "com.facebook.platform.extra.DESCRIPTION";
        r0 = r10.getStringExtra(r0);
        if (r0 == 0) goto L_0x0064;
    L_0x005f:
        r1 = "DESCRIPTION";
        r12.putString(r1, r0);
    L_0x0064:
        r0 = "com.facebook.platform.extra.IMAGE";
        r0 = r10.getStringExtra(r0);
        if (r0 == 0) goto L_0x0071;
    L_0x006c:
        r1 = "IMAGE";
        r12.putString(r1, r0);
    L_0x0071:
        r0 = "com.facebook.platform.extra.QUOTE";
        r0 = r10.getStringExtra(r0);
        if (r0 == 0) goto L_0x007e;
    L_0x0079:
        r1 = "QUOTE";
        r12.putString(r1, r0);
    L_0x007e:
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "com.facebook.platform.protocol.PROTOCOL_VERSION";
        r0 = com.facebook.platform.common.PlatformConstants.a;
        r3 = 0;
        r0 = r0.get(r3);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1.putInt(r2, r0);
        r0 = "com.facebook.platform.extra.APPLICATION_ID";
        r1.putString(r0, r11);
        if (r14 == 0) goto L_0x00a1;
    L_0x009c:
        r0 = "composer_session_id";
        r1.putString(r0, r14);
    L_0x00a1:
        r0 = "com.facebook.platform.protocol.METHOD_ARGS";
        r1.putBundle(r0, r12);
        r0 = "com.facebook.platform.protocol.BRIDGE_ARGS";
        r2 = new android.os.Bundle;
        r2.<init>();
        r1.putBundle(r0, r2);
        r0 = r9.m14676a(r1, r13);
        return r0;
    L_0x00b5:
        r4 = r5;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.shareintent.ImplicitShareIntentHandler.a(android.content.Intent, java.lang.String, android.os.Bundle, java.lang.String, java.lang.String):android.content.Intent");
    }

    private Intent m14676a(Bundle bundle, @Nullable String str) {
        Intent intent;
        boolean z;
        boolean a = this.f9678M.mo596a(ExperimentsForShareIntentUtilModule.a, false);
        if (a) {
            intent = new Intent(this, PlatformWrapperActivity.class);
        } else {
            this.f9683S = (PlatformIntentDemuxer) this.f9677L.get();
            intent = new Intent();
        }
        Intent putExtra = intent.putExtras(bundle).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.FEED_DIALOG").putExtra("calling_package_key", m14716o()).putExtra("platform_launch_time_ms", this.f9692G);
        String str2 = "platform_launch_extras";
        String str3 = "is_action_send";
        String str4 = "true";
        String str5 = "bypass_platform_activity";
        if (a) {
            z = false;
        } else {
            z = true;
        }
        return putExtra.putExtra(str2, ImmutableMap.of(str3, str4, str5, String.valueOf(z))).putExtra("should_set_simple_result", true).putExtra("com.facebook.platform.extra.METADATA", str);
    }
}
