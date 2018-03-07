package com.facebook.platform.feed;

import android.os.Bundle;
import com.facebook.common.util.CollectionUtil;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import com.facebook.platform.common.activity.PlatformActivityRequest.Setter;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: filterName */
public final class PlatformActivityFeedDialogRequest extends PlatformActivityRequest {
    public String f14864a;
    public ArrayList<String> f14865b;
    public String f14866c;
    public String f14867d;
    public String f14868e;
    public String f14869f;
    public String f14870g;
    public String f14871h;
    public ArrayList<String> f14872i;
    public String f14873j;
    public String f14874k;
    public String f14875l;
    public ArrayList<Bundle> f14876m;
    public boolean f14877n;
    public boolean f14878o;

    /* compiled from: filterName */
    class C09641 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14855a;

        C09641(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14855a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14855a.f14864a = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09652 implements Setter<ArrayList<String>> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14856a;

        C09652(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14856a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14856a.f14865b = (ArrayList) obj;
        }
    }

    /* compiled from: filterName */
    class C09663 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14857a;

        C09663(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14857a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14857a.f14866c = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09674 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14858a;

        C09674(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14858a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14858a.f14867d = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09685 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14859a;

        C09685(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14859a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14859a.f14868e = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09696 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14860a;

        C09696(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14860a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14860a.f14869f = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09707 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14861a;

        C09707(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14861a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14861a.f14870g = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09718 implements Setter<String> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14862a;

        C09718(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14862a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            this.f14862a.f14871h = (String) obj;
        }
    }

    /* compiled from: filterName */
    class C09729 implements Setter<Boolean> {
        final /* synthetic */ PlatformActivityFeedDialogRequest f14863a;

        C09729(PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
            this.f14863a = platformActivityFeedDialogRequest;
        }

        public final void mo1177a(Object obj) {
            boolean z;
            Boolean bool = (Boolean) obj;
            PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest = this.f14863a;
            if (bool == null || !bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            platformActivityFeedDialogRequest.f14877n = z;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean mo1178a(android.content.Intent r7) {
        /*
        r6 = this;
        r3 = 1;
        r2 = "com.facebook.platform.extra.PLACE";
        r4 = java.lang.String.class;
        r5 = r6.m22495v();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x0011:
        r0 = "com.facebook.platform.extra.FRIENDS";
        r1 = r6.m22496w();
        r0 = r6.m5933a(r7, r0, r3, r1);
        if (r0 == 0) goto L_0x00ca;
    L_0x001d:
        r2 = "com.facebook.platform.extra.LINK";
        r4 = java.lang.String.class;
        r5 = r6.m22497x();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x002d:
        r2 = "com.facebook.platform.extra.IMAGE";
        r4 = java.lang.String.class;
        r5 = r6.m22498y();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x003d:
        r2 = "com.facebook.platform.extra.TITLE";
        r4 = java.lang.String.class;
        r5 = r6.m22499z();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x004d:
        r2 = "com.facebook.platform.extra.SUBTITLE";
        r4 = java.lang.String.class;
        r5 = r6.m22487A();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x005d:
        r2 = "com.facebook.platform.extra.DESCRIPTION";
        r4 = java.lang.String.class;
        r5 = r6.m22488B();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x006d:
        r2 = "com.facebook.platform.extra.REF";
        r4 = java.lang.String.class;
        r5 = r6.m22489C();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x007d:
        r2 = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
        r4 = java.lang.Boolean.class;
        r5 = r6.m22490D();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x008d:
        r0 = "com.facebook.platform.extra.PHOTOS";
        r1 = r6.m22491E();
        r0 = r6.m5933a(r7, r0, r3, r1);
        if (r0 != 0) goto L_0x00a9;
    L_0x0099:
        r2 = "com.facebook.platform.extra.PHOTOS";
        r4 = java.lang.String.class;
        r5 = r6.m22492F();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x00a9:
        r2 = "com.facebook.platform.extra.QUOTE";
        r4 = java.lang.String.class;
        r5 = r6.m22493H();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5940b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x00b9:
        r2 = "com.facebook.platform.extra.MEDIA";
        r4 = android.os.Bundle.class;
        r5 = r6.m22494J();
        r0 = r6;
        r1 = r7;
        r0 = r0.m5934a(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00ca;
    L_0x00c9:
        return r3;
    L_0x00ca:
        r3 = 0;
        goto L_0x00c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.feed.PlatformActivityFeedDialogRequest.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean mo1179a(android.os.Bundle r8) {
        /*
        r7 = this;
        r3 = 1;
        r2 = "PLACE";
        r4 = java.lang.String.class;
        r5 = r7.m22495v();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x0011:
        r0 = "FRIENDS";
        r1 = r7.m22496w();
        r0 = r7.m5936a(r8, r0, r3, r1);
        if (r0 == 0) goto L_0x0100;
    L_0x001d:
        r2 = "link";
        r4 = java.lang.String.class;
        r5 = r7.m22497x();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x002d:
        r2 = "IMAGE";
        r4 = java.lang.String.class;
        r5 = r7.m22498y();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x003d:
        r2 = "TITLE";
        r4 = java.lang.String.class;
        r5 = r7.m22499z();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x004d:
        r2 = "SUBTITLE";
        r4 = java.lang.String.class;
        r5 = r7.m22487A();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x005d:
        r2 = "DESCRIPTION";
        r4 = java.lang.String.class;
        r5 = r7.m22488B();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x006d:
        r2 = "REF";
        r4 = java.lang.String.class;
        r5 = r7.m22489C();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x007d:
        r2 = "DATA_FAILURES_FATAL";
        r4 = java.lang.Boolean.class;
        r5 = r7.m22490D();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x008d:
        r0 = "PHOTOS";
        r1 = r7.m22491E();
        r0 = r7.m5936a(r8, r0, r3, r1);
        if (r0 != 0) goto L_0x00a9;
    L_0x0099:
        r2 = "PHOTOS";
        r4 = java.lang.String.class;
        r5 = r7.m22492F();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00a9:
        r2 = "VIDEO";
        r4 = java.lang.String.class;
        r6 = new com.facebook.platform.feed.PlatformActivityFeedDialogRequest$12;
        r6.<init>(r7);
        r5 = r6;
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00bb:
        r2 = "QUOTE";
        r4 = java.lang.String.class;
        r5 = r7.m22493H();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00cb:
        r2 = "HASHTAG";
        r4 = java.lang.String.class;
        r6 = new com.facebook.platform.feed.PlatformActivityFeedDialogRequest$14;
        r6.<init>(r7);
        r5 = r6;
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00dd:
        r2 = "MEDIA";
        r4 = android.os.Bundle.class;
        r5 = r7.m22494J();
        r0 = r7;
        r1 = r8;
        r0 = r0.m5937a(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00ed:
        r2 = "IS_NATIVE_INTENT";
        r4 = java.lang.Boolean.class;
        r6 = new com.facebook.platform.feed.PlatformActivityFeedDialogRequest$16;
        r6.<init>(r7);
        r5 = r6;
        r0 = r7;
        r1 = r8;
        r0 = r0.m5941b(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0100;
    L_0x00ff:
        return r3;
    L_0x0100:
        r3 = 0;
        goto L_0x00ff;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.feed.PlatformActivityFeedDialogRequest.a(android.os.Bundle):boolean");
    }

    private Setter<String> m22495v() {
        return new C09641(this);
    }

    private Setter<ArrayList<String>> m22496w() {
        return new C09652(this);
    }

    private Setter<String> m22497x() {
        return new C09663(this);
    }

    private Setter<String> m22498y() {
        return new C09674(this);
    }

    private Setter<String> m22499z() {
        return new C09685(this);
    }

    private Setter<String> m22487A() {
        return new C09696(this);
    }

    private Setter<String> m22488B() {
        return new C09707(this);
    }

    private Setter<String> m22489C() {
        return new C09718(this);
    }

    private Setter<Boolean> m22490D() {
        return new C09729(this);
    }

    private Setter<ArrayList<String>> m22491E() {
        return new Setter<ArrayList<String>>(this) {
            final /* synthetic */ PlatformActivityFeedDialogRequest f14848a;

            {
                this.f14848a = r1;
            }

            public final void mo1177a(Object obj) {
                this.f14848a.f14872i = (ArrayList) obj;
            }
        };
    }

    private Setter<String> m22492F() {
        return new Setter<String>(this) {
            final /* synthetic */ PlatformActivityFeedDialogRequest f14849a;

            {
                this.f14849a = r1;
            }

            public final void mo1177a(Object obj) {
                String str = (String) obj;
                this.f14849a.f14872i = Lists.a(new String[]{str});
            }
        };
    }

    private Setter<String> m22493H() {
        return new Setter<String>(this) {
            final /* synthetic */ PlatformActivityFeedDialogRequest f14851a;

            {
                this.f14851a = r1;
            }

            public final void mo1177a(Object obj) {
                this.f14851a.f14874k = (String) obj;
            }
        };
    }

    private Setter<ArrayList<Bundle>> m22494J() {
        return new Setter<ArrayList<Bundle>>(this) {
            final /* synthetic */ PlatformActivityFeedDialogRequest f14853a;

            {
                this.f14853a = r1;
            }

            public final void mo1177a(Object obj) {
                this.f14853a.f14876m = (ArrayList) obj;
            }
        };
    }

    public final boolean m22502k() {
        return this.f14877n;
    }

    public final boolean m22503q() {
        return (this.f14872i == null || this.f14872i.isEmpty()) ? false : true;
    }

    public final boolean m22504r() {
        return this.f14873j != null;
    }

    public final boolean m22505s() {
        return CollectionUtil.b(this.f14876m);
    }
}
