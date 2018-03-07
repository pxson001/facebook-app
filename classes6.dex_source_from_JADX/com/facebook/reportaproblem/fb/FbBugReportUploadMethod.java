package com.facebook.reportaproblem.fb;

import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ByteArrayBody;
import com.facebook.http.protocol.DataStreamBodyWithOffset;
import com.facebook.reportaproblem.base.bugreport.BugReportRequest;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.google.common.collect.Lists;
import java.io.File;
import java.net.URI;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: setPlaceholderImageParams */
public class FbBugReportUploadMethod implements ApiMethod<BugReportRequest, Boolean> {
    private static final Class<?> f4608a = FbBugReportUploadMethod.class;

    public final ApiRequest m7118a(Object obj) {
        BugReportRequest bugReportRequest = (BugReportRequest) obj;
        List a = bugReportRequest.m7039a();
        a.add(new BasicNameValuePair("format", "json-strings"));
        List a2 = Lists.a();
        StringBuilder stringBuilder = new StringBuilder();
        for (BugReportFile bugReportFile : bugReportRequest.m7041c()) {
            try {
                File file = new File(new URI(bugReportFile.b()));
                if (file.exists()) {
                    a2.add(new FormBodyPart(bugReportFile.a(), new DataStreamBodyWithOffset(file, bugReportFile.c(), bugReportFile.a(), 0, file.length())));
                } else {
                    BLog.b(f4608a.getName(), "Ignoring invalid debug attachment");
                    stringBuilder.append("Attachment file not found, skipping: ").append(bugReportFile.a()).append("\n");
                }
            } catch (Throwable e) {
                BLog.b(f4608a.getName(), "Ignoring invalid debug attachment", e);
                stringBuilder.append(ExceptionUtil.a(e)).append("\n");
            }
        }
        if (stringBuilder.length() > 0) {
            a2.add(new FormBodyPart("missing_attachment_report.txt", new ByteArrayBody(StringUtil.a(stringBuilder.toString()), "text/plain", "missing_attachment_report.txt")));
        }
        return ApiRequest.newBuilder().a("fbbugreportuploader").c("POST").d(bugReportRequest.m7040b() + "/bugs").a(a).a(ApiResponseType.JSON).b(a2).C();
    }

    public final Object m7119a(Object obj, ApiResponse apiResponse) {
        boolean z = true;
        if (apiResponse.b != 200) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
