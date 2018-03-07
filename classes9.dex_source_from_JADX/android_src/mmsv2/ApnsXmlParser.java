package android_src.mmsv2;

import android.content.ContentValues;
import android_src.mmsv2.DefaultApnSettingsLoader.C03361;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: setting_status */
class ApnsXmlParser extends MmsXmlResourceParser {
    private final C03361 f3738b;
    private final ContentValues f3739c = new ContentValues();

    ApnsXmlParser(XmlPullParser xmlPullParser, C03361 c03361) {
        super(xmlPullParser);
        this.f3738b = c03361;
    }

    protected final void mo111a() {
        if ("apn".equals(this.f3736a.getName())) {
            this.f3739c.clear();
            for (int i = 0; i < this.f3736a.getAttributeCount(); i++) {
                String attributeName = this.f3736a.getAttributeName(i);
                if (attributeName != null) {
                    this.f3739c.put(attributeName, this.f3736a.getAttributeValue(i));
                }
            }
            if (this.f3738b != null) {
                this.f3738b.m3480a(this.f3739c);
            }
        }
        if (this.f3736a.next() != 3) {
            throw new XmlPullParserException("Expecting end tag @" + m3474d());
        }
    }

    protected final String mo112b() {
        return "apns";
    }
}
