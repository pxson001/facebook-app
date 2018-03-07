package com.facebook.crudolib.netengine;

import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineRequest;
import javax.annotation.Nullable;

/* compiled from: TincanSendMessage */
public interface HttpEngineRequest$Builder {
    HttpEngineRequest$Builder mo1109a(String str);

    HttpEngineRequest$Builder mo1110a(String str, @Nullable HttpEngineRequestBody httpEngineRequestBody);

    HttpEngineRequest$Builder mo1111a(String str, String str2);

    FbHttpEngineRequest mo1112a();

    HttpEngineRequest$Builder mo1113b(String str);

    HttpEngineRequest$Builder mo1114b(String str, String str2);
}
