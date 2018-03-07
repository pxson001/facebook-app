package com.facebook.widget.text.html;

import android.text.Editable;
import android.text.Html.TagHandler;
import org.xml.sax.XMLReader;

/* compiled from: com.google.android.gms.location.places.internal.IGooglePlacesService */
public class HtmlTagHandler implements TagHandler {
    private final HtmlContentHandler f19880a;
    private boolean f19881b = false;

    public HtmlTagHandler(HtmlContentHandler htmlContentHandler) {
        this.f19880a = htmlContentHandler;
    }

    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        if (!this.f19881b) {
            HtmlContentHandler htmlContentHandler = this.f19880a;
            htmlContentHandler.f19878b = editable;
            htmlContentHandler.f19877a = xMLReader.getContentHandler();
            xMLReader.setContentHandler(this.f19880a);
            this.f19881b = true;
        }
    }
}
