package com.facebook.richdocument;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.richdocument.BaseRichDocumentActivity.C06721;
import com.facebook.richdocument.RichDocumentFragment.C06811;
import javax.annotation.Nullable;

/* compiled from: profile/video/create */
public interface RichDocumentDelegate {
    View mo247a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    void mo248a(Context context);

    void mo249a(Bundle bundle);

    void mo250a(View view, @Nullable Bundle bundle);

    void mo251a(C06721 c06721);

    void mo252a(C06811 c06811);

    boolean mo253a();

    void mo254b(Bundle bundle);

    void mo255c(Bundle bundle);

    void mo256d();

    void mo257e();

    void mo258f();

    void mo259g();

    void mo260h();

    void mo261i();

    Dialog mo262j();
}
