package com.facebook.browser.prefetch;

import android.text.Editable;
import android.text.Html.TagHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.BreakIterator;
import javax.annotation.Nullable;
import org.xml.sax.XMLReader;

/* compiled from: processing */
public class ArticleExtractor {

    /* compiled from: processing */
    public class ArticleTagHandler implements TagHandler {
        private int f7406a = -1;

        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if (z) {
                this.f7406a = editable.length();
            } else if (this.f7406a >= 0) {
                editable.delete(this.f7406a, editable.length());
                this.f7406a = -1;
            }
        }
    }

    @Nullable
    public static String m10495b(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine).append("\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    bufferedReader2 = bufferedReader;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            bufferedReader.close();
            int indexOf = stringBuilder.indexOf("<head");
            int indexOf2 = stringBuilder.indexOf("/head>", indexOf + 5);
            if (indexOf >= 0 && indexOf2 > indexOf) {
                stringBuilder = stringBuilder.delete(indexOf, indexOf2 + 6);
            }
            return stringBuilder.toString();
        } catch (Exception e3) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            }
            throw th;
        }
    }

    public static int m10494a(BreakIterator breakIterator) {
        int first = breakIterator.first();
        int i = 0;
        while (first != -1) {
            first = breakIterator.next();
            i++;
        }
        return i;
    }
}
