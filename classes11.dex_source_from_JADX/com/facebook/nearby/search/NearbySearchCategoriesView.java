package com.facebook.nearby.search;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.common.NearbyTopic;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.search.NearbySearchFragment.C00975;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: topStickerSelect */
public class NearbySearchCategoriesView extends CustomLinearLayout {
    public final ImmutableMap<Integer, SearchSuggestion> f735a;

    /* compiled from: topStickerSelect */
    public class C00921 implements OnClickListener {
        final /* synthetic */ C00975 f732a;
        final /* synthetic */ Entry f733b;
        final /* synthetic */ NearbySearchCategoriesView f734c;

        public C00921(NearbySearchCategoriesView nearbySearchCategoriesView, C00975 c00975, Entry entry) {
            this.f734c = nearbySearchCategoriesView;
            this.f732a = c00975;
            this.f733b = entry;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 886894509);
            this.f732a.m1029a((SearchSuggestion) this.f733b.getValue());
            Logger.a(2, EntryType.UI_INPUT_END, 2008141968, a);
        }
    }

    public NearbySearchCategoriesView(Context context) {
        this(context, null);
    }

    private NearbySearchCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905407);
        if (VERSION.SDK_INT <= 11) {
            findViewById(2131564161).setBackgroundResource(2130841543);
            findViewById(2131564164).setBackgroundResource(2130841542);
        }
        NearbySearchCategoryList a = NearbySearchCategoryList.m1028a(getContext());
        this.f735a = ImmutableMap.builder().b(Integer.valueOf(2131564157), m1027a(a.f737a)).b(Integer.valueOf(2131564159), m1027a(a.f739c)).b(Integer.valueOf(2131564158), m1027a(a.f738b)).b(Integer.valueOf(2131564160), m1027a(a.f740d)).b(Integer.valueOf(2131564162), m1027a(a.f742f)).b(Integer.valueOf(2131564163), m1027a(a.f743g)).b(Integer.valueOf(2131564164), m1027a(a.f744h)).b(Integer.valueOf(2131564161), m1027a(a.f741e)).b();
        Iterator it = this.f735a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ((Button) findViewById(((Integer) entry.getKey()).intValue())).setText(((SearchSuggestion) entry.getValue()).d.a);
        }
    }

    private static SearchSuggestion m1027a(NearbyTopic nearbyTopic) {
        return new SearchSuggestion(nearbyTopic.a, nearbyTopic.a, null, nearbyTopic);
    }
}
