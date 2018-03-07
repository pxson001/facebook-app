package android_src.mmsv2;

import com.facebook.debug.log.BLog;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: settings_section */
public abstract class MmsXmlResourceParser {
    protected final XmlPullParser f3736a;
    private final StringBuilder f3737b = new StringBuilder();

    protected abstract void mo111a();

    protected abstract String mo112b();

    protected MmsXmlResourceParser(XmlPullParser xmlPullParser) {
        this.f3736a = xmlPullParser;
    }

    final void m3473c() {
        try {
            if (m3469a(2) != 2) {
                throw new XmlPullParserException("ApnsXmlProcessor: expecting start tag @" + m3474d());
            } else if (mo112b().equals(this.f3736a.getName())) {
                int next;
                while (true) {
                    next = this.f3736a.next();
                    if (next != 4) {
                        if (next != 2) {
                            break;
                        }
                        mo111a();
                    }
                }
                if (next != 3) {
                    throw new XmlPullParserException("Expecting start or end tag @" + m3474d());
                }
            } else {
                BLog.a("MmsLib", "Carrier config does not start with " + mo112b());
            }
        } catch (Throwable e) {
            BLog.a("MmsLib", "XmlResourceParser: I/O failure", e);
        } catch (Throwable e2) {
            BLog.a("MmsLib", "XmlResourceParser: parsing failure", e2);
        }
    }

    private int m3469a(int i) {
        int next;
        do {
            next = this.f3736a.next();
            if (next == i) {
                break;
            }
        } while (next != 1);
        return next;
    }

    protected final String m3474d() {
        int i = 0;
        this.f3737b.setLength(0);
        if (this.f3736a != null) {
            try {
                int eventType = this.f3736a.getEventType();
                this.f3737b.append(m3470b(eventType));
                if (eventType == 2 || eventType == 3 || eventType == 4) {
                    this.f3737b.append('<').append(this.f3736a.getName());
                    while (i < this.f3736a.getAttributeCount()) {
                        this.f3737b.append(' ').append(this.f3736a.getAttributeName(i)).append('=').append(this.f3736a.getAttributeValue(i));
                        i++;
                    }
                    this.f3737b.append("/>");
                }
                return this.f3737b.toString();
            } catch (Throwable e) {
                BLog.a("MmsLib", "XmlResourceParser exception", e);
            }
        }
        return "Unknown";
    }

    private static String m3470b(int i) {
        switch (i) {
            case 0:
                return "START_DOCUMENT";
            case 1:
                return "END_DOCUMENT";
            case 2:
                return "START_TAG";
            case 3:
                return "END_TAG";
            case 4:
                return "TEXT";
            default:
                return Integer.toString(i);
        }
    }
}
