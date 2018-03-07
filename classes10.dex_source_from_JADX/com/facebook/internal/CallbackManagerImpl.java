package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SEND_SKIPPED_MEDIA_UPLOAD_FAILED */
public final class CallbackManagerImpl {
    private static Map<Integer, Object> f23976a = new HashMap();
    private Map<Integer, Object> f23977b = new HashMap();

    /* compiled from: SEND_SKIPPED_MEDIA_UPLOAD_FAILED */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7);
        
        private final int offset;

        private RequestCodeOffset(int i) {
            this.offset = i;
        }

        public final int toRequestCode() {
            Validate.m25364a();
            return FacebookSdk.f13777n + this.offset;
        }
    }
}
