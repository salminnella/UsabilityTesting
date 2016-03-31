package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.OnSelectedSignListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: Create a separate layout xml file for tablet devices.
  }

  @Override
  public void onSelectedSign(String sign) {
    Log.i("MainAct", "sign is " + sign);

    FragmentManager fragmentManager = getSupportFragmentManager();
    DetailsFragment detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.details_frag);

    detailsFragment.updateContent(sign);
  }
}
