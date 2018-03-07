package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory;
import android.util.Log;

/* compiled from: watch_status */
public class RemoteInput extends android.support.v4.app.RemoteInputCompatBase.RemoteInput {
    public static final Factory f201a = new C00121();
    public static final Impl f202g;
    private final String f203b;
    private final CharSequence f204c;
    private final CharSequence[] f205d;
    private final boolean f206e;
    private final Bundle f207f;

    /* compiled from: watch_status */
    final class C00121 implements Factory {
        C00121() {
        }
    }

    /* compiled from: watch_status */
    public final class Builder {
        private final String f196a;
        public CharSequence f197b;
        public CharSequence[] f198c;
        public boolean f199d = true;
        private Bundle f200e = new Bundle();

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f196a = str;
        }

        public final RemoteInput m193a() {
            return new RemoteInput(this.f196a, this.f197b, this.f198c, this.f199d, this.f200e);
        }
    }

    /* compiled from: watch_status */
    public interface Impl {
        Bundle mo34a(Intent intent);

        void mo35a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);
    }

    /* compiled from: watch_status */
    class ImplApi20 implements Impl {
        public final Bundle mo34a(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }

        public final void mo35a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent(RemoteInputCompatApi20.m212a(remoteInputArr), intent, bundle);
        }

        ImplApi20() {
        }
    }

    /* compiled from: watch_status */
    class ImplBase implements Impl {
        ImplBase() {
        }

        public final Bundle mo34a(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }

        public final void mo35a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }
    }

    /* compiled from: watch_status */
    class ImplJellybean implements Impl {
        public final void mo35a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            for (android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
                Object obj = bundle.get(remoteInput.mo36a());
                if (obj instanceof CharSequence) {
                    bundle2.putCharSequence(remoteInput.mo36a(), (CharSequence) obj);
                }
            }
            Intent intent2 = new Intent();
            intent2.putExtra("android.remoteinput.resultsData", bundle2);
            intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
        }

        ImplJellybean() {
        }

        public final Bundle mo34a(Intent intent) {
            Bundle bundle = null;
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                ClipDescription description = clipData.getDescription();
                if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
                    bundle = (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            return bundle;
        }
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.f203b = str;
        this.f204c = charSequence;
        this.f205d = charSequenceArr;
        this.f206e = z;
        this.f207f = bundle;
    }

    public final String mo36a() {
        return this.f203b;
    }

    public final CharSequence mo37b() {
        return this.f204c;
    }

    public final CharSequence[] mo38c() {
        return this.f205d;
    }

    public final boolean mo39d() {
        return this.f206e;
    }

    public final Bundle mo40e() {
        return this.f207f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f202g = new ImplApi20();
        } else if (VERSION.SDK_INT >= 16) {
            f202g = new ImplJellybean();
        } else {
            f202g = new ImplBase();
        }
    }
}
