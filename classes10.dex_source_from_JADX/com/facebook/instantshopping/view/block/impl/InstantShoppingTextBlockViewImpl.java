package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLInstantShoppingActionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.presenter.InstantShoppingTextBlockPresenter;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.instantshopping.view.block.InstantShoppingTextBlockView;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: STARTING */
public class InstantShoppingTextBlockViewImpl extends AbstractBlockView<InstantShoppingTextBlockPresenter> implements InstantShoppingTextBlockView {
    @Inject
    public InstantShoppingAnalyticsLogger f23785a;
    @Inject
    public AttachmentLinkLauncher f23786b;
    @Inject
    public InstantShoppingTextUtils f23787c;
    @Inject
    public InstantShoppingLoggingUtils f23788d;
    public final RichTextView f23789e;

    public static void m25074a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        InstantShoppingTextBlockViewImpl instantShoppingTextBlockViewImpl = (InstantShoppingTextBlockViewImpl) obj;
        InstantShoppingAnalyticsLogger a = InstantShoppingAnalyticsLogger.m24853a(injectorLike);
        AttachmentLinkLauncher a2 = AttachmentLinkLauncher.a(injectorLike);
        InstantShoppingTextUtils b = InstantShoppingTextUtils.b(injectorLike);
        InstantShoppingLoggingUtils a3 = InstantShoppingLoggingUtils.m24879a(injectorLike);
        instantShoppingTextBlockViewImpl.f23785a = a;
        instantShoppingTextBlockViewImpl.f23786b = a2;
        instantShoppingTextBlockViewImpl.f23787c = b;
        instantShoppingTextBlockViewImpl.f23788d = a3;
    }

    public InstantShoppingTextBlockViewImpl(View view) {
        super(view);
        this.f23789e = (RichTextView) view.findViewById(2131563266);
        Class cls = InstantShoppingTextBlockViewImpl.class;
        m25074a((Object) this, getContext());
    }

    public final void m25075a(Bundle bundle) {
        super.a(bundle);
        this.f23789e.d.a();
    }

    public final void m25076a(final LoggingParams loggingParams, final EntityModel entityModel) {
        this.f23789e.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InstantShoppingTextBlockViewImpl f23784c;

            /* compiled from: STARTING */
            class C34121 extends HashMap<String, Object> {
                C34121() {
                    put("action_type", GraphQLInstantShoppingActionType.OPEN_URL);
                    put("action_url", entityModel.B());
                }
            }

            /* compiled from: STARTING */
            class C34132 extends HashMap<String, Object> {
                C34132() {
                    put("action_type", "No-Op");
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -798379460);
                if (entityModel != null) {
                    this.f23784c.f23785a.m24857a(loggingParams, new C34121());
                    this.f23784c.f23788d.m24884b("richtext_link_click", loggingParams.toString() + entityModel.B());
                    this.f23784c.f23786b.a(this.f23784c.getContext(), entityModel.B(), null, null);
                } else {
                    this.f23784c.f23785a.m24857a(loggingParams, new C34132());
                }
                LogUtils.a(-1020485356, a);
            }
        });
    }
}
