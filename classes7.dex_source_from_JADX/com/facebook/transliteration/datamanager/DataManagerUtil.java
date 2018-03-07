package com.facebook.transliteration.datamanager;

import android.content.Context;
import android.text.Html;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.transliteration.TransliterateAnalyticsLogger;
import com.facebook.transliteration.api.DownloadModelMethod;
import com.facebook.transliteration.api.DownloadModelParams;
import com.facebook.transliteration.api.TransliterationModelResponse;
import com.facebook.transliteration.database.TransliterationDatabaseSupplier;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: existing_place_items */
public class DataManagerUtil {
    public static final PrefKey f15167a = ((PrefKey) SharedPrefKeys.a.a("transliteration/"));
    private static final String f15168c = DataManagerUtil.class.getSimpleName();
    public TransliterationDatabaseSupplier f15169b;
    private Context f15170d;
    private DownloadModelMethod f15171e;
    private FbSharedPreferences f15172f;
    private AbstractSingleMethodRunner f15173g;
    private TransliterateAnalyticsLogger f15174h;
    private final Clock f15175i;

    public static DataManagerUtil m19168b(InjectorLike injectorLike) {
        return new DataManagerUtil((Context) injectorLike.getInstance(Context.class), new DownloadModelMethod(), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), TransliterateAnalyticsLogger.m19046a(injectorLike), TransliterationDatabaseSupplier.m19160a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DataManagerUtil(Context context, DownloadModelMethod downloadModelMethod, FbSharedPreferences fbSharedPreferences, AbstractSingleMethodRunner abstractSingleMethodRunner, TransliterateAnalyticsLogger transliterateAnalyticsLogger, TransliterationDatabaseSupplier transliterationDatabaseSupplier, Clock clock) {
        this.f15170d = context;
        this.f15171e = downloadModelMethod;
        this.f15172f = fbSharedPreferences;
        this.f15173g = abstractSingleMethodRunner;
        this.f15174h = transliterateAnalyticsLogger;
        this.f15169b = transliterationDatabaseSupplier;
        this.f15175i = clock;
    }

    public final void m19178a(String str, int i, int i2, int i3) {
        Closeable fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(new File(this.f15170d.getFilesDir(), m19175g(i, i2)));
            try {
                fileOutputStream.write(str.getBytes());
                m19170b("transliteration_version", i, i2, i3);
                m19166a(fileOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    BLog.b(f15168c, "File not found while storing", e);
                    m19166a(fileOutputStream);
                } catch (Throwable th) {
                    e = th;
                    m19166a(fileOutputStream);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                BLog.b(f15168c, "IO Exception while writing to file", e);
                m19166a(fileOutputStream);
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileOutputStream = null;
            BLog.b(f15168c, "File not found while storing", e);
            m19166a(fileOutputStream);
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            BLog.b(f15168c, "IO Exception while writing to file", e);
            m19166a(fileOutputStream);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            m19166a(fileOutputStream);
            throw e;
        }
    }

    private static void m19166a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                BLog.b(f15168c, "IO Exception, couldnt close stream", e);
            }
        }
    }

    private static String m19164a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStream.close();
                    return stringBuilder.toString();
                }
            }
        } catch (Throwable e) {
            BLog.b(f15168c, "No file to load from", e);
            return null;
        } catch (Throwable e2) {
            BLog.b(f15168c, "file IO exception on reading", e2);
            return null;
        }
    }

    private String m19165a(String str) {
        Closeable open;
        Throwable e;
        Throwable th;
        String str2 = null;
        try {
            open = this.f15170d.getAssets().open(str);
            try {
                str2 = m19164a((InputStream) open);
                m19166a(open);
            } catch (IOException e2) {
                e = e2;
                try {
                    BLog.b(f15168c, "file IO exception on reading", e);
                    m19166a(open);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    m19166a(open);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            open = str2;
            BLog.b(f15168c, "file IO exception on reading", e);
            m19166a(open);
            return str2;
        } catch (Throwable e4) {
            open = str2;
            th = e4;
            m19166a(open);
            throw th;
        }
        return str2;
    }

    public final String m19176a(int i) {
        return m19165a("keyboard_" + i);
    }

    public final String m19177a(int i, int i2) {
        return m19165a(m19175g(i, i2));
    }

    public final String m19179b(int i, int i2) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(this.f15170d.getFilesDir(), m19175g(i, i2)));
            try {
                str = m19164a((InputStream) fileInputStream);
                m19166a(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    BLog.b(f15168c, "file IO exception on reading", e);
                    m19166a(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    m19166a(fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = str;
            BLog.b(f15168c, "file IO exception on reading", e);
            m19166a(fileInputStream);
            return str;
        } catch (Throwable e4) {
            fileInputStream = str;
            th = e4;
            m19166a(fileInputStream);
            throw th;
        }
        return str;
    }

    public final String m19180c(int i, int i2) {
        if (m19163a("transliteration_dictionary", i, i2) == 1) {
            return m19174f(i, i2);
        }
        return null;
    }

    public final String m19181d(int i, int i2) {
        try {
            TransliterationModelResponse transliterationModelResponse = (TransliterationModelResponse) this.f15173g.a(this.f15171e, new DownloadModelParams(i, i2, false, m19163a("transliteration_version", i, i2)));
            if (transliterationModelResponse != null && transliterationModelResponse.m19146a() != null) {
                return m19171c(transliterationModelResponse.m19146a());
            }
            this.f15174h.m19063f();
            return null;
        } catch (Throwable e) {
            BLog.b(f15168c, "Download Failed", e);
            this.f15174h.m19063f();
            return null;
        }
    }

    public final String m19182e(int i, int i2) {
        if (!m19172d("transliteration_dictionary")) {
            return null;
        }
        try {
            int a = m19163a("transliteration_dictionary", i, i2);
            TransliterationModelResponse transliterationModelResponse = (TransliterationModelResponse) this.f15173g.a(this.f15171e, new DownloadModelParams(i, i2, true, a));
            if (transliterationModelResponse == null || transliterationModelResponse.m19147b() == null) {
                this.f15174h.m19063f();
                return null;
            }
            m19173e("transliteration_dictionary");
            if (transliterationModelResponse.mVersion.intValue() > a) {
                m19170b("transliteration_dictionary", i, i2, transliterationModelResponse.mVersion.intValue());
            }
            return transliterationModelResponse.m19148c();
        } catch (Throwable e) {
            BLog.b(f15168c, "Download Failed", e);
            this.f15174h.m19063f();
            return null;
        }
    }

    public static String m19169b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("\\\\u([0-9A-Fa-f]{4})").matcher(str);
        while (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.appendCodePoint(parseInt);
            } catch (Throwable e) {
                BLog.b(f15168c, "Unicode Exception", e);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static String m19171c(String str) {
        return m19169b(Html.fromHtml(str).toString());
    }

    private boolean m19172d(String str) {
        if (this.f15175i.a() - this.f15172f.a((PrefKey) f15167a.a(str + "_last_download_time"), 0) > TimeUnit.DAYS.toMillis(7)) {
            return true;
        }
        return false;
    }

    private void m19173e(String str) {
        this.f15172f.edit().a((PrefKey) f15167a.a(str + "_last_download_time"), this.f15175i.a()).commit();
    }

    private void m19170b(String str, int i, int i2, int i3) {
        this.f15172f.edit().a(m19167b(str, i, i2), i3).commit();
    }

    private int m19163a(String str, int i, int i2) {
        return this.f15172f.a(m19167b(str, i, i2), 1);
    }

    private static String m19175g(int i, int i2) {
        return "transliteration_model_" + i + "_" + i2;
    }

    private String m19174f(int i, int i2) {
        return m19165a("transliteration_dictionary_" + i + "_" + i2);
    }

    private static PrefKey m19167b(String str, int i, int i2) {
        return (PrefKey) f15167a.a(str + "_" + i + "_" + i2);
    }
}
