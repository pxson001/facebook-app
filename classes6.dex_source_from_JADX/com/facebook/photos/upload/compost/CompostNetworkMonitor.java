package com.facebook.photos.upload.compost;

import android.os.Handler;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graph_search_v2_typeahead_keyword_suggestion */
public class CompostNetworkMonitor {
    public final FbNetworkManager f13536a;
    public final QeAccessor f13537b;
    @Nullable
    private Timer f13538c;
    @Nullable
    public CompostNetworkListener f13539d = null;
    public CompostNetworkStatus f13540e;

    /* compiled from: graph_search_v2_typeahead_keyword_suggestion */
    public interface CompostNetworkListener {
        void mo1142a();
    }

    /* compiled from: graph_search_v2_typeahead_keyword_suggestion */
    public enum CompostNetworkStatus {
        CONNECTED,
        NO_INTERNET
    }

    public static CompostNetworkMonitor m21213b(InjectorLike injectorLike) {
        return new CompostNetworkMonitor(FbNetworkManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CompostNetworkMonitor(FbNetworkManager fbNetworkManager, QeAccessor qeAccessor) {
        this.f13536a = fbNetworkManager;
        this.f13537b = qeAccessor;
        m21214a();
    }

    public final void m21214a() {
        if (this.f13536a.d()) {
            this.f13540e = CompostNetworkStatus.CONNECTED;
        } else {
            this.f13540e = CompostNetworkStatus.NO_INTERNET;
        }
    }

    public final void m21215a(CompostNetworkListener compostNetworkListener) {
        long a = this.f13537b.a(ExperimentsForCompostAbTestModule.f8095n, 5000);
        this.f13539d = compostNetworkListener;
        final Handler handler = new Handler();
        this.f13538c = new Timer();
        this.f13538c.scheduleAtFixedRate(new TimerTask(this) {
            final /* synthetic */ CompostNetworkMonitor f13535b;

            /* compiled from: graph_search_v2_typeahead_keyword_suggestion */
            class C08671 implements Runnable {
                final /* synthetic */ C08681 f13533a;

                C08671(C08681 c08681) {
                    this.f13533a = c08681;
                }

                public void run() {
                    if (this.f13533a.f13535b.f13539d != null) {
                        CompostNetworkStatus compostNetworkStatus = this.f13533a.f13535b.f13540e;
                        this.f13533a.f13535b.m21214a();
                        if (compostNetworkStatus != this.f13533a.f13535b.f13540e) {
                            this.f13533a.f13535b.f13539d.mo1142a();
                        }
                    }
                }
            }

            public void run() {
                HandlerDetour.a(handler, new C08671(this), -429490927);
            }
        }, a, a);
    }

    public final void m21216d() {
        if (this.f13538c != null) {
            this.f13538c.cancel();
        }
        this.f13538c = null;
        this.f13539d = null;
    }
}
