package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.customthreads.CustomThreadTheme;
import com.facebook.messaging.customthreads.CustomThreadThemeManager;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadThemeOptionsAdapter;
import com.facebook.messaging.customthreads.ThreadThemeOptionsAdapter.OnThreadThemeClickListener;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass14;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: message_capping_composer_button_click */
public class ThreadThemePickerView extends CustomLinearLayout {
    @Inject
    public CustomThreadsTextHelper f7439a;
    @Inject
    public CustomThreadThemeManager f7440b;
    @Inject
    public ThreadThemeOptionsAdapter f7441c;
    private final ThemeListener f7442d = new ThemeListener(this);
    public TextView f7443e;
    public TextView f7444f;
    public String f7445g;
    private List<String> f7446h;
    private ThreadKey f7447i;
    @Nullable
    public AnonymousClass14 f7448j;
    @Nullable
    private DefaultThreadViewTheme f7449k;

    /* compiled from: message_capping_composer_button_click */
    public class C11171 implements OnThreadThemeClickListener {
        final /* synthetic */ ThreadThemePickerView f7436a;

        public C11171(ThreadThemePickerView threadThemePickerView) {
            this.f7436a = threadThemePickerView;
        }

        public final void m7076a(@Nullable CustomThreadTheme customThreadTheme) {
            if (this.f7436a.f7448j != null) {
                this.f7436a.f7448j.m7406a(customThreadTheme, this.f7436a.f7445g);
            }
        }
    }

    /* compiled from: message_capping_composer_button_click */
    public class SpacingDecoration extends ItemDecoration {
        private final int f7437a;

        public SpacingDecoration(int i) {
            this.f7437a = i;
        }

        public final void m7077a(Rect rect, View view, RecyclerView recyclerView, State state) {
            if (RecyclerView.e(view) > 0) {
                rect.left = this.f7437a;
            }
        }
    }

    /* compiled from: message_capping_composer_button_click */
    class ThemeListener implements Listener {
        final /* synthetic */ ThreadThemePickerView f7438a;

        public ThemeListener(ThreadThemePickerView threadThemePickerView) {
            this.f7438a = threadThemePickerView;
        }

        public final void m7078a() {
            ThreadThemePickerView.m7080b(this.f7438a);
        }
    }

    public static void m7079a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ThreadThemePickerView threadThemePickerView = (ThreadThemePickerView) obj;
        CustomThreadsTextHelper a = CustomThreadsTextHelper.m2126a(injectorLike);
        CustomThreadThemeManager a2 = CustomThreadThemeManager.a(injectorLike);
        ThreadThemeOptionsAdapter b = ThreadThemeOptionsAdapter.b(injectorLike);
        threadThemePickerView.f7439a = a;
        threadThemePickerView.f7440b = a2;
        threadThemePickerView.f7441c = b;
    }

    public ThreadThemePickerView(Context context) {
        super(context);
        Class cls = ThreadThemePickerView.class;
        m7079a(this, getContext());
        setContentView(2130903831);
        setOrientation(1);
        this.f7443e = (TextView) a(2131560867);
        this.f7444f = (TextView) a(2131560868);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131427840);
        this.f7441c.a(ImmutableList.copyOf(this.f7440b.n));
        this.f7441c.b = new C11171(this);
        RecyclerView recyclerView = (RecyclerView) a(2131560869);
        recyclerView.a(new SpacingDecoration(dimensionPixelOffset));
        recyclerView.setAdapter(this.f7441c);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
    }

    @Nullable
    public String getSource() {
        return this.f7445g;
    }

    public void setThreadViewTheme(DefaultThreadViewTheme defaultThreadViewTheme) {
        if (this.f7449k != null) {
            this.f7449k.b(this.f7442d);
        }
        this.f7449k = defaultThreadViewTheme;
        if (this.f7449k != null) {
            this.f7449k.a(this.f7442d);
            m7080b(this);
        }
    }

    public void setColorChoices(@Nullable List<String> list) {
        if (!Objects.equal(list, this.f7446h)) {
            this.f7446h = list != null ? ImmutableList.copyOf(list) : null;
            if (this.f7446h != null) {
                List arrayList = new ArrayList();
                arrayList.add(CustomThreadTheme.newBuilder().d(getResources().getColor(2131362327)).f());
                for (String parseLong : list) {
                    try {
                        int parseLong2 = (int) Long.parseLong(parseLong, 16);
                        arrayList.add(CustomThreadTheme.newBuilder().d(parseLong2).b(parseLong2).f());
                    } catch (NumberFormatException e) {
                    }
                }
                this.f7441c.a(arrayList);
                return;
            }
            this.f7441c.a(this.f7440b.a());
        }
    }

    public void setThreadKey(ThreadKey threadKey) {
        if (!Objects.equal(threadKey, this.f7447i)) {
            this.f7447i = threadKey;
            this.f7444f.setText(this.f7439a.m2128a(threadKey));
        }
    }

    public static void m7080b(ThreadThemePickerView threadThemePickerView) {
        if (threadThemePickerView.f7449k != null) {
            int d = threadThemePickerView.f7449k.d();
            threadThemePickerView.f7443e.setTextColor(d);
            threadThemePickerView.f7444f.setTextColor(d);
            threadThemePickerView.f7441c.a(threadThemePickerView.f7449k.h);
        }
    }
}
