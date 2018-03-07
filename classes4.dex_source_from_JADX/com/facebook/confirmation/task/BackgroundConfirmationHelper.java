package com.facebook.confirmation.task;

import android.os.Handler;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.prefs.AccountConfirmationPrefKeys;
import com.facebook.confirmation.util.SmsConfirmationReaderExperimental;
import com.facebook.confirmation.util.SmsReaderExperimental.SmsReaderPointer;
import com.facebook.debug.log.BLog;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fb_ffmpeg_jni */
public class BackgroundConfirmationHelper {
    private static final Class<?> f12023a = BackgroundConfirmationHelper.class;
    private final FbSharedPreferences f12024b;
    private final Clock f12025c;
    private final ObjectMapper f12026d;
    public final Handler f12027e;
    public final Lazy<BackgroundTaskManager> f12028f;
    public final Lazy<SmsConfirmationReaderExperimental> f12029g;
    private final Provider<String> f12030h;

    /* compiled from: fb_ffmpeg_jni */
    public enum ConfirmationMethod {
        REGULAR_SMS_CONFIRMATION,
        EXPERIMENTAL_SMS_CONFIRMATION,
        OPENID_CONNECT_EMAIL_CONFIRMATION
    }

    public static BackgroundConfirmationHelper m12689b(InjectorLike injectorLike) {
        return new BackgroundConfirmationHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 384), IdBasedLazy.a(injectorLike, 887), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public BackgroundConfirmationHelper(FbSharedPreferences fbSharedPreferences, Clock clock, ObjectMapper objectMapper, Handler handler, Lazy<BackgroundTaskManager> lazy, Lazy<SmsConfirmationReaderExperimental> lazy2, Provider<String> provider) {
        this.f12024b = fbSharedPreferences;
        this.f12025c = clock;
        this.f12026d = objectMapper;
        this.f12027e = handler;
        this.f12028f = lazy;
        this.f12029g = lazy2;
        this.f12030h = provider;
    }

    public final boolean m12697a(Contactpoint contactpoint) {
        if (contactpoint.type == ContactpointType.PHONE) {
            return m12691b(ConfirmationMethod.REGULAR_SMS_CONFIRMATION, contactpoint, (String) this.f12030h.get());
        }
        if (contactpoint.type == ContactpointType.EMAIL) {
            return m12691b(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION, contactpoint, (String) this.f12030h.get());
        }
        return false;
    }

    public final boolean m12694a(ConfirmationMethod confirmationMethod, Contactpoint contactpoint, String str) {
        return m12691b(confirmationMethod, contactpoint, str);
    }

    public final boolean m12695a(ConfirmationMethod confirmationMethod, Contactpoint... contactpointArr) {
        Map hashMap = new HashMap(m12692a(confirmationMethod));
        for (Object remove : contactpointArr) {
            hashMap.remove(remove);
        }
        return m12687a(confirmationMethod, hashMap, (String) this.f12030h.get());
    }

    public final Map<Contactpoint, Long> m12692a(ConfirmationMethod confirmationMethod) {
        return m12685a(confirmationMethod, (String) this.f12030h.get());
    }

    public final boolean m12696a(SmsReaderPointer smsReaderPointer) {
        try {
            this.f12024b.edit().a(AccountConfirmationPrefKeys.f13082e, this.f12026d.a(smsReaderPointer)).commit();
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    @Nullable
    public final SmsReaderPointer m12699b() {
        try {
            return (SmsReaderPointer) this.f12026d.a(this.f12024b.a(AccountConfirmationPrefKeys.f13082e, null), SmsReaderPointer.class);
        } catch (Throwable e) {
            BLog.b(f12023a, "Error with parsing sms reader pointer data", e);
            return null;
        }
    }

    public final Set<String> m12701c() {
        return m12686a(AccountConfirmationPrefKeys.f13079b);
    }

    public final boolean m12698a(Set<String> set) {
        return m12688a(AccountConfirmationPrefKeys.f13079b, (Set) set);
    }

    public final Set<String> m12702d() {
        return m12686a(AccountConfirmationPrefKeys.f13080c);
    }

    public final boolean m12700b(Set<String> set) {
        return m12688a(AccountConfirmationPrefKeys.f13080c, (Set) set);
    }

    public final int m12703e() {
        return this.f12024b.a(AccountConfirmationPrefKeys.f13081d, 0);
    }

    public final void m12693a(int i) {
        this.f12024b.edit().a(AccountConfirmationPrefKeys.f13081d, i).commit();
    }

    private Set<String> m12686a(PrefKey prefKey) {
        Object a = this.f12024b.a(prefKey, null);
        if (StringUtil.c(a)) {
            return new HashSet();
        }
        try {
            return (Set) this.f12026d.a(a, this.f12026d.c().a(Set.class, String.class));
        } catch (Throwable e) {
            BLog.b(f12023a, "Error with parsing pending contactpoints data", e);
            return new HashSet();
        }
    }

    private boolean m12688a(PrefKey prefKey, Set<String> set) {
        try {
            this.f12024b.edit().a(prefKey, this.f12026d.a(set)).commit();
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    private boolean m12691b(ConfirmationMethod confirmationMethod, Contactpoint contactpoint, String str) {
        if (contactpoint == null || !contactpoint.a() || StringUtil.a(str)) {
            return false;
        }
        Map hashMap = new HashMap(m12685a(confirmationMethod, str));
        if (!hashMap.containsKey(contactpoint)) {
            hashMap.put(contactpoint, Long.valueOf(this.f12025c.a()));
        }
        boolean a = m12687a(confirmationMethod, hashMap, str);
        long j = 0;
        if (confirmationMethod == ConfirmationMethod.REGULAR_SMS_CONFIRMATION) {
            j = 10000;
        }
        if (!a) {
            return a;
        }
        HandlerDetour.b(this.f12027e, new 2(this), j, -1945084817);
        return a;
    }

    private boolean m12687a(ConfirmationMethod confirmationMethod, Map<Contactpoint, Long> map, String str) {
        if (StringUtil.a(str)) {
            return false;
        }
        try {
            List arrayList = new ArrayList();
            for (Entry entry : map.entrySet()) {
                arrayList.add(new PendingContactpoint((Contactpoint) entry.getKey(), ((Long) entry.getValue()).longValue()));
            }
            this.f12024b.edit().a(m12690b(confirmationMethod, str), this.f12026d.a(arrayList)).commit();
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    private Map<Contactpoint, Long> m12685a(ConfirmationMethod confirmationMethod, String str) {
        Builder builder = new Builder();
        if (StringUtil.a(str)) {
            return builder.b();
        }
        Object a = this.f12024b.a(m12690b(confirmationMethod, str), null);
        if (StringUtil.c(a)) {
            return builder.b();
        }
        try {
            List<PendingContactpoint> list = (List) this.f12026d.a(a, this.f12026d.c().a(List.class, PendingContactpoint.class));
            if (list != null) {
                for (PendingContactpoint pendingContactpoint : list) {
                    builder.b(pendingContactpoint.pendingContactpoint, Long.valueOf(pendingContactpoint.timestamp));
                }
            }
        } catch (Throwable e) {
            BLog.b(f12023a, "Error with parsing pending contactpoints data", e);
        }
        return builder.b();
    }

    private static PrefKey m12690b(ConfirmationMethod confirmationMethod, String str) {
        return (PrefKey) ((PrefKey) AccountConfirmationPrefKeys.f13083f.a(confirmationMethod.name() + "/")).a(str);
    }
}
