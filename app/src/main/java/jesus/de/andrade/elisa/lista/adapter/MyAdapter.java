package jesus.de.andrade.elisa.lista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jesus.de.andrade.elisa.lista.R;
import jesus.de.andrade.elisa.lista.activity.MainActivity;
import jesus.de.andrade.elisa.lista.model.MyItem;

public class MyAdapter extends RecyclerView.Adapter{
    MainActivity mainActivity;
    List<MyItem> itens;

    public MyAdapter(MainActivity mainActivity, List<MyItem> itens){
        this.mainActivity = mainActivity;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){

        MyItem MyItem = itens.get(position);
        View v = holder.itemView;

        ImageView imvphoto = v.findViewById(R.id.imvPhoto);
        imvphoto.setImageBitmap(MyItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText(MyItem.title);

        TextView tcDesc = v.findViewById(R.id.tcDesc);
        tcDesc.setText(MyItem.description);




    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
