package com.facebook.customsettings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: pinned_threads */
public class IntentParser {
    public static final Pattern f6563a = Pattern.compile("(.*?)\\.?(R\\.)(.*?)\\.(.*)");

    /* compiled from: pinned_threads */
    interface ExtraType {
        void mo267a(Bundle bundle, String str, String str2);
    }

    /* compiled from: pinned_threads */
    class IntegerExtra implements ExtraType {
        public final void mo267a(Bundle bundle, String str, String str2) {
            bundle.putInt(str, Integer.parseInt(str2));
        }
    }

    /* compiled from: pinned_threads */
    class StringExtra implements ExtraType {
        public final void mo267a(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    IntentParser() {
        throw new RuntimeException("Use IntentParser.fromXml()");
    }

    static Intent m6900a(String str, Context context, UriIntentMapper uriIntentMapper) {
        Intent intent = new Intent();
        Reader stringReader = new StringReader(str);
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(stringReader);
            newPullParser.nextTag();
            m6902a(context, newPullParser, intent);
            if (intent.getData() == null || !intent.getData().toString().startsWith(FBLinks.cr)) {
                Bundle bundle = new Bundle();
                while (newPullParser.next() != 3) {
                    if (newPullParser.getEventType() == 2) {
                        if (newPullParser.getName().equals("extra")) {
                            m6903a(context, newPullParser, bundle);
                        } else {
                            throw new IllegalArgumentException(String.format(Locale.US, "%s tag not supported", new Object[]{"extra"}));
                        }
                    }
                }
                intent.putExtras(bundle);
                stringReader.close();
                return intent;
            }
            intent = uriIntentMapper.a(context, intent.getData().toString());
            return intent;
        } finally {
            stringReader.close();
        }
    }

    private static void m6902a(Context context, XmlPullParser xmlPullParser, Intent intent) {
        xmlPullParser.require(2, "", "intent");
        Object attributeValue = xmlPullParser.getAttributeValue("", "android:action");
        if (!TextUtils.isEmpty(attributeValue)) {
            intent.setAction(attributeValue);
        }
        attributeValue = xmlPullParser.getAttributeValue("", "android:data");
        if (!TextUtils.isEmpty(attributeValue)) {
            intent.setData(Uri.parse(attributeValue));
        }
        attributeValue = xmlPullParser.getAttributeValue("", "android:targetClass");
        if (!TextUtils.isEmpty(attributeValue)) {
            intent.setClassName(context, attributeValue);
        }
    }

    private static void m6903a(Context context, XmlPullParser xmlPullParser, Bundle bundle) {
        int identifier;
        xmlPullParser.require(2, "", "extra");
        String a = m6901a(xmlPullParser, "", "android:name");
        Object a2 = m6901a(xmlPullParser, "", "android:value");
        Matcher matcher = f6563a.matcher(a2);
        if (matcher.find()) {
            String packageName;
            Object group = matcher.group(1);
            StringBuilder stringBuilder = new StringBuilder();
            if (TextUtils.isEmpty(group)) {
                packageName = context.getPackageName();
            } else {
                stringBuilder.append(group).append(":");
                packageName = null;
            }
            stringBuilder.append(matcher.group(3)).append("/").append(matcher.group(4));
            identifier = context.getResources().getIdentifier(stringBuilder.toString(), null, packageName);
        } else {
            identifier = 0;
        }
        int i = identifier;
        if (i > 0) {
            bundle.putInt(a, i);
        } else {
            ExtraType stringExtra;
            String a3 = m6901a(xmlPullParser, "", "type");
            i = -1;
            switch (a3.hashCode()) {
                case -891985903:
                    if (a3.equals("string")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1958052158:
                    if (a3.equals("integer")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    stringExtra = new StringExtra();
                    break;
                case 1:
                    stringExtra = new IntegerExtra();
                    break;
                default:
                    throw new IllegalArgumentException(String.format(Locale.US, "%s type is not supported", new Object[]{a3}));
            }
            stringExtra.mo267a(bundle, a, a2);
        }
        xmlPullParser.nextTag();
        xmlPullParser.require(3, "", "extra");
    }

    private static String m6901a(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(str, str2);
        if (TextUtils.isEmpty(attributeValue)) {
            return "string";
        }
        return attributeValue;
    }
}
