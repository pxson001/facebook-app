package com.facebook.messaging.composershortcuts;

import com.facebook.debug.log.BLog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: messages_type_index */
public class MessengerComposerShortcutsOrderingHelper {
    private static final Class<?> f10096a = MessengerComposerShortcutsOrderingHelper.class;

    /* compiled from: messages_type_index */
    class OrderingMapComparator implements Comparator<ComposerShortcutItem> {
        ImmutableMap<String, Integer> f10094a;
        final /* synthetic */ MessengerComposerShortcutsOrderingHelper f10095b;

        public int compare(Object obj, Object obj2) {
            return ((Integer) this.f10094a.get(((ComposerShortcutItem) obj).f9973b)).compareTo((Integer) this.f10094a.get(((ComposerShortcutItem) obj2).f9973b));
        }

        OrderingMapComparator(MessengerComposerShortcutsOrderingHelper messengerComposerShortcutsOrderingHelper, ImmutableMap<String, Integer> immutableMap) {
            this.f10095b = messengerComposerShortcutsOrderingHelper;
            this.f10094a = immutableMap;
        }
    }

    public final ImmutableList<ComposerShortcutItem> m10594a(ImmutableList<ComposerShortcutItem> immutableList, ImmutableMap<String, Integer> immutableMap, ImmutableMap<String, Integer> immutableMap2) {
        if (immutableMap == null) {
            return immutableList;
        }
        ArrayList arrayList = new ArrayList();
        Object arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) immutableList.get(i);
            if (immutableMap2.containsKey(composerShortcutItem.f9973b)) {
                arrayList2.add(composerShortcutItem);
            } else {
                if (immutableMap.containsKey(composerShortcutItem.f9973b) && m10593a(composerShortcutItem)) {
                    arrayList.add(composerShortcutItem);
                } else if (composerShortcutItem.f9981j) {
                    arrayList3.add(composerShortcutItem);
                } else if (composerShortcutItem.f9982k) {
                    arrayList4.add(composerShortcutItem);
                } else {
                    arrayList5.add(composerShortcutItem);
                }
            }
        }
        Collections.sort(arrayList, new OrderingMapComparator(this, immutableMap));
        Collections.sort(arrayList2, new OrderingMapComparator(this, immutableMap2));
        int i2 = 0;
        Object obj = "";
        String str = "";
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            String str2;
            Object obj2;
            composerShortcutItem = (ComposerShortcutItem) arrayList.get(i3);
            if (composerShortcutItem.f9981j) {
                str2 = composerShortcutItem.f9973b;
                obj2 = obj;
                size = i2;
            } else {
                i2++;
                if (i2 == 2) {
                    size = i2;
                    String str3 = composerShortcutItem.f9973b;
                    str2 = str;
                    str = str3;
                } else {
                    str2 = str;
                    obj2 = obj;
                    size = i2;
                }
            }
            i3++;
            i2 = size;
            obj = obj2;
            str = str2;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = arrayList.iterator();
        Iterator it2 = arrayList2.iterator();
        Iterator it3 = arrayList3.iterator();
        Iterator it4 = arrayList4.iterator();
        Iterator it5 = arrayList5.iterator();
        ComposerShortcutItem a = m10592a(it2);
        Object obj3 = null;
        Object obj4 = null;
        i2 = 0;
        while (i2 < immutableList.size()) {
            if (a != null) {
                if (i2 == ((Integer) immutableMap2.get(a.f9973b)).intValue()) {
                    ComposerShortcutItem composerShortcutItem2 = a;
                    a = m10592a(it2);
                    Object obj5 = composerShortcutItem2;
                    builder.c(obj5);
                    i2++;
                }
            }
            if (obj4 != null && it4.hasNext()) {
                composerShortcutItem = (ComposerShortcutItem) it4.next();
                builder.c(obj5);
                i2++;
            } else if (obj3 == null || !it3.hasNext()) {
                if (it.hasNext()) {
                    composerShortcutItem = (ComposerShortcutItem) it.next();
                    if (composerShortcutItem.f9973b.equals(obj)) {
                        obj4 = 1;
                    } else if (composerShortcutItem.f9973b.equals(str)) {
                        obj3 = 1;
                    }
                } else if (it3.hasNext()) {
                    composerShortcutItem = (ComposerShortcutItem) it3.next();
                } else if (it4.hasNext()) {
                    composerShortcutItem = (ComposerShortcutItem) it4.next();
                } else if (a != null) {
                    composerShortcutItem2 = a;
                    a = m10592a(it2);
                    composerShortcutItem = composerShortcutItem2;
                } else if (it5.hasNext()) {
                    composerShortcutItem = (ComposerShortcutItem) it5.next();
                } else {
                    BLog.b(f10096a, "Composer shortcut spots > number of items!  This shouldn't happen!");
                    return builder.b();
                }
                builder.c(obj5);
                i2++;
            } else {
                composerShortcutItem = (ComposerShortcutItem) it3.next();
                builder.c(obj5);
                i2++;
            }
        }
        return builder.b();
    }

    private static ComposerShortcutItem m10592a(Iterator<ComposerShortcutItem> it) {
        return it.hasNext() ? (ComposerShortcutItem) it.next() : null;
    }

    private static boolean m10593a(ComposerShortcutItem composerShortcutItem) {
        return composerShortcutItem.f9982k || composerShortcutItem.f9981j;
    }
}
