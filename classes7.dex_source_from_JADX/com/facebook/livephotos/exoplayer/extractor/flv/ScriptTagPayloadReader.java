package com.facebook.livephotos.exoplayer.extractor.flv;

import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: page_save_error */
public final class ScriptTagPayloadReader extends TagPayloadReader {
    public ScriptTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected final boolean mo426a(ParsableByteArray parsableByteArray) {
        return true;
    }

    protected final void mo425a(ParsableByteArray parsableByteArray, long j) {
        if (m8935b(parsableByteArray) != 2) {
            throw new ParserException();
        }
        if (!"onMetaData".equals(m8937e(parsableByteArray))) {
            return;
        }
        if (m8935b(parsableByteArray) != 8) {
            throw new ParserException();
        }
        Map h = m8938h(parsableByteArray);
        if (h.containsKey("duration")) {
            double doubleValue = ((Double) h.get("duration")).doubleValue();
            if (doubleValue > 0.0d) {
                this.f7052b = (long) (doubleValue * 1000000.0d);
            }
        }
    }

    public static int m8935b(ParsableByteArray parsableByteArray) {
        return parsableByteArray.m9343f();
    }

    public static Double m8936d(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.m9351o()));
    }

    public static String m8937e(ParsableByteArray parsableByteArray) {
        int g = parsableByteArray.m9344g();
        int i = parsableByteArray.f7732b;
        parsableByteArray.m9339c(g);
        return new String(parsableByteArray.f7731a, i, g);
    }

    private static HashMap<String, Object> m8938h(ParsableByteArray parsableByteArray) {
        int s = parsableByteArray.m9355s();
        HashMap<String, Object> hashMap = new HashMap(s);
        for (int i = 0; i < s; i++) {
            hashMap.put(m8937e(parsableByteArray), m8934a(parsableByteArray, m8935b(parsableByteArray)));
        }
        return hashMap;
    }

    public static Object m8934a(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 0:
                return m8936d(parsableByteArray);
            case 1:
                boolean z = true;
                if (parsableByteArray.m9343f() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                return m8937e(parsableByteArray);
            case 3:
                HashMap hashMap = new HashMap();
                while (true) {
                    String e = m8937e(parsableByteArray);
                    int b = m8935b(parsableByteArray);
                    if (b == 9) {
                        return hashMap;
                    }
                    hashMap.put(e, m8934a(parsableByteArray, b));
                }
            case 8:
                return m8938h(parsableByteArray);
            case 10:
                int s = parsableByteArray.m9355s();
                ArrayList arrayList = new ArrayList(s);
                for (int i2 = 0; i2 < s; i2++) {
                    arrayList.add(m8934a(parsableByteArray, m8935b(parsableByteArray)));
                }
                return arrayList;
            case 11:
                Date date = new Date((long) m8936d(parsableByteArray).doubleValue());
                parsableByteArray.m9339c(2);
                return date;
            default:
                return null;
        }
    }
}
