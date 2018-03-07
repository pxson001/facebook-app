package com.facebook.user.names;

import com.facebook.user.names.ContactLocaleUtils.ContactLocaleUtilsBase;
import com.facebook.user.names.HanziToPinyin.Token;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: convertColor */
class ContactLocaleUtils$ChineseContactUtils extends ContactLocaleUtilsBase {
    final /* synthetic */ ContactLocaleUtils f18458a;

    public ContactLocaleUtils$ChineseContactUtils(ContactLocaleUtils contactLocaleUtils) {
        this.f18458a = contactLocaleUtils;
        super(contactLocaleUtils);
    }

    public final String m27078a(String str) {
        ArrayList a = ((HanziToPinyin) this.f18458a.a.get()).m27085a(str);
        if (a == null || a.size() <= 0) {
            return super.a(str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Token token = (Token) a.get(i);
            if (2 == token.f18460a) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(token.f18462c);
                stringBuilder.append(' ');
                stringBuilder.append(token.f18461b);
            } else {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(token.f18461b);
            }
        }
        return stringBuilder.toString();
    }

    public final Iterator<String> m27079b(String str) {
        HashSet hashSet = new HashSet();
        ArrayList a = ((HanziToPinyin) this.f18458a.a.get()).m27085a(str);
        int size = a.size();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            Token token = (Token) a.get(i);
            if (2 == token.f18460a) {
                stringBuilder.insert(0, token.f18462c);
                stringBuilder2.insert(0, token.f18462c.charAt(0));
            } else if (1 == token.f18460a) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.insert(0, ' ');
                }
                if (stringBuilder3.length() > 0) {
                    stringBuilder3.insert(0, ' ');
                }
                stringBuilder.insert(0, token.f18461b);
                stringBuilder2.insert(0, token.f18461b.charAt(0));
            }
            stringBuilder3.insert(0, token.f18461b);
            hashSet.add(stringBuilder3.toString());
            hashSet.add(stringBuilder.toString());
            hashSet.add(stringBuilder2.toString());
        }
        return hashSet.iterator();
    }
}
