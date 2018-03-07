package com.facebook.negativefeedback.video.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryModels.RapidReportingTagsQueryModel.NegativeFeedbackPromptModel.TagsModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FlowLayout;
import java.util.List;

/* compiled from: terminate_other_sessions */
public class ReportLiveVideoFeedbackView extends CustomLinearLayout {
    public int f1650a;
    public EditText f1651b;
    public TextView f1652c;
    public RapidReportingController f1653d;
    public final OnClickListener f1654e = new C01751(this);
    public final ClickableSpan f1655f = new C01762(this);

    /* compiled from: terminate_other_sessions */
    class C01751 implements OnClickListener {
        final /* synthetic */ ReportLiveVideoFeedbackView f1645a;

        C01751(ReportLiveVideoFeedbackView reportLiveVideoFeedbackView) {
            this.f1645a = reportLiveVideoFeedbackView;
        }

        public void onClick(View view) {
            boolean z = true;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1697145132);
            TagsModel tagsModel = (TagsModel) view.getTag();
            String j = tagsModel.m1848j();
            boolean z2 = !view.isSelected();
            if (this.f1645a.f1653d != null) {
                RapidReportingController rapidReportingController = this.f1645a.f1653d;
                if (z2) {
                    rapidReportingController.p.add(j);
                    rapidReportingController.g.a(rapidReportingController.n, j);
                } else {
                    rapidReportingController.p.remove(j);
                    rapidReportingController.g.b(rapidReportingController.n, j);
                }
            }
            view.setSelected(z2);
            if (tagsModel.m1844a() >= 200) {
                int i;
                ReportLiveVideoFeedbackView reportLiveVideoFeedbackView = this.f1645a;
                if (z2) {
                    i = 1;
                } else {
                    i = -1;
                }
                reportLiveVideoFeedbackView.f1650a += i;
                TextView textView = this.f1645a.f1652c;
                if (this.f1645a.f1650a <= 0) {
                    z = false;
                }
                textView.setSelected(z);
            }
            if (z2 && "other".equalsIgnoreCase(tagsModel.m1848j())) {
                this.f1645a.f1651b.requestFocus();
                KeyboardUtils.b(this.f1645a.getContext(), this.f1645a.f1651b);
            }
            LogUtils.a(511679095, a);
        }
    }

    /* compiled from: terminate_other_sessions */
    class C01762 extends ClickableSpan {
        final /* synthetic */ ReportLiveVideoFeedbackView f1646a;

        C01762(ReportLiveVideoFeedbackView reportLiveVideoFeedbackView) {
            this.f1646a = reportLiveVideoFeedbackView;
        }

        public void onClick(View view) {
            if (this.f1646a.f1653d != null) {
                RapidReportingController rapidReportingController = this.f1646a.f1653d;
                Context context = this.f1646a.getContext();
                rapidReportingController.g.c(rapidReportingController.n);
                Intent intent = new Intent();
                intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/462017383994422"))));
                rapidReportingController.d.a(intent, context);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f1646a.getResources().getColor(2131362082));
        }
    }

    public ReportLiveVideoFeedbackView(Context context) {
        super(context);
        setOrientation(1);
        setContentView(2130906824);
        final TextView textView = (TextView) a(2131566949);
        this.f1651b = (EditText) a(2131566948);
        final int integer = getResources().getInteger(2131492943);
        EditText editText = this.f1651b;
        textView.setText(editText.getText().length() + "/" + integer);
        editText.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ReportLiveVideoFeedbackView f1649c;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (this.f1649c.f1653d != null) {
                    this.f1649c.f1653d.o = editable.toString();
                }
                textView.setText(editable.length() + "/" + integer);
            }
        });
        textView = (TextView) a(2131566946);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(new StyledStringBuilder(getResources()).a(2131238418).a("%1$s", getResources().getString(2131238419), this.f1655f, 33).b());
        this.f1652c = (TextView) a(2131566950);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1918928998);
        super.onDetachedFromWindow();
        KeyboardUtils.a(getContext(), this.f1651b);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1878017574, a);
    }

    public void setTags(List<TagsModel> list) {
        a(2131559418).setVisibility(8);
        FlowLayout flowLayout = (FlowLayout) a(2131566947);
        flowLayout.removeAllViews();
        if (list == null || list.isEmpty()) {
            flowLayout.setVisibility(8);
            return;
        }
        flowLayout.setVisibility(0);
        for (TagsModel tagsModel : list) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(2130906825, flowLayout, false);
            textView.setText(tagsModel.m1849k().m1843a());
            textView.setTag(tagsModel);
            textView.setOnClickListener(this.f1654e);
            flowLayout.addView(textView);
        }
    }
}
