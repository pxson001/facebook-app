package com.facebook.structuredsurvey;

import com.facebook.structuredsurvey.api.ParcelableStringArrayList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: draft_dialog_save */
public class StructuredSurveyState {
    public HashMap<String, ImmutableList<Answer>> f17113a = Maps.c();
    public List<ImmutableList<String>> f17114b = new ArrayList();
    public List<Integer> f17115c = new ArrayList();

    /* compiled from: draft_dialog_save */
    public class Answer {
        public int f17110a;
        public String f17111b;
        public String f17112c;

        public Answer(int i, String str, String str2) {
            this.f17110a = i;
            this.f17111b = str;
            this.f17112c = str2;
        }

        public Answer(String str) {
            this.f17111b = str;
            this.f17112c = str;
        }
    }

    public final ImmutableMap<String, ParcelableStringArrayList> m24807a() {
        Map c = Maps.c();
        for (Entry entry : this.f17113a.entrySet()) {
            String str = (String) entry.getKey();
            ImmutableList immutableList = (ImmutableList) entry.getValue();
            ParcelableStringArrayList parcelableStringArrayList = new ParcelableStringArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                parcelableStringArrayList.add(((Answer) immutableList.get(i)).f17111b);
            }
            c.put(str, parcelableStringArrayList);
        }
        return ImmutableMap.copyOf(c);
    }

    public final ImmutableList<Integer> m24808c() {
        return ImmutableList.copyOf(this.f17115c);
    }
}
