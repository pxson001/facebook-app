package com.facebook.catalyst.modules.media;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: marked_seen_stories_count */
public final class SoundsModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static final String[] f5596a = new String[]{"currentTime", "duration", "isPlaying", "isPaused", "loop", "volume"};
    public HashMap<String, ReactMediaPlayer> f5597b = MapBuilder.a();
    public boolean f5598c = false;
    @Nullable
    private String f5599d = null;
    @GuardedBy("this")
    private double f5600e;

    /* compiled from: marked_seen_stories_count */
    interface SoundCallback {
        void mo152a(ReactMediaPlayer reactMediaPlayer);
    }

    /* compiled from: marked_seen_stories_count */
    class C07191 implements SoundCallback {
        final /* synthetic */ SoundsModule f5576a;

        C07191(SoundsModule soundsModule) {
            this.f5576a = soundsModule;
        }

        public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
            reactMediaPlayer.m6891b();
            double d = reactMediaPlayer.m6892d();
            synchronized (this.f5576a) {
                this.f5576a.f5600e = d;
            }
        }
    }

    private void m6911t() {
        if (this.a.h() || this.a.f()) {
            throw new IllegalStateException("Not on an AsyncTask thread");
        }
    }

    public final void m6913c() {
        this.a.a(this);
    }

    public SoundsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public final String getName() {
        return "Sounds";
    }

    public final void hg_() {
        this.f5598c = true;
        if (this.f5599d != null) {
            m6906a(this.f5599d, new C07191(this));
        }
        m6910s();
    }

    public final void hh_() {
    }

    public final void hf_() {
        this.f5598c = false;
        if (this.f5599d != null) {
            double d;
            synchronized (this) {
                d = this.f5600e;
            }
            setCurrentTime(this.f5599d, d);
        }
    }

    @Nullable
    public final Map<String, Object> m6912a() {
        Map hashMap = new HashMap();
        for (int i = 0; i < f5596a.length; i++) {
            hashMap.put(f5596a[i], Integer.valueOf(i));
        }
        return MapBuilder.a("Properties", hashMap);
    }

    @ReactMethod
    public final void play(final ReadableMap readableMap) {
        final String string = readableMap.getString("uri");
        m6906a(string, new SoundCallback(this) {
            final /* synthetic */ SoundsModule f5579c;

            public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
                reactMediaPlayer.m6890a((float) readableMap.getDouble("volume"));
                try {
                    reactMediaPlayer.m6889a();
                } catch (Throwable e) {
                    throw new JSApplicationCausedNativeException("Could not play audio: " + string, e);
                }
            }
        });
    }

    @ReactMethod
    public final void pause(final String str, final Callback callback) {
        m6906a(str, new SoundCallback(this) {
            final /* synthetic */ SoundsModule f5582c;

            public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
                try {
                    reactMediaPlayer.m6891b();
                    callback.a(new Object[]{null, Arguments.b()});
                } catch (Throwable e) {
                    throw new JSApplicationCausedNativeException("Could not play audio: " + str, e);
                }
            }
        });
    }

    @ReactMethod
    public final void setVolume(String str, final float f) {
        m6906a(str, new SoundCallback(this) {
            final /* synthetic */ SoundsModule f5584b;

            public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
                reactMediaPlayer.m6890a(f);
            }
        });
    }

    @ReactMethod
    public final void setCurrentTime(String str, final double d) {
        m6906a(str, new SoundCallback(this) {
            final /* synthetic */ SoundsModule f5586b;

            public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
                double d = d;
                if (reactMediaPlayer.f5573b) {
                    reactMediaPlayer.f5572a.seekTo(((int) d) * 1000);
                }
            }
        });
    }

    @ReactMethod
    public final void preloadFiles(final ReadableArray readableArray) {
        new GuardedAsyncTask<Void, Void>(this, this.a) {
            final /* synthetic */ SoundsModule f5588b;

            protected final void m6899a(Object[] objArr) {
                for (int i = 0; i < readableArray.size() && !this.f5588b.f5598c; i++) {
                    String string = readableArray.getString(i);
                    if (!this.f5588b.f5597b.containsKey(string)) {
                        this.f5588b.m6905a(string);
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void getState(String str, final ReadableArray readableArray, final Callback callback) {
        m6906a(str, new SoundCallback(this) {
            final /* synthetic */ SoundsModule f5591c;

            public final void mo152a(ReactMediaPlayer reactMediaPlayer) {
                WritableMap b = Arguments.b();
                for (int i = 0; i < readableArray.size(); i++) {
                    int i2 = readableArray.getInt(i);
                    String str;
                    switch (i2) {
                        case 0:
                            b.putDouble(SoundsModule.f5596a[i2], reactMediaPlayer.m6892d());
                            break;
                        case 1:
                            double d;
                            str = SoundsModule.f5596a[i2];
                            if (reactMediaPlayer.f5573b) {
                                int duration = reactMediaPlayer.f5572a.getDuration();
                                if (duration == -1) {
                                    d = -1.0d;
                                } else {
                                    d = ReactMediaPlayer.m6885a(duration);
                                }
                            } else {
                                d = 0.0d;
                            }
                            b.putDouble(str, d);
                            break;
                        case 2:
                            boolean isPlaying;
                            str = SoundsModule.f5596a[i2];
                            if (reactMediaPlayer.f5573b) {
                                isPlaying = reactMediaPlayer.f5572a.isPlaying();
                            } else {
                                isPlaying = false;
                            }
                            b.putBoolean(str, isPlaying);
                            break;
                        case 3:
                            b.putBoolean(SoundsModule.f5596a[i2], reactMediaPlayer.f5574c);
                            break;
                        case 4:
                            b.putInt(SoundsModule.f5596a[i2], 0);
                            break;
                        case 5:
                            b.putDouble(SoundsModule.f5596a[i2], (double) reactMediaPlayer.f5575d);
                            break;
                        default:
                            throw new JSApplicationCausedNativeException("Unknown sound property: " + i2);
                    }
                }
                callback.a(new Object[]{null, b});
            }
        });
    }

    @ReactMethod
    public final void setPauseOnAppBackground(String str, boolean z) {
        if (z) {
            this.f5599d = str;
        } else {
            this.f5599d = null;
        }
    }

    public final void m6914e() {
        m6910s();
    }

    private void m6906a(final String str, final SoundCallback soundCallback) {
        new GuardedAsyncTask<Void, Void>(this, this.a) {
            final /* synthetic */ SoundsModule f5594c;

            protected final void m6901a(Object[] objArr) {
                if (!this.f5594c.f5597b.containsKey(str)) {
                    this.f5594c.m6905a(str);
                }
                soundCallback.mo152a((ReactMediaPlayer) this.f5594c.f5597b.get(str));
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private ReactMediaPlayer m6905a(String str) {
        m6911t();
        Uri a = UriUtil.a(str);
        if (this.f5597b.containsKey(str)) {
            return (ReactMediaPlayer) this.f5597b.get(str);
        }
        ReactMediaPlayer a2;
        Object obj = (UriUtil.a(a) || UriUtil.b(a)) ? null : 1;
        if (obj != null) {
            a2 = ReactMediaPlayer.m6887a((Context) this.a, str);
        } else {
            a2 = ReactMediaPlayer.m6886a((Context) this.a, a);
        }
        this.f5597b.put(str, a2);
        return a2;
    }

    private void m6910s() {
        new GuardedAsyncTask<Void, Void>(this, this.a) {
            final /* synthetic */ SoundsModule f5595a;

            protected final void m6902a(Object[] objArr) {
                for (ReactMediaPlayer reactMediaPlayer : this.f5595a.f5597b.values()) {
                    reactMediaPlayer.f5572a.release();
                }
                this.f5595a.f5597b.clear();
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
