package com.facebook.xconfig.bugreporting;

import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.facebook.xconfig.core.XConfigInformation;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigRegistry;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Cloneable; */
public class XConfigExtraFileProvider implements BugReportExtraFileMapProvider {
    private static final Class<?> f13990a = XConfigExtraFileProvider.class;
    private final XConfigReader f13991b;
    private final Lazy<XConfigRegistry> f13992c;

    @Inject
    public XConfigExtraFileProvider(XConfigReader xConfigReader, Lazy<XConfigRegistry> lazy) {
        this.f13991b = xConfigReader;
        this.f13992c = lazy;
    }

    public boolean shouldSendAsync() {
        return this.f13991b.a(BugReportingXConfig.C, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Builder builder = ImmutableMap.builder();
        try {
            builder.b("xconfigs.txt", m15114a(file).toString());
        } catch (Throwable e) {
            BLog.a(f13990a, "Exception saving report data file", e);
        }
        return builder.b();
    }

    public void prepareDataForWriting() {
    }

    private Uri m15114a(File file) {
        Throwable th;
        Throwable th2;
        File file2 = new File(file, "xconfigs.txt");
        OutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            ImmutableMap a = ((XConfigRegistry) this.f13992c.get()).a();
            Iterator it = a.keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Iterator it2 = ((XConfigInformation) a.get(str)).b.iterator();
                while (it2.hasNext()) {
                    XConfigSetting xConfigSetting = (XConfigSetting) it2.next();
                    printWriter.println("config: " + str + ", setting: " + xConfigSetting + ", value: " + this.f13991b.a(xConfigSetting, "<not set>"));
                }
            }
            printWriter.flush();
            Uri fromFile = Uri.fromFile(file2);
            fileOutputStream.close();
            return fromFile;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (th22 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            fileOutputStream.close();
        }
        throw th;
    }
}
