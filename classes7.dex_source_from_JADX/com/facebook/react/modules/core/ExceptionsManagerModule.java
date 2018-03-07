package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.DevSupportManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: from_tag_fragment */
public class ExceptionsManagerModule extends BaseJavaModule {
    private static final Pattern f11634a = Pattern.compile("(?:^|[/\\\\])(\\d+\\.js)$");
    private final DevSupportManager f11635b;

    public ExceptionsManagerModule(DevSupportManager devSupportManager) {
        this.f11635b = devSupportManager;
    }

    public String getName() {
        return "RKExceptionsManager";
    }

    private static String m13698a(ReadableMap readableMap) {
        if (readableMap.hasKey("file") && !readableMap.isNull("file") && readableMap.getType("file") == ReadableType.String) {
            Matcher matcher = f11634a.matcher(readableMap.getString("file"));
            if (matcher.find()) {
                return matcher.group(1) + ":";
            }
        }
        return "";
    }

    private static String m13699a(String str, ReadableArray readableArray) {
        StringBuilder append = new StringBuilder(str).append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap b = readableArray.mo669b(i);
            append.append(b.getString("methodName")).append("@").append(m13698a(b)).append(b.getInt("lineNumber"));
            if (b.hasKey("column") && !b.isNull("column") && b.getType("column") == ReadableType.Number) {
                append.append(":").append(b.getInt("column"));
            }
            append.append("\n");
        }
        return append.toString();
    }

    @ReactMethod
    public void reportFatalException(String str, ReadableArray readableArray, int i) {
        m13700a(str, readableArray, i);
    }

    @ReactMethod
    public void reportSoftException(String str, ReadableArray readableArray, int i) {
        FLog.b("React", m13699a(str, readableArray));
    }

    private void m13700a(String str, ReadableArray readableArray, int i) {
        if (!this.f11635b.mo717a()) {
            throw new JavascriptException(m13699a(str, readableArray));
        }
    }

    @ReactMethod
    public void updateExceptionMessage(String str, ReadableArray readableArray, int i) {
    }

    @ReactMethod
    public void dismissRedbox() {
    }
}
