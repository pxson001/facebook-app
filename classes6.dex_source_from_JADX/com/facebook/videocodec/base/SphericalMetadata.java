package com.facebook.videocodec.base;

import java.io.StringReader;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: reviews_feed_header_load_success */
public class SphericalMetadata {
    public boolean f5477a;
    public String f5478b = "";
    public String f5479c = "";

    /* compiled from: reviews_feed_header_load_success */
    public class SphericalMetadataParsingException extends Exception {
        public SphericalMetadataParsingException(Throwable th) {
            super(th);
        }
    }

    public SphericalMetadata(String str) {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            String str2 = "";
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 3:
                        m8158a(newPullParser.getName(), str2);
                        break;
                    case 4:
                        str2 = newPullParser.getText();
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            throw new SphericalMetadataParsingException(e);
        }
    }

    private void m8158a(String str, String str2) {
        String toLowerCase = str.toLowerCase(Locale.US);
        if (toLowerCase.equals("spherical")) {
            this.f5477a = str2.equalsIgnoreCase("true");
        } else if (toLowerCase.equals("projectiontype")) {
            this.f5478b = str2;
        } else if (toLowerCase.equals("stereomode")) {
            this.f5479c = str2;
        }
    }
}
