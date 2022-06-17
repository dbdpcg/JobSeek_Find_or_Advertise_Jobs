package classes;

import javax.naming.NotContextException;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GuiHelper {
    public static Set<String> getSelectedOptions(JPanel optionsPanel) {
        Set<String> selectedOptions = new HashSet<>();
        Component[] allOptions = optionsPanel.getComponents();
        for (Component option : allOptions) {
            if (((JCheckBox) option).isSelected()) {
                selectedOptions.add(((JCheckBox) option).getText().toLowerCase());
            }
        }
        return selectedOptions;
    }
    public static void setSelectedOptions(JPanel optionsPanel, Collection<String> selected) {
        Component[] allOptions = optionsPanel.getComponents();
        for (Component option : allOptions) {
            if (selected.contains(((JCheckBox)option).getText().toLowerCase())) {
                ((JCheckBox) option).setSelected(true);
            }
        }
    }
    public static String  getSelectedRadio(JPanel optionsPanel) throws Exception {
        Component[] allOptions = optionsPanel.getComponents();
        for (Component option : allOptions) {
            if (((JRadioButton) option).isSelected()) {
                return ((JRadioButton) option).getText().toLowerCase();
            }
        }
        throw new Exception();
    }
    public static void createOptionBox(JPanel optionsPanel, Collection<String> options) {
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.removeAll();
        for (String option : options) {
            option = option.substring(0,1).toUpperCase() + option.substring(1).toLowerCase();
            optionsPanel.add(new JCheckBox(option));
        }
        optionsPanel.updateUI();
    }
    public static void createRadioBox(JPanel optionsPanel, Collection<String> options) {
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.removeAll();
        ButtonGroup buttonGroup = new ButtonGroup();
        for (String option : options) {
            option = option.substring(0,1).toUpperCase() + option.substring(1).toLowerCase();
            JRadioButton radioButton = new JRadioButton(option);
            buttonGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }
        optionsPanel.updateUI();
    }
    public static <V> boolean createJobList(Collection<V> jobList, JPanel jobsPanel) {
        if (jobList.isEmpty()){
            return false;
        }
        for (V job : jobList) {
            JPanel jPanel;
            if (job instanceof Job) {
                jPanel = new JobListing((Job) job).getJobListingPanel();
            } else {
                jPanel = new JobListing((ScoredJob) job).getJobListingPanel();
            }

            jobsPanel.setLayout(new BoxLayout(jobsPanel, BoxLayout.Y_AXIS));
            jobsPanel.add(jPanel);
        }
        return true;
    }
    public static boolean createJobSeekerList(HashMap<JobSeeker, Integer> jobSeekerList, Job job, JPanel jobSeekerPanel) {
        if (jobSeekerList.isEmpty()){
            return false;
        }
        jobSeekerPanel.setLayout(new BoxLayout(jobSeekerPanel, BoxLayout.Y_AXIS));
        for (JobSeeker jobSeeker : jobSeekerList.keySet()) {
            JPanel jPanel;
            jPanel = new JobSeekerItem(jobSeeker, job,  jobSeekerList.get(jobSeeker)).getPanel();
            jobSeekerPanel.add(jPanel);
        }
        return true;
    }
    public static String capitalise(String words) {
        return Stream.of(words.trim().split("\\s"))
                .filter(word -> word.length() > 0)
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
