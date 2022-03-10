package com.chat.fetchdatafromapi_volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingelton {
  

        private RequestQueue requestQueue;
        private static VolleySingelton mInstance;

        private VolleySingelton(Context context){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        public static synchronized VolleySingelton getmInstance(Context context){

            if (mInstance == null){
                mInstance = new VolleySingelton(context);
            }
            return mInstance;
        }

        public RequestQueue getRequestQueue(){return requestQueue;}
    }





