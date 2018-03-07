package com.facebook.fbui.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.facebook.R;

/* compiled from: Z) */
public class PopoverMenuInflater extends MenuInflater {
    private Context f12150a;

    /* compiled from: Z) */
    class ParsedItem {
        int f12138a;
        int f12139b;
        CharSequence f12140c;
        CharSequence f12141d;
        CharSequence f12142e;
        int f12143f;
        boolean f12144g;
        boolean f12145h;
        boolean f12146i;
        boolean f12147j;
        boolean f12148k;
        final /* synthetic */ PopoverMenuInflater f12149l;

        public ParsedItem(PopoverMenuInflater popoverMenuInflater) {
            this.f12149l = popoverMenuInflater;
        }
    }

    public PopoverMenuInflater(Context context) {
        super(context);
        this.f12150a = context;
    }

    public void inflate(int i, Menu menu) {
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f12150a.getResources().getXml(i);
            m20172a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (Throwable e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (Throwable e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private void m20172a(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        ParsedItem parsedItem = null;
        int eventType = xmlResourceParser.getEventType();
        do {
            String name = xmlResourceParser.getName();
            switch (eventType) {
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (!name.equals("item")) {
                        if (name.equals("menu") && parsedItem != null) {
                            Menu addSubMenu = menu.addSubMenu(-1, parsedItem.f12138a, parsedItem.f12139b, parsedItem.f12140c);
                            parsedItem.f12148k = true;
                            m20173a(parsedItem, addSubMenu.getItem());
                            m20172a(xmlResourceParser, attributeSet, addSubMenu);
                            break;
                        }
                    }
                    parsedItem = m20171a(attributeSet);
                    break;
                case 3:
                    if (xmlResourceParser.getName().equals("item")) {
                        if (!parsedItem.f12148k) {
                            m20173a(parsedItem, menu.add(-1, parsedItem.f12138a, parsedItem.f12139b, parsedItem.f12140c));
                            break;
                        }
                    } else if (name.equals("menu")) {
                        return;
                    }
                    break;
            }
            eventType = xmlResourceParser.next();
        } while (eventType != 1);
    }

    private ParsedItem m20171a(AttributeSet attributeSet) {
        ParsedItem parsedItem = new ParsedItem(this);
        TypedArray obtainStyledAttributes = this.f12150a.obtainStyledAttributes(attributeSet, R.styleable.MenuItemImpl);
        parsedItem.f12138a = obtainStyledAttributes.getResourceId(3, -1);
        parsedItem.f12139b = obtainStyledAttributes.getInt(6, 0);
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId > 0) {
            parsedItem.f12140c = this.f12150a.getString(resourceId);
        } else {
            parsedItem.f12140c = obtainStyledAttributes.getText(7);
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            parsedItem.f12141d = this.f12150a.getString(resourceId);
        } else {
            parsedItem.f12141d = obtainStyledAttributes.getText(2);
        }
        resourceId = obtainStyledAttributes.getResourceId(9, 0);
        if (resourceId > 0) {
            parsedItem.f12142e = this.f12150a.getString(resourceId);
        } else {
            parsedItem.f12142e = obtainStyledAttributes.getText(9);
        }
        parsedItem.f12143f = obtainStyledAttributes.getResourceId(0, 0);
        parsedItem.f12144g = obtainStyledAttributes.getBoolean(8, false);
        parsedItem.f12145h = obtainStyledAttributes.getBoolean(4, false);
        parsedItem.f12146i = obtainStyledAttributes.getBoolean(5, true);
        parsedItem.f12147j = obtainStyledAttributes.getBoolean(1, true);
        parsedItem.f12148k = false;
        obtainStyledAttributes.recycle();
        return parsedItem;
    }

    private static void m20173a(ParsedItem parsedItem, MenuItem menuItem) {
        menuItem.setVisible(parsedItem.f12146i).setEnabled(parsedItem.f12147j).setIcon(parsedItem.f12143f).setCheckable(parsedItem.f12144g).setChecked(parsedItem.f12145h);
        if (menuItem instanceof MenuItemImpl) {
            ((MenuItemImpl) menuItem).m20147a(parsedItem.f12141d);
            ((MenuItemImpl) menuItem).m20149b(parsedItem.f12142e);
        }
    }
}
