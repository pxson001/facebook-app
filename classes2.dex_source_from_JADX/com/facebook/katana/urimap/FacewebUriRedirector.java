package com.facebook.katana.urimap;

import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.FacebookUriUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: signal_cdma_ecio */
public class FacewebUriRedirector {
    private final ImmutableList<Entry> f4821a;

    /* compiled from: signal_cdma_ecio */
    public class Builder {
        public final List<Entry> f4814a = Lists.m1296a();

        public final Builder m8652a(String str, String str2, @Nullable String str3, String str4) {
            this.f4814a.add(new Entry(str, str2, str3, str4));
            return this;
        }
    }

    /* compiled from: signal_cdma_ecio */
    public class Entry {
        public final String f4815a;
        public final String f4816b;
        public final String f4817c;
        public Pattern f4818d;
        public Pattern f4819e;
        public final String f4820f;

        public Entry(String str, String str2, @Nullable String str3, String str4) {
            this.f4815a = (String) Preconditions.checkNotNull(str);
            this.f4816b = str2;
            this.f4817c = str3;
            this.f4820f = (String) Preconditions.checkNotNull(str4);
        }
    }

    @Nullable
    public final String m8653a(Uri uri) {
        if (uri.toString().startsWith(FBLinks.cr)) {
            String queryParameter = uri.getQueryParameter("href");
            if (queryParameter == null) {
                return null;
            }
            uri = Uri.parse(queryParameter);
        }
        if (uri.getHost() != null && !FacebookUriUtil.m20919c(uri)) {
            return null;
        }
        int size = this.f4821a.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.f4821a.get(i);
            int i2 = 1;
            Matcher matcher = null;
            String path = uri.getPath();
            if (path != null && path.startsWith(entry.f4815a)) {
                if (entry.f4818d == null) {
                    Pattern compile;
                    entry.f4818d = Pattern.compile(entry.f4816b != null ? entry.f4816b : "");
                    if (entry.f4817c != null) {
                        compile = Pattern.compile(entry.f4817c);
                    } else {
                        compile = null;
                    }
                    entry.f4819e = compile;
                }
                Matcher matcher2 = entry.f4818d.matcher(path.substring(entry.f4815a.length()));
                if (matcher2.matches()) {
                    if (entry.f4819e != null) {
                        CharSequence query = uri.getQuery();
                        if (query == null) {
                            query = "";
                        }
                        Matcher matcher3 = entry.f4819e.matcher(query);
                        if (matcher3.matches()) {
                            matcher = matcher3;
                        }
                    }
                    path = entry.f4820f;
                    for (int i3 = 1; i3 <= matcher2.groupCount(); i3++) {
                        path = path.replaceAll("<p\\$" + i3 + ">", matcher2.group(i3));
                    }
                    if (matcher != null) {
                        while (i2 <= matcher.groupCount()) {
                            path = path.replaceAll("<q\\$" + i2 + ">", matcher.group(i2));
                            i2++;
                        }
                    }
                    Object obj = path;
                }
            }
            Matcher matcher4 = matcher;
            if (matcher4 != null) {
                return matcher4;
            }
        }
        return null;
    }

    public FacewebUriRedirector(Builder builder) {
        this.f4821a = ImmutableList.copyOf(builder.f4814a);
    }
}
