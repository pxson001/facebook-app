package com.facebook.customsettings;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import java.io.IOException;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: pinned_threads_display_order */
public class CustomSettingsActivity extends FbFragmentActivity implements OnClickListener {
    @Inject
    SecureContextHelper f6561p;
    @Inject
    UriIntentMapper f6562q;

    /* compiled from: pinned_threads_display_order */
    class C06761 implements OnClickListener {
        final /* synthetic */ CustomSettingsActivity f6560a;

        C06761(CustomSettingsActivity customSettingsActivity) {
            this.f6560a = customSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1861958161);
            this.f6560a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1667310069, a);
        }
    }

    private static <T extends Context> void m6893a(Class<T> cls, T t) {
        m6894a((Object) t, (Context) t);
    }

    public static void m6894a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CustomSettingsActivity) obj).m6892a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector));
    }

    protected final void m6896b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = CustomSettingsActivity.class;
        m6894a((Object) this, (Context) this);
        if (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("extra_layout")) {
            throw new IllegalArgumentException(String.format(Locale.US, "You must supply %s", new Object[]{"extra_layout"}));
        }
        setContentView(getIntent().getIntExtra("extra_layout", 0));
        m6895i();
    }

    public void onClick(View view) {
        Throwable e;
        RuntimeException runtimeException;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1743000025);
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f6561p.a(IntentParser.m6900a(str, (Context) this, this.f6562q), this);
            } catch (XmlPullParserException e2) {
                e = e2;
                runtimeException = new RuntimeException(e);
                LogUtils.a(242631535, a);
                throw runtimeException;
            } catch (IOException e3) {
                e = e3;
                runtimeException = new RuntimeException(e);
                LogUtils.a(242631535, a);
                throw runtimeException;
            }
        }
        LogUtils.a(553946048, a);
    }

    private void m6895i() {
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
            if (fbTitleBar != null) {
                fbTitleBar.a(new C06761(this));
            }
        }
    }

    private void m6892a(SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f6561p = secureContextHelper;
        this.f6562q = uriIntentMapper;
    }
}
