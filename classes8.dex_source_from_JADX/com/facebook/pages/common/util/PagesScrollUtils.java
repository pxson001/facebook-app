package com.facebook.pages.common.util;

import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

/* compiled from: coreComponentTextFields */
public class PagesScrollUtils {

    /* compiled from: coreComponentTextFields */
    final class C18311 implements Runnable {
        final /* synthetic */ ViewGroup f16893a;
        final /* synthetic */ int f16894b;
        final /* synthetic */ int f16895c;

        C18311(ViewGroup viewGroup, int i, int i2) {
            this.f16893a = viewGroup;
            this.f16894b = i;
            this.f16895c = i2;
        }

        public final void run() {
            if (this.f16893a instanceof ListView) {
                ((ListView) this.f16893a).setSelectionFromTop(0, this.f16894b);
            } else if (this.f16893a instanceof ScrollView) {
                ((ScrollView) this.f16893a).scrollTo(0, this.f16894b * -1);
            } else if (this.f16893a instanceof RecyclerView) {
                LayoutManager layoutManager = ((RecyclerView) this.f16893a).getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager).d(0, this.f16894b);
                }
            }
            if (!PagesScrollUtils.m20195c(this.f16893a, this.f16894b)) {
                PagesScrollUtils.m20194b(this.f16893a, this.f16894b, RetryDelay.DELAY, this.f16895c + 1);
            }
        }
    }

    /* compiled from: coreComponentTextFields */
    enum RetryDelay {
        IMMEDIATE,
        DELAY
    }

    public static void m20193a(ViewGroup viewGroup, int i) {
        m20194b(viewGroup, i, RetryDelay.IMMEDIATE, 0);
    }

    public static void m20194b(ViewGroup viewGroup, int i, RetryDelay retryDelay, int i2) {
        if (viewGroup != null && i2 <= 6) {
            Runnable c18311 = new C18311(viewGroup, i, i2);
            switch (retryDelay) {
                case DELAY:
                    viewGroup.postDelayed(c18311, 33);
                    return;
                default:
                    viewGroup.post(c18311);
                    return;
            }
        }
    }

    public static boolean m20195c(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof ListView) {
            if (((ListView) viewGroup).getFirstVisiblePosition() == 0 && ((ListView) viewGroup).getChildAt(0) != null && ((ListView) viewGroup).getChildAt(0).getTop() == i) {
                return true;
            }
            return false;
        } else if (viewGroup instanceof ScrollView) {
            if (((ScrollView) viewGroup).getScrollY() == (-i)) {
                return true;
            }
            return false;
        } else if (!(viewGroup instanceof RecyclerView)) {
            return false;
        } else {
            LayoutManager layoutManager = ((RecyclerView) viewGroup).getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return false;
            }
            boolean z;
            try {
                z = ((LinearLayoutManager) layoutManager).l() == 0;
            } catch (NullPointerException e) {
                z = false;
            }
            if (z && ((RecyclerView) viewGroup).getChildAt(0) != null && ((RecyclerView) viewGroup).getChildAt(0).getTop() == i) {
                return true;
            }
            return false;
        }
    }

    public static Pair<Boolean, Integer> m20192a(View view, ViewGroup viewGroup, int i, int[] iArr, int i2) {
        View view2;
        int i3;
        ViewGroup viewGroup2 = null;
        boolean z = false;
        if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            if (listView.getAdapter() == null || listView.getAdapter().isEmpty() || listView.getLastVisiblePosition() != listView.getAdapter().getCount() - 1) {
                view2 = null;
            } else {
                view2 = listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition());
            }
            viewGroup2 = viewGroup;
        } else if ((viewGroup instanceof ScrollView) && viewGroup.getChildCount() == 1 && (viewGroup.getChildAt(0) instanceof ViewGroup)) {
            viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            view2 = view;
        } else {
            view2 = null;
        }
        if (view2 != null && view2 == view) {
            view.getLocationOnScreen(iArr);
            if (iArr[1] <= i2) {
                i3 = i2 - iArr[1];
                if (i == 0 && viewGroup2.getChildCount() >= 2 && viewGroup2.getChildAt(1) != null) {
                    viewGroup2.getChildAt(1).getLocationOnScreen(iArr);
                    if (iArr[1] > 0) {
                        i3 += iArr[1];
                        z = true;
                        return new Pair(Boolean.valueOf(z), Integer.valueOf(i3));
                    }
                }
                z = true;
                return new Pair(Boolean.valueOf(z), Integer.valueOf(i3));
            }
        }
        i3 = 0;
        return new Pair(Boolean.valueOf(z), Integer.valueOf(i3));
    }
}
