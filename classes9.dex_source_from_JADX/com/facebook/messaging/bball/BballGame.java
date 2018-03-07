package com.facebook.messaging.bball;

import com.facebook.messaging.bball.BballScene.Listener;
import com.facebook.messaging.bball.BballView.C09234;
import javax.annotation.Nullable;

/* compiled from: open/ */
public class BballGame {
    public final BballScene f8149a;
    public boolean f8150b;
    public int f8151c;
    private int f8152d = 1000;
    public boolean f8153e;
    public int f8154f;
    @Nullable
    public C09234 f8155g;

    /* compiled from: open/ */
    class BballSceneListener implements Listener {
        final /* synthetic */ BballGame f8148a;

        public BballSceneListener(BballGame bballGame) {
            this.f8148a = bballGame;
        }

        public final void mo301a() {
        }

        public final void mo302b() {
            if (this.f8148a.f8151c == 0) {
                BballGame bballGame = this.f8148a;
                bballGame.f8154f++;
            }
        }

        public final void mo303c() {
        }

        public final void mo304d() {
            this.f8148a.f8150b = false;
        }

        public final void mo305e() {
            this.f8148a.f8150b = true;
            BballGame.m8406a(this.f8148a, this.f8148a.f8151c + 1);
        }

        public final void mo306f() {
            if (this.f8148a.f8150b) {
                this.f8148a.f8149a.m8427i();
            } else {
                BballGame.m8406a(this.f8148a, 0);
                BballScene bballScene = this.f8148a.f8149a;
                bballScene.f8180j = 0.0f;
                bballScene.f8181k = 0.0f;
                bballScene.f8182l = 0.0f;
                bballScene.f8183m = -1.1f;
                bballScene.f8184n = 0.15f;
                this.f8148a.f8149a.m8426h();
                if (this.f8148a.f8155g != null) {
                    this.f8148a.f8155g.m8436a();
                }
            }
            this.f8148a.f8150b = false;
        }
    }

    public BballGame(BballScene bballScene) {
        this.f8149a = bballScene;
        this.f8149a.m8424a(new BballSceneListener(this));
    }

    public static void m8406a(BballGame bballGame, int i) {
        if (!(i == 0 || bballGame.f8151c + 1000 == bballGame.f8152d)) {
            bballGame.f8153e = true;
        }
        bballGame.f8151c = i;
        bballGame.f8152d = bballGame.f8151c + 1000;
        if (bballGame.f8151c == 10) {
            bballGame.f8149a.m8422a(0.2f);
        } else if (bballGame.f8151c == 20) {
            bballGame.f8149a.m8422a(0.4f);
        } else if (bballGame.f8151c == 30) {
            bballGame.f8149a.m8425b(0.1f);
        } else if (bballGame.f8151c == 40) {
            bballGame.f8149a.m8425b(0.2f);
            bballGame.f8149a.f8184n = 0.3f;
        }
        if (bballGame.f8155g != null) {
            bballGame.f8155g.m8437a(bballGame.f8151c);
        }
    }
}
