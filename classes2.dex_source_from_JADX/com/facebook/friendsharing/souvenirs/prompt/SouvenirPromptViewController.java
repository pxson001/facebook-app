package com.facebook.friendsharing.souvenirs.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mountType */
public class SouvenirPromptViewController implements PromptViewController {
    public final Resources f13303a;
    public final SouvenirPromptTitleGenerator f13304b;
    private final SouvenirsLogger f13305c;
    public final Context f13306d;
    private final V2PromptUtil f13307e;
    private final SouvenirPromptManager f13308f;
    public final InlineComposerPromptActionHandler f13309g;
    public final PromptActionContextFactory f13310h;
    private final ClickListener f13311i = new ClickListener(this);

    /* compiled from: mountType */
    public class ClickListener implements OnClickListener {
        final /* synthetic */ SouvenirPromptViewController f13385a;
        public InlineComposerPromptSession f13386b = null;

        public ClickListener(SouvenirPromptViewController souvenirPromptViewController) {
            this.f13385a = souvenirPromptViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 558598559);
            Preconditions.checkNotNull(this.f13386b);
            this.f13385a.f13309g.mo2620a(view, this.f13386b, this.f13385a.f13310h.m19726a(this.f13386b).a());
            Logger.a(2, EntryType.UI_INPUT_END, 2082893117, a);
        }
    }

    public static SouvenirPromptViewController m19594b(InjectorLike injectorLike) {
        return new SouvenirPromptViewController(ResourcesMethodAutoProvider.m6510a(injectorLike), SouvenirPromptTitleGenerator.m19604b(injectorLike), SouvenirsLogger.m19617b(injectorLike), (Context) injectorLike.getInstance(Context.class), V2PromptUtil.m18713b(injectorLike), SouvenirPromptManager.m19626a(injectorLike), InlineComposerPromptActionHandler.m19641b(injectorLike), PromptActionContextFactory.m19725b(injectorLike));
    }

    @Inject
    public SouvenirPromptViewController(Resources resources, SouvenirPromptTitleGenerator souvenirPromptTitleGenerator, SouvenirsLogger souvenirsLogger, Context context, V2PromptUtil v2PromptUtil, SouvenirPromptManager souvenirPromptManager, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory) {
        this.f13303a = resources;
        this.f13304b = souvenirPromptTitleGenerator;
        this.f13305c = souvenirsLogger;
        this.f13306d = context;
        this.f13307e = v2PromptUtil;
        this.f13308f = souvenirPromptManager;
        this.f13309g = inlineComposerPromptActionHandler;
        this.f13310h = promptActionContextFactory;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof SouvenirPromptObject;
    }

    public final PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof SouvenirPromptObject, "Bug in framework.");
        return new SouvenirPromptViewBindingObject(this, (SouvenirPromptObject) a);
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f13311i.f13386b = inlineComposerPromptSession;
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(this.f13311i);
        SouvenirPromptViewBindingObject souvenirPromptViewBindingObject = (SouvenirPromptViewBindingObject) v2ObjectsRequiredForBinding.f19914b;
        ((SouvenirPromptAttachment) v2ObjectsRequiredForBinding.f19915c).a(souvenirPromptViewBindingObject.b, souvenirPromptViewBindingObject.c, souvenirPromptViewBindingObject.d);
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof SouvenirPromptObject, "Didn't get a souvenir prompt object");
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) a;
        if (!souvenirPromptObject.b) {
            this.f13305c.m19623b(souvenirPromptObject);
            souvenirPromptObject.b = true;
            this.f13308f.m19628a(a.mo2493b());
        }
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f13311i.f13386b = null;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(null);
    }

    public final void mo2614a(boolean z, InlineComposerPromptSession inlineComposerPromptSession) {
    }

    public final void mo2613a(InlineComposerPromptSession inlineComposerPromptSession) {
    }

    public final void mo2618b(InlineComposerPromptSession inlineComposerPromptSession) {
    }

    public final void mo2619c(InlineComposerPromptSession inlineComposerPromptSession) {
    }
}
