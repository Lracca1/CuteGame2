package game.lgracca.com.cutegame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import game.lgracca.com.cutegame.R;

/**
 * ProfileFragment class extends Fragment and contains an override onCreate method.
 */
public class ProfileFragment extends Fragment {

  View myView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    myView = inflater.inflate(R.layout.profile_layout, container, false);
    return myView;
  }
}
