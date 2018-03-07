package com.facebook.feed.rows.animations;

import android.view.View;

/* compiled from: simplepicker_camera_button */
class AnimationsPartDefinition$2 implements Runnable {
    final /* synthetic */ AnimationBuilder f3682a;
    final /* synthetic */ Object f3683b;
    final /* synthetic */ Object f3684c;
    final /* synthetic */ View f3685d;
    final /* synthetic */ long f3686e;
    final /* synthetic */ long f3687f;
    final /* synthetic */ AnimationsPartDefinition$PersistentState f3688g;
    final /* synthetic */ AnimationsPartDefinition f3689h;

    AnimationsPartDefinition$2(AnimationsPartDefinition animationsPartDefinition, AnimationBuilder animationBuilder, Object obj, Object obj2, View view, long j, long j2, AnimationsPartDefinition$PersistentState animationsPartDefinition$PersistentState) {
        this.f3689h = animationsPartDefinition;
        this.f3682a = animationBuilder;
        this.f3683b = obj;
        this.f3684c = obj2;
        this.f3685d = view;
        this.f3686e = j;
        this.f3687f = j2;
        this.f3688g = animationsPartDefinition$PersistentState;
    }

    public void run() {
        Runnable a = this.f3682a.a(this.f3683b, this.f3684c, this.f3685d);
        if (a != null) {
            a.run();
        }
        if (this.f3689h.a.a() >= this.f3686e + this.f3687f) {
            this.f3688g.f3690a = this.f3684c;
            this.f3688g.f3691b = 0;
        }
    }
}
