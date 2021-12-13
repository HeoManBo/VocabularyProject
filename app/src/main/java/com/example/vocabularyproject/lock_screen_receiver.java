package com.example.vocabularyproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.vocabularyproject.lock_screen_pager.lock_screen_pager01;

public class lock_screen_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Intent i = new Intent(context, lock_screen.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(i);
        }
    }
}
