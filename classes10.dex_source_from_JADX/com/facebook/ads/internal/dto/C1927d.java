package com.facebook.ads.internal.dto;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class C1927d {
    private static final AdPlacementType f14142k = AdPlacementType.UNKNOWN;
    public AdPlacementType f14143a = f14142k;
    public int f14144b = 1;
    protected int f14145c;
    protected int f14146d = 0;
    protected int f14147e = 20;
    public int f14148f = 0;
    public int f14149g = 1000;
    protected boolean f14150h = false;
    public int f14151i = -1;
    public int f14152j = -1;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1927d(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r7 = this;
        r4 = 1;
        r3 = -1;
        r2 = 0;
        r7.<init>();
        r0 = f14142k;
        r7.f14143a = r0;
        r7.f14144b = r4;
        r7.f14146d = r2;
        r0 = 20;
        r7.f14147e = r0;
        r7.f14148f = r2;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7.f14149g = r0;
        r7.f14150h = r2;
        r7.f14151i = r3;
        r7.f14152j = r3;
        r0 = r8.entrySet();
        r5 = r0.iterator();
    L_0x0026:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0139;
    L_0x002c:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r6 = r1.hashCode();
        switch(r6) {
            case -1561601017: goto L_0x0079;
            case -856794442: goto L_0x00ac;
            case -553208868: goto L_0x0083;
            case 3575610: goto L_0x0051;
            case 664421755: goto L_0x0065;
            case 700812481: goto L_0x005b;
            case 1085444827: goto L_0x006f;
            case 1183549815: goto L_0x00a1;
            case 1503616961: goto L_0x0097;
            case 2002133996: goto L_0x008d;
            default: goto L_0x003f;
        };
    L_0x003f:
        r1 = r3;
    L_0x0040:
        switch(r1) {
            case 0: goto L_0x0044;
            case 1: goto L_0x00b7;
            case 2: goto L_0x00c5;
            case 3: goto L_0x00d3;
            case 4: goto L_0x00e1;
            case 5: goto L_0x00ef;
            case 6: goto L_0x0101;
            case 7: goto L_0x010f;
            case 8: goto L_0x011d;
            case 9: goto L_0x012b;
            default: goto L_0x0043;
        };
    L_0x0043:
        goto L_0x0026;
    L_0x0044:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = com.facebook.ads.internal.server.AdPlacementType.fromString(r0);
        r7.f14143a = r0;
        goto L_0x0026;
    L_0x0051:
        r6 = "type";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x0059:
        r1 = r2;
        goto L_0x0040;
    L_0x005b:
        r6 = "min_viewability_percentage";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x0063:
        r1 = r4;
        goto L_0x0040;
    L_0x0065:
        r6 = "min_viewability_duration";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x006d:
        r1 = 2;
        goto L_0x0040;
    L_0x006f:
        r6 = "refresh";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x0077:
        r1 = 3;
        goto L_0x0040;
    L_0x0079:
        r6 = "refresh_threshold";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x0081:
        r1 = 4;
        goto L_0x0040;
    L_0x0083:
        r6 = "cacheable";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x008b:
        r1 = 5;
        goto L_0x0040;
    L_0x008d:
        r6 = "placement_width";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x0095:
        r1 = 6;
        goto L_0x0040;
    L_0x0097:
        r6 = "placement_height";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x009f:
        r1 = 7;
        goto L_0x0040;
    L_0x00a1:
        r6 = "viewability_check_initial_delay";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x00a9:
        r1 = 8;
        goto L_0x0040;
    L_0x00ac:
        r6 = "viewability_check_interval";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x003f;
    L_0x00b4:
        r1 = 9;
        goto L_0x0040;
    L_0x00b7:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14144b = r0;
        goto L_0x0026;
    L_0x00c5:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14145c = r0;
        goto L_0x0026;
    L_0x00d3:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14146d = r0;
        goto L_0x0026;
    L_0x00e1:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14147e = r0;
        goto L_0x0026;
    L_0x00ef:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Boolean.valueOf(r0);
        r0 = r0.booleanValue();
        r7.f14150h = r0;
        goto L_0x0026;
    L_0x0101:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14151i = r0;
        goto L_0x0026;
    L_0x010f:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14152j = r0;
        goto L_0x0026;
    L_0x011d:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14148f = r0;
        goto L_0x0026;
    L_0x012b:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f14149g = r0;
        goto L_0x0026;
    L_0x0139:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dto.d.<init>(java.util.Map):void");
    }

    public static C1927d m14336a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Map hashMap = new HashMap();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, String.valueOf(jSONObject.opt(str)));
        }
        return new C1927d(hashMap);
    }

    public final long m14337b() {
        return (long) (this.f14146d * 1000);
    }

    public final long m14338c() {
        return (long) (this.f14147e * 1000);
    }

    public final boolean m14339d() {
        return this.f14150h;
    }
}
