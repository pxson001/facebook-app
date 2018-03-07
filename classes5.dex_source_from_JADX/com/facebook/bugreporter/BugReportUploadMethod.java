package com.facebook.bugreporter;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.debug.log.BLog;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.people */
public class BugReportUploadMethod implements ApiMethod<BugReportUploadParams, String> {
    private static final String f10489a = BugReportUploadMethod.class.getSimpleName();
    private final Provider<String> f10490b;
    public final Locales f10491c;
    private final ParamsCollectionPool f10492d = ParamsCollectionPool.a();
    private final XConfigReader f10493e;

    public final ApiRequest m18566a(Object obj) {
        BugReportUploadParams bugReportUploadParams = (BugReportUploadParams) obj;
        ParamsCollectionMap b = m18563b(bugReportUploadParams);
        List e = m18565e(bugReportUploadParams);
        String str = (String) this.f10490b.get();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "bugReportUpload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str + "/bugs";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.h = b;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = e;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public BugReportUploadMethod(Provider<String> provider, Locales locales, XConfigReader xConfigReader) {
        this.f10490b = provider;
        this.f10491c = locales;
        this.f10493e = xConfigReader;
    }

    private ParamsCollectionMap m18563b(BugReportUploadParams bugReportUploadParams) {
        ParamsCollectionMap b = this.f10492d.b();
        b.a(ParamsJsonEncoder.a());
        b.a("user_identifier", (String) this.f10490b.get());
        b.a("client_time", Long.toString(new Date(bugReportUploadParams.f10516s).getTime() / 1000));
        b.a("config_id", "624618737631578");
        m18562a(bugReportUploadParams, b.b("metadata"));
        return b;
    }

    private void m18562a(BugReportUploadParams bugReportUploadParams, ParamsCollectionMap paramsCollectionMap) {
        String str;
        paramsCollectionMap.a(ParamsJsonEncoder.a());
        paramsCollectionMap.a("description", bugReportUploadParams.f10499b);
        paramsCollectionMap.a("category_id", bugReportUploadParams.f10505h);
        paramsCollectionMap.a("network_type", bugReportUploadParams.f10511n);
        paramsCollectionMap.a("network_subtype", bugReportUploadParams.f10512o);
        paramsCollectionMap.a("build_num", bugReportUploadParams.f10508k);
        paramsCollectionMap.a("source", bugReportUploadParams.f10514q.getName());
        ImmutableMap immutableMap = bugReportUploadParams.f10503f;
        if (immutableMap != null) {
            Iterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                String str2 = (String) immutableMap.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    paramsCollectionMap.a(str, str2);
                }
            }
        }
        str = "misc_info";
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("Git_Hash", bugReportUploadParams.f10507j);
        String str3 = bugReportUploadParams.f10510m;
        if (str3 != null) {
            objectNode.a("Git_Branch", str3);
        }
        str3 = bugReportUploadParams.f10509l;
        if (str3 != null) {
            objectNode.a("Build_Time", str3);
        }
        objectNode.a("Report_ID", bugReportUploadParams.f10498a);
        objectNode.a("Build_Num", bugReportUploadParams.f10508k);
        objectNode.a("OS_Version", VERSION.RELEASE);
        objectNode.a("Manufacturer", Build.MANUFACTURER);
        objectNode.a("Model", Build.MODEL);
        objectNode.a("Device Locale", Locales.e().getDisplayName(Locale.US));
        objectNode.a("App Locale", this.f10491c.a().getDisplayName(Locale.US));
        objectNode.a("Zombie(s)", bugReportUploadParams.f10513p);
        String str4 = "Sent_On_Retry";
        if (bugReportUploadParams.f10515r) {
            str3 = "True";
        } else {
            str3 = "False";
        }
        objectNode.a(str4, str3);
        objectNode.a("Creation_Time", bugReportUploadParams.f10516s);
        objectNode.a("Send_Time", Calendar.getInstance().getTime().toString());
        objectNode.a("Timed_Out_Attachments", bugReportUploadParams.f10517t);
        paramsCollectionMap.a(str, objectNode.toString());
        paramsCollectionMap.a("attachment_file_names", m18564c(bugReportUploadParams));
    }

    private String m18564c(BugReportUploadParams bugReportUploadParams) {
        int i = 0;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (this.f10493e.a(BugReportingXConfig.q, false) && bugReportUploadParams.f10500c != null) {
            int size = bugReportUploadParams.f10500c.size();
            while (i < size) {
                objectNode.a(StringFormatUtil.formatStrLocaleSafe("screenshot-%d.png", Integer.valueOf(i)), 1);
                i++;
            }
        }
        Iterator it = bugReportUploadParams.f10502e.keySet().iterator();
        while (it.hasNext()) {
            objectNode.a((String) it.next(), 1);
        }
        return objectNode.toString();
    }

    public final Object m18567a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.b == 200) {
            return apiResponse.c().b("id").B();
        }
        BLog.b(f10489a, "Bug report upload failed, error code: %d, msg: %s", new Object[]{Integer.valueOf(apiResponse.b), apiResponse.c.toString()});
        return null;
    }

    private List<FormBodyPart> m18565e(BugReportUploadParams bugReportUploadParams) {
        List<FormBodyPart> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (!(this.f10493e.a(BugReportingXConfig.q, false) || bugReportUploadParams.m18572c() == null || bugReportUploadParams.m18572c().isEmpty())) {
            ImmutableList c = bugReportUploadParams.m18572c();
            int size = c.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                try {
                    File file = new File(new URI(((Uri) c.get(i)).toString()));
                    if (file.exists() && file.canRead()) {
                        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("screenshot-%d.png", Integer.valueOf(i2));
                        arrayList.add(new FormBodyPart(formatStrLocaleSafe, new DataStreamBody(file, "image/png", formatStrLocaleSafe)));
                        i3 = i2 + 1;
                        i++;
                        i2 = i3;
                    } else {
                        BLog.a(f10489a, "Ignoring invalid screen shot file");
                        i3 = i2;
                        i++;
                        i2 = i3;
                    }
                } catch (Throwable e) {
                    BLog.a(f10489a, "Ignoring invalid screen shot", e);
                    stringBuilder.append(ExceptionUtil.a(e)).append("\n");
                    i3 = i2;
                }
            }
        }
        Iterator it = bugReportUploadParams.m18573d().entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = (String) entry.getKey();
            try {
                File file2 = new File(new URI((String) entry.getValue()));
                if (file2.exists()) {
                    formatStrLocaleSafe = str.toLowerCase(this.f10491c.a());
                    String str2 = (formatStrLocaleSafe.endsWith(".jpg") || formatStrLocaleSafe.endsWith(".jpeg")) ? "image/jpeg" : "text/plain";
                    arrayList.add(new FormBodyPart(str, new DataStreamBodyWithOffset(file2, str2, str, 0, file2.length())));
                } else {
                    BLog.b(f10489a, "Ignoring invalid debug attachment");
                    stringBuilder.append("Attachment file not found, skipping: ").append(str).append("\n");
                }
            } catch (Throwable e2) {
                BLog.b(f10489a, e2, "Ignoring invalid debug attachment: %s", new Object[]{str});
                stringBuilder.append(ExceptionUtil.a(e2)).append("\n");
            }
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(new FormBodyPart("missing_attachment_report.txt", new ByteArrayBody(StringUtil.a(stringBuilder.toString()), "text/plain", "missing_attachment_report.txt")));
        }
        return arrayList;
    }
}
