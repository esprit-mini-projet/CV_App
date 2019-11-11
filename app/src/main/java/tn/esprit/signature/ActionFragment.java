package tn.esprit.signature;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import tn.esprit.signature.databinding.FragmentActionBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActionFragment extends Fragment {

    private Bitmap mBitmap;
    private FragmentActionBinding mDataBinding;


    public ActionFragment() {
        // Required empty public constructor
    }

    public static ActionFragment create(Bitmap bitmap) {
        ActionFragment actionFragment = new ActionFragment();
        actionFragment.mBitmap = bitmap;

        return actionFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_action, container, false);

        mDataBinding.ivBg.setImageBitmap(mBitmap);
        mDataBinding.multipleActions.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                mDataBinding.bgBottomFade.animate().alpha(1.0f).setDuration(200);
            }

            @Override
            public void onMenuCollapsed() {
                mDataBinding.bgBottomFade.animate().alpha(0.0f).setDuration(200);
            }
        });

        return mDataBinding.getRoot();
    }

}
