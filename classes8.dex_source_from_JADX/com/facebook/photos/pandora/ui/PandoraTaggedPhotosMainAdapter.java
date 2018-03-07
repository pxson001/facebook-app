package com.facebook.photos.pandora.ui;

import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.ui.adapter.AbstractPandoraAdapter;
import com.facebook.photos.pandora.common.ui.adapter.AbstractPandoraChildAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererCollection;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: com.facebook.STREAM_PUBLISH_START */
public class PandoraTaggedPhotosMainAdapter extends AbstractPandoraAdapter {
    private String f17743a;
    private String f17744b;
    public final Lazy<PandoraTaggedPhotosAdapter> f17745c;

    @Inject
    public PandoraTaggedPhotosMainAdapter(String str, Lazy<PandoraTaggedPhotosAdapter> lazy) {
        this.f17743a = str;
        this.f17745c = lazy;
    }

    public final void m21716a(String str, String str2, boolean z, boolean z2, boolean z3) {
        for (AbstractPandoraChildAdapter unregisterDataSetObserver : this.f17435a) {
            unregisterDataSetObserver.unregisterDataSetObserver(this.f17437c);
        }
        this.f17435a.clear();
        AdapterDetour.a(this, 2097700758);
        this.f17743a = str;
        this.f17744b = str2;
        m21412a((AbstractPandoraChildAdapter) this.f17745c.get());
        ((PandoraTaggedPhotosAdapter) this.f17745c.get()).mo1053a(this.f17743a, this.f17744b, z, z2, z3);
    }

    public final PandoraRendererCollection m21717c() {
        return ((PandoraTaggedPhotosAdapter) this.f17745c.get()).f17457i;
    }

    public final PandoraTaggedPhotosAdapter m21718d() {
        return (PandoraTaggedPhotosAdapter) this.f17745c.get();
    }
}
