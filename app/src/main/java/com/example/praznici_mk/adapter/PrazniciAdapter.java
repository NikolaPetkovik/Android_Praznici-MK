package com.example.praznici_mk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.praznici_mk.R;
import com.example.praznici_mk.model.PrazniciModel;
import java.util.List;


public class PrazniciAdapter extends RecyclerView.Adapter<PrazniciAdapter.PrazniciViewHolder>  {

    private List<PrazniciModel> prazniciModelList;
        // Constructor
        public PrazniciAdapter(List<PrazniciModel> prazniciModelList) {
        this.prazniciModelList = prazniciModelList;
    }

    private boolean cardDetails = true;


    @NonNull
    @Override
    public PrazniciViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_praznici, parent, false);
        return new PrazniciViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PrazniciViewHolder holder, int position) {
        holder.dd       .setText(prazniciModelList.get(position).getDate ());
        holder.mm       .setText(prazniciModelList.get(position).getMonthNumber());
        holder.yyyy     .setText(prazniciModelList.get(position).getYear ());
        holder.praznik  .setText(prazniciModelList.get(position).getName ());
        holder.month    .setText(prazniciModelList.get(position).getMonth());
        holder.day      .setText(prazniciModelList.get(position).getDay  ());
        holder.type     .setText(prazniciModelList.get(position).getType ());

        holder.mainConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cardDetails == true){
                    holder.cardVisible.setVisibility(View.VISIBLE);
                    cardDetails = false;
                }else {
                    holder.cardVisible.setVisibility(View.GONE);
                    cardDetails = true;
                }
            }
        });

     }

    @Override
    public int getItemCount() {
        return prazniciModelList.size();
    }


    // RecyclerView -- ViewHolder (item_praznici Components)
    public class PrazniciViewHolder extends RecyclerView.ViewHolder{

        // Components -- item_praznici
        ConstraintLayout  mainConstraint;
        CardView          cardVisible;
        private TextView  dd, mm, yyyy, praznik,
                          month,  day,    type;

        // InitComponents
        public PrazniciViewHolder(@NonNull View itemView) {
            super(itemView);
            praznik = itemView.findViewById(R.id.textViewPraznik);
            dd      = itemView.findViewById(R.id.textViewDD);
            mm      = itemView.findViewById(R.id.textViewMM);
            yyyy    = itemView.findViewById(R.id.textViewYYYY);
            month   = itemView.findViewById(R.id.textViewMonth);
            day     = itemView.findViewById(R.id.textViewDay);
            type    = itemView.findViewById(R.id.textViewType);

            cardVisible     = itemView.findViewById(R.id.cardVisible);
            mainConstraint  = itemView.findViewById(R.id.constraintMain);

        }
    }

}
