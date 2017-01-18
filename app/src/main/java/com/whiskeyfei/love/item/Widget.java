package com.whiskeyfei.love.item;

import android.content.Context;

/**
 * Created by whiskeyfei on 16/11/9.
 */

public abstract class Widget {
    public abstract Object buildUI(Context context);

    public abstract Object updateUI();

    public void onEvent(int event, Object arg) {
    }
}
