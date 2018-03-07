package com.facebook.platform.common.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.ipc.RedirectableLaunchAuthActivityUtil;
import com.facebook.base.activity.RunningTaskInfoManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.common.action.PlatformAppCall.Builder;
import com.facebook.platform.common.annotations.TaskRunningInPlatformContext;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.facebook.platform.common.webdialogs.PlatformWebDialogsController;
import com.facebook.platform.perflogging.PlatformPerformanceLogger;
import com.facebook.platform.webdialogs.PlatformWebDialogsControllerImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: stream_disk_recording_video_bitrate */
public class PlatformIntentDemuxer {
    private static final Map<String, Integer> f4043a = Maps.c();
    private static final Map<String, Bundle> f4044b = Maps.c();
    private static final Set<String> f4045c = Sets.a();
    private boolean f4046d;
    private AbstractPlatformActionExecutor f4047e;
    public SelfRegistrableReceiverImpl f4048f;
    public boolean f4049g = false;
    private Activity f4050h;
    private PlatformAppCall f4051i;
    private Intent f4052j;
    private Map<String, String> f4053k;
    private long f4054l;
    private String f4055m;
    private boolean f4056n;
    private Class<?> f4057o;
    private int f4058p;
    @CrossFbProcessBroadcast
    private final BaseFbBroadcastManager f4059q;
    private final AbstractFbErrorReporter f4060r;
    public final LoggedInUserSessionManager f4061s;
    private final Map<String, PlatformActivityActionHandler> f4062t = Maps.c();
    private final PlatformActivityThrottler f4063u;
    private final PlatformPackageUtilities f4064v;
    private final PlatformPerformanceLogger f4065w;
    private final PlatformWebDialogsControllerImpl f4066x;
    private final FbAndroidAuthActivityUtil f4067y;
    private final RunningTaskInfoManager f4068z;

    /* compiled from: stream_disk_recording_video_bitrate */
    class C02231 implements ActionReceiver {
        final /* synthetic */ PlatformIntentDemuxer f4042a;

        C02231(PlatformIntentDemuxer platformIntentDemuxer) {
            this.f4042a = platformIntentDemuxer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -290113810);
            this.f4042a.f4049g = true;
            this.f4042a.f4048f.c();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1189129624, a);
        }
    }

    public static PlatformIntentDemuxer m5950b(InjectorLike injectorLike) {
        return new PlatformIntentDemuxer((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PlatformActivityActionHandler(injectorLike)), PlatformActivityThrottler.m5942a(injectorLike), PlatformPackageUtilities.m6010b(injectorLike), PlatformPerformanceLogger.m6022a(injectorLike), PlatformWebDialogsControllerImpl.b(injectorLike), FbAndroidAuthActivityUtil.b(injectorLike), RunningTaskInfoManager.a(injectorLike));
    }

    static {
        f4043a.put("com.facebook.platform.action.request.FEED_DIALOG", Integer.valueOf(20130618));
        f4043a.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", Integer.valueOf(20130618));
        f4044b.put("com.facebook.platform.action.request.LOGIN_DIALOG", new PlatformActivityErrorBundleBuilder("ServiceDisabled", "Please fall back to the previous version of the SSO Login Dialog").f4035a);
        f4045c.add("com.facebook.katana");
        f4045c.add("com.facebook.orca");
        f4045c.add("com.facebook.wakizashi");
        f4045c.add("com.facebook.work");
    }

    @Inject
    public PlatformIntentDemuxer(FbBroadcastManager fbBroadcastManager, FbErrorReporter fbErrorReporter, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Set<PlatformActivityActionHandler> set, PlatformActivityThrottler platformActivityThrottler, PlatformPackageUtilities platformPackageUtilities, PlatformPerformanceLogger platformPerformanceLogger, PlatformWebDialogsController platformWebDialogsController, RedirectableLaunchAuthActivityUtil redirectableLaunchAuthActivityUtil, RunningTaskInfoManager runningTaskInfoManager) {
        this.f4059q = fbBroadcastManager;
        this.f4060r = fbErrorReporter;
        this.f4061s = loggedInUserAuthDataStore;
        this.f4063u = platformActivityThrottler;
        this.f4064v = platformPackageUtilities;
        this.f4065w = platformPerformanceLogger;
        this.f4066x = platformWebDialogsController;
        this.f4067y = redirectableLaunchAuthActivityUtil;
        this.f4068z = runningTaskInfoManager;
        for (PlatformActivityActionHandler platformActivityActionHandler : set) {
            this.f4062t.put(platformActivityActionHandler.mo290a(), platformActivityActionHandler);
        }
    }

    public final void m5957a(Bundle bundle) {
        m5953d(bundle);
    }

    public final void m5959b(Bundle bundle) {
        m5954e(bundle);
    }

    public final void m5958a(Bundle bundle, Activity activity, Intent intent, boolean z, long j) {
        this.f4050h = activity;
        this.f4052j = intent;
        this.f4054l = j;
        this.f4057o = this.f4050h.getClass();
        if (this.f4063u.m5944a()) {
            this.f4048f = this.f4059q.a().a("ACTION_MQTT_NO_AUTH", new C02231(this)).a();
            this.f4048f.b();
            if (bundle != null) {
                this.f4055m = bundle.getString("calling_package");
                this.f4046d = bundle.getBoolean("disallow_web_dialog");
                this.f4051i = (PlatformAppCall) bundle.getParcelable("platform_app_call");
            } else {
                m5948a(z);
            }
            this.f4068z.a(this.f4050h, TaskRunningInPlatformContext.class);
            this.f4058p = this.f4050h.getTaskId();
            this.f4047e = m5945a(this.f4052j);
            if (this.f4047e == null) {
                return;
            }
            if (this.f4061s.b()) {
                this.f4047e.m5903a(bundle);
                return;
            } else {
                m5952b(false);
                return;
            }
        }
        BLog.b(this.f4057o, "Api requests exceed the rate limit");
        m5954e(null);
    }

    public final void m5955a() {
        if (this.f4048f != null) {
            this.f4048f.c();
        }
        if (!(this.f4068z == null || this.f4050h == null)) {
            this.f4068z.a(this.f4050h, this.f4058p, TaskRunningInPlatformContext.class);
        }
        if (this.f4047e != null) {
            this.f4047e.m5901a();
        }
    }

    public final void m5956a(int i, int i2, Intent intent) {
        if (!this.f4049g || i2 == -1) {
            switch (i) {
                case 2210:
                    if (i2 == 0) {
                        m5954e(PlatformAppResults.m5891a(this.f4051i, "User canceled login"));
                        return;
                    }
                    if (this.f4047e == null) {
                        this.f4047e = m5945a(this.f4052j);
                    }
                    this.f4047e.m5903a(null);
                    return;
                default:
                    this.f4047e.m5902a(i, i2, intent);
                    return;
            }
        }
        this.f4049g = false;
        this.f4047e.m5901a();
        this.f4047e = null;
        m5952b(true);
    }

    public final void m5960c(Bundle bundle) {
        bundle.putBoolean("disallow_web_dialog", this.f4046d);
        bundle.putString("calling_package", this.f4055m);
        bundle.putParcelable("platform_app_call", this.f4051i);
        if (this.f4047e != null) {
            this.f4047e.m5905b(bundle);
        }
    }

    private boolean m5948a(boolean z) {
        ComponentName callingActivity = this.f4050h.getCallingActivity();
        String packageName = callingActivity != null ? callingActivity.getPackageName() : null;
        if (!z || f4045c.contains(packageName)) {
            Bundle extras = this.f4052j.getExtras();
            if (extras != null) {
                this.f4055m = extras.getString("calling_package_key");
                if (extras.containsKey("platform_launch_time_ms")) {
                    this.f4054l = extras.getLong("platform_launch_time_ms");
                }
                if (extras.containsKey("platform_launch_extras")) {
                    this.f4053k = (Map) extras.getSerializable("platform_launch_extras");
                }
                this.f4056n = extras.getBoolean("should_set_simple_result");
            }
        } else {
            this.f4055m = packageName;
        }
        if (this.f4055m == null) {
            if (BuildConstants.i && this.f4052j.hasExtra("internal_calling_package")) {
                this.f4055m = this.f4052j.getStringExtra("internal_calling_package");
            } else {
                this.f4060r.b("sso", "getCallingPackage==null; finish() called. see t1118578");
                m5947a("The calling package was null");
                return false;
            }
        }
        this.f4051i = m5949b(this.f4052j);
        if (this.f4051i == null) {
            return false;
        }
        PlatformPerformanceLogger platformPerformanceLogger = this.f4065w;
        platformPerformanceLogger.m6024a(this.f4054l, platformPerformanceLogger.f4109a, this.f4053k);
        platformPerformanceLogger.f4109a = false;
        return true;
    }

    private AbstractPlatformActionExecutor m5945a(Intent intent) {
        if (this.f4051i == null) {
            return null;
        }
        AbstractPlatformActionExecutor abstractPlatformActionExecutor;
        if (this.f4046d || this.f4066x == null) {
            abstractPlatformActionExecutor = null;
        } else {
            abstractPlatformActionExecutor = this.f4066x.a(this.f4050h, intent, this.f4051i);
            if (abstractPlatformActionExecutor != null) {
                abstractPlatformActionExecutor.m5904a(this);
                return abstractPlatformActionExecutor;
            }
            abstractPlatformActionExecutor = this.f4066x.b(this.f4050h, intent, this.f4051i);
        }
        String j = this.f4051i.m5914j();
        if (f4044b.containsKey(j)) {
            m5954e((Bundle) f4044b.get(j));
            return null;
        }
        int intExtra = this.f4052j.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        if (!f4043a.containsKey(j) || intExtra >= ((Integer) f4043a.get(j)).intValue()) {
            PlatformActivityActionHandler platformActivityActionHandler = (PlatformActivityActionHandler) this.f4062t.get(j);
            if (platformActivityActionHandler != null) {
                this.f4046d = true;
                try {
                    PlatformActivityRequest b = platformActivityActionHandler.mo291b();
                    if (b == null) {
                        m5951b(j);
                        return null;
                    } else if (b.m5938a(this.f4051i, intent)) {
                        AbstractPlatformActionExecutor a = platformActivityActionHandler.mo289a(this.f4050h, b);
                        if (a == null) {
                            return a;
                        }
                        a.m5904a(this);
                        return a;
                    } else {
                        m5954e(b.m5939b());
                        return null;
                    }
                } catch (PlatformActivityActionNotSupportedException e) {
                    m5954e(e.m5922a());
                    return null;
                } catch (Exception e2) {
                    m5951b(j);
                    return null;
                }
            } else if (abstractPlatformActionExecutor == null) {
                m5951b(j);
                return null;
            } else {
                abstractPlatformActionExecutor.m5904a(this);
                return abstractPlatformActionExecutor;
            }
        }
        m5951b(j);
        return null;
    }

    private PlatformAppCall m5949b(Intent intent) {
        PlatformAppCall platformAppCall = null;
        String a = this.f4064v.m6012a(this.f4055m);
        if (a == null) {
            m5947a("Application key hash could not be computed");
        } else {
            try {
                Builder builder = new Builder(intent);
                builder.m5910b(a).m5908a(this.f4055m);
                platformAppCall = builder.m5909a();
            } catch (PlatformActivityActionNotSupportedException e) {
                m5954e(e.m5922a());
            }
        }
        return platformAppCall;
    }

    private void m5952b(boolean z) {
        if (this.f4067y != null) {
            this.f4067y.a(this.f4050h, z);
        } else {
            m5954e(new PlatformActivityErrorBundleBuilder("PermissionDenied", "No user is logged in and app is unable to display login screen").f4035a);
        }
    }

    private void m5947a(String str) {
        m5954e(PlatformAppResults.m5893a(this.f4051i, "ProtocolError", str));
    }

    private void m5951b(String str) {
        String formatStrLocaleSafe;
        if (str == null) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("Expected non-null '%s' extra.", "com.facebook.platform.protocol.PROTOCOL_ACTION");
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("Unrecognized '%s' extra: '%s'.", "com.facebook.platform.protocol.PROTOCOL_ACTION", str);
        }
        m5947a(formatStrLocaleSafe);
    }

    private void m5953d(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        m5946a(bundle, null);
    }

    private void m5954e(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        m5946a(null, bundle);
    }

    private void m5946a(Bundle bundle, Bundle bundle2) {
        int i = 1;
        int i2 = -1;
        int i3 = 0;
        boolean z = (bundle == null && bundle2 == null) ? false : true;
        Preconditions.checkArgument(z);
        if (bundle2 != null) {
            i = 0;
        }
        if (this.f4056n) {
            Activity activity = this.f4050h;
            if (i != 0) {
                i3 = -1;
            }
            activity.setResult(i3);
            this.f4050h.finish();
            return;
        }
        int intExtra = this.f4052j.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        Bundle bundle3;
        if (this.f4051i != null) {
            String str = this.f4051i.f4018i;
            if (this.f4051i.f4012c) {
                bundle3 = new Bundle();
                Bundle a = PlatformAppCall.m5911a(this.f4052j);
                if (bundle2 != null) {
                    a.putBundle("error", bundle2);
                }
                a.putString("action_id", this.f4051i.f4010a);
                bundle3.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", a);
                bundle3.putString("com.facebook.platform.extra.APPLICATION_ID", this.f4051i.f4014e);
                if (str != null) {
                    bundle3.putString("com.facebook.platform.protocol.PROTOCOL_ACTION", str);
                }
                if (bundle != null) {
                    bundle3.putBundle("com.facebook.platform.protocol.RESULT_ARGS", bundle);
                }
                bundle2 = bundle3;
            } else {
                if (bundle != null) {
                    bundle2 = bundle;
                }
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                if (str != null) {
                    bundle2.putString("com.facebook.platform.protocol.PROTOCOL_ACTION", str);
                }
                if (intExtra >= 20130502) {
                    bundle2.putString("com.facebook.platform.protocol.CALL_ID", this.f4051i.f4010a);
                }
            }
        } else {
            if (bundle2 == null) {
                bundle2 = PlatformAppResults.m5893a(null, "UnknownError", "Unknown error in processing the incoming intent");
            }
            bundle3 = PlatformAppCall.m5911a(this.f4052j);
            if (bundle3 != null) {
                bundle3.putBundle("error", new Bundle(bundle2));
                bundle2.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", bundle3);
            }
        }
        Intent intent = new Intent();
        bundle2.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", intExtra);
        intent.putExtras(bundle2);
        if (i == 0) {
            i2 = 0;
        }
        this.f4050h.setResult(i2, intent);
        this.f4050h.finish();
    }
}
