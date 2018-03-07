package com.facebook.search.util.keyword;

import android.text.SpannableString;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.inject.Singleton;

@Singleton
/* compiled from: megaphone_button_cancel */
public class KeywordSuggestionHighlightingUtil {
    private static volatile KeywordSuggestionHighlightingUtil f8957a;

    /* compiled from: megaphone_button_cancel */
    class C09271 implements Comparator<HighlightRange> {
        final /* synthetic */ KeywordSuggestionHighlightingUtil f8956a;

        C09271(KeywordSuggestionHighlightingUtil keywordSuggestionHighlightingUtil) {
            this.f8956a = keywordSuggestionHighlightingUtil;
        }

        public int compare(Object obj, Object obj2) {
            return ((HighlightRange) obj).f8954a - ((HighlightRange) obj2).f8954a;
        }
    }

    /* compiled from: megaphone_button_cancel */
    final class C09282 implements Comparator<String> {
        C09282() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((String) obj2).length() - ((String) obj).length();
        }
    }

    public static com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil m10679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8957a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil.class;
        monitor-enter(r1);
        r0 = f8957a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10678a();	 Catch:{ all -> 0x0034 }
        f8957a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8957a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil.a(com.facebook.inject.InjectorLike):com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil");
    }

    private static KeywordSuggestionHighlightingUtil m10678a() {
        return new KeywordSuggestionHighlightingUtil();
    }

    public final CharSequence m10683a(String str, String str2, ImmutableList<KeywordSpanFactory> immutableList, ImmutableList<KeywordSpanFactory> immutableList2) {
        if (Strings.isNullOrEmpty(str2)) {
            return str;
        }
        CharSequence spannableString = new SpannableString(str);
        List<HighlightRange> a = m10680a(str, str2);
        Collections.sort(a, new C09271(this));
        int i = 0;
        for (HighlightRange highlightRange : a) {
            if (highlightRange.f8954a != 0) {
                m10681a((SpannableString) spannableString, (ImmutableList) immutableList2, i, highlightRange.f8954a);
                i += highlightRange.f8954a - i;
            }
            m10681a((SpannableString) spannableString, (ImmutableList) immutableList, highlightRange.f8954a, highlightRange.f8954a + highlightRange.f8955b);
            i = highlightRange.f8955b + i;
        }
        m10681a((SpannableString) spannableString, (ImmutableList) immutableList2, i, str.length());
        return spannableString;
    }

    private static List<HighlightRange> m10680a(String str, String str2) {
        List<HighlightRange> a = Lists.a();
        Object stringBuilder = new StringBuilder(str.toLowerCase(Locale.getDefault()));
        String[] split = str2.trim().toLowerCase(Locale.getDefault()).split("\\s+");
        Arrays.sort(split, new C09282());
        for (String str3 : split) {
            int indexOf = stringBuilder.indexOf(str3);
            StringBuffer stringBuffer = new StringBuffer(stringBuilder);
            while (indexOf != -1) {
                Object obj;
                if (indexOf == 0 || str.codePointAt(indexOf - 1) == 32) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    break;
                }
                int i;
                for (i = indexOf; i < str3.length() + indexOf; i++) {
                    stringBuffer.replace(i, i + 1, " ");
                }
                indexOf = stringBuffer.indexOf(str3);
            }
            if (indexOf != -1) {
                a.add(new HighlightRange(indexOf, str3.length()));
                for (i = indexOf; i < str3.length() + indexOf; i++) {
                    stringBuilder.replace(i, i + 1, " ");
                }
            }
        }
        return a;
    }

    private static void m10681a(SpannableString spannableString, ImmutableList<KeywordSpanFactory> immutableList, int i, int i2) {
        if (!m10682a(spannableString, i, i2)) {
            int size = immutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                spannableString.setSpan(((KeywordSpanFactory) immutableList.get(i3)).m10677a(), i, i2, 17);
            }
        }
    }

    private static boolean m10682a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
