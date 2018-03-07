package com.facebook.common.uri;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.generated.C0490x39ca9ed8;
import com.google.common.annotations.VisibleForTesting;
import java.lang.annotation.Annotation;
import javax.annotation.Nullable;
import javax.inject.Provider;

@Deprecated
/* compiled from: balance */
public abstract class UriIntentBuilder {
    private UriTemplateMap<IUriTemplateIntentBuilder> f8029a = new UriTemplateMap();

    /* compiled from: balance */
    public interface IUriTemplateIntentBuilder {
        Intent mo1029a(Context context, Bundle bundle);
    }

    /* compiled from: balance */
    class FragmentUriBuilder implements IUriTemplateIntentBuilder {
        private final int f11187a;
        private final Class<? extends Annotation> f11188b;
        private final Bundle f11189c;

        public FragmentUriBuilder(int i, Class<? extends Annotation> cls, @Nullable Bundle bundle) {
            this.f11187a = i;
            this.f11188b = cls;
            this.f11189c = bundle;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            Intent component = new Intent().setComponent(C0490x39ca9ed8.m10042a(FbInjector.get(context), this.f11188b));
            component.putExtra("target_fragment", this.f11187a);
            if (this.f11189c != null) {
                component.putExtras(this.f11189c);
            }
            if (bundle != null) {
                component.putExtras(bundle);
            }
            return component;
        }
    }

    /* compiled from: balance */
    class MappedUriIntentBuilder implements IUriTemplateIntentBuilder {
        private final String f11190a;

        public MappedUriIntentBuilder(String str) {
            this.f11190a = str;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            try {
                String str = this.f11190a;
                String str2 = str;
                for (String str3 : bundle.keySet()) {
                    str2 = str2.replaceAll("<" + str3 + ">", StringUtil.a(bundle, str3));
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                return intent;
            } catch (Throwable e) {
                BLog.c("UriIntentBuilder", e, "MappedUriIntentBuilder.buildIntent failed: mUriTemplate=%s parameters=%s", new Object[]{this.f11190a, bundle, e});
                return null;
            }
        }
    }

    /* compiled from: balance */
    public class UriBuilder implements IUriTemplateIntentBuilder {
        private final Class<? extends Activity> f11191a;
        private final Bundle f11192b;

        public UriBuilder(Class<? extends Activity> cls) {
            this(cls, null);
        }

        public UriBuilder(Class<? extends Activity> cls, @Nullable Bundle bundle) {
            this.f11191a = cls;
            this.f11192b = bundle;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            Intent intent = new Intent(context, this.f11191a);
            if (this.f11192b != null) {
                intent.putExtras(this.f11192b);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            return intent;
        }
    }

    /* compiled from: balance */
    class UriComponentProviderBuilder implements IUriTemplateIntentBuilder {
        private final Provider<ComponentName> f11193a;
        private final Bundle f11194b;

        public UriComponentProviderBuilder(Provider<ComponentName> provider, @Nullable Bundle bundle) {
            this.f11193a = provider;
            this.f11194b = bundle;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            Intent intent = new Intent();
            intent.setComponent((ComponentName) this.f11193a.get());
            if (this.f11194b != null) {
                intent.putExtras(this.f11194b);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            return intent;
        }
    }

    protected boolean mo1030a() {
        return true;
    }

    public Intent m14185a(Context context, String str) {
        if (!mo1030a()) {
            return null;
        }
        try {
            UriTemplateMap$UriMatch a = this.f8029a.a(str.replaceAll("v\\d+\\.\\d+\\/", ""));
            if (a != null) {
                return ((IUriTemplateIntentBuilder) a.f11200a).mo1029a(context, a.f11201b);
            }
            return null;
        } catch (UriTemplateMap$InvalidUriException e) {
            return null;
        }
    }

    public final void m14192a(String str, Provider<ComponentName> provider, @Nullable Bundle bundle) {
        try {
            this.f8029a.a(str, new UriComponentProviderBuilder(provider, bundle));
        } catch (Throwable e) {
            BLog.b(getClass(), String.format("Invalid uri template: %s", new Object[]{str}), e);
        }
    }

    public final void m14187a(String str, Class<? extends Activity> cls) {
        m14190a(str, (Class) cls, null);
    }

    public final void m14190a(String str, Class<? extends Activity> cls, @Nullable Bundle bundle) {
        try {
            this.f8029a.a(str, new UriBuilder(cls, bundle));
        } catch (Throwable e) {
            BLog.b(getClass(), e, "Invalid uri template: %s", new Object[]{str});
        }
    }

    protected final void m14188a(String str, Class<? extends Annotation> cls, int i) {
        m14189a(str, cls, i, null);
    }

    public final void m14189a(String str, Class<? extends Annotation> cls, int i, @Nullable Bundle bundle) {
        try {
            this.f8029a.a(str, new FragmentUriBuilder(i, cls, bundle));
        } catch (Throwable e) {
            BLog.b(getClass(), e, "Invalid uri template: %s", new Object[]{str});
        }
    }

    protected final void m14191a(String str, String str2) {
        try {
            this.f8029a.a(str, new MappedUriIntentBuilder(str2));
        } catch (Throwable e) {
            BLog.b(getClass(), StringFormatUtil.formatStrLocaleSafe("Invalid uri template: %s", str), e);
        }
    }

    @VisibleForTesting
    public final void m14186a(String str, IUriTemplateIntentBuilder iUriTemplateIntentBuilder) {
        try {
            this.f8029a.a(str, iUriTemplateIntentBuilder);
        } catch (Throwable e) {
            BLog.b(getClass(), e, "Invalid uri template: %s", new Object[]{str});
        }
    }
}
