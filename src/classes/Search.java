package classes;

import java.util.*;

public class Search {
    String searchText;
    ArrayList<String> states;
    ArrayList<String> cats;
    int salary;
    String jobType;
    String keywords;
    HashSet<Job> jobs;
    ArrayList<ScoredJob> scoredJobs = new ArrayList<>();
    public Search(HashSet<Job> jobs){
        this.jobs = jobs;
        //setScores(jobs);
    }

    /**
     * Uses the scorer object to score all jobs in the Jobs set.
     */
    public void setScores(){
        Scorer scorer = new Scorer();
        for (Job job: jobs){
            int score = scorer.scoreAgaintSearch(this, job);
            scoredJobs.add(new ScoredJob(job, score));
        }
        scoredJobs.sort(Comparator.comparing(ScoredJob::getScore).reversed());
    }
    public String getSearchText() {
        return searchText;
    }




    public int getSalary() {
        return salary;
    }

    public String getJobType() {
        return jobType;
    }

    public String getKeywords() {
        return keywords;
    }

    public HashSet<Job> getJobs() {
        return jobs;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setJobs(HashSet<Job> jobs) {
        this.jobs = jobs;
    }
    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public ArrayList<ScoredJob> getScoredJobs() {
        return scoredJobs;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void setStates(ArrayList<String> states) {
        this.states = states;
    }

    public ArrayList<String> getCats() {
        return cats;
    }

    public void setCats(ArrayList<String> cats) {
        this.cats = cats;
    }
}