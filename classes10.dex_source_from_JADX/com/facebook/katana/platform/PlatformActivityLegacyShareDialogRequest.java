package com.facebook.katana.platform;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import com.facebook.platform.common.activity.PlatformActivityRequest.Setter;
import java.util.ArrayList;

/* compiled from: turn_on_progress */
public final class PlatformActivityLegacyShareDialogRequest extends PlatformActivityRequest {
    public boolean f1125a;
    public String f1126b;
    public ArrayList<String> f1127c;
    public String f1128d;
    public String f1129e;
    public String f1130f;
    public String f1131g;
    public String f1132h;

    /* compiled from: turn_on_progress */
    class C01881 implements Setter<Boolean> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1117a;

        C01881(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1117a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1146a(Object obj) {
            boolean z;
            Boolean bool = (Boolean) obj;
            PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest = this.f1117a;
            if (bool == null || !bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            platformActivityLegacyShareDialogRequest.f1125a = z;
        }
    }

    /* compiled from: turn_on_progress */
    class C01892 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1118a;

        C01892(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1118a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1147a(Object obj) {
            this.f1118a.f1126b = (String) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01903 implements Setter<ArrayList<String>> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1119a;

        C01903(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1119a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1148a(Object obj) {
            this.f1119a.f1127c = (ArrayList) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01914 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1120a;

        C01914(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1120a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1149a(Object obj) {
            this.f1120a.f1128d = (String) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01925 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1121a;

        C01925(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1121a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1150a(Object obj) {
            this.f1121a.f1129e = (String) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01936 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1122a;

        C01936(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1122a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1151a(Object obj) {
            this.f1122a.f1130f = (String) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01947 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1123a;

        C01947(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1123a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1152a(Object obj) {
            this.f1123a.f1131g = (String) obj;
        }
    }

    /* compiled from: turn_on_progress */
    class C01958 implements Setter<String> {
        final /* synthetic */ PlatformActivityLegacyShareDialogRequest f1124a;

        C01958(PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest) {
            this.f1124a = platformActivityLegacyShareDialogRequest;
        }

        public final void m1153a(Object obj) {
            this.f1124a.f1132h = (String) obj;
        }
    }

    protected final boolean m1162a(Intent intent) {
        if (b(intent, "com.facebook.platform.extra.IS_USER_MESSAGE_OPTIONAL", true, Boolean.class, m1154f())) {
            if (b(intent, "com.facebook.platform.extra.PLACE", true, String.class, m1155g()) && a(intent, "com.facebook.platform.extra.FRIENDS", true, m1156h())) {
                if (b(intent, "com.facebook.platform.extra.LINK", true, String.class, m1157i())) {
                    if (b(intent, "com.facebook.platform.extra.IMAGE", true, String.class, m1158j())) {
                        if (b(intent, "com.facebook.platform.extra.TITLE", true, String.class, m1159k())) {
                            if (b(intent, "com.facebook.platform.extra.SUBTITLE", true, String.class, m1160l())) {
                                if (b(intent, "com.facebook.platform.extra.DESCRIPTION", true, String.class, m1161m())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    protected final boolean m1163a(Bundle bundle) {
        if (b(bundle, "IS_USER_MESSAGE_OPTIONAL", true, Boolean.class, m1154f())) {
            if (b(bundle, "PLACE", true, String.class, m1155g()) && a(bundle, "FRIENDS", true, m1156h())) {
                if (b(bundle, "link", true, String.class, m1157i())) {
                    if (b(bundle, "IMAGE", true, String.class, m1158j())) {
                        if (b(bundle, "TITLE", true, String.class, m1159k())) {
                            if (b(bundle, "SUBTITLE", true, String.class, m1160l())) {
                                if (b(bundle, "DESCRIPTION", true, String.class, m1161m())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private Setter<Boolean> m1154f() {
        return new C01881(this);
    }

    private Setter<String> m1155g() {
        return new C01892(this);
    }

    private Setter<ArrayList<String>> m1156h() {
        return new C01903(this);
    }

    private Setter<String> m1157i() {
        return new C01914(this);
    }

    private Setter<String> m1158j() {
        return new C01925(this);
    }

    private Setter<String> m1159k() {
        return new C01936(this);
    }

    private Setter<String> m1160l() {
        return new C01947(this);
    }

    private Setter<String> m1161m() {
        return new C01958(this);
    }
}
