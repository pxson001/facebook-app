package com.facebook.messaging.photos.editing;

import com.facebook.stickers.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: did_tap_call_to_action */
public class Scene {
    public final List<Layer> f16190a = new ArrayList();
    public final Observable f16191b = new Observable();
    public Layer f16192c;
    public int f16193d;
    public int f16194e;
    public final HashMap<String, Integer> f16195f = new HashMap();
    public final HashMap<String, Integer> f16196g = new HashMap();

    public final void m16295a(Layer layer) {
        if (layer instanceof TextLayer) {
            this.f16193d++;
        } else if (layer instanceof StickerLayer) {
            this.f16194e++;
            Sticker sticker = ((StickerLayer) layer).f16226a;
            if (this.f16195f.get(sticker.a) == null) {
                this.f16195f.put(sticker.a, Integer.valueOf(1));
            } else {
                this.f16195f.put(sticker.a, Integer.valueOf(((Integer) this.f16195f.get(sticker.a)).intValue() + 1));
            }
            if (this.f16196g.get(sticker.b) == null) {
                this.f16196g.put(sticker.b, Integer.valueOf(1));
            } else {
                this.f16196g.put(sticker.b, Integer.valueOf(((Integer) this.f16196g.get(sticker.b)).intValue() + 1));
            }
        }
        this.f16190a.add(layer);
        this.f16191b.m16225a(new AddLayerEvent(layer, this.f16190a.size() - 1));
        m16296b(layer);
    }

    public final void m16296b(Layer layer) {
        if (layer != this.f16192c) {
            Layer layer2 = this.f16192c;
            this.f16192c = layer;
            this.f16191b.m16225a(new SetActiveLayerEvent(layer, layer2));
        }
    }

    public final Layer m16294a(int i) {
        if (i < 0 || i >= this.f16190a.size()) {
            return null;
        }
        return (Layer) this.f16190a.get(i);
    }

    public final void m16297c(Layer layer) {
        int indexOf = this.f16190a.indexOf(layer);
        if (indexOf >= 0) {
            if (layer instanceof TextLayer) {
                this.f16193d--;
            } else if (layer instanceof StickerLayer) {
                this.f16194e--;
                Sticker sticker = ((StickerLayer) layer).f16226a;
                if (this.f16195f.get(sticker.a) != null) {
                    this.f16195f.put(sticker.a, Integer.valueOf(((Integer) this.f16195f.get(sticker.a)).intValue() - 1));
                    if (((Integer) this.f16195f.get(sticker.a)).intValue() == 0) {
                        this.f16195f.remove(sticker.a);
                    }
                }
                if (this.f16196g.get(sticker.b) != null) {
                    this.f16196g.put(sticker.b, Integer.valueOf(((Integer) this.f16196g.get(sticker.b)).intValue() - 1));
                    if (((Integer) this.f16196g.get(sticker.b)).intValue() == 0) {
                        this.f16196g.remove(sticker.b);
                    }
                }
            }
            this.f16190a.remove(layer);
            this.f16191b.m16225a(new DeleteLayerEvent(layer));
            if (layer == this.f16192c) {
                Layer layer2;
                int min = Math.min(this.f16190a.size() - 1, indexOf);
                if (min >= 0) {
                    layer2 = (Layer) this.f16190a.get(min);
                } else {
                    layer2 = null;
                }
                m16296b(layer2);
            }
        }
    }
}
