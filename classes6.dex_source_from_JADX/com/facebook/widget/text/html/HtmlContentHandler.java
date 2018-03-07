package com.facebook.widget.text.html;

import android.text.Editable;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

/* compiled from: com.google.android.gms.location.places.internal.IPhotosCallbacks */
public class HtmlContentHandler implements ContentHandler {
    public ContentHandler f19877a;
    public Editable f19878b;
    public BaseTagHandler f19879c;

    public void setDocumentLocator(Locator locator) {
        this.f19877a.setDocumentLocator(locator);
    }

    public void startDocument() {
        this.f19877a.startDocument();
    }

    public void endDocument() {
        this.f19877a.endDocument();
    }

    public void startPrefixMapping(String str, String str2) {
        this.f19877a.startPrefixMapping(str, str2);
    }

    public void endPrefixMapping(String str) {
        this.f19877a.endPrefixMapping(str);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (!"fbhtml".equalsIgnoreCase(str2)) {
            if (this.f19879c == null || !this.f19879c.mo1503a(str2, attributes, this.f19878b)) {
                this.f19877a.startElement(str, str2, str3, attributes);
            }
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (!"fbhtml".equalsIgnoreCase(str2)) {
            if (this.f19879c == null || !this.f19879c.mo1502a(str2, this.f19878b)) {
                this.f19877a.endElement(str, str2, str3);
            }
        }
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.f19879c == null || !this.f19879c.mo1505a(cArr, i, i2, this.f19878b)) {
            this.f19877a.characters(cArr, i, i2);
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        this.f19877a.ignorableWhitespace(cArr, i, i2);
    }

    public void processingInstruction(String str, String str2) {
        this.f19877a.processingInstruction(str, str2);
    }

    public void skippedEntity(String str) {
        this.f19877a.skippedEntity(str);
    }
}
