package com.facebook.quickpromotion.prefs;

import android.net.Uri;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$ContextualFilter$Type;

/* compiled from: reaction_attachment_invalid */
public class QuickPromotionPrefKeys {
    public static final PrefKey f4757a;
    public static final PrefKey f4758b;
    public static final PrefKey f4759c = ((PrefKey) f4757a.a("show_all_segues"));
    private static final PrefKey f4760d;
    public static final PrefKey f4761e;
    public static final PrefKey f4762f = ((PrefKey) f4760d.a("last_impression/"));
    public static final PrefKey f4763g = ((PrefKey) f4760d.a("force_mode/"));
    public static final PrefKey f4764h = ((PrefKey) f4760d.a("filter_mode/"));

    /* compiled from: reaction_attachment_invalid */
    public enum FilterState {
        DEFAULT("No Override"),
        ALWAYS_PASS("Always Pass"),
        ALWAYS_FAIL("Always Fail");
        
        private String mFilterState;

        private FilterState(String str) {
            this.mFilterState = str;
        }

        public final String getFilterStateCaption() {
            return this.mFilterState;
        }
    }

    /* compiled from: reaction_attachment_invalid */
    public enum PromotionForceMode {
        DEFAULT("Default", "(Default)"),
        FORCE_ON("Force On", "(Forced On)"),
        FORCE_OFF("Force Off", "(Forced Off)");
        
        private final String mForceModeAction;
        private final String mForceModeCaption;

        private PromotionForceMode(String str, String str2) {
            this.mForceModeAction = str;
            this.mForceModeCaption = str2;
        }

        public final String getActionCaption() {
            return this.mForceModeAction;
        }

        public final String getStatusCaption() {
            return this.mForceModeCaption;
        }
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("qp/");
        f4757a = prefKey;
        f4758b = (PrefKey) prefKey.a("dev_mode");
        prefKey = (PrefKey) SharedPrefKeys.a.a("qp/");
        f4760d = prefKey;
        f4761e = (PrefKey) prefKey.a("last_action/");
    }

    public static PrefKey m4649a(String str) {
        return (PrefKey) f4761e.a(Uri.encode(str));
    }

    public static PrefKey m4650b(String str) {
        return (PrefKey) f4762f.a(Uri.encode(str));
    }

    public static PrefKey m4651c(String str) {
        return (PrefKey) f4763g.a(Uri.encode(str));
    }

    public static PrefKey m4648a(QuickPromotionDefinition$ContextualFilter$Type quickPromotionDefinition$ContextualFilter$Type) {
        return (PrefKey) f4764h.a(Uri.encode(quickPromotionDefinition$ContextualFilter$Type.name()));
    }
}
