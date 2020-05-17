package tk.dhsh;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Banner extends WebView {


    public Banner(Context context) {
        super(context);
        createbanner(context);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        createbanner(context);
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createbanner(context);
    }

    public void createbanner(Context context){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        //this.getLayoutParams().height = 50;
        //this.getLayoutParams().width = 320;
        //this.requestLayout();
        this.setWebViewClient(new DHSHWebViewClient(context));
        this.getSettings().setDisplayZoomControls(false);
        this.getSettings().setBuiltInZoomControls(false);
        this.getSettings().setSupportZoom(false);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.getSettings().setJavaScriptEnabled(true);
        this.loadUrl("https://dhsh.tk/ad.php?art=2");
        this.setPadding(0, 0, 0, 0);
        this.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
    }
}
