package pl.pragmatists;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

public class WorkEntry {
    private LocalDate date;
    private Project project;
    private Person person;

    public WorkEntry(LocalDate date, Project project, Person person) {
        this.date = date;
        this.project = project;
        this.person = person;
    }

    public LocalDate getDate() {
        return date;
    }

    public Project getProject() {
        return project;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
