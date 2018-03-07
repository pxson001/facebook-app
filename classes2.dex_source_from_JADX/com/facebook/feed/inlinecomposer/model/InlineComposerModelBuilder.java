package com.facebook.feed.inlinecomposer.model;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.productionprompts.model.InlineComposerPromptSession;

/* compiled from: negative_feedback_actions */
public class InlineComposerModelBuilder {
    private String f12891a;
    public String f12892b;
    public InlineComposerPromptSession f12893c;
    public WorkComposerModel f12894d;
    public int f12895e;
    public String f12896f = "";
    public String f12897g = "";
    public String f12898h = "";
    public String f12899i = "";
    public boolean f12900j = true;
    public boolean f12901k = true;
    private boolean f12902l = true;
    public boolean f12903m = false;
    public boolean f12904n = false;
    public GraphQLExploreFeed f12905o;

    public InlineComposerModelBuilder(String str, String str2) {
        this.f12891a = str;
        this.f12892b = str2;
    }

    public InlineComposerModelBuilder(InlineComposerModel inlineComposerModel) {
        this.f12891a = inlineComposerModel.f12906a;
        this.f12892b = inlineComposerModel.f12907b;
        this.f12893c = inlineComposerModel.f12908c;
        this.f12900j = inlineComposerModel.f12909d;
        this.f12901k = inlineComposerModel.f12910e;
        this.f12903m = inlineComposerModel.f12919n;
        this.f12904n = inlineComposerModel.f12919n;
        this.f12902l = inlineComposerModel.f12911f;
        this.f12894d = inlineComposerModel.f12913h;
        this.f12895e = inlineComposerModel.f12918m;
        this.f12896f = inlineComposerModel.f12914i;
        this.f12897g = inlineComposerModel.f12915j;
        this.f12898h = inlineComposerModel.f12916k;
        this.f12899i = inlineComposerModel.f12917l;
        this.f12905o = inlineComposerModel.f12912g;
    }

    public final InlineComposerModel m18960a() {
        return new InlineComposerModel(this.f12891a, this.f12892b, this.f12893c, this.f12900j, this.f12901k, this.f12903m, this.f12902l, this.f12894d, this.f12905o, this.f12895e, this.f12896f, this.f12897g, this.f12898h, this.f12899i, this.f12904n);
    }
}
