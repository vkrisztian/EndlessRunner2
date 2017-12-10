package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Krisz on 2017. 12. 10..
 */

public class UserRecycleAdapter extends RecyclerView.Adapter<UserRecycleAdapter.NewsViewHolder>{
    List<User> items;

    public UserRecycleAdapter(List<User> items) {
        this.items = items;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(View.inflate(parent.getContext(),R.layout.highscoreitem,null));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        User myuser = items.get(position);
        holder.nameTextView.setText(myuser.getUserName());
        holder.scoreTextView.setText(Integer.toString(myuser.getHighscore()));
    }

    @Override
    public int getItemCount() {
        return items == null? 0:items.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nameTextView,scoreTextView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            scoreTextView = (TextView) itemView.findViewById(R.id.score);
        }
    }
}
