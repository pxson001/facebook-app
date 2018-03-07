package android_src.mmsv2;

import android_src.mmsv2.DefaultCarrierConfigValuesLoader.C03371;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: setWallpaper */
class CarrierConfigXmlParser extends MmsXmlResourceParser {
    private final C03371 f3743b;

    CarrierConfigXmlParser(XmlPullParser xmlPullParser, C03371 c03371) {
        super(xmlPullParser);
        this.f3743b = c03371;
    }

    protected final void mo111a() {
        String str = null;
        String attributeValue = this.f3736a.getAttributeValue(null, "name");
        String name = this.f3736a.getName();
        int next = this.f3736a.next();
        if (next == 4) {
            str = this.f3736a.getText();
            next = this.f3736a.next();
        }
        if (next != 3) {
            throw new XmlPullParserException("Expecting end tag @" + m3474d());
        } else if (this.f3743b != null) {
            this.f3743b.m3499a(name, attributeValue, str);
        }
    }

    protected final String mo112b() {
        return "mms_config";
    }
}
