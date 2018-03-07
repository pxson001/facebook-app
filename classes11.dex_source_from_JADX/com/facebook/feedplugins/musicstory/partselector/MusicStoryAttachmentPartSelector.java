package com.facebook.feedplugins.musicstory.partselector;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.ShareAttachmentImageFormatSelector;
import com.facebook.feedplugins.musicpreview.MusicPreviewAttachmentGroupPartDefinition;
import com.facebook.feedplugins.musicstory.SimpleMusicStoryPartDefinition;
import com.facebook.feedplugins.musicstory.albums.AlbumSharePartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_action_item_click */
public class MusicStoryAttachmentPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static MusicStoryAttachmentPartSelector f8332e;
    private static final Object f8333f = new Object();
    private final ShareAttachmentImageFormatSelector f8334a;
    private final MusicPreviewAttachmentGroupPartDefinition f8335b;
    private final SimpleMusicStoryPartDefinition f8336c;
    private final AlbumSharePartDefinition<?, FeedEnvironment> f8337d;

    private static MusicStoryAttachmentPartSelector m9240b(InjectorLike injectorLike) {
        return new MusicStoryAttachmentPartSelector(SimpleMusicStoryPartDefinition.m9188a(injectorLike), AlbumSharePartDefinition.m9209a(injectorLike), MusicPreviewAttachmentGroupPartDefinition.m9093a(injectorLike), ShareAttachmentImageFormatSelector.a(injectorLike));
    }

    public final Object m9241a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f8335b, feedProps).a(this.f8336c, feedProps).a(this.f8337d, feedProps).a(this.f8334a, feedProps);
        return null;
    }

    public final boolean m9242a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        return this.f8335b.m9096a(feedProps) || SimpleMusicStoryPartDefinition.m9189a(feedProps) || AlbumSharePartDefinition.m9210a(feedProps) || 1 != 0;
    }

    @Inject
    public MusicStoryAttachmentPartSelector(SimpleMusicStoryPartDefinition simpleMusicStoryPartDefinition, AlbumSharePartDefinition albumSharePartDefinition, MusicPreviewAttachmentGroupPartDefinition musicPreviewAttachmentGroupPartDefinition, ShareAttachmentImageFormatSelector shareAttachmentImageFormatSelector) {
        this.f8336c = simpleMusicStoryPartDefinition;
        this.f8337d = albumSharePartDefinition;
        this.f8334a = shareAttachmentImageFormatSelector;
        this.f8335b = musicPreviewAttachmentGroupPartDefinition;
    }

    public static MusicStoryAttachmentPartSelector m9239a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicStoryAttachmentPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8333f) {
                MusicStoryAttachmentPartSelector musicStoryAttachmentPartSelector;
                if (a2 != null) {
                    musicStoryAttachmentPartSelector = (MusicStoryAttachmentPartSelector) a2.a(f8333f);
                } else {
                    musicStoryAttachmentPartSelector = f8332e;
                }
                if (musicStoryAttachmentPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9240b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8333f, b3);
                        } else {
                            f8332e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicStoryAttachmentPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
