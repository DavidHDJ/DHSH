package tk.dhsh;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;

public class DHSHWebViewClient extends WebViewClient {
    Context context;
    public DHSHWebViewClient(Context t){
        context = t;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if((String.valueOf(request.getUrl())).contains("dhsh.tk")) {
            view.loadUrl(String.valueOf(request.getUrl()));
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
            view.getContext().startActivity(intent);
        }
        return true;
    }
    public void onReceivedSslError(Banner view, SslErrorHandler handler, SslError error) {
        view.loadUrl("http://dhsh.tk/ad.php?art=2&app-id=" + BuildConfig.APPLICATION_ID.toString());
        Log.e("DHSH-Banner", "SSL: " + error.toString());
    }

    public void onReceivedError(Banner view, WebResourceRequest request, WebResourceError error){
        view.getLayoutParams().height = 0;
        view.getLayoutParams().width = 0;
    }
}

