package com.facebook.photos.base.analytics;

import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.TriState;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.AuthTokenNullException;
import com.facebook.http.protocol.BatchMethodNotExecutedException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.HttpResponseException;

/* compiled from: internal_calling_package */
public class ExceptionInterpreter implements PhotoFlowLogger$ExceptionReporter {
    public static int f12611a = 1366046;
    private static int f12612b = 1366064;
    private static final Pattern f12613c = Pattern.compile("\"is_transient\"[\\s]*:[\\s]*([truefalsTRUEFALS]+)\\W");
    private static final Pattern f12614d = Pattern.compile("\"code\"[\\s]*:[\\s]*(\\d+)\\W");
    private static final Pattern f12615e = Pattern.compile("\"error_code\"[\\s]*:[\\s]*(\\d+)\\W");
    private static final Pattern f12616f = Pattern.compile("\"error_subcode\"[\\s]*:[\\s]*(\\d+)\\W");
    private static final ImmutableSet<Integer> f12617q = ImmutableSet.of(Integer.valueOf(1), Integer.valueOf(2));
    private static final ImmutableSet<Integer> f12618r = ImmutableSet.of(Integer.valueOf(368));
    private static final ImmutableSet<Integer> f12619s = ImmutableSet.of(Integer.valueOf(302), Integer.valueOf(307), Integer.valueOf(308), Integer.valueOf(408), Integer.valueOf(502), Integer.valueOf(503), new Integer[]{Integer.valueOf(504)});
    private static final ImmutableSet<Integer> f12620t = ImmutableSet.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1366043), Integer.valueOf(f12611a));
    private static final ImmutableSet<Integer> f12621u = ImmutableSet.of(Integer.valueOf(1349124), Integer.valueOf(1366002), Integer.valueOf(1366035), Integer.valueOf(1366050), Integer.valueOf(f12612b), Integer.valueOf(1367008), new Integer[]{Integer.valueOf(1376025), Integer.valueOf(1399017), Integer.valueOf(1455003), Integer.valueOf(1607036), Integer.valueOf(1610002), Integer.valueOf(1610003), Integer.valueOf(1610007), Integer.valueOf(1462004)});
    public Exception f12622g;
    private String f12623h;
    private int f12624i;
    private int f12625j;
    private boolean f12626k;
    public boolean f12627l;
    public boolean f12628m;
    public String f12629n;
    public Diagnostic f12630o;
    private boolean f12631p;

    /* compiled from: internal_calling_package */
    public enum Diagnostic {
        CANT_UPLOAD_TO_ALBUM,
        CANT_UPLOAD_ALBUM_PHOTO,
        PERMANENT_API_ERROR_WITH_VALID_MESSAGE,
        TRANSIENT_ERROR,
        PERMANENT_ERROR,
        PERMANENT_CONTENT_REJECTED_ERROR,
        PERMANENT_PROCESSING_ERROR,
        PERMANENT_VIDEO_PROCESSING_ERROR,
        NETWORK_ERROR,
        NOT_ENOUGH_DISK_SPACE,
        MISSING_MEDIA_FILE,
        APP_INTERRUPTED_TOO_MANY_TIMES
    }

    public final Exception m19959a() {
        return this.f12622g;
    }

    public final String mo1088b() {
        return this.f12631p ? ExceptionUtil.a(this.f12622g) : null;
    }

    public final String mo1089c() {
        return this.f12622g.getClass().getName();
    }

    public final String mo1090d() {
        return this.f12623h;
    }

    public final int mo1091e() {
        return this.f12624i;
    }

    public final int mo1092f() {
        return this.f12625j;
    }

    public final String mo1093g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Network:").append(Boolean.toString(this.f12627l));
        stringBuilder.append(";Retry:").append(Boolean.toString(this.f12628m));
        return stringBuilder.toString();
    }

    public final boolean m19967h() {
        return this.f12626k;
    }

    public final boolean m19968i() {
        return this.f12627l;
    }

    public final boolean m19969j() {
        return this.f12628m;
    }

    public final boolean m19970k() {
        return !this.f12626k && this.f12624i == f12611a;
    }

    public ExceptionInterpreter(boolean z) {
        this.f12631p = z;
    }

    public ExceptionInterpreter(Exception exception) {
        this(exception, false);
    }

    public ExceptionInterpreter(Exception exception, boolean z) {
        this.f12622g = exception;
        this.f12631p = z;
        m19960a(exception);
    }

    public final void m19960a(Exception exception) {
        String str = null;
        this.f12622g = exception;
        String a;
        if (exception instanceof ApiException) {
            ApiErrorResult b = ((ApiException) exception).b();
            if (b != null) {
                a = m19953a(b.c(), "<no error message>");
                String d = b.d();
                if (d != null) {
                    a = a + ", " + d;
                }
                this.f12623h = a;
                this.f12624i = b.a();
                if (f12618r.contains(Integer.valueOf(this.f12624i))) {
                    a = b.c();
                }
                a = null;
            } else {
                this.f12623h = "<no error result>";
                this.f12624i = -1;
                a = null;
            }
            this.f12625j = -1;
            this.f12626k = true;
            this.f12627l = false;
            if (exception instanceof BatchMethodNotExecutedException) {
                this.f12628m = true;
            } else {
                this.f12628m = f12617q.contains(Integer.valueOf(this.f12624i));
            }
            if (this.f12628m) {
                this.f12630o = Diagnostic.TRANSIENT_ERROR;
                str = a;
            } else if (this.f12624i == 120) {
                this.f12630o = Diagnostic.CANT_UPLOAD_TO_ALBUM;
                str = a;
            } else if (this.f12624i == 122) {
                this.f12630o = Diagnostic.CANT_UPLOAD_ALBUM_PHOTO;
                str = a;
            } else if (a != null) {
                this.f12630o = Diagnostic.PERMANENT_API_ERROR_WITH_VALID_MESSAGE;
                str = a;
            } else {
                this.f12630o = Diagnostic.PERMANENT_ERROR;
                str = a;
            }
        } else {
            this.f12626k = false;
            this.f12623h = exception.getMessage() != null ? exception.getMessage() + "\n" + Throwables.getStackTraceAsString(exception) : "<no error result>";
            if (exception instanceof HttpResponseException) {
                int i;
                boolean z;
                TriState triState;
                int i2;
                this.f12625j = ((HttpResponseException) exception).getStatusCode();
                TriState triState2 = TriState.UNSET;
                a = this.f12623h;
                if (a == null) {
                    i = -1;
                } else {
                    i = 0;
                    while (i < a.length()) {
                        char charAt = a.charAt(i);
                        if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && charAt != ' '))) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                }
                int i3 = i;
                boolean z2 = i3 == -1 || m19954a(this.f12623h, "<html>", i3) || m19954a(this.f12623h, "<!DOCTYPE ", i3);
                if (z2) {
                    z = z2;
                    triState = null;
                    i3 = -1;
                    i2 = 0;
                } else {
                    int c;
                    int a2 = m19951a(this.f12623h, i3);
                    if (a2 >= 0) {
                        c = m19957c(this.f12623h, i3);
                    } else {
                        a2 = m19955b(this.f12623h, i3);
                        c = -1;
                    }
                    if (a2 < 0) {
                        z2 = true;
                    }
                    boolean z3 = z2;
                    i2 = a2;
                    triState = m19958d(this.f12623h, i3);
                    i3 = c;
                    z = z3;
                }
                if (z) {
                    this.f12627l = true;
                    this.f12628m = true;
                    this.f12624i = -1;
                    this.f12630o = Diagnostic.NETWORK_ERROR;
                } else {
                    this.f12627l = false;
                    if (triState != TriState.UNSET) {
                        this.f12624i = i2;
                        this.f12628m = triState.asBoolean();
                    } else if (this.f12625j == 500) {
                        this.f12624i = i2;
                        if (i3 != -1) {
                            i2 = i3;
                        }
                        if (f12620t.contains(Integer.valueOf(i2))) {
                            this.f12628m = true;
                        } else if (f12621u.contains(Integer.valueOf(i2))) {
                            this.f12628m = false;
                        } else {
                            this.f12628m = this.f12623h.startsWith("Internal Server Error");
                        }
                    } else {
                        this.f12624i = -1;
                        this.f12628m = f12619s.contains(Integer.valueOf(this.f12625j));
                    }
                    if (this.f12628m) {
                        this.f12630o = Diagnostic.TRANSIENT_ERROR;
                    } else if (this.f12624i == f12612b) {
                        this.f12630o = Diagnostic.PERMANENT_CONTENT_REJECTED_ERROR;
                    } else {
                        this.f12630o = Diagnostic.PERMANENT_ERROR;
                    }
                }
            } else {
                this.f12625j = -1;
                this.f12624i = -1;
                Class cls = exception.getClass();
                String name = cls.getName();
                if (exception instanceof InterpretedException) {
                    InterpretedException interpretedException = (InterpretedException) exception;
                    this.f12627l = false;
                    this.f12628m = interpretedException.m19971a();
                    if (interpretedException.m19972b() != null) {
                        this.f12630o = interpretedException.m19972b();
                    } else if (this.f12628m) {
                        this.f12630o = Diagnostic.TRANSIENT_ERROR;
                    } else {
                        this.f12630o = Diagnostic.PERMANENT_ERROR;
                    }
                } else if (exception instanceof ImageResizingException) {
                    this.f12627l = false;
                    this.f12628m = ((ImageResizingException) exception).a();
                    if (this.f12628m) {
                        this.f12630o = Diagnostic.TRANSIENT_ERROR;
                    } else {
                        this.f12630o = Diagnostic.PERMANENT_PROCESSING_ERROR;
                    }
                } else if (name.startsWith("org.apache.http.") || name.startsWith("javax.net.") || name.startsWith("java.net.") || name.startsWith("com.facebook.proxygen.HttpNetworkException") || cls == SecurityException.class) {
                    this.f12627l = true;
                    this.f12628m = true;
                    this.f12630o = Diagnostic.NETWORK_ERROR;
                } else if (cls == FileNotFoundException.class) {
                    this.f12627l = false;
                    this.f12628m = false;
                    this.f12630o = Diagnostic.PERMANENT_PROCESSING_ERROR;
                } else if (cls == AuthTokenNullException.class) {
                    this.f12627l = false;
                    this.f12628m = false;
                    this.f12630o = Diagnostic.PERMANENT_ERROR;
                } else if (exception instanceof RuntimeException) {
                    this.f12627l = false;
                    this.f12628m = false;
                    this.f12630o = Diagnostic.PERMANENT_ERROR;
                } else if (exception instanceof TranscodingFailedException) {
                    this.f12627l = false;
                    this.f12628m = false;
                    this.f12630o = Diagnostic.PERMANENT_VIDEO_PROCESSING_ERROR;
                } else {
                    this.f12627l = false;
                    this.f12628m = true;
                    this.f12630o = Diagnostic.TRANSIENT_ERROR;
                }
            }
        }
        this.f12629n = str;
    }

    @VisibleForTesting
    private static boolean m19954a(String str, String str2, int i) {
        return str.regionMatches(true, i, str2, 0, str2.length());
    }

    @VisibleForTesting
    private static int m19951a(String str, int i) {
        return m19952a(str, f12614d, i);
    }

    @VisibleForTesting
    private static int m19955b(String str, int i) {
        return m19952a(str, f12615e, i);
    }

    @VisibleForTesting
    private static int m19957c(String str, int i) {
        return m19952a(str, f12616f, i);
    }

    private static int m19952a(String str, Pattern pattern, int i) {
        return (int) m19956b(str, pattern, i);
    }

    private static long m19956b(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find(i)) {
            String group = matcher.group(1);
            if (group != null) {
                try {
                    return Long.parseLong(group);
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1;
    }

    private static String m19953a(String str, String str2) {
        return str != null ? str : str2;
    }

    @VisibleForTesting
    private static TriState m19958d(String str, int i) {
        Matcher matcher = f12613c.matcher(str);
        if (matcher.find(i)) {
            String group = matcher.group(1);
            if (group != null) {
                if ("true".equalsIgnoreCase(group)) {
                    return TriState.YES;
                }
                if ("false".equalsIgnoreCase(group)) {
                    return TriState.NO;
                }
            }
        }
        return TriState.UNSET;
    }
}
