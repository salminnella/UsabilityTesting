package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends android.support.v4.app.ListFragment {
  private static final String SIGN = "sign";
  private ListView listView;
    OnSelectedSignListener selectedSignListener;

    public interface OnSelectedSignListener {
        void onSelectedSign(String sign);
    }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout, container, false);
    listView = (ListView) view.findViewById(R.id.list_view);

    return view;
  }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            selectedSignListener = (OnSelectedSignListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnSelectedSignListener");
        }
    }

    @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    String[] values = getResources().getStringArray(R.array.signs);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
        android.R.layout.simple_list_item_1, android.R.id.text1, values);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      // TODO: Write the logic that will check if the DetailsFragment is present next to the
      // TODO: ListFragment or not. If it is not (it is a handset), start DetailsActivity. If
      // TODO: it is present, get reference to DetailsFragment and call a method on it that will
      // TODO: open a webview with the information about the clicked sign.

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          String selectedSignName = listView.getAdapter().getItem(position).toString();
          selectedSignListener.onSelectedSign(selectedSignName);
      }
    });
  }
}
