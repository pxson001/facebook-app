package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.Tuple;
import com.facebook.inject.FbInjector;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.manageddatastore.ManagedDataStore$ClearType;
import java.io.IOException;

/* compiled from: timeline_optimistic_post_failed */
public class FacewebComponentsStoreCache {
    public static final Class<?> f1257a = FacewebComponentsStoreCache.class;
    protected static FacewebComponentsStoreMDS f1258b;

    /* compiled from: timeline_optimistic_post_failed */
    public class Key extends Tuple<String, String> {
        public Key(String str, String str2) {
            super(str, str2);
        }

        public final String m1289a() {
            return (String) this.a;
        }

        public final String m1290b() {
            return (String) this.b;
        }

        public String toString() {
            return StringFormatUtil.formatStrLocaleSafe("FwCSC.Key<host=%s, fwVersion=%s>", m1289a(), m1290b());
        }
    }

    /* compiled from: timeline_optimistic_post_failed */
    public interface Listener {
        void mo51a(FacewebComponentsStore facewebComponentsStore);

        void mo52a(LoadError loadError, String str);
    }

    /* compiled from: timeline_optimistic_post_failed */
    public enum LoadError {
        DESERIALIZATION_ERROR,
        NETWORK_ERROR,
        NO_SESSION_ERROR,
        SERIALIZATION_ERROR,
        UNEXPECTED_REDIRECT,
        UNKNOWN_ERROR
    }

    /* compiled from: timeline_optimistic_post_failed */
    public class Value extends Tuple<Tuple<LoadError, String>, FacewebComponentsStore> {
        public Value(FacewebComponentsStore facewebComponentsStore) {
            super(null, facewebComponentsStore);
        }

        public Value(LoadError loadError, String str) {
            super(new Tuple(loadError, str), null);
        }

        public final Tuple<LoadError, String> m1293a() {
            return (Tuple) this.a;
        }

        public final FacewebComponentsStore m1294b() {
            return (FacewebComponentsStore) this.b;
        }

        public final boolean m1295c() {
            return this.a != null;
        }

        public String toString() {
            return StringFormatUtil.formatStrLocaleSafe("FwCSC.Value<error=%s fcs=%s>", m1293a(), m1294b());
        }
    }

    public static void m1296a(Context context) {
        m1298d(context).a(ManagedDataStore$ClearType.CLEAR_ALL);
    }

    public static FacewebComponentsStoreMDS m1298d(Context context) {
        if (f1258b == null) {
            f1258b = new FacewebComponentsStoreMDS(context);
        }
        return f1258b;
    }

    public static void m1297a(Context context, Key key, FacewebComponentsStore facewebComponentsStore) {
        FacewebComponentsStoreMDS d = m1298d(context);
        if (facewebComponentsStore == null) {
            d.m1308a(context, false, key, null, new Value(LoadError.UNKNOWN_ERROR, "Fail fetching FacewebComponentsStore"));
            return;
        }
        try {
            d.m1308a(context, true, key, facewebComponentsStore.a(FbObjectMapperMethodAutoProvider.a(FbInjector.get(context))), new Value(facewebComponentsStore));
        } catch (IOException e) {
            d.m1308a(context, false, key, null, new Value(LoadError.SERIALIZATION_ERROR, e.toString()));
        }
    }
}
