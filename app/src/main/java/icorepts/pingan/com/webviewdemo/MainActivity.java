package icorepts.pingan.com.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    private WebView webView;
    private String url="http://www.taobao.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
       // 触摸焦点起作用
        webView.requestFocus();
        webView.loadUrl(url);
        webView.setWebViewClient(new MyWebViewClient());
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK){
            webView.goBack();   //goBack()表示返回webView的上一页
            return true;
        }
        return false;
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}
