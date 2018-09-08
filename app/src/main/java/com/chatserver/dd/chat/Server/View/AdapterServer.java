package com.chatserver.dd.chat.Server.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chatserver.dd.chat.R;

import java.util.List;

public class AdapterServer extends RecyclerView.Adapter<AdapterServer.ViewHolder> {

    private List<UsersServer> usersAllWords;
    private RecyclerItemClickListenerServer recyclerItemClickListener;

    public AdapterServer(List<UsersServer> usersAllWords, RecyclerItemClickListenerServer recyclerItemClickListener) {
        this.usersAllWords = usersAllWords;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_server,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.eventTime.setText(usersAllWords.get(position).getEventTime());
        holder.message.setText(usersAllWords.get(position).getMessage());
        holder.lastName.setText(usersAllWords.get(position).getLastName());

        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerItemClickListener.onItemClick(usersAllWords.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersAllWords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventTime, message, lastName;

        public ViewHolder(View itemView) {
            super(itemView);
            eventTime = (TextView) itemView.findViewById(R.id.eventTimeChat);
            message = (TextView) itemView.findViewById(R.id.message);
            lastName = (TextView) itemView.findViewById(R.id.lastName);
        }
    }
}