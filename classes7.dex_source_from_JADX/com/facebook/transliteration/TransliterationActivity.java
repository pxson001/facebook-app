package com.facebook.transliteration;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;

/* compiled from: extra_feed_unit_cache_id */
public class TransliterationActivity extends FbFragmentActivity {
    public TransliterationFragment f15098p;

    /* compiled from: extra_feed_unit_cache_id */
    class C11251 implements OnClickListener {
        final /* synthetic */ TransliterationActivity f15096a;

        C11251(TransliterationActivity transliterationActivity) {
            this.f15096a = transliterationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 262449610);
            this.f15096a.f15098p.m19101b();
            Logger.a(2, EntryType.UI_INPUT_END, 1720680462, a);
        }
    }

    /* compiled from: extra_feed_unit_cache_id */
    class C11262 implements OnActionButtonClickListener {
        final /* synthetic */ TransliterationActivity f15097a;

        C11262(TransliterationActivity transliterationActivity) {
            this.f15097a = transliterationActivity;
        }

        public final void m19068a(View view) {
            this.f15097a.f15098p.m19101b();
        }
    }

    private static <T extends Context> void m19070a(Class<T> cls, T t) {
        FbInjector.get(t);
    }

    private static void m19071a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public final void m19072b(Bundle bundle) {
        super.b(bundle);
        Class cls = TransliterationActivity.class;
        FbInjector.get(this);
        setContentView(2130907537);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131568102);
        fb4aTitleBar.setTitle(getString(2131233194));
        fb4aTitleBar.a(new C11251(this));
        Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131233191);
        a = a;
        a.h = -2;
        a = a;
        a.q = true;
        fb4aTitleBar.setPrimaryButton(a.a());
        fb4aTitleBar.setActionButtonOnClickListener(new C11262(this));
        this.f15098p = (TransliterationFragment) kO_().a(2131568103);
        Bundle extras = getIntent().getExtras();
        this.f15098p.m19099a(extras.getString("entry_point"));
        this.f15098p.m19102b(extras.getString("composer_text"));
    }

    public void onBackPressed() {
        this.f15098p.m19101b();
    }
}
