package com.facebook.tigon.httpclientadapter;

import android.util.SparseArray;
import com.facebook.tigon.tigonapi.TigonResponse;

/* compiled from: not_cursor */
public class TigonHttpUtils {
    public static SparseArray<String> f4971a;

    static {
        SparseArray sparseArray = new SparseArray(41);
        f4971a = sparseArray;
        sparseArray.append(100, "Continue");
        f4971a.append(101, "Switching Protocols");
        f4971a.append(200, "OK");
        f4971a.append(201, "Created");
        f4971a.append(202, "Accepted");
        f4971a.append(203, "Non-Authoritative Information");
        f4971a.append(204, "No Content");
        f4971a.append(205, "Reset Content");
        f4971a.append(206, "Partial Content");
        f4971a.append(300, "Multiple Choices");
        f4971a.append(301, "Moved Permanently");
        f4971a.append(302, "Found");
        f4971a.append(303, "See Other");
        f4971a.append(304, "Not Modified");
        f4971a.append(305, "Use Proxy");
        f4971a.append(307, "Temporary Redirect");
        f4971a.append(400, "Bad Request");
        f4971a.append(401, "Unauthorized");
        f4971a.append(402, "Payment Required");
        f4971a.append(403, "Forbidden");
        f4971a.append(404, "Not Found");
        f4971a.append(405, "Method Not Allowed");
        f4971a.append(406, "Not Acceptable");
        f4971a.append(407, "Proxy Authentication Required");
        f4971a.append(408, "Request Timeout");
        f4971a.append(409, "Conflict");
        f4971a.append(410, "Gone");
        f4971a.append(411, "Length Required");
        f4971a.append(412, "Precondition Failed");
        f4971a.append(413, "Payload Too Large");
        f4971a.append(414, "URI Too Long");
        f4971a.append(415, "Unsupported Media Type");
        f4971a.append(416, "Range Not Satisfiable");
        f4971a.append(417, "Expectation Failed");
        f4971a.append(426, "Upgrade Required");
        f4971a.append(500, "Internal Server Error");
        f4971a.append(501, "Not Implemented");
        f4971a.append(502, "Bad Gateway");
        f4971a.append(503, "Service Unavailable");
        f4971a.append(504, "Gateway Timeout");
        f4971a.append(505, "HTTP Version Not Supported");
    }

    public static long m6245a(TigonResponse tigonResponse) {
        String str = (String) tigonResponse.f5058b.get("Content-Length");
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return -1;
    }
}
