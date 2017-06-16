package jiutianbian.com.testbutterknife;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends FragmentActivity {

    @BindString(R.string.hello_blank_fragment) String hello_blank_fragment;
    @BindDrawable(R.drawable.ic_launcher)
    Drawable ic_launcher;
    @BindColor(R.color.colorAccent) int red; // int or ColorStateList field
    @BindDimen(R.dimen.text_height) float text_height; // int (for pixel size) or float (for exact value) field



    @BindView(R.id.tx_hello)
    TextView tx_hello;
    @BindView(R.id.list_hello)
    ListView list_hello;

    @BindViews({ R.id.tx_hello, R.id.tx_nihao})
    List<TextView> nameViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tx_hello.setText("你好，中国");
        tx_hello.setTextColor(red);

        tx_hello.setText(hello_blank_fragment);
        tx_hello.setTextSize(text_height);


        MainAdapter adapter = new MainAdapter(this);
        list_hello.setAdapter(adapter);
        list_hello.setBackground(ic_launcher);

    }

    static final ButterKnife.Action<View> INVISIBLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setVisibility(View.INVISIBLE);
        }
    };

    static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };


    @OnClick(R.id.btn_show)
    public void click(View view) {
        ButterKnife.apply(nameViews,INVISIBLE);
    }


    @OnLongClick(R.id.btn_show)
    public boolean longclick(View view) {
        ButterKnife.apply(nameViews,VISIBLE);
        return true;
    }
}
