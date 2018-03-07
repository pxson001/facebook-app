package com.facebook.places.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.ipc.model.PageTopic;
import com.facebook.widget.listview.SectionedListAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: framePacks */
public class SelectPageTopicAdapter extends SectionedListAdapter {
    private static Map<Long, PageTopic> f14697i;
    private static Map<PageTopic, List<PageTopic>> f14698j;
    private final Context f14699c;
    private final int f14700d;
    private final long f14701e;
    private final PageTopic f14702f;
    private final boolean f14703g;
    private List<PageTopic> f14704h;

    /* compiled from: framePacks */
    class C09401 implements Comparator<PageTopic> {
        final /* synthetic */ SelectPageTopicAdapter f14695a;

        C09401(SelectPageTopicAdapter selectPageTopicAdapter) {
            this.f14695a = selectPageTopicAdapter;
        }

        public int compare(Object obj, Object obj2) {
            return Integer.valueOf(((PageTopic) obj2).pageCount).compareTo(Integer.valueOf(((PageTopic) obj).pageCount));
        }
    }

    /* compiled from: framePacks */
    class C09412 implements Comparator<PageTopic> {
        final /* synthetic */ SelectPageTopicAdapter f14696a;

        C09412(SelectPageTopicAdapter selectPageTopicAdapter) {
            this.f14696a = selectPageTopicAdapter;
        }

        public int compare(Object obj, Object obj2) {
            return ((PageTopic) obj).displayName.compareTo(((PageTopic) obj2).displayName);
        }
    }

    public SelectPageTopicAdapter(Context context, int i, long j) {
        this.f14699c = context;
        this.f14700d = i;
        this.f14701e = j;
        this.f14703g = this.f14700d > 0;
        this.f14704h = new ArrayList();
        if (this.f14700d == 0) {
            m22260a(new ArrayList());
        } else {
            m22255d();
        }
        this.f14702f = (PageTopic) f14697i.get(Long.valueOf(this.f14701e));
    }

    public final int mo1063c() {
        return this.f14703g ? 2 : 1;
    }

    public final int mo1064c(int i) {
        if (!this.f14703g) {
            return this.f14704h.size();
        }
        if (i == 0) {
            return 1;
        }
        return this.f14704h.size();
    }

    public final Object mo1060b(int i) {
        return null;
    }

    public final Object mo1059a(int i, int i2) {
        if (!this.f14703g || (this.f14703g && i == 1)) {
            return this.f14704h.get(i2);
        }
        return this.f14702f;
    }

    public final View mo1058a(int i, View view, ViewGroup viewGroup) {
        if (!this.f14703g) {
            return new View(this.f14699c);
        }
        View inflate;
        if (view == null) {
            inflate = LayoutInflater.from(this.f14699c).inflate(2130906088, null);
        } else {
            inflate = view;
        }
        switch (i) {
            case 0:
                ((TextView) inflate.findViewById(2131558966)).setText(this.f14699c.getString(2131235139));
                break;
            default:
                ((TextView) inflate.findViewById(2131558966)).setText(this.f14699c.getString(2131235140));
                break;
        }
        return inflate;
    }

    public final View mo1057a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f14699c).inflate(2130906087, null);
        }
        if (this.f14703g && i == 0) {
            ((TextView) view.findViewById(2131565655)).setText(this.f14702f.displayName);
            view.findViewById(2131565656).setVisibility(8);
            view.findViewById(2131565657).setVisibility(8);
        } else {
            ((TextView) view.findViewById(2131565655)).setText(((PageTopic) this.f14704h.get(i2)).displayName);
            if (m22254b(((PageTopic) this.f14704h.get(i2)).id) == null) {
                view.findViewById(2131565656).setVisibility(8);
                view.findViewById(2131565657).setVisibility(8);
            } else {
                view.findViewById(2131565657).setVisibility(0);
                if (this.f14700d == 0) {
                    view.findViewById(2131565656).setVisibility(0);
                    ((TextView) view.findViewById(2131565656)).setText(m22254b(((PageTopic) this.f14704h.get(i2)).id));
                } else {
                    view.findViewById(2131565656).setVisibility(8);
                }
            }
        }
        return view;
    }

    public final boolean mo1062b(int i, int i2) {
        return true;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public final int mo1056a(int i) {
        return 0;
    }

    public final int mo1065c(int i, int i2) {
        return 1;
    }

    public final boolean mo1061b() {
        return f14697i.isEmpty();
    }

    public static List<PageTopic> m22252a(long j) {
        List list = (List) f14698j.get((PageTopic) f14697i.get(Long.valueOf(j)));
        if (list != null) {
            return new ArrayList(list);
        }
        return new ArrayList();
    }

    private String m22254b(long j) {
        List a = m22252a(j);
        if (a == null || a.size() <= 0) {
            return null;
        }
        Collections.sort(a, new C09401(this));
        List arrayList = new ArrayList();
        int min = Math.min(3, a.size());
        for (int i = 0; i < min; i++) {
            arrayList.add(((PageTopic) a.get(i)).displayName);
        }
        return StringUtil.b(", ", new Object[]{arrayList});
    }

    public final void m22260a(List<PageTopic> list) {
        f14697i = new HashMap();
        f14698j = new HashMap();
        for (PageTopic pageTopic : list) {
            f14697i.put(Long.valueOf(pageTopic.id), pageTopic);
        }
        for (PageTopic pageTopic2 : list) {
            if (pageTopic2.parentIds == null || pageTopic2.parentIds.size() == 0) {
                m22253a(null, pageTopic2);
            } else {
                for (Long l : pageTopic2.parentIds) {
                    m22253a((PageTopic) f14697i.get(l), pageTopic2);
                }
            }
        }
        for (List sort : f14698j.values()) {
            Collections.sort(sort, new C09412(this));
        }
        m22255d();
    }

    private void m22255d() {
        this.f14704h = m22252a(this.f14701e);
    }

    private static void m22253a(PageTopic pageTopic, PageTopic pageTopic2) {
        List list = (List) f14698j.get(pageTopic);
        if (list == null) {
            list = new ArrayList();
            f14698j.put(pageTopic, list);
        }
        list.add(pageTopic2);
    }
}
