package com.facebook.orca.compose;

import android.support.v4.app.FragmentManager;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.orca.compose.ComposeFragment.AnonymousClass32;
import javax.annotation.Nullable;

/* compiled from: open_media_picker_params */
public interface MessageComposer {
    int mo173a(ComposerPointerLocation composerPointerLocation, boolean z);

    void mo174a(int i, int i2);

    void mo175a(ContentSearchType contentSearchType, String str, boolean z, String str2);

    void mo176a(String str);

    void mo177a(boolean z, @Nullable String str);

    void mo178b();

    void mo179b(String str);

    void mo180c();

    void clearFocus();

    void mo181d();

    void mo182e();

    void mo183f();

    void mo184g();

    int getAdditionalKeyboardHeight();

    ContentSearchParams getContentSearchParams();

    MessageComposerEditor getEditor();

    int getOverlapY();

    String getUnsentMessageText();

    boolean mo190h();

    boolean mo191i();

    boolean mo192j();

    void mo193k();

    void setCanSendStickers(boolean z);

    void setComposeMode(ComposeMode composeMode);

    void setComposerButtonActiveColorFilterOverride(int i);

    void setCreateThreadPickedUsersCount(int i);

    void setFragmentManager(FragmentManager fragmentManager);

    void setIsFlowerBorderModeActive(boolean z);

    void setIsLikeEnabled(boolean z);

    void setIsSecretMode(boolean z);

    void setIsSendEnabled(boolean z);

    void setIsSmsThread(boolean z);

    void setLikeIconIdOverride(int i);

    void setMessageComposerCallback(AnonymousClass32 anonymousClass32);

    void setTextLengthLimit(int i);

    void setThreadKey(@Nullable ThreadKey threadKey);
}
