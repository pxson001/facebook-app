package com.facebook.messaging.composer.triggers;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SimpleOnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.composer.triggers.OpenCloseAnimator.AnimatedView;
import com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_inbox_units */
public class ContentSearchResultsView extends CustomFrameLayout implements AnimatedView {
    @Inject
    ContentSearchLogger f9851a;
    @Inject
    ContentSearchResultsAdapter f9852b;
    private BetterRecyclerView f9853c;
    private EmptyListViewItem f9854d;
    public LinearLayoutManager f9855e;
    public OnSelectListener f9856f;
    public OnHighlightListener f9857g;
    public boolean f9858h;
    private int f9859i;
    public int f9860j;
    public Set<Integer> f9861k;
    public boolean f9862l;

    /* compiled from: messenger_inbox_units */
    public interface OnSelectListener {
        void mo398a(Sticker sticker, int i);

        void mo399a(MediaResource mediaResource, int i);
    }

    /* compiled from: messenger_inbox_units */
    public interface OnHighlightListener {
        void mo400a();

        void mo401a(MediaResource mediaResource);

        void mo402b(MediaResource mediaResource);
    }

    /* compiled from: messenger_inbox_units */
    public class C11421 {
        final /* synthetic */ ContentSearchResultsView f9844a;

        C11421(ContentSearchResultsView contentSearchResultsView) {
            this.f9844a = contentSearchResultsView;
        }

        public final void m10398a(Sticker sticker, int i) {
            if (this.f9844a.f9856f != null) {
                this.f9844a.f9856f.mo398a(sticker, i);
            }
        }

        public final void m10399a(MediaResource mediaResource, int i) {
            if (this.f9844a.f9856f != null) {
                this.f9844a.f9856f.mo399a(mediaResource, i);
            }
        }

        public final boolean m10400a(MediaResource mediaResource) {
            if (this.f9844a.f9857g == null) {
                return false;
            }
            this.f9844a.f9857g.mo401a(mediaResource);
            this.f9844a.f9862l = true;
            return true;
        }

        public final void m10397a(int i) {
            if (i <= this.f9844a.f9860j) {
                this.f9844a.f9861k.add(Integer.valueOf(i));
                if (this.f9844a.f9861k.size() == this.f9844a.f9860j + 1) {
                    this.f9844a.f9851a.f9933c.b(6815746, (short) 2);
                }
            }
        }
    }

    /* compiled from: messenger_inbox_units */
    class C11443 implements OnDrawListener {
        final /* synthetic */ ContentSearchResultsView f9848a;

        C11443(ContentSearchResultsView contentSearchResultsView) {
            this.f9848a = contentSearchResultsView;
        }

        public final boolean gD_() {
            this.f9848a.f9857g;
            return false;
        }
    }

    /* compiled from: messenger_inbox_units */
    class C11454 extends OnScrollListener {
        final /* synthetic */ ContentSearchResultsView f9849a;

        C11454(ContentSearchResultsView contentSearchResultsView) {
            this.f9849a = contentSearchResultsView;
        }

        public final void m10402a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (i > 0 || i2 > 0) {
                if (this.f9849a.m10413a(this.f9849a.f9855e.l())) {
                    this.f9849a.f9851a.m10485d();
                    this.f9849a.m10421e();
                }
                this.f9849a.f9858h = true;
            }
        }
    }

    /* compiled from: messenger_inbox_units */
    class C11465 extends SimpleOnItemTouchListener {
        final /* synthetic */ ContentSearchResultsView f9850a;

        C11465(ContentSearchResultsView contentSearchResultsView) {
            this.f9850a = contentSearchResultsView;
        }

        public final boolean m10403a(MotionEvent motionEvent) {
            return this.f9850a.f9862l && this.f9850a.f9857g != null;
        }

        public final void m10404b(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                this.f9850a.f9857g.mo400a();
                this.f9850a.f9862l = false;
                return;
            }
            ExternalMediaGraphQLResult a = this.f9850a.m10407a(x, y);
            if (a != null) {
                this.f9850a.f9857g.mo402b(a.f11612e);
            }
        }
    }

    private static <T extends View> void m10411a(Class<T> cls, T t) {
        m10412a((Object) t, t.getContext());
    }

    private static void m10412a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContentSearchResultsView) obj).m10410a(ContentSearchLogger.m10478a(fbInjector), new ContentSearchResultsAdapter(ContentSearchLogger.m10478a(fbInjector), FbDraweeControllerBuilder.b(fbInjector), LayoutInflaterMethodAutoProvider.b(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), StickerContentSearchExperimentAccessor.b(fbInjector), StickerUrls.b(fbInjector)));
    }

    public ContentSearchResultsView(Context context) {
        super(context);
        m10409a(context);
    }

    public ContentSearchResultsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10409a(context);
    }

    public ContentSearchResultsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10409a(context);
    }

    private void m10409a(Context context) {
        m10411a(ContentSearchResultsView.class, (View) this);
        setContentView(2130903792);
        this.f9853c = (BetterRecyclerView) c(2131560745);
        this.f9854d = (EmptyListViewItem) c(2131560591);
        this.f9855e = new LinearLayoutManager(context);
        this.f9855e.b(0);
        this.f9861k = new HashSet();
        m10421e();
        this.f9853c.setLayoutManager(this.f9855e);
        this.f9853c.setAdapter(this.f9852b);
        this.f9852b.f9840i = new C11421(this);
        setPadding(0, getResources().getDimensionPixelOffset(2131433762), 0, 0);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(2131433760);
        final int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433761);
        this.f9853c.a(new ItemDecoration(this) {
            final /* synthetic */ ContentSearchResultsView f9847c;

            public final void m10401a(Rect rect, View view, RecyclerView recyclerView, State state) {
                if (RecyclerView.d(view) != 0) {
                    rect.set(dimensionPixelSize, 0, 0, 0);
                } else {
                    rect.set(dimensionPixelSize2, 0, 0, 0);
                }
            }
        });
        this.f9853c.a(new C11443(this));
        this.f9853c.setOnScrollListener(new C11454(this));
        this.f9853c.a(new C11465(this));
        CharSequence string = getResources().getString(2131241119);
        this.f9854d.setMessage(string);
        this.f9854d.setContentDescription(string);
    }

    private void m10410a(ContentSearchLogger contentSearchLogger, ContentSearchResultsAdapter contentSearchResultsAdapter) {
        this.f9851a = contentSearchLogger;
        this.f9852b = contentSearchResultsAdapter;
    }

    public static void m10417b(ContentSearchResultsView contentSearchResultsView) {
        int l = contentSearchResultsView.f9855e.l();
        if (l != -1 && !contentSearchResultsView.f9858h) {
            contentSearchResultsView.f9859i = l;
            contentSearchResultsView.f9860j = contentSearchResultsView.f9855e.n();
        }
    }

    private boolean m10413a(int i) {
        if (i > this.f9860j) {
            return true;
        }
        if (i > this.f9859i) {
            for (int i2 = this.f9859i; i2 < i; i2++) {
                if (!this.f9861k.contains(Integer.valueOf(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setResults(List<ExternalMediaGraphQLResult> list) {
        this.f9852b.m10396a(list);
        this.f9853c.a(0);
        m10421e();
        if (list.isEmpty()) {
            this.f9853c.setVisibility(8);
            this.f9854d.setVisibility(0);
            return;
        }
        this.f9853c.setVisibility(0);
        this.f9854d.setVisibility(8);
    }

    private void m10421e() {
        this.f9858h = false;
        this.f9861k.clear();
        this.f9860j = -1;
        this.f9859i = -1;
    }

    @Nullable
    private ExternalMediaGraphQLResult m10407a(float f, float f2) {
        if (f < 0.0f || f > ((float) this.f9853c.getWidth()) || f2 < 0.0f || f2 > ((float) this.f9853c.getHeight())) {
            return null;
        }
        int d = RecyclerView.d(this.f9853c.a(f, f2));
        if (d == -1) {
            return null;
        }
        ExternalMediaGraphQLResult externalMediaGraphQLResult;
        ContentSearchResultsAdapter contentSearchResultsAdapter = this.f9852b;
        if (d < 0 || d >= contentSearchResultsAdapter.aZ_()) {
            externalMediaGraphQLResult = null;
        } else {
            externalMediaGraphQLResult = (ExternalMediaGraphQLResult) contentSearchResultsAdapter.f9839h.get(d);
        }
        return externalMediaGraphQLResult;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.f9856f = onSelectListener;
    }

    public void setOnHighlightListener(OnHighlightListener onHighlightListener) {
        this.f9857g = onHighlightListener;
        this.f9862l = false;
    }

    public int getMaxVisiblePosition() {
        return this.f9855e.n();
    }

    public final void mo403a() {
        this.f9852b.m10396a(RegularImmutableList.a);
    }
}
