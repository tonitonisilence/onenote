package onenote.guagnzhou.com.onenote.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import onenote.guagnzhou.com.onenote.R;
import onenote.guagnzhou.com.onenote.config.ConstantsConfig;
import onenote.guagnzhou.com.onenote.model.MenuBean;

public class RegisterFragment extends Fragment {
    @Bind(R.id.edt_accout)
    EditText edtAccout;
    @Bind(R.id.edit_pwd)
    EditText editPwd;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.ll_all)
    LinearLayout llAll;
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Bundle args = getArguments();
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        this.activity = activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
