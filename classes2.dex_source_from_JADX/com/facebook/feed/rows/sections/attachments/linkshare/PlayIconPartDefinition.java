package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_privacy_options */
public class PlayIconPartDefinition<V extends View & AttachmentHasPlayIcon> extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, AnyEnvironment, V> {
    private static PlayIconPartDefinition f23958b;
    private static final Object f23959c = new Object();
    private final DialtoneController f23960a;

    private static PlayIconPartDefinition m32344b(InjectorLike injectorLike) {
        return new PlayIconPartDefinition(DialtoneControllerImpl.m8272a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1044482544);
        m32343a((GraphQLStoryAttachment) obj, view);
        Logger.a(8, EntryType.MARK_POP, -149458484, a);
    }

    @Inject
    public PlayIconPartDefinition(DialtoneController dialtoneController) {
        this.f23960a = dialtoneController;
    }

    private void m32343a(GraphQLStoryAttachment graphQLStoryAttachment, V v) {
        if (graphQLStoryAttachment.m23979r() == null || !graphQLStoryAttachment.m23979r().an()) {
            ((AttachmentHasPlayIcon) v).setCoverPhotoPlayIconVisibility(8);
        } else if (this.f23960a.mo1231j()) {
            this.f23960a.mo1210a(new 1(this, v));
            ((AttachmentHasPlayIcon) v).setCoverPhotoPlayIconVisibility(8);
        } else {
            ((AttachmentHasPlayIcon) v).setCoverPhotoPlayIconVisibility(0);
        }
    }

    public static PlayIconPartDefinition m32342a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlayIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23959c) {
                PlayIconPartDefinition playIconPartDefinition;
                if (a2 != null) {
                    playIconPartDefinition = (PlayIconPartDefinition) a2.mo818a(f23959c);
                } else {
                    playIconPartDefinition = f23958b;
                }
                if (playIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32344b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23959c, b3);
                        } else {
                            f23958b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = playIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
