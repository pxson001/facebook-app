package com.facebook.orca.threadview.messagelist;

import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.orca.threadview.GiftWrapAnimationManager;
import com.facebook.orca.threadview.MessageDetailViewManager;
import com.facebook.orca.threadview.MessageListAdapter.Listener;
import com.facebook.orca.threadview.PaymentsAnimationManager;
import com.facebook.orca.threadview.SendMessageAnimationManager;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass14;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.BotPromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.EmojilikePickerViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.MessageListListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.NicknamePromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager;
import com.facebook.widget.listview.ScrollState;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: markThreadAsSpamDialog */
public interface MessageListHelper {
    @Nullable
    ViewGroup mo334a();

    RowItem mo335a(int i);

    void mo336a(FragmentManager fragmentManager);

    void mo337a(FrameLayout frameLayout, ViewStub viewStub);

    void mo338a(DefaultThreadViewTheme defaultThreadViewTheme);

    void mo339a(@Nullable RowItem rowItem);

    void mo340a(Listener listener);

    void mo341a(AnonymousClass14 anonymousClass14);

    void mo342a(BotPromptViewListener botPromptViewListener);

    void mo343a(EmojilikePickerViewListener emojilikePickerViewListener);

    void mo344a(MessageListListener messageListListener);

    void mo345a(NicknamePromptViewListener nicknamePromptViewListener);

    void mo346a(Decoration decoration);

    void mo347a(MessageListAccessibilityDelegate messageListAccessibilityDelegate);

    void mo348a(ScrollState scrollState);

    void mo349a(List<RowItem> list);

    void mo350a(boolean z);

    void mo351b();

    void mo352b(int i);

    void mo353b(Decoration decoration);

    void mo354b(boolean z);

    boolean mo355c();

    int mo356d();

    int mo357e();

    int mo358f();

    void mo359g();

    boolean mo360h();

    ImmutableList<RowItem> mo361i();

    ImmutableList<RowItem> mo362j();

    @Nullable
    ScrollState mo363k();

    void mo364l();

    SendMessageAnimationManager mo365m();

    MessageDetailViewManager mo366n();

    HotLikesAnimationManager mo367o();

    PaymentsAnimationManager mo368p();

    GiftWrapAnimationManager mo369q();

    ScrollingViewProxy mo370r();
}
