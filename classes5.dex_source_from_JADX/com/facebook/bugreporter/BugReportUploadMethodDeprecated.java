package com.facebook.bugreporter;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.debug.log.BLog;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ByteArrayBody;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.http.protocol.DataStreamBodyWithOffset;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: android.os.ServiceManager */
public class BugReportUploadMethodDeprecated implements ApiMethod<BugReportUploadParams, String> {
    private static final Class<?> f10494a = BugReportUploadMethodDeprecated.class;
    private final Locales f10495b;
    private final ParamsCollectionPool f10496c = ParamsCollectionPool.a();
    private final XConfigReader f10497d;

    public final ApiRequest m18568a(Object obj) {
        String str;
        BugReportUploadParams bugReportUploadParams = (BugReportUploadParams) obj;
        ParamsCollectionMap b = this.f10496c.b();
        b.a(ParamsJsonEncoder.a());
        b.a("desc", bugReportUploadParams.m18571b());
        b.a("log", bugReportUploadParams.m18575f());
        b.a("format", "json-strings");
        b.a("network_type", bugReportUploadParams.m18582m());
        b.a("network_subtype", bugReportUploadParams.m18583n());
        b.a("build_num", bugReportUploadParams.m18579j());
        if (!(bugReportUploadParams.m18585p() == null || bugReportUploadParams.m18585p() == BugReportSource.DEFAULT)) {
            b.a("source", bugReportUploadParams.m18585p().getName());
        }
        ImmutableMap q = bugReportUploadParams.m18586q();
        if (q != null) {
            Iterator it = q.keySet().iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                String str2 = (String) q.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    b.a(str, str2);
                }
            }
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("Git_Hash", bugReportUploadParams.m18578i());
        str = bugReportUploadParams.m18581l();
        if (str != null) {
            objectNode.a("Git_Branch", str);
        }
        str = bugReportUploadParams.m18580k();
        if (str != null) {
            objectNode.a("Build_Time", str);
        }
        objectNode.a("Report_ID", bugReportUploadParams.m18570a());
        objectNode.a("Build_Num", bugReportUploadParams.m18579j());
        objectNode.a("OS_Version", VERSION.RELEASE);
        objectNode.a("Manufacturer", Build.MANUFACTURER);
        objectNode.a("Model", Build.MODEL);
        objectNode.a("Device Locale", Locales.e().getDisplayName(Locale.US));
        objectNode.a("App Locale", this.f10495b.a().getDisplayName(Locale.US));
        objectNode.a("Zombie(s)", bugReportUploadParams.m18584o());
        objectNode.a("Sent_On_Retry", bugReportUploadParams.m18587r() ? "True" : "False");
        objectNode.a("Creation_Time", bugReportUploadParams.m18588s());
        objectNode.a("Send_Time", Calendar.getInstance().getTime().toString());
        objectNode.a("Timed_Out_Attachments", bugReportUploadParams.m18589t());
        b.a("info", objectNode.toString());
        if (bugReportUploadParams.m18576g() != null) {
            b.a("category_id", bugReportUploadParams.m18576g());
        }
        if (bugReportUploadParams.m18577h() != null) {
            b.a("duplicate_bug_id", bugReportUploadParams.m18577h());
        }
        boolean a = this.f10497d.a(BugReportingXConfig.q, false);
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        Iterator it2 = bugReportUploadParams.m18574e().keySet().iterator();
        while (it2.hasNext()) {
            objectNode2.a((String) it2.next(), 1);
        }
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (!(bugReportUploadParams.m18572c() == null || bugReportUploadParams.m18572c().isEmpty())) {
            int i = 0;
            ImmutableList c = bugReportUploadParams.m18572c();
            int size = c.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                try {
                    File file = new File(new URI(((Uri) c.get(i2)).toString()));
                    if (file.exists() && file.canRead()) {
                        str = StringFormatUtil.formatStrLocaleSafe("screenshot-%d.png", Integer.valueOf(i));
                        if (a) {
                            objectNode2.a(str, 1);
                        } else {
                            arrayList.add(new FormBodyPart(str, new DataStreamBody(file, "image/png", str)));
                        }
                        i3 = i + 1;
                        i2++;
                        i = i3;
                    } else {
                        BLog.a(f10494a, "Ignoring invalid screen shot file");
                        i3 = i;
                        i2++;
                        i = i3;
                    }
                } catch (Throwable e) {
                    BLog.a(f10494a, "Ignoring invalid screen shot", e);
                    stringBuilder.append(ExceptionUtil.a(e)).append("\n");
                    i3 = i;
                }
            }
        }
        b.a("attachment_file_names", objectNode2.toString());
        Iterator it3 = bugReportUploadParams.m18573d().entrySet().iterator();
        while (it3.hasNext()) {
            Entry entry = (Entry) it3.next();
            String str3 = (String) entry.getKey();
            try {
                File file2 = new File(new URI((String) entry.getValue()));
                if (file2.exists()) {
                    str = str3.toLowerCase(Locale.getDefault());
                    String str4 = (str.endsWith(".jpg") || str.endsWith(".jpeg")) ? "image/jpeg" : "text/plain";
                    arrayList.add(new FormBodyPart(str3, new DataStreamBodyWithOffset(file2, str4, str3, 0, file2.length())));
                } else {
                    BLog.b(f10494a, "Ignoring invalid debug attachment");
                    stringBuilder.append("Attachment file not found, skipping: ").append(str3).append("\n");
                }
            } catch (Throwable e2) {
                BLog.b(f10494a, e2, "Ignoring invalid debug attachment: %s", new Object[]{str3});
                stringBuilder.append(ExceptionUtil.a(e2)).append("\n");
            }
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(new FormBodyPart("missing_attachment_report.txt", new ByteArrayBody(StringUtil.a(stringBuilder.toString()), "text/plain", "missing_attachment_report.txt")));
        }
        return ApiRequest.newBuilder().a("bugReportUpload").c("POST").d("method/bug.create").a(b).a(ApiResponseType.JSON).b(arrayList).C();
    }

    @Inject
    public BugReportUploadMethodDeprecated(Locales locales, XConfigReader xConfigReader) {
        this.f10495b = locales;
        this.f10497d = xConfigReader;
    }

    public final Object m18569a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.b == 200) {
            return apiResponse.c().b("bug_id").B();
        }
        BLog.b(f10494a, StringLocaleUtil.a("Bug report upload failed: %s", new Object[]{StringFormatUtil.formatStrLocaleSafe("error code: %d, msg: %s", Integer.valueOf(apiResponse.b), apiResponse.c.toString())}));
        return null;
    }
}
