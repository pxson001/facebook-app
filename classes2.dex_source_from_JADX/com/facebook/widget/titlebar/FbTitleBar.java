package com.facebook.widget.titlebar;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

/* compiled from: reviews_feed_load_shimmer */
public interface FbTitleBar {
    void mo1617a(OnClickListener onClickListener);

    boolean mo1618a();

    View f_(int i);

    void setButtonSpecs(List<TitleBarButtonSpec> list);

    void setCustomTitleView(View view);

    void setHasBackButton(boolean z);

    void setHasFbLogo(boolean z);

    void setOnBackPressedListener(OnBackPressedListener onBackPressedListener);

    void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener);

    void setShowDividers(boolean z);

    void setTitle(int i);

    void setTitle(String str);

    void setTitlebarAsModal(OnClickListener onClickListener);
}
