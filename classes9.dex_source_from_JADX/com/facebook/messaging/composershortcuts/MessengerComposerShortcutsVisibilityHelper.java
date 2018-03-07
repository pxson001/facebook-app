package com.facebook.messaging.composershortcuts;

import com.facebook.common.hardware.CameraDetectionUtil;
import com.facebook.common.util.TriState;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: messages_timestamp_index */
public class MessengerComposerShortcutsVisibilityHelper {
    public static final ImmutableList<String> f10097a = ImmutableList.of("text", "camera", "gallery", "voice_clip", "sendlocation", "stickers", "emoji");
    public static final ImmutableList<String> f10098b = ImmutableList.of("text", "camera", "gallery", "stickers", "sendlocation", "emoji", "ephemeral");
    public final CameraDetectionUtil f10099c;
    public final ComposerShortcutsGatekeepers f10100d;
    public final Provider<Boolean> f10101e;
    private final Provider<Boolean> f10102f;
    public final Provider<Boolean> f10103g;
    public final Provider<Boolean> f10104h;
    public final Provider<Boolean> f10105i;
    public final TincanGatekeepers f10106j;
    public TriState f10107k = TriState.UNSET;

    @Inject
    public MessengerComposerShortcutsVisibilityHelper(CameraDetectionUtil cameraDetectionUtil, ComposerShortcutsGatekeepers composerShortcutsGatekeepers, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, TincanGatekeepers tincanGatekeepers) {
        this.f10099c = cameraDetectionUtil;
        this.f10100d = composerShortcutsGatekeepers;
        this.f10101e = provider;
        this.f10102f = provider2;
        this.f10103g = provider3;
        this.f10104h = provider4;
        this.f10105i = provider5;
        this.f10106j = tincanGatekeepers;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.collect.ImmutableList<com.facebook.messaging.composershortcuts.ComposerShortcutItem> m10595a(com.facebook.messaging.composershortcuts.ComposerShortcutsFilter r10, com.google.common.collect.ImmutableList<com.facebook.messaging.composershortcuts.ComposerShortcutItem> r11) {
        /*
        r9 = this;
        r2 = com.google.common.collect.ImmutableList.builder();
        r3 = r11.size();
        r0 = 0;
        r1 = r0;
    L_0x000a:
        if (r1 >= r3) goto L_0x002c;
    L_0x000c:
        r0 = r11.get(r1);
        r0 = (com.facebook.messaging.composershortcuts.ComposerShortcutItem) r0;
        r4 = r0.f9973b;
        r6 = 1;
        r5 = 0;
        r7 = com.facebook.messaging.composershortcuts.ComposerShortcutsFilter.SMS;
        if (r10 != r7) goto L_0x0031;
    L_0x001a:
        r7 = f10097a;
        r7 = r7.contains(r4);
        if (r7 != 0) goto L_0x0031;
    L_0x0022:
        r4 = r5;
        if (r4 == 0) goto L_0x0028;
    L_0x0025:
        r2.c(r0);
    L_0x0028:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x000a;
    L_0x002c:
        r0 = r2.b();
        return r0;
    L_0x0031:
        r7 = com.facebook.messaging.composershortcuts.ComposerShortcutsFilter.TINCAN;
        if (r10 != r7) goto L_0x003d;
    L_0x0035:
        r7 = f10098b;
        r7 = r7.contains(r4);
        if (r7 == 0) goto L_0x0022;
    L_0x003d:
        r7 = -1;
        r8 = r4.hashCode();
        switch(r8) {
            case -1367751899: goto L_0x004b;
            case -786681338: goto L_0x005e;
            case 32613394: goto L_0x007c;
            case 96632902: goto L_0x0054;
            case 563386781: goto L_0x0086;
            case 575445857: goto L_0x0068;
            case 814800675: goto L_0x0090;
            case 1835818606: goto L_0x0072;
            default: goto L_0x0045;
        };
    L_0x0045:
        r5 = r7;
    L_0x0046:
        switch(r5) {
            case 0: goto L_0x009a;
            case 1: goto L_0x00b6;
            case 2: goto L_0x00be;
            case 3: goto L_0x00cc;
            case 4: goto L_0x00da;
            case 5: goto L_0x00da;
            case 6: goto L_0x00e8;
            case 7: goto L_0x00f0;
            default: goto L_0x0049;
        };
    L_0x0049:
        r5 = r6;
        goto L_0x0022;
    L_0x004b:
        r8 = "camera";
        r8 = r4.equals(r8);
        if (r8 == 0) goto L_0x0045;
    L_0x0053:
        goto L_0x0046;
    L_0x0054:
        r5 = "emoji";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x005c:
        r5 = r6;
        goto L_0x0046;
    L_0x005e:
        r5 = "payment";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0066:
        r5 = 2;
        goto L_0x0046;
    L_0x0068:
        r5 = "contentsearch";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0070:
        r5 = 3;
        goto L_0x0046;
    L_0x0072:
        r5 = "ride_service";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x007a:
        r5 = 4;
        goto L_0x0046;
    L_0x007c:
        r5 = "ride_service_promotion";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0084:
        r5 = 5;
        goto L_0x0046;
    L_0x0086:
        r5 = "ephemeral";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x008e:
        r5 = 6;
        goto L_0x0046;
    L_0x0090:
        r5 = "send_event";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0098:
        r5 = 7;
        goto L_0x0046;
    L_0x009a:
        r5 = r9.f10107k;
        r5 = r5.isSet();
        if (r5 != 0) goto L_0x00ae;
    L_0x00a2:
        r5 = r9.f10099c;
        r5 = r5.a();
        r5 = com.facebook.common.util.TriState.valueOf(r5);
        r9.f10107k = r5;
    L_0x00ae:
        r5 = r9.f10107k;
        r5 = r5.asBoolean();
        goto L_0x0022;
    L_0x00b6:
        r5 = r9.f10100d;
        r5 = r5.m10557a();
        goto L_0x0022;
    L_0x00be:
        r5 = r9.f10101e;
        r5 = r5.get();
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        goto L_0x0022;
    L_0x00cc:
        r5 = r9.f10103g;
        r5 = r5.get();
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        goto L_0x0022;
    L_0x00da:
        r5 = r9.f10104h;
        r5 = r5.get();
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        goto L_0x0022;
    L_0x00e8:
        r5 = r9.f10106j;
        r5 = r5.d();
        goto L_0x0022;
    L_0x00f0:
        r5 = r9.f10105i;
        r5 = r5.get();
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composershortcuts.MessengerComposerShortcutsVisibilityHelper.a(com.facebook.messaging.composershortcuts.ComposerShortcutsFilter, com.google.common.collect.ImmutableList):com.google.common.collect.ImmutableList<com.facebook.messaging.composershortcuts.ComposerShortcutItem>");
    }
}
