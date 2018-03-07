package com.facebook.bugreporter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.abtest.qe.bootstrap.utils.ExperimentData;
import com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.bugreporter.extras.FlytrapExtras;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.diagnostics.LogReportFetcher;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.StackTraceDumper;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager$Privacy;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder$JSONOutputType;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GkAccessorByName;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.features.bugreporter.FbandroidFlytrapExtras;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.media.metadata.YEAR */
public class BugReportWriter {
    private static final Joiner f10568o = Joiner.on(", ");
    private static final String f10569p = (BugReporter.class.getSimpleName() + ".");
    private final BugReporterFileUtil f10570a;
    public final ConnectivityManager f10571b;
    private final AbstractFbErrorReporter f10572c;
    private final FlytrapExtras f10573d;
    private final GatekeeperStoreImpl f10574e;
    private final LogReportFetcher f10575f;
    private final QuickExperimentUtil f10576g;
    private final Set<BugReportExtraFileMapProvider> f10577h;
    private final Set<BugReportExtraDataMapProvider> f10578i;
    public final TempFileManager f10579j;
    public final ViewDescriptionBuilder f10580k;
    private final ListeningExecutorService f10581l;
    public final XConfigReader f10582m;
    public final Provider<ViewerContext> f10583n;

    public static BugReportWriter m18613b(InjectorLike injectorLike) {
        return new BugReportWriter(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), BugReporterFileUtil.m18646a(injectorLike), ConnectivityManagerMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FlytrapExtras) FbandroidFlytrapExtras.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), LogReportFetcher.m3639b(injectorLike), QuickExperimentUtil.m2363a(injectorLike), STATICDI_MULTIBIND_PROVIDER$BugReportExtraFileMapProvider.m18684a(injectorLike), STATICDI_MULTIBIND_PROVIDER$BugReportExtraDataMapProvider.m18683a(injectorLike), TempFileManager.a(injectorLike), ViewDescriptionBuilder.b(injectorLike), XConfigReader.a(injectorLike), IdBasedProvider.a(injectorLike, 372));
    }

    public static BugReportWriter m18602a(InjectorLike injectorLike) {
        return m18613b(injectorLike);
    }

    @Inject
    public BugReportWriter(ListeningExecutorService listeningExecutorService, BugReporterFileUtil bugReporterFileUtil, ConnectivityManager connectivityManager, FbErrorReporter fbErrorReporter, FlytrapExtras flytrapExtras, GkAccessorByName gkAccessorByName, LogReportFetcher logReportFetcher, QuickExperimentUtil quickExperimentUtil, Set<BugReportExtraFileMapProvider> set, Set<BugReportExtraDataMapProvider> set2, TempFileManager tempFileManager, ViewDescriptionBuilder viewDescriptionBuilder, XConfigReader xConfigReader, Provider<ViewerContext> provider) {
        this.f10581l = listeningExecutorService;
        this.f10570a = bugReporterFileUtil;
        this.f10571b = connectivityManager;
        this.f10572c = fbErrorReporter;
        this.f10573d = flytrapExtras;
        this.f10574e = gkAccessorByName;
        this.f10575f = logReportFetcher;
        this.f10576g = quickExperimentUtil;
        this.f10577h = set;
        this.f10578i = set2;
        this.f10579j = tempFileManager;
        this.f10580k = viewDescriptionBuilder;
        this.f10582m = xConfigReader;
        this.f10583n = provider;
    }

    public final BugReportBuilder m18624a(List<Bitmap> list, Bundle bundle, Context context, ImmutableMap<String, String> immutableMap, ImmutableSet<BugReportExtraFileMapProvider> immutableSet, BugReportSource bugReportSource) {
        String valueOf;
        BugReportingData a = BugReportingData.m18659a();
        File file = new File(this.f10570a.f10626b.getCacheDir(), "bugreports");
        do {
            valueOf = String.valueOf(System.nanoTime());
        } while (new File(file, valueOf).exists());
        String str = valueOf;
        a.f10632b = m18604a(str);
        a.f10639i = m18615b(str);
        a.f10633c = list;
        a.f10634d = bundle;
        a.f10635e = context;
        a.f10636f = immutableMap;
        a.f10637g = immutableSet;
        a.f10638h = bugReportSource;
        return m18601a();
    }

    public final BugReportBuilder m18623a(BugReportBuilder bugReportBuilder) {
        return m18616c(bugReportBuilder);
    }

    private BugReportBuilder m18601a() {
        File file;
        BugReportingData a = BugReportingData.m18659a();
        BugReportBuilder newBuilder = BugReport.newBuilder();
        newBuilder.f10439a = Uri.fromFile(a.f10632b);
        newBuilder = newBuilder;
        newBuilder.f10446h = a.f10632b.getName();
        newBuilder = newBuilder;
        newBuilder.f10456r = a.f10638h;
        BugReportBuilder bugReportBuilder = newBuilder;
        boolean a2 = this.f10582m.a(BugReportingXConfig.q, false);
        List list = a.f10633c;
        if (a2) {
            file = a.f10639i;
        } else {
            file = a.f10632b;
        }
        m18607a(bugReportBuilder, list, file);
        ViewerContext viewerContext = (ViewerContext) this.f10583n.get();
        bugReportBuilder.f10459u = viewerContext.mUserId;
        bugReportBuilder.f10460v = viewerContext.mAuthToken;
        m18608a(a);
        return bugReportBuilder;
    }

    private void m18608a(BugReportingData bugReportingData) {
        Iterator it = ImmutableSet.builder().b(this.f10577h).b(bugReportingData.m18661g()).b().iterator();
        while (it.hasNext()) {
            try {
                ((BugReportExtraFileMapProvider) it.next()).prepareDataForWriting();
            } catch (Throwable e) {
                this.f10572c.a(f10569p + "prepareDataForWriting", e);
            }
        }
    }

    private BugReportBuilder m18616c(BugReportBuilder bugReportBuilder) {
        BugReportingData a = BugReportingData.m18659a();
        Builder builder = ImmutableMap.builder();
        builder.a(a.f10636f);
        m18609a(builder);
        ImmutableMap b = builder.b();
        bugReportBuilder.f10455q = (String) b.get("StoryZombies");
        m18605a(a.f10635e, bugReportBuilder);
        m18606a(bugReportBuilder, a.f10635e, a.f10632b, a.f10639i, b, a.f10637g, a.f10634d);
        NetworkInfo activeNetworkInfo = this.f10571b.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            bugReportBuilder.f10453o = activeNetworkInfo.getTypeName();
            bugReportBuilder.f10454p = activeNetworkInfo.getSubtypeName();
        } else {
            bugReportBuilder.f10453o = "NONE";
            bugReportBuilder.f10454p = "NONE";
        }
        bugReportBuilder.f10457s = Calendar.getInstance().getTime().toString();
        return bugReportBuilder;
    }

    private File m18604a(String str) {
        File a = this.f10570a.m18655a(str);
        if (a != null) {
            return a;
        }
        throw new RuntimeException("Could not create directory");
    }

    private File m18615b(String str) {
        File b = this.f10570a.m18656b(str);
        if (b != null) {
            return b;
        }
        throw new RuntimeException("Could not create directory");
    }

    private void m18605a(Context context, BugReportBuilder bugReportBuilder) {
        ImmutableMap a;
        if (context != null) {
            a = m18603a(context);
        } else {
            a = new Builder().b();
        }
        bugReportBuilder.f10445g = a;
    }

    private void m18607a(BugReportBuilder bugReportBuilder, List<Bitmap> list, File file) {
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(m18597a((Bitmap) list.get(i), file, i));
        }
        bugReportBuilder.f10442d = arrayList;
    }

    private void m18606a(BugReportBuilder bugReportBuilder, Context context, File file, File file2, ImmutableMap<String, String> immutableMap, ImmutableSet<BugReportExtraFileMapProvider> immutableSet, Bundle bundle) {
        final File file3 = file;
        ListenableFuture a = this.f10581l.a(new Callable<Uri>(this) {
            final /* synthetic */ BugReportWriter f10528b;

            public Object call() {
                return BugReportWriter.m18599a(this.f10528b, file3);
            }
        });
        final Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        final Map synchronizedMap2 = Collections.synchronizedMap(new HashMap());
        Map hashMap = new HashMap();
        final File file4 = file2;
        final File file5 = file;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10533e;

            public Object call() {
                boolean a = this.f10533e.f10582m.a(BugReportingXConfig.m, false);
                Uri b = BugReportWriter.m18612b(this.f10533e, a ? file4 : file5);
                if (b != null) {
                    (a ? synchronizedMap2 : synchronizedMap).put("quick_experiments.txt", b.toString());
                }
                return null;
            }
        }), "quick_experiments");
        final File file6 = file2;
        final File file7 = file;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10538e;

            public Object call() {
                boolean a = this.f10538e.f10582m.a(BugReportingXConfig.f, false);
                (a ? synchronizedMap2 : synchronizedMap).putAll(BugReportWriter.m18617c(this.f10538e, a ? file6 : file7));
                return null;
            }
        }), "debug_logs");
        file4 = file2;
        file5 = file;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10543e;

            public Object call() {
                boolean a = this.f10543e.f10582m.a(BugReportingXConfig.n, false);
                Uri d = BugReportWriter.m18618d(this.f10543e, a ? file4 : file5);
                if (d != null) {
                    (a ? synchronizedMap2 : synchronizedMap).put("traces.txt", d.toString());
                }
                return null;
            }
        }), "anr_traces");
        file4 = file2;
        file5 = file;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10548e;

            public Object call() {
                boolean a = this.f10548e.f10582m.a(BugReportingXConfig.j, false);
                Uri e = this.f10548e.m18622f(a ? file4 : file5);
                if (e != null) {
                    (a ? synchronizedMap2 : synchronizedMap).put("gatekeepers.txt", e.toString());
                }
                return null;
            }
        }), "gatekeepers");
        file4 = file2;
        file5 = file;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10553e;

            public Object call() {
                boolean a = this.f10553e.f10582m.a(BugReportingXConfig.o, false);
                Uri f = this.f10553e.m18620e(a ? file4 : file5);
                if (f != null) {
                    (a ? synchronizedMap2 : synchronizedMap).put("stacktrace-dump.txt", f.toString());
                }
                return null;
            }
        }), "stack_trace_dump");
        if (context instanceof FragmentManagerHost) {
            final Context context2 = context;
            hashMap.put(this.f10581l.a(new Callable<Void>(this) {
                final /* synthetic */ BugReportWriter f10557d;

                public Object call() {
                    (this.f10557d.f10582m.a(BugReportingXConfig.g, false) ? synchronizedMap2 : synchronizedMap).put("dumpsys.txt", BugReportWriter.m18598a(this.f10557d, (FragmentManagerHost) context2).toString());
                    return null;
                }
            }), "sysdump");
        }
        final File file8 = file2;
        final File file9 = file;
        final ImmutableMap<String, String> immutableMap2 = immutableMap;
        final Map map = synchronizedMap2;
        final Map map2 = synchronizedMap;
        hashMap.put(this.f10581l.a(new Callable<Void>(this) {
            final /* synthetic */ BugReportWriter f10563f;

            public Object call() {
                boolean a = this.f10563f.f10582m.a(BugReportingXConfig.h, false);
                Uri a2 = BugReportWriter.m18600a(this.f10563f, a ? file8 : file9, immutableMap2);
                if (a2 != null) {
                    (a ? map : map2).put("extra_data.txt", a2.toString());
                }
                return null;
            }
        }), "debug_info");
        if (bundle != null) {
            final Bundle bundle2 = bundle;
            hashMap.put(this.f10581l.a(new Callable<Void>(this) {
                final /* synthetic */ BugReportWriter f10567d;

                public Object call() {
                    boolean a = this.f10567d.f10582m.a(BugReportingXConfig.p, false);
                    BugReportWriter bugReportWriter = this.f10567d;
                    Bundle bundle = bundle2;
                    File a2 = bugReportWriter.f10579j.a("view_hierarchy", null, true);
                    bugReportWriter.f10580k.a(a2, ViewDescriptionBuilder$JSONOutputType.PRETTY, bundle);
                    (a ? synchronizedMap2 : synchronizedMap).put("view_hierarchy.txt", Uri.fromFile(a2).toString());
                    return null;
                }
            }), "view_hierarchy");
        }
        m18611a(file, file2, synchronizedMap, synchronizedMap2, immutableSet);
        boolean a2 = this.f10582m.a(BugReportingXConfig.D, true);
        int a3 = this.f10582m.a(BugReportingXConfig.E, 15);
        Iterable arrayList = new ArrayList();
        for (Future future : hashMap.keySet()) {
            if (a2) {
                try {
                    FutureDetour.a(future, (long) a3, TimeUnit.SECONDS, -287085039);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str = (String) hashMap.get(future);
                    this.f10572c.a("bugReportAttachmentFutureTimeout", "Bug report attachment future timed out: " + str, th);
                    future.cancel(true);
                    arrayList.add(str);
                }
            } else {
                FutureDetour.a(future, -1601042416);
            }
        }
        bugReportBuilder.m18534a(Uri.fromFile(file)).m18541n(arrayList.isEmpty() ? "none" : TextUtils.join(", ", arrayList)).m18536a(new Builder().a(synchronizedMap).b()).m18538b(new Builder().a(synchronizedMap2).b()).m18537b((Uri) FutureDetour.a(a, -1854745821)).m18539c(Calendar.getInstance().getTime().toString());
    }

    private Uri m18597a(Bitmap bitmap, File file, int i) {
        try {
            BugReportAttachment a = BugReporterFileUtil.m18645a(file, StringFormatUtil.formatStrLocaleSafe("screenshot%d.png", Integer.valueOf(i)));
            try {
                bitmap.compress(CompressFormat.PNG, 100, a.m18526a());
                a.m18526a().flush();
                Uri b = a.m18527b();
                return b;
            } finally {
                Closeables.a(a.m18526a(), false);
            }
        } catch (Throwable e) {
            BLog.a("BugReportWriter", "Exception saving screenshot", e);
            return null;
        }
    }

    private void m18609a(Builder<String, String> builder) {
        for (BugReportExtraDataMapProvider d : this.f10578i) {
            try {
                Map d2 = d.d();
                if (d2 != null) {
                    builder.a(d2);
                }
            } catch (Throwable e) {
                this.f10572c.a(f10569p + "addExtraDataFromWorkerThread", e);
            }
        }
    }

    private ImmutableMap<String, String> m18603a(Context context) {
        Builder builder = ImmutableMap.builder();
        try {
            builder.a(this.f10573d.mo1128a(context));
        } catch (Throwable e) {
            this.f10572c.a("BugReporter.getFlytrapExtrasFromWorkerThread", e);
        }
        return builder.b();
    }

    public static Uri m18599a(BugReportWriter bugReportWriter, File file) {
        try {
            return BugReporterFileUtil.m18651b(file, "report.txt");
        } catch (Throwable e) {
            bugReportWriter.f10572c.a(f10569p + "generateAcraReport", e);
            return null;
        }
    }

    @Nullable
    public static Uri m18612b(BugReportWriter bugReportWriter, File file) {
        BugReportAttachment a;
        BufferedWriter bufferedWriter;
        Throwable e;
        try {
            a = BugReporterFileUtil.m18645a(file, "quick_experiments.txt");
            try {
                ImmutableList<ExperimentData> a2 = bugReportWriter.f10576g.m2365a();
                bufferedWriter = new BufferedWriter(new PrintWriter(a.m18526a()));
                try {
                    for (ExperimentData experimentData : a2) {
                        bufferedWriter.write(experimentData.m2359a());
                        bufferedWriter.newLine();
                        m18610a(bufferedWriter, experimentData);
                        bufferedWriter.newLine();
                    }
                    Uri b = a.m18527b();
                    try {
                        bufferedWriter.close();
                    } catch (Throwable e2) {
                        BLog.a("BugReportWriter", "Exception closing quick experiments report.", e2);
                    }
                    if (a == null) {
                        return b;
                    }
                    try {
                        a.m18526a().close();
                        return b;
                    } catch (Throwable e22) {
                        BLog.a("BugReportWriter", "Exception closing attachment stream.", e22);
                        return b;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        BLog.a("BugReportWriter", "Exception saving quick experiments", e);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable e4) {
                                BLog.a("BugReportWriter", "Exception closing quick experiments report.", e4);
                            }
                        }
                        if (a != null) {
                            try {
                                a.m18526a().close();
                            } catch (Throwable e42) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e42);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e42 = th;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable e222) {
                                BLog.a("BugReportWriter", "Exception closing quick experiments report.", e222);
                            }
                        }
                        if (a != null) {
                            try {
                                a.m18526a().close();
                            } catch (Throwable e2222) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e2222);
                            }
                        }
                        throw e42;
                    }
                }
            } catch (IOException e5) {
                e42 = e5;
                bufferedWriter = null;
                BLog.a("BugReportWriter", "Exception saving quick experiments", e42);
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (a != null) {
                    a.m18526a().close();
                }
                return null;
            } catch (Throwable th2) {
                e42 = th2;
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (a != null) {
                    a.m18526a().close();
                }
                throw e42;
            }
        } catch (IOException e6) {
            e42 = e6;
            a = null;
            bufferedWriter = null;
            BLog.a("BugReportWriter", "Exception saving quick experiments", e42);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (a != null) {
                a.m18526a().close();
            }
            return null;
        } catch (Throwable th3) {
            e42 = th3;
            a = null;
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (a != null) {
                a.m18526a().close();
            }
            throw e42;
        }
    }

    public static Map m18617c(BugReportWriter bugReportWriter, File file) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        Map c = Maps.c();
        ImmutableList b = bugReportWriter.m18614b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            File file2 = (File) b.get(i);
            String str = "debuglog-" + simpleDateFormat.format(new Date(file2.lastModified())) + ".txt";
            try {
                BugReportAttachment a = BugReporterFileUtil.m18645a(file, str);
                BugReporterFileUtil.m18649a(file2, a);
                c.put(str, a.m18527b().toString());
            } catch (Throwable e) {
                BLog.b("BugReportWriter", "Unable to copy debug log file", e);
            }
        }
        return c;
    }

    @Nullable
    public static Uri m18618d(BugReportWriter bugReportWriter, File file) {
        try {
            BugReportAttachment a = BugReporterFileUtil.m18645a(file, "traces.txt");
            BugReporterFileUtil.m18649a(new File("/data/anr/traces.txt"), a);
            return a.m18527b();
        } catch (Throwable e) {
            BLog.b("BugReportWriter", "Unable to copy traces file", e);
            return null;
        }
    }

    @Nullable
    public static Uri m18600a(BugReportWriter bugReportWriter, File file, ImmutableMap immutableMap) {
        BugReportAttachment a;
        BufferedWriter bufferedWriter;
        Throwable e;
        BugReportAttachment bugReportAttachment;
        BufferedWriter bufferedWriter2;
        try {
            a = BugReporterFileUtil.m18645a(file, "extra_data.txt");
            try {
                bufferedWriter = new BufferedWriter(new PrintWriter(new OutputStreamWriter(a.m18526a(), "UTF8")));
                try {
                    Iterator it = immutableMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        bufferedWriter.write(((String) entry.getKey()).replaceAll("[^a-zA-Z0-9_ ]", "_"));
                        bufferedWriter.write(9);
                        bufferedWriter.write((String) entry.getValue());
                        bufferedWriter.newLine();
                    }
                    Uri b = a.m18527b();
                    try {
                        bufferedWriter.close();
                    } catch (Throwable e2) {
                        BLog.a("BugReportWriter", "Exception closing DebugInfo report.", e2);
                    }
                    if (a == null) {
                        return b;
                    }
                    try {
                        a.m18526a().close();
                        return b;
                    } catch (Throwable e22) {
                        BLog.a("BugReportWriter", "Exception closing attachment stream.", e22);
                        return b;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bugReportAttachment = a;
                    bufferedWriter2 = bufferedWriter;
                    try {
                        BLog.a("BugReportWriter", "Exception saving DebugInfo", e);
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (Throwable e4) {
                                BLog.a("BugReportWriter", "Exception closing DebugInfo report.", e4);
                            }
                        }
                        if (bugReportAttachment != null) {
                            try {
                                bugReportAttachment.m18526a().close();
                            } catch (Throwable e42) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e42);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e42 = th;
                        bufferedWriter = bufferedWriter2;
                        a = bugReportAttachment;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable e222) {
                                BLog.a("BugReportWriter", "Exception closing DebugInfo report.", e222);
                            }
                        }
                        if (a != null) {
                            try {
                                a.m18526a().close();
                            } catch (Throwable e2222) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e2222);
                            }
                        }
                        throw e42;
                    }
                } catch (Throwable th2) {
                    e42 = th2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (a != null) {
                        a.m18526a().close();
                    }
                    throw e42;
                }
            } catch (IOException e5) {
                e42 = e5;
                bugReportAttachment = a;
                bufferedWriter2 = null;
                BLog.a("BugReportWriter", "Exception saving DebugInfo", e42);
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                if (bugReportAttachment != null) {
                    bugReportAttachment.m18526a().close();
                }
                return null;
            } catch (Throwable th3) {
                e42 = th3;
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (a != null) {
                    a.m18526a().close();
                }
                throw e42;
            }
        } catch (IOException e6) {
            e42 = e6;
            bugReportAttachment = null;
            bufferedWriter2 = null;
            BLog.a("BugReportWriter", "Exception saving DebugInfo", e42);
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (bugReportAttachment != null) {
                bugReportAttachment.m18526a().close();
            }
            return null;
        } catch (Throwable th4) {
            e42 = th4;
            a = null;
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (a != null) {
                a.m18526a().close();
            }
            throw e42;
        }
    }

    public static Uri m18598a(BugReportWriter bugReportWriter, FragmentManagerHost fragmentManagerHost) {
        PrintWriter printWriter;
        Throwable e;
        File a = bugReportWriter.f10579j.a("dumpsys.txt", null, TempFileManager$Privacy.REQUIRE_PRIVATE);
        try {
            OutputStream fileOutputStream = new FileOutputStream(a);
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            FileDescriptor fd = fileOutputStream.getFD();
            printWriter = new PrintWriter(bufferedOutputStream);
            try {
                fragmentManagerHost.kO_().a("", fd, printWriter, new String[0]);
                printWriter.close();
            } catch (IOException e2) {
                e = e2;
                try {
                    BLog.b("BugReportWriter", e, "Failed to sysdump activity", new Object[0]);
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    return Uri.fromFile(a);
                } catch (Throwable th) {
                    e = th;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            printWriter = null;
            BLog.b("BugReportWriter", e, "Failed to sysdump activity", new Object[0]);
            if (printWriter != null) {
                printWriter.close();
            }
            return Uri.fromFile(a);
        } catch (Throwable th2) {
            e = th2;
            printWriter = null;
            if (printWriter != null) {
                printWriter.close();
            }
            throw e;
        }
        return Uri.fromFile(a);
    }

    @Nullable
    private Uri m18620e(File file) {
        try {
            BugReportAttachment a = BugReporterFileUtil.m18645a(file, "stacktrace-dump.txt");
            try {
                StackTraceDumper.m3647a(a.m18526a());
                Uri b = a.m18527b();
                return b;
            } finally {
                Closeables.a(a.m18526a(), false);
            }
        } catch (Throwable e) {
            BLog.a("BugReportWriter", "Exception saving stack trace", e);
            return null;
        }
    }

    private static void m18610a(BufferedWriter bufferedWriter, ExperimentData experimentData) {
        int size = experimentData.groupNames.size();
        for (int i = 0; i < size; i++) {
            Iterable arrayList = new ArrayList();
            bufferedWriter.write("  ");
            bufferedWriter.write((String) experimentData.groupNames.get(i));
            if (i == experimentData.serverAssignedGroupIndex) {
                arrayList.add("server group");
            }
            if (i == experimentData.clientOverrideGroupIndex) {
                arrayList.add("client override");
            }
            if (!arrayList.isEmpty()) {
                bufferedWriter.write(" (");
                bufferedWriter.write(f10568o.join(arrayList));
                bufferedWriter.write(")");
            }
        }
    }

    @Nullable
    private Uri m18622f(File file) {
        BugReportAttachment a;
        BufferedWriter bufferedWriter;
        Throwable e;
        BugReportAttachment bugReportAttachment;
        BufferedWriter bufferedWriter2;
        try {
            a = BugReporterFileUtil.m18645a(file, "gatekeepers.txt");
            try {
                Map a2 = this.f10574e.a();
                bufferedWriter = new BufferedWriter(new PrintWriter(a.m18526a()));
                try {
                    for (Entry entry : a2.entrySet()) {
                        bufferedWriter.write(((String) entry.getKey()) + " = " + ((String) entry.getValue()));
                        bufferedWriter.newLine();
                    }
                    Uri b = a.m18527b();
                    try {
                        bufferedWriter.close();
                    } catch (Throwable e2) {
                        BLog.a("BugReportWriter", "Exception closing Gatekeepers report.", e2);
                    }
                    if (a == null) {
                        return b;
                    }
                    try {
                        a.m18526a().close();
                        return b;
                    } catch (Throwable e22) {
                        BLog.a("BugReportWriter", "Exception closing attachment stream.", e22);
                        return b;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bugReportAttachment = a;
                    bufferedWriter2 = bufferedWriter;
                    try {
                        BLog.a("BugReportWriter", "Exception saving Gatekeepers.", e);
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (Throwable e4) {
                                BLog.a("BugReportWriter", "Exception closing Gatekeepers report.", e4);
                            }
                        }
                        if (bugReportAttachment != null) {
                            try {
                                bugReportAttachment.m18526a().close();
                            } catch (Throwable e42) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e42);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e42 = th;
                        bufferedWriter = bufferedWriter2;
                        a = bugReportAttachment;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable e222) {
                                BLog.a("BugReportWriter", "Exception closing Gatekeepers report.", e222);
                            }
                        }
                        if (a != null) {
                            try {
                                a.m18526a().close();
                            } catch (Throwable e2222) {
                                BLog.a("BugReportWriter", "Exception closing attachment stream.", e2222);
                            }
                        }
                        throw e42;
                    }
                } catch (Throwable th2) {
                    e42 = th2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (a != null) {
                        a.m18526a().close();
                    }
                    throw e42;
                }
            } catch (IOException e5) {
                e42 = e5;
                bugReportAttachment = a;
                bufferedWriter2 = null;
                BLog.a("BugReportWriter", "Exception saving Gatekeepers.", e42);
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                if (bugReportAttachment != null) {
                    bugReportAttachment.m18526a().close();
                }
                return null;
            } catch (Throwable th3) {
                e42 = th3;
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (a != null) {
                    a.m18526a().close();
                }
                throw e42;
            }
        } catch (IOException e6) {
            e42 = e6;
            bugReportAttachment = null;
            bufferedWriter2 = null;
            BLog.a("BugReportWriter", "Exception saving Gatekeepers.", e42);
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (bugReportAttachment != null) {
                bugReportAttachment.m18526a().close();
            }
            return null;
        } catch (Throwable th4) {
            e42 = th4;
            a = null;
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (a != null) {
                a.m18526a().close();
            }
            throw e42;
        }
    }

    private ImmutableList<File> m18614b() {
        try {
            return this.f10575f.m3640a(2);
        } catch (Throwable e) {
            this.f10572c.a(f10569p + "getRecentLogFiles", e);
            return ImmutableList.of();
        }
    }

    private void m18611a(File file, File file2, Map<String, String> map, Map<String, String> map2, ImmutableSet<BugReportExtraFileMapProvider> immutableSet) {
        Iterator it = ImmutableSet.builder().b(this.f10577h).b(immutableSet).b().iterator();
        while (it.hasNext()) {
            BugReportExtraFileMapProvider bugReportExtraFileMapProvider = (BugReportExtraFileMapProvider) it.next();
            try {
                boolean shouldSendAsync = bugReportExtraFileMapProvider.shouldSendAsync();
                Map extraFileFromWorkerThread = bugReportExtraFileMapProvider.getExtraFileFromWorkerThread(shouldSendAsync ? file2 : file);
                if (extraFileFromWorkerThread != null) {
                    Map map3;
                    if (shouldSendAsync) {
                        map3 = map2;
                    } else {
                        Map<String, String> map4 = map;
                    }
                    map3.putAll(extraFileFromWorkerThread);
                }
            } catch (Throwable e) {
                this.f10572c.a(f10569p + "addExtraFileFromWorkerThread", e);
            }
        }
    }
}
