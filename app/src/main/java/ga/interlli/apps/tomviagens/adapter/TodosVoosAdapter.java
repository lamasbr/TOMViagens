package ga.interlli.apps.tomviagens.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ga.interlli.apps.tomviagens.R;
import ga.interlli.apps.tomviagens.models.Voo;

public class TodosVoosAdapter extends BaseAdapter {

    private LayoutInflater layout;
    private List<Voo> voos;
    private ArrayList<Voo> arrayList;
    private Context context;

    @BindView(R.id.tvVooOrigem) TextView tvVooOrigem;
    @BindView(R.id.tvVooDestino) TextView tvVooDestino;
    @BindView(R.id.tvVooPreco) TextView tvVooPreco;

    public TodosVoosAdapter (Context context, List<Voo> voos){
        this.context = context;
        this.voos = voos;
        layout = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Voo>();
        this.arrayList.addAll(voos);
    }

    @Override
    public int getCount() {
        return voos.size();
    }

    @Override
    public Object getItem(int position) {
        return voos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Voo voo = (Voo) getItem(position);
        final int vooId = voo.getId();

        if(convertView != null){
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = layout.inflate(R.layout.listview_todosvoos_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.tvVooOrigem.setText(voo.getOrigem().getCidade().toString());
        holder.tvVooDestino.setText(voo.getDestino().getCidade().toString());
        holder.tvVooPreco.setText(String.valueOf(voo.getValorPassagem()));

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvVooOrigem) TextView tvVooOrigem;
        @BindView(R.id.tvVooDestino) TextView tvVooDestino;
        @BindView(R.id.tvVooPreco) TextView tvVooPreco;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
