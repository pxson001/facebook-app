package com.facebook.friendsharing.gif.activity;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.friendsharing.gif.model.GifList;
import com.facebook.friendsharing.gif.model.GifModelContainer;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import javax.inject.Inject;

/* compiled from: SEND_AS_MESSAGE */
public class GifFetch {
    private static final String f23870a = GifFetch.class.getSimpleName();
    private final Lazy<FbErrorReporter> f23871b;
    private final FbObjectMapper f23872c;

    @Inject
    public GifFetch(Lazy<FbErrorReporter> lazy, FbObjectMapper fbObjectMapper) {
        this.f23871b = lazy;
        this.f23872c = fbObjectMapper;
    }

    public final ImmutableList<GifModelContainer> m26007a(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Reader inputStreamReader2 = new InputStreamReader(new URL(str).openStream());
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            bufferedReader2.close();
                            inputStreamReader2.close();
                            return m26006b(stringBuffer.toString());
                        }
                    } catch (Throwable e) {
                        inputStreamReader = inputStreamReader2;
                        BufferedReader bufferedReader3 = bufferedReader2;
                        th = e;
                        bufferedReader = bufferedReader3;
                    }
                }
            } catch (Throwable e2) {
                th = e2;
                bufferedReader = null;
                Reader reader = inputStreamReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                ((AbstractFbErrorReporter) this.f23871b.get()).a(f23870a, "Error while fetching GIFs", th);
                throw th;
            }
        } catch (Throwable e22) {
            th = e22;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            ((AbstractFbErrorReporter) this.f23871b.get()).a(f23870a, "Error while fetching GIFs", th);
            throw th;
        }
    }

    private ImmutableList<GifModelContainer> m26006b(String str) {
        try {
            return ((GifList) this.f23872c.a(str.toString(), GifList.class)).m26047a();
        } catch (Throwable e) {
            Throwable th = e;
            ((AbstractFbErrorReporter) this.f23871b.get()).a(f23870a, "Error while parsing JSON", th);
            throw th;
        }
    }
}
