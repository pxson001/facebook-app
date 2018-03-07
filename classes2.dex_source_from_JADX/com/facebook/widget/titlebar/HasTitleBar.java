package com.facebook.widget.titlebar;

import android.view.View;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import javax.annotation.Nullable;

/* compiled from: mv */
public interface HasTitleBar {
    void mo2554a(OnToolbarButtonListener onToolbarButtonListener);

    void mo2555a(TitleBarButtonSpec titleBarButtonSpec);

    void a_(String str);

    void mo2557b(TitleBarButtonSpec titleBarButtonSpec);

    void mo2558c(boolean z);

    void kg_();

    @Nullable
    View lh_();

    void setCustomTitle(View view);

    void y_(int i);
}
