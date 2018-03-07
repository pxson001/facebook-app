package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: group_pending_members */
public interface JavaJSExecutor {

    /* compiled from: group_pending_members */
    public class ProxyExecutorException extends Exception {
    }

    @DoNotStrip
    String executeJSCall(String str, String str2);

    @DoNotStrip
    void loadApplicationScript(String str);

    @DoNotStrip
    void setGlobalVariable(String str, String str2);
}
