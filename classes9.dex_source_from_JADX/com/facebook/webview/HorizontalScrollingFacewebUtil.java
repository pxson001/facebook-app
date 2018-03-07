package com.facebook.webview;

import android.net.Uri;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: shipping_options */
public class HorizontalScrollingFacewebUtil {
    private static final Class<?> f3519a = HorizontalScrollingFacewebUtil.class;
    public static final List<UriDetector> f3520b = Lists.a(new UriDetector[]{UriPatternDetector.m3325b("findfriends/browse.*"), UriPatternDetector.m3325b("friends/center.*"), UriPatternDetector.m3325b("home.php.*"), UriPatternDetector.m3325b("profile.php.*"), UriPatternDetector.m3325b("about/graphsearch.*"), new TimelineViewTypeDetector("map"), UriPatternDetector.m3325b("events/\\d+.*"), UriPatternDetector.m3325b("saved/.*"), UriPatternDetector.m3325b("profile/edit/questions/.*"), UriPatternDetector.m3325b("appcenter.*"), UriPatternDetector.m3325b("travel/slideshow.*")});

    /* compiled from: shipping_options */
    public interface UriDetector {
        boolean mo95a(String str);
    }

    /* compiled from: shipping_options */
    class UriPatternDetector implements UriDetector {
        private Pattern f3517a;

        public static UriDetector m3325b(String str) {
            return new UriPatternDetector("^(https|http)://m.(.*\\.)?facebook.com/" + str);
        }

        protected UriPatternDetector(String str) {
            this.f3517a = Pattern.compile(str);
        }

        public boolean mo95a(String str) {
            return this.f3517a.matcher(str).matches();
        }
    }

    /* compiled from: shipping_options */
    public class TimelineViewTypeDetector extends UriPatternDetector {
        private String f3518a;

        public TimelineViewTypeDetector(String str) {
            super("^(https|http)://m.(.*\\.)?facebook.com/.*");
            this.f3518a = str;
        }

        public final boolean mo95a(String str) {
            if (!super.mo95a(str)) {
                return false;
            }
            return this.f3518a.equalsIgnoreCase(Uri.parse(str).getQueryParameter("v"));
        }
    }
}
