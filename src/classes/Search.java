package classes;

import java.util.*;

public class Search {
    String searchText;
    Set<String> states;
    Set<String> cats;
    Set<String> jobTypes;
    int salary;

    /**
     * Uses the scorer object to score all jobs in the Jobs set.
     */
    public Search(){
        searchText = "";
        states= new HashSet<>();
        cats = new HashSet<>();
        jobTypes = new HashSet<>();
        salary = 0;
    }
    public String getSearchText() {
        return searchText;
    }
    public int getSalary() {
        return salary;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Set<String> getStates() {
        return states;
    }

    public void setStates(Set<String> states) {
        this.states = states;
    }

    public Set<String> getCats() {
        return cats;
    }

    public void setCats(Set<String> cats) {
        this.cats = cats;
    }

    public Set<String> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(Set<String> jobTypes) {
        this.jobTypes = jobTypes;
    }
}
