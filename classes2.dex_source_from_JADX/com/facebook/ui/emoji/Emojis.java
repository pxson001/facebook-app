package com.facebook.ui.emoji;

import android.os.Build.VERSION;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.data.EmojisDataMethodAutoProvider;
import com.facebook.ui.emoji.data.FacebookEmojisData;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.emoji.model.EmojiSet;
import com.facebook.ui.emoji.model.EmojiSet.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: getViewForPositionAndType returned a view which does not have a ViewHolder */
public class Emojis {
    public static final String f24283a = new String(Character.toChars(128077));
    public static final String f24284b = new String(Character.toChars(983040));
    public static final Pattern f24285c = Pattern.compile(new String(Character.toChars(10084)));
    private static final Emoji f24286d = new Emoji(2130839424, 0);
    private static volatile Emojis f24287h;
    private final EmojiCodePointFilter f24288e;
    public final FacebookEmojisData f24289f;
    @Nullable
    private Pattern f24290g;

    /* compiled from: getViewForPositionAndType returned a view which does not have a ViewHolder */
    public class EmoticonResult {
        public int f22498a;
        public int f22499b;
    }

    public static com.facebook.ui.emoji.Emojis m32621a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24287h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.emoji.Emojis.class;
        monitor-enter(r1);
        r0 = f24287h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m32625b(r0);	 Catch:{ all -> 0x0035 }
        f24287h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24287h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.emoji.Emojis.a(com.facebook.inject.InjectorLike):com.facebook.ui.emoji.Emojis");
    }

    private static Emojis m32625b(InjectorLike injectorLike) {
        return new Emojis(EmojiCodePointFilter.m27891a(injectorLike), EmojisDataMethodAutoProvider.m27894a(injectorLike));
    }

    @Inject
    public Emojis(EmojiCodePointFilter emojiCodePointFilter, FacebookEmojisData facebookEmojisData) {
        Preconditions.checkNotNull(facebookEmojisData, "Binding for emojisData not defined.");
        this.f24288e = emojiCodePointFilter;
        this.f24289f = facebookEmojisData;
    }

    public final List<EmojiSet> m32630a(int i) {
        List<EmojiSet> a = this.f24289f.m27901a();
        Builder builder = ImmutableList.builder();
        for (EmojiSet emojiSet : a) {
            if (emojiSet.d == Type.RECENTLY_USED) {
                builder.m1069c(emojiSet);
            } else {
                builder.m1069c(EmojiSet.a(emojiSet.a, emojiSet.b, m32622a(emojiSet.c, i)));
            }
        }
        return builder.m1068b();
    }

    private List<Emoji> m32622a(List<Emoji> list, int i) {
        if (!m32626c(i)) {
            return list;
        }
        Builder builder = ImmutableList.builder();
        for (Emoji emoji : list) {
            if (m32631a(emoji)) {
                builder.m1069c(new Emoji(this.f24289f.m27899a(emoji.f23124b, i, -1), emoji.f23124b, i, emoji.f23126d));
            } else {
                builder.m1069c(emoji);
            }
        }
        return builder.m1068b();
    }

    public final EmojiSet m32633b() {
        FacebookEmojisData facebookEmojisData = this.f24289f;
        return EmojiSet.a(0, 2131232443, Collections.unmodifiableList(Arrays.asList(new Emoji[]{new Emoji(2130839112, 128515, 0, 2131238521), new Emoji(2130839118, 128521, 0, 2131238523), new Emoji(2130839140, 128536, 0, 2131238525), new Emoji(2130839178, 128563, 0, 2131238529), new Emoji(2130839108, 128513, 0, 2131238530), new Emoji(2130839144, 128540, 0, 2131238527), new Emoji(2130839130, 128530, 0, 2131238533), new Emoji(2130839128, 128527, 0, 2131238558), new Emoji(2130839154, 128546, 0, 2131238536), new Emoji(2130839110, 128514, 0, 2131238537), new Emoji(2130839152, 128545, 0, 2131238548), new Emoji(2130838910, 128127, 0, 2131238557), new Emoji(2130838906, 128125, 0, 2131238584), new Emoji(2130838984, 128169, 0, 2131238585), new Emoji(2130838816, 128064, 0, 2131238595), new Emoji(2130838822, 128068, 0, 2131238598), new Emoji(2130838928, 128139, 0, 2131238654), new Emoji(2130839372, 10084, 0, 2131238646), new Emoji(2130838946, 128148, 0, 2131238647), new Emoji(2130838952, 128152, 0, 2131238652), new Emoji(2130838840, 128077, 0, 2131238599), new Emoji(2130838842, 128078, 0, 2131238600), new Emoji(2130838832, 128073, 0, 2131238610), new Emoji(2130838830, 128072, 0, 2131238611), new Emoji(2130838550, 127775, 0, 2131238588), new Emoji(2130839076, 128293, 0, 2131238586), new Emoji(2130839286, 9728, 0, 2131238708), new Emoji(2130839292, 9748, 0, 2131238711), new Emoji(2130839288, 9729, 0, 2131238709), new Emoji(2130839314, 9889, 0, 2131238710), new Emoji(2130838802, 128054, 0, 2131238657), new Emoji(2130838792, 128048, 0, 2131238662), new Emoji(2130838806, 128056, 0, 2131238663), new Emoji(2130838790, 128047, 0, 2131238664), new Emoji(2130838812, 128059, 0, 2131238666), new Emoji(2130838804, 128055, 0, 2131238667), new Emoji(2130838788, 128046, 0, 2131238668), new Emoji(2130838752, 128018, 0, 2131238671), new Emoji(2130838758, 128024, 0, 2131238674), new Emoji(2130838746, 128013, 0, 2131238679), new Emoji(2130838754, 128020, 0, 2131238678), new Emoji(2130838776, 128039, 0, 2131238675), new Emoji(2130838766, 128031, 0, 2131238684), new Emoji(2130838796, 128051, 0, 2131238686), new Emoji(2130838938, 128144, 0, 2131238692), new Emoji(2130838562, 127801, 0, 2131238696), new Emoji(2130838570, 127808, 0, 2131238695), new Emoji(2130839294, 9749, 0, 2131238804), new Emoji(2130838634, 127866, 0, 2131238807), new Emoji(2130838632, 127864, 0, 2131238809), new Emoji(2130838590, 127828, 0, 2131238811), new Emoji(2130838586, 127822, 0, 2131238829)})));
    }

    public final Pattern m32635c() {
        if (this.f24290g == null) {
            FacebookEmojisData facebookEmojisData = this.f24289f;
            this.f24290g = Pattern.compile("(?:^|\\s|'|\"|\\.)((\\:\\-\\))|(\\:\\))|(\\:\\])|(=\\))|(\\:\\-\\()|(\\:\\()|(\\:\\[)|(=\\()|(\\:\\-P)|(\\:poop\\:)|(\\:P)|(\\:\\-p)|(\\:p)|(=P)|(\\:\\-D)|(\\:D)|(=D)|(\\:\\-O)|(\\:O)|(\\:\\-o)|(\\:o)|(\\;\\-\\))|(\\;\\))|(>\\:\\()|(>\\:\\-\\()|(\\:/)|(\\:\\-/)|(\\:\\\\)|(\\:\\-\\\\)|(\\:'\\()|(3\\:\\))|(3\\:\\-\\))|(\\:\\-\\*)|(\\:\\*)|(<3)|(&lt\\;3)|(\\^_\\^)|(o\\.O)|(o\\.0)|(O\\.o)|(0\\.o)|(>\\:O)|(>\\:\\-O)|(>\\:o)|(>\\:\\-o)|(>_<)|(>\\.<)|(<\\(\"\\))|(\\:like\\:)|(\\(y\\))|(\\(Y\\))|(\\(n\\))|(\\(N\\))|(\\(poo\\)))(?:|'|\"|\\.|,|!|\\?|$)");
        }
        return this.f24290g;
    }

    public static boolean m32623a(char[] cArr, int i, EmoticonResult emoticonResult) {
        if (i >= cArr.length) {
            return false;
        }
        switch (cArr[i]) {
            case '&':
                if (i + 4 >= cArr.length || cArr[i + 1] != 'l' || cArr[i + 2] != 't' || cArr[i + 3] != ';' || cArr[i + 4] != '3') {
                    return false;
                }
                emoticonResult.f22498a = 10084;
                emoticonResult.f22499b = 5;
                return true;
            case '(':
                if (i + 2 < cArr.length && cArr[i + 2] == ')') {
                    if (cArr[i + 1] == 'N' || cArr[i + 1] == 'n') {
                        emoticonResult.f22498a = 128078;
                        emoticonResult.f22499b = 3;
                        return true;
                    } else if (cArr[i + 1] == 'Y' || cArr[i + 1] == 'y') {
                        emoticonResult.f22498a = 983040;
                        emoticonResult.f22499b = 3;
                        return true;
                    }
                }
                if (i + 4 >= cArr.length || cArr[i + 1] != 'p' || cArr[i + 2] != 'o' || cArr[i + 3] != 'o' || cArr[i + 4] != ')') {
                    return false;
                }
                emoticonResult.f22498a = 128169;
                emoticonResult.f22499b = 5;
                return true;
            case '0':
                if (i + 2 >= cArr.length || cArr[i + 1] != '.' || cArr[i + 2] != 'o') {
                    return false;
                }
                emoticonResult.f22498a = 983042;
                emoticonResult.f22499b = 3;
                return true;
            case '3':
                if (i + 2 < cArr.length && cArr[i + 1] == ':' && cArr[i + 2] == ')') {
                    emoticonResult.f22498a = 128127;
                    emoticonResult.f22499b = 3;
                    return true;
                } else if (i + 3 >= cArr.length || cArr[i + 1] != ':' || cArr[i + 2] != '-' || cArr[i + 3] != ')') {
                    return false;
                } else {
                    emoticonResult.f22498a = 128127;
                    emoticonResult.f22499b = 4;
                    return true;
                }
            case ':':
                if (i + 5 < cArr.length && cArr[i + 5] == ':') {
                    if (cArr[i + 1] == 'p' && cArr[i + 2] == 'o' && cArr[i + 3] == 'o' && cArr[i + 4] == 'p') {
                        emoticonResult.f22498a = 128169;
                        emoticonResult.f22499b = 6;
                        return true;
                    } else if (cArr[i + 1] == 'l' && cArr[i + 2] == 'i' && cArr[i + 3] == 'k' && cArr[i + 4] == 'e') {
                        emoticonResult.f22498a = 128077;
                        emoticonResult.f22499b = 6;
                        return true;
                    }
                }
                if (i + 1 >= cArr.length) {
                    return false;
                }
                switch (cArr[i + 1]) {
                    case '(':
                    case '[':
                        emoticonResult.f22498a = 128542;
                        emoticonResult.f22499b = 2;
                        return true;
                    case ')':
                    case ']':
                        emoticonResult.f22498a = 128522;
                        emoticonResult.f22499b = 2;
                        return true;
                    case '*':
                        emoticonResult.f22498a = 128536;
                        emoticonResult.f22499b = 2;
                        return true;
                    case '/':
                        emoticonResult.f22498a = 128533;
                        emoticonResult.f22499b = 2;
                        return true;
                    case 'D':
                        emoticonResult.f22498a = 128515;
                        emoticonResult.f22499b = 2;
                        return true;
                    case 'O':
                    case 'o':
                        emoticonResult.f22498a = 128562;
                        emoticonResult.f22499b = 2;
                        return true;
                    case 'P':
                    case 'p':
                        emoticonResult.f22498a = 128540;
                        emoticonResult.f22499b = 2;
                        return true;
                    case '\\':
                        emoticonResult.f22498a = 128533;
                        emoticonResult.f22499b = 2;
                        return true;
                    default:
                        if (i + 2 >= cArr.length) {
                            return false;
                        }
                        if (cArr[i + 1] == '\'' && cArr[i + 2] == '(') {
                            emoticonResult.f22498a = 128546;
                            emoticonResult.f22499b = 3;
                            return true;
                        } else if (cArr[i + 1] != '-') {
                            return false;
                        } else {
                            switch (cArr[i + 2]) {
                                case '(':
                                    emoticonResult.f22498a = 128542;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case ')':
                                    emoticonResult.f22498a = 128522;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case '*':
                                    emoticonResult.f22498a = 128536;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case '/':
                                    emoticonResult.f22498a = 128533;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case 'D':
                                    emoticonResult.f22498a = 128515;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case 'O':
                                case 'o':
                                    emoticonResult.f22498a = 128562;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case 'P':
                                case 'p':
                                    emoticonResult.f22498a = 128540;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                case '\\':
                                    emoticonResult.f22498a = 128533;
                                    emoticonResult.f22499b = 3;
                                    return true;
                                default:
                                    return false;
                            }
                        }
                }
            case ';':
                if (i + 1 < cArr.length && cArr[i + 1] == ')') {
                    emoticonResult.f22498a = 128521;
                    emoticonResult.f22499b = 2;
                    return true;
                } else if (i + 2 >= cArr.length || cArr[i + 1] != '-' || cArr[i + 2] != ')') {
                    return false;
                } else {
                    emoticonResult.f22498a = 128521;
                    emoticonResult.f22499b = 3;
                    return true;
                }
            case '<':
                if (i + 1 < cArr.length && cArr[i + 1] == '3') {
                    emoticonResult.f22498a = 10084;
                    emoticonResult.f22499b = 2;
                    return true;
                } else if (i + 3 >= cArr.length || cArr[i + 1] != '(' || cArr[i + 2] != '\"' || cArr[i + 3] != ')') {
                    return false;
                } else {
                    emoticonResult.f22498a = 128039;
                    emoticonResult.f22499b = 4;
                    return true;
                }
            case '=':
                if (i + 1 >= cArr.length) {
                    return false;
                }
                switch (cArr[i + 1]) {
                    case '(':
                        emoticonResult.f22498a = 128542;
                        emoticonResult.f22499b = 2;
                        return true;
                    case ')':
                        emoticonResult.f22498a = 128522;
                        emoticonResult.f22499b = 2;
                        return true;
                    case 'D':
                        emoticonResult.f22498a = 128515;
                        emoticonResult.f22499b = 2;
                        return true;
                    case 'P':
                        emoticonResult.f22498a = 128540;
                        emoticonResult.f22499b = 2;
                        return true;
                    default:
                        return false;
                }
            case '>':
                if (i + 2 < cArr.length && ((cArr[i + 2] == '<' && (cArr[i + 1] == '.' || cArr[i + 1] == '_')) || (cArr[i + 1] == ':' && (cArr[i + 2] == 'O' || cArr[i + 2] == 'o' || cArr[i + 2] == '(')))) {
                    emoticonResult.f22498a = 128544;
                    emoticonResult.f22499b = 3;
                    return true;
                } else if (i + 3 >= cArr.length || cArr[i + 1] != ':' || cArr[i + 2] != '-') {
                    return false;
                } else {
                    if (cArr[i + 3] != 'O' && cArr[i + 3] != 'o' && cArr[i + 3] != '(') {
                        return false;
                    }
                    emoticonResult.f22498a = 128544;
                    emoticonResult.f22499b = 4;
                    return true;
                }
            case 'O':
                if (i + 2 >= cArr.length || cArr[i + 1] != '.' || cArr[i + 2] != 'o') {
                    return false;
                }
                emoticonResult.f22498a = 983042;
                emoticonResult.f22499b = 3;
                return true;
            case '^':
                if (i + 2 >= cArr.length || cArr[i + 1] != '_' || cArr[i + 2] != '^') {
                    return false;
                }
                emoticonResult.f22498a = 128516;
                emoticonResult.f22499b = 3;
                return true;
            case 'o':
                if (i + 2 >= cArr.length || cArr[i + 1] != '.') {
                    return false;
                }
                if (cArr[i + 2] != 'O' && cArr[i + 2] != '0') {
                    return false;
                }
                emoticonResult.f22498a = 983041;
                emoticonResult.f22499b = 3;
                return true;
            default:
                return false;
        }
    }

    final Emoji m32632b(int i) {
        int a = this.f24289f.m27899a(i, 0, -1);
        if (a != -1) {
            return new Emoji(a, i);
        }
        if (VERSION.SDK_INT < 16) {
            return f24286d;
        }
        return null;
    }

    @Nullable
    public final Emoji m32628a(int i, int i2, List<Integer> list) {
        FacebookEmojisData facebookEmojisData = this.f24289f;
        int i3 = -1;
        return i3 == -1 ? null : new Emoji(i3, i, i2, (List) list);
    }

    @Nullable
    public final Emoji m32627a(int i, int i2) {
        if (!EmojiCodePointFilter.m27892a(i, i2)) {
            return null;
        }
        Object obj;
        if ((i == 35 || (i >= 48 && i <= 57)) && i2 == 8419) {
            obj = 1;
        } else {
            obj = null;
        }
        int a;
        if (obj != null) {
            a = this.f24289f.m27899a(i, i2, -1);
            return a == -1 ? null : new Emoji(a, i, i2);
        } else if (i < 127462 || i > 127487 || i2 < 127462 || i2 > 127487) {
            int a2 = this.f24289f.m27898a(i, -1);
            if (a2 != -1) {
                i = a2;
            }
            if (m32626c(i2) || i2 == 65039) {
                a = this.f24289f.m27899a(i, i2, -1);
                if (a != -1) {
                    return new Emoji(a, i, i2);
                }
            }
            a2 = this.f24289f.m27899a(i, 0, -1);
            if (a2 == -1) {
                a = m32624b(i, -1);
                if (a != -1) {
                    i = a;
                    a = this.f24289f.m27899a(a, 0, -1);
                    if (a != -1) {
                        return new Emoji(a, i);
                    }
                    return VERSION.SDK_INT >= 16 ? f24286d : null;
                }
            }
            a = a2;
            if (a != -1) {
                return new Emoji(a, i);
            }
            if (VERSION.SDK_INT >= 16) {
            }
        } else {
            a = this.f24289f.m27899a(i, i2, -1);
            return a == -1 ? null : new Emoji(a, i, i2);
        }
    }

    private static boolean m32626c(int i) {
        return i >= 127995 && i <= 127999;
    }

    public final Emoji m32629a(String str) {
        int a = this.f24289f.m27900a(str, -1);
        if (a == -1) {
            return null;
        }
        int a2 = this.f24289f.m27899a(a, 0, -1);
        if (a2 != -1) {
            return new Emoji(a2, a);
        }
        return null;
    }

    private static int m32624b(int i, int i2) {
        switch (i) {
            case 128149:
                return 128147;
            default:
                return i2;
        }
    }

    public final boolean m32631a(Emoji emoji) {
        if (emoji.f23127e == null && this.f24289f.m27899a(emoji.f23124b, 127995, -1) != -1) {
            return true;
        }
        return false;
    }

    public final ImmutableList<Emoji> m32634b(Emoji emoji) {
        Builder builder = ImmutableList.builder();
        if (m32631a(emoji)) {
            builder.m1069c(m32627a(emoji.f23124b, 0));
            int i = 127995;
            while (i <= 127999) {
                int i2 = i + 1;
                builder.m1069c(m32627a(emoji.f23124b, i));
                i = i2;
            }
        } else {
            builder.m1069c(emoji);
        }
        return builder.m1068b();
    }
}
