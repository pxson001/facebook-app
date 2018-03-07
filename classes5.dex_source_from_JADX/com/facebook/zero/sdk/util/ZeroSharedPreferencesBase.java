package com.facebook.zero.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.util.ZeroSharedPreferences.Editor;
import javax.inject.Inject;

/* compiled from: com.android.internal.os.BatteryStatsImpl */
public class ZeroSharedPreferencesBase implements ZeroSharedPreferences {
    public final SharedPreferences f5936a;

    /* compiled from: com.android.internal.os.BatteryStatsImpl */
    public class ZeroEditorBase implements Editor {
        final /* synthetic */ ZeroSharedPreferencesBase f5934a;
        private SharedPreferences.Editor f5935b;

        public ZeroEditorBase(ZeroSharedPreferencesBase zeroSharedPreferencesBase, SharedPreferences.Editor editor) {
            this.f5934a = zeroSharedPreferencesBase;
            this.f5935b = editor;
        }

        public final Editor m10721a(String str, String str2) {
            this.f5935b.putString(str, str2);
            return this;
        }

        public final Editor m10719a(String str, int i) {
            this.f5935b.putInt(str, i);
            return this;
        }

        public final Editor m10720a(String str, long j) {
            this.f5935b.putLong(str, j);
            return this;
        }

        public final Editor m10722a(String str, boolean z) {
            this.f5935b.putBoolean(str, z);
            return this;
        }

        public final Editor m10718a(String str) {
            for (String str2 : this.f5934a.f5936a.getAll().keySet()) {
                if (str2.startsWith(str) && (str2.length() == str.length() || str2.charAt(str.length()) == '/')) {
                    this.f5935b.remove(str2);
                }
            }
            return this;
        }

        public final void m10723a() {
            this.f5935b.commit();
        }
    }

    private static ZeroSharedPreferencesBase m10724b(InjectorLike injectorLike) {
        return new ZeroSharedPreferencesBase((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ZeroSharedPreferencesBase(Context context) {
        this.f5936a = context.getSharedPreferences(ZeroSharedPreferencesBase.class.getName(), 0);
    }

    public final Editor m10727a() {
        return new ZeroEditorBase(this, this.f5936a.edit());
    }

    public final String m10728a(String str, String str2) {
        return this.f5936a.getString(str, str2);
    }

    public final int m10725a(String str, int i) {
        return this.f5936a.getInt(str, i);
    }

    public final long m10726a(String str, long j) {
        return this.f5936a.getLong(str, j);
    }

    public final boolean m10730a(String str, boolean z) {
        return this.f5936a.getBoolean(str, z);
    }

    public final boolean m10729a(String str) {
        return this.f5936a.contains(str);
    }
}
