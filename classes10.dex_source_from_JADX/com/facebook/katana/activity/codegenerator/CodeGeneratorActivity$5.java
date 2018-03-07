package com.facebook.katana.activity.codegenerator;

import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$5 implements Runnable {
    final /* synthetic */ CodeGeneratorActivity f706a;

    CodeGeneratorActivity$5(CodeGeneratorActivity codeGeneratorActivity) {
        this.f706a = codeGeneratorActivity;
    }

    public void run() {
        Long valueOf = Long.valueOf(30000 / CodeGeneratorActivity.B.longValue());
        Long valueOf2 = Long.valueOf(this.f706a.v.a());
        Long valueOf3 = Long.valueOf((valueOf2.longValue() / 1000) + this.f706a.G.longValue());
        double longValue = (double) ((valueOf2.longValue() + (this.f706a.G.longValue() * 1000)) / CodeGeneratorActivity.B.longValue());
        this.f706a.K.setText(String.valueOf(Long.valueOf(30 - (valueOf3.longValue() % 30))));
        this.f706a.b(CodeGeneratorActivity.a(this.f706a.F, Long.valueOf(valueOf3.longValue() / 30)));
        this.f706a.H.setProgress(((((double) valueOf.longValue()) - (longValue % ((double) valueOf.longValue()))) / ((double) valueOf.longValue())) * 100.0d);
        HandlerDetour.b(this.f706a.E, this, CodeGeneratorActivity.B.longValue(), -1581039338);
    }
}
