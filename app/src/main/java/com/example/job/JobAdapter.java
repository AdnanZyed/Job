package com.example.job;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private Context context;
    private List<Job> jobList;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public JobAdapter(Context context, List<Job> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);

        holder.tvTime.setText(job.getTo_date());
        holder.tvJobTitle.setText(job.getTitle());
        holder.tvCompany.setText(job.getWork_place());
        holder.tvCode.setText(job.getWork_field_id());

        holder.tvCategory.setText(job.getCountry_of_graduation());
        holder.tvSalary.setText(String.format("%.2f", job.getGender_perfrence()));
        holder.tvYears.setText(String.valueOf(job.getCountry_of_residence()));
        holder.tvDays.setText(String.valueOf(job.getWork_experience()));
        holder.tvDescription.setText(job.getBusiness_man_id());

        if (job.getWork_experience() != null) {
            holder.tvExpire.setText(job.getWork_experience().format(String.valueOf(dateFormatter)));
        } else {
            holder.tvExpire.setText("N/A");
        }

         holder.tvViews.setText(String.valueOf(job.getGender_perfrence()));
        holder.layoutSkills.removeAllViews();
//        for (String skill : job.getSkills()) {
//            TextView skillView = new TextView(context);
//            skillView.setText(skill);
//            skillView.setBackgroundResource(R.drawable.shape2);
//            skillView.setPadding(16, 8, 16, 8);
//            skillView.setTextColor(context.getResources().getColor(R.color.primary));
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params.setMargins(8, 0, 8, 0);
//            skillView.setLayoutParams(params);
//            holder.layoutSkills.addView(skillView);
//        }
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime, tvJobTitle, tvCompany, tvCode, tvCategory ,tvViews,
                tvSalary, tvYears, tvDays, tvDescription, tvExpire;
        LinearLayout layoutSkills;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvTime);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvCode = itemView.findViewById(R.id.pure);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvYears = itemView.findViewById(R.id.Years);
            tvDays = itemView.findViewById(R.id.days);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvExpire = itemView.findViewById(R.id.tvExpire);
            layoutSkills = itemView.findViewById(R.id.layoutSkills);
            tvViews = itemView.findViewById(R.id.tvViews);

        }
    }
}
