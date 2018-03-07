package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;

/* compiled from: o2i_rtt */
public abstract class PageStyle {
    public static final PaddingStyle f13886a;

    /* compiled from: o2i_rtt */
    public class FullWidthPageStyle extends PageStyle {
        public final void mo573a(View view) {
        }

        public final void mo574a(View view, int i, int i2) {
        }

        public final void mo571a(ViewPager viewPager) {
            viewPager.setPageMargin(SizeUtil.a(viewPager.getContext(), 8.0f));
        }

        public final void mo576b(View view) {
            throw new UnsupportedOperationException("full width is not supported by recycler view yet");
        }

        public final void mo572a(RecyclerView recyclerView) {
            throw new UnsupportedOperationException("full width is not supported by recycler view yet");
        }

        public final float mo570a(int i, int i2) {
            return 1.0f;
        }

        public final int mo575b() {
            throw new UnsupportedOperationException("full width is not supported by recycler view yet");
        }
    }

    /* compiled from: o2i_rtt */
    public class AbsoluteWidthPageStyle extends PageStyle {
        public final float f13892b;
        public final int f13893c;
        private final boolean f13894d;
        private int f13895e = -1;
        private int f13896f = -1;

        public AbsoluteWidthPageStyle(float f, int i, boolean z) {
            this.f13893c = i;
            this.f13892b = f;
            this.f13894d = z;
        }

        public final void mo573a(View view) {
            m14687b(view.getContext());
            if (this.f13894d) {
                PageStyle.m14678a(view, this.f13895e);
            } else if (view instanceof HasPageStyle) {
                ((HasPageStyle) view).setWidth(this.f13895e);
            }
        }

        public final void mo574a(View view, int i, int i2) {
            int i3 = 1;
            if (view instanceof FrameLayout) {
                int i4;
                if (view.getLayoutParams() != null) {
                    view.setLayoutParams(new LayoutParams());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) view).getChildAt(0).getLayoutParams();
                if (i == 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (i != i2 - 1) {
                    i3 = 0;
                }
                int i5 = i4 != 0 ? 3 : i3 != 0 ? 5 : 1;
                layoutParams.gravity = i5;
                return;
            }
            throw new UnsupportedOperationException("This style requires an extra wrapping FrameLayout to work");
        }

        public final void mo571a(ViewPager viewPager) {
            Context context = viewPager.getContext();
            int a = SizeUtil.a(context, 8.0f);
            this.f13895e = SizeUtil.a(context, this.f13892b);
            viewPager.setPageMargin((SizeUtil.a(context, this.f13892b) - this.f13893c) + a);
        }

        public final void mo576b(View view) {
            if (view instanceof FrameLayout) {
                m14687b(view.getContext());
                m14686a(view.getContext());
                View childAt = ((FrameLayout) view).getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int i = this.f13895e - (this.f13896f * 2);
                if (layoutParams.leftMargin != this.f13896f || layoutParams.rightMargin != this.f13896f || layoutParams.width != i) {
                    layoutParams.setMargins(this.f13896f, 0, this.f13896f, 0);
                    layoutParams.width = i;
                    childAt.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("This style requires an extra wrapping FrameLayout to work");
        }

        public final void mo572a(RecyclerView recyclerView) {
            m14687b(recyclerView.getContext());
            m14686a(recyclerView.getContext());
        }

        public final float mo570a(int i, int i2) {
            if (i == 0 || i == i2 - 1) {
                return ((float) (((this.f13893c - this.f13895e) / 2) + this.f13895e)) / ((float) this.f13893c);
            }
            return 1.0f;
        }

        private void m14686a(Context context) {
            if (this.f13896f == -1) {
                this.f13896f = SizeUtil.a(context, 8.0f) / 2;
            }
        }

        private void m14687b(Context context) {
            if (this.f13895e == -1) {
                this.f13895e = SizeUtil.a(context, this.f13892b);
            }
        }

        public final int mo575b() {
            if (this.f13895e != -1) {
                return this.f13895e;
            }
            throw new IllegalStateException("getPageWidthPixelsForRecyclerView() must be called after applyToRecyclerView()");
        }
    }

    public abstract float mo570a(int i, int i2);

    public abstract void mo571a(ViewPager viewPager);

    public abstract void mo572a(RecyclerView recyclerView);

    public abstract void mo573a(View view);

    public abstract void mo574a(View view, int i, int i2);

    public abstract int mo575b();

    public abstract void mo576b(View view);

    static {
        Builder a = Builder.a();
        a.d = -4.0f;
        f13886a = a.i();
    }

    public static PageStyle m14677a(int i, boolean z, boolean z2) {
        return new FullBleedPageStyle((float) i, z, z2);
    }

    public static PageStyle m14676a(float f, int i, boolean z) {
        return new AbsoluteWidthPageStyle(f, i, z);
    }

    public static PageStyle m14675a(float f, int i) {
        return new AbsoluteWidthPageStyle(f, i, false);
    }

    protected static void m14678a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(i, -2));
        } else if (layoutParams.width != i) {
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }
}
