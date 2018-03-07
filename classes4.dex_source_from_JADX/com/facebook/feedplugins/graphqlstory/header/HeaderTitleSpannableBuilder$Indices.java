package com.facebook.feedplugins.graphqlstory.header;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/* compiled from: dialtone_whitelist */
class HeaderTitleSpannableBuilder$Indices {
    private List<Index> f13847a;

    /* compiled from: dialtone_whitelist */
    public class Index implements Comparable<Index> {
        final /* synthetic */ HeaderTitleSpannableBuilder$Indices f13848a;
        public int f13849b;
        public int f13850c;
        public int f13851d;
        public int f13852e;

        public int compareTo(Object obj) {
            return Integer.valueOf(this.f13849b).compareTo(Integer.valueOf(((Index) obj).f13849b));
        }

        Index(HeaderTitleSpannableBuilder$Indices headerTitleSpannableBuilder$Indices, int i, String str, String str2) {
            this.f13848a = headerTitleSpannableBuilder$Indices;
            this.f13849b = i;
            this.f13851d = str.length();
            this.f13852e = str2 != null ? str2.length() : 0;
        }

        public final int m14639a() {
            return this.f13849b;
        }

        public final int m14640c() {
            return this.f13852e;
        }

        public final int m14641d() {
            return this.f13850c;
        }
    }

    public final List<Index> m14638a() {
        return this.f13847a;
    }

    public HeaderTitleSpannableBuilder$Indices(String str, String... strArr) {
        int i = 0;
        this.f13847a = Lists.b(strArr.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%%%d$s", Integer.valueOf(i2 + 1));
            int indexOf = str.indexOf(formatStrLocaleSafe);
            while (indexOf >= 0) {
                Index index = new Index(this, indexOf, formatStrLocaleSafe, strArr[i2]);
                index.f13850c = i2;
                this.f13847a.add(index);
                indexOf = str.indexOf(formatStrLocaleSafe, indexOf + 1);
            }
        }
        Collections.sort(this.f13847a);
        for (Index index2 : this.f13847a) {
            index2.f13849b += i;
            i += index2.f13852e - index2.f13851d;
        }
    }
}
