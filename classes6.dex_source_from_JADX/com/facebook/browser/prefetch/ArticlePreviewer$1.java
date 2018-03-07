package com.facebook.browser.prefetch;

import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextUtils;
import com.facebook.browser.prefetch.ArticleExtractor.ArticleTagHandler;
import java.io.File;
import java.text.BreakIterator;
import java.util.Locale;

/* compiled from: process_uptime */
class ArticlePreviewer$1 implements Runnable {
    final /* synthetic */ File f7407a;
    final /* synthetic */ String f7408b;
    final /* synthetic */ ArticlePreviewer f7409c;

    ArticlePreviewer$1(ArticlePreviewer articlePreviewer, File file, String str) {
        this.f7409c = articlePreviewer;
        this.f7407a = file;
        this.f7408b = str;
    }

    public void run() {
        File file = this.f7407a;
        ImageGetter imageGetter = null;
        if (file.length() <= 1073741824) {
            String b = ArticleExtractor.m10495b(file);
            if (b != null) {
                String obj = Html.fromHtml(b, null, new ArticleTagHandler()).toString();
                int indexOf = obj.indexOf("\n\n");
                ImageGetter imageGetter2 = null;
                while (indexOf >= 0) {
                    int indexOf2 = obj.indexOf("\n\n", indexOf + 2);
                    if (indexOf2 - indexOf > 300) {
                        b = obj.substring(indexOf + 2, indexOf2).trim();
                        Object obj2 = null;
                        Locale locale = Locale.US;
                        if (b.length() >= 300) {
                            BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
                            wordInstance.setText(b);
                            if (ArticleExtractor.m10494a(wordInstance) >= 100) {
                                wordInstance = BreakIterator.getSentenceInstance(locale);
                                wordInstance.setText(b);
                                if (ArticleExtractor.m10494a(wordInstance) >= 3) {
                                    obj2 = 1;
                                }
                            }
                        }
                        if (obj2 == null) {
                            b = null;
                        } else if (imageGetter2 != null) {
                            imageGetter = imageGetter2;
                            break;
                        }
                    } else {
                        Object obj3 = imageGetter2;
                    }
                    Object obj4 = b;
                    indexOf = indexOf2;
                }
                imageGetter = imageGetter2;
            }
        }
        ImageGetter imageGetter3 = imageGetter;
        if (!TextUtils.isEmpty(imageGetter3)) {
            this.f7409c.a.put(this.f7408b, imageGetter3);
        }
    }
}
