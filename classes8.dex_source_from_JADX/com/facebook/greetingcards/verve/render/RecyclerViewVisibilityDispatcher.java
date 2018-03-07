package com.facebook.greetingcards.verve.render;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.greetingcards.verve.model.VMView;

/* compiled from: view_story_tap */
public class RecyclerViewVisibilityDispatcher {
    public final RecyclerView f387a;
    public VerveActionListener f388b;
    private final Rect f389c = new Rect();
    public SparseArray<View> f390d = new SparseArray();
    public SparseArray<View> f391e = new SparseArray();
    public SparseArray<View> f392f = new SparseArray();

    /* compiled from: view_story_tap */
    class C00411 extends OnScrollListener {
        final /* synthetic */ RecyclerViewVisibilityDispatcher f385a;

        C00411(RecyclerViewVisibilityDispatcher recyclerViewVisibilityDispatcher) {
            this.f385a = recyclerViewVisibilityDispatcher;
        }

        public final void m358a(RecyclerView recyclerView, int i, int i2) {
            RecyclerViewVisibilityDispatcher.m360a(this.f385a);
        }
    }

    /* compiled from: view_story_tap */
    public class C00422 implements OnGlobalLayoutListener {
        final /* synthetic */ RecyclerViewVisibilityDispatcher f386a;

        public C00422(RecyclerViewVisibilityDispatcher recyclerViewVisibilityDispatcher) {
            this.f386a = recyclerViewVisibilityDispatcher;
        }

        public void onGlobalLayout() {
            if (VERSION.SDK_INT < 16) {
                this.f386a.f387a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.f386a.f387a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            RecyclerViewVisibilityDispatcher.m360a(this.f386a);
        }
    }

    public RecyclerViewVisibilityDispatcher(RecyclerView recyclerView) {
        this.f387a = recyclerView;
        this.f387a.setOnScrollListener(new C00411(this));
    }

    public static void m360a(RecyclerViewVisibilityDispatcher recyclerViewVisibilityDispatcher) {
        int i;
        int i2 = 0;
        recyclerViewVisibilityDispatcher.f390d.clear();
        for (int i3 = 0; i3 < recyclerViewVisibilityDispatcher.f387a.getChildCount(); i3++) {
            ViewGroup viewGroup = (ViewGroup) recyclerViewVisibilityDispatcher.f387a.getChildAt(i3);
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getGlobalVisibleRect(recyclerViewVisibilityDispatcher.f389c) && childAt.getVisibility() == 0) {
                    recyclerViewVisibilityDispatcher.f390d.put(((VMView) childAt.getTag(2131558772)).f340a, childAt);
                }
            }
        }
        recyclerViewVisibilityDispatcher.f392f.clear();
        for (i = 0; i < recyclerViewVisibilityDispatcher.f390d.size(); i++) {
            int keyAt = recyclerViewVisibilityDispatcher.f390d.keyAt(i);
            if (recyclerViewVisibilityDispatcher.f391e.indexOfKey(keyAt) < 0) {
                recyclerViewVisibilityDispatcher.f392f.put(keyAt, recyclerViewVisibilityDispatcher.f390d.get(keyAt));
            }
        }
        if (recyclerViewVisibilityDispatcher.f392f.size() > 0) {
            recyclerViewVisibilityDispatcher.m359a(recyclerViewVisibilityDispatcher.f392f, "visible");
        }
        recyclerViewVisibilityDispatcher.f392f.clear();
        while (i2 < recyclerViewVisibilityDispatcher.f391e.size()) {
            i = recyclerViewVisibilityDispatcher.f391e.keyAt(i2);
            if (recyclerViewVisibilityDispatcher.f390d.indexOfKey(i) < 0) {
                recyclerViewVisibilityDispatcher.f392f.put(i, recyclerViewVisibilityDispatcher.f391e.get(i));
            }
            i2++;
        }
        if (recyclerViewVisibilityDispatcher.f392f.size() > 0) {
            recyclerViewVisibilityDispatcher.m359a(recyclerViewVisibilityDispatcher.f392f, "hidden");
        }
        SparseArray sparseArray = recyclerViewVisibilityDispatcher.f391e;
        recyclerViewVisibilityDispatcher.f391e = recyclerViewVisibilityDispatcher.f390d;
        recyclerViewVisibilityDispatcher.f390d = sparseArray;
    }

    private void m359a(SparseArray<View> sparseArray, String str) {
        for (int i = 0; i < sparseArray.size(); i++) {
            View view = (View) sparseArray.get(sparseArray.keyAt(i));
            VMView vMView = (VMView) view.getTag(2131558772);
            if (vMView.actionsMap != null && vMView.actionsMap.containsKey(str)) {
                this.f388b.a((VMAction) vMView.actionsMap.get(str), view);
            }
        }
    }
}
