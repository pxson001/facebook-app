package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: treehouse_group_mall */
class ItemTouchUIUtilImpl {

    /* compiled from: treehouse_group_mall */
    class Gingerbread implements ItemTouchUIUtil {
        Gingerbread() {
        }

        private static void m2220a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public final void mo461a(View view) {
            view.setVisibility(0);
        }

        public final void mo462b(View view) {
            view.setVisibility(4);
        }

        public final void mo460a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                m2220a(canvas, recyclerView, view, f, f2);
            }
        }

        public final void mo459a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i) {
            if (i == 2) {
                m2220a(canvas, recyclerView, view, f, f2);
            }
        }
    }

    /* compiled from: treehouse_group_mall */
    class Honeycomb implements ItemTouchUIUtil {
        Honeycomb() {
        }

        public void mo461a(View view) {
            ViewCompat.a(view, 0.0f);
            ViewCompat.b(view, 0.0f);
        }

        public final void mo462b(View view) {
        }

        public void mo460a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            ViewCompat.a(view, f);
            ViewCompat.b(view, f2);
        }

        public final void mo459a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i) {
        }
    }

    /* compiled from: treehouse_group_mall */
    class Lollipop extends Honeycomb {
        Lollipop() {
        }

        public final void mo460a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(2131558477) == null) {
                Float valueOf = Float.valueOf(ViewCompat.x(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                int i2 = 0;
                while (i2 < childCount) {
                    float x;
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        x = ViewCompat.x(childAt);
                        if (x > f3) {
                            i2++;
                            f3 = x;
                        }
                    }
                    x = f3;
                    i2++;
                    f3 = x;
                }
                ViewCompat.g(view, 1.0f + f3);
                view.setTag(2131558477, valueOf);
            }
            super.mo460a(canvas, recyclerView, view, f, f2, i, z);
        }

        public final void mo461a(View view) {
            Object tag = view.getTag(2131558477);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.g(view, ((Float) tag).floatValue());
            }
            view.setTag(2131558477, null);
            super.mo461a(view);
        }
    }

    ItemTouchUIUtilImpl() {
    }
}
