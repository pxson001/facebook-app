package com.facebook.orca.notify;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.android.gms.wearable.Node;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: setLeftTopRightBottom */
public class MessagesWearNodeListener {
    private static final Class f2452a = MessagesWearNodeListener.class;
    public final FbSharedPreferences f2453b;

    public static MessagesWearNodeListener m2725a(InjectorLike injectorLike) {
        return new MessagesWearNodeListener((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MessagesWearNodeListener(FbSharedPreferences fbSharedPreferences) {
        this.f2453b = fbSharedPreferences;
    }

    public final ListenableFuture<Void> m2726a(Node node) {
        SettableFuture f = SettableFuture.f();
        try {
            if (!this.f2453b.a()) {
                this.f2453b.c();
            }
            Iterable a = Sets.a();
            Collections.addAll(a, this.f2453b.a(MessagingPrefKeys.at, "").split(":"));
            a.add(node.a());
            this.f2453b.edit().a(MessagingPrefKeys.at, Joiner.on(":").join(a)).commit();
            FutureDetour.a(f, null, 964922069);
        } catch (Throwable e) {
            f.a(e);
        }
        return f;
    }

    public final ListenableFuture<Void> m2727b(Node node) {
        SettableFuture f = SettableFuture.f();
        try {
            if (!this.f2453b.a()) {
                this.f2453b.c();
            }
            Iterable a = Sets.a();
            Collections.addAll(a, this.f2453b.a(MessagingPrefKeys.at, "").split(":"));
            a.remove(node.a());
            this.f2453b.edit().a(MessagingPrefKeys.at, Joiner.on(":").join(a)).commit();
            FutureDetour.a(f, null, -609918032);
        } catch (Throwable e) {
            f.a(e);
        }
        return f;
    }
}
