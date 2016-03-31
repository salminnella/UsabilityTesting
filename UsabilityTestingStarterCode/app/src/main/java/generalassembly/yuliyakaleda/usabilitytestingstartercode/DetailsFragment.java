package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DetailsFragment extends Fragment{
  WebView webView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.details_activity_layout, container, false);

    webView = (WebView) view.findViewById(R.id.web_view_details);
    webView.loadUrl("http://www.horoscopedates.com");

    //TODO: Inflate the view and change the return type;
    return view;
  }

  public void updateContent(String sign) {
    Log.i("DetailsFrag", "sign is " + sign);
    // TODO: Finish the method which will open a webview and redirect the user to the website
    // TODO: to read about the sign that was clicked in the ListView


    if (sign != null && getView() != null) {
      Log.i("detailFrag", "WEBSITE URL:  http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
      Log.i("detailFrag", "view is: " + getView());
      webView = (WebView) getView().findViewById(R.id.web_view_details);
      webView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
    }

    Log.i("detailFrag","sign and view are null");
  }
}
