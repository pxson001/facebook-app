package com.facebook.places.checkin.utils;

import android.location.Location;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.MapsLocationUtils;
import com.google.common.annotations.VisibleForTesting;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: cfc81bbb54bae3f760592afccf48494c */
public class CheckinTextModifier {
    private static volatile CheckinTextModifier f18115b;
    private MapsLocationUtils f18116a;

    public static com.facebook.places.checkin.utils.CheckinTextModifier m22087a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18115b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.checkin.utils.CheckinTextModifier.class;
        monitor-enter(r1);
        r0 = f18115b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22089b(r0);	 Catch:{ all -> 0x0035 }
        f18115b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18115b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.utils.CheckinTextModifier.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.utils.CheckinTextModifier");
    }

    private static CheckinTextModifier m22089b(InjectorLike injectorLike) {
        return new CheckinTextModifier(MapsLocationUtils.b(injectorLike));
    }

    @Inject
    public CheckinTextModifier(MapsLocationUtils mapsLocationUtils) {
        this.f18116a = mapsLocationUtils;
    }

    @VisibleForTesting
    public static CharSequence m22088a(Locale locale, String str, String str2) {
        int i = 0;
        String toLowerCase = str.toLowerCase(locale);
        if (toLowerCase.length() != str.length()) {
            return str;
        }
        int length;
        if (StringUtil.a(str2)) {
            length = str.length();
        } else if (str2.split("[-'&/\\+,\\.]", 2).length > 1) {
            i = toLowerCase.indexOf(str2);
            if (i == -1) {
                return str;
            }
            length = str2.length() + i;
        } else {
            int[] iArr = new int[str.length()];
            char[] cArr = new char[str.length()];
            char[] toCharArray = toLowerCase.toCharArray();
            int length2 = toCharArray.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length2) {
                char c = toCharArray[i2];
                if ("-'&/+,.".indexOf(c) == -1) {
                    cArr[i] = c;
                    length = i + 1;
                    iArr[i] = i3;
                } else {
                    length = i;
                }
                i3++;
                i2++;
                i = length;
            }
            length = new String(cArr).indexOf(str2);
            if (length == -1) {
                return str;
            }
            i = iArr[length];
            length = iArr[(length + str2.length()) - 1] + 1;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 17);
        return spannableStringBuilder;
    }

    public final String m22090a(Location location, double d, double d2) {
        Location location2 = new Location("");
        location2.setLatitude(d);
        location2.setLongitude(d2);
        return this.f18116a.a(location, location2);
    }
}
