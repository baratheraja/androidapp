package it.neokree.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pushbots.push.utils.PBConstants;

import java.util.HashMap;

/**
 * Created by baratheraja on 3/4/15.
 */
public class customHandler extends BroadcastReceiver
{
    private static final String TAG = "it.neokree.example.customHandler";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        Log.d(TAG, "action=" + action);
        // Handle Push Message when opened
        if (action.equals(PBConstants.EVENT_MSG_OPEN)) {
            HashMap<?, ?> PushdataOpen = (HashMap<?, ?>) intent.getExtras().get(PBConstants.EVENT_MSG_OPEN);
            Log.w(TAG, "User clicked notification with Message: " + PushdataOpen.get("message"));

            // Handle Push Message when received
        }else if(action.equals(PBConstants.EVENT_MSG_RECEIVE)){
            HashMap<?, ?> PushdataOpen = (HashMap<?, ?>) intent.getExtras().get(PBConstants.EVENT_MSG_RECEIVE);
            Log.w(TAG, "User Received notification with Message: " + PushdataOpen.get("message"));
        }
    }
}