package com.facebook.composer.minutiae.view;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.composer.minutiae.MinutiaeTaggableObjectFragment;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.SubtextModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel.NodeModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: total_likes */
public class MinutiaeTaggableObjectViewController {
    public boolean f1889a = false;

    /* compiled from: total_likes */
    public interface SuggestionCallback {
        void mo71a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel);
    }

    public final void m1845a(MinutiaeBaseRowView minutiaeBaseRowView, final MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel, @Nullable final SuggestionCallback suggestionCallback) {
        m1843a(minutiaeBaseRowView, m1842a(minutiaeTaggableSuggestionsModel), minutiaeTaggableSuggestionsModel.c().b(), false);
        minutiaeBaseRowView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MinutiaeTaggableObjectViewController f1885c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -677932905);
                if (suggestionCallback != null) {
                    suggestionCallback.mo71a(minutiaeTaggableSuggestionsModel);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1005436620, a);
            }
        });
    }

    public final void m1844a(MinutiaeBaseRowView minutiaeBaseRowView, final TaggableObjectEdgeModel taggableObjectEdgeModel, MinutiaeTaggableActivity minutiaeTaggableActivity, boolean z, @Nullable final MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
        m1843a(minutiaeBaseRowView, taggableObjectEdgeModel, minutiaeTaggableActivity, z);
        minutiaeBaseRowView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MinutiaeTaggableObjectViewController f1888c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1544810260);
                if (minutiaeTaggableObjectFragment != null) {
                    minutiaeTaggableObjectFragment.m1510a(taggableObjectEdgeModel);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1047924542, a);
            }
        });
    }

    private void m1843a(MinutiaeBaseRowView minutiaeBaseRowView, TaggableObjectEdgeModel taggableObjectEdgeModel, MinutiaeTaggableActivity minutiaeTaggableActivity, boolean z) {
        Uri uri;
        Uri uri2;
        Uri parse;
        String str;
        Uri uri3 = null;
        minutiaeBaseRowView.m1839a();
        if (z) {
            minutiaeBaseRowView.setBackgroundResource(2130838241);
        } else {
            minutiaeBaseRowView.setBackgroundResource(2130838244);
        }
        String c = taggableObjectEdgeModel.c();
        if (z && taggableObjectEdgeModel.af_() != null && taggableObjectEdgeModel.af_().k() != null) {
            uri = null;
            uri2 = null;
            parse = Uri.parse(taggableObjectEdgeModel.af_().k().b());
            str = null;
        } else if (!minutiaeTaggableActivity.k() || taggableObjectEdgeModel.d() == null) {
            if (taggableObjectEdgeModel.g() != null) {
                str = taggableObjectEdgeModel.g().a();
            } else {
                str = null;
            }
            if (taggableObjectEdgeModel.af_() == null || taggableObjectEdgeModel.af_().k() == null) {
                uri = null;
            } else {
                uri = Uri.parse(taggableObjectEdgeModel.af_().k().b());
            }
            if (taggableObjectEdgeModel.d() != null) {
                parse = null;
                Uri uri4 = uri;
                uri = Uri.parse(taggableObjectEdgeModel.d().b());
                uri2 = uri4;
            } else {
                uri2 = uri;
                parse = null;
                uri = null;
            }
        } else {
            uri = null;
            uri2 = null;
            parse = Uri.parse(taggableObjectEdgeModel.d().b());
            str = null;
        }
        MinutiaeBaseRowView.m1835a(minutiaeBaseRowView.f1861h, c);
        MinutiaeBaseRowView minutiaeBaseRowView2 = minutiaeBaseRowView;
        Preconditions.checkArgument(minutiaeBaseRowView2.f1862i.isPresent());
        MinutiaeBaseRowView.m1835a((TextView) minutiaeBaseRowView2.f1862i.get(), str);
        MinutiaeBaseRowView b = minutiaeBaseRowView2.m1837a(uri2).m1840b(parse);
        if (!this.f1889a || uri2 == null) {
            uri3 = uri;
        }
        b.m1841c(uri3).m1838a(taggableObjectEdgeModel.af_().c());
    }

    private static TaggableObjectEdgeModel m1842a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        SubtextModel subtextModel;
        NodeModel c = minutiaeTaggableSuggestionsModel.c();
        DefaultImageFieldsModel a = DefaultImageFieldsModel.a(c.c().a());
        MinutiaeTaggableObjectFieldsModel a2 = c.a();
        Builder builder = new Builder();
        builder.f = a;
        Builder builder2 = builder;
        builder2.g = a2;
        Builder builder3 = builder2;
        builder3.d = minutiaeTaggableSuggestionsModel.b();
        builder2 = builder3;
        if (minutiaeTaggableSuggestionsModel.d() != null) {
            SubtextModel.Builder builder4 = new SubtextModel.Builder();
            builder4.a = minutiaeTaggableSuggestionsModel.d().a();
            builder4 = builder4;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder4.a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            subtextModel = new SubtextModel(new MutableFlatBuffer(wrap, null, null, true, null));
        } else {
            subtextModel = null;
        }
        builder2.i = subtextModel;
        builder3 = builder2;
        builder3.h = true;
        builder3 = builder3;
        builder3.c = minutiaeTaggableSuggestionsModel.a();
        return builder3.a();
    }
}
