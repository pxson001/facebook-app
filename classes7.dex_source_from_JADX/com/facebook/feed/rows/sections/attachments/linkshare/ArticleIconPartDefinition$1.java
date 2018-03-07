package com.facebook.feed.rows.sections.attachments.linkshare;

import android.graphics.Rect;
import android.view.View;

/* compiled from: ViewPager has no children after the layout after setting the adapter */
class ArticleIconPartDefinition$1 implements Runnable {
    final /* synthetic */ View f20956a;
    final /* synthetic */ View f20957b;
    final /* synthetic */ ArticleIconPartDefinition f20958c;

    ArticleIconPartDefinition$1(ArticleIconPartDefinition articleIconPartDefinition, View view, View view2) {
        this.f20958c = articleIconPartDefinition;
        this.f20956a = view;
        this.f20957b = view2;
    }

    public void run() {
        Rect rect = new Rect();
        if (this.f20958c.q && this.f20956a.getGlobalVisibleRect(rect) && rect.top >= (this.f20958c.p.a() * 30) / 160) {
            this.f20957b.getGlobalVisibleRect(this.f20958c.o);
            int now = (int) (this.f20958c.c.now() - this.f20958c.j);
            if (now < 2) {
                ArticleIconPartDefinition.b(this.f20958c, this.f20957b);
                return;
            }
            ArticleIconPartDefinition articleIconPartDefinition = this.f20958c;
            int i = articleIconPartDefinition.o.top - articleIconPartDefinition.k;
            int i2 = articleIconPartDefinition.o.bottom - articleIconPartDefinition.l;
            if (Math.abs(i2) <= Math.abs(i)) {
                i2 = i;
            }
            i2 = (i2 * 1000) / now;
            articleIconPartDefinition.n = ((i2 - articleIconPartDefinition.m) * 1000) / now;
            articleIconPartDefinition.m = i2;
            ArticleIconPartDefinition articleIconPartDefinition2 = this.f20958c;
            Object obj = 1;
            i = Math.abs(articleIconPartDefinition2.m) / articleIconPartDefinition2.p.a();
            if (i <= 0 && (i <= 1 || Math.signum((float) articleIconPartDefinition2.m) * Math.signum((float) articleIconPartDefinition2.n) <= 0.0f)) {
                obj = null;
            }
            if (obj != null) {
                ArticleIconPartDefinition.b(this.f20958c, this.f20957b);
                return;
            }
            this.f20958c.f.a(this.f20956a);
            if (this.f20958c.i != null && this.f20958c.a != null) {
                this.f20958c.a.a(this.f20958c.i);
                this.f20958c.a.a().a(this.f20958c.i.b());
            }
        }
    }
}
