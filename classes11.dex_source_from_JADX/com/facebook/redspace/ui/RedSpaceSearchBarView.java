package com.facebook.redspace.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.executors.ForUiThread;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObservable.7;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.executor.RequestSubscription;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.rx.RxTextViewBinder.TextViewTextChangeEventOnSubscribe;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;
import rx.Observable;

/* compiled from: Partial Content */
public class RedSpaceSearchBarView extends CustomLinearLayout implements TextWatcher {
    private static final SpringConfig f12363b = SpringConfig.b(10.0d, 12.0d);
    @Inject
    volatile Provider<SpringSystem> f12364a = UltralightRuntime.a;
    @Inject
    @Lazy
    @ForUiThread
    private com.facebook.inject.Lazy<ExecutorService> f12365c = UltralightRuntime.b;
    @Inject
    private RedSpaceStrings f12366d;
    private View f12367e;
    public SearchEditText f12368f;
    private View f12369g;
    public OnSearchTextChangedListener f12370h;
    private RequestSubscription f12371i;
    private Spring f12372j;
    public View f12373k;

    /* compiled from: Partial Content */
    public interface OnSearchTextChangedListener {
        void mo346a(CharSequence charSequence);
    }

    /* compiled from: Partial Content */
    class C14591 implements OnClickListener {
        final /* synthetic */ RedSpaceSearchBarView f12358a;

        C14591(RedSpaceSearchBarView redSpaceSearchBarView) {
            this.f12358a = redSpaceSearchBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -487454436);
            this.f12358a.f12368f.a();
            Logger.a(2, EntryType.UI_INPUT_END, 1599430583, a);
        }
    }

    /* compiled from: Partial Content */
    class C14602 implements RequestObserver<String> {
        final /* synthetic */ RedSpaceSearchBarView f12359a;

        C14602(RedSpaceSearchBarView redSpaceSearchBarView) {
            this.f12359a = redSpaceSearchBarView;
        }

        public final void m12781a(Object obj) {
            String str = (String) obj;
            if (this.f12359a.f12370h != null) {
                this.f12359a.f12370h.mo346a(str);
            }
        }

        public final void m12780a() {
        }

        public final void m12782a(Throwable th) {
        }
    }

    private static <T extends View> void m12787a(Class<T> cls, T t) {
        m12788a((Object) t, t.getContext());
    }

    private static void m12788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceSearchBarView) obj).m12789a(IdBasedProvider.a(fbInjector, 3433), IdBasedSingletonScopeProvider.b(fbInjector, 3863), RedSpaceStrings.a(fbInjector));
    }

    public RedSpaceSearchBarView(Context context) {
        super(context);
        m12791c();
    }

    public RedSpaceSearchBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m12791c();
    }

    private void m12789a(Provider<SpringSystem> provider, com.facebook.inject.Lazy<ExecutorService> lazy, RedSpaceStrings redSpaceStrings) {
        this.f12364a = provider;
        this.f12365c = lazy;
        this.f12366d = redSpaceStrings;
    }

    public RedSpaceSearchBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12791c();
    }

    private void m12791c() {
        m12787a(RedSpaceSearchBarView.class, (View) this);
        this.f12372j = ((SpringSystem) this.f12364a.get()).a();
        this.f12372j.a(f12363b);
        setContentView(2130906791);
        this.f12367e = a(2131566889);
        this.f12368f = (SearchEditText) a(2131566887);
        this.f12369g = a(2131566888);
        this.f12373k = a(2131566886);
        this.f12367e.setOnClickListener(new C14591(this));
        this.f12368f.addTextChangedListener(this);
        this.f12368f.setHint(this.f12366d.g());
    }

    public final void m12792a() {
        this.f12368f.b();
    }

    public final void m12793b() {
        this.f12368f.c();
    }

    public void setShowProgress(boolean z) {
        this.f12369g.setVisibility(z ? 0 : 8);
    }

    public CharSequence getText() {
        return this.f12368f.getText();
    }

    public SearchEditText getSearchEditText() {
        return this.f12368f;
    }

    public View getSearchGlyph() {
        return this.f12373k;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        m12786a(this.f12367e, TextUtils.isEmpty(editable) ? 0.0f : 1.0f);
    }

    public void setOnSearchTextChangedListener(OnSearchTextChangedListener onSearchTextChangedListener) {
        this.f12370h = onSearchTextChangedListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -234856836);
        super.onAttachedToWindow();
        SearchEditText searchEditText = this.f12368f;
        Preconditions.checkNotNull(searchEditText, "view == null");
        RequestObservable requestObservable = new RequestObservable(Observable.a(new 7(new TextViewTextChangeEventOnSubscribe(searchEditText))));
        this.f12371i = new RequestObservable(requestObservable.a.a((long) 300, TimeUnit.MILLISECONDS)).a((Executor) this.f12365c.get()).a(new C14602(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 262377407, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1128762904);
        this.f12371i.a();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1637403736, a);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f12368f.getLayoutParams().height = getResources().getDimensionPixelSize(2131430586);
        this.f12368f.setLayoutParams(this.f12368f.getLayoutParams());
    }

    private void m12786a(final View view, final float f) {
        this.f12372j.m();
        this.f12372j.a(new SimpleSpringListener(this) {
            final /* synthetic */ RedSpaceSearchBarView f12362c;

            public final void m12784b(Spring spring) {
                float d = (float) spring.d();
                if (f == 0.0f && d == 0.0f) {
                    view.setVisibility(8);
                }
            }

            public final void m12783a(Spring spring) {
                float d = (float) spring.d();
                view.setAlpha(d);
                view.setScaleX(d);
                view.setScaleY(d);
            }
        });
        this.f12372j.b((double) f);
        if (f > 0.0f) {
            view.setVisibility(0);
        }
    }
}
