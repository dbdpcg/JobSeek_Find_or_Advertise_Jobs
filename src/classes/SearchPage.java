package classes;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

public class SearchPage {
    private final boolean searchClicked = false;
    private ClearingTextField searchTBox;
    private JButton searchButton;
    private JSlider salarySlider;
    private JPanel searchPanel;
    private JLabel StateLabel;
    private JLabel jobTypeLabel;
    private JLabel lowSalLabel;
    private JLabel midSalLabel;
    private JLabel highSalLabel;
    private JTextArea textArea1;
    private JPanel statePanel;
    private JScrollPane stateScroller;
    private JLabel catLabel;
    private JScrollPane catScroller;
    private JPanel catPanel;
    private JScrollPane jobTypeScroller;
    private JPanel jobTypePanel;

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public SearchPage(HashSet<Job> jobs) {
        /**test code to check categories' functionality
         should be removed when adding categories by recruiters is implemented
         */
        GuiHelper.createOptionBox(statePanel, Config.STATES);
        GuiHelper.createOptionBox(catPanel, Runtime.accountManager().getCategories().keySet());
        GuiHelper.createOptionBox(jobTypePanel, Config.JOB_TYPES);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Creates a new search object and adds the user's selected criteria to it
                Collection<Job> appliedJobs = Runtime.accountManager().getJobApplications().
                        get(Runtime.accountManager().getCurrentUser().getEmail());
                Collection<Job> availableJobs = Runtime.accountManager().getJobs().values();
                // To only show jobs that have not been applied for
                //availableJobs.removeAll(appliedJobs);
                Search search = new Search(availableJobs);
                search.setSearchText(searchTBox.getText());
                search.setStates(GuiHelper.getSelectedOptions(statePanel));
                search.setCats(GuiHelper.getSelectedOptions(catPanel));
                search.setJobTypes(GuiHelper.getSelectedOptions(jobTypePanel));
                search.setSalary(salarySlider.getValue() * 3000);
                search.setScores();
                ArrayList<ScoredJob> jobList = search.getScoredJobs();
                Runtime.showSearchResultsPage(Runtime.frame, jobList);
            }
        });
    }

    public boolean isSearchClicked() {
        return searchClicked;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        searchPanel = new JPanel();
        searchPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(19, 7, new Insets(20, 20, 20, 20), -1, -1));
        searchPanel.setBackground(new Color(-13224648));
        searchPanel.setForeground(new Color(-1973791));
        searchTBox = new ClearingTextField();
        searchTBox.setEditable(true);
        searchTBox.setEnabled(true);
        searchTBox.setText("I'm looking for...");
        searchPanel.add(searchTBox, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(250, -1), new Dimension(150, -1), new Dimension(-1, 150), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        searchPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(5, 5, 14, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setText("Search");
        searchPanel.add(searchButton, new com.intellij.uiDesigner.core.GridConstraints(3, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(200, 150), 0, false));
        textArea1 = new JTextArea();
        textArea1.setBackground(new Color(-11348236));
        searchPanel.add(textArea1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, 1, 1, null, new Dimension(1000, 15), new Dimension(-1, 1), 0, false));
        StateLabel = new JLabel();
        Font StateLabelFont = this.$$$getFont$$$("Calibri Light", Font.BOLD, 16, StateLabel.getFont());
        if (StateLabelFont != null) StateLabel.setFont(StateLabelFont);
        StateLabel.setForeground(new Color(-592138));
        StateLabel.setText("State");
        searchPanel.add(StateLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        catLabel = new JLabel();
        Font catLabelFont = this.$$$getFont$$$("Calibri Light", Font.BOLD, 16, catLabel.getFont());
        if (catLabelFont != null) catLabel.setFont(catLabelFont);
        catLabel.setForeground(new Color(-592138));
        catLabel.setText("Categories");
        searchPanel.add(catLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stateScroller = new JScrollPane();
        searchPanel.add(stateScroller, new com.intellij.uiDesigner.core.GridConstraints(7, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(100, 100), new Dimension(300, 300), new Dimension(450, -1), 0, false));
        statePanel = new JPanel();
        statePanel.setLayout(new GridBagLayout());
        stateScroller.setViewportView(statePanel);
        catScroller = new JScrollPane();
        searchPanel.add(catScroller, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        catPanel = new JPanel();
        catPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        catScroller.setViewportView(catPanel);
        jobTypeScroller = new JScrollPane();
        searchPanel.add(jobTypeScroller, new com.intellij.uiDesigner.core.GridConstraints(14, 6, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(100, 100), new Dimension(300, 100), new Dimension(450, 200), 0, false));
        jobTypePanel = new JPanel();
        jobTypePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1, true, false));
        jobTypeScroller.setViewportView(jobTypePanel);
        jobTypeLabel = new JLabel();
        Font jobTypeLabelFont = this.$$$getFont$$$("Calibri Light", Font.BOLD, 16, jobTypeLabel.getFont());
        if (jobTypeLabelFont != null) jobTypeLabel.setFont(jobTypeLabelFont);
        jobTypeLabel.setForeground(new Color(-592138));
        jobTypeLabel.setText("Job Type");
        searchPanel.add(jobTypeLabel, new com.intellij.uiDesigner.core.GridConstraints(13, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        searchPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Calibri Light", Font.BOLD, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-592138));
        label1.setText("Minimum Salary");
        searchPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lowSalLabel = new JLabel();
        Font lowSalLabelFont = this.$$$getFont$$$("Calibri Light", -1, 16, lowSalLabel.getFont());
        if (lowSalLabelFont != null) lowSalLabel.setFont(lowSalLabelFont);
        lowSalLabel.setForeground(new Color(-592138));
        lowSalLabel.setText("$30K");
        searchPanel.add(lowSalLabel, new com.intellij.uiDesigner.core.GridConstraints(14, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, -1), null, null, 0, false));
        salarySlider = new JSlider();
        salarySlider.setBackground(new Color(-13224648));
        salarySlider.setForeground(new Color(-1973791));
        salarySlider.setValue(10);
        searchPanel.add(salarySlider, new com.intellij.uiDesigner.core.GridConstraints(15, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        highSalLabel = new JLabel();
        Font highSalLabelFont = this.$$$getFont$$$("Calibri Light", -1, 16, highSalLabel.getFont());
        if (highSalLabelFont != null) highSalLabel.setFont(highSalLabelFont);
        highSalLabel.setForeground(new Color(-592138));
        highSalLabel.setText("$270K");
        searchPanel.add(highSalLabel, new com.intellij.uiDesigner.core.GridConstraints(14, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, -1), null, null, 0, false));
        midSalLabel = new JLabel();
        Font midSalLabelFont = this.$$$getFont$$$("Calibri Light", -1, 16, midSalLabel.getFont());
        if (midSalLabelFont != null) midSalLabel.setFont(midSalLabelFont);
        midSalLabel.setForeground(new Color(-592138));
        midSalLabel.setText("$150K");
        searchPanel.add(midSalLabel, new com.intellij.uiDesigner.core.GridConstraints(14, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, -1), null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Calibri Light", -1, 22, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-592138));
        label2.setText("Search");
        searchPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        searchPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(4, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 15), new Dimension(-1, 15), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        searchPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(9, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 15), new Dimension(-1, 15), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return searchPanel;
    }

}
