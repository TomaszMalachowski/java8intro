package pl.pragmatists;

import java.util.ArrayList;
import java.util.List;

public class WorkEntryFilter {
    private List<WorkEntry> workEntries;

    public WorkEntryFilter(List<WorkEntry> workEntries) {
        this.workEntries = workEntries;
    }

    public List<WorkEntry> filterByProject(Project project) {
        List<WorkEntry> filtered = new ArrayList<>();

        for (WorkEntry workEntry : workEntries) {
            if(workEntry.getProject() == project) {
                filtered.add(workEntry);
            }
        }
        return filtered;
    }
}
