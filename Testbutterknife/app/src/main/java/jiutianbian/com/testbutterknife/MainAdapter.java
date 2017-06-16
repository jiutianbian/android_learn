package jiutianbian.com.testbutterknife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qianchanghao on 2017/6/15.
 */

public class MainAdapter extends BaseAdapter {
    private LayoutInflater inflater;

    public MainAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.adapter_main, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.tx_hello3.setText("hello~~~~~");

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tx_hello3)
        TextView tx_hello3;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);

        }
    }
}