package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: last_tracking_code */
public class JfifUtil {
    private JfifUtil() {
    }

    public static int m25070a(InputStream inputStream) {
        int i = 0;
        try {
            int b = m25071b(inputStream);
            if (b != 0) {
                i = TiffUtil.m25079a(inputStream, b);
            }
        } catch (IOException e) {
        }
        return i;
    }

    private static int m25071b(InputStream inputStream) {
        int a;
        int i = 1;
        Preconditions.a(inputStream);
        while (StreamProcessor.m25072a(inputStream, 1, false) == 255) {
            int i2 = 255;
            while (i2 == 255) {
                i2 = StreamProcessor.m25072a(inputStream, 1, false);
            }
            if (225 == 192) {
                Object obj;
                switch (i2) {
                    case 192:
                    case 193:
                    case 194:
                    case 195:
                    case 197:
                    case 198:
                    case 199:
                    case 201:
                    case 202:
                    case 203:
                    case 205:
                    case 206:
                    case 207:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    if (i != 0) {
                        a = StreamProcessor.m25072a(inputStream, 2, false) - 2;
                        if (a > 6) {
                            int a2 = StreamProcessor.m25072a(inputStream, 4, false);
                            a -= 4;
                            int a3 = StreamProcessor.m25072a(inputStream, 2, false);
                            a -= 2;
                            if (a2 == 1165519206 && a3 == 0) {
                                return a;
                            }
                        }
                    }
                    return 0;
                }
            }
            if (i2 != 225) {
                if (!(i2 == 216 || i2 == 1)) {
                    if (i2 == 217 || i2 == 218) {
                        i = 0;
                    } else {
                        inputStream.skip((long) (StreamProcessor.m25072a(inputStream, 2, false) - 2));
                    }
                }
            }
            if (i != 0) {
                a = StreamProcessor.m25072a(inputStream, 2, false) - 2;
                if (a > 6) {
                    int a22 = StreamProcessor.m25072a(inputStream, 4, false);
                    a -= 4;
                    int a32 = StreamProcessor.m25072a(inputStream, 2, false);
                    a -= 2;
                    return a;
                }
            }
            return 0;
        }
        i = 0;
        if (i != 0) {
            a = StreamProcessor.m25072a(inputStream, 2, false) - 2;
            if (a > 6) {
                int a222 = StreamProcessor.m25072a(inputStream, 4, false);
                a -= 4;
                int a322 = StreamProcessor.m25072a(inputStream, 2, false);
                a -= 2;
                return a;
            }
        }
        return 0;
    }
}
