package com.example.googlemaps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<AddressData> addressData;

    public RecyclerViewAdapter(Context context, ArrayList<AddressData> addressData) {
        this.context = context;
        this.addressData = addressData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        AddressData r = addressData.get(position);
        int index = holder.getAdapterPosition();
        Log.e("AAA", "onBindViewHolder: " + r.getLatitude());
        String strLat = String.valueOf(r.getLatitude());
        String strLog = String.valueOf(r.getLongitude());
        Log.e("AAA", "lat and log is : " + strLat + " " + strLog);
        holder.txtLat.setText(strLat);
        holder.txtLog.setText(strLog);
        holder.txtComAdd.setText(r.getFullAdd());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("JJJ", "cardView: " + r.getLatitude() + "    " + r.getLongitude());
                String uri = "http://maps.google.com/maps?q=loc:" + r.getLatitude() + "," + r.getLongitude();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return addressData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtLat, txtLog, txtComAdd;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLat = itemView.findViewById(R.id.txtLatitude);
            txtLog = itemView.findViewById(R.id.txtLongitude);
            txtComAdd = itemView.findViewById(R.id.txtComAdd);
            cardView = itemView.findViewById(R.id.crdCardView2);

        }

    }


}
