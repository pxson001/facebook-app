package com.facebook.platform.opengraph;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.debug.log.BLog;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import com.facebook.platform.common.activity.PlatformActivityRequest.Setter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: file_face_detection_tracker */
public final class PlatformActivityOpenGraphDialogRequest extends PlatformActivityRequest {
    public static final Class<?> f14897a = PlatformActivityOpenGraphDialogRequest.class;
    public String f14898b;
    public String f14899c;
    public String f14900d;
    public ObjectNode f14901e;
    public boolean f14902f;
    public final ObjectMapper f14903g;

    /* compiled from: file_face_detection_tracker */
    class C09751 implements Setter<String> {
        final /* synthetic */ PlatformActivityOpenGraphDialogRequest f14892a;

        C09751(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
            this.f14892a = platformActivityOpenGraphDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14892a.f14898b = (String) obj;
        }
    }

    /* compiled from: file_face_detection_tracker */
    class C09762 implements Setter<String> {
        final /* synthetic */ PlatformActivityOpenGraphDialogRequest f14893a;

        C09762(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
            this.f14893a = platformActivityOpenGraphDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14893a.f14899c = (String) obj;
        }
    }

    /* compiled from: file_face_detection_tracker */
    public class C09773 implements Setter<String> {
        final /* synthetic */ PlatformActivityOpenGraphDialogRequest f14894a;

        public C09773(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
            this.f14894a = platformActivityOpenGraphDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14894a.f14900d = (String) obj;
        }
    }

    /* compiled from: file_face_detection_tracker */
    class C09784 implements Setter<String> {
        final /* synthetic */ PlatformActivityOpenGraphDialogRequest f14895a;

        C09784(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
            this.f14895a = platformActivityOpenGraphDialogRequest;
        }

        public final void mo1177a(Object obj) {
            try {
                JsonNode a = this.f14895a.f14903g.a((String) obj);
                if (a != null && a.i()) {
                    this.f14895a.f14901e = (ObjectNode) a;
                }
            } catch (JsonProcessingException e) {
                BLog.b(PlatformActivityOpenGraphDialogRequest.f14897a, "Exception deserializing action", e);
                this.f14895a.f14901e = null;
            } catch (Throwable e2) {
                BLog.b(PlatformActivityOpenGraphDialogRequest.f14897a, "Exception deserializing action", e2);
                this.f14895a.f14901e = null;
            }
        }
    }

    /* compiled from: file_face_detection_tracker */
    class C09795 implements Setter<Boolean> {
        final /* synthetic */ PlatformActivityOpenGraphDialogRequest f14896a;

        C09795(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
            this.f14896a = platformActivityOpenGraphDialogRequest;
        }

        public final void mo1177a(Object obj) {
            boolean z;
            Boolean bool = (Boolean) obj;
            PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest = this.f14896a;
            if (bool == null || !bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            platformActivityOpenGraphDialogRequest.f14902f = z;
        }
    }

    public PlatformActivityOpenGraphDialogRequest(ObjectMapper objectMapper) {
        this.f14903g = objectMapper;
    }

    protected final boolean mo1178a(Intent intent) {
        boolean z;
        if (m5940b(intent, "com.facebook.platform.extra.ACTION_TYPE", false, String.class, m22530i())) {
            if (m5940b(intent, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", false, String.class, m22531j())) {
                if (m5940b(intent, "com.facebook.platform.extra.ACTION", false, String.class, m22532l())) {
                    if (m5940b(intent, "com.facebook.platform.extra.DATA_FAILURES_FATAL", true, Boolean.class, m22533m())) {
                        z = true;
                        return z && this.f14901e != null;
                    }
                }
            }
        }
        z = false;
        if (!z) {
        }
    }

    protected final boolean mo1179a(Bundle bundle) {
        boolean z;
        if (m5941b(bundle, "action_type", false, String.class, m22530i())) {
            if (m5941b(bundle, "preview_property_name", false, String.class, m22531j())) {
                if (m5941b(bundle, "action", false, String.class, m22532l())) {
                    if (m5941b(bundle, "HASHTAG", true, String.class, (Setter) new C09773(this))) {
                        if (m5941b(bundle, "DATA_FAILURES_FATAL", true, Boolean.class, m22533m())) {
                            z = true;
                            if (z || this.f14901e == null) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }

    private Setter<String> m22530i() {
        return new C09751(this);
    }

    private Setter<String> m22531j() {
        return new C09762(this);
    }

    private Setter<String> m22532l() {
        return new C09784(this);
    }

    private Setter<Boolean> m22533m() {
        return new C09795(this);
    }

    public final boolean m22536g() {
        return this.f14902f;
    }
}
