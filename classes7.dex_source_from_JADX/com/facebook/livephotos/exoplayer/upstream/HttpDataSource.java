package com.facebook.livephotos.exoplayer.upstream;

import android.text.TextUtils;
import com.facebook.livephotos.exoplayer.util.Predicate;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: overlay */
public interface HttpDataSource extends UriDataSource {
    public static final Predicate<String> f7646a = new C06261();

    /* compiled from: overlay */
    public final class C06261 {
        C06261() {
        }

        public final boolean m9284a(Object obj) {
            String str;
            String str2 = (String) obj;
            if (str2 == null) {
                str = null;
            } else {
                str = str2.toLowerCase(Locale.US);
            }
            String str3 = str;
            return (TextUtils.isEmpty(str3) || ((str3.contains("text") && !str3.contains("text/vtt")) || str3.contains("html") || str3.contains("xml"))) ? false : true;
        }
    }

    /* compiled from: overlay */
    public class HttpDataSourceException extends IOException {
        public final DataSpec dataSpec;

        public HttpDataSourceException(String str, DataSpec dataSpec) {
            super(str);
            this.dataSpec = dataSpec;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec) {
            super(iOException);
            this.dataSpec = dataSpec;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec) {
            super(str, iOException);
            this.dataSpec = dataSpec;
        }
    }

    /* compiled from: overlay */
    public final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec);
            this.contentType = str;
        }
    }

    /* compiled from: overlay */
    public final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i, dataSpec);
            this.responseCode = i;
            this.headerFields = map;
        }
    }
}
