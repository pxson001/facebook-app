package com.facebook.orca.threadview;

import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.messaging.database.serialization.MessageDebugDataSerializationHelper;
import com.facebook.messaging.model.messages.Message;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: messenger_location_map_view */
public class MessageSendFailedDataFileProvider implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private final AbstractFbErrorReporter f7215a;
    private final Message f7216b;
    private final MessageDebugDataSerializationHelper f7217c;
    private final XConfigReader f7218d;

    @Inject
    public MessageSendFailedDataFileProvider(@Assisted Message message, AbstractFbErrorReporter abstractFbErrorReporter, MessageDebugDataSerializationHelper messageDebugDataSerializationHelper, XConfigReader xConfigReader) {
        this.f7216b = message;
        this.f7215a = abstractFbErrorReporter;
        this.f7217c = messageDebugDataSerializationHelper;
        this.f7218d = xConfigReader;
    }

    public boolean shouldSendAsync() {
        return this.f7218d.a(BugReportingXConfig.v, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        try {
            Uri a = m6912a(file);
            Map<String, String> hashMap = new HashMap();
            hashMap.put("message_send_fail_json.txt", a.toString());
            return hashMap;
        } catch (Throwable e) {
            this.f7215a.a("MessageSendFailedDataFileProvider", e);
            return null;
        }
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        try {
            Uri a = m6912a(file);
            List arrayList = new ArrayList();
            arrayList.add(new BugReportFile("message_send_fail_json.txt", a.toString(), "text/plain"));
            return arrayList;
        } catch (Throwable e) {
            throw new IOException("Failed to write message failed Info file", e);
        }
    }

    @VisibleForTesting
    private Uri m6912a(File file) {
        Throwable th;
        File file2 = new File(file, "message_send_fail_json.txt");
        PrintWriter printWriter = new PrintWriter(file2);
        Throwable th2 = null;
        try {
            printWriter.write(this.f7217c.a(this.f7216b).toString());
            printWriter.close();
            return Uri.fromFile(file2);
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (th22 != null) {
            try {
                printWriter.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            printWriter.close();
        }
        throw th;
        throw th;
    }
}
