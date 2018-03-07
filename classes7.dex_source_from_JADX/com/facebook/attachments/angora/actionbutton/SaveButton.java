package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.analytics.CurationSurface;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.Environments;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: user_saved_mode */
public class SaveButton extends CustomFrameLayout {
    public ImageView f866a;
    public LegacySaveButtonPartDefinition f867b;

    private static <T extends View> void m861a(Class<T> cls, T t) {
        m862a((Object) t, t.getContext());
    }

    private static void m862a(Object obj, Context context) {
        ((SaveButton) obj).f867b = LegacySaveButtonPartDefinition.m840a(FbInjector.get(context));
    }

    public SaveButton(Context context) {
        this(context, null);
    }

    public SaveButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SaveButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903600);
        m861a(SaveButton.class, (View) this);
        this.f866a = (ImageView) c(2131560394);
    }

    @Inject
    private void m860a(LegacySaveButtonPartDefinition legacySaveButtonPartDefinition) {
        this.f867b = legacySaveButtonPartDefinition;
    }

    public ImageView getButton() {
        return this.f866a;
    }

    public final void m863a(@Nonnull GraphQLNode graphQLNode, @Nonnull CurationSurface curationSurface, @Nullable FeedProps<? extends FeedUnit> feedProps, @Nullable OnClickListener onClickListener) {
        SaveButtonProps saveButtonProps = new SaveButtonProps(graphQLNode, curationSurface, feedProps, onClickListener, false);
        SimpleRenderer simpleRenderer = new SimpleRenderer(this.f867b, Environments.a);
        simpleRenderer.a(saveButtonProps);
        simpleRenderer.a(this);
    }
}
